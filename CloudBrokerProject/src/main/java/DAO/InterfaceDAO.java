package DAO;

import Metier.entities.DP;

import Metier.entities.QoS;

import Metier.entities.intended_user;
import Metier.entities.license_type;
import Metier.entities.location;

import Metier.entities.openness;
import Metier.entities.payement;
import Metier.entities.provider;
import Metier.entities.service_interface;
import Metier.entities.user;

public interface InterfaceDAO {
	public int insertProvider(provider provider);  //done
	public static String authenticateProvider(String Nom, String Motdepasse) {
	  return null;}
    public int insertDP(DP DP);  //done  
    public int getIDLicenseType(license_type license_type);   //done
    public int getIDIntendedUser(intended_user intended_user);   //done
    public int getIDServiceInterface(service_interface service_interface);    //done
    public int getIDOpenness(openness openness);   //done
    public int getIDPayement(payement payement);   //done
    public int getIDLocation(location location);    //done 
	public int insertQoS(QoS QoS);     //done

    public int insertUser(user user);     //done
	public static String authenticateUser(String Nom, String Motdepasse) {
		  return null;}     //done
	public static String authenticateAdmin(String Username, String password) {
		  return null;}     //done
	






	
	}
