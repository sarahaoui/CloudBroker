package DAO;

import Metier.entities.DP;
import Metier.entities.DataRedundancySupport;
import Metier.entities.DataStorageParam;
import Metier.entities.DiskSpace;
import Metier.entities.DiskTransferRate;
import Metier.entities.HDD;
import Metier.entities.HRM;
import Metier.entities.HRM_NFF;
import Metier.entities.QoS;
import Metier.entities.QuantityOfOperations;
import Metier.entities.SAS;
import Metier.entities.SM_NFF;
import Metier.entities.SM;
import Metier.entities.SSD;
import Metier.entities.VolumeOfData;
import Metier.entities.intended_user;
import Metier.entities.license_type;
import Metier.entities.location;
import Metier.entities.numofoperation;
import Metier.entities.numofsession;
import Metier.entities.numofuser;
import Metier.entities.openness;
import Metier.entities.payement;
import Metier.entities.provider;
import Metier.entities.service_interface;

public interface InterfaceDAO {
	public void insertProvider(provider provider);  //done
    public void insertDP(DP DP);  //done  
    public int getMAXIDProvider();  //done
    public int getIDLicenseType(license_type license_type);   //done
    public int getIDIntendedUser(intended_user intended_user);   //done
    public int getIDServiceInterface(service_interface service_interface);    //done
    public int getIDOpenness(openness openness);   //done
    public int getIDPayement(payement payement);   //done
    public int getIDLocation(location location);    //done
    public void insertNumOfOperation(numofoperation numofoperation);    //done 
	public void insertNumOfUser(numofuser numofuser);    //done
	public void insertNumOfSession(numofsession numofsession);    //done
	public int getMaxNumOfSession();    //done
	public int getMaxNumOfOperation();    //done
	public int getMaxNumOfUser();    //done
    public void insertHRM_NFF(HRM_NFF HRM_NFF);     //done
    public int getMaxDP();     //done
	public int getMaxQoS();     //done
	public int getMaxHRM_NFF();     //done
    public void insertHRM(HRM HRM);     //done
    public void insertDataRedundancySupport(DataRedundancySupport DataRedundancySupport);     //done
   	public void insertQuantityOfOperations(QuantityOfOperations QuantityOfOperations);     //done
   	public void insertVolumeOfData(VolumeOfData VolumeOfData);     //done
	public int getMaxDataRedundancySupport();     //done
	public int getMaxQuantityOfOperations();     //done
	public int getMaxVolumeOfData();     //done
    public void insertSM_NFF(SM_NFF SM_NFF);     //done
	public void insertQoS(QoS QoS);     //done
	public void insertDiskSpace(DiskSpace DiskSpace);     //done
	public void insertDiskTransferRate(DiskTransferRate DiskTransferRate);     //done
    public void insertHDD(HDD HDD);     //done
    public void insertSAS(SAS SAS);     //done
    public void insertSSD(SSD SSD);     //done
    public static String authenticateUser(String Nom, String Motdepasse) {
		return null;
	}
    public int getMaxDiskSpaceID();     //done
    public int getMaxDiskTransferRateID();     //done
    public void insertDataStorageParam(DataStorageParam DataStorageParam);     //done
    public int getMaxHDD();     //done
    public int getMaxSAS();     //done
    public int getMaxSSD();     //done
    public int getMaxDataStorageParam();     //done
    
    public int getMaxSM_NFF();
    public void insertSM(SM SM);   
    


	

    
    






	
	}

