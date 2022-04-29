package Métier;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import it.uniroma1.lcl.jlt.util.Collections;

public class SortedServices {

	public static ArrayList<JSONObject> sortBasedOnTotalHrel(JSONObject rankedServices) {
		JSONArray RankedSortServices = new JSONArray();
		JSONArray array = new JSONArray();
	Set<Object>cat = rankedServices.keySet();
	Object elementCat= new Object();
	for (Object object : cat) {
		elementCat=object;
	}
			JSONObject item= (JSONObject) rankedServices.get(elementCat);
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
			
		
		return list;
		
	}
	public static JSONObject GetService(ArrayList<JSONObject>listServices,String Title) {
		for (JSONObject jsonObject : listServices) {
			JSONObject generalinfo= (JSONObject) jsonObject.get("General Information");
			if(generalinfo.get("ServiceTitle").equals(Title)) {
				return jsonObject;
			}
		}
		return null;
		
	}
}
