package Rachael;

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
	public saveDiary(){
		
	}

	public static void save(String name) {
		try {
			 
			 FileReader fr = new FileReader(name+".txt");
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
		    //readDiary.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
		
	}

	public void addTodiary(String s, String name) throws IOException {
		// TODO Auto-generated method stub
		diary.add(s);
		FileWriter fwr = new FileWriter(name+".txt",true );
		BufferedWriter bwr = new BufferedWriter(fwr);
		bwr.write(s);
		 bwr.newLine();
		 bwr.flush();
	}
	 public static void NewDiary(String session){
		 final File tempDiary = new File(session+".txt");
		 try {
			tempDiary.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }
}