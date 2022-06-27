package SMA.Agents;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.json.simple.JSONObject;

import DAO.InterfaceImpDAOntologie;
import Metier.entities.DP;
import Metier.entities.QoS;
import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.UnreadableException;

public class AgentTraitementAPI extends Agent{
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
			JSONObject message = new JSONObject();
			try {
				message = (JSONObject)msg.getContentObject();
			} catch (UnreadableException e) {
				e.printStackTrace();
			}
			System.out.println("Accept Controller");
			Set<String> keys=  message.keySet();
			//System.out.println(keys);
			Iterator keysiter= keys.iterator();
            
			/*while(keysiter.hasNext()) {
				String key = keysiter.next().toString();
				if(message.get(key) instanceof JSONObject) {  // to JSONObject
					System.out.println("JSONObject:" +message.get(key));
				}else {
					System.out.println("Value: "+message.get(key));  // value type
				}	
			}*/
			ArrayList<String> Description = new ArrayList<String>();
			
			Description.add("Service_Title");
			Description.add("Location");
			Description.add("URL");
			Description.add("Service_Interface");
			Description.add("Version");
			Description.add("Intended_User");
			Description.add("Openness");
			Description.add("Payement_Model");
			Description.add("Short_Description");
			Description.add("License_Type");
			Description.add("price");
			Description.add("rating");
			Description.add("availability");
			Description.add("Individuals"); 
			Description.add("Organizations"); 
			JSONObject Service = new JSONObject();
			while(keysiter.hasNext()) {
				HashMap<String,Double> similarityChildren = new HashMap<String,Double>();
					String key = keysiter.next().toString();
					InterfaceImpDAOntologie.APISimilarity(key, Description,similarityChildren)	;	
					System.out.println(similarityChildren);
					System.out.println(key +" -->"+Collections.max(similarityChildren.entrySet(),Comparator.comparingDouble(Map.Entry::getValue)).getKey());
					String keyMatch = Collections.max(similarityChildren.entrySet(),Comparator.comparingDouble(Map.Entry::getValue)).getKey();	
					if(message.get(key) instanceof JSONObject) {  // to JSONObject
						System.out.println("JSONObject:" +message.get(key));
						JSONObject value = (JSONObject) message.get(key);
						Service.put(keyMatch, value);
					}else {
						String value = message.get(key).toString();
						Service.put(keyMatch, value);
					}
			}
			System.out.println(Service);
			/*** Send Data to Controller ***/
			ACLMessage toFournisseur= new ACLMessage(ACLMessage.ACCEPT_PROPOSAL);
			AID agent = new AID("ControlContainer-11",AID.ISLOCALNAME);
			toFournisseur.addReceiver(agent);
			try {
				toFournisseur.setContentObject(Service);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		   send(toFournisseur);
		System.out.println("Send to Agent Controller");	
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


