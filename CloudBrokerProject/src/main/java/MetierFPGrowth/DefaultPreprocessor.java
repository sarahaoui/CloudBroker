package MetierFPGrowth;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;



public class DefaultPreprocessor implements Preprocessor {
    private ArrayList<String[]> transactions= new ArrayList<String[]>();

    public void loadDataFile(FileReader fileReader) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line;
       
        while ((line = bufferedReader.readLine()) != null) {
            transactions.add(parseTransactionString(line));
        }
        bufferedReader.close();
    }

    
    public ArrayList<String[]> getTransactions() {
        return transactions;
    }

    // for print output
    public  List<List<String>> getFrequentItemsetWithLabels(List<List<String>> frequentItemsets) {
        List<List<String>> output = new ArrayList<List<String>>();
        for (List<String> itemset : frequentItemsets) {
            List<String> newItemset = new ArrayList<String>();
            for (String item : itemset) {
                newItemset.add(item.toString());
            }
            output.add(newItemset);
        }
        return output;
    }

    public static String[] parseTransactionString(String str) {
        String[] strArray = str.split(",");
        String[] transaction = new String[strArray.length];
        for (int i = 0; i < strArray.length; i++) {
            transaction[i] = strArray[i];
        }   
        return transaction;
    }
}
