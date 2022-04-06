package Métier;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import it.uniroma1.lcl.babelnet.BabelNet;
import it.uniroma1.lcl.babelnet.BabelNetQuery;
import it.uniroma1.lcl.babelnet.BabelSense;
import it.uniroma1.lcl.babelnet.BabelSynset;
import it.uniroma1.lcl.jlt.util.Language;

public class BabelNetConnection {
	
	List<BabelSense> senses = null;
	List<BabelSynset> byl =null;
	static BabelNet bn = BabelNet.getInstance();
	
	/**** 	First Test *****/
	public void Connection(ArrayList<String> keywords) {
		for(int i=0;i<keywords.size();i++) {
			
		BabelNetQuery query = new BabelNetQuery.Builder(keywords.get(i))
		        .from(Language.EN)
		        .build();
		List<BabelSynset> byl = bn.getSynsets(query);
		if(byl.isEmpty()) {
	    	 keywords.remove(keywords.get(i));
	     }else {
		String item= keywords.get(i);
		item= item.replace(" ", "_");
		keywords.set(i, item);
		}}
		
		System.out.println("Done !");
		}
	
	/**** 	Second Test *****/
	public ArrayList<String> Connection2(ArrayList<String> keywords) {
		ArrayList<String> tokens=new ArrayList<>();
		for(int j=0;j<keywords.size();j++) {
			tokens.add(keywords.get(j));
		}
		for(int i=0;i<keywords.size();i++) {	
		String[] parts= keywords.get(i).split(";");	
		BabelNetQuery query = new BabelNetQuery.Builder(parts[0])
		        .from(Language.EN)
		        .build();
		List<BabelSynset> byl = bn.getSynsets(query);
		
		if(byl.isEmpty()) {
			
	    	 tokens.remove(keywords.get(i));
	     }}
		
		return tokens;
		
		}
	/**** Get Synonyms For FF ******/
	public ArrayList<String> SynonymsFF(String FF){

		Set<String> sensesSet= new HashSet<>();
		ArrayList <String> sensesList= new ArrayList<>();
		BabelNetQuery query = new BabelNetQuery.Builder(FF)
		        .from(Language.EN)
		        .build();
		List<BabelSynset> byl = bn.getSynsets(query);
		List<BabelSense> senses = bn.getSensesFrom(query); 
		if(byl.isEmpty()) {
	    	 System.out.println("No Data"); 
	     }
		else {
		for (BabelSense sense : senses) {
			sensesSet.add(sense.getNormalizedLemma());
		}	
		}
		sensesList.addAll(sensesSet);
		return sensesList;
	}
	
	/**** Create DictionaryCloud ****/
	public static JSONArray createDictionaryCloud(ArrayList<ArrayList<String>> Tokens,JSONArray Dictionary,String FF) {
	for (int j = 0; j < Tokens.size(); j++) {
		for (int i=0;i<Tokens.get(j).size();i++) {
			if(!SreachTermInDictionary(Dictionary, Tokens.get(j).get(i)) && NumerOfServiceTerm(Tokens.get(j).get(i), Tokens)>=0.2) {   //check if term not exist in CloudDictionary and term exist in 20% of services 
		    String[] parts= Tokens.get(j).get(i).split(";");
		    ArrayList<String>Concepts= new ArrayList<>();
			ArrayList<String>Entitys= new ArrayList<>();
		    BabelNetQuery query = new BabelNetQuery.Builder(parts[0])
		        .from(Language.EN)
		        .build();
		    List<BabelSynset> byl = bn.getSynsets(query);
		    for (BabelSynset babelSynset : byl) {
					if(babelSynset.getType().toString().equals("Concept")) {
				    List<BabelSense> senses=babelSynset.getSenses();
					for (BabelSense sense : senses) {
						if(!Concepts.contains(sense.getNormalizedLemma().toString())) {
						 Concepts.add(sense.getNormalizedLemma().toString());}
						}
						
					 }else {
					 List<BabelSense> senses=babelSynset.getSenses();
				     for (BabelSense sense : senses) {
					   if(!Entitys.contains(sense.getNormalizedLemma().toString())) {
					   Entitys.add(sense.getNormalizedLemma().toString());}
						}
					 }
		           
		         }
		    JSONObject tokenDetails= new JSONObject();
		    tokenDetails.put("CloudDomainName", FF);
		    tokenDetails.put("Concept", Concepts);
		    tokenDetails.put("Entity", Entitys);
		
		    JSONObject tokenObject = new JSONObject();
		    tokenObject.put(Tokens.get(j).get(i), tokenDetails);
		    Dictionary.add(tokenObject);
    }}
	} 
		
		  
	return Dictionary;	  
 }
	public static Boolean  SreachTermInDictionary(JSONArray Dictionnary,String term) {
		 
         for (int i = 0; i < Dictionnary.size(); i++)
        { 
            JSONObject item = (JSONObject) Dictionnary.get(i);
            if (item.keySet().contains(term))
            {return true;}
        }
		return false;
         }
	
	 public static Double NumerOfServiceTerm(String Term ,ArrayList<ArrayList<String>>list) {
		 double count=0;
		  for (int i = 0; i < list.size(); i++) {
			if(list.get(i).contains(Term)) {
				count++;
			}
		}
		int lenght= list.size();
		return (count/lenght);
	  }
}
 
