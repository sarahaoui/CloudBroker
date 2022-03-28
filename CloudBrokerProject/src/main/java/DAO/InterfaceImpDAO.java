package DAO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import Metier.entities.login;


public class InterfaceImpDAO implements InterfaceDAO{
		
	Connection connection= SingletonConnection.getConnection();
	
	

	
	public void insertProvider(login provider){
		try {
		    String INSERT_USERS = "INSERT INTO `provider`(`nom`, `motdepasse`, `email`, `telephone`, `nom_entreprise`, `pays`) VALUES (?,?,?,?,?,?);";
			PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS);
			preparedStatement.setString(1, provider.getNom());
			preparedStatement.setString(2, provider.getMotdepasse());
			preparedStatement.setString(3, provider.getEmail());
			preparedStatement.setString(4, provider.getTelephone());
			preparedStatement.setString(5, provider.getNom_entreprise());
			preparedStatement.setString(6, provider.getPays());
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			printSQLException(e); }
	}

	private void printSQLException(SQLException ex) {		
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
			 
		 }
	 }
	}

	
}
