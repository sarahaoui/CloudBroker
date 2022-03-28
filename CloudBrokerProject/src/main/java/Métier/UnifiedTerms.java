package Métier;

import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class UnifiedTerms {

	public void UnifiedTerms(JSONArray Dictionary, ArrayList<String> list) {
		ArrayList<String> result= new ArrayList<>();
		for(int i=0;i<list.size();i++) {
			if(!result.contains(list.get(i))) {
			ArrayList<String> Synonyms=parseTokenObject((JSONArray )Dictionary,list.get(i));
			
			for(int j=i+1;j<list.size();j++) {
				String[] partsj= list.get(j).split(";");
				if(!result.contains(list.get(j))) {
				if(Synonyms.contains(partsj[0]) ) {
					list.set(j, list.get(i));
				}
			}}
			result.add(list.get(i));
		}}
		
	}
	public static ArrayList<String> parseTokenObject(JSONArray Dictionnary,String term) {
		JSONObject value = null;
        JSONArray array = new JSONArray();
        ArrayList<String>Synonyms= new ArrayList<>();
         for (int i = 0; i < Dictionnary.size(); i++)
        {
            JSONObject item = (JSONObject) Dictionnary.get(i);
            
            if (item.keySet().contains(term))
            {
                value = (JSONObject) item.get(term);
                array.add(value);
            }
        }
         
         JSONObject value2 = null;
         ArrayList<String>Concept= new ArrayList<>();
         ArrayList<String>entity= new ArrayList<>();
         String Domain=null;
        for (int i = 0; i < array.size(); i++)
         {
        	value2 = (JSONObject) array.get(i);
             Domain = (String) value2.get("CloudDomainName");
             if (Domain.equals("HR") )
             {
            	Concept = (ArrayList<String>) value2.get("Concept"); 
            	entity = (ArrayList<String>) value2.get("Entity"); 
            	Synonyms.addAll(Concept);
            	Synonyms.addAll(Concept.size(),entity);
                break; 
                 
             }
         }
        
	    return Synonyms;
	}
}
