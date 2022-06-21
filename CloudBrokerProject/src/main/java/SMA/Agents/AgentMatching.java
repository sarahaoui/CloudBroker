package SMA.Agents;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

import DAO.InterfaceImpDAOntologie;
import Metier.entities.FFQuery;
import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.UnreadableException;

public class AgentMatching extends Agent{
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
			HashMap<String,ArrayList<String>> sysnsetTerm = new HashMap<String,ArrayList<String>>();
			try {
				sysnsetTerm = (HashMap<String,ArrayList<String>>)msg.getContentObject();
				System.out.println("Accept from FournisseurAgent get mots cles for similarité");
				} catch (UnreadableException e1) {
					e1.printStackTrace();
				}
			/*** Start Similarity **/
			ArrayList<String> VisitedNode= new ArrayList<String>();
			HashMap<String,Double> similarityChildren = new HashMap<String,Double>();
			
			InterfaceImpDAOntologie.GetDomaine("FF", sysnsetTerm, VisitedNode, similarityChildren);
			System.out.println(similarityChildren);
			System.out.println(Collections.max(similarityChildren.entrySet(),Comparator.comparingDouble(Map.Entry::getValue)).getKey());
			String Domaine = Collections.max(similarityChildren.entrySet(),Comparator.comparingDouble(Map.Entry::getValue)).getKey();

	       HashMap<String,Double> similarityFF = new HashMap<String,Double>();
	       InterfaceImpDAOntologie.GetFF(Domaine, sysnsetTerm, VisitedNode, similarityFF);
			System.out.println(similarityFF);
			String FFSelected=Collections.max(similarityFF.entrySet(),Comparator.comparingDouble(Map.Entry::getValue)).getKey();
		     System.out.println(FFSelected);
		     
		     
				/*** Send Data Agent Fournisseur ***/
				ACLMessage toFournisseur= new ACLMessage(ACLMessage.CONFIRM);
				AID agent = new AID("AgentFournisseur",AID.ISLOCALNAME);
				toFournisseur.addReceiver(agent);
				toFournisseur.setContent(FFSelected);
			   send(toFournisseur);
			System.out.println("Send to Agent Fournisseur");	
			break;
			
		case ACLMessage.AGREE:
			
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


