package Métier;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Pattern;

import edu.smu.tspell.wordnet.Synset;
import edu.smu.tspell.wordnet.SynsetType;
import edu.smu.tspell.wordnet.WordNetDatabase;
import edu.smu.tspell.wordnet.impl.file.Morphology;
import opennlp.tools.postag.POSModel;
import opennlp.tools.postag.POSTaggerME;
import opennlp.tools.tokenize.Tokenizer;
import opennlp.tools.tokenize.TokenizerME;
import opennlp.tools.tokenize.TokenizerModel;

public class WordNetConnection {
	
	
	public static void WordnetConnection(ArrayList<String> Tokens) throws IOException {
		System.setProperty("wordnet.database.dir", "C:\\Users\\pc-click\\Desktop\\PFE Ressources\\WordNet-3.0\\dict");
		WordNetDatabase database = WordNetDatabase.getFileInstance();
		FileInputStream tokenModelIn = new FileInputStream("D:/en-token.bin");
	    FileInputStream posModelIn = new FileInputStream("D:/en-pos-maxent.bin");
	    TokenizerModel tokenModel = new TokenizerModel(tokenModelIn);
	    Tokenizer tokenizer = new TokenizerME(tokenModel);
	    // loading the parts-of-speech model from stream
	     POSModel posModel = new POSModel(posModelIn);
	     // initializing the parts-of-speech tagger with model 
	      POSTaggerME posTagger = new POSTaggerME(posModel);
		String[] arr =null;
		
		Morphology id = Morphology.getInstance();
		
	    for (int i=0;i<Tokens.size();i++) {
			String[] parts= Tokens.get(i).split(";");
	    	if((parts[0].equals("NN"))|| (parts[0].equals("NNS"))||(parts[0].equals("NNP"))||(parts[0].equals("NNPS"))) {
	    		arr = id.getBaseFormCandidates(parts[0], SynsetType.NOUN);
	    	}else if(parts[0].equals("JJ")) {
	    		arr = id.getBaseFormCandidates(parts[0], SynsetType.ADJECTIVE);
	    	}else {
	    		arr = id.getBaseFormCandidates(parts[0], SynsetType.VERB);
	    	}
	    	if(arr.length!= 0) {
	    		 String tags[] = posTagger.tag(arr);
	    		 for(int j=0;j<tags.length;j++) {
	    			 if(Pattern.matches("[a-zA-Z-]+",arr[j])) {
	    				 Tokens.add(arr[j]+";"+ tags[j]);
	 		    		
	 		    	}else {
	 		    		Tokens.add(arr[j]+";Expression");	
	 		    	}
	    			 
	    		 }
	    	}
	       
		}

	}
	public static ArrayList<String> Synonyms(String term){
		ArrayList<String> Synonyms = new ArrayList<String>();
		System.setProperty("wordnet.database.dir", "C:\\Users\\pc-click\\Desktop\\PFE Ressources\\WordNet-3.0\\dict");
        WordNetDatabase database = WordNetDatabase.getFileInstance();
        Synset [] synsets = database.getSynsets(term);
        if(synsets.length>0) {
        	for (int i = 0; i < synsets.length; i++) {
        		String[]wordform = synsets[i].getWordForms();
        		for (int j = 0; j < wordform.length; j++) {
        			Synonyms.add(wordform[j]);
				}
			}
        	
        }
		return Synonyms;
	}
}
