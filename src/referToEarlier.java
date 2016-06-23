//import java.io.File;
import java.io.FileReader;
//import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.io.BufferedReader;
//import java.io.BufferedWriter;
import java.util.ArrayList;
import java.util.Random;

public class referToEarlier {

	ArrayList<String> references = new ArrayList<String>();
	static Random rand = new Random();
	public referToEarlier() {

	}

	public void setReference(String name) {
		try {
			FileReader fr = new FileReader(name+".txt");

			BufferedReader br = new BufferedReader(fr);
			
			Scanner read = new Scanner(br);
			while(read.hasNext()){
			references.add(read.next());
			br.close();
			read.close();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		  }
	}
	public String getReference(){
		int reference=rand.nextInt(references.size());
		return "Before talked about"+references.get(reference);
	}

}
