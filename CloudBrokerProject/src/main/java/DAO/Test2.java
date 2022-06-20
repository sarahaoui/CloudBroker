package DAO;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import Métier.BabelNetConnection;
import Métier.Similarity;
import Métier.TextRank;
import Métier.Tokenization;
import Métier.WordNetConnection;
import edu.smu.tspell.wordnet.NounSynset;
import edu.smu.tspell.wordnet.Synset;
import edu.smu.tspell.wordnet.SynsetType;
import edu.smu.tspell.wordnet.WordNetDatabase;

public class Test2 {

	public static void main(String[] args) {
		String Description="I want a Human resource management that can help me to manage my HR processes, accounting, payroll, and all my reporting and compliance required for my business ... I want to focus on my business and the service helps me support my business plans. ";
       //String Description="I want a streaming and multimedia that can manage my brodcasts and edit my videos.";
		//String Description = "Visualize database structures to understand your database, create databases or modify existing databases, you can also analyze and optimize databases.";
		ArrayList<String> keywords = new ArrayList<String>();
		HashMap<String,ArrayList<String>> sysnsetTerm = new HashMap<String,ArrayList<String>>();
		System.setProperty("wordnet.database.dir", "C:\\Users\\pc-click\\Desktop\\PFE Ressources\\WordNet-3.0\\dict");
        WordNetDatabase database = WordNetDatabase.getFileInstance();

		try {
			/*** Text Rank ***/
			keywords=TextRank.sentenceDetect(Description);
			/*** Babelnet Elimination ***/
			BabelNetConnection.Connection(keywords);
			/*** Search for Simple or complex phrases ***/
			for (int i = 0; i < keywords.size(); i++) {
				
					/** Get Synsets Using BabelNet***/
				 ArrayList<String>synonyms =BabelNetConnection.SynonymsFF(keywords.get(i));
	             sysnsetTerm.put(keywords.get(i), synonyms) ;     
			}
	        	
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(sysnsetTerm);
		
		/*** Start Similarity **/
		ArrayList<String> VisitedNode= new ArrayList<String>();
		HashMap<String,Double> similarityChildren = new HashMap<String,Double>();
		// Information_Management Developement_And_Testing Business_Resource_Management
		ImplementationSimilarity.CalculateSimilarity("Business_Resource_Management", sysnsetTerm, VisitedNode, similarityChildren);
		System.out.println(similarityChildren);
		System.out.println(Collections.max(similarityChildren.entrySet(),Comparator.comparingDouble(Map.Entry::getValue)).getKey());
		
		
		
		
		
	}

}
