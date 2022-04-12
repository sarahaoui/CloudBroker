package Metier.entities;


public class HRM_NFF {
 private String NumOfUsersID;
 private String NumOfSessionsPerUserID;
 private String NumOfOperationsPerSessionID;
 

 public HRM_NFF() {
	 super();
	}
	
	public HRM_NFF(String NumOfUsersID, String NumOfSessionsPerUserID, String NumOfOperationsPerSessionID) {
		super();
		this.NumOfUsersID = NumOfUsersID;
		this.NumOfSessionsPerUserID = NumOfSessionsPerUserID;
		this.NumOfOperationsPerSessionID = NumOfOperationsPerSessionID;		
	}

	public String getNumOfUsersID() {
		return NumOfUsersID;
	}

	public void setNumOfUsersID(String numOfUsersID) {
		NumOfUsersID = numOfUsersID;
	}

	public String getNumOfSessionsPerUserID() {
		return NumOfSessionsPerUserID;
	}

	public void setNumOfSessionsPerUserID(String numOfSessionsPerUserID) {
		NumOfSessionsPerUserID = numOfSessionsPerUserID;
	}

	public String getNumOfOperationsPerSessionID() {
		return NumOfOperationsPerSessionID;
	}

	public void setNumOfOperationsPerSessionID(String numOfOperationsPerSessionID) {
		NumOfOperationsPerSessionID = numOfOperationsPerSessionID;
	}

	
}
