package Métier;

import java.util.ArrayList;

public class TFWeight {
	
	public static double TFWeight(ArrayList<String> doc , String Term) {
		double result =0;
		for(String word: doc) {
			if(Term.equalsIgnoreCase(word)) {
				result++;
			}
		}
		return result/doc.size();
		}
	    /*********Calculate TFWeight *******/
		public static ArrayList<String> CalculateTFWeight(ArrayList<String>list) {
			ArrayList<String>tokens= new ArrayList<String>();
			for(int j=0;j<list.size();j++) {
				Double weight=TFWeight(list, list.get(j));
				if(weight>=0.05) {    //change Weight
					tokens.add(list.get(j));
				}
			}
	        return tokens;
		}
		


}
