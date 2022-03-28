package MetierFPGrowth;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import static MetierFPGrowth.FPGrowth.getOneItemsetCounts;
import static MetierFPGrowth.FPGrowth.buildFPTree;
import static MetierFPGrowth.FPGrowth.findFrequentItemsetWithSuffix;
public class Test {

	public static void main(String[] args) {
		  double minSupport = 0.6;
	        
	        File file = new File("C:\\Users\\pc-click\\Desktop\\tokens.txt");
	        Preprocessor preprocessor = new DefaultPreprocessor();
	        try {
	            FileReader fileReader = new FileReader(file);
	            preprocessor.loadDataFile(fileReader);
	            fileReader.close();
	            System.out.println("Preprocessed the file.");
	        } catch (FileNotFoundException e) {
	            System.out.println("Could not find the file.");
	            System.exit(1);
	        } catch (IOException e) {
	            System.out.println("Could not read the file.");
	            System.exit(1);
	        }

	        Map<String, Integer> oneItemsetCounts = getOneItemsetCounts(preprocessor.getTransactions());
	        System.out.println(preprocessor.getFrequentItemsetWithLabels(
	            findFrequentItemsetWithSuffix(
	                buildFPTree(preprocessor.getTransactions(), oneItemsetCounts, true, minSupport),
	                new ArrayList<String>(),
	                ((int) minSupport * preprocessor.getTransactions().size())
	            )
	        ));

	}

}
