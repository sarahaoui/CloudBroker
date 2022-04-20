package Metier.entities;

public class numofoperation {
	private int ID;
	 private String UpTo50;
	 private String UpTo100;
	 private String UpTo300;
	 private String UpTo500;
	 private String UpTo1000;
	 private String UpTo1500;
	 
	 
	 public numofoperation() {
		 super();
		}

  public numofoperation(int ID, String UpTo50, String UpTo100, String UpTo300, String UpTo500, String UpTo1000, String UpTo1500) {
	        super();
	        this.ID = ID ;
			this.UpTo50 = UpTo50;
			this.UpTo100 = UpTo100;
			this.UpTo300 = UpTo300;
			this.UpTo100 = UpTo500;
			this.UpTo50 = UpTo1000;
			this.UpTo100 = UpTo1500;
		}

public int getID() {
	return ID;
}

public void setID(int iD) {
	ID = iD;
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

public String getUpTo300() {
	return UpTo300;
}

public void setUpTo300(String upTo300) {
	UpTo300 = upTo300;
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

public String getUpTo1500() {
	return UpTo1500;
}

public void setUpTo1500(String upTo1500) {
	UpTo1500 = upTo1500;
} 
  
  
     

		

		

}
