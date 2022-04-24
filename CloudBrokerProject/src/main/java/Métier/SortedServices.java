package Métier;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import it.uniroma1.lcl.jlt.util.Collections;

public class SortedServices {

	public static JSONObject sortBasedOnTotalHrel(JSONObject rankedServices) {
		JSONObject RankedSortServices = new JSONObject();
		for (Object cat : rankedServices.keySet()) {
			JSONArray array = new JSONArray();
			JSONObject item= (JSONObject) rankedServices.get(cat);
			Set<String>ServicesTitle= item.keySet();
			for (String Title : ServicesTitle) {
				JSONObject service= (JSONObject) item.get(Title);
				array.add(service);
				}
			ArrayList<JSONObject> list = new ArrayList<JSONObject>();
			for (int i = 0; i < array.size(); i++) {
				list.add((JSONObject) array.get(i))	;
				}
			java.util.Collections.sort(list, new MyJSONComparator());
			RankedSortServices.put(cat.toString(), list);
		}
		return RankedSortServices;
		
	}
}
