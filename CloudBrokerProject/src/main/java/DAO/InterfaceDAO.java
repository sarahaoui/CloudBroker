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
	public int insertProvider(provider provider);  //done
	public static String authenticateUser(String Nom, String Motdepasse) {
	  return null;}
    public int insertDP(DP DP);  //done  
    public int getIDLicenseType(license_type license_type);   //done
    public int getIDIntendedUser(intended_user intended_user);   //done
    public int getIDServiceInterface(service_interface service_interface);    //done
    public int getIDOpenness(openness openness);   //done
    public int getIDPayement(payement payement);   //done
    public int getIDLocation(location location);    //done
    public int insertNumOfOperation(numofoperation numofoperation);    //done 
	public int insertNumOfUser(numofuser numofuser);    //done
	public int insertNumOfSession(numofsession numofsession);    //done	
    public int insertHRM_NFF(HRM_NFF HRM_NFF);     //done
    public void insertHRM(HRM HRM);     //done
    public int insertDataRedundancySupport(DataRedundancySupport DataRedundancySupport);     //done
   	public int insertQuantityOfOperations(QuantityOfOperations QuantityOfOperations);     //done
   	public int insertVolumeOfData(VolumeOfData VolumeOfData);     //done
    public int insertSM_NFF(SM_NFF SM_NFF);     //done
	public int insertQoS(QoS QoS);     //done
	public int insertDiskSpace(DiskSpace DiskSpace);     //done
	public int insertDiskTransferRate(DiskTransferRate DiskTransferRate);     //done
    public int insertHDD(HDD HDD);     //done
    public int insertSAS(SAS SAS);     //done
    public int insertSSD(SSD SSD);     //done
    public int insertDataStorageParam(DataStorageParam DataStorageParam);     //done
    public void insertSM(SM SM);   

    
    






	
	}

