package Metier.entities;


public class DP {
 private int ID;
 private String ServiceTitle;
 private String ProviderName;
 private String SubscriptionFee;
 private String SLA;
 private String Version;
 private String ServiceURL;
 private String SLATokens;
 private String ShortDescription;
 private String PaymentModelID;
 private String IntendedUserID;
 private String LicenseTypeID;
 private String LocationID;
 private String OpennessID;
 private String ServiceInterfaceID;

 
 
 
 
 public DP() {
	 super();
	}
	
	public DP(int ID, String ServiceTitle, String ProviderName, String SubscriptionFee, String SLA, String Version, String ServiceURL, String SLATokens, String ShortDescription, String PaymentModelID, String IntendedUserID, String LicenseTypeID, String LocationID, String OpennessID, String ServiceInterfaceID) {
		super();
		this.ID = ID;
		this.ServiceTitle = ServiceTitle;
		this.ProviderName = ProviderName;
		this.SubscriptionFee = SubscriptionFee;
		this.SLA = SLA;
		this.Version = Version;
		this.ServiceURL = ServiceURL;
		this.SLATokens = SLATokens;
		this.ShortDescription = ShortDescription;
		this.PaymentModelID = PaymentModelID;
		this.IntendedUserID = IntendedUserID;
		this.LicenseTypeID = LicenseTypeID;
		this.LocationID = LocationID;
		this.OpennessID = OpennessID;
		this.ServiceInterfaceID = ServiceInterfaceID;
	}

	
	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getProviderName() {
		return ProviderName;
	}

	public void setProviderName(String providerName) {
		ProviderName = providerName;
	}

	public String getServiceTitle() {
		return ServiceTitle;
	}

	public void setServiceTitle(String serviceTitle) {
		ServiceTitle = serviceTitle;
	}

	public String getSubscriptionFee() {
		return SubscriptionFee;
	}

	public void setSubscriptionFee(String subscriptionFee) {
		SubscriptionFee = subscriptionFee;
	}

	public String getSLA() {
		return SLA;
	}

	public void setSLA(String sLA) {
		SLA = sLA;
	}

	public String getVersion() {
		return Version;
	}

	public void setVersion(String version) {
		Version = version;
	}

	public String getServiceURL() {
		return ServiceURL;
	}

	public void setServiceURL(String serviceURL) {
		ServiceURL = serviceURL;
	}

	public String getSLATokens() {
		return SLATokens;
	}

	public void setSLATokens(String sLATokens) {
		SLATokens = sLATokens;
	}

	public String getShortDescription() {
		return ShortDescription;
	}

	public void setShortDescription(String shortDescription) {
		ShortDescription = shortDescription;
	}

	public String getPaymentModelID() {
		return PaymentModelID;
	}

	public void setPaymentModelID(String paymentModelID) {
		PaymentModelID = paymentModelID;
	}

	public String getIntendedUserID() {
		return IntendedUserID;
	}

	public void setIntendedUserID(String intendedUserID) {
		IntendedUserID = intendedUserID;
	}

	public String getLicenseTypeID() {
		return LicenseTypeID;
	}

	public void setLicenseTypeID(String licenseTypeID) {
		LicenseTypeID = licenseTypeID;
	}

	public String getLocationID() {
		return LocationID;
	}

	public void setLocationID(String locationID) {
		LocationID = locationID;
	}

	public String getOpennessID() {
		return OpennessID;
	}

	public void setOpennessID(String opennessID) {
		OpennessID = opennessID;
	}

	public String getServiceInterfaceID() {
		return ServiceInterfaceID;
	}

	public void setServiceInterfaceID(String serviceInterfaceID) {
		ServiceInterfaceID = serviceInterfaceID;
	}
}
