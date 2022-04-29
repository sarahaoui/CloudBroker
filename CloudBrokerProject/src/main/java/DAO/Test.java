package DAO;



import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Stream;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.semanticweb.owlapi.model.OWLException;

import Métier.BabelNetConnection;
import Métier.SortedServices;




public class Test {

	public static void main(String[] args)  {
		InterfaceImpDAOntologie imp = new InterfaceImpDAOntologie();
		ArrayList<String>list= new ArrayList<>();
		list.add("StreamingAndMultimedia");
		list.add("HumanRessourceManagement_HRM");
		/*** Get CloudDictionary ***/
	    JSONParser jsonParser = new JSONParser();
    JSONArray Dictionnary = new JSONArray();
    ArrayList<JSONObject> RankedCatServices = new ArrayList<JSONObject>();
	    try (FileReader reader = new FileReader("C:\\Users\\pc-click\\Desktop\\CloudDictionary.json"))
    {
       //Read JSON file
        Object obj = jsonParser.parse(reader);
        Dictionnary = (JSONArray) obj;

     } catch (IOException e) {
        e.printStackTrace();
     } catch (ParseException e) {
        e.printStackTrace();	     }
		try {
			 RankedCatServices =	InterfaceImpDAOntologie.RankingServices(imp.ServicesRetrieval(list), list, Dictionnary);
			 System.out.println(":"+RankedCatServices); 
			 
			
		
		} catch (OWLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try (FileWriter file = new FileWriter("C:\\Users\\pc-click\\Desktop\\services.json",false)) {
            //We can write any JSONArray or JSONObject instance to the file
			for (JSONObject jsonObject : RankedCatServices) {
				file.write(jsonObject.toJSONString());
	            file.flush();	
			}
			
            file.close();
 
        } catch (IOException e) {
            e.printStackTrace();
        }
		
		
		
		
		
		
		
		
		
		
		
	}

}
