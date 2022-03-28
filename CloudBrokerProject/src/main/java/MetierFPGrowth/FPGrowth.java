package MetierFPGrowth;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class FPGrowth {
	public static Map<String, Integer> getOneItemsetCounts(List<String[]> transactions) {
        Map<String, Integer> counts = new HashMap<String, Integer>();
        return addToOneItemsetCounts(counts, transactions);
    }

    public static Map<String, Integer> addToOneItemsetCounts(Map<String, Integer> counts, List<String[]> transactions) {
        for (String[] itemset : transactions) {
            for (String item : itemset) {
                Integer count = counts.get(item);
                if (count == null) count = 0;
                count++;
                counts.put(item, count);
            }
        }
        return counts;
    }

    public static FPTree buildFPTree(List<String[]> transactions, Map<String, Integer> oneItemsetCounts, boolean pruneBeforeInsert, double minSupport) {
        FPTree tree = new FPTree();
        tree.addTransactions(transactions, oneItemsetCounts, pruneBeforeInsert, minSupport);
        return tree;
    }


    public static String[] sortTransaction(String[] transaction, Map<String, Integer> oneItemsetCounts) {
        List<String> list =new ArrayList<String>();
        list=Arrays.asList(transaction);
        Collections.sort(list, new ItemsetComparator(oneItemsetCounts));
        String[]Stringlist= new String[list.size()];
        Stringlist=list.toArray(Stringlist);
        return Stringlist;
    }


    public static List<List<String>> findFrequentItemsetWithSuffix(FPTree tree, ArrayList<String> arrayList, int minSupportCount) {
        List<List<String>> frequentItemset = new ArrayList<List<String>>();
        for (String item : tree.getItems().keySet()) {
            int support = tree.getSupportForItem(item);
            if (support >= minSupportCount && !arrayList.contains(item)) {
                ArrayList<String> found = new ArrayList<String>();
                found.addAll(arrayList);
                found.add(item);
                frequentItemset.add(found);

                FPTree conditionalTree = FPTree.conditionalTree(tree.getPrefixPaths(item), minSupportCount);
                frequentItemset.addAll(findFrequentItemsetWithSuffix(conditionalTree, found, minSupportCount));
            }
        }
        return frequentItemset;
    }

}
