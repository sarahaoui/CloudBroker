package SMA.Agents;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import Metier.entities.FFQuery;
import Métier.BabelNetConnection;
import Métier.TextRank;
import Métier.Tokenization;
import Métier.WordNetConnection;
import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.UnreadableException;

public class AgentTraitementTexte extends Agent{
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
			String message="";
			message = (String)msg.getContent();
			System.out.println("Accept from Controler get FF");
			
			ArrayList<String> keywords = new ArrayList<String>();
			ArrayList<String> Tokens = new ArrayList<String>();
			ArrayList<String> FinalKeywords = new ArrayList<String>();


			try {
				/*** Text Rank ***/
				keywords=TextRank.sentenceDetect(message);
				System.out.println("Keywords: "+keywords);
				
				/*** Babelnet Elimination ***/
				BabelNetConnection.Connection(keywords);
				
				/*** Tokenization And POS ***/
				Tokens= Tokenization.TokanizationTag(keywords);
				
				/*** WordNet ***/
				WordNetConnection.WordnetConnection(Tokens);
				Set<String> set= new HashSet<>(Tokens);
				Tokens.clear();
				Tokens.addAll(set);
				
				/*** Babelnet Verification ***/
				FinalKeywords=BabelNetConnection.Connection2(Tokens);
				System.out.println("FinalKeywords: ");
				System.out.println(FinalKeywords);
			} catch (IOException e) {
				e.printStackTrace();
			}
			/*** Send Data TO Controller ***/
			ACLMessage toController= new ACLMessage(ACLMessage.CFP);
			AID agent2 = new AID("ControlContainer-11",AID.ISLOCALNAME);
			toController.addReceiver(agent2);
			try {
				toController.setContentObject(FinalKeywords);
			} catch (IOException e) {
				e.printStackTrace();
			}
            send(toController);
            System.out.println("Send to Controller");
			break;
			
		case ACLMessage.REQUEST:
			String message2="";
			message2 = (String)msg.getContent();
			System.out.println("Accept from Controler get FF");
			
			ArrayList<String> keywords2 = new ArrayList<String>();
			ArrayList<String> Tokens2 = new ArrayList<String>();
			ArrayList<String> FinalKeywords2 = new ArrayList<String>();


			try {
				/*** Text Rank ***/
				keywords2=TextRank.sentenceDetect(message2);
				System.out.println("Keywords: "+keywords2);
				
				/*** Babelnet Elimination ***/
				BabelNetConnection.Connection(keywords2);
				
				/*** Tokenization And POS ***/
				Tokens2= Tokenization.TokanizationTag(keywords2);
				
				/*** WordNet ***/
				WordNetConnection.WordnetConnection(Tokens2);
				Set<String> set= new HashSet<>(Tokens2);
				Tokens2.clear();
				Tokens2.addAll(set);
				
				/*** Babelnet Verification ***/
				FinalKeywords2=BabelNetConnection.Connection2(Tokens2);
				System.out.println("FinalKeywords: ");
				System.out.println(FinalKeywords2);
			} catch (IOException e) {
				e.printStackTrace();
			}
			/*** Send Data TO AgentUtilisateur ***/
			ACLMessage touser= new ACLMessage(ACLMessage.CONFIRM);
			AID agent = new AID("AgentUtilisateur",AID.ISLOCALNAME);
			touser.addReceiver(agent);
			try {
				touser.setContentObject(FinalKeywords2);
			} catch (IOException e) {
				e.printStackTrace();
			}
            send(touser);
            System.out.println("Send to AgentUtilisateur");
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


