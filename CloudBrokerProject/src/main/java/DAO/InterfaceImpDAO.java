package DAO;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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
import Metier.entities.SM;
import Metier.entities.SM_NFF;
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

import java.sql.SQLException;
import java.sql.Statement;


public class InterfaceImpDAO implements InterfaceDAO{
	static Connection connection= SingletonConnection.getConnection();

	public int insertProvider(provider provider){
		int key=0;
		try {
			String INSERT_USERS = "INSERT INTO `Provider`(`Nom`, `Motdepasse`, `Email`, `Telephone`, `Nom_entreprise`, `Pays`) VALUES (?,?,?,?,?,?);";
			PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS,Statement.RETURN_GENERATED_KEYS);			
			preparedStatement.setString(1, provider.getNom());
			preparedStatement.setString(2, provider.getMotdepasse());
			preparedStatement.setString(3, provider.getEmail());
			preparedStatement.setString(4, provider.getTelephone());
			preparedStatement.setString(5, provider.getNom_entreprise());
			preparedStatement.setString(6, provider.getPays());
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
			
			ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
			if(generatedKeys.next()) {
				 key=(generatedKeys.getInt(1));
			}else {
				System.out.println("Creating user failed , no ID obtained !!");
			}
			
		} catch (SQLException e) {
		//	printSQLException(e);
			}
		return key;
	}
	
	   ////////////////////////////////////////////////////////////////
	public void insertNumOfOperation(numofoperation numofoperation){
		try {
			String req2 = "INSERT INTO `numofoperationspersession`(`UpTo50`, `UpTo100`, `UpTo300`, `UpTo500`, `UpTo1000`, `UpTo1500`) VALUES (?,?,?,?,?,?);";
			PreparedStatement preparedStatement = connection.prepareStatement(req2);			
			preparedStatement.setString(1, numofoperation.getUpTo50());
			preparedStatement.setString(2, numofoperation.getUpTo100());
			preparedStatement.setString(3, numofoperation.getUpTo300());
			preparedStatement.setString(4, numofoperation.getUpTo500());
			preparedStatement.setString(5, numofoperation.getUpTo1000());
			preparedStatement.setString(6, numofoperation.getUpTo1500());
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			printSQLException(e); }
	}
	   ////////////////////////////////////////////////////////////////
	public void insertNumOfUser(numofuser numofuser){
		try {
			String req3 = "INSERT INTO `numofusers`(`UpTo10`, `UpTo50`, `UpTo100`, `UpTo500`, `UpTo1000`) VALUES (?,?,?,?,?);";
			PreparedStatement preparedStatement = connection.prepareStatement(req3);			
			preparedStatement.setString(1, numofuser.getUpTo10());
			preparedStatement.setString(2, numofuser.getUpTo50());
			preparedStatement.setString(3, numofuser.getUpTo100());
			preparedStatement.setString(4, numofuser.getUpTo500());
			preparedStatement.setString(5, numofuser.getUpTo1000());
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			printSQLException(e); }
	}
	
    ////////////////////////////////////////////////////////////////
	public void insertNumOfSession(numofsession numofsession){
		try {
			String req4 = "INSERT INTO `numofsessionsperuser`(`UpTo1`, `UpTo5`, `UpTo10`, `UpTo20`, `UpTo50`) VALUES (?,?,?,?,?);";
			PreparedStatement preparedStatement = connection.prepareStatement(req4);			
			preparedStatement.setString(1, numofsession.getUpTo1());
			preparedStatement.setString(2, numofsession.getUpTo5());
			preparedStatement.setString(3, numofsession.getUpTo10());
			preparedStatement.setString(4, numofsession.getUpTo20());
			preparedStatement.setString(5, numofsession.getUpTo50());
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			printSQLException(e); }
	}
	   ////////////////////////////////////////////////////////////////
	public void insertDP(DP DP){
		try {
			String req7 = "INSERT INTO `deploymentparameters_dp_nffs`(`ServiceTitle`, `ProviderID`, `PaymentModelID`, `SubscriptionFee`, `IntendedUserID`, `LicenseTypeID`, `OpennessID`, `ServiceInterfaceID`, `LocationID`, `Version`, `ServiceURL`, `ShortDescription`, `SLA`, `SlaTokens`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,`SlaTokens`);";
			PreparedStatement preparedStatement = connection.prepareStatement(req7);			
			preparedStatement.setString(1, DP.getServiceTitle());
			preparedStatement.setString(2, DP.getProviderName());
			preparedStatement.setString(3, DP.getPaymentModelID());
			preparedStatement.setString(4, DP.getSubscriptionFee());
			preparedStatement.setString(5, DP.getIntendedUserID());
			preparedStatement.setString(6, DP.getLicenseTypeID());
			preparedStatement.setString(7, DP.getOpennessID());
			preparedStatement.setString(8, DP.getServiceInterfaceID());
			preparedStatement.setString(9, DP.getLocationID());
			preparedStatement.setString(10, DP.getVersion());
			preparedStatement.setString(11, DP.getServiceURL());
			preparedStatement.setString(12, DP.getShortDescription());
			preparedStatement.setString(13, DP.getSLA());
			
			
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			printSQLException(e); }
	}
	
    ////////////////////////////////////////////////////////////////
	public int getMAXIDProvider(){
		int max = 0;
		try {
			String req13 = "SELECT MAX(id) FROM `Provider`";
			PreparedStatement preparedStatement = connection.prepareStatement(req13);
			ResultSet r1 =  preparedStatement.executeQuery(req13);
			while(r1.next()){
				 max = r1.getInt("MAX(id)");
			}
		} catch (SQLException e) {
			printSQLException(e); }
		return max;
	}
    ////////////////////////////////////////////////////////////////	
	public int getIDLicenseType(license_type license_type){
		int max = 0;
		try {
			String req14 = "SELECT LicenseTypeID FROM `licensetype` WHERE Proprietary='"+license_type.getProprietary()+"' AND OpenSource= '"+license_type.getOpenSource()+"'";
			PreparedStatement preparedStatement = connection.prepareStatement(req14);
			System.out.println(preparedStatement);
			preparedStatement.executeQuery();
			ResultSet r1 =  preparedStatement.executeQuery(req14);
			while(r1.next()){
				 max = r1.getInt("LicenseTypeID");
			}
		} catch (SQLException e) {
			printSQLException(e); }
		return max;
	}
    ////////////////////////////////////////////////////////////////	

	public int getIDIntendedUser(intended_user intended_user){
		int max = 0;
		try {
			String req15 = "SELECT IntendedUserID FROM `intendeduser` WHERE Individuals='"+intended_user.getIndividuals()+"' AND Organizations= '"+intended_user.getOrganizations()+"'";
			PreparedStatement preparedStatement = connection.prepareStatement(req15);
			System.out.println(preparedStatement);
			preparedStatement.executeQuery();
			ResultSet r1 =  preparedStatement.executeQuery(req15);
			while(r1.next()){
				 max = r1.getInt("IntendedUserID");
			}
		} catch (SQLException e) {
			printSQLException(e); }
		return max;
	}
    ////////////////////////////////////////////////////////////////	

	public int getIDServiceInterface(service_interface service_interface){
		int max = 0;
		try {
			String req16 = "SELECT ServiceInterfaceID FROM `serviceinterface` WHERE WebPortal='"+service_interface.getWebPortal()+"' AND API= '"+service_interface.getAPI()+"' AND CLI= '"+service_interface.getCLI()+"'";
			PreparedStatement preparedStatement = connection.prepareStatement(req16);
			System.out.println(preparedStatement);
			preparedStatement.executeQuery();
			ResultSet r1 =  preparedStatement.executeQuery(req16);
			while(r1.next()){
				 max = r1.getInt("ServiceInterfaceID");
			}
		} catch (SQLException e) {
			printSQLException(e); }
		return max;
	}
    ////////////////////////////////////////////////////////////////

	public int getIDOpenness(openness openness){
		int max = 0;
		try {
			String req17 = "SELECT OpennessID FROM `openness` WHERE LimitedLevel='"+openness.getLimitedLevel()+"' AND BasicLevel= '"+openness.getBasicLevel()+"' AND CompleteLevel= '"+openness.getCompleteLevel()+"' AND ModerateLevel= '"+openness.getModerateLevel()+"'";
			PreparedStatement preparedStatement = connection.prepareStatement(req17);
			System.out.println(preparedStatement);
			preparedStatement.executeQuery();
			ResultSet r1 =  preparedStatement.executeQuery(req17);
			while(r1.next()){
				 max = r1.getInt("OpennessID");
			}
		} catch (SQLException e) {
			printSQLException(e); }
		return max;
	}
    ////////////////////////////////////////////////////////////////

	public int getIDPayement(payement payement){
		int max = 0;
		try {
			String req18 = "SELECT PaymentModelID FROM `paymentmodel` WHERE Free='"+payement.getFree()+"' AND PerUnit= '"+payement.getPerUnit()+"' AND Subscription= '"+payement.getSubscription()+"' AND Tiered= '"+payement.getTiered()+"'";
			PreparedStatement preparedStatement = connection.prepareStatement(req18);
			System.out.println(preparedStatement);
			preparedStatement.executeQuery();
			ResultSet r1 =  preparedStatement.executeQuery(req18);
			while(r1.next()){
				 max = r1.getInt("PaymentModelID");
			}
		} catch (SQLException e) {
			printSQLException(e); }
		return max;
	}
    ////////////////////////////////////////////////////////////////
	public int getIDLocation(location location){
		int max = 0;
		try {
			String req19 = "SELECT LocationID FROM `location` WHERE Africa='"+location.getAfrica()+"' AND Asia= '"+location.getAsia()+"' AND Australlia= '"+location.getAustrallia()+"' AND Europe_UK= '"+location.getEurope_UK()+"' AND US_Canada= '"+location.getUS_Canada()+"' AND MiddleeastNorthAfrica= '"+location.getMiddleeastNorthAfrica()+"'";
			PreparedStatement preparedStatement = connection.prepareStatement(req19);
			System.out.println(preparedStatement);
			preparedStatement.executeQuery();
			ResultSet r1 =  preparedStatement.executeQuery(req19);
			while(r1.next()){
				 max = r1.getInt("LocationID");
			}
		} catch (SQLException e) {
			printSQLException(e); }
		return max;
	}
    ////////////////////////////////////////////////////////////////
	public int getMaxNumOfSession(){
		int max = 0;
		try {
			String req19 = "SELECT MAX(NumOfSessionsPerUserID)FROM `numofsessionsperuser`";
			PreparedStatement preparedStatement = connection.prepareStatement(req19);
			System.out.println(preparedStatement);
			preparedStatement.executeQuery();
			ResultSet r1 =  preparedStatement.executeQuery(req19);
			while(r1.next()){
				 max = r1.getInt("MAX(NumOfSessionsPerUserID)");
			}
		} catch (SQLException e) {
			printSQLException(e); }
		return max;
	}
    ////////////////////////////////////////////////////////////////
	public int getMaxNumOfOperation(){
		int max = 0;
		try {
			String req19 = "SELECT MAX(NumOfOperationsPerSessionID) FROM `numofoperationspersession`";
			PreparedStatement preparedStatement = connection.prepareStatement(req19);
			System.out.println(preparedStatement);
			preparedStatement.executeQuery();
			ResultSet r1 =  preparedStatement.executeQuery(req19);
			while(r1.next()){
				 max = r1.getInt("MAX(NumOfOperationsPerSessionID)");
			}
		} catch (SQLException e) {
			printSQLException(e); }
		return max;
	}
    ////////////////////////////////////////////////////////////////
	public int getMaxNumOfUser(){
		int max = 0;
		try {
			String req19 = "SELECT MAX(NumOfUsersID) FROM `numofusers`";
			PreparedStatement preparedStatement = connection.prepareStatement(req19);
			System.out.println(preparedStatement);
			preparedStatement.executeQuery();
			ResultSet r1 =  preparedStatement.executeQuery(req19);
			while(r1.next()){
				 max = r1.getInt("MAX(NumOfUsersID)");
			}
		} catch (SQLException e) {
			printSQLException(e); }
		return max;
	}
	
    ////////////////////////////////////////////////////////////////
	public void insertHRM_NFF(HRM_NFF HRM_NFF){
		try {
			String req4 = "INSERT INTO `humanresourcemanagement_hrm_nffs`(`NumOfUsersID`, `NumOfSessionsPerUserID`, `NumOfOperationsPerSessionID`) VALUES (?,?,?);";
			PreparedStatement preparedStatement = connection.prepareStatement(req4);			
			preparedStatement.setString(1, HRM_NFF.getNumOfUsersID());
			preparedStatement.setString(2, HRM_NFF.getNumOfSessionsPerUserID());
			preparedStatement.setString(3, HRM_NFF.getNumOfOperationsPerSessionID());
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			printSQLException(e); }
	}
    ////////////////////////////////////////////////////////////////
	public void insertHRM(HRM HRM){
		try {
			String req4 = "INSERT INTO `humanresourcemanagement_hrm`(`DeploymentParameters_DP_NFFsID`, `HumanResourceManagement_HRM_NFFsID`, `QoSID`) VALUES (?,?,?);";
			PreparedStatement preparedStatement = connection.prepareStatement(req4);			
			preparedStatement.setString(1, HRM.getDeploymentParameters_DP_NFFsID());
			preparedStatement.setString(2, HRM.getHumanResourceManagement_HRM_NFFsID());
			preparedStatement.setString(3, HRM.getQoSID());
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			printSQLException(e); }
	}
	
	
    ////////////////////////////////////////////////////////////////	
	public void insertDataRedundancySupport(DataRedundancySupport DataRedundancySupport){
		try {
			String req2 = "INSERT INTO `dataredundancysupport`(`PREMIUM`, `HOT`, `COOL`, `ARCHIVE`) VALUES (?,?,?,?);";
			PreparedStatement preparedStatement = connection.prepareStatement(req2);			
			preparedStatement.setString(1, DataRedundancySupport.getPREMIUM());
			preparedStatement.setString(2, DataRedundancySupport.getHOT());
			preparedStatement.setString(3, DataRedundancySupport.getCOOL());
			preparedStatement.setString(4, DataRedundancySupport.getARCHIVE());
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			printSQLException(e); }
	}
	
    ////////////////////////////////////////////////////////////////	
	public void insertQuantityOfOperations(QuantityOfOperations QuantityOfOperations){
		try {
			String req2 = "INSERT INTO `quantityofoperations`(`UpTo5KOperationsPerMonth`, `UpTo10KOperationsPerMonth`, `UpTo25KOperationsPerMonth`, `UpTo50KOperationsPerMonth`, `UpTo100KOperationsPerMonth`, `UpTo250KOperationsPerMonth`,"
					+ "`UpTo500KOperationsPerMonth`, `UpTo1MOperationsPerMonth`, `UpTo2MOperationsPerMonth`, `UpTo5MOperationsPerMonth`) VALUES (?,?,?,?,?,?,?,?,?,?);";
			PreparedStatement preparedStatement = connection.prepareStatement(req2);			
			preparedStatement.setString(1, QuantityOfOperations.getUpTo5KOperationsPerMonth());
			preparedStatement.setString(2, QuantityOfOperations.getUpTo10KOperationsPerMonth());
			preparedStatement.setString(3, QuantityOfOperations.getUpTo25KOperationsPerMonth());
			preparedStatement.setString(4, QuantityOfOperations.getUpTo50KOperationsPerMonth());		
			preparedStatement.setString(5, QuantityOfOperations.getUpTo100KOperationsPerMonth());
			preparedStatement.setString(6, QuantityOfOperations.getUpTo250KOperationsPerMonth());
			preparedStatement.setString(7, QuantityOfOperations.getUpTo500KOperationsPerMonth());
			preparedStatement.setString(8, QuantityOfOperations.getUpTo1MOperationsPerMonth());
			preparedStatement.setString(9, QuantityOfOperations.getUpTo2MOperationsPerMonth());
			preparedStatement.setString(10,QuantityOfOperations.getUpTo5MOperationsPerMonth());
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			printSQLException(e); }
	}
    ////////////////////////////////////////////////////////////////	
	public void insertVolumeOfData(VolumeOfData VolumeOfData){
		try {
			String req2 = "INSERT INTO `volumeofdata`(`UpTo50GB`, `UpTo100GB`, `UpTo200GB`, `UpTo400GB`, `UpTo800GB`, `UpTo1TB`, `UpTo2TB`) VALUES (?,?,?,?,?,?,?);";
			PreparedStatement preparedStatement = connection.prepareStatement(req2);			
			preparedStatement.setString(1, VolumeOfData.getUpTo50GB());
			preparedStatement.setString(2, VolumeOfData.getUpTo100GB());
			preparedStatement.setString(3, VolumeOfData.getUpTo200GB());
			preparedStatement.setString(4, VolumeOfData.getUpTo400GB());
			preparedStatement.setString(5, VolumeOfData.getUpTo800GB());
			preparedStatement.setString(6, VolumeOfData.getUpTo1TB());
			preparedStatement.setString(7, VolumeOfData.getUpTo2TB());

			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			printSQLException(e); }
	}
    ////////////////////////////////////////////////////////////////	
	public int getMaxDataRedundancySupport(){
		int max = 0;
		try {
			String req19 = "SELECT MAX(DataRedundancySupportID) FROM `dataredundancysupport`";
			PreparedStatement preparedStatement = connection.prepareStatement(req19);
			System.out.println(preparedStatement);
			preparedStatement.executeQuery();
			ResultSet r1 =  preparedStatement.executeQuery(req19);
			while(r1.next()){
				 max = r1.getInt("MAX(DataRedundancySupportID)");
			}
		} catch (SQLException e) {
			printSQLException(e); }
		return max;
		
	}
    ////////////////////////////////////////////////////////////////	
	public int getMaxQuantityOfOperations(){
		int max = 0;
		try {
			String req19 = "SELECT MAX(QuantityOfOperationsID) FROM `quantityofoperations`";
			PreparedStatement preparedStatement = connection.prepareStatement(req19);
			System.out.println(preparedStatement);
			preparedStatement.executeQuery();
			ResultSet r1 =  preparedStatement.executeQuery(req19);
			while(r1.next()){
				 max = r1.getInt("MAX(QuantityOfOperationsID)");
			}
		} catch (SQLException e) {
			printSQLException(e); }
		return max;
		
	}
    ////////////////////////////////////////////////////////////////	
	public int getMaxVolumeOfData(){
		int max = 0;
		try {
			String req19 = "SELECT MAX(VolumeOfDataID) FROM `volumeofdata`";
			PreparedStatement preparedStatement = connection.prepareStatement(req19);
			System.out.println(preparedStatement);
			preparedStatement.executeQuery();
			ResultSet r1 =  preparedStatement.executeQuery(req19);
			while(r1.next()){
				 max = r1.getInt("MAX(VolumeOfDataID)");
			}
		} catch (SQLException e) {
			printSQLException(e); }
		return max;				
	}
    ////////////////////////////////////////////////////////////////
	public void insertSM_NFF(SM_NFF SM_NFF){
		try {
			String req4 = "INSERT INTO `streamingandmultimedia_sm_nffs`(`QuantityOfOperationsID`, `VolumeOfDataID`, `DataRedundancySupportID`, `DataStorageParamID`) VALUES (?,?,?,?);";
			PreparedStatement preparedStatement = connection.prepareStatement(req4);			
			preparedStatement.setString(1, SM_NFF.getQuantityOfOperationsID());
			preparedStatement.setString(2, SM_NFF.getVolumeOfDataID());
			preparedStatement.setString(3, SM_NFF.getDataRedundancySupportID());
			preparedStatement.setString(4, SM_NFF.getDataStorageParamID());
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
			
		} catch (SQLException e) {
			printSQLException(e);
			}
	}
    ////////////////////////////////////////////////////////////////
	public int getMaxSM_NFF(){
		int max = 0;
		try {
			String req19 = "SELECT MAX(StreamingAndMultimedia_SM_NFFsID)FROM `streamingandmultimedia_sm_nffs`";
			PreparedStatement preparedStatement = connection.prepareStatement(req19);
			System.out.println(preparedStatement);
			preparedStatement.executeQuery();
			ResultSet r1 =  preparedStatement.executeQuery(req19);
			while(r1.next()){
				 max = r1.getInt("MAX(StreamingAndMultimedia_SM_NFFsID)");
			}
		} catch (SQLException e) {
			printSQLException(e); }
		return max;
	}
    ////////////////////////////////////////////////////////////////
	public void insertSM(SM SM){
		try {
			String req4 = "INSERT INTO `streamingandmultimedia_sm`(`DeploymentParameters_DP_NFFsID`, `StreamingAndMultimedia_SM_NFFsID`, `QoSID`) VALUES (?,?,?);";
			PreparedStatement preparedStatement = connection.prepareStatement(req4);			
			preparedStatement.setString(1, SM.getDeploymentParameters_DP_NFFsID());
			preparedStatement.setString(2, SM.getStreamingAndMultimedia_SM_NFFsID());
			preparedStatement.setString(3, SM.getQoSID());
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			printSQLException(e); }
	}

    ////////////////////////////////////////////////////////////////
	public void insertQoS(QoS QoS){
		try {
			String req4 = "INSERT INTO `rt_nffs`(`ConsumabilityEffortsID`, `FaultToleranceEffortsID`, `MigrationabilityEffortsID`, `PerformanceID`, `ReliabilityEffortsID`, `RuntimeTunningID`, `ScalabilityEffortsID`, `SecurityEffortsID`, `StandardizedEffortsID`) VALUES (?,?,?,?,?,?,?,?,?);";
			PreparedStatement preparedStatement = connection.prepareStatement(req4);			
			preparedStatement.setString(1, QoS.getConsumabilityEfforts());
			preparedStatement.setString(2, QoS.getFaultToleranceEfforts());
			preparedStatement.setString(3, QoS.getMigrationabilityEfforts());
			preparedStatement.setString(4, QoS.getPerformance());
			preparedStatement.setString(5, QoS.getReliabilityEfforts());
			preparedStatement.setString(6, QoS.getRuntimeTunning());
			preparedStatement.setString(7, QoS.getScalabilityEfforts());
			preparedStatement.setString(8, QoS.getSecurityEfforts());
			preparedStatement.setString(9, QoS.getStandardizedEfforts());
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			printSQLException(e); }
	}
    ////////////////////////////////////////////////////////////////
	public void insertDiskSpace(DiskSpace DiskSpace){
		try {
			String req4 = "INSERT INTO `diskspace`(`Space_UpTo2GB`, `Space_UpTo4GB`, `Space_UpTo8GB`, `Space_UpTo16GB`, `Space_UpTo32GB`, `Space_UpTo64GB`, `Space_UpTo128GB`, `Space_UpTo256GB`, `Space_UpTo512GB`) VALUES (?,?,?,?,?,?,?,?,?);";
			PreparedStatement preparedStatement = connection.prepareStatement(req4);			
			preparedStatement.setString(1, DiskSpace.getSpace_UpTo2GB());
			preparedStatement.setString(2, DiskSpace.getSpace_UpTo4GB());
			preparedStatement.setString(3, DiskSpace.getSpace_UpTo8GB());
			preparedStatement.setString(4, DiskSpace.getSpace_UpTo16GB());
			preparedStatement.setString(5, DiskSpace.getSpace_UpTo32GB());
			preparedStatement.setString(6, DiskSpace.getSpace_UpTo64GB());
			preparedStatement.setString(7, DiskSpace.getSpace_UpTo128GB());
			preparedStatement.setString(8, DiskSpace.getSpace_UpTo256GB());
			preparedStatement.setString(9, DiskSpace.getSpace_UpTo512GB());
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			printSQLException(e); }
	}
    ////////////////////////////////////////////////////////////////
	public void insertDiskTransferRate(DiskTransferRate DiskTransferRate){
		try {
			String req4 = "INSERT INTO `disktransferrate`(`TransferRate_UpTo3000MBps`, `TransferRate_UpTo2400MBps`, `TransferRate_UpTo1200MBps`, `TransferRate_UpTo600MBps`, `TransferRate_UpTo400MBps`, `TransferRate_UpTo200MBps`, `TransferRate_UpTo100MBps`, `TransferRate_UpTo50MBps`) VALUES (?,?,?,?,?,?,?,?);";
			PreparedStatement preparedStatement = connection.prepareStatement(req4);			
			preparedStatement.setString(1, DiskTransferRate.getTransferRate_UpTo3000MBps());
			preparedStatement.setString(2, DiskTransferRate.getTransferRate_UpTo2400MBps());
			preparedStatement.setString(3, DiskTransferRate.getTransferRate_UpTo1200MBps());
			preparedStatement.setString(4, DiskTransferRate.getTransferRate_UpTo600MBps());
			preparedStatement.setString(5, DiskTransferRate.getTransferRate_UpTo400MBps());
			preparedStatement.setString(6, DiskTransferRate.getTransferRate_UpTo200MBps());
			preparedStatement.setString(7, DiskTransferRate.getTransferRate_UpTo100MBps());
			preparedStatement.setString(8, DiskTransferRate.getTransferRate_UpTo50MBps());
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			printSQLException(e); }
	}
    ////////////////////////////////////////////////////////////////
	public void insertHDD(HDD HDD){
		try {
			String req4 = "INSERT INTO `hddstorage`(`DiskSpaceID`, `DiskTransferRateID`) VALUES (?,?);";
			PreparedStatement preparedStatement = connection.prepareStatement(req4);			
			preparedStatement.setString(1, HDD.getDiskSpaceID());
			preparedStatement.setString(2, HDD.getDiskTransferRateID());
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			printSQLException(e); }
	}
    ////////////////////////////////////////////////////////////////
	public void insertSAS(SAS SAS){
		try {
			String req4 = "INSERT INTO `sasstorage`(`DiskSpaceID`, `DiskTransferRateID`) VALUES (?,?);";
			PreparedStatement preparedStatement = connection.prepareStatement(req4);			
			preparedStatement.setString(1, SAS.getDiskSpaceID());
			preparedStatement.setString(2, SAS.getDiskTransferRateID());
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			printSQLException(e); }
	}
    ////////////////////////////////////////////////////////////////
	public void insertSSD(SSD SSD){
		try {
			String req4 = "INSERT INTO `ssdstorage`(`DiskSpaceID`, `DiskTransferRateID`) VALUES (?,?);";
			PreparedStatement preparedStatement = connection.prepareStatement(req4);			
			preparedStatement.setString(1, SSD.getDiskSpaceID());
			preparedStatement.setString(2, SSD.getDiskTransferRateID());
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			printSQLException(e); }
	}
    ////////////////////////////////////////////////////////////////
	public int getMaxQoS(){
		int max = 0;
		try {
			String req19 = "SELECT MAX(QoSID)FROM `rt_nffs`";
			PreparedStatement preparedStatement = connection.prepareStatement(req19);
			System.out.println(preparedStatement);
			preparedStatement.executeQuery();
			ResultSet r1 =  preparedStatement.executeQuery(req19);
			while(r1.next()){
				 max = r1.getInt("MAX(QoSID)");
			}
		} catch (SQLException e) {
			printSQLException(e); }
		return max;
	}
    ////////////////////////////////////////////////////////////////
	public int getMaxDP(){
		int max = 0;
		try {
			String req19 = "SELECT MAX(DeploymentParameters_DP_NFFsID)FROM `deploymentparameters_dp_nffs`";
			PreparedStatement preparedStatement = connection.prepareStatement(req19);
			System.out.println(preparedStatement);
			preparedStatement.executeQuery();
			ResultSet r1 =  preparedStatement.executeQuery(req19);
			while(r1.next()){
				 max = r1.getInt("MAX(DeploymentParameters_DP_NFFsID)");
			}
		} catch (SQLException e) {
			printSQLException(e); }
		return max;
	}
    ////////////////////////////////////////////////////////////////
	public int getMaxHRM_NFF(){
		int max = 0;
		try {
			String req19 = "SELECT MAX(HumanResourceManagement_HRM_NFFsID)FROM `humanresourcemanagement_hrm_nffs`";
			PreparedStatement preparedStatement = connection.prepareStatement(req19);
			System.out.println(preparedStatement);
			preparedStatement.executeQuery();
			ResultSet r1 =  preparedStatement.executeQuery(req19);
			while(r1.next()){
				 max = r1.getInt("MAX(HumanResourceManagement_HRM_NFFsID)");
			}
		} catch (SQLException e) {
			printSQLException(e); }
		return max;
	}
    ////////////////////////////////////////////////////////////////		


    ////////////////////////////////////////////////////////////////		
 public static String authenticateUser(String Nom, String Motdepasse) {
	 String msg = null;	 
	 try {
			String req13 = "SELECT Motdepasse FROM `provider` where Nom ='"+Nom+"'";
			PreparedStatement preparedStatement = connection.prepareStatement(req13);
		//	preparedStatement.setString(1, Nom);
			ResultSet rs =  preparedStatement.executeQuery(req13);
			if(rs.next()){
				if(rs.getString(1).equals(Motdepasse)) { 
					msg = "success";
				} else {
					msg = "Invalid";}
				
			}else { msg="Invalidd"; }	
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			}
	return msg;	 
 }
 
 ////////////////////////////////////////////////////////////////
	public int getMaxDiskSpaceID(){
		int max = 0;
		try {
			String req19 = "SELECT MAX(DiskSpaceID)FROM `diskspace`";
			PreparedStatement preparedStatement = connection.prepareStatement(req19);
			System.out.println(preparedStatement);
			preparedStatement.executeQuery();
			ResultSet r1 =  preparedStatement.executeQuery(req19);
			while(r1.next()){
				 max = r1.getInt("MAX(DiskSpaceID)");
			}
		} catch (SQLException e) {
			printSQLException(e); }
		return max;
	}
	 ////////////////////////////////////////////////////////////////
		public int getMaxDiskTransferRateID(){
			int max = 0;
			try {
				String req19 = "SELECT MAX(DiskTransferRateID)FROM `disktransferrate`";
				PreparedStatement preparedStatement = connection.prepareStatement(req19);
				System.out.println(preparedStatement);
				preparedStatement.executeQuery();
				ResultSet r1 =  preparedStatement.executeQuery(req19);
				while(r1.next()){
					 max = r1.getInt("MAX(DiskTransferRateID)");
				}
			} catch (SQLException e) {
				printSQLException(e); }
			return max;
		}
     ////////////////////////////////////////////////////////////////
      	public void insertDataStorageParam(DataStorageParam DataStorageParam){
			try {
				String req4 = "INSERT INTO `datastorageparam`(`SSDStorageID`, `SASStorageID`, `HDDStorageID`) VALUES (?,?,?);";
				PreparedStatement preparedStatement = connection.prepareStatement(req4);			
				preparedStatement.setString(1, DataStorageParam.getSSDStorageID());
				preparedStatement.setString(2, DataStorageParam.getSASStorageID());
				preparedStatement.setString(3, DataStorageParam.getHDDStorageID());
				System.out.println(preparedStatement);
				preparedStatement.executeUpdate();
			} catch (SQLException e) {
				printSQLException(e); }
		}
		
	////////////////////////////////////////////////////////////////
		public int getMaxSSD(){
		 int max = 0;
			try {
			String req19 = "SELECT MAX(SSDStorageID)FROM `ssdstorage`";
			PreparedStatement preparedStatement = connection.prepareStatement(req19);
			System.out.println(preparedStatement);
			preparedStatement.executeQuery();
			ResultSet r1 =  preparedStatement.executeQuery(req19);
			while(r1.next()){
				 max = r1.getInt("MAX(SSDStorageID)");
				}
				} catch (SQLException e) {
					printSQLException(e); }
				return max;
			}
		////////////////////////////////////////////////////////////////
		public int getMaxSAS(){
		 int max = 0;
			try {
			String req19 = "SELECT MAX(SaSStorageID)FROM `sasstorage`";
			PreparedStatement preparedStatement = connection.prepareStatement(req19);
			System.out.println(preparedStatement);
			preparedStatement.executeQuery();
			ResultSet r1 =  preparedStatement.executeQuery(req19);
			while(r1.next()){
				 max = r1.getInt("MAX(SaSStorageID)");
				}
				} catch (SQLException e) {
					printSQLException(e); }
				return max;
			}
	////////////////////////////////////////////////////////////////
		public int getMaxHDD(){
		 int max = 0;
			try {
			String req19 = "SELECT MAX(HDDStorageID)FROM `hddstorage`";
			PreparedStatement preparedStatement = connection.prepareStatement(req19);
			System.out.println(preparedStatement);
			preparedStatement.executeQuery();
			ResultSet r1 =  preparedStatement.executeQuery(req19);
			while(r1.next()){
				 max = r1.getInt("MAX(HDDStorageID)");
				}
				} catch (SQLException e) {
					printSQLException(e); }
				return max;
			}
	////////////////////////////////////////////////////////////////
		public int getMaxDataStorageParam(){
		 int max = 0;
			try {
			String req19 = "SELECT MAX(DataStorageParamID)FROM `datastorageparam`";
			PreparedStatement preparedStatement = connection.prepareStatement(req19);
			System.out.println(preparedStatement);
			preparedStatement.executeQuery();
			ResultSet r1 =  preparedStatement.executeQuery(req19);
			while(r1.next()){
				 max = r1.getInt("MAX(DataStorageParamID)");
				}
				} catch (SQLException e) {
					printSQLException(e); }
				return max;
			}
 
    ////////////////////////////////////////////////////////////////
	private static void printSQLException(SQLException ex) {		
	 for (Throwable e : ex ) {
		 if(e instanceof SQLException) {
			 e.printStackTrace(System.err);
			 System.err.println("SQLState" +((SQLException) e).getSQLState());
			 System.err.println("Error Code" +((SQLException) e).getErrorCode());
			 System.err.println("Message" +e.getMessage());
			 Throwable t = ex.getCause();
			 while(t != null) {
				 System.out.println("Cause:" +t);
				 t=t.getCause();}
			 
		 }}}
   ////////////////////////////////////////////////////////////////	
}

