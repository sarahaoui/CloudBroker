package DAO;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.apache.jena.query.Query;
import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.query.QueryFactory;
import org.apache.jena.query.QuerySolution;
import org.apache.jena.query.ResultSet;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.RDFNode;
import org.apache.jena.update.UpdateAction;
import org.semanticweb.owlapi.model.OWLException;
import org.semanticweb.owlapi.model.OWLObject;
import org.semanticweb.owlapi.model.OWLOntology;

import it.unibz.krdb.obda.model.OBDAModel;
import it.unibz.krdb.obda.owlrefplatform.owlapi3.QuestOWL;
import it.unibz.krdb.obda.owlrefplatform.owlapi3.QuestOWLConnection;
import it.unibz.krdb.obda.owlrefplatform.owlapi3.QuestOWLResultSet;
import it.unibz.krdb.obda.owlrefplatform.owlapi3.QuestOWLStatement;

public class InterfaceImpDAOntologie implements InterfaceDAOntologie {

	static QuestOWLConnection conn= SingletonConnectionOntologie.getConnection();
	static QuestOWL reasoner = SingletonConnectionOntologie.Reasoner();
	static Model model= SingletonConnectionOntologie.getModel();
	
	
	/****** Start UPDATE WORK *******/
   public  HashMap<String,ArrayList<ArrayList<String>>> UpdateFF() throws OWLException, IOException {
	   
	   HashMap<String,ArrayList<ArrayList<String>>> FFTokens = new HashMap<String,ArrayList<ArrayList<String>>>();
	   ArrayList<String>FFInstnaces= VerifyFF(); 
	   System.out.println(FFInstnaces);
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
	          	URI = URI.substring(URI.indexOf("#")+1);
	          	URI= URI.substring(0,URI.indexOf(">"));
				InstancesFF.add(URI);
	            String FF=ExisteFFList.get(i);
	            System.out.println(FF);
	            System.out.println("************");
	            System.out.println(InstancesFF);
	            ArrayList<ArrayList<String>> SLATokensList=GetSLATokensInstance(InstancesFF,FF);
				FFTokens.put(FF, SLATokensList);
	            }
			
				
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
  public static void GetProprties(String Key) throws OWLException {
	        String sparqlQuery = "PREFIX dc: <http://www.protege.org/CloudFNF#> \r\n"
	        		+ "SELECT ?Unique ?Merged \r\n"
	        		+ "\r\n"
	        		+ "    WHERE { dc:"+Key+" dc:isDefinedByUniqueKeywords ?Unique;\r\n"
	        				+ "    dc:isDefinedByUniqueKeywords ?Merged."
	        		+ "                      }";
	  
	        Query query= QueryFactory.create(sparqlQuery);  
			QueryExecution queryExecution= QueryExecutionFactory.create(query,model);  
			 
			try {
				ResultSet response=queryExecution.execSelect(); 
				while(response.hasNext()) {
					QuerySolution sol= response.nextSolution();
					RDFNode Unique=sol.get("?Unique");
					RDFNode Merged=sol.get("?Merged");
					if(Unique==null || Merged ==null){
						System.out.println("there are no data");
					}else {
						String UniqueString= Unique.toString();
						String MergedString= Merged.toString();
						System.out.println("Unique: "+UniqueString+ " Merged: "+MergedString);
					}
					}}
				finally {
					
					queryExecution.close();
				}
  }	
}
  
   

