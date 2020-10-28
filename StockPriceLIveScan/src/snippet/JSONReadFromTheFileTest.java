package snippet;
import java.awt.Toolkit;
import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.util.Date;

import org.json.simple.parser.ParseException;
public class JSONReadFromTheFileTest 
{ 
   public static void main(String[] args) throws IOException, ParseException 
   {
	   try {
		   
		   String line;
		   float oldPrice = 1 ;
		   float newPrice = 1;
		   while (true) 
		   {
	            System.out.println(new Date());
	            Thread.sleep(5*60000);
	       
	   
	
	   
	   
	            URL url = new URL("https://api.coindesk.com/v1/bpi/currentprice.json");

	            URLConnection connection = url.openConnection();
	            connection.addRequestProperty("Referer",  "https://api.coindesk.com/v1/bpi/currentprice.json");

	   
	            StringBuilder builder = new StringBuilder();
	            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));

	            while((line = reader.readLine()) != null) 
	            {
	            	builder.append(line);
	            	//price = line.substring(400, 450);
	            	int end = 446;
	            	while(Character.isDigit(line.charAt(end)) == false)
	            	{end = end-1;}
	            	newPrice = Float.parseFloat(line.substring(437,end));
	            	if(newPrice/oldPrice>1.01)
	            	{
	            		Toolkit.getDefaultToolkit().beep();
	            		System.out.println(newPrice);
	            		System.out.println(oldPrice);
	            	}
	            	System.out.println(newPrice);
            		System.out.println(oldPrice);
	            	System.out.println(newPrice/oldPrice);
            		
	            }
	            oldPrice = newPrice;
	        }
	    } catch (InterruptedException e) 
	   {
	    	e.printStackTrace();
	    }


	 

   }
}