package DAO;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.semanticweb.owlapi.model.OWLException;

import Métier.BabelNetConnection;
import Métier.Similarity;
import Métier.TextRank;
import Métier.Tokenization;
import Métier.UpdateKeyWords;
import Métier.WordNetConnection;
import edu.smu.tspell.wordnet.NounSynset;
import edu.smu.tspell.wordnet.Synset;
import edu.smu.tspell.wordnet.SynsetType;
import edu.smu.tspell.wordnet.WordNetDatabase;

public class Test2 {

	public static void main(String[] args) {
		//String Description="Managing tax accounting";
		//String Description="Marketing by email";
		//String Description="Marketing mobile";
		//String Description="Human_Ressource_management";
		
		UpdateKeyWords up = new  UpdateKeyWords();
		try {
			up.UpdateKeywords();
		} catch (OWLException | IOException e) {
			e.printStackTrace();
		}
		
		
		
		
		
		
	}

}
