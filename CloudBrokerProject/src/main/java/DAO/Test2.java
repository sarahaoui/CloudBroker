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
		//String Description="Managing the accounting risks";
		//String Description="Marketing by email";
		//String Description="Marketing mobile";
		//String Description="Human_Ressource_management";
		String Description="Delpoyer applications";
		ArrayList<String> keywords = new ArrayList<String>();
		HashMap<String,ArrayList<String>> sysnsetTerm = new HashMap<String,ArrayList<String>>();
		

		try {
			/*** Text Rank ***/
			keywords=TextRank.sentenceDetect(Description);
			System.out.println(keywords);
		
			/*** Search for Simple or complex phrases ***/
			for (int i = 0; i < keywords.size(); i++) {
				
					/** Get Synsets Using BabelNet***/
				// ArrayList<String>synonyms =BabelNetConnection.SynonymsFF(keywords.get(i));
				ArrayList<String> synonyms = WordNetConnection.Synonyms(keywords.get(i));
	             sysnsetTerm.put(keywords.get(i), synonyms) ;     
			}
	        	
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(sysnsetTerm);
		
		/*** Start Similarity **/
		ArrayList<String> VisitedNode= new ArrayList<String>();
		HashMap<String,Double> similarityChildren = new HashMap<String,Double>();
		
		ImplementationSimilarity.GetDomaine("FF", sysnsetTerm, VisitedNode, similarityChildren);
		System.out.println(similarityChildren);
		System.out.println(Collections.max(similarityChildren.entrySet(),Comparator.comparingDouble(Map.Entry::getValue)).getKey());
		String Domaine = Collections.max(similarityChildren.entrySet(),Comparator.comparingDouble(Map.Entry::getValue)).getKey();

       HashMap<String,Double> similarityFF = new HashMap<String,Double>();
		ImplementationSimilarity.GetFF(Domaine, sysnsetTerm, VisitedNode, similarityFF);
		System.out.println(similarityFF);
		System.out.println(Collections.max(similarityFF.entrySet(),Comparator.comparingDouble(Map.Entry::getValue)).getKey());
		
		
		
	}

}
