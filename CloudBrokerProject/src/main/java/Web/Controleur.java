package Web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.InterfaceImpDAO;
import Metier.entities.DP;
import Metier.entities.DataRedundancySupport;
import Metier.entities.DataStorageParam;
import Metier.entities.DiskSpace;
import Metier.entities.DiskTransferRate;
import Metier.entities.HDD;
import Metier.entities.HRM;
import Metier.entities.HRM_NFF;
import Metier.entities.QoS;
import Metier.entities.QuantityOfOperations;
import Metier.entities.SAS;
import Metier.entities.SM;
import Metier.entities.SM_NFF;
import Metier.entities.SSD;
import Metier.entities.VolumeOfData;
import Metier.entities.intended_user;
import Metier.entities.license_type;
import Metier.entities.location;
import Metier.entities.provider;
import Metier.entities.numofoperation;
import Metier.entities.numofsession;
import Metier.entities.numofuser;
import Metier.entities.openness;
import Metier.entities.payement;
import Metier.entities.service_interface;
import Métier.BabelNetConnection;
import Métier.TextRank;
import Métier.Tokenization;
import Métier.WordNetConnection;


@WebServlet("*.php")
public class Controleur extends HttpServlet {
	private static final long serialVersionUID = 1L;
	InterfaceImpDAO imp;
       
    
    public Controleur() {
        super();
    }
    public void init() throws ServletException {
    	imp = new InterfaceImpDAO();
    }
    
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	
		
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("nom");
		String emaill = request.getParameter("email");
		
		HttpSession session = request.getSession();
		session.setAttribute("nom",name);
		session.setAttribute("email",emaill);
		
		
          String path =request.getServletPath();
          
          /******************Connexion.php ******************/	
  		if(path.equals("/Connexion.php")) {
  		
  		String Nom, Motdepasse;
  		
  		Nom = request.getParameter("Nom");
  		Motdepasse = request.getParameter("Motdepasse");
  		String msg =   InterfaceImpDAO.authenticateUser(Nom, Motdepasse);
  		if(msg.equals("success")) {
  			request.getRequestDispatcher("DP1.jsp").forward(request, response);
  		} else {
  			response.sendRedirect("Connexion.jsp");
  		}
		

		/******************Inscription.php ******************/	
  		} else if(path.equals("/Inscrire.php")) {
			
			provider newUser = new  provider();			
			String nom = request.getParameter("nom");
			String motdepasse = request.getParameter("motdepasse");
			String email = request.getParameter("email");
			String telephone = request.getParameter("telephone");
			String nom_entreprise = request.getParameter("nom_entreprise");
			String pays = request.getParameter("pays");			
			newUser.setNom(nom);
			newUser.setMotdepasse(motdepasse);
			newUser.setEmail(email);
			newUser.setTelephone(telephone);
			newUser.setNom_entreprise(nom_entreprise);
			newUser.setPays(pays);
			
			int key=imp.insertProvider(newUser);
			newUser.setID(key);
			System.out.println(key);
			response.sendRedirect("DP1.jsp");
			
		/******************DP1.php ******************/	
		}else if(path.equals("/DP1.php")) {
			
			license_type lc = new license_type();
			String Proprietary = request.getParameter("prop");
			String OpenSource = request.getParameter("open");
			lc.setProprietary(Proprietary);
			lc.setOpenSource(OpenSource);	
			int IDLicenseType=(imp.getIDLicenseType(lc));
			
			intended_user iu = new intended_user();
			String Individuals = request.getParameter("individu");
			String Organizations = request.getParameter("orga");		
			iu.setIndividuals(Individuals);
			iu.setOrganizations(Organizations);	
			int IDintended_user=(imp.getIDIntendedUser(iu));
			
			service_interface si = new service_interface();
			String WebPortal = request.getParameter("web");
			String CLI = request.getParameter("cli");	
			String API = request.getParameter("api");	
			si.setWebPortal( WebPortal);
			si.setCLI(CLI);
			si.setAPI(API);
			int IDservice_interface=(imp.getIDServiceInterface(si));
			
			
			payement pa = new payement();
			String Free = request.getParameter("free");
			String PerUnit = request.getParameter("unit");	
			String Subscription = request.getParameter("sub");
			String Tiered = request.getParameter("tie");
			pa.setFree(Free);
			pa.setPerUnit(PerUnit);
			pa.setSubscription(Subscription);
			pa.setTiered(Tiered);
			int IDpayement=(imp.getIDPayement(pa));
			
			
			openness op = new openness();
			String LimitedLevel = request.getParameter("limited");
			String BasicLevel = request.getParameter("basic");	
			String CompleteLevel = request.getParameter("complete");
			String ModerateLevel = request.getParameter("moderate");
			op.setLimitedLevel(LimitedLevel);
			op.setBasicLevel(BasicLevel);
			op.setCompleteLevel(CompleteLevel);
			op.setModerateLevel(ModerateLevel);
			int IDopenness=(imp.getIDOpenness(op));
			
			
			
			location loc = new location();
			String Africa = request.getParameter("africa");
			String Asia = request.getParameter("asia");	
			String Australlia = request.getParameter("australlia");
			String Europe_UK = request.getParameter("uk");
			String US_Canada = request.getParameter("us");
			String MiddleeastNorthAfrica = request.getParameter("north");
			loc.setAfrica(Africa);
			loc.setAsia(Asia);
			loc.setAustrallia(Australlia);
			loc.setEurope_UK(Europe_UK);
			loc.setUS_Canada(US_Canada);
			loc.setMiddleeastNorthAfrica(MiddleeastNorthAfrica);
			int IDlocation=(imp.getIDLocation(loc));

						
			DP dp = new DP();
			int IDprovider=(imp.getMAXIDProvider());		
			String title = request.getParameter("title");
			String fee = request.getParameter("fee");
			String version = request.getParameter("version");
			String description = request.getParameter("description");
			String url = request.getParameter("url");
			String impor = request.getParameter("import");	
			dp.setServiceTitle(title);
			dp.setProviderName(String.valueOf(IDprovider));
			dp.setSubscriptionFee(fee);
			dp.setSLA(impor);
			dp.setVersion(version);
			dp.setServiceURL(url);
			dp.setShortDescription(description);
			dp.setPaymentModelID(String.valueOf(IDpayement));		
			dp.setIntendedUserID(String.valueOf(IDintended_user));
			dp.setLicenseTypeID(String.valueOf(IDLicenseType));
			dp.setLocationID(String.valueOf(IDlocation));	
			dp.setOpennessID(String.valueOf(IDopenness));
			dp.setServiceInterfaceID(String.valueOf(IDservice_interface));			
			imp.insertDP(dp);
			
			response.sendRedirect("QoS.jsp");
			
		/******************QoS.php ******************/	
		}else if(path.equals("/QoS.php")) {
			
		QoS QoS = new QoS();
		
		String Consumability = request.getParameter("Consumability");
		String FaultTolerance = request.getParameter("FaultTolerance");
		String Migrationability = request.getParameter("Migrationability");
		String Performance = request.getParameter("Performance");
		String Reliability = request.getParameter("Reliability");
		String RuntimeTunning = request.getParameter("RuntimeTunning");
		String Scalability = request.getParameter("Scalability");
		String Security = request.getParameter("Security");
		String Standardized = request.getParameter("Standardized");
		
		QoS.setConsumabilityEfforts(Consumability);
		QoS.setFaultToleranceEfforts(FaultTolerance);
		QoS.setMigrationabilityEfforts(Migrationability);
		QoS.setPerformance(Performance);
		QoS.setReliabilityEfforts(Reliability);
		QoS.setRuntimeTunning(RuntimeTunning);	
		QoS.setScalabilityEfforts(Scalability);
		QoS.setSecurityEfforts(Security);
		QoS.setStandardizedEfforts(Standardized);
			
		imp.insertQoS(QoS);
		
		response.sendRedirect("Choisir.jsp");
		
			
			/******************DP2.php ******************/	
			
	}else if(path.equals("/DP2.php")) { 
			numofuser numuser = new numofuser();
			String UpTo10 = request.getParameter("10");
			String UpTo50 = request.getParameter("50");
			String UpTo100 = request.getParameter("100");
			String UpTo500 = request.getParameter("500");
			String UpTo1000 = request.getParameter("1000");
			numuser.setUpTo10(UpTo10);
			numuser.setUpTo50(UpTo50);
			numuser.setUpTo100(UpTo100);
			numuser.setUpTo500(UpTo500);
			numuser.setUpTo1000(UpTo1000);
			imp.insertNumOfUser(numuser);
			
			
			numofoperation numoperation = new numofoperation();
			String UpTo50ope = request.getParameter("operation50");
			String UpTo100ope = request.getParameter("operation100");
			String UpTo300ope = request.getParameter("operation300");
			String UpTo500ope = request.getParameter("operation500");
			String UpTo1000ope = request.getParameter("operation1000");
			String UpTo1500ope = request.getParameter("operation1500");
			numoperation.setUpTo50(UpTo50ope);
			numoperation.setUpTo100(UpTo100ope);
			numoperation.setUpTo300(UpTo300ope);
			numoperation.setUpTo500(UpTo500ope);
			numoperation.setUpTo1000(UpTo1000ope);
			numoperation.setUpTo1500(UpTo1500ope);
			imp.insertNumOfOperation(numoperation);
			
			
			numofsession numsession = new numofsession();
			String UpTo1sess = request.getParameter("session1");
			String UpTo5sess = request.getParameter("session5");
			String UpTo10sess = request.getParameter("session10");
			String UpTo20sess = request.getParameter("session20");
			String UpTo50sess = request.getParameter("session50");
			numsession.setUpTo1(UpTo1sess);
			numsession.setUpTo5(UpTo5sess);
			numsession.setUpTo10(UpTo10sess);
			numsession.setUpTo20(UpTo20sess);
			numsession.setUpTo50(UpTo50sess);
			imp.insertNumOfSession(numsession);
			
			
			int maxsession=(imp.getMaxNumOfSession());
			int maxoperation=(imp.getMaxNumOfOperation());
			int maxuser=(imp.getMaxNumOfUser());		
			HRM_NFF hrm = new HRM_NFF();	
			hrm.setNumOfSessionsPerUserID(String.valueOf(maxsession));
			hrm.setNumOfOperationsPerSessionID(String.valueOf(maxoperation));
			hrm.setNumOfUsersID(String.valueOf(maxuser));
			imp.insertHRM_NFF(hrm);
			
			
			int maxQoS=(imp.getMaxQoS());
			int maxDP=(imp.getMaxDP());
			int maxHRM_NFF=(imp.getMaxHRM_NFF());	
			HRM hrmm = new HRM();	
			hrmm.setDeploymentParameters_DP_NFFsID(String.valueOf(maxDP));
			hrmm.setHumanResourceManagement_HRM_NFFsID(String.valueOf(maxHRM_NFF));
			hrmm.setQoSID(String.valueOf(maxQoS));
			imp.insertHRM(hrmm);
			
			response.sendRedirect("Choisir.jsp");

			
		
		/******************DP3.php ******************/	
		
	     }else if(path.equals("/DP3.php")) { 
		
	    DataRedundancySupport data = new DataRedundancySupport();
		String premium = request.getParameter("premium");
		String hot = request.getParameter("hot");
		String cool = request.getParameter("cool");
		String archive = request.getParameter("archive");
		data.setPREMIUM(premium);
		data.setHOT(hot);
		data.setCOOL(cool);
		data.setARCHIVE(archive);
		imp.insertDataRedundancySupport(data);
		
		
		VolumeOfData volume = new VolumeOfData();
		String volume50 = request.getParameter("volume50");
		String volume100 = request.getParameter("volume100");
		String volume200 = request.getParameter("volume200");
		String volume400 = request.getParameter("volume400");
		String volume800 = request.getParameter("volume800");
		String volume1t = request.getParameter("volume1t");
		String volume2t = request.getParameter("volume2t");
		volume.setUpTo50GB(volume50);
		volume.setUpTo100GB(volume100);
		volume.setUpTo200GB(volume200);
		volume.setUpTo400GB(volume400);
		volume.setUpTo800GB(volume800);
		volume.setUpTo1TB(volume1t);
		volume.setUpTo2TB(volume2t);
		imp.insertVolumeOfData(volume);
		
		QuantityOfOperations Qte = new QuantityOfOperations();
		String UpTo5KOperationsPerMonth = request.getParameter("Qte1");
		String UpTo10KOperationsPerMonth = request.getParameter("Qte10");
		String UpTo25KOperationsPerMonth = request.getParameter("Qte25");
		String UpTo50KOperationsPerMonth = request.getParameter("Qte50");
		String UpTo100KOperationsPerMonth = request.getParameter("Qte100");
		String UpTo250KOperationsPerMonth = request.getParameter("Qte250");
		String UpTo500KOperationsPerMonth = request.getParameter("Qte500");
		String UpTo1MOperationsPerMonth = request.getParameter("Qte1M");
		String UpTo2MOperationsPerMonth = request.getParameter("Qte2M");
		String UpTo5MOperationsPerMonth = request.getParameter("Qte5M");
		Qte.setUpTo5KOperationsPerMonth(UpTo5KOperationsPerMonth);
		Qte.setUpTo10KOperationsPerMonth(UpTo10KOperationsPerMonth);
		Qte.setUpTo25KOperationsPerMonth(UpTo25KOperationsPerMonth);
		Qte.setUpTo50KOperationsPerMonth(UpTo50KOperationsPerMonth);
		Qte.setUpTo100KOperationsPerMonth(UpTo100KOperationsPerMonth);
		Qte.setUpTo250KOperationsPerMonth(UpTo250KOperationsPerMonth);
		Qte.setUpTo500KOperationsPerMonth(UpTo500KOperationsPerMonth);
		Qte.setUpTo1MOperationsPerMonth(UpTo1MOperationsPerMonth);
		Qte.setUpTo2MOperationsPerMonth(UpTo2MOperationsPerMonth);
		Qte.setUpTo5MOperationsPerMonth(UpTo5MOperationsPerMonth);	
		imp.insertQuantityOfOperations(Qte);
	
		
		response.sendRedirect("DataStorageParamaters.jsp");

		
  		/******************Inscription.php ******************/	
		} else if(path.equals("/DataStorage.php")) {
			String data = request.getParameter("data");
			if(data.equals("SAS")){				 
				    DiskSpace diskspace = new DiskSpace();
					String Space_UpTo2GB = request.getParameter("2GB");
					String Space_UpTo4GB = request.getParameter("4GB");
					String Space_UpTo8GB = request.getParameter("8GB");
					String Space_UpTo16GB = request.getParameter("16GB");
					String Space_UpTo32GB = request.getParameter("32GB");
					String Space_UpTo64GB = request.getParameter("64GB");
					String Space_UpTo128GB = request.getParameter("128GB");
					String Space_UpTo256GB = request.getParameter("256GB");
					String Space_UpTo512GB = request.getParameter("512GB");
					diskspace.setSpace_UpTo2GB(Space_UpTo2GB);
					diskspace.setSpace_UpTo4GB(Space_UpTo4GB);
					diskspace.setSpace_UpTo8GB(Space_UpTo8GB);
					diskspace.setSpace_UpTo16GB(Space_UpTo16GB);
					diskspace.setSpace_UpTo32GB(Space_UpTo32GB);
					diskspace.setSpace_UpTo64GB(Space_UpTo64GB);
					diskspace.setSpace_UpTo128GB(Space_UpTo128GB);
					diskspace.setSpace_UpTo256GB(Space_UpTo256GB);
					diskspace.setSpace_UpTo512GB(Space_UpTo512GB);
					imp.insertDiskSpace(diskspace);

				    DiskTransferRate disktransferrate = new DiskTransferRate();
				    String TransferRate_UpTo50MBps = request.getParameter("50MB");
					String TransferRate_UpTo100MBps = request.getParameter("100MB");
					String TransferRate_UpTo200MBps = request.getParameter("200MB");
					String TransferRate_UpTo400MBps = request.getParameter("400MB");
					String TransferRate_UpTo600MBps = request.getParameter("600MB");
					String TransferRate_UpTo1200MBps = request.getParameter("1200MB");
					String TransferRate_UpTo2400MBps = request.getParameter("2400MB");
					String TransferRate_UpTo3000MBps = request.getParameter("3000MB");
					disktransferrate.setTransferRate_UpTo3000MBps(TransferRate_UpTo3000MBps);
					disktransferrate.setTransferRate_UpTo2400MBps(TransferRate_UpTo2400MBps);
					disktransferrate.setTransferRate_UpTo1200MBps(TransferRate_UpTo1200MBps);
					disktransferrate.setTransferRate_UpTo600MBps(TransferRate_UpTo600MBps);
					disktransferrate.setTransferRate_UpTo400MBps(TransferRate_UpTo400MBps);
					disktransferrate.setTransferRate_UpTo200MBps(TransferRate_UpTo200MBps);
					disktransferrate.setTransferRate_UpTo100MBps(TransferRate_UpTo100MBps);
					disktransferrate.setTransferRate_UpTo50MBps(TransferRate_UpTo50MBps);
					imp.insertDiskTransferRate(disktransferrate);
					
					
					int maxdiskspace=(imp.getMaxDiskSpaceID());
					int maxdisktransferrate=(imp.getMaxDiskTransferRateID());
					SAS sas = new SAS();	
					sas.setDiskSpaceID(String.valueOf(maxdiskspace));
					sas.setDiskTransferRateID(String.valueOf(maxdisktransferrate));				
					imp.insertSAS(sas);
					response.sendRedirect("DataStorageParamaters.jsp");
					
				 				 
			 }  else if(data.equals("SSD")){			 
				    DiskSpace diskspace = new DiskSpace();
					String Space_UpTo2GB = request.getParameter("2GB");
					String Space_UpTo4GB = request.getParameter("4GB");
					String Space_UpTo8GB = request.getParameter("8GB");
					String Space_UpTo16GB = request.getParameter("16GB");
					String Space_UpTo32GB = request.getParameter("32GB");
					String Space_UpTo64GB = request.getParameter("64GB");
					String Space_UpTo128GB = request.getParameter("128GB");
					String Space_UpTo256GB = request.getParameter("256GB");
					String Space_UpTo512GB = request.getParameter("512GB");
					diskspace.setSpace_UpTo2GB(Space_UpTo2GB);
					diskspace.setSpace_UpTo4GB(Space_UpTo4GB);
					diskspace.setSpace_UpTo8GB(Space_UpTo8GB);
					diskspace.setSpace_UpTo16GB(Space_UpTo16GB);
					diskspace.setSpace_UpTo32GB(Space_UpTo32GB);
					diskspace.setSpace_UpTo64GB(Space_UpTo64GB);
					diskspace.setSpace_UpTo128GB(Space_UpTo128GB);
					diskspace.setSpace_UpTo256GB(Space_UpTo256GB);
					diskspace.setSpace_UpTo512GB(Space_UpTo512GB);
					imp.insertDiskSpace(diskspace);

				    DiskTransferRate disktransferrate = new DiskTransferRate();
				    String TransferRate_UpTo50MBps = request.getParameter("50MB");
					String TransferRate_UpTo100MBps = request.getParameter("100MB");
					String TransferRate_UpTo200MBps = request.getParameter("200MB");
					String TransferRate_UpTo400MBps = request.getParameter("400MB");
					String TransferRate_UpTo600MBps = request.getParameter("600MB");
					String TransferRate_UpTo1200MBps = request.getParameter("1200MB");
					String TransferRate_UpTo2400MBps = request.getParameter("2400MB");
					String TransferRate_UpTo3000MBps = request.getParameter("3000MB");
					disktransferrate.setTransferRate_UpTo3000MBps(TransferRate_UpTo3000MBps);
					disktransferrate.setTransferRate_UpTo2400MBps(TransferRate_UpTo2400MBps);
					disktransferrate.setTransferRate_UpTo1200MBps(TransferRate_UpTo1200MBps);
					disktransferrate.setTransferRate_UpTo600MBps(TransferRate_UpTo600MBps);
					disktransferrate.setTransferRate_UpTo400MBps(TransferRate_UpTo400MBps);
					disktransferrate.setTransferRate_UpTo200MBps(TransferRate_UpTo200MBps);
					disktransferrate.setTransferRate_UpTo100MBps(TransferRate_UpTo100MBps);
					disktransferrate.setTransferRate_UpTo50MBps(TransferRate_UpTo50MBps);
					imp.insertDiskTransferRate(disktransferrate);
					
					
					int maxdiskspace=(imp.getMaxDiskSpaceID());
					int maxdisktransferrate=(imp.getMaxDiskTransferRateID());
					SSD ssd = new SSD();	
					ssd.setDiskSpaceID(String.valueOf(maxdiskspace));
					ssd.setDiskTransferRateID(String.valueOf(maxdisktransferrate));				
					imp.insertSSD(ssd);
					response.sendRedirect("DataStorageParamaters.jsp");
					
				 				 
			 } else if(data.equals("HDD")){			 
				    DiskSpace diskspace = new DiskSpace();
					String Space_UpTo2GB = request.getParameter("2GB");
					String Space_UpTo4GB = request.getParameter("4GB");
					String Space_UpTo8GB = request.getParameter("8GB");
					String Space_UpTo16GB = request.getParameter("16GB");
					String Space_UpTo32GB = request.getParameter("32GB");
					String Space_UpTo64GB = request.getParameter("64GB");
					String Space_UpTo128GB = request.getParameter("128GB");
					String Space_UpTo256GB = request.getParameter("256GB");
					String Space_UpTo512GB = request.getParameter("512GB");
					diskspace.setSpace_UpTo2GB(Space_UpTo2GB);
					diskspace.setSpace_UpTo4GB(Space_UpTo4GB);
					diskspace.setSpace_UpTo8GB(Space_UpTo8GB);
					diskspace.setSpace_UpTo16GB(Space_UpTo16GB);
					diskspace.setSpace_UpTo32GB(Space_UpTo32GB);
					diskspace.setSpace_UpTo64GB(Space_UpTo64GB);
					diskspace.setSpace_UpTo128GB(Space_UpTo128GB);
					diskspace.setSpace_UpTo256GB(Space_UpTo256GB);
					diskspace.setSpace_UpTo512GB(Space_UpTo512GB);
					imp.insertDiskSpace(diskspace);

				    DiskTransferRate disktransferrate = new DiskTransferRate();
				    String TransferRate_UpTo50MBps = request.getParameter("50MB");
					String TransferRate_UpTo100MBps = request.getParameter("100MB");
					String TransferRate_UpTo200MBps = request.getParameter("200MB");
					String TransferRate_UpTo400MBps = request.getParameter("400MB");
					String TransferRate_UpTo600MBps = request.getParameter("600MB");
					String TransferRate_UpTo1200MBps = request.getParameter("1200MB");
					String TransferRate_UpTo2400MBps = request.getParameter("2400MB");
					String TransferRate_UpTo3000MBps = request.getParameter("3000MB");
					disktransferrate.setTransferRate_UpTo3000MBps(TransferRate_UpTo3000MBps);
					disktransferrate.setTransferRate_UpTo2400MBps(TransferRate_UpTo2400MBps);
					disktransferrate.setTransferRate_UpTo1200MBps(TransferRate_UpTo1200MBps);
					disktransferrate.setTransferRate_UpTo600MBps(TransferRate_UpTo600MBps);
					disktransferrate.setTransferRate_UpTo400MBps(TransferRate_UpTo400MBps);
					disktransferrate.setTransferRate_UpTo200MBps(TransferRate_UpTo200MBps);
					disktransferrate.setTransferRate_UpTo100MBps(TransferRate_UpTo100MBps);
					disktransferrate.setTransferRate_UpTo50MBps(TransferRate_UpTo50MBps);
					imp.insertDiskTransferRate(disktransferrate);
					
					
					int maxdiskspace=(imp.getMaxDiskSpaceID());
					int maxdisktransferrate=(imp.getMaxDiskTransferRateID());
					HDD hdd = new HDD();	
					hdd.setDiskSpaceID(String.valueOf(maxdiskspace));
					hdd.setDiskTransferRateID(String.valueOf(maxdisktransferrate));				
					imp.insertHDD(hdd);
					
					int maxHDD=(imp.getMaxHDD());
					int maxSAS=(imp.getMaxSAS());
					int maxSSD=(imp.getMaxSSD());
					DataStorageParam dataStorageParam = new DataStorageParam();	
					dataStorageParam.setHDDStorageID(String.valueOf(maxHDD));
					dataStorageParam.setSASStorageID(String.valueOf(maxSAS));
					dataStorageParam.setSSDStorageID(String.valueOf(maxSSD));				
					imp.insertDataStorageParam(dataStorageParam);
					
					int dataParam=(imp.getMaxDataStorageParam());						
					int dataredun=(imp.getMaxDataRedundancySupport());
					int volumeofdata=(imp.getMaxVolumeOfData());
					int Qteoperation=(imp.getMaxQuantityOfOperations());	
					SM_NFF sm_nff = new SM_NFF();	
					sm_nff.setQuantityOfOperationsID(String.valueOf(Qteoperation));
					sm_nff.setVolumeOfDataID(String.valueOf(volumeofdata));
					sm_nff.setDataRedundancySupportID(String.valueOf(dataredun));
					sm_nff.setDataStorageParamID(String.valueOf(dataParam));
					imp.insertSM_NFF(sm_nff);
					
					int maxQoS=(imp.getMaxQoS());
					int maxDP=(imp.getMaxDP());
					int maxHRM_NFF=(imp.getMaxSM_NFF());	
					SM sm = new SM();	
					sm.setDeploymentParameters_DP_NFFsID(String.valueOf(maxDP));
					sm.setStreamingAndMultimedia_SM_NFFsID(String.valueOf(maxHRM_NFF));
					sm.setQoSID(String.valueOf(maxQoS));
					imp.insertSM(sm);
					
					
					response.sendRedirect("Choisir.jsp");
					
				 				 
			 } 		
			/******************Choisir.php ******************/	
		} else if(path.equals("/Choisir.php")) {
			String choisir = request.getParameter("choisir");
			if(choisir.equals("Human Resource Management")){		
			response.sendRedirect("HRM.jsp"); }
			else if(choisir.equals("Streaming And Multimedia")){		
				response.sendRedirect("SM.jsp"); }

		}
  		/******************DescriptionQuery.php ******************/	
		else if(path.equals("/DescriptionQuery.php")) {
			String Description= request.getParameter("user_message");
			ArrayList<String> keywords = new ArrayList<String>();
			ArrayList<String> Tokens = new ArrayList<String>();
			ArrayList<String> FinalKeywords = new ArrayList<String>();
			
			/*** Text Rank ***/
			try {
				keywords=TextRank.sentenceDetect(Description);
				
				/*** Babelnet Elimination ***/
				BabelNetConnection.Connection(keywords);
				
				/*** Tokenization And POS ***/
				Tokens= Tokenization.TokanizationTag(keywords);
				
				/*** WordNet ***/
				WordNetConnection.WordnetConnection(Tokens);
				Set<String> set= new HashSet<>(Tokens);
				Tokens.clear();
				Tokens.addAll(set);
				
				/*** Babelnet Verification ***/
				FinalKeywords=BabelNetConnection.Connection2(Tokens);
				
				System.out.println("Keywords :");
				System.out.println(FinalKeywords);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			/*** Matching Keywords ***/
			
			
		}
			
		doGet(request, response);
	}

}
