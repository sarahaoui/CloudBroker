package Metier.entities;

public class DiskSpace {
 private int ID;
 private String Space_UpTo2GB;
 private String Space_UpTo4GB;
 private String Space_UpTo8GB;
 private String Space_UpTo16GB;
 private String Space_UpTo32GB;
 private String Space_UpTo64GB;
 private String Space_UpTo128GB;
 private String Space_UpTo256GB;
 private String Space_UpTo512GB;

 public DiskSpace() {
	 super();
	}
	
	public DiskSpace(int ID, String Space_UpTo2GB, String Space_UpTo4GB, String Space_UpTo8GB, String Space_UpTo16GB, String Space_UpTo32GB, String Space_UpTo64GB, String Space_UpTo128GB, String Space_UpTo256GB, String Space_UpTo512GB) {
		super();
		this.ID = ID;
		this.Space_UpTo2GB = Space_UpTo2GB;
		this.Space_UpTo4GB = Space_UpTo4GB;
		this.Space_UpTo8GB = Space_UpTo8GB;	
		this.Space_UpTo16GB = Space_UpTo16GB;
		this.Space_UpTo32GB = Space_UpTo32GB;			
		this.Space_UpTo64GB = Space_UpTo64GB;
		this.Space_UpTo128GB = Space_UpTo128GB;
		this.Space_UpTo256GB = Space_UpTo256GB;		
		this.Space_UpTo512GB = Space_UpTo512GB;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getSpace_UpTo2GB() {
		return Space_UpTo2GB;
	}

	public void setSpace_UpTo2GB(String space_UpTo2GB) {
		Space_UpTo2GB = space_UpTo2GB;
	}

	public String getSpace_UpTo4GB() {
		return Space_UpTo4GB;
	}

	public void setSpace_UpTo4GB(String space_UpTo4GB) {
		Space_UpTo4GB = space_UpTo4GB;
	}

	public String getSpace_UpTo8GB() {
		return Space_UpTo8GB;
	}

	public void setSpace_UpTo8GB(String space_UpTo8GB) {
		Space_UpTo8GB = space_UpTo8GB;
	}

	public String getSpace_UpTo16GB() {
		return Space_UpTo16GB;
	}

	public void setSpace_UpTo16GB(String space_UpTo16GB) {
		Space_UpTo16GB = space_UpTo16GB;
	}

	public String getSpace_UpTo32GB() {
		return Space_UpTo32GB;
	}

	public void setSpace_UpTo32GB(String space_UpTo32GB) {
		Space_UpTo32GB = space_UpTo32GB;
	}

	public String getSpace_UpTo64GB() {
		return Space_UpTo64GB;
	}

	public void setSpace_UpTo64GB(String space_UpTo64GB) {
		Space_UpTo64GB = space_UpTo64GB;
	}

	public String getSpace_UpTo128GB() {
		return Space_UpTo128GB;
	}

	public void setSpace_UpTo128GB(String space_UpTo128GB) {
		Space_UpTo128GB = space_UpTo128GB;
	}

	public String getSpace_UpTo256GB() {
		return Space_UpTo256GB;
	}

	public void setSpace_UpTo256GB(String space_UpTo256GB) {
		Space_UpTo256GB = space_UpTo256GB;
	}

	public String getSpace_UpTo512GB() {
		return Space_UpTo512GB;
	}

	public void setSpace_UpTo512GB(String space_UpTo512GB) {
		Space_UpTo512GB = space_UpTo512GB;
	}
	
}

