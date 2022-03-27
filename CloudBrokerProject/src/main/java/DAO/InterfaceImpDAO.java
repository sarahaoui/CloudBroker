package DAO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import Metier.entities.login;
import java.sql.SQLException;


public class InterfaceImpDAO implements InterfaceDAO{
		
	protected Connection getConnection() {
		Connection connection = null;
	    try{
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1/cloudfnf","root","");
		}catch (SQLException e) {		
			e.printStackTrace();
		}catch (ClassNotFoundException e) {			
			e.printStackTrace();}
		return connection;}
	
	private static final String INSERT_USERS = "INSERT INTO `login`(`nom`, `motdepasse`, `email`, `telephone`, `nom_entreprise`, `pays`) VALUES (?,?,?,?,?,?);";

	
	public void insertProvider(login provider){
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS)) {
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
