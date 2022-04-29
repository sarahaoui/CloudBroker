package Model;

import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONObject;


public class Model {
	private List<String> FF= new ArrayList<String>();
	private ArrayList<JSONObject> rankedCatServices = new ArrayList<JSONObject>();
	JSONObject service = new JSONObject();

	public JSONObject getService() {
		return service;
	}

	public void setService(JSONObject service) {
		this.service = service;
	}

	public ArrayList<JSONObject> getRankedCatServices() {
		return rankedCatServices;
	}

	public void setRankedCatServices(ArrayList<JSONObject> rankedCatServices) {
		this.rankedCatServices = rankedCatServices;
	}

	public List<String> getFF() {
		return FF;
	}

	public void setFF(List<String> fF) {
		FF = fF;
	}
}
