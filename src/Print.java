import java.util.ArrayList;
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
}
