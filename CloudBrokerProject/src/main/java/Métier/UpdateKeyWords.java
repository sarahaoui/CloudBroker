package Métier;


import static MetierFPGrowth.FPGrowth.findFrequentItemsetWithSuffix;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.semanticweb.owlapi.model.OWLException;

import DAO.InterfaceImpDAOntologie;
import MetierFPGrowth.DefaultPreprocessor;
import MetierFPGrowth.FPGrowth;

public class UpdateKeyWords  {
	
	InterfaceImpDAOntologie imp= new InterfaceImpDAOntologie();
	
	
	public void UpdateKeywords() throws OWLException, IOException {
		JSONParser jsonParser = new JSONParser();
		JSONArray Dictionnary = new JSONArray();
		
		/*** Get FF with SLATokens ***/
		System.out.println("************GetFFTokens**************");
	   	HashMap<String,ArrayList<ArrayList<String>>> FFTokens= imp.UpdateFF();
        System.out.println(FFTokens);
	   	/*** Get CloudDictionary ***/
	   	System.out.println("************GetCloudDictionary**************");
	   	try (FileReader reader = new FileReader("C:\\Users\\pc-click\\Desktop\\CloudDictionary.json"))
        {
            //Read JSON file
            Object obj = jsonParser.parse(reader);
            Dictionnary = (JSONArray) obj;
  
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
	   	/*** Add Terms to CloudDictionary ***/
	   	for (String key : FFTokens.keySet()) {
	   			BabelNetConnection.createDictionaryCloud(FFTokens.get(key), Dictionnary, key);	
		}
	   	try (FileWriter file = new FileWriter("C:\\Users\\pc-click\\Desktop\\CloudDictionary.json",false)) {
            //We can write any JSONArray or JSONObject instance to the file
			file.write(Dictionnary.toJSONString());
            file.flush();
            file.close();
 
        } catch (IOException e) {
            e.printStackTrace();
        }
	   	/*** for each FF ***/
	   	for (String key : FFTokens.keySet()) {
	   		/*** Unified Terms ***/
	   		System.out.println("************UnifiedTerms**************");
		    ArrayList<String>AllKeywords=new ArrayList<String>();
	    	   for (int i = 0; i < FFTokens.get(key).size(); i++) {
	   			for (int j = 0; j < FFTokens.get(key).get(i).size(); j++) {
	   				AllKeywords.add(FFTokens.get(key).get(i).get(j));
	   			}
	   		}
	        UnifiedTerms.UnifiedTerms(Dictionnary, AllKeywords);
	        int[]size= new int[FFTokens.get(key).size()];
	        for (int i = 0; i < FFTokens.get(key).size(); i++) {
	        	size[i]=FFTokens.get(key).get(i).size();
	        }
	        ArrayList<ArrayList<String>>TokensList =UnifiedTerms.GenerateListes(AllKeywords, size);
	        System.out.println(TokensList);
	        /*** TF Weight ****/
	        System.out.println("************TFWeight**************");
	        for (int i = 0; i < TokensList.size(); i++) {
			  TokensList.set(i, TFWeight.CalculateTFWeight(TokensList.get(i)));
			}
	        System.out.println(TokensList);
	        /*** FPGrowth ***/
	        System.out.println("************FPGrowth**************");
	        ArrayList<String[]>Listt= new ArrayList<String[]>();
	        for (int i = 0; i < TokensList.size(); i++) {
			  String[]TokensListString=new String[TokensList.get(i).size()];
		      TokensListString=TokensList.get(i).toArray(TokensListString);
		      Listt.add(TokensListString);
	        }
	        double minSupport = 0.6;
	        Map<String, Integer> oneItemsetCounts =FPGrowth.getOneItemsetCounts(Listt);
	        DefaultPreprocessor pr = new DefaultPreprocessor();
	        List<List<String>> output = new ArrayList<List<String>>();
	        output=pr.getFrequentItemsetWithLabels(
	            findFrequentItemsetWithSuffix(
	                FPGrowth.buildFPTree(Listt, oneItemsetCounts, true, minSupport),
	                new ArrayList<String>(),
	                ((int) minSupport * Listt.size())
	            ));
	        
	        ArrayList<String>Properties= new ArrayList<String>();
	        for (int i = 0; i < output.size(); i++) {
				for(int j=0;j<output.get(i).size();j++) {
					if(!Properties.contains(output.get(i).get(j))) {
						Properties.add(output.get(i).get(j));
					}
				}
			}
	        String propString ="";
	        for (int i = 0; i < Properties.size(); i++) {
	        	if(propString.equals("")) {
	        		propString =propString+Properties.get(i);
	        	}else {
	        		propString =propString+","+Properties.get(i);
	        	}
	        	
			}
	      System.out.println(propString);
	        
	        /*** Add Properties to FF Unique Merged Keywords ***/
	          System.out.println("************ADD Properties**************");
	          InterfaceImpDAOntologie.UpdateKeyWords(key,propString,"Unique");
	          InterfaceImpDAOntologie.UpdateKeyWords(key,propString,"Merged");
	        
	       
	   	}
	    /*** Update Merged Keywords ***/
        ArrayList<String> VisitedNode= new ArrayList<String>();
        InterfaceImpDAOntologie.DFSbasedMergingKeyWords("OFFs",VisitedNode);
      
      
       
	   	
	   	
	   	
	   	 
	}
	

}
