import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.BufferedWriter;

public class saveDiary {
	private static final Boolean APPEND = true;
	static ArrayList<String> diary=new ArrayList<String>();
	
	public saveDiary(ArrayList<String> diary) {
		saveDiary.diary=diary;
	}

	public static void save(String name) {
		try {
			 
			 FileReader fr = new FileReader(diary+".txt");
			 BufferedReader br = new BufferedReader(fr);

			FileWriter fwr = new FileWriter(name + ".txt", APPEND);
			BufferedWriter bwr = new BufferedWriter(fwr);
			Scanner readDiary = new Scanner(br);
			
			while(readDiary.hasNext()){
			
				bwr.write(readDiary.next());	
			
			}
			br.close();
			bwr.flush();
		    bwr.close();
		    readDiary.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
		
	}
//
//	private static void addTodiary(String s) {
//		// TODO Auto-generated method stub
//		diary.add(s);
//	}
//	 public static void NewDiary(String session){
//		 final File tempDiary = new File(session+".txt");
//		 try {
//			tempDiary.createNewFile();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	 }
}