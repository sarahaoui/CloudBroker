package DAO;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

import org.apache.jena.query.Query;
import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.query.QueryFactory;
import org.apache.jena.query.QuerySolution;
import org.apache.jena.query.ResultSet;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.RDFNode;
import org.json.simple.JSONArray;


import Métier.BabelNetConnection;
import Métier.Similarity;
import Métier.WordNetConnection;
import edu.cmu.lti.lexical_db.ILexicalDatabase;
import edu.cmu.lti.lexical_db.NictWordNet;
import edu.cmu.lti.ws4j.impl.WuPalmer;
import edu.cmu.lti.ws4j.util.WS4JConfiguration;
import edu.smu.tspell.wordnet.Synset;
import edu.smu.tspell.wordnet.WordNetDatabase;

public class ImplementationSimilarity {
	static String defaultNameSpace= SingletonConnectionOntoS.getDefaultNameSpace();
	static Model model= SingletonConnectionOntoS.getModel();
	private static ILexicalDatabase db = new NictWordNet();
	
	 public static ArrayList<String> GetChildren(String FF) {
		 
		 ArrayList<String> childs= new ArrayList<>();
		  String sparqlQuery = "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\r\n"
		  		+ "PREFIX owl: <http://www.w3.org/2002/07/owl#>\r\n"
		  		+ "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\r\n"
		  		+ "PREFIX xsd: <http://www.w3.org/2001/XMLSchema#>\r\n"
		  		+ "PREFIX dc: <http://www.protege.org/Cloud#>\r\n"
		  		+ "SELECT ?child \r\n"
		  		+ " WHERE { ?child rdfs:subClassOf dc:"+FF+"\r\n"
		  		+ " MINUS { ?child rdfs:subClassOf ?othersub .\r\n"
		  		+ "                     ?othersub rdfs:subClassOf dc:"+FF+".\r\n"
		  		+ "                      FILTER (?child != ?othersub)"
		  		+ "                      FILTER (?othersub != dc:"+FF+"). } }";
	      		

	      Query query= QueryFactory.create(sparqlQuery);  
			QueryExecution queryExecution= QueryExecutionFactory.create(query,model);
			try {
				ResultSet response=queryExecution.execSelect(); 
				while(response.hasNext()) {
					QuerySolution sol= response.nextSolution();
					RDFNode child=sol.get("?child");
					if(child==null){
						System.out.println("there are no data");
					}else {
						String childString= child.toString();
						childString = childString.substring(childString.indexOf("#")+1);
						if(!childString.equals(FF)) {
	                    childs.add(childString);}
					}
					}}
				finally {
					
					queryExecution.close();
				}
			return childs;
		  
	  }
	 public static void GetDomaine(String Node ,HashMap<String,ArrayList<String>> sysnsetTerm ,ArrayList<String> VisitedNode,HashMap<String,Double> similarityChildren) {
		 ArrayList<String> children= new ArrayList<>();
		 System.setProperty("wordnet.database.dir", "C:\\Users\\pc-click\\Desktop\\PFE Ressources\\WordNet-3.0\\dict");
	        WordNetDatabase database = WordNetDatabase.getFileInstance();
		  children= GetChildren(Node); 
		  VisitedNode.add(Node);  //to avoid the cyclic mode
		  for (String child : children) {
			  if(!VisitedNode.contains(child)) {
                  // ArrayList<String>synonyms =BabelNetConnection.SynonymsFF(child);
				  ArrayList<String> synonyms = new ArrayList<String>();
				  if(child.contains("_")) {
					  String[] parts= child.split("_");	
					  for (int i = 0; i < parts.length; i++) {
						  synonyms.addAll(synonyms.size(), WordNetConnection.Synonyms(parts[i]));
					}
				  }else {
					   synonyms.addAll(WordNetConnection.Synonyms(child)) ; 
					  
				  }
				  
	               
				/*** Calculate Similarity ***/	
					// Syntaxique Similarity
					Double similaritykeys = 0.0;
					String FF = child.replace("_", " ");
					for (String key : sysnsetTerm.keySet()) {
						 similaritykeys=similaritykeys+Similarity.diceCoefficient(key, FF);
					}
					Double similaritySim = similaritykeys/ sysnsetTerm.size();
	             
					
					// Lexical Similarity
			     ArrayList<Double> similaritylexical = new ArrayList<Double>();
				  System.out.println(synonyms);
					for (String key : sysnsetTerm.keySet()) {
						ArrayList<String> Synsets = sysnsetTerm.get(key);
						similaritylexical.add(Similarity.LexicalSimilarity(Synsets,synonyms)) ;
					}
					Double similarityLex =Collections.max(similaritylexical);
					
					
					
					//Structurel Similarity
					ArrayList<Double>Sim= new ArrayList<Double>();
					if(child.contains("_")) {
						String[] parts= child.split("_");	
						for (int i = 0; i < parts.length; i++) {
							for (String key : sysnsetTerm.keySet()) {
								Double Str=compute(key, parts[i]);
								if(Str<=1) {
									Sim.add(Str);	
								}
								}
						}
						
					}else {
					for (String key : sysnsetTerm.keySet()) {
								Double Str=compute(key, child);
								if(Str<=1) {
									Sim.add(Str);	
								}
								}}
					
					Double similarityStru = max(Sim);
					
					
					similarityStru =(int)(Math.round(similarityStru *10000000))/10000000.0;
					similaritySim=(int)(Math.round(similaritySim *10000000))/10000000.0;
					similarityLex =(int)(Math.round(similarityLex *10000000))/10000000.0;
					// Semantique Similarity 
					Double P1=Math.exp(similaritySim);
					Double P2 = Math.exp(similarityLex);
					Double P3 = Math.exp(similarityStru);
					//System.out.println("Child: "+child+"SimSyn: "+similaritySim+"SimLex: "+similarityLex+"SimStru: ");
					//System.out.println("P1: "+P1+"P2: "+P2);
					Double Similarity = (P1* similaritySim+P2*similarityLex+P3*similarityStru)/(P1+P2+P3);
					similarityChildren.put(child, Similarity);
					
			        }
			  

			 
		  }
		  //CalculateSimilarity(child ,sysnsetTerm ,VisitedNode,similarityChildren) ; 
	 }
	 public static void GetFF(String Node ,HashMap<String,ArrayList<String>> sysnsetTerm ,ArrayList<String> VisitedNode,HashMap<String,Double> similarityChildren) {
		 ArrayList<String> children= new ArrayList<>();
		 System.setProperty("wordnet.database.dir", "C:\\Users\\pc-click\\Desktop\\PFE Ressources\\WordNet-3.0\\dict");
	        WordNetDatabase database = WordNetDatabase.getFileInstance();
		  children= GetChildren(Node); 
		  VisitedNode.add(Node);  //to avoid the cyclic mode
		  for (String child : children) {
			  if(!VisitedNode.contains(child)) {
                  // ArrayList<String>synonyms =BabelNetConnection.SynonymsFF(child);
				  ArrayList<String> synonyms = new ArrayList<String>();
				  if(child.contains("_")) {
					  String[] parts= child.split("_");	
					  for (int i = 0; i < parts.length; i++) {
						  synonyms.addAll(synonyms.size(), WordNetConnection.Synonyms(parts[i]));
					}
				  }else {
					   synonyms.addAll(WordNetConnection.Synonyms(child)) ; 
					  
				  }
				  
	               
				/*** Calculate Similarity ***/	
					// Syntaxique Similarity
					Double similaritykeys = 0.0;
					String FF = child.replace("_", " ");
					for (String key : sysnsetTerm.keySet()) {
						 similaritykeys=similaritykeys+Similarity.diceCoefficient(key, FF);
					}
					Double similaritySim = similaritykeys/ sysnsetTerm.size();
	             
					
					// Lexical Similarity
					Double similaritylexical = 0.0;
				  System.out.println(synonyms);
					for (String key : sysnsetTerm.keySet()) {
						ArrayList<String> Synsets = sysnsetTerm.get(key);
						similaritylexical =similaritylexical+Similarity.LexicalSimilarity(Synsets,synonyms) ;
					}
					Double similarityLex =similaritylexical /sysnsetTerm.size();
					
					
					
					//Structurel Similarity
					ArrayList<Double>Sim= new ArrayList<Double>();
					if(child.contains("_")) {
						String[] parts= child.split("_");	
						for (int i = 0; i < parts.length; i++) {
							for (String key : sysnsetTerm.keySet()) {
								Double Str=compute(key, parts[i]);
								if(Str<=1) {
									Sim.add(Str);	
								}
								}
						}
						
					}else {
					for (String key : sysnsetTerm.keySet()) {
								Double Str=compute(key, child);
								if(Str<=1) {
									Sim.add(Str);	
								}
								}}
					
					Double similarityStru = max(Sim);
					
					
					similarityStru =(int)(Math.round(similarityStru *10000000))/10000000.0;
					similaritySim=(int)(Math.round(similaritySim *10000000))/10000000.0;
					similarityLex =(int)(Math.round(similarityLex *10000000))/10000000.0;
					// Semantique Similarity 
					Double P1=Math.exp(similaritySim);
					Double P2 = Math.exp(similarityLex);
					Double P3 = Math.exp(similarityStru);
					//System.out.println("Child: "+child+"SimSyn: "+similaritySim+"SimLex: "+similarityLex+"SimStru: ");
					//System.out.println("P1: "+P1+"P2: "+P2);
					Double Similarity = (P1* similaritySim+P2*similarityLex+P3*similarityStru)/(P1+P2+P3);
					similarityChildren.put(child, Similarity);
					
			        }
			  

			  GetFF(child ,sysnsetTerm ,VisitedNode,similarityChildren) ;  
		  }
		 
	 }
	 public static Double max(ArrayList<Double>list) {
		 Double max =list.get(0);
		 for(int i=0;i<list.size();i++) {
			 if(list.get(i)>=max) {
				 max= list.get(i);
			 }
		 }
		 return max;
	 }
	 private static double compute(String word1, String word2) {
		 	 
	  WS4JConfiguration.getInstance().setMFS(true);
	  double s = new WuPalmer(db).calcRelatednessOfWords(word1, word2);
	  return s;
	  }
}
