package Metier.entities;


public class SM_NFF {
 private String QuantityOfOperationsID;
 private String VolumeOfDataID;
 private String DataRedundancySupportID;
 private String DataStorageParamID;
 

 public SM_NFF() {
	 super();
	}
	
	public SM_NFF(String QuantityOfOperationsID, String VolumeOfDataID, String DataRedundancySupportID, String DataStorageParamID) {
		super();
		this.QuantityOfOperationsID = QuantityOfOperationsID;
		this.VolumeOfDataID = VolumeOfDataID;
		this.DataRedundancySupportID = DataRedundancySupportID;
		this.DataStorageParamID = DataStorageParamID;		

	}

	public String getQuantityOfOperationsID() {
		return QuantityOfOperationsID;
	}

	public void setQuantityOfOperationsID(String quantityOfOperationsID) {
		QuantityOfOperationsID = quantityOfOperationsID;
	}

	public String getVolumeOfDataID() {
		return VolumeOfDataID;
	}

	public void setVolumeOfDataID(String volumeOfDataID) {
		VolumeOfDataID = volumeOfDataID;
	}

	public String getDataRedundancySupportID() {
		return DataRedundancySupportID;
	}

	public void setDataRedundancySupportID(String dataRedundancySupportID) {
		DataRedundancySupportID = dataRedundancySupportID;
	}

	public String getDataStorageParamID() {
		return DataStorageParamID;
	}

	public void setDataStorageParamID(String dataStorageParamID) {
		DataStorageParamID = dataStorageParamID;
	}
	
}

