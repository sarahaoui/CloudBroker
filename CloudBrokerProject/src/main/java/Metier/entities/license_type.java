package Metier.entities;

public class license_type {
	private String Proprietary;
	 private String OpenSource;
	
	
	 
	 
	 public license_type() {
		 super();
		}
		
		public license_type(String Proprietary, String OpenSource) {
			super();
			this.Proprietary = Proprietary;
			this.OpenSource = OpenSource;}

		public String getProprietary() {
			return Proprietary;
		}

		public void setProprietary(String proprietary) {
			Proprietary = proprietary;
		}

		public String getOpenSource() {
			return OpenSource;
		}

		public void setOpenSource(String openSource) {
			OpenSource = openSource;
		}

}
