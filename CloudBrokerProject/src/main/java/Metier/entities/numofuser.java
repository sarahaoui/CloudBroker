package Metier.entities;

public class numofuser {
	 private String UpTo10;
	 private String UpTo50;
	 private String UpTo100;
	 private String UpTo500;
	 private String UpTo1000;
	 
	 
	 public numofuser() {
		 super();
		}

  public numofuser(String UpTo10, String UpTo50, String UpTo100, String UpTo500, String UpTo1000) {
	        super();
			this.UpTo10 = UpTo10;
			this.UpTo50 = UpTo50;
			this.UpTo100 = UpTo100;
			this.UpTo100 = UpTo500;
			this.UpTo50 = UpTo1000;
		}

public String getUpTo10() {
	return UpTo10;
}

public void setUpTo10(String upTo10) {
	UpTo10 = upTo10;
}

public String getUpTo50() {
	return UpTo50;
}

public void setUpTo50(String upTo50) {
	UpTo50 = upTo50;
}

public String getUpTo100() {
	return UpTo100;
}

public void setUpTo100(String upTo100) {
	UpTo100 = upTo100;
}

public String getUpTo500() {
	return UpTo500;
}

public void setUpTo500(String upTo500) {
	UpTo500 = upTo500;
}

public String getUpTo1000() {
	return UpTo1000;
}

public void setUpTo1000(String upTo1000) {
	UpTo1000 = upTo1000;
}
  

}
