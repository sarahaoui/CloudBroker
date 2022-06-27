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
import Métier.TextRank2;
import Métier.Tokenization;
import Métier.UpdateKeyWords;
import Métier.WordNetConnection;
import edu.smu.tspell.wordnet.NounSynset;
import edu.smu.tspell.wordnet.Synset;
import edu.smu.tspell.wordnet.SynsetType;
import edu.smu.tspell.wordnet.WordNetDatabase;

public class Test2 {

	public static void main(String[] args) {
		//String Description="";
		//String Description="Marketing by email";
		//String Description="Marketing mobile";
		//String Description="Human_Ressource_management";
		 
		
		
		/*I want a service that helps me to get the numbers right by preparing tax accounting calculations, researching technical issues and reviewing transactions,
		 *  accounting entries and adjustments that may have tax consequences.*/
		
		String Description="database modeling";
	    
			System.setProperty("wordnet.database.dir", "C:\\Users\\pc-click\\Desktop\\PFE Ressources\\WordNet-3.0\\dict");
	        WordNetDatabase database = WordNetDatabase.getFileInstance();

	        ArrayList<String> keywords = new ArrayList<String>();
			HashMap<String,ArrayList<String>> sysnsetTerm = new HashMap<String,ArrayList<String>>();
			/*** Text Rank ***/
			try {
				keywords=TextRank2.sentenceDetect(Description);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			System.out.println(keywords);
		
			/*** Search for Simple or complex phrases ***/
			for (int i = 0; i < keywords.size(); i++) {
				
            /** Get Synsets Using BabelNet***/

			ArrayList<String> synonyms = WordNetConnection.Synonyms(keywords.get(i));
	        sysnsetTerm.put(keywords.get(i), synonyms) ;     
			}
			System.out.println(sysnsetTerm);
			
			
			/*** Start Similarity **/
			ArrayList<String> VisitedNode= new ArrayList<String>();
			HashMap<String,Double> similarityChildren = new HashMap<String,Double>();
			// Information_Management Developement_And_Testing Business_Resource_Management
			InterfaceImpDAOntologie.GetFF("Design", sysnsetTerm, VisitedNode, similarityChildren);
			System.out.println(similarityChildren);
			System.out.println(Collections.max(similarityChildren.entrySet(),Comparator.comparingDouble(Map.Entry::getValue)).getKey());
			
			
		
		
		
		
		
		
		
	}

}
