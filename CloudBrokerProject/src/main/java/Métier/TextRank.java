package Métier;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;

import opennlp.tools.postag.POSModel;
import opennlp.tools.postag.POSTaggerME;
import opennlp.tools.sentdetect.SentenceDetectorME;
import opennlp.tools.sentdetect.SentenceModel;
import opennlp.tools.tokenize.Tokenizer;
import opennlp.tools.tokenize.TokenizerME;
import opennlp.tools.tokenize.TokenizerModel;

public class TextRank {
	public ArrayList<String>  sentenceDetect(String paragraph) throws InvalidFormatException, IOException {
    	int k = 2;                 //window size/2
        float d = 0.85f;
        final int max_iter = 100;  //Maximum number of iterations
        final float min_diff = 0.001f; //The difference is the smallest
        int nbrKeywords;
    	InputStream tokenModelIn = null;
        InputStream posModelIn = null;
        String[] sentences = null;
        ArrayList<List<String>> listSentences= new ArrayList<>();
        Map<String, Set<String>> relationWords = new HashMap<>();
        List<String> keyWords = new ArrayList<>();
        
   
        InputStream is = new FileInputStream("en-sent.bin");
        tokenModelIn = new FileInputStream("en-token.bin");
        posModelIn = new FileInputStream("en-pos-maxent.bin");
        
        TokenizerModel tokenModel = new TokenizerModel(tokenModelIn);
        Tokenizer tokenizer = new TokenizerME(tokenModel);
        SentenceModel model = new SentenceModel(is);
         
        // feed the model to SentenceDetectorME class 
        SentenceDetectorME sdetector = new SentenceDetectorME(model);
         
        // detect sentences in the paragraph
        sentences = sdetector.sentDetect(paragraph);
         
        // loading the parts-of-speech model from stream
         POSModel posModel = new POSModel(posModelIn);
         
         // initializing the parts-of-speech tagger with model 
          POSTaggerME posTagger = new POSTaggerME(posModel);
   
       /** Token Sentences **/
        for(int i=0;i<sentences.length;i++){
        	String sentence= sentences[i];
        	String[]tokens = tokenizer.tokenize(sentence);
        	List<String>listTokens= new LinkedList<String>(Arrays.asList(tokens)) ;
        	listSentences.add(listTokens);
        	}
           //System.out.println(listSentences);
        
       /** Detect AdjecentWords **/
        ArrayList<String> wordsAdjecent= new ArrayList<String>();
        for(int i=0;i<listSentences.size();i++){
        	String[] list= listSentences.get(i).toArray(new String[listSentences.get(i).size()]);
        	String tags[] = posTagger.tag(list);
            List<String>tagslist= new LinkedList<String>(Arrays.asList(tags)) ; 
            String word="";
            for(int j=0 ;j<listSentences.get(i).size();j++) {
            	//System.out.println(listSentences.get(i).get(j)+" /Tag:"+tagslist.get(j));
        	if((tagslist.get(j).equals("JJ"))  ||  (tagslist.get(j).equals("NN")) ||  (tagslist.get(j).equals("NNS")) ||  (tagslist.get(j).equals("NNP")) || (tagslist.get(j).equals("NNPS"))) { 	
        		if(word.equals("")) {
					word=listSentences.get(i).get(j);
				}else {
					word=word+" " +listSentences.get(i).get(j);
				}	
        	}else {
        		if(!word.equals("")) {
        			wordsAdjecent.add(word);
        		word="";}
        	}	
        }if(!word.equals("")) {
        	wordsAdjecent.add(word);
    		word="";}}
        //System.out.println("paragraph with only noun object words: \n"+wordsAdjecent);
        
        /** Fill keywords list **/
        for(int index=0;index<wordsAdjecent.size();index++) {
        	String sentence= wordsAdjecent.get(index);
        	String[]tokens = tokenizer.tokenize(sentence);
        	for(int j=0;j<tokens.length; j++) {
   		 keyWords.add(tokens[j]);
			}}
        //System.out.println("keywords: \n"+keyWords);  
            
			 
		 /**Get the combination of k before and after each keyword**/
		   for (int i = 0; i <keyWords.size(); i++) {
		            String keyword = keyWords.get(i);
		            Set<String> keySets = relationWords.get(keyword);
		            if (keySets == null) {
		                keySets = new HashSet<>();
		                relationWords.put(keyword, keySets);
		            }

		            for (int j = i-k; j <= i + k; j++) {
		                if (j <0 || j >= keyWords.size() || j == i) {
		                    continue;
		                } else {
		                    keySets.add(keyWords.get(j));
		                }}
		     }
	       /* for (String s: relationWords.keySet()) {
	            System.out.print(s+"/ ");
	            for (String s1: relationWords.get(s)) {
	                System.out.print(s1+", ");
	            }
	            System.out.println();
	        }*/
		   
		  /** Set Score to each key **/
	        Map<String, Float> score = new HashMap<String, Float>();
	        for (int i = 0; i < max_iter; ++i)
	        {
	            Map<String, Float> m = new HashMap<String, Float>();
	            float max_diff = 0;
	            for  (String key: relationWords.keySet())
	            { 
	                Set<String> value = relationWords.get(key);;
	              //First give each keyword a default rank value
	                m.put(key, 1 - d);
	                for (String other : value)
	                {
	                    int size = relationWords.get(other).size();
	                    
	                    if (key.equals(other) || size == 0) continue;   //skip this iteration
	                    m.put(key, m.get(key) + d / size * (score.get(other) == null ? 1 : score.get(other)));
	                   
	                }
	                max_diff = Math.max(max_diff, Math.abs(m.get(key) - (score.get(key) == null ? 1 : score.get(key))));
	            }
	            score = m;
	          
	            
	            if (max_diff <= min_diff) {   //stop loop (the previous score and the current score are close to each other)
	            	System.out.println("Number of iterations:" + i);
	            break;}
	        }
	      
	      /** Sort keys **/
	        List<Map.Entry<String, Float>> entryList = new ArrayList<Map.Entry<String, Float>>(score.entrySet());
	        Collections.sort(entryList, new Comparator<Map.Entry<String, Float>>()
	        {
	            public int compare(Map.Entry<String, Float> o1, Map.Entry<String, Float> o2)
	            {
	                return (o1.getValue() - o2.getValue() > 0 ? -1 : 1);
	            }
	        });
	       System.out.println(entryList);
	       
	     /** Number of keywords **/
	       String[]words=paragraph.split("\\s+");
	        if(words.length<5 || words.length/3>entryList.size()) {
	        	nbrKeywords =  entryList.size();
	        }else {
	        	nbrKeywords = words.length/3;
	        }
	        
	        System.out.println("Number of keywords:"+nbrKeywords);
	       ArrayList<String> result = new ArrayList<>();
	        for (int i = 0; i < nbrKeywords; ++i)
	        { result.add(entryList.get(i).getKey()) ;}
	       // System.out.println(result);
	        
	       /** Token AdjacentWords **/ 
	        ArrayList<ArrayList<String>> TokenWordAdjecent= new ArrayList<>();
	        for(int i=0;i<wordsAdjecent.size();i++) {
	    		String sentence= wordsAdjecent.get(i);
	        	String[]tokens = tokenizer.tokenize(sentence);
	        	ArrayList<String>TokWords= new ArrayList<>(); 
	        	for(int j=0;j<tokens.length; j++) {
	        		TokWords.add(tokens[j]);}
	        	TokenWordAdjecent.add(TokWords);
	    	} 
	        //System.out.println(TokenWordAdjecent);
	        
	      /** Combine Adjacent Words **/
	      ArrayList<String>FinalKeyWords= KeyPhrases(TokenWordAdjecent, result,tokenizer) ;
	       
	        is.close();    
	        return FinalKeyWords;
    
    }
    
    
    public ArrayList<String> KeyPhrases(ArrayList<ArrayList<String>>words,ArrayList<String> result,Tokenizer tokenizer) {
    	ArrayList<String>Final= new ArrayList<String>();
    	for(int i=0;i<words.size();i++) {
    		String word="";
    		for(int j=0;j<words.get(i).size();j++) {
    			if(result.contains(words.get(i).get(j))) {
    				if(Final.contains(words.get(i).get(j))) {
    					Final.remove(words.get(i).get(j));
    				}
    				if(word.equals("")) {
    					word=words.get(i).get(j);
    				}else {
    					word=word+" "+words.get(i).get(j);
    				}
    				
    			}else {	
    			if(!word.equals("") ) {
    				CheckWord(tokenizer,word, Final);
    				}
    			word="";}
    	        }
    		if(!word.equals("")) {
    			CheckWord(tokenizer,word, Final);
				}
         }
    	return Final;
    	}


	private void CheckWord(Tokenizer tokenizer, String word, ArrayList<String> Final) {
		String[]tokens = tokenizer.tokenize(word);
		String Finall[]= new String[Final.size()];
		Finall= Final.toArray(Finall);
		if(tokens.length==1 ) {
			Boolean exsite= false;
			for(int z=0;z<Finall.length;z++) {
				String[]tokenss = tokenizer.tokenize(Finall[z]);
				for(int k=0;k<tokenss.length;k++) {
					if(tokenss[k].equals(word)) {
						exsite=true;
					}}}
			if(exsite==false) {
				Final.add(word);	
			}
			word="";
	    }else {
	        Final.add(word);
	        word="";
	  }}

}
