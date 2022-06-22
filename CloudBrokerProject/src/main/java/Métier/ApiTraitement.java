package Métier;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;

import java.net.URL;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;

import org.apache.jena.atlas.json.io.parser.JSONParser;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class ApiTraitement {

	public JSONArray TraitementApi(String path) throws IOException {
		
		URL url = new URL(path);
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
			System.out.println(information);
			
						
			
			
		}
		return null;
	}
}
