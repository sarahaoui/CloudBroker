package Metier.entities;

import java.io.Serializable;

public class QoS implements Serializable {
private int ID;
 private int availability;
 private Double price;
 private Double rating;
 private String AvailabilityR,RatingR,PriceR;

 public QoS() {
	 super();
	}


public String getAvailabilityR() {
	return AvailabilityR;
}


public void setAvailabilityR(String availabilityR) {
	AvailabilityR = availabilityR;
}


public String getRatingR() {
	return RatingR;
}


public void setRatingR(String ratingR) {
	RatingR = ratingR;
}


public String getPriceR() {
	return PriceR;
}


public void setPriceR(String priceR) {
	PriceR = priceR;
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

