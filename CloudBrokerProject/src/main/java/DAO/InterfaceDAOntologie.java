package DAO;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.semanticweb.owlapi.model.OWLException;

public interface InterfaceDAOntologie {
	public  HashMap<String,ArrayList<ArrayList<String>>> UpdateFF() throws OWLException, IOException;
	public  ArrayList<String> VerifyFF() throws OWLException, IOException;
	public ArrayList<String>  FindRealFF(ArrayList<String>FFInstnace) throws OWLException;
	public ArrayList<ArrayList<String>> GetSLATokensInstance(ArrayList<String> instancesFF, String FF) throws OWLException;
    
}
