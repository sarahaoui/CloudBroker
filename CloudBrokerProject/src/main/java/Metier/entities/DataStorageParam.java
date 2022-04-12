package Metier.entities;


public class DataStorageParam {
 private String SSDStorageID;
 private String SASStorageID;
 private String HDDStorageID;


 public DataStorageParam() {
	 super();
	}
	
	public DataStorageParam(String SSDStorageID, String SASStorageID, String HDDStorageID) {
		super();
		this.SSDStorageID = SSDStorageID;
		this.SASStorageID = SASStorageID;
		this.HDDStorageID = HDDStorageID;		
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

