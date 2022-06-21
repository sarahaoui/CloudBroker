package DAO;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.jena.query.Query;
import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.query.QueryFactory;
import org.apache.jena.query.QuerySolution;
import org.apache.jena.query.ResultSet;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.RDFNode;
import org.apache.jena.update.UpdateAction;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.semanticweb.owlapi.model.OWLException;
import org.semanticweb.owlapi.model.OWLObject;
import org.semanticweb.owlapi.model.OWLOntology;

import Metier.entities.FFInstance;
import Métier.Matching;
import Métier.Similarity;
import Métier.SortedServices;
import Métier.WordNetConnection;
import edu.cmu.lti.lexical_db.ILexicalDatabase;
import edu.cmu.lti.lexical_db.NictWordNet;
import edu.cmu.lti.ws4j.impl.WuPalmer;
import edu.cmu.lti.ws4j.util.WS4JConfiguration;
import edu.smu.tspell.wordnet.WordNetDatabase;
import it.unibz.krdb.obda.model.OBDAModel;
import it.unibz.krdb.obda.owlrefplatform.owlapi3.QuestOWL;
import it.unibz.krdb.obda.owlrefplatform.owlapi3.QuestOWLConnection;
import it.unibz.krdb.obda.owlrefplatform.owlapi3.QuestOWLResultSet;
import it.unibz.krdb.obda.owlrefplatform.owlapi3.QuestOWLStatement;

public class InterfaceImpDAOntologie implements InterfaceDAOntologie {

	static QuestOWLConnection conn= SingletonConnectionOntologie.getConnection();
	static QuestOWL reasoner = SingletonConnectionOntologie.Reasoner();
	static Model model= SingletonConnectionOntologie.getModel();
	private static ILexicalDatabase db = new NictWordNet();
	
	
	/****** Start UPDATE WORK *******/
   public  HashMap<String,ArrayList<ArrayList<String>>> UpdateFF() throws OWLException, IOException {
	   
	   HashMap<String,ArrayList<ArrayList<String>>> FFTokens = new HashMap<String,ArrayList<ArrayList<String>>>();
	   ArrayList<String>FFInstnaces= VerifyFF(); 
	   ArrayList<String>ExisteFFList= FindRealFF(FFInstnaces);  
	   
	  
	   QuestOWLStatement st = conn.createStatement();
	   try {
	   for (int i = 0; i < ExisteFFList.size(); i++) {
		   ArrayList<String> InstancesFF= new ArrayList<String>();
		  
	        String sparqlQuery = "PREFIX dc: <http://www.protege.org/CloudFNF#> \r\n"
	        		+ "SELECT *\r\n"
	        		+ "    WHERE { ?instURI rdf:type dc:"+ExisteFFList.get(i)+".\r\n"
	        		+ "                   }";
	        	QuestOWLResultSet res = st.executeTuple(sparqlQuery); 
	            while (res.nextRow()) {
	               
	            OWLObject instURI=	res.getOWLObject("instURI");	
	          	String URI = instURI.toString();
	          	String URI2=instURI.toString();
	          	URI = URI.substring(URI.indexOf("#")+1);
				URI= URI.substring(0,URI.indexOf("ID_"));
				if(URI.equals(ExisteFFList.get(i))) {
				URI2 = URI2.substring(URI2.indexOf("#")+1);
				URI2= URI2.substring(0,URI2.indexOf(">"));
				InstancesFF.add(URI2);
	            String FF=ExisteFFList.get(i);
	            System.out.println(FF);
	            System.out.println("************");
	            System.out.println(InstancesFF);
	            ArrayList<ArrayList<String>> SLATokensList=GetSLATokensInstance(InstancesFF,FF);
				FFTokens.put(FF, SLATokensList);
	            }}	
			}
	 }
	   finally {
		   if (st != null && !st.isClosed()) {
				st.close();
			}
				
				 if (!conn.isClosed()) {
						conn.close();
					}
					reasoner.dispose();
	}
	  
	return FFTokens;
	   
   }
   
   /*** VerifyFF ***/
   public ArrayList<String> VerifyFF() throws OWLException, IOException {
		
	    ArrayList<String> FFInstnaces= new ArrayList<String>(); 
		QuestOWLStatement st = conn.createStatement();
       String sparqlQuery = "PREFIX dc: <http://www.protege.org/CloudFNF#> \r\n"
	    		+ "SELECT *\r\n"
	    		+ "   WHERE { ?instURI rdf:type dc:OFFs.\r\n"
	    		+ "                     \r\n"
	    		+ "                   }";

       try {
       	QuestOWLResultSet res = st.executeTuple(sparqlQuery); 
           while (res.nextRow()) {    
           OWLObject instURI=	res.getOWLObject("instURI");	
         	String instURIString = instURI.toString();
            
         	 FFInstnaces.add(instURIString);
           }
           return FFInstnaces;
	
		} finally {
			if (st != null && !st.isClosed()) {
				st.close();
			}
			if (!conn.isClosed()) {
				conn.close();
			}
			reasoner.dispose();
			
		}
       
	}
	
    /*** FindRealFF ***/
	public ArrayList<String>  FindRealFF(ArrayList<String>FFInstnace) throws OWLException {
		
		ArrayList<String>ExisteFFList = new ArrayList<String>();
		for (int i = 0; i < FFInstnace.size(); i++) {
			String URI= FFInstnace.get(i);
			URI = URI.substring(URI.indexOf("#")+1);
			URI= URI.substring(0,URI.indexOf("ID_"));
			if(!ExisteFFList.contains(URI)) {
				ExisteFFList.add(URI);
			}
		}
		return ExisteFFList;
	}

  /*** Get SLA Tokens ***/
  public ArrayList<ArrayList<String>> GetSLATokensInstance(ArrayList<String> instancesFF, String FF) throws OWLException {
	  ArrayList<ArrayList<String>> SLATokensList= new ArrayList<ArrayList<String>>();
	  
	for (int i = 0; i < instancesFF.size(); i++) {
		ArrayList<String>Tokens=new ArrayList<String>();
		   QuestOWLStatement st = conn.createStatement();
	        String sparqlQuery = "PREFIX dc: <http://www.protege.org/CloudFNF#> \r\n"
	        		+ "SELECT ?SLATokens\r\n"
	        		+ "   WHERE { dc:"+instancesFF.get(i)+" rdf:type dc:"+FF+";\r\n"
	        		+ "                dc:DeployementParameters_DP_NFFsID ?DP .\r\n"
	        		+ "           ?DP dc:SLATokens ?SLATokens .\r\n"
	        		+ "                     \r\n"
	        		+ "                   }";

	        
	        	QuestOWLResultSet res = st.executeTuple(sparqlQuery);
	        	
	            while (res.nextRow()) {
	               
	            OWLObject instURI=	res.getOWLObject("SLATokens");	
	          	String SLATokens = instURI.toString();
	          	SLATokens = SLATokens.substring(SLATokens.indexOf('"')+1);
	          	SLATokens= SLATokens.substring(0,SLATokens.indexOf('"'));
	          	 String[] parts= SLATokens.split(",");
	          	 for (int j = 0; j < parts.length; j++) {
	          		 Tokens.add(parts[j]);
	          		
				}
	          	

	            }
	            SLATokensList.add(Tokens);
			
	}
	return SLATokensList;
 }

  /*** UpdateKeywords ***/
  public static void UpdateKeyWords(String key, String properties,String Type) throws OWLException {
	  
	  String sparqlQuery = "PREFIX dc: <http://www.protege.org/CloudFNF#> \r\n"
	       		+ "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\r\n"
	       		+ "PREFIX owl: <http://www.w3.org/2002/07/owl#>\r\n"
	       		+ "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\r\n"
	       		+ "DELETE {dc:"+key+" dc:isDefinedBy"+Type+"Keywords ?o.}"
	       		+"INSERT { dc:"+key+" dc:isDefinedBy"+Type+"Keywords \""+properties+"\".}"
	 
	       		+ "WHERE {"
	       		+ "dc:"+key+" dc:isDefinedBy"+Type+"Keywords ?o.}";

	  
	              UpdateAction.parseExecute(sparqlQuery, model);
	  		    try {
	  	 			model.write(new FileOutputStream("D:/CloudFNF.owl"), "RDF/XML");
	  	 			
	  	 		} catch (FileNotFoundException e) {
	  	 			e.printStackTrace();
	  	 		}
	              
		  	        	
  }
  
  /*** GetProperties ***/
  public static String GetKeywords(String Key ,String Type) throws OWLException {
	  String keywordString="";
	        String sparqlQuery = "PREFIX dc: <http://www.protege.org/CloudFNF#> \r\n"
	        		+ "SELECT ?keywords \r\n"
	        		+ "\r\n"
	        		+ "    WHERE { dc:"+Key+" dc:isDefinedBy"+Type+"Keywords ?keywords.}";             
	  
	        Query query= QueryFactory.create(sparqlQuery);  
			QueryExecution queryExecution= QueryExecutionFactory.create(query,model);  
			 
			try {
				ResultSet response=queryExecution.execSelect(); 
				while(response.hasNext()) {
					QuerySolution sol= response.nextSolution();
					RDFNode keyword=sol.get("?keywords");
					if(keyword==null ){
						System.out.println("there are no data");
					}else {
						keywordString= keyword.toString();
						
					}
					}}
				finally {
					
					queryExecution.close();
				}
			return keywordString;
  }	
  
  /*** GetSubClasses ***/
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
  
  /*** DFS Based Merging Keywords ***/
  public static void DFSbasedMergingKeyWords(String Node ,ArrayList<String> VisitedNode) throws OWLException{
	  
	  ArrayList<String> children= new ArrayList<>();
	  children= GetChildren(Node);
	  VisitedNode.add(Node);   //to avoid the cyclic mode
	  
	  for (String child : children) {
		
		 if(!VisitedNode.contains(child)) 
			  DFSbasedMergingKeyWords(child,VisitedNode);
		 String NodeKeyWords= GetKeywords(Node, "Merged");
		 String ChildKeyWords= GetKeywords(child, "Merged");
		 String mergedKeywords= Merge(NodeKeyWords,ChildKeyWords);
         
		  String sparqlQuery = "PREFIX dc: <http://www.protege.org/CloudFNF#> \r\n"
		       		+ "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\r\n"
		       		+ "PREFIX owl: <http://www.w3.org/2002/07/owl#>\r\n"
		       		+ "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\r\n"
		       		+ "DELETE {dc:"+Node+" dc:isDefinedByMergedKeywords ?o.}"
		       		+"INSERT { dc:"+Node+" dc:isDefinedByMergedKeywords \""+ mergedKeywords+"\".}"
		 
		       		+ "WHERE {"
		       		+ "dc:"+Node+" dc:isDefinedByMergedKeywords ?o.}";

		  
		              UpdateAction.parseExecute(sparqlQuery, model);
		  		    try {
		  	 			model.write(new FileOutputStream("D:/CloudFNF.owl"), "RDF/XML");
		  	 			
		  	 		} catch (FileNotFoundException e) {
		  	 			e.printStackTrace();
		  	 		}
		  
		  
	}
	  
	  
	  
  }

 /*** Merge ***/
 private static String Merge(String nodeKeyWords, String childKeyWords) {
	String mergedKeywords="";
	if(nodeKeyWords.equals("") && childKeyWords.equals("")) {
		mergedKeywords="";
	}else if(nodeKeyWords.equals("")) {
		mergedKeywords=childKeyWords;
	}else if(childKeyWords.equals("")) {
		mergedKeywords=nodeKeyWords;
	} else{
		mergedKeywords= nodeKeyWords+","+childKeyWords;
	}
	return mergedKeywords;
}
 
  /*** BFS Based Matching Keywords ***/
  public static void BFSbasedMatchingKeywords(String Node ,ArrayList<String>serviceSLATokens,JSONArray Dictionnary,ArrayList<String> VisitedNode,ArrayList<String> matchedChildren) throws OWLException {
	  
	  ArrayList<String> children= new ArrayList<>();
	  children= GetChildren(Node); 
	  VisitedNode.add(Node);  //to avoid the cyclic mode
	  Double Hrel=0.0;
	  for (String child : children) {
		if(!VisitedNode.contains(child)) {
			String UniqueKeyWords= GetKeywords(child, "Unique");
			System.out.println("Child: "+child+" Unique: "+UniqueKeyWords);
			if(!UniqueKeyWords.equals("")) {
				Hrel= Matching.RelativeEntropy(UniqueKeyWords, serviceSLATokens, child, Dictionnary);
				System.out.println(Hrel);
				if(Hrel>=0.6)
					matchedChildren.add(child);}
				String MergedKeywords = GetKeywords(child, "Merged");
				System.out.println("Child: "+child+" Merged: "+MergedKeywords);
				if(!MergedKeywords .equals("")) {
				Hrel=Matching.RelativeEntropy(MergedKeywords, serviceSLATokens, child, Dictionnary);
				System.out.println(Hrel);
				if(Hrel>=0.6)
					BFSbasedMatchingKeywords(child, serviceSLATokens, Dictionnary, VisitedNode, matchedChildren);		
			}
				
		}
	}
  }
  
  /*** Services Retrieval ***/ 
  public  JSONObject ServicesRetrieval (ArrayList<String>RequiredFFsList) throws OWLException {
	 
	  ArrayList <String> ExistFFsList = new ArrayList<String>();
	  ArrayList <String> InstancesFF = new ArrayList<String>();
	  for (String FFname : RequiredFFsList) {
		  
		  QuestOWLStatement st = conn.createStatement();
		  String sparqlQuery = "PREFIX dc: <http://www.protege.org/CloudFNF#> \r\n"
	        		+ "SELECT *\r\n"
	        		+ "    WHERE { ?instURI rdf:type dc:"+FFname+".\r\n"
	        		+ "                   }";
	        	QuestOWLResultSet res = st.executeTuple(sparqlQuery); 
	            while (res.nextRow()) {   
	            OWLObject instURI=	res.getOWLObject("instURI");	
	          	String URI = instURI.toString();
	          	String URI2 = instURI.toString();
	          	URI2 = URI2.substring(URI2.indexOf("#")+1);
				URI2= URI2.substring(0,URI2.indexOf("ID_"));
				if(URI2.equals(FFname)) {
				InstancesFF.add(URI);}
	            } 
	            ExistFFsList=FindRealFF(InstancesFF); 
	}
	  return queryCompositionAndExecution(ExistFFsList);
  }

   /*** QueryComposition And Execution ***/
   public JSONObject queryCompositionAndExecution(ArrayList<String> existFFsList) throws OWLException {
	   JSONObject CategorizedServices = new JSONObject ();
	   for (String FF : existFFsList) { 
		   JSONArray arr = new JSONArray();
		   JSONObject OneCategory=new JSONObject();
		   QuestOWLStatement st = conn.createStatement();
			  String sparqlQuery = "PREFIX dc: <http://www.protege.org/CloudFNF#> \r\n"
			  		+ "SELECT *\r\n"
			  		+ "\r\n"
			  		+ "{?instURI rdf:type dc:"+FF+" ;\r\n"
			  		+ "                   dc:"+FF+"_NFFsID ?DT ;\r\n"
			  		+ "                   dc:DeployementParameters_DP_NFFsID ?DP ;\r\n"
			  		+ "                   dc:RT_NFFsID ?QoS.}";
		        	QuestOWLResultSet res = st.executeTuple(sparqlQuery); 
		        	
		            while (res.nextRow()) { 
		            FFInstance instance = new FFInstance();
		            OWLObject instURI=	res.getOWLObject("instURI");	
		          	String URI = instURI.toString();
		          	OWLObject instDT=	res.getOWLObject("DT");	
		          	String DT = instDT.toString();
		          	OWLObject instDP=	res.getOWLObject("DP");	
		          	String DP = instDP.toString();
		          	OWLObject instQoS=	res.getOWLObject("QoS");	
		          	String QoS = instQoS.toString();
		          	instance.setInstURI(URI);
		          	instance.setDT_URI(DT);
		          	instance.setDP_URI(DP);
		          	instance.setQoS_URI(QoS);
		            
		            JSONObject OneService = new JSONObject();
		            JSONObject DP_NFFs = new JSONObject();
		            JSONObject DT_NFFs=new JSONObject();;
		            
		            /********* General Information **************/
		            String sparqlQueryDP = "PREFIX dc: <http://www.protege.org/CloudFNF#> \r\n"
		            		+ "SELECT *\r\n"
		            		+ "    WHERE {        \r\n"
		            		+ ""+instance.getDP_URI()+"  rdf:type dc:DeploymentParameters_DP_NFFs;\r\n"
		            		+ "    ?property ?object.\r\n"
		            		+ "                   \r\n"
		            		+ "       FILTER(?property != rdf:type ).    \r\n"
		            		+ " \r\n"
		            		+ "                 }";
			String	Title= CollectData(DP_NFFs,"DeploymentParameters_DP_NFFs",sparqlQueryDP);
				       OneService.put("General Information", DP_NFFs);
				      
				     /********* Exclusive NFFs Information **************/
				       String sparqlQueryDT = "PREFIX dc: <http://www.protege.org/CloudFNF#> \r\n"
				       		+ "SELECT *\r\n"
				       		+ "WHERE {    \r\n"
				       		+ ""+instance.getDT_URI()+" rdf:type dc:"+FF+"_NFFs ;\r\n"
				       		+ " ?property ?object.\r\n"
				       		+ "       }";
					       CollectData(DT_NFFs,FF+"_NFFs",sparqlQueryDT);
					       OneService.put("Exclusive Information", DT_NFFs);
					       OneCategory.put(Title, OneService);
					       
		            }
		            CategorizedServices.put(FF, OneCategory);  }
     System.out.println(CategorizedServices);
	 return CategorizedServices;
   }
  public String CollectData(JSONObject postObj, String conceptname, String sparqlQuery) throws OWLException {
	  QuestOWLStatement st = conn.createStatement();
	  String Title ="";
	  QuestOWLResultSet res = st.executeTuple(sparqlQuery); 
      while (res.nextRow()) {   
      OWLObject instP=	res.getOWLObject("property");	
    	String Property = instP.toString();
    	if(!Property.equals("rdf:type")) {
    	Property = Property.substring(Property.indexOf("#")+1);
    	Property= Property.substring(0,Property.indexOf(">"));
    	OWLObject instO=res.getOWLObject("object");	
    	String Object = instO.toString();
    	
    	if(!Property.endsWith("ID")) {
    		Object = Object.substring(Object.indexOf("\"")+1);
    		Object= Object.substring(0,Object.indexOf("\""));
    		if(Property.equals("ServiceTitle")) {
    			Title=Object;
    		}
    		
    		postObj.put(Property, Object);
    		
    	}else if(Property.endsWith("ID") && !Property.equals(conceptname+"ID")) {
    		String property = Property.substring(0,Property.indexOf("ID"));
    		String Query ="PREFIX dc: <http://www.protege.org/CloudFNF#> \r\n"
    				+ "SELECT *\r\n"
    				+ "    WHERE {        \r\n"
    				+ ""+Object+"  rdf:type dc:"+property+";\r\n"
    				+ "    ?property ?object.\r\n"
    				+ "                   \r\n"
    				+ "                 }";
    		JSONObject tempObj= new JSONObject();
    		CollectData(tempObj, property, Query);		
    		postObj.put(property, tempObj);
    	}}
      }
   return Title;   
  }

  public static ArrayList<JSONObject> RankingServices(JSONObject CatedServices, ArrayList<String> RequiredFFsList,JSONArray Dictionnary) throws OWLException {
	  JSONObject RankedCatServices = new JSONObject();
	  JSONObject rankedServices= new JSONObject();
	  ArrayList<JSONObject> RankedSortServices = new ArrayList<JSONObject>();
	  for (Object cat : CatedServices.keySet()) {
		  JSONObject item= (JSONObject) CatedServices.get(cat);
		 Set<String>ServicesTitle= item.keySet();
		 Double THrel=0.0;
		 for (String Title : ServicesTitle) {
			JSONObject service= (JSONObject) item.get(Title);
			JSONObject GeneralInfo= (JSONObject) service.get("General Information");
			String SLATokens= (String) GeneralInfo.get("SLATokens");
			String[] termsString = SLATokens.split(",");
			ArrayList<String> terms= new ArrayList<String>(Arrays.asList(termsString));
			if(rankedServices.get(Title)==null) {
				String Keywords= GetKeywords(cat.toString(), "Unique");
				Double Hrel= Matching.RelativeEntropy(Keywords,terms,cat.toString(),Dictionnary);
				THrel= THrel+(Hrel * Math.log(Hrel))/Math.log(2);   // RequiredFFsList.size() :if required list size= 1 THrel= infinity xD
				THrel= -THrel;
				Double THrelDF=Double.parseDouble(new DecimalFormat("##.###").format(THrel).replace(",", ".")) ;
				service.put("THrel", THrelDF);
				service.put("FF", cat.toString());
			    rankedServices.put(Title, service);
			}
		}
		 RankedCatServices.put(cat.toString(), rankedServices); 
		 
	}
	  
	     RankedSortServices= SortedServices.sortBasedOnTotalHrel(RankedCatServices);
	  return RankedSortServices;
  }
  
  /**** Calcule Similarity ***/
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
  
   

