package DAO;

import java.sql.SQLException;
import java.util.List;

import Metier.entities.login;


public class Test {

	public static void main(String[] args) throws SQLException {
    InterfaceImpDAO imp = new InterfaceImpDAO();
		
		/***********Ajouter Provider*****************/
           login newUser= new login();
           newUser.setNom("Azure"); 
           newUser.setEmail("yamrouni74@gmail.com");
           newUser.setTelephone("0556610834");
           
           newUser.setMotdepasse("Aa02148mk");
           newUser.setNom_entreprise("Google");
           newUser.setPays("France");
          
         
          imp.insertProvider(newUser);        
   
	}

}
