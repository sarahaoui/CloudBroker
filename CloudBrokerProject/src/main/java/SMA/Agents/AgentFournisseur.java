package SMA.Agents;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import Metier.entities.FFQuery;
import Métier.TextRank;
import Métier.TextRank2;
import Métier.WordNetConnection;
import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.UnreadableException;
import jade.wrapper.gateway.GatewayAgent;

public class AgentFournisseur extends GatewayAgent{
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
			FFQuery message=new FFQuery();
			try {
				message = (FFQuery)msg.getContentObject();
				System.out.println("Accept from controller");
				} catch (UnreadableException e1) {
					e1.printStackTrace();
				}
			
			ArrayList<String> keywords = new ArrayList<String>();
			HashMap<String,ArrayList<String>> sysnsetTerm = new HashMap<String,ArrayList<String>>();
			/*** Text Rank ***/
			try {
				keywords=TextRank2.sentenceDetect(message.getFF());
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			System.out.println(keywords);
		
			/*** Search for Simple or complex phrases ***/
			for (int i = 0; i < keywords.size(); i++) {
				
            /** Get Synsets Using BabelNet***/

			ArrayList<String> synonyms = WordNetConnection.Synonyms(keywords.get(i));
	        sysnsetTerm.put(keywords.get(i), synonyms) ;     
			}
			System.out.println(sysnsetTerm);
			
			
				/*** Send Data TO Agent Matching ***/
				ACLMessage totraitement= new ACLMessage(ACLMessage.CFP);
				AID agent = new AID("AgentMatching",AID.ISLOCALNAME);
				try {
				totraitement.addReceiver(agent);
				totraitement.setContentObject(sysnsetTerm);
				send(totraitement);
				System.out.println("Send to AgentMatching");
				} catch (IOException e) {
					e.printStackTrace();
				}	
			break;
			
		case ACLMessage.CONFIRM:
			
			String FFAsocie = (String)msg.getContent();
			System.out.println("Accept from Agent Matching");
			/*** Send Data TO Controller ***/
			ACLMessage toController= new ACLMessage(ACLMessage.CFP);
			AID agent2 = new AID("ControlContainer-11",AID.ISLOCALNAME);
			toController.addReceiver(agent2);
			toController.setContent(FFAsocie);
            send(toController);
            System.out.println("Send to Controller");	
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


