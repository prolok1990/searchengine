package textprocess;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class PrintToConsole {
	public static void print(List<String> tokenlist)
	{
		
			for(String str:tokenlist)
				
				{
					System.out.println(str);//iterate through the list, and print
				}
		
		
	}
	public static void print(Map<String,Integer> fcount)
	{
		List<Map.Entry<String,Integer>> list = new LinkedList<Entry<String, Integer>>( fcount.entrySet() );//converting the frequency list into Linked-list.
	    Collections.sort( list, new Comparator<Map.Entry<String,Integer>>()
	    {
	        public int compare( Map.Entry<String,Integer> m1, Map.Entry<String,Integer> m2 )//comparator for sorting
	        {
	            return (m2.getValue()).compareTo( m1.getValue() );
	        }

		} );
	    
	    for (Map.Entry<String,Integer> entry : list)
	    {
	    	System.out.println( entry.getKey()+" : "+entry.getValue());//iterate through the sorted linkedlist and print
	    }
		
	}
	
}
