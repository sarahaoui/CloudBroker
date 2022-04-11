package Métier;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Pattern;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;

import opennlp.tools.postag.POSModel;
import opennlp.tools.postag.POSTaggerME;
import opennlp.tools.tokenize.Tokenizer;
import opennlp.tools.tokenize.TokenizerME;
import opennlp.tools.tokenize.TokenizerModel;

public class Tokenization {
	public static ArrayList<String> TokanizationTag(ArrayList<String>keywords)throws InvalidFormatException, IOException {
		  
	      FileInputStream tokenModelIn = new FileInputStream("D:/en-token.bin");
	      FileInputStream posModelIn = new FileInputStream("D:/en-pos-maxent.bin");
	      TokenizerModel tokenModel = new TokenizerModel(tokenModelIn);
	      Tokenizer tokenizer = new TokenizerME(tokenModel);
	      // loading the parts-of-speech model from stream
	       POSModel posModel = new POSModel(posModelIn);
	       // initializing the parts-of-speech tagger with model 
	        POSTaggerME posTagger = new POSTaggerME(posModel);
	       
	        String[] list= keywords.toArray(new String[keywords.size()]);
	        String tags[] = posTagger.tag(list);
		    List<String>listTags= new LinkedList<String>(Arrays.asList(tags)) ;
		   
		    
		    ArrayList<String> Tokens=new ArrayList<>();
		    for(int i=0;i<keywords.size();i++) {

				if(Pattern.matches("[a-zA-Z-]+",keywords.get(i))) {
					if(listTags.get(i).equals(".")) {
						Tokens.add(keywords.get(i)+";NN");
			    	}else {
					Tokens.add(keywords.get(i)+";"+listTags.get(i));	
			    	}
		    	}else {
		    		Tokens.add(keywords.get(i)+";Expression");	
		    	}
		    	
		    }
	        return Tokens;
	        
	  }
	

}
