package Metier.entities;


public class SM {
 private String DeploymentParameters_DP_NFFsID;
 private String StreamingAndMultimedia_SM_NFFsID;
 private String QoSID;
 

 public SM() {
	 super();
	}
	
	public SM(String DeploymentParameters_DP_NFFsID, String StreamingAndMultimedia_SM_NFFsID, String QoSID) {
		super();
		this.DeploymentParameters_DP_NFFsID = DeploymentParameters_DP_NFFsID;
		this.StreamingAndMultimedia_SM_NFFsID = StreamingAndMultimedia_SM_NFFsID;
		this.QoSID = QoSID;		
	}

	public String getDeploymentParameters_DP_NFFsID() {
		return DeploymentParameters_DP_NFFsID;
	}

	public void setDeploymentParameters_DP_NFFsID(String deploymentParameters_DP_NFFsID) {
		DeploymentParameters_DP_NFFsID = deploymentParameters_DP_NFFsID;
	}

	public String getStreamingAndMultimedia_SM_NFFsID() {
		return StreamingAndMultimedia_SM_NFFsID;
	}

	public void setStreamingAndMultimedia_SM_NFFsID(String streamingAndMultimedia_SM_NFFsID) {
		StreamingAndMultimedia_SM_NFFsID = streamingAndMultimedia_SM_NFFsID;
	}

	public String getQoSID() {
		return QoSID;
	}

	public void setQoSID(String qoSID) {
		QoSID = qoSID;
	}

	
}

