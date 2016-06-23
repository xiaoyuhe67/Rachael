import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;


public class Print {
	public static String leave(int tries){
		if(tries<3)return "So you want to leave.  Answer just a few more questions before you go.";
		else return "Alright I suppose that's enough for now.";
	}
	
	public static String randFrom(ArrayList<String> list){
		Random rand = new Random();
		return list.get(rand.nextInt(list.size()));
	}
	
	public static String[] replace(String input, HashMap<String,String> replacements){
		input=input.toLowerCase();
		String[] words = input.split(" ");
		for(int i = 0;i < words.length;i++){
			if(replacements.containsKey(words[i]))words[i]=replacements.get(words[i]);
		}
		return words;
	}
	public static String compile(String[] words){
		String output=new String();
		for(String word:words){
			output+=word + " ";
		}
		return output;
	}
}
