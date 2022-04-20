package Metier.entities;


public class DataStorageParam {
 private int ID;
 private String SSDStorageID;
 private String SASStorageID;
 private String HDDStorageID;


 public DataStorageParam() {
	 super();
	}
	
	public DataStorageParam(int ID, String SSDStorageID, String SASStorageID, String HDDStorageID) {
		super();
		this.ID = ID;
		this.SSDStorageID = SSDStorageID;
		this.SASStorageID = SASStorageID;
		this.HDDStorageID = HDDStorageID;		
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getSSDStorageID() {
		return SSDStorageID;
	}

	public void setSSDStorageID(String sSDStorageID) {
		SSDStorageID = sSDStorageID;
	}

	public String getSASStorageID() {
		return SASStorageID;
	}

	public void setSASStorageID(String sASStorageID) {
		SASStorageID = sASStorageID;
	}

	public String getHDDStorageID() {
		return HDDStorageID;
	}

	public void setHDDStorageID(String hDDStorageID) {
		HDDStorageID = hDDStorageID;
	}



	
}

