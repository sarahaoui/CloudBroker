package DAO;

import it.unibz.krdb.obda.exception.InvalidMappingException;
import it.unibz.krdb.obda.exception.InvalidPredicateDeclarationException;
import it.unibz.krdb.obda.io.ModelIOManager;
import it.unibz.krdb.obda.model.OBDADataFactory;
import it.unibz.krdb.obda.model.OBDAException;
import it.unibz.krdb.obda.model.OBDAModel;
import it.unibz.krdb.obda.model.impl.OBDADataFactoryImpl;
import it.unibz.krdb.obda.owlrefplatform.core.QuestConstants;
import it.unibz.krdb.obda.owlrefplatform.core.QuestPreferences;
import it.unibz.krdb.obda.owlrefplatform.owlapi3.QuestOWL;
import it.unibz.krdb.obda.owlrefplatform.owlapi3.QuestOWLConnection;
import it.unibz.krdb.obda.owlrefplatform.owlapi3.QuestOWLFactory;



import java.io.File;

import java.io.IOException;

import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.util.FileManager;
import org.semanticweb.owlapi.apibinding.OWLManager;

import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyCreationException;
import org.semanticweb.owlapi.model.OWLOntologyManager;
import org.semanticweb.owlapi.reasoner.SimpleConfiguration;

public class SingletonConnectionOntologie  {
	
	
	private static QuestOWL reasoner; 
	private static QuestOWLConnection conn;
	private static String DefaultNameSpace="http://www.livre.com/ontologies/livre.owl#" ;
	private static Model model=null;
	
	
	
	

    static  {
    	
    	final String owlFile = "D:/CloudFNF.owl";
    	final String obdaFile = "D:/CloudFNF.obda";
        OWLOntology ontology;
    	
        model=ModelFactory.createOntologyModel();  
		java.io.InputStream in=FileManager.get().open("D:/CloudFNF.owl");  
		if(in==null) {
			throw new IllegalArgumentException("fichier ontologie intruovable");  }
		else {
			model.read(in,DefaultNameSpace); 
		
		}
    	
    	
		try {
			ontology = loadOWLOntology(owlFile);
			 OBDAModel obdaModel = loadOBDA(obdaFile);
			 System.out.println("Done!");
		        /*** Prepare the configuration for the Quest instance ***/
				QuestPreferences preference = new QuestPreferences();
				preference.setCurrentValueOf(QuestPreferences.ABOX_MODE, QuestConstants.VIRTUAL);

				/*** Create the instance of Quest OWL reasoner ***/
				QuestOWLFactory factory = new QuestOWLFactory();
				factory.setOBDAController(obdaModel);
				factory.setPreferenceHolder(preference);
			    reasoner = (QuestOWL) factory.createReasoner(ontology, new SimpleConfiguration());

				/*** Prepare the data connection for querying ***/
				 conn = reasoner.getConnection();
				 
		} catch (OWLOntologyCreationException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InvalidPredicateDeclarationException e) {
			e.printStackTrace();
		} catch (InvalidMappingException e) {
			e.printStackTrace();
		} catch (OBDAException e) {
			e.printStackTrace();
		}
       
        
		
	}

    private static OBDAModel loadOBDA(String obdaFile) throws IOException, InvalidPredicateDeclarationException, InvalidMappingException {
   
        OBDADataFactory fac = OBDADataFactoryImpl.getInstance();
        OBDAModel obdaModel = fac.getOBDAModel();
        ModelIOManager ioManager = new ModelIOManager(obdaModel);
        ioManager.load(obdaFile);
        return obdaModel;
    }

  
    private static OWLOntology loadOWLOntology(String owlFile) throws OWLOntologyCreationException {
        OWLOntologyManager manager = OWLManager.createOWLOntologyManager();
        return manager.loadOntologyFromOntologyDocument(new File(owlFile));
    }
    
    public static QuestOWLConnection getConnection() {
		return conn;
	}
    
    public static QuestOWL Reasoner() {
		return reasoner;
	}
    
    public static Model getModel() {
		return model;
	}

}


