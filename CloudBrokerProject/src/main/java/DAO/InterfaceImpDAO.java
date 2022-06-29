package DAO;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Metier.entities.DP;

import Metier.entities.QoS;

import Metier.entities.intended_user;
import Metier.entities.license_type;
import Metier.entities.location;

import Metier.entities.openness;
import Metier.entities.payement;
import Metier.entities.provider;
import Metier.entities.service_interface;
import Metier.entities.tax_accounting;
import Metier.entities.user;

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
	public int insertUser(user user){
		int key=0;
		try {
			String INSERT_USERS = "INSERT INTO `user`(`Nom`, `Motdepasse`, `Email`, `Telephone`, `Nom_entreprise`, `Pays`) VALUES (?,?,?,?,?,?);";
			PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS,Statement.RETURN_GENERATED_KEYS);			
			preparedStatement.setString(1, user.getNom());
			preparedStatement.setString(2, user.getMotdepasse());
			preparedStatement.setString(3, user.getEmail());
			preparedStatement.setString(4, user.getTelephone());
			preparedStatement.setString(5, user.getNom_entreprise());
			preparedStatement.setString(6, user.getPays());
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
	public int insertDP(DP DP){
		int key=0;
		try {
			String req7 = "INSERT INTO `deploymentparameters_dp_nffs`(`ServiceTitle`, `ProviderID`, `PaymentModelID`, `IntendedUserID`, `LicenseTypeID`, `OpennessID`, `ServiceInterfaceID`, `LocationID`, `Version`, `ServiceURL`, `ShortDescription`, `SLA`, `SlaTokens`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?);";
			PreparedStatement preparedStatement = connection.prepareStatement(req7,Statement.RETURN_GENERATED_KEYS);			
			preparedStatement.setString(1, DP.getServiceTitle());
			preparedStatement.setString(2, DP.getProviderName());
			preparedStatement.setString(3, DP.getPaymentModelID());
			preparedStatement.setString(4, DP.getIntendedUserID());
			preparedStatement.setString(5, DP.getLicenseTypeID());
			preparedStatement.setString(6, DP.getOpennessID());
			preparedStatement.setString(7, DP.getServiceInterfaceID());
			preparedStatement.setString(8, DP.getLocationID());
			preparedStatement.setString(9, DP.getVersion());
			preparedStatement.setString(10, DP.getServiceURL());
			preparedStatement.setString(11, DP.getShortDescription());
			preparedStatement.setString(12, DP.getsLA());
			preparedStatement.setString(13, DP.getsLATokens());
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
			
			ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
			if(generatedKeys.next()) {
				 key=(generatedKeys.getInt(1));
			}else {
				System.out.println("Creating user failed , no ID obtained !!");
			}
		} catch (SQLException e) {
			printSQLException(e); 
			}
		return key;
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
	public static int getIDService(String name){
		int max = 0;
		try {
			String req14 = "SELECT `DeploymentParameters_DP_NFFsID` FROM `deploymentparameters_dp_nffs` WHERE `ServiceTitle`='"+name+"'";
			PreparedStatement preparedStatement = connection.prepareStatement(req14);
			System.out.println(preparedStatement);
			preparedStatement.executeQuery();
			ResultSet r1 =  preparedStatement.executeQuery(req14);
			while(r1.next()){
				 max = r1.getInt("DeploymentParameters_DP_NFFsID");
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
	public int insertQoS(QoS QoS){
		int key=0;
		try {
			String req4 = "INSERT INTO `rt_nffs`( `price`, `availability`,`rating`) VALUES (?,?,?);";
			PreparedStatement preparedStatement = connection.prepareStatement(req4,Statement.RETURN_GENERATED_KEYS);			
			preparedStatement.setDouble(1, QoS.getPrice());
			preparedStatement.setInt(2, QoS.getAvailability());
			preparedStatement.setDouble(3, 0.0);
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
			
			ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
			if(generatedKeys.next()) {
				 key=(generatedKeys.getInt(1));
			}else {
				System.out.println("Creating qos failed , no ID obtained !!");
			}
		} catch (SQLException e) {
		//	printSQLException(e); 
			}
		return key;
	}
	public static int insertOrder(int idService, int idUser){
		int key=0;
		try {
			String req4 = "INSERT INTO `order`( `IDUser`, `IDService`) VALUES (?,?);";
			PreparedStatement preparedStatement = connection.prepareStatement(req4,Statement.RETURN_GENERATED_KEYS);			
			preparedStatement.setInt(1, idUser);
			preparedStatement.setInt(2, idService);
			
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
			
			ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
			if(generatedKeys.next()) {
				 key=(generatedKeys.getInt(1));
			}else {
				System.out.println("Creating qos failed , no ID obtained !!");
			}
		} catch (SQLException e) {
			printSQLException(e); 
			}
		return key;
	}


    ////////////////////////////////////////////////////////////////		
 public static String authenticateProvider(String Nom, String Motdepasse) {
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
   public static String authenticateUser(String Nom, String Motdepasse) {
	 String msg = null;	 
	 try {
			String req14 = "SELECT Motdepasse FROM `user` where Nom ='"+Nom+"'";
			PreparedStatement preparedStatement = connection.prepareStatement(req14);
			ResultSet rs =  preparedStatement.executeQuery(req14);
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
public static String authenticateAdmin(String Username, String password) {
	 String msg = null;	 
	 try {
			String req15 = "SELECT password FROM `admin` where Username ='"+Username+"'";
			PreparedStatement preparedStatement = connection.prepareStatement(req15);
			ResultSet rs =  preparedStatement.executeQuery(req15);
			if(rs.next()){
				if(rs.getString(1).equals(password)) { 
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

    	public int getIDProvider(provider provider){
    		int id = 0;
    		try {
    			String req15 = "SELECT ID FROM `provider` WHERE Nom='"+provider.getNom()+"' AND Motdepasse= '"+provider.getMotdepasse()+"'";
    			PreparedStatement preparedStatement = connection.prepareStatement(req15);
    			System.out.println(preparedStatement);
    			preparedStatement.executeQuery();
    			ResultSet r1 =  preparedStatement.executeQuery(req15);
    			while(r1.next()){
    				 id = r1.getInt("ID");
    			}
    		} catch (SQLException e) {
    			printSQLException(e); }
    		return id;
    	}
    	///////////////////////////////////////
    	public String getName(provider provider){
    		String name = "";
    		try {
    			String req15 = "SELECT Nom FROM `provider` WHERE Nom='"+provider.getNom()+"' AND Motdepasse= '"+provider.getMotdepasse()+"'";
    			PreparedStatement preparedStatement = connection.prepareStatement(req15);
    			System.out.println(preparedStatement);
    			preparedStatement.executeQuery();
    			ResultSet r1 =  preparedStatement.executeQuery(req15);
    			while(r1.next()){
    				 name = r1.getString("Nom");
    			}
    		} catch (SQLException e) {
    			printSQLException(e); }
    		return name;
    	}
    	///////////////////////////////////////
    	public String getEmail(provider provider){
    		String email = "";
    		try {
    			String req15 = "SELECT Email FROM `provider` WHERE Nom='"+provider.getNom()+"' AND Motdepasse= '"+provider.getMotdepasse()+"'";
    			PreparedStatement preparedStatement = connection.prepareStatement(req15);
    			System.out.println(preparedStatement);
    			preparedStatement.executeQuery();
    			ResultSet r1 =  preparedStatement.executeQuery(req15);
    			while(r1.next()){
    				 email = r1.getString("Email");
    			}
    		} catch (SQLException e) {
    			printSQLException(e); }
    		return email;
    	}
    	public int getIDUser(user user){
    		int id = 0;
    		try {
    			String req15 = "SELECT ID FROM `user` WHERE Nom='"+user.getNom()+"' AND Motdepasse= '"+user.getMotdepasse()+"'";
    			PreparedStatement preparedStatement = connection.prepareStatement(req15);
    			System.out.println(preparedStatement);
    			preparedStatement.executeQuery();
    			ResultSet r1 =  preparedStatement.executeQuery(req15);
    			while(r1.next()){
    				 id = r1.getInt("ID");
    			}
    		} catch (SQLException e) {
    			printSQLException(e); }
    		return id;
    	}
    	///////////////////////////////////////
    	public String getNameUser(user user){
    		String name = "";
    		try {
    			String req15 = "SELECT Nom FROM `user` WHERE Nom='"+user.getNom()+"' AND Motdepasse= '"+user.getMotdepasse()+"'";
    			PreparedStatement preparedStatement = connection.prepareStatement(req15);
    			System.out.println(preparedStatement);
    			preparedStatement.executeQuery();
    			ResultSet r1 =  preparedStatement.executeQuery(req15);
    			while(r1.next()){
    				 name = r1.getString("Nom");
    			}
    		} catch (SQLException e) {
    			printSQLException(e); }
    		return name;
    	}
    	///////////////////////////////////////
    	public String getEmailUser(user user){
    		String email = "";
    		try {
    			String req15 = "SELECT Email FROM `user` WHERE Nom='"+user.getNom()+"' AND Motdepasse= '"+user.getMotdepasse()+"'";
    			PreparedStatement preparedStatement = connection.prepareStatement(req15);
    			System.out.println(preparedStatement);
    			preparedStatement.executeQuery();
    			ResultSet r1 =  preparedStatement.executeQuery(req15);
    			while(r1.next()){
    				 email = r1.getString("Email");
    			}
    		} catch (SQLException e) {
    			printSQLException(e); }
    		return email;
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
	public void insertTax_Acc(tax_accounting acc) {
		
		try {
			String req4 = "INSERT INTO `tax_accounting`( `DeploymentParameters_DP_NFFsID`, `QoSID`) VALUES (?,?);";
			PreparedStatement preparedStatement = connection.prepareStatement(req4,Statement.RETURN_GENERATED_KEYS);			
			preparedStatement.setInt(1,Integer.parseInt(acc.getDeploymentParameters_DP_NFFsID()) );
			preparedStatement.setInt(2, Integer.parseInt(acc.getQoSID()));

			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
			
			
			
		} catch (SQLException e) {
			printSQLException(e); 
			}
		
		
	}
	public static ArrayList<DP> GetServices(int idprovider) {
		ArrayList<DP> services = new ArrayList<DP>();
		try {
			String req15 = "SELECT `ServiceTitle`, `Version` FROM `deploymentparameters_dp_nffs` `deploymentparameters_dp_nffs` WHERE  ProviderID='"+idprovider+"'";
			PreparedStatement preparedStatement = connection.prepareStatement(req15);
			System.out.println(preparedStatement);
			preparedStatement.executeQuery();
			ResultSet r1 =  preparedStatement.executeQuery(req15);
			while(r1.next()){
				 String titre = r1.getString("ServiceTitle"); 
				 String version = r1.getString("Version");
				 DP dp = new DP();
				 dp.setServiceTitle(titre);
				 dp.setVersion(version);
				 services.add(dp);
			}
		} catch (SQLException e) {
			printSQLException(e); }
		
	
		return services;
		
	}
}