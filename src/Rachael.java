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
		HashMap<String,String> replacements = Init.switchInit();
		
		Sentiment mood=new Sentiment();
		try{
		mood.SentimentInit();
		}
		catch(IOException e){
			System.out.println("Problem loading mood");
		}
		
		int respond2 = 0;
		
		Scanner in = new Scanner(System.in);
		Random rand = new Random();
		
		System.out.println("Hi, Rachael will be ready for you shortly."
				+ "\nCan I have your name?");
		String name = in.nextLine();
		
		saveDiary.NewDiary(name);
		referToEarlier today = new referToEarlier();
		today.setReference(name);
		saveDiary diary = new saveDiary(today.references);
		
		System.out.println("Rachael will see you now.");
		
		//start time
		
		
		int leave=0;
		int moodCount=0;
		
		
		System.out.println("Hi " + name + ", how are you?");
		while(true){
			String input = in.nextLine();
			String[] words = Print.replace(input, replacements);
			diary.addTodiary(Print.compile(words));
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
			if(input.equals("quit")){
				System.out.println(Print.leave(leave));
				break;
			}
			
			else if(moodCount>5||moodCount<-5)
			{
				System.out.println(mood.DefineMoody(moodCount, 0));
				moodCount=0;
			}
			
			else if(respond==0&&respond2==0){
				System.out.println(Print.randFrom(hedges));
				respond2++;
			}
			else if(respond==1){
				System.out.println(Print.randFrom(questions));
			}
			else if(respond==2){
				System.out.println(Print.randFrom(qualifiers)+ " " + Print.compile(words));
			}
			else if(respond==0){
				System.out.println(today.getReference());
			}
		}
<<<<<<< HEAD
=======
		
	     
>>>>>>> 2d546bf09b4af80eb93377356d805a5bb402676f
		//print cost
		
		//save diary
		in.close();
	}
}
