package SMA.Agents;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.semanticweb.owlapi.model.OWLException;

import DAO.InterfaceImpDAOntologie;
import Model.Model;
import Métier.UpdateKeyWords;
import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.UnreadableException;

public class AgentDecouverte extends Agent{
	@Override
	protected void setup() {
		System.out.println("Initialisation d'agent: "+this.getAID().getName());
		addBehaviour(new CyclicBehaviour(this)
		{
		public void action() {
		ACLMessage msg = receive();
		
		if (msg!=null){
		
		switch (msg.getPerformative()) {
		case ACLMessage.CFP:
			ArrayList<String> keyWords = new ArrayList<String>();
			try {
				keyWords = (ArrayList<String>)msg.getContentObject();
			} catch (UnreadableException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			System.out.println("Accept from AgentUtilisateur");
			/*** Get CloudDictionary ***/
	   	    System.out.println("************GetCloudDictionary**************");
	   	    JSONParser jsonParser = new JSONParser();
		    JSONArray Dictionnary = new JSONArray();
		
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
		
	   	 /*** Matching Keywords ***/
		    ArrayList<String> VisitedNode= new ArrayList<String>();
		    ArrayList<String> matchedChildren= new ArrayList<String>();
		    try {
				InterfaceImpDAOntologie.BFSbasedMatchingKeywords("FF", keyWords, Dictionnary, VisitedNode, matchedChildren);
			} catch (OWLException e) {
				e.printStackTrace();
			}	
		    System.out.println("FFS Matched:"+matchedChildren);
		    
		    /**************** Get And Ranking Services *********/
		    InterfaceImpDAOntologie imp = new InterfaceImpDAOntologie();
		    ArrayList<JSONObject> RankedCatServices = new ArrayList<JSONObject>();
			try {
				 RankedCatServices =	InterfaceImpDAOntologie.RankingServices(imp.ServicesRetrieval(matchedChildren), matchedChildren, Dictionnary);
				 System.out.println(":"+RankedCatServices);
				 Collections.reverse(RankedCatServices);

			} catch (OWLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try (FileWriter file = new FileWriter("C:\\Users\\pc-click\\Desktop\\services.json",false)) {
	            //We can write any JSONArray or JSONObject instance to the file
				
			    file.write(RankedCatServices.toString());
		        file.flush();	
	            file.close();
	 
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
			/*** Send Data TO Controler ***/
			ACLMessage totraitement= new ACLMessage(ACLMessage.INFORM);
			AID agent = new AID("ControlContainer-11",AID.ISLOCALNAME);
			try {
			totraitement.addReceiver(agent);
			totraitement.setContentObject(RankedCatServices);
			send(totraitement);
			System.out.println("Send to Controler");
			} catch (IOException e) {
				e.printStackTrace();
			}
			break;
			
		
			
				
		}
		
		
		}
		else block();
		}
		});
		
		
		
	}
	@Override
	protected void beforeMove() {   // before migration 
		
		System.out.println("Avant migration : "+this.getAID().getName());
		
	}
	
	@Override
	protected void afterMove() {    //after migration
		
		System.out.println("Apres migration : "+this.getAID().getName());
	}
	
	@Override
	protected void takeDown() {  // kill agent
		
		System.out.println("L'agent : "+this.getAID().getName()+"va mourir");
	}

}


