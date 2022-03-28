package MetierFPGrowth;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public interface Preprocessor {
	 public void loadDataFile(FileReader fileReader) throws IOException;
	    public ArrayList<String[]> getTransactions();
	    public List<List<String>> getFrequentItemsetWithLabels(List<List<String>> list);
	}


