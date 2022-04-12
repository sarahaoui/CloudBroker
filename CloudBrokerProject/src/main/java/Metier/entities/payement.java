package Metier.entities;

public class payement {
 private String Free;
 private String PerUnit;
 private String Subscription;
 private String Tiered;
 
 
 
 public payement() {
	 super();
	}
	
	public payement(String Free, String PerUnit, String Subscription, String Tiered) {
		super();
		this.Free = Free;
		this.PerUnit = PerUnit;
		this.Subscription	 = Subscription	;
		this.Tiered = Tiered;
	}

	public String getFree() {
		return Free;
	}

	public void setFree(String free) {
		Free = free;
	}

	public String getPerUnit() {
		return PerUnit;
	}

	public void setPerUnit(String perUnit) {
		PerUnit = perUnit;
	}

	public String getSubscription() {
		return Subscription;
	}

	public void setSubscription(String subscription) {
		Subscription = subscription;
	}

	public String getTiered() {
		return Tiered;
	}

	public void setTiered(String tiered) {
		Tiered = tiered;
	}

	
}
