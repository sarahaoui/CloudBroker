package Metier.entities;

public class service_interface {
 private String WebPortal;
 private String CLI;
 private String API;
 
 
 
 public service_interface() {
	 super();
	}
	
	public service_interface(String WebPortal, String CLI, String API) {
		super();
		this.WebPortal = WebPortal;
		this.CLI = CLI;
		this.API	 = API	;
		
	}

	public String getWebPortal() {
		return WebPortal;
	}

	public void setWebPortal(String webPortal) {
		WebPortal = webPortal;
	}

	public String getCLI() {
		return CLI;
	}

	public void setCLI(String cLI) {
		CLI = cLI;
	}

	public String getAPI() {
		return API;
	}

	public void setAPI(String aPI) {
		API = aPI;
	}

	
}
