package Metier.entities;


public class HRM {
 private String DeploymentParameters_DP_NFFsID;
 private String HumanResourceManagement_HRM_NFFsID;
 private String QoSID;
 

 public HRM() {
	 super();
	}
	
	public HRM(String DeploymentParameters_DP_NFFsID, String HumanResourceManagement_HRM_NFFsID, String QoSID) {
		super();
		this.DeploymentParameters_DP_NFFsID = DeploymentParameters_DP_NFFsID;
		this.HumanResourceManagement_HRM_NFFsID = HumanResourceManagement_HRM_NFFsID;
		this.QoSID = QoSID;		
	}

	public String getDeploymentParameters_DP_NFFsID() {
		return DeploymentParameters_DP_NFFsID;
	}

	public void setDeploymentParameters_DP_NFFsID(String deploymentParameters_DP_NFFsID) {
		DeploymentParameters_DP_NFFsID = deploymentParameters_DP_NFFsID;
	}

	public String getHumanResourceManagement_HRM_NFFsID() {
		return HumanResourceManagement_HRM_NFFsID;
	}

	public void setHumanResourceManagement_HRM_NFFsID(String humanResourceManagement_HRM_NFFsID) {
		HumanResourceManagement_HRM_NFFsID = humanResourceManagement_HRM_NFFsID;
	}

	public String getQoSID() {
		return QoSID;
	}

	public void setQoSID(String qoSID) {
		QoSID = qoSID;
	}

	
}

