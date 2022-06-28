package Model;

import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONObject;

import Metier.entities.DP;


public class Model {
	private List<String> FF= new ArrayList<String>();
	private List<DP> services= new ArrayList<DP>();
	private ArrayList<JSONObject> rankedCatServices = new ArrayList<JSONObject>();
	JSONObject service = new JSONObject();
	private boolean showpop = false;
    private String ff;
    
	public String getFf() {
		return ff;
	}

	public void setFf(String ff) {
		this.ff = ff;
	}

	public boolean isShowpop() {
		return showpop;
	}

	public void setShowpop(boolean showpop) {
		this.showpop = showpop;
	}

	public List<DP> getServices() {
		return services;
	}

	public void setServices(List<DP> services) {
		this.services = services;
	}

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
