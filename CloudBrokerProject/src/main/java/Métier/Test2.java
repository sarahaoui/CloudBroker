package Métier;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.semanticweb.owlapi.model.OWLException;

import DAO.InterfaceImpDAOntologie;

public class Test2 {

	public static void main(String[] args) {
		
		System.out.println("************UpdateKeywords**************");
		
		UpdateKeyWords up = new UpdateKeyWords();
		try {
			up.UpdateKeywords();
		} catch (OWLException | IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("************Fournisseur Description**************");
		
	String Description= "We describe TriNet as our HR solution and we like to call them our mentors - people who help us with our HR processes, accounting, payroll, and all the reporting"
		+ " and compliance required for our business ... I want to focus on my business and TriNet helps me support "
		+ "my business plans, and my HR requirements in ways I could have never done. "
		+ "It's difficult to compete with the big companies and the benefit packages that they offer their employees "
		+ "and what TriNet allows us to do is level the playing field ...";

	ArrayList<String> keywords = new ArrayList<String>();
	ArrayList<String> Tokens = new ArrayList<String>();
	ArrayList<String> FinalKeywords = new ArrayList<String>();


	try {
		/*** Text Rank ***/
		keywords=TextRank.sentenceDetect(Description);
		System.out.println("Keywords: "+keywords);
		/*** Babelnet Elimination ***/
		BabelNetConnection.Connection(keywords);
		
		/*** Tokenization And POS ***/
		Tokens= Tokenization.TokanizationTag(keywords);
		
		/*** WordNet ***/
		WordNetConnection.WordnetConnection(Tokens);
		Set<String> set= new HashSet<>(Tokens);
		Tokens.clear();
		Tokens.addAll(set);
		
		/*** Babelnet Verification ***/
		FinalKeywords=BabelNetConnection.Connection2(Tokens);
		System.out.println("FinalKeywords: ");
		System.out.println(FinalKeywords);
	} catch (IOException e) {
		e.printStackTrace();
	}
	/*** Get CloudDictionary ***/
		    JSONParser jsonParser = new JSONParser();
	    JSONArray Dictionnary = new JSONArray();

		    try (FileReader reader = new FileReader("C:\\Users\\pc-click\\Desktop\\CloudDictionary.json"))
	    {
	       //Read JSON file
	        Object obj = jsonParser.parse(reader);
	        Dictionnary = (JSONArray) obj;

	     } catch (IOException e) {
	        e.printStackTrace();
	     } catch (ParseException e) {
	        e.printStackTrace();
	     }

	   /*** Matching Keywords ***/
	    ArrayList<String> VisitedNode= new ArrayList<String>();
	    ArrayList<String> matchedChildren= new ArrayList<String>();
	    try {
			InterfaceImpDAOntologie.BFSbasedMatchingKeywords("OFFs", FinalKeywords, Dictionnary, VisitedNode, matchedChildren);
		} catch (OWLException e) {
			e.printStackTrace();
		}	
	    System.out.println("FFS Matched:"+matchedChildren);
			
	
		
		
	}
}
