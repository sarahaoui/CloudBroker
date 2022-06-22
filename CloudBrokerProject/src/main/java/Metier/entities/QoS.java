package Metier.entities;

public class QoS {
private int ID;
 private int availability;
 private Double price;
 private Double rating;

 public QoS() {
	 super();
	}


public Double getRating() {
	return rating;
}


public void setRating(Double rating) {
	this.rating = rating;
}


public int getID() {
	return ID;
}


public void setID(int iD) {
	ID = iD;
}


public int getAvailability() {
	return availability;
}


public void setAvailability(int availability) {
	this.availability = availability;
}


public Double getPrice() {
	return price;
}


public void setPrice(Double price) {
	this.price = price;
}
	
	
}

