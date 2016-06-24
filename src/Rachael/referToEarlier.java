package Rachael;

//import java.io.File;
import java.io.FileReader;
//import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.text.html.HTMLDocument.Iterator;

import java.awt.List;
import java.io.BufferedReader;
//import java.io.BufferedWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
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
			
			}
			read.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		  }
	}
	public  String getReference(){
		int reference=rand.nextInt(references.size());
		return "Before you talked about "+references.get(reference)+ ". Tell me more about that.";
	}
	
	public String Frequency()
	{
		System.out.println("Start Frequency");
		HashMap<String, Integer> frequency=new HashMap<String, Integer>();
		for(int i=0;i<references.size();i++)
		{
			String[] arr=references.get(i).split(" ");
			
			for(int k=0;k<arr.length;k++)
			{
				if(frequency.containsKey(arr[k]))
				{
					frequency.put(arr[k], frequency.get(arr[k])+1);
					
				}
				else
				{
					frequency.put(arr[k], 1);
				}
				
			}		
		}
		
		String[] topten=new String[10];
		int[] toptenInt=new int[10];
		int lowestval=0;
		int lowestIndex=0;
		java.util.Iterator<String> it=frequency.keySet().iterator();
		while(it.hasNext())
		{	
			String next=it.next();
			
			if(frequency.get(next)>lowestval)
			{
				topten[lowestIndex]=next;
				toptenInt[lowestIndex]=frequency.get(next);
				lowestval=frequency.get(next);
				
			}
			for(int i=0;i<10;i++)
			{
				if(toptenInt[i]<lowestval)
				{
					lowestIndex=i;
					lowestval=toptenInt[lowestIndex];
				}
			}
			
		}
		
		int mood=0;
		Sentiment st=new Sentiment();
		String content="";
		for (int i=0;i<10;i++)
		{
			content+=topten[i]+" "+toptenInt[i]+"\n";		
			if(st.getHappy().contains(topten[i]))
			{
				mood++;
			}
			else if(st.getSad().contains(topten[i]))
			{
				mood--;
			}
			
		}
		content+="Happy Score is "+mood;
		return content;
		
	}
	
}
