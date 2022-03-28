package MetierFPGrowth;

import java.util.Comparator;
import java.util.Map;

public class ItemsetComparator implements Comparator<String> {
    private final Map<String, Integer> counts;

    public ItemsetComparator(Map<String, Integer> counts) {
        this.counts = counts;
    }

	public int compare(String o1, String o2) {
		return counts.get(o2) - counts.get(o1);
	}
}