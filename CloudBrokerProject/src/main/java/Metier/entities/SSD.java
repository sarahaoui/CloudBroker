package Metier.entities;

public class SSD {
 private String DiskSpaceID;
 private String DiskTransferRateID;
 

 public SSD() {
	 super();
	}
	
	public SSD(String DiskSpaceID, String DiskTransferRateID) {
		super();
		this.DiskSpaceID = DiskSpaceID;
		this.DiskTransferRateID = DiskTransferRateID;	
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

