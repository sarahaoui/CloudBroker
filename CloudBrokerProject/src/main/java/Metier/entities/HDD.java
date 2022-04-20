package Metier.entities;

public class HDD {
private int ID;
 private String DiskSpaceID;
 private String DiskTransferRateID;
 

 public HDD() {
	 super();
	}
	
	public HDD(int ID, String DiskSpaceID, String DiskTransferRateID) {
		super();
		this.ID = ID;
		this.DiskSpaceID = DiskSpaceID;
		this.DiskTransferRateID = DiskTransferRateID;	
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getDiskSpaceID() {
		return DiskSpaceID;
	}

	public void setDiskSpaceID(String diskSpaceID) {
		DiskSpaceID = diskSpaceID;
	}

	public String getDiskTransferRateID() {
		return DiskTransferRateID;
	}

	public void setDiskTransferRateID(String diskTransferRateID) {
		DiskTransferRateID = diskTransferRateID;
	}
	
}

