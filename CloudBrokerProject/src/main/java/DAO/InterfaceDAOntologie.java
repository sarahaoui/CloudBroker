package DAO;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import org.semanticweb.owlapi.model.OWLException;

public interface InterfaceDAOntologie {
	public  Map<String,ArrayList<String>> UpdateFF() throws OWLException, IOException;
	public  ArrayList<String> VerifyFF() throws OWLException, IOException;
	public ArrayList<String>  FindRealFF(ArrayList<String>FFInstnace) throws OWLException;
	public ArrayList<String> GetSLATokensInstance(ArrayList<String> instancesFF, String FF) throws OWLException;

}
