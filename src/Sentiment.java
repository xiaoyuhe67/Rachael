import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Sentiment {
	
	private static ArrayList<String> happy = new ArrayList<String>();
	private static ArrayList<String> sad = new ArrayList<String>();
	private static ArrayList<String> neutral = new ArrayList<String>();
	
	
	public ArrayList<String> createHappyList() throws IOException
	{
		ArrayList<String> arr = new ArrayList<String>();
		File file = new File("happy.txt");	
		FileReader fr = new FileReader(file);
	    BufferedReader br = new BufferedReader(fr);
	    String line;
	    while ( (line = br.readLine())!= null)     
	    {
	            arr.add(line);	                      
	    }
		br.close();
		return arr;
	}
	
	public ArrayList<String> createSadList() throws IOException
	{
		ArrayList<String> arr = new ArrayList<String>();
		File file = new File("sad.txt");	
		FileReader fr = new FileReader(file);
	    BufferedReader br = new BufferedReader(fr);
	    String line;
	    while ( (line = br.readLine())!= null)     
	    {
	            arr.add(line);	                      
	    }
		br.close();
		return arr;
	}
	public ArrayList<String> createNeutralList() throws IOException
	{
		ArrayList<String> arr = new ArrayList<String>();
		File file = new File("Neutral.txt");	
		FileReader fr = new FileReader(file);
	    BufferedReader br = new BufferedReader(fr);
	    String line;
	    while ( (line = br.readLine())!= null)     
	    {
	            arr.add(line);	                      
	    }
		br.close();
		return arr;
	}
	
	public void SentimentInit() throws IOException
	{
		happy=createHappyList();
		sad=createSadList();
		neutral=createNeutralList();
	}
	
	public String DefineMoody(int happyCount, int sadCount)
	{
		String Content="";
		if(happyCount>sadCount)
		{
			Content+="What are you so happy about?"+"\n";
		}
		else if(happyCount<sadCount)
		{
			Content+="What are you so sad about?"+"\n";
		}
		else
		{
			Content+="";
		}
		return Content;
	}
	
	
	
	public void addWordtoHappy(String str)
	{
		happy.add(str);
	}
	public void addWordtoSad(String str)
	{
		sad.add(str);
	}
	public void addWordtoNeutral(String str)
	{
		neutral.add(str);
	}
	
	public int gethappyCount(String[] str)
	{
		int happyCount=0;
		for(int i=0;i<str.length;i++)
		{
			if(happy.contains(str[i]))
			{
				happyCount++;
			}
			
		}
		return happyCount;
	}
	public int getSadCount(String[] str)
	{
		int sadCount=0;
		for(int i=0;i<str.length;i++)
		{
			if(sad.contains(str[i]))
			{
				sadCount++;
			}
			
		}
		return sadCount;
	}

	public ArrayList<String> getHappy() {
		return happy;
	}

	public void setHappy(ArrayList<String> happy) {
		Sentiment.happy = happy;
	}

	public ArrayList<String> getSad() {
		return sad;
	}

	public void setSad(ArrayList<String> sad) {
		Sentiment.sad = sad;
	}

	public ArrayList<String> getNeutral() {
		return neutral;
	}

	public void setNeutral(ArrayList<String> neutral) {
		Sentiment.neutral = neutral;
	}
	
	
	
	
	
	
	 
	
	
	

}
