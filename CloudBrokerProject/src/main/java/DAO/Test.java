package DAO;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import org.semanticweb.owlapi.model.OWLException;




public class Test {

	public static void main(String[] args)  {
    InterfaceImpDAOntologie imp = new InterfaceImpDAOntologie();
		
		// Verify FF
        try {
        	 Map<String,ArrayList<String>> FFTokens= imp.UpdateFF();
        	System.out.println(FFTokens);
		} catch (OWLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
           
    
   
	}

}
