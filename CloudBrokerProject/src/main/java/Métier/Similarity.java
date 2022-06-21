package Métier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
public class Similarity {
	
   public Similarity () {
	   
   }
	/*** Dice ***/
	public static double diceCoefficient(String s1, String s2)
	{
		Set<String> nx = new HashSet<String>();
		Set<String> ny = new HashSet<String>();

		for (int i=0; i < s1.length()-1; i++) {
			char x1 = s1.charAt(i);
			char x2 = s1.charAt(i+1);	
			if(x1 == ' ' || x2 == ' ') {
			 	
			}else {
				String tmp = "" + x1 + x2;
				nx.add(tmp);	
			}	
		}
		for (int j=0; j < s2.length()-1; j++) {
			char y1 = s2.charAt(j);
			char y2 = s2.charAt(j+1);
            if(y1 == ' ' || y2 == ' ') {
			 	
			}else {
			String tmp = "" + y1 + y2;
			ny.add(tmp);}
			
		}
		

		Set<String> intersection = new HashSet<String>(nx);
		intersection.retainAll(ny);
		double totcombigrams = intersection.size();
		return (2*totcombigrams) / (nx.size()+ny.size());
	}
	
	/*** Jaccard ***/
	public static Double calculateJaccardSimilarity(CharSequence left, CharSequence right) {
        Set<String> intersectionSet = new HashSet<String>();
        Set<String> unionSet = new HashSet<String>();
        boolean unionFilled = false;
        int leftLength = left.length();
        int rightLength = right.length();
        if (leftLength == 0 || rightLength == 0) {
            return 0d;
        }

        for (int leftIndex = 0; leftIndex < leftLength; leftIndex++) {
            unionSet.add(String.valueOf(left.charAt(leftIndex)));
            for (int rightIndex = 0; rightIndex < rightLength; rightIndex++) {
                if (!unionFilled) {
                    unionSet.add(String.valueOf(right.charAt(rightIndex)));
                }
                if (left.charAt(leftIndex) == right.charAt(rightIndex)) {
                    intersectionSet.add(String.valueOf(left.charAt(leftIndex)));
                }
            }
            unionFilled = true;
        }
     
        return Double.valueOf(intersectionSet.size()) / Double.valueOf(unionSet.size());
    }
	
	/*** Levenshtein ***/
	public static Double Levenshtein(String x, String y) {
	    int[][] dp = new int[x.length() + 1][y.length() + 1];

	    for (int i = 0; i <= x.length(); i++) {
	        for (int j = 0; j <= y.length(); j++) {
	            if (i == 0) {
	                dp[i][j] = j;
	            }
	            else if (j == 0) {
	                dp[i][j] = i;
	            }
	            else {
	                dp[i][j] = min(dp[i - 1][j - 1] 
	                 + costOfSubstitution(x.charAt(i - 1), y.charAt(j - 1)), 
	                  dp[i - 1][j] + 1, 
	                  dp[i][j - 1] + 1);
	            }
	        }
	    }

	    Double leven= Double.valueOf(dp[x.length()][y.length()]) ;
	    Double similarityLevenshtein =1.0-(leven /max(x.length(),y.length()));
	    return similarityLevenshtein;
	    		
	}
	public static int costOfSubstitution(char a, char b) {
        return a == b ? 0 : 1;
    }
	 public static int min(int... numbers) {
	        return Arrays.stream(numbers)
	          .min().orElse(Integer.MAX_VALUE);
	    }
	 public static int max(int... numbers) {
	        return Arrays.stream(numbers)
	          .max().orElse(Integer.MAX_VALUE);
	    }
	 /*** lexical similarity ***/
	 public static Double LexicalSimilarity(ArrayList<String> Concept1,ArrayList<String> Concept2) {
		 Set<String> CommunSynset = new HashSet<String>();
		 for (int i = 0; i < Concept1.size(); i++) {
			 for (int j = 0; j < Concept2.size(); j++) {
				 if(Concept1.get(i).equals(Concept2.get(j))) {
					 CommunSynset.add(Concept1.get(i));
				 }
			 }
		}
		 Double size= Double.valueOf(CommunSynset.size());
		 int size2= max(Concept1.size(),Concept2.size());
		 System.out.println(size+"/"+size2);
		 Double Similarity =size/size2 ;
		return Similarity; 
	 }
}
