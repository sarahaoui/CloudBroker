package Metier.entities;

public class login {
 private String nom;
 private String motdepasse;
 private String email;
 private String telephone;
 private String nom_entreprise;
 private String pays;
 
 
 
 public login() {
	 super();
	}
	
	public login(String nom, String motdepasse, String email, String telephone, String nom_entreprise, String pays) {
		super();
		this.nom = nom;
		this.motdepasse = motdepasse;
		this.email = email;
		this.telephone = telephone;
		this.nom_entreprise = nom_entreprise;
		this.pays = pays;
	}



public String getNom() {
	return nom;
}
public void setNom(String nom) {
	this.nom = nom;
}
public String getMotdepasse() {
	return motdepasse;
}
public void setMotdepasse(String motdepasse) {
	this.motdepasse = motdepasse;
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
