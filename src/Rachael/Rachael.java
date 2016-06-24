package Rachael;

import java.io.IOException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;




public class Rachael {
	
	public static void main(String[] args) {
		ArrayList<String> qualifiers = Init.Qualifier();
		ArrayList<String> questions = Init.Questions();
		ArrayList<String> hedges = Init.Hedges();
		HashMap<String,String> replacements = Init.switchInit();
		
		Sentiment mood=new Sentiment();
		try{
		mood.SentimentInit();
		}
		catch(IOException e){
			System.out.println("Problem loading mood");
		}
		
		
		Scanner in = new Scanner(System.in);
		Random rand = new Random();
		
		System.out.println("Hi, Rachael will be ready for you shortly."
				+ "\nCan I have your name?");
		String name = in.nextLine();
		
		if(name.toLowerCase().equals("admin")){
			System.out.println("Welcome admin");
			while(true){
				System.out.println("Enter a word to add");
				String entry= in.nextLine();
				  if(mood.getHappy().contains(entry))
				   {
					  System.out.println("Already listed as happy");   
				   }
				   else if(mood.getSad().contains(entry))
				   {
					   System.out.println("Already listed as sad");
				   }else if(mood.getNeutral().contains(entry)){
					   System.out.println("Already listed as neutral");
				   }
				   else
					{
					   System.out.println("Does < "+ entry+ " > make you happy or sad?"+"\n"
									+"Press '1' to define happy, press '2' to define sad, or press '3' to define neutral");
					   String happy = in.nextLine();
					   if(happy.equals("1"))
						{
							try {
								mood.addWordtoHappy(entry);
							} catch (IOException e) {
								// TODO Auto-generated catch block
								System.out.println("Problem loading mood");
							}
						}
						else if(happy.equals("2"))
						{
							try {
								mood.addWordtoSad(entry);
							} catch (IOException e) {
								// TODO Auto-generated catch block
								System.out.println("Problem loading mood");
							}
						}
						else if(happy.equals("3"))
						{
							try {
								mood.addWordtoNeutral(entry);
							} catch (IOException e) {
								// TODO Auto-generated catch block
								System.out.println("Problem loading mood");
							}
						}
					   
					}
				}
			}
			
		
		
		saveDiary.NewDiary(name);
		referToEarlier today = new referToEarlier();
		today.setReference(name);
		saveDiary diary = new saveDiary(today.references);
		
		System.out.println("Rachael will see you now.");
	
		//start time
		Timer time =new Timer();
		
		time.start();
		
		int leave=0;
		int moodCount=0;
		
		
		System.out.println("Hi " + name + ", how are you?");
		while(true){
			String input = in.nextLine();
			String[] words = Print.replace(input, replacements);
			
			if(input.equals("patient"))
			{
				System.out.println(today.Frequency());
			}
			
			try {
				if(!input.equals("quit"))
				{
					diary.addTodiary(Print.compile(words),name);
				}
				else if (!input.equals("patient"))
				{
					diary.addTodiary(Print.compile(words),name);
				}
				
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			for(String word:words){
			   if(mood.getHappy().contains(word))
			   {
				  moodCount++;   
			   }
			   else if(mood.getSad().contains(word))
			   {
				   moodCount--;
			   }
			   else if(!mood.getNeutral().contains(word))
				{
				   System.out.println("Does < "+ word+ " > make you happy or sad?"+"\n"
								+"Press '1' to define happy, press '2' to define sad, or press '3' to define neutral");
				   String happy = in.nextLine();
				   if(happy.equals("1"))
					{
						try {
							mood.addWordtoHappy(word);
						} catch (IOException e) {
							// TODO Auto-generated catch block
							System.out.println("Problem loading mood");
						}
					}
					else if(happy.equals("2"))
					{
						try {
							mood.addWordtoSad(word);
						} catch (IOException e) {
							// TODO Auto-generated catch block
							System.out.println("Problem loading mood");
						}
					}
					else if(happy.equals("3"))
					{
						try {
							mood.addWordtoNeutral(word);
						} catch (IOException e) {
							// TODO Auto-generated catch block
							System.out.println("Problem loading mood");
						}
					}
				   
				}
			}
			//int respond = rand.nextInt(4);
			int respond = 0;
			int useName=rand.nextInt(5);
			if(input.equals("quit")){
				System.out.println(Print.leave(leave));
				if(leave==2)
					{
					break;
					}
				System.out.println(Print.randFrom(questions));
				try {
					diary.addTodiary(Print.compile(words),name);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				leave++;
			}
			
			else if(moodCount>5||moodCount<-5)
			{
				System.out.println(mood.DefineMoody(moodCount, 0));
				moodCount=0;
			}
			
			else if(respond==0){
				if (useName==0){
					System.out.println(name+", "+Print.randFrom(hedges));
				}else{
					System.out.println(Print.randFrom(hedges));
				}
			}
			else if(respond==1){
				if (useName==0){
					System.out.println(name+", "+Print.randFrom(questions));
				}else{
					System.out.println(Print.randFrom(questions));
				}
			}
			else if(respond==2){
				if(useName==0){
					System.out.println(name+", "+Print.randFrom(qualifiers)+ " " + Print.compile(words));
				}else{
					System.out.println(Print.randFrom(qualifiers)+ " " + Print.compile(words));
				}
			}
			else if(respond==3){
				if(useName==0){
					System.out.println(name+", "+today.getReference());
				}else{
					System.out.println(today.getReference());
				}
			}
		}
        time.end();
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        System.out.println("Time: "+(double)(time.getTotalTime())/60000+ " minutes");
        System.out.println("Cost: "+currency.format((double)(time.getTotalTime())/60000*10.00));
		//print cost
		
		//save diary
        
        
		in.close();
	}
}
