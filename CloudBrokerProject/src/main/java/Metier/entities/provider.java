package Metier.entities;

public class provider {
 private static String Nom;
 private String Motdepasse;
 private String email;
 private String telephone;
 private String nom_entreprise;
 private String pays;
 
 
 
 public provider() {
	 super();
	}
	
	public provider(String Nom, String Motdepasse, String email, String telephone, String nom_entreprise, String pays) {
		super();
		this.Nom = Nom;
		this.Motdepasse = Motdepasse;
		this.email = email;
		this.telephone = telephone;
		this.nom_entreprise = nom_entreprise;
		this.pays = pays;
	}



public static String getNom() {
	return Nom;
}
public void setNom(String Nom) {
	this.Nom = Nom;
}
public String getMotdepasse() {
	return Motdepasse;
}
public void setMotdepasse(String Motdepasse) {
	this.Motdepasse = Motdepasse;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getTelephone() {
	return telephone;
}
public void setTelephone(String telephone) {
	this.telephone = telephone;
}
public String getNom_entreprise() {
	return nom_entreprise;
}
public void setNom_entreprise(String nom_entreprise) {
	this.nom_entreprise = nom_entreprise;
}
public String getPays() {
	return pays;
}
public void setPays(String pays) {
	this.pays = pays;
}
 
 
}
