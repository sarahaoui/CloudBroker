package DAO;

import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.util.FileManager;


public class SingletonConnectionOntoS {
	private static String DefaultNameSpace="http://www.protege.org/Cloud#" ;
	private static Model model=null;
	
	static  {
	model=ModelFactory.createOntologyModel();  
	java.io.InputStream in=FileManager.get().open("D:/CloudSimilarity.owl");  
	if(in==null) {
		throw new IllegalArgumentException("fichier ontologie intruovable");  }
	else {
		model.read(in,DefaultNameSpace); 
	
	}}
	
    
    
    public static Model getModel() {
		return model;
	}
    public static String getDefaultNameSpace() {
		return DefaultNameSpace;
	}
}
