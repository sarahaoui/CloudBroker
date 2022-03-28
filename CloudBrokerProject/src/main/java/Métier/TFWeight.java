package Métier;

import java.util.ArrayList;

public class TFWeight {
	
	public double TFWeight(ArrayList<String> doc , String Term) {
		double result =0;
		for(String word: doc) {
			if(Term.equalsIgnoreCase(word)) {
				result++;
			}
		}
		return result/doc.size();
		}
	    /*********Calculate TFWeight *******/
		public void CalculateTFWeight(ArrayList<String>list) {
			int j=0;
			while(j<list.size()) {
				Double weight=TFWeight(list, list.get(j));
				if(weight<0.033) {    //change Weight
					Delete(list.get(j), list);
				}else {
					j++;
				}
				
			}
	        
		}
		/****** Delete all items **********/
		public void Delete(String term ,ArrayList<String>list ) {
			int i=0;	
			while(i<list.size()) {
				if(list.get(i).equals(term)) {
					list.remove(i);
				}else {
					i++;
				}
			}
		}


}
