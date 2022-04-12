package Metier.entities;

public class openness {
 private String ID;
 private String LimitedLevel;
 private String BasicLevel;
 private String CompleteLevel;
 private String ModerateLevel;
 
 
 
 public openness() {
	 super();
	}
	
	public openness(String ID, String LimitedLevel, String BasicLevel, String CompleteLevel, String ModerateLevel) {
		super();
		this.ID = ID;
		this.LimitedLevel = LimitedLevel;
		this.BasicLevel = BasicLevel;
		this.CompleteLevel = CompleteLevel;
		this.ModerateLevel = ModerateLevel;
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getLimitedLevel() {
		return LimitedLevel;
	}

	public void setLimitedLevel(String limitedLevel) {
		LimitedLevel = limitedLevel;
	}

	public String getBasicLevel() {
		return BasicLevel;
	}

	public void setBasicLevel(String basicLevel) {
		BasicLevel = basicLevel;
	}

	public String getCompleteLevel() {
		return CompleteLevel;
	}

	public void setCompleteLevel(String completeLevel) {
		CompleteLevel = completeLevel;
	}

	public String getModerateLevel() {
		return ModerateLevel;
	}

	public void setModerateLevel(String moderateLevel) {
		ModerateLevel = moderateLevel;
	}
 
}
