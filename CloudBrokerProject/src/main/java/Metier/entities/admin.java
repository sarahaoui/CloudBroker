package Metier.entities;

public class admin {
 private static String Username;
 private String password;
 
 
 public admin() {
	 super();
	}
	
	public admin(String Username, String password) {
		super();		
		this.Username = Username;
		this.password = password;
	}

	public static String getUsername() {
		return Username;
	}

	public static void setUsername(String username) {
		Username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


 
}