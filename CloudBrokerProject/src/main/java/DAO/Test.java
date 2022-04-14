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
import java.util.List;
import java.util.stream.Stream;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.semanticweb.owlapi.model.OWLException;

import Métier.BabelNetConnection;




public class Test {

	public static void main(String[] args)  {
		JSONParser jsonParser = new JSONParser();
		JSONArray Dictionnary = new JSONArray();
		ArrayList<ArrayList<String>> FFTokens= new ArrayList<ArrayList<String>>();
		ArrayList<String> list= new ArrayList<>();
		System.out.println("************GetCloudDictionary**************");
	   	try (FileReader reader = new FileReader("C:\\Users\\pc-click\\Desktop\\CloudDictionary.json"))
        {
            //Read JSON file
            Object obj = jsonParser.parse(reader);
            Dictionnary = (JSONArray) obj;
            //System.out.println(Dictionnary);
  
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
	   	/*** Add Terms to CloudDictionary ***/
	   	list.add("HR;NN");
	   	list.add("payroll;NN");
	   	list.add("benefit;NN");
	   	list.add("employee;NN");
	   	list.add("team;NN");
	   	list.add("professionalism;NN");
	   	list.add("employer;NN");
	   	list.add("compensation;NN");
	   	list.add("compliance;NN");
	   	list.add("employe;NN");
	   	list.add("mentors;NNS");
		list.add("employees;NNS");
		list.add("accounting;VBG");
		list.add("reporting;VBG");
		list.add("mentor;NN");
		list.add("people;NNS");
		list.add("account;NN");
		list.add("report;NN");
		FFTokens.add(list);
	   			BabelNetConnection.createDictionaryCloud(FFTokens, Dictionnary, "BusinessResourceManagement");	
		
	   	try (FileWriter file = new FileWriter("C:\\Users\\pc-click\\Desktop\\CloudDictionary.json",false)) {
            //We can write any JSONArray or JSONObject instance to the file
			file.write(Dictionnary.toJSONString());
            file.flush();
            file.close();
 
        } catch (IOException e) {
            e.printStackTrace();
        }
		
		

   
	}

}
