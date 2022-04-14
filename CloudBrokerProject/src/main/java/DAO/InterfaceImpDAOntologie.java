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
import org.json.simple.JSONArray;
import org.semanticweb.owlapi.model.OWLException;
import org.semanticweb.owlapi.model.OWLObject;
import org.semanticweb.owlapi.model.OWLOntology;

import Métier.Matching;
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
	  		+ "PREFIX dc: <http://www.protege.org/CloudFNF#>\r\n"
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
 

  public static void BFSbasedMatchingKeywords(String Node ,ArrayList<String>serviceSLATokens,JSONArray Dictionnary,ArrayList<String> VisitedNode,ArrayList<String> matchedChildren) throws OWLException {
	  
	  ArrayList<String> children= new ArrayList<>();
	  children= GetChildren(Node); 
	  VisitedNode.add(Node);  //to avoid the cyclic mode
	  Double Hrel=0.0;
	  for (String child : children) {
		if(!VisitedNode.contains(child)) {
			String UniqueKeyWords= GetKeywords(child, "Unique");
			if(!UniqueKeyWords.equals("")) {
				Hrel= Matching.RelativeEntropy(UniqueKeyWords, serviceSLATokens, child, Dictionnary);
				if(Hrel>=0.6)
					matchedChildren.add(child);
				String MergedKeywords = GetKeywords(child, "Merged");
				if(!MergedKeywords .equals("")) {
				Hrel=Matching.RelativeEntropy(MergedKeywords, serviceSLATokens, child, Dictionnary);
				if(Hrel>=0.6)
					BFSbasedMatchingKeywords(child, serviceSLATokens, Dictionnary, VisitedNode, matchedChildren);		
			}}
		}
	}
  }

}
  
   

