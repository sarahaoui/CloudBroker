package SMA.Agents;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import Metier.entities.FFQuery;
import Métier.TextRank2;
import Métier.WordNetConnection;
import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.UnreadableException;
import jade.wrapper.gateway.GatewayAgent;

public class AgentUtilisateur extends GatewayAgent{
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
			String Description="";
			Description = (String)msg.getContent();
			System.out.println("Accept from controller");
			
				/*** Send Query TO AgentTraitementTexte***/
				ACLMessage totraitement= new ACLMessage(ACLMessage.REQUEST);
				AID agent = new AID("AgentTraitementTexte",AID.ISLOCALNAME);
			totraitement.addReceiver(agent);
			totraitement.setContent(Description);
			send(totraitement);
			System.out.println("Send to AgentTraitementTexte");	
			break;
			
		case ACLMessage.CONFIRM:
			
			ArrayList<String> keyWords = new ArrayList<String>();
			try {
				keyWords = (ArrayList<String>)msg.getContentObject();
			} catch (UnreadableException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			System.out.println("Accept from TraitementTexte");
			/*** Send Data TO Decouverte ***/
			ACLMessage todeco= new ACLMessage(ACLMessage.CFP);
			AID agent2 = new AID("AgentDecouverte",AID.ISLOCALNAME);
			todeco.addReceiver(agent2);
			try {
				todeco.setContentObject(keyWords);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            send(todeco);
            System.out.println("Send to Decouverte");	
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

