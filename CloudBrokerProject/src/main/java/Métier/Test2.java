package Métier;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

import javax.servlet.http.Cookie;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.semanticweb.owlapi.model.OWLException;


import DAO.InterfaceImpDAOntologie;

public class Test2 {

	public static void main(String[] args) {
		
		URL url;
		try {
			url = new URL("http://localhost:3000/Service");
			HttpURLConnection conn= (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.connect();
			// Check if connect is made 
			int responseCode = conn.getResponseCode();
			
			//200 ok
			if(responseCode!=200) {
				throw new RuntimeException("HttpRespondeCode: "+responseCode);
			}else {
				StringBuilder information= new StringBuilder();
				Scanner scanner = new Scanner(url.openStream());
				while(scanner.hasNext()) {
					information.append(scanner.nextLine());
				}
				scanner.close();
				//System.out.println(information);
				try (FileWriter file = new FileWriter("C:\\Users\\pc-click\\Desktop\\api.json",false)) {
		            //We can write any JSONArray or JSONObject instance to the file
					
				    file.write(String.valueOf(information));
			        file.flush();	
		            file.close();
		 
		        } catch (IOException e) {
		            e.printStackTrace();
		        }
				JSONObject service = new JSONObject();
				JSONParser parse = new JSONParser();
				
				try (FileReader reader = new FileReader("C:\\Users\\pc-click\\Desktop\\api.json"))
	            {
	               //Read JSON file
	                Object obj = parse.parse(reader);
	                service = (JSONObject) obj;  
	                
	             } catch (IOException e) {
	            	 e.printStackTrace();
	             } catch (ParseException e) {
	                e.printStackTrace();
	             }
				
				Set<String> keys=  service.keySet();
				//System.out.println(keys);
				Iterator keysiter= keys.iterator();
                
				while(keysiter.hasNext()) {
					String key = keysiter.next().toString();
					if(service.get(key) instanceof JSONObject) {  // to JSONObject
						System.out.println("JSONObject:" +service.get(key));
					}else {
						System.out.println("Value: "+service.get(key));  // value type
					}	
				}
		}
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		
}
}
