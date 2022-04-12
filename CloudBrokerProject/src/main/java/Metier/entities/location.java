package Metier.entities;

public class location {
 private String Africa;
 private String Asia;
 private String Australlia;
 private String Europe_UK;
 private String US_Canada;
 private String MiddleeastNorthAfrica;
 
 
 public location() {
	 super();
	}
	
	public location(String Africa, String Asia, String Australlia, String Europe_UK, String US_Canada, String MiddleeastNorthAfrica) {
		super();
		this.Africa = Africa;
		this.Asia = Asia;
		this.Australlia	 = Australlia ;
		this.Europe_UK = Europe_UK;
		this. US_Canada	 =  US_Canada ;
		this.MiddleeastNorthAfrica = MiddleeastNorthAfrica;
	}

	public String getAfrica() {
		return Africa;
	}

	public void setAfrica(String africa) {
		Africa = africa;
	}

	public String getAsia() {
		return Asia;
	}

	public void setAsia(String asia) {
		Asia = asia;
	}

	public String getAustrallia() {
		return Australlia;
	}

	public void setAustrallia(String australlia) {
		Australlia = australlia;
	}

	public String getEurope_UK() {
		return Europe_UK;
	}

	public void setEurope_UK(String europe_UK) {
		Europe_UK = europe_UK;
	}

	public String getUS_Canada() {
		return US_Canada;
	}

	public void setUS_Canada(String uS_Canada) {
		US_Canada = uS_Canada;
	}

	public String getMiddleeastNorthAfrica() {
		return MiddleeastNorthAfrica;
	}

	public void setMiddleeastNorthAfrica(String middleeastNorthAfrica) {
		MiddleeastNorthAfrica = middleeastNorthAfrica;
	}

	
}
