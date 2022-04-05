package Métier;


import java.io.IOException;

import org.semanticweb.owlapi.model.OWLException;

public class Test2 {

	public static void main(String[] args) {
		UpdateKeyWords up = new UpdateKeyWords();
		try {
			up.UpdateKeywords();
		} catch (OWLException | IOException e) {
			e.printStackTrace();
		}
		
	}
}
