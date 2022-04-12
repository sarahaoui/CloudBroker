package Metier.entities;

public class QoS {
 private String ConsumabilityEfforts;
 private String FaultToleranceEfforts;
 private String MigrationabilityEfforts;
 private String Performance;
 private String ReliabilityEfforts;
 private String RuntimeTunning;
 private String ScalabilityEfforts;
 private String SecurityEfforts;
 private String StandardizedEfforts;

 public QoS() {
	 super();
	}
	
	public QoS(String ConsumabilityEfforts, String FaultToleranceEfforts, String MigrationabilityEfforts, String Performance, String ReliabilityEfforts, String RuntimeTunning, String ScalabilityEfforts, String SecurityEfforts, String StandardizedEfforts) {
		super();
		this.ConsumabilityEfforts = ConsumabilityEfforts;
		this.FaultToleranceEfforts = FaultToleranceEfforts;
		this.MigrationabilityEfforts = MigrationabilityEfforts;	
		this.Performance = Performance;
		this.ReliabilityEfforts = ReliabilityEfforts;			
		this.RuntimeTunning = RuntimeTunning;
		this.ScalabilityEfforts = ScalabilityEfforts;
		this.SecurityEfforts = SecurityEfforts;		
		this.StandardizedEfforts = StandardizedEfforts;
	}

	public String getConsumabilityEfforts() {
		return ConsumabilityEfforts;
	}

	public void setConsumabilityEfforts(String consumabilityEfforts) {
		ConsumabilityEfforts = consumabilityEfforts;
	}

	public String getFaultToleranceEfforts() {
		return FaultToleranceEfforts;
	}

	public void setFaultToleranceEfforts(String faultToleranceEfforts) {
		FaultToleranceEfforts = faultToleranceEfforts;
	}

	public String getMigrationabilityEfforts() {
		return MigrationabilityEfforts;
	}

	public void setMigrationabilityEfforts(String migrationabilityEfforts) {
		MigrationabilityEfforts = migrationabilityEfforts;
	}

	public String getPerformance() {
		return Performance;
	}

	public void setPerformance(String performance) {
		Performance = performance;
	}

	public String getReliabilityEfforts() {
		return ReliabilityEfforts;
	}

	public void setReliabilityEfforts(String reliabilityEfforts) {
		ReliabilityEfforts = reliabilityEfforts;
	}

	public String getRuntimeTunning() {
		return RuntimeTunning;
	}

	public void setRuntimeTunning(String runtimeTunning) {
		RuntimeTunning = runtimeTunning;
	}

	public String getScalabilityEfforts() {
		return ScalabilityEfforts;
	}

	public void setScalabilityEfforts(String scalabilityEfforts) {
		ScalabilityEfforts = scalabilityEfforts;
	}

	public String getSecurityEfforts() {
		return SecurityEfforts;
	}

	public void setSecurityEfforts(String securityEfforts) {
		SecurityEfforts = securityEfforts;
	}

	public String getStandardizedEfforts() {
		return StandardizedEfforts;
	}

	public void setStandardizedEfforts(String standardizedEfforts) {
		StandardizedEfforts = standardizedEfforts;
	}
	
}

