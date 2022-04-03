package DAO;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.semanticweb.owlapi.model.OWLException;
import org.semanticweb.owlapi.model.OWLObject;

import it.unibz.krdb.obda.owlrefplatform.owlapi3.QuestOWL;
import it.unibz.krdb.obda.owlrefplatform.owlapi3.QuestOWLConnection;
import it.unibz.krdb.obda.owlrefplatform.owlapi3.QuestOWLResultSet;
import it.unibz.krdb.obda.owlrefplatform.owlapi3.QuestOWLStatement;

public class InterfaceImpDAOntologie implements InterfaceDAOntologie {

	QuestOWLConnection conn= SingletonConnectionOntologie.getConnection();
	QuestOWL reasoner = SingletonConnectionOntologie.Reasoner();
	
	/****** Start UPDATE WORK *******/
   public  HashMap<String,ArrayList<String>> UpdateFF() throws OWLException, IOException {
	   
	   HashMap<String, ArrayList<String>> FFTokens = new HashMap<String, ArrayList<String>>();
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
				ArrayList<String> SLATokensList=GetSLATokensInstance(InstancesFF,FF);
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
   
   public  ArrayList<String> VerifyFF() throws OWLException, IOException {
		
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
	
  public ArrayList<String> GetSLATokensInstance(ArrayList<String> instancesFF, String FF) throws OWLException {
	 ArrayList<String> SLATokensList= new ArrayList<String>();
	for (int i = 0; i < instancesFF.size(); i++) {
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
	          	SLATokensList.add(SLATokens);

	            }  
			
	}
	return SLATokensList;
 }
 
  
   
}
