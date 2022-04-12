package Metier.entities;


public class VolumeOfData {
 private String UpTo50GB;
 private String UpTo100GB;
 private String UpTo200GB;
 private String UpTo400GB;
 private String UpTo800GB;
 private String UpTo1TB;
 private String UpTo2TB;




 public VolumeOfData() {
	 super();
	}
	
	public VolumeOfData(String UpTo50GB, String UpTo100GB, String UpTo200GB, String UpTo400GB, String UpTo800GB, String UpTo1TB, String UpTo2TB) {
		super();
		this.UpTo50GB = UpTo50GB;
		this.UpTo100GB = UpTo100GB;
		this.UpTo200GB = UpTo200GB;	
		this.UpTo400GB = UpTo400GB;
		this.UpTo800GB = UpTo800GB;	
		
		this.UpTo1TB = UpTo1TB;
		this.UpTo2TB = UpTo2TB;

	}

	public String getUpTo50GB() {
		return UpTo50GB;
	}

	public void setUpTo50GB(String upTo50GB) {
		UpTo50GB = upTo50GB;
	}

	public String getUpTo100GB() {
		return UpTo100GB;
	}

	public void setUpTo100GB(String upTo100GB) {
		UpTo100GB = upTo100GB;
	}

	public String getUpTo200GB() {
		return UpTo200GB;
	}

	public void setUpTo200GB(String upTo200GB) {
		UpTo200GB = upTo200GB;
	}

	public String getUpTo400GB() {
		return UpTo400GB;
	}

	public void setUpTo400GB(String upTo400GB) {
		UpTo400GB = upTo400GB;
	}

	public String getUpTo800GB() {
		return UpTo800GB;
	}

	public void setUpTo800GB(String upTo800GB) {
		UpTo800GB = upTo800GB;
	}

	public String getUpTo1TB() {
		return UpTo1TB;
	}

	public void setUpTo1TB(String upTo1TB) {
		UpTo1TB = upTo1TB;
	}

	public String getUpTo2TB() {
		return UpTo2TB;
	}

	public void setUpTo2TB(String upTo2TB) {
		UpTo2TB = upTo2TB;
	}

	
}


