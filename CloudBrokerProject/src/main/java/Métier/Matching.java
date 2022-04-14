package Métier;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class Matching {
	
	
	public static String TrakingSynonymss(ArrayList<String>TokenCheckedList,JSONArray Dictionnary,ArrayList<String> serviceSLATokens,String term,String FF) {
		
		if(TokenCheckedList.contains(term))
			return null;
		TokenCheckedList.add(term);
		
		JSONObject value = null;
        JSONArray array = new JSONArray();
       
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
             if (Domain.equals(FF) )
             {
            	Concept = (ArrayList<String>) value2.get("Concept"); 
            	for (String syn : Concept) {
					if(serviceSLATokens.indexOf(syn)>-1) {
						return syn;
					}else if(serviceSLATokens.indexOf(TrakingSynonymss(TokenCheckedList, Dictionnary, serviceSLATokens, syn, FF)) >-1) {
						return syn;
					}
				}
            	entity = (ArrayList<String>) value2.get("Entity");
            	for (String syn : entity) {
					if(serviceSLATokens.indexOf(syn)>-1) {
						return syn;
					}else if(serviceSLATokens.indexOf(TrakingSynonymss(TokenCheckedList, Dictionnary, serviceSLATokens, syn, FF)) >-1) {
						return syn;
					}
				}
            	 
                 
             }
         }
		
		 return null;
		 
	 }
	public static int GetCount(String synonym, ArrayList<String> serviceSLATokens) {
		int count =0;
		for (String term : serviceSLATokens) {
			if(term.equals(synonym)) {
				count++;
			}
		}
		return count;
		
	}
	
	public static Double RelativeEntropy(String Keywords, ArrayList<String> serviceSLATokens ,String FF , JSONArray Dictionnary) {
		String[] termsString = Keywords.split(",");
		List<String> terms= new LinkedList<String>(Arrays.asList(termsString));
		ArrayList<String>TokenCheckedList = new ArrayList<String>();
		int[]index= new int[terms.size()];
		int i=0;
		int TotalCount=0;
		Double Pi,Entropy=0.0;
		for (String term : terms) {
			int termCount =GetCount(term, serviceSLATokens);
			String Synonym = TrakingSynonymss(TokenCheckedList, Dictionnary, serviceSLATokens, term, FF);
			if(Synonym !=null)
				termCount+=GetCount(Synonym, serviceSLATokens);
			index[i++]=termCount;
		    TotalCount+=termCount;
		}
		for (int j = 0; j < terms.size(); j++) {
			if(index[j]>0) {
				Pi= (double) (index[i]/TotalCount);
				Entropy+=(Pi * Math.log(Pi))/Math.log(terms.size());
			}
		}
		return -Entropy;	
	}
	
	
}
