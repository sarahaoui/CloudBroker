package SMA.Agents;

import java.io.IOException;

import org.json.simple.JSONObject;
import org.semanticweb.owlapi.model.OWLException;

import DAO.InterfaceImpDAO;
import DAO.InterfaceImpDAOntologie;
import Metier.entities.QoS;
import Métier.UpdateKeyWords;
import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.UnreadableException;

public class AgentSelection extends Agent{
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
			QoS message = new QoS();
			try {
				message = (QoS)msg.getContentObject();
			} catch (UnreadableException e) {
				e.printStackTrace();
			}
			System.out.println("Accept Controller");
			JSONObject service=InterfaceImpDAOntologie.Selection(message);
			
			/*** Send Data TO Controler ***/
			ACLMessage totraitement= new ACLMessage(ACLMessage.INFORM);
			AID agent = new AID("ControlContainer-11",AID.ISLOCALNAME);
			try {
			totraitement.addReceiver(agent);
			totraitement.setContentObject(service);
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


