import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;


public class Rachael {
	
	public static void main(String[] args) {
		ArrayList<String> qualifiers = Init.Qualifier();
		ArrayList<String> questions = Init.Questions();
		ArrayList<String> hedges = Init.Hedges();
		HashMap<String,String> replacements;
		
		Sentiment mood=new Sentiment();
		
		//Get sentiment lists
		try{
		mood.SentimentInit();
		}
		catch(Exception e){
			System.out.println("Problem loading mood");
		}
		
		Scanner in = new Scanner(System.in);
		Random rand = new Random();
		
		System.out.println("Hi, Rachael will be ready for you shortly."
				+ "Can I have your name?");
		String name = in.nextLine();
		
		//Load diary
		
		System.out.println("Rachael will see you now.");
		
		//start time
		
		
		int leave=0;
		int moodCount=0;
		
		
		System.out.println("Hi " + name + ", how are you?");
		while(true){
			int respond = rand.nextInt(4);
			String input = in.nextLine();
			String[] words = Print.replace(input, replacements);//todo
			for(String word:words){
				//if happy add 1
				//if sad subtract 1
				//if new clarify
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
						mood.addWordtoHappy(word);
					}
					else if(happy.equals("2"))
					{
						mood.addWordtoSad(word);
					}
					else if(happy.equals("3"))
					{
						mood.addWordtoNeutral(word);
					}
				   
				}
					
			}
			//process input
			
			
			if(input.equals("quit"))System.out.println(Print.leave(leave));
			
			else if(moodCount>5||moodCount<5)
			{
				System.out.println(mood.DefineMoody(moodCount, 0));
				moodCount=0;
			}
			
			else if(respond==0)System.out.println(Print.randFrom(hedges));
			//1 random
			//2 qualify
			//3 refer
		}
		
	     
		//print cost
		
		//save diary
	}
}
