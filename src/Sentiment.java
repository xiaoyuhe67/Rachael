import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Sentiment {
	
	private static ArrayList<String> happy = new ArrayList<String>();
	private static ArrayList<String> sad = new ArrayList<String>();
	private static ArrayList<String> neutral = new ArrayList<String>();
	
	private static int happyCount=0;
	private static int sadCount=0;
	
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
	public String SearchMoodyWords(String[] str) throws IOException
	{	
		String Content="";
		SentimentInit();
		for(int i=0;i<str.length;i++)
		{
			if(happy.contains(str[i]))
			{
				happyCount++;
			}
			else if(sad.contains(str[i]))
			{
				sadCount++;
			}
			else
			{
				Content="Does < "+ str[i]+ " > make you happy or sad?"+"\n"
						+"Press '1' to define happy, press '2' to define sad, or press '3' to define neutral";
			}
		}
		
		return Content;
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
	public void userMoody(String str)
	{
		if(str.equals("1"))
		{
			addWordtoHappy(str);
		}
		else if(str.equals("2"))
		{
			addWordtoSad(str);
		}
		else if(str.equals("3"))
		{
			addWordtoNeutral(str);
		}
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
	
	
	
	
	
	 
	
	
	

}
