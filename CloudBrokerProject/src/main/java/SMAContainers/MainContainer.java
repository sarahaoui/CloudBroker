package SMAContainers;

import jade.core.Profile;
import jade.core.ProfileImpl;
import jade.core.Runtime;
import jade.util.ExtendedProperties;
import jade.util.leap.Properties;
import jade.wrapper.AgentContainer;
import jade.wrapper.AgentController;
import jade.wrapper.ControllerException;

public class MainContainer {

	public static void main(String[] args) {
		try {
			Runtime runtime =Runtime.instance();
			Properties properties = new ExtendedProperties();
			properties.setProperty(Profile.GUI, "true");
			Profile profile= new ProfileImpl(properties);
			AgentContainer mainContainer = runtime.createMainContainer(profile);	
			mainContainer.start();
		} catch (ControllerException e) {
			e.printStackTrace();
		}
		// Agent Utilisateur
		try {
			Runtime runtime= Runtime.instance();
			Profile profile = new ProfileImpl(false);
			profile.setParameter(Profile.MAIN_HOST, "localhost");
			AgentContainer agentContainer= runtime.createAgentContainer(profile);
			AgentController agentController= agentContainer.createNewAgent("AgentUtilisateur", "SMA.Agents.AgentUtilisateur",new Object[]{} );
			agentController.start();
		} catch (ControllerException e) {
			e.printStackTrace();
		}
		      // Agent Fournisseur
				try {
					Runtime runtime= Runtime.instance();
					Profile profile = new ProfileImpl(false);
					profile.setParameter(Profile.MAIN_HOST, "localhost");
					AgentContainer agentContainer= runtime.createAgentContainer(profile);
					AgentController agentController= agentContainer.createNewAgent("AgentFournisseur", "SMA.Agents.AgentFournisseur",new Object[]{} );
					agentController.start();
				} catch (ControllerException e) {
					e.printStackTrace();
				}
				
				// Agent Decouverte
				try {
					Runtime runtime= Runtime.instance();
					Profile profile = new ProfileImpl(false);
					profile.setParameter(Profile.MAIN_HOST, "localhost");
					AgentContainer agentContainer= runtime.createAgentContainer(profile);
					AgentController agentController= agentContainer.createNewAgent("AgentDecouverte", "SMA.Agents.AgentDecouverte",new Object[]{} );
					agentController.start();
				} catch (ControllerException e) {
					e.printStackTrace();
				}
				
				// Agent Evaluation
				try {
					Runtime runtime= Runtime.instance();
					Profile profile = new ProfileImpl(false);
					profile.setParameter(Profile.MAIN_HOST, "localhost");
					AgentContainer agentContainer= runtime.createAgentContainer(profile);
					AgentController agentController= agentContainer.createNewAgent("AgentEvaluation", "SMA.Agents.AgentEvaluation",new Object[]{} );
					agentController.start();
				} catch (ControllerException e) {
					e.printStackTrace();
				}
				
				// Agent Matching
				try {
					Runtime runtime= Runtime.instance();
					Profile profile = new ProfileImpl(false);
					profile.setParameter(Profile.MAIN_HOST, "localhost");
					AgentContainer agentContainer= runtime.createAgentContainer(profile);
					AgentController agentController= agentContainer.createNewAgent("AgentMatching", "SMA.Agents.AgentMatching",new Object[]{} );
					agentController.start();
				} catch (ControllerException e) {
					e.printStackTrace();
				}
				
				// Agent Selection
				try {
					Runtime runtime= Runtime.instance();
					Profile profile = new ProfileImpl(false);
					profile.setParameter(Profile.MAIN_HOST, "localhost");
					AgentContainer agentContainer= runtime.createAgentContainer(profile);
					AgentController agentController= agentContainer.createNewAgent("AgentSelection", "SMA.Agents.AgentSelection",new Object[]{} );
					agentController.start();
				} catch (ControllerException e) {
					e.printStackTrace();
				}
				
				// Agent Stockage
				try {
					Runtime runtime= Runtime.instance();
					Profile profile = new ProfileImpl(false);
					profile.setParameter(Profile.MAIN_HOST, "localhost");
					AgentContainer agentContainer= runtime.createAgentContainer(profile);
					AgentController agentController= agentContainer.createNewAgent("AgentStockage", "SMA.Agents.AgentStockage",new Object[]{} );
					agentController.start();
				} catch (ControllerException e) {
					e.printStackTrace();
				}
				
				// Agent TraitementAPI
				try {
					Runtime runtime= Runtime.instance();
					Profile profile = new ProfileImpl(false);
					profile.setParameter(Profile.MAIN_HOST, "localhost");
					AgentContainer agentContainer= runtime.createAgentContainer(profile);
					AgentController agentController= agentContainer.createNewAgent("AgentTraitementAPI", "SMA.Agents.AgentTraitementAPI",new Object[]{} );
					agentController.start();
				} catch (ControllerException e) {
					e.printStackTrace();
				}
				
				// Agent TraitementTexte
				try {
					Runtime runtime= Runtime.instance();
					Profile profile = new ProfileImpl(false);
					profile.setParameter(Profile.MAIN_HOST, "localhost");
					AgentContainer agentContainer= runtime.createAgentContainer(profile);
					AgentController agentController= agentContainer.createNewAgent("AgentTraitementTexte", "SMA.Agents.AgentTraitementTexte",new Object[]{} );
					agentController.start();
				} catch (ControllerException e) {
					e.printStackTrace();
				}
				
				// Agent Update
				try {
					Runtime runtime= Runtime.instance();
					Profile profile = new ProfileImpl(false);
					profile.setParameter(Profile.MAIN_HOST, "localhost");
					AgentContainer agentContainer= runtime.createAgentContainer(profile);
					AgentController agentController= agentContainer.createNewAgent("AgentUpdate", "SMA.Agents.AgentUpdate",new Object[]{} );
					agentController.start();
				} catch (ControllerException e) {
					e.printStackTrace();
				}
				
				

	}

}
