package Metier.entities;

public class intended_user {
	private String Individuals;
	 private String Organizations;
	 
	 
	 public intended_user() {
		 super();
		}
		
		public intended_user(String Individuals, String Organizations) {
			super();
			this.Individuals = Individuals;
			this.Organizations = Organizations;
		}

		public String getIndividuals() {
			return Individuals;
		}

		public void setIndividuals(String individuals) {
			Individuals = individuals;
		}

		public String getOrganizations() {
			return Organizations;
		}

		public void setOrganizations(String organizations) {
			Organizations = organizations;
		}

}
