package Métier;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.semanticweb.owlapi.model.OWLException;

import DAO.InterfaceImpDAOntologie;

public class UpdateKeyWords  {
	
	InterfaceImpDAOntologie imp= new InterfaceImpDAOntologie();
	
	
	public void UpdateKeywords() throws OWLException, IOException {
		JSONParser jsonParser = new JSONParser();
		JSONArray Dictionnary = new JSONArray();
		/*** Get FF with SLATokens ***/
	   	HashMap<String,ArrayList<String>> FFTokens= imp.UpdateFF();
	   	/*** Get CloudDictionary ***/
	   	try (FileReader reader = new FileReader("C:\\Users\\pc-click\\Desktop\\CloudDictionary.json"))
        {
            //Read JSON file
            Object obj = jsonParser.parse(reader);
 
             Dictionnary = (JSONArray) obj;
        } catch (Exception e) {
	    e.getStackTrace();
      }
	   	/*** Add Terms to CloudDictionary ***/
	   	for (String key : FFTokens.keySet()) {
	   		BabelNetConnection.createDictionaryCloud(FFTokens.get(key), Dictionnary, key);
		}
	   	
	   	
	   	
	   	 
	}
	

}
