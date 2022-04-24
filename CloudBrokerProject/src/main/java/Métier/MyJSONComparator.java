package Métier;

import java.util.Comparator;

import org.json.simple.JSONObject;

public class MyJSONComparator  implements Comparator<JSONObject>{

	@Override
	public int compare(JSONObject o1, JSONObject o2) {
		Double THrel1= (Double) o1.get("THrel");
		Double THrel2= (Double) o2.get("THrel");
		return THrel1.compareTo(THrel2);
	}

	
}
