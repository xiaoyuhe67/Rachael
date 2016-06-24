package Rachael;

import java.util.ArrayList;
import java.util.HashMap;

public class Init {
	public static ArrayList<String> Hedges(){
		ArrayList<String>hedges = new ArrayList<String>();
		hedges.add("Tell me more about that.");
		hedges.add("Many of my patients say the same thing.");
		hedges.add("That's sounds interesting, tell me more.");
		hedges.add("Do you think that's a good or bad thing?");
		hedges.add("Please tell me more.");
		hedges.add("It is getting late, maybe we had better quit.");
		hedges.add("That's interesting, I haven't heard that before.");
		hedges.add("It seems like you've been holding that back for a while.");
		hedges.add("Interesting. How does that make you feel?");
		hedges.add("Can you tell me more about that?");
		hedges.add("Why don't you tell me a little more about that.");
		hedges.add("It seems like you're not telling me the whole story.");
		hedges.add("And how did that make you feel?");
		hedges.add("I've heard that story many a time.");
		hedges.add("I feel like we're really getting somewhere, go on.");
		return hedges;
	}
	
	public static ArrayList<String> Qualifier(){
		ArrayList<String>qual=new ArrayList<String>();
		qual.add("You seem to think that");
		qual.add("Why do you say that");
		qual.add("So, you are concerned that");
		qual.add("You seem hung up on the fact that");
		qual.add("Are you sure");
		qual.add("I find it hard to believe");
		qual.add("You're trying to say that");
		qual.add("So you believe that");
		qual.add("When did you find out");
		qual.add("How did you come to know");
		qual.add("I think it's funny");
		qual.add("What makes you think");
		qual.add("How did you come to know");
		qual.add("It sounds like you've been really affected because");
		qual.add("I really doubt");
		
		return qual;
	}
	
	public static HashMap<String,String> switchInit(){
		HashMap<String,String>switches=new HashMap<String,String>();
		switches.put("me","you");
		switches.put("i","you");
		switches.put("my","your");
		switches.put("mine","yours");
		switches.put("myself","yourself");
		switches.put("us","you");
		switches.put("we","you");
		switches.put("am","are");
		switches.put("ourselves","yourselves");
		switches.put("our","your");
		switches.put("you","I");
		switches.put("your","my");
		switches.put("yours","mine");
		switches.put("your","my");
		switches.put("I'm","you're");
		switches.put("I've","you've");
		switches.put("I'll","you'll");
		
		return switches;
	}
	
	public static ArrayList<String> Questions(){
		ArrayList<String>q=new ArrayList<String>();
		q.add("Did you catch the game last night?");
		q.add("What do you think about the weather we're having?");
		q.add("Got any plans this weekend?");
		q.add("Seen any good movies lately?");
		q.add("How is your work going?");
		q.add("Have you been exercising?");
		q.add("Did you get a haircut?");
		q.add("Have you been making sure to take your medicine?");
		q.add("What kind of music do you like?");
		q.add("What kinds of food do you like?");
		q.add("Can you give me your credit card number?");
		q.add("Do you think you could beat me in a fight?");//12
		q.add("Where did you say you were from again?");
		q.add("Have you spoken with your mother recently?");
		q.add("Just what kind of therapist do you think I am?");
		
		return q;
	}
}
