package Metier.entities;

public class FFInstance {
   private  String InstURI , DP_URI , DT_URI , QoS_URI;

public FFInstance(String instURI, String dP_URI, String dT_URI, String qoS_URI) {
	super();
	InstURI = instURI;
	DP_URI = dP_URI;
	DT_URI = dT_URI;
	QoS_URI = qoS_URI;
}

public FFInstance() {
	super();
}

public String getInstURI() {
	return InstURI;
}

public void setInstURI(String instURI) {
	InstURI = instURI;
}

public String getDP_URI() {
	return DP_URI;
}

public void setDP_URI(String dP_URI) {
	DP_URI = dP_URI;
}

public String getDT_URI() {
	return DT_URI;
}

public void setDT_URI(String dT_URI) {
	DT_URI = dT_URI;
}

public String getQoS_URI() {
	return QoS_URI;
}

public void setQoS_URI(String qoS_URI) {
	QoS_URI = qoS_URI;
}

}
