package Metier.entities;

public class numofsession {
	 private String UpTo1;
	 private String UpTo5;
	 private String UpTo10;
	 private String UpTo20;
	 private String UpTo50;
	 
	 
	 public numofsession() {
		 super();
		}

  public numofsession(String UpTo1, String UpTo5, String UpTo10, String UpTo20, String UpTo50) {
	        super();
			this.UpTo1 = UpTo1;
			this.UpTo5 = UpTo5;
			this.UpTo10 = UpTo10;
			this.UpTo20 = UpTo20;
			this.UpTo50 = UpTo50;
		}

public String getUpTo1() {
	return UpTo1;
}

public void setUpTo1(String upTo1) {
	UpTo1 = upTo1;
}

public String getUpTo5() {
	return UpTo5;
}

public void setUpTo5(String upTo5) {
	UpTo5 = upTo5;
}

public String getUpTo10() {
	return UpTo10;
}

public void setUpTo10(String upTo10) {
	UpTo10 = upTo10;
}

public String getUpTo20() {
	return UpTo20;
}

public void setUpTo20(String upTo20) {
	UpTo20 = upTo20;
}

public String getUpTo50() {
	return UpTo50;
}

public void setUpTo50(String upTo50) {
	UpTo50 = upTo50;
}
  


}
