package Web;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.semanticweb.owlapi.model.OWLException;

import DAO.InterfaceImpDAO;
import DAO.InterfaceImpDAOntologie;
import Metier.entities.DP;
import Metier.entities.DataRedundancySupport;
import Metier.entities.DataStorageParam;
import Metier.entities.DiskSpace;
import Metier.entities.DiskTransferRate;
import Metier.entities.FFQuery;
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
import Metier.entities.admin;
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
import Metier.entities.user;
import Model.Model;
import Métier.BabelNetConnection;
import Métier.SortedServices;
import Métier.TextRank;
import Métier.Tokenization;
import Métier.UpdateKeyWords;
import Métier.WordNetConnection;
import jade.core.AID;
import jade.core.behaviours.Behaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.UnreadableException;
import jade.wrapper.ControllerException;
import jade.wrapper.StaleProxyException;
import jade.wrapper.gateway.JadeGateway;


@WebServlet("*.php")
public class Controleur extends HttpServlet {
	private static final long serialVersionUID = 1L;
	InterfaceImpDAO imp;
	
      int idprovider, idqos, iddp, idhrm_nff, idsm_nff, idssd, idhdd, idsas, iddatastorageparam, iddataredsupport, idvolumeofdata;
      int idqte, iddiskspace, iddisktransferrate;
      int idnumofsession, idnumofuser, idnumofoperation;
      String nomm, emailll;
    
    public Controleur() {
        super();
    }
    public void init() throws ServletException {
    	imp = new InterfaceImpDAO();
    }
    
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doPost(request, response);
	}	
		
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		final	HttpSession session = request.getSession();
	  
		  ArrayList<String> matchedChildren= new ArrayList<String>();
          String path =request.getServletPath();
          
          /******************Connexion.php ******************/	
  		if(path.equals("/ConnexionProvider.php")) {
  		
  		String Nom, Motdepasse;
  		
  		Nom = request.getParameter("Nom");
  		Motdepasse = request.getParameter("Motdepasse");
  		String msg =   InterfaceImpDAO.authenticateProvider(Nom, Motdepasse);
  		
  		if(msg.equals("success")) {
  			
            provider newUser = new  provider();
  			String nom = request.getParameter("Nom");
			String motdepasse = request.getParameter("Motdepasse");
			newUser.setNom(nom);
			newUser.setMotdepasse(motdepasse);
  			idprovider =   imp.getIDProvider(newUser);
  			nomm =   imp.getName(newUser);
  			emailll =   imp.getEmail(newUser);  			
			System.out.println(idprovider);
			System.out.println(nomm);
			System.out.println(emailll);
			session.setAttribute("nom",nomm);
	        session.setAttribute("email",emailll);
	        request.getRequestDispatcher("Home.jsp").forward(request, response);
  		} else {
  			response.sendRedirect("Connexion.jsp");
  		}}
  		
		/******************Inscription.php ******************/	
         if(path.equals("/Inscrire.php")) {
			
             provider newUser = new  provider();
		
			String nom = request.getParameter("nom");
			String motdepasse = request.getParameter("motdepasse");
			String emaill = request.getParameter("email");
			String telephone = request.getParameter("telephone");
			String nom_entreprise = request.getParameter("nom_entreprise");
			String pays = request.getParameter("pays");			
			newUser.setNom(nom);
			newUser.setMotdepasse(motdepasse);
			newUser.setEmail(emaill);
			newUser.setTelephone(telephone);
			newUser.setNom_entreprise(nom_entreprise);
			newUser.setPays(pays);
			
			newUser.setID(imp.insertProvider(newUser));
			idprovider = newUser.getID();
			nomm = newUser.getNom();			 
			emailll = newUser.getEmail();
			System.out.println(idprovider);
			response.sendRedirect("Home.jsp");
			
			session.setAttribute("nom",nomm);
	         session.setAttribute("email",emailll);}

                /******************ConnexionUser.php ******************/	
  		if(path.equals("/ConnexionUser.php")) {
  		
  		String Nom, Motdepasse;
  		
  		Nom = request.getParameter("Nom");
  		Motdepasse = request.getParameter("Motdepasse");
  		String msg =   InterfaceImpDAO.authenticateUser(Nom, Motdepasse);
  		
  		if(msg.equals("success")) {
  			
  			user newUser = new  user();
  			String nom = request.getParameter("Nom");
 			String motdepasse = request.getParameter("Motdepasse");
 			newUser.setNom(nom);
 			newUser.setMotdepasse(motdepasse);
  			idprovider =   imp.getIDUser(newUser);
  			nomm =   imp.getNameUser(newUser);
  			emailll =   imp.getEmailUser(newUser);  			
			System.out.println(idprovider);
			System.out.println(nomm);
			System.out.println(emailll);
			session.setAttribute("nom",nomm);
	        session.setAttribute("email",emailll);  
  			
 	        request.getRequestDispatcher("QueryUser.jsp").forward(request, response);
  		} else {
  			response.sendRedirect("ConnexionUser.jsp");
  		}}
 		/******************InscriptionUser.php ******************/	
         if(path.equals("/InscrireUser.php")) {
 			
             user newUser = new  user();
 		
 			String nom = request.getParameter("nom");
 			String motdepasse = request.getParameter("motdepasse");
 			String emaill = request.getParameter("email");
 			String telephone = request.getParameter("telephone");
 			String nom_entreprise = request.getParameter("nom_entreprise");
 			String pays = request.getParameter("pays");			
 			newUser.setNom(nom);
 			newUser.setMotdepasse(motdepasse);
 			newUser.setEmail(emaill);
 			newUser.setTelephone(telephone);
 			newUser.setNom_entreprise(nom_entreprise);
 			newUser.setPays(pays);
 			
 			imp.insertUser(newUser);
 			idprovider = newUser.getID();
			nomm = newUser.getNom();			 
			emailll = newUser.getEmail();
			System.out.println(idprovider);
			session.setAttribute("nom",nomm);
	         session.setAttribute("email",emailll);
 			
 			response.sendRedirect("QueryUser.jsp");}
         
         	
		/******************DP1.php ******************/	
		 if(path.equals("/DP1.php")) {
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
			String title = request.getParameter("title");
			String fee = request.getParameter("fee");
			String version = request.getParameter("version");
			String description = request.getParameter("description");
			String url = request.getParameter("url");
			String impor = request.getParameter("import");	
			dp.setServiceTitle(title);
			dp.setProviderName(String.valueOf(idprovider));	
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
			
			try {
				JadeGateway.execute(new Behaviour(){
					private boolean finished = false;
					public void onStart() {
						ACLMessage msg = new ACLMessage(ACLMessage.CFP);
				    	AID agent = new AID("AgentTraitementTexte",AID.ISLOCALNAME);
				    	msg.addReceiver(agent);
					    msg.setContent(description);
						myAgent.send(msg);
					  }

					@Override
				    public void action() {  	
				  ACLMessage res= myAgent.receive();
				  if(res!= null) {
					  switch (res.getPerformative()) {
						case ACLMessage.CFP:
							ArrayList<String> FinalKeywords = new ArrayList<String>();
							
						try {
							FinalKeywords = (ArrayList<String>)res.getContentObject();
							System.out.println(FinalKeywords);
							String SlaTokens ="";
							for (int i = 0; i < FinalKeywords.size(); i++) {
								if(SlaTokens.equals("")) {
									SlaTokens= SlaTokens+FinalKeywords.get(i);
									
								}else {
									SlaTokens= SlaTokens+","+FinalKeywords.get(i);
								}
								
							}
							System.out.println("SLATOKENS: "+SlaTokens);
							dp.setSLATokens(SlaTokens);
							dp.setID(imp.insertDP(dp));
							iddp = dp.getID();
							System.out.println(iddp);
							
						} catch (UnreadableException e) {
							e.printStackTrace();
						}
						    
							break;}
					 
					  finished= true;
				      }
					    else {
					      block();
					    }
					  }
					@Override
					public boolean done() {
						return finished;
					}
					 
					});
			} catch (StaleProxyException e) {
				e.printStackTrace();
			} catch (ControllerException e) {
				e.printStackTrace();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			
			response.sendRedirect("QoS.jsp");
			
		/******************QoS.php ******************/	
		}if(path.equals("/QoS.php")) {
			
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
			
		
		QoS.setID(imp.insertQoS(QoS));
		idqos = QoS.getID();
		System.out.println(idqos);
		
		response.sendRedirect("ChoisirForm.php");}
			
			/******************DP2.php ******************/	
			
	      if(path.equals("/DP2.php")) { 
			numofuser numuser = new numofuser();
			String UpTo10 = request.getParameter("upto10");
			String UpTo50 = request.getParameter("upto50");
			String UpTo100 = request.getParameter("upto100");
			String UpTo500 = request.getParameter("upto500");
			String UpTo1000 = request.getParameter("upto1000");
			numuser.setUpTo10(UpTo10);
			numuser.setUpTo50(UpTo50);
			numuser.setUpTo100(UpTo100);
			numuser.setUpTo500(UpTo500);
			numuser.setUpTo1000(UpTo1000);
			numuser.setID(imp.insertNumOfUser(numuser));
			idnumofuser = numuser.getID();
			System.out.println(idnumofuser);
			
			
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
			numoperation.setID(imp.insertNumOfOperation(numoperation));
			idnumofoperation = numoperation.getID();
			System.out.println(idnumofoperation);
			
			
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
			numsession.setID(imp.insertNumOfSession(numsession));
			idnumofsession = numsession.getID();
			System.out.println(idnumofsession);
			
			
		
			HRM_NFF hrm = new HRM_NFF();	
			hrm.setNumOfSessionsPerUserID(String.valueOf(idnumofsession));
			hrm.setNumOfOperationsPerSessionID(String.valueOf(idnumofoperation));
			hrm.setNumOfUsersID(String.valueOf(idnumofuser));
			
			hrm.setID(imp.insertHRM_NFF(hrm));
			idhrm_nff = hrm.getID();
			System.out.println(idhrm_nff);
			
			
			HRM hrmm = new HRM();	
			hrmm.setDeploymentParameters_DP_NFFsID(String.valueOf(iddp));
			hrmm.setHumanResourceManagement_HRM_NFFsID(String.valueOf(idhrm_nff));
			hrmm.setQoSID(String.valueOf(idqos));
			imp.insertHRM(hrmm);
			
			response.sendRedirect("ChoisirForm.php");}

			
		
		/******************DP3.php ******************/	
		
	     if(path.equals("/DP3.php")) { 
		
	    DataRedundancySupport data = new DataRedundancySupport();
		String premium = request.getParameter("premium");
		String hot = request.getParameter("hot");
		String cool = request.getParameter("cool");
		String archive = request.getParameter("archive");
		data.setPREMIUM(premium);
		data.setHOT(hot);
		data.setCOOL(cool);
		data.setARCHIVE(archive);
		
		data.setID(imp.insertDataRedundancySupport(data));
		iddataredsupport = data.getID();
		System.out.println(iddataredsupport);
		
		
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
		
		volume.setID(imp.insertVolumeOfData(volume));
		idvolumeofdata = data.getID();
		System.out.println(idvolumeofdata);
		
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
		Qte.setID(imp.insertQuantityOfOperations(Qte));
		idqte = data.getID();
		System.out.println(idqte);
	
		
		response.sendRedirect("DataStorageParamaters.jsp");}

		
  		/******************Inscription.php ******************/	
		if(path.equals("/DataStorage.php")) {
			String data = request.getParameter("data");
			if(data.equals("SAS")){				 
				    DiskSpace diskspace = new DiskSpace();
					String Space_UpTo2GB = request.getParameter("to2GB");
					String Space_UpTo4GB = request.getParameter("to4GB");
					String Space_UpTo8GB = request.getParameter("to8GB");
					String Space_UpTo16GB = request.getParameter("to16GB");
					String Space_UpTo32GB = request.getParameter("to32GB");
					String Space_UpTo64GB = request.getParameter("to64GB");
					String Space_UpTo128GB = request.getParameter("to128GB");
					String Space_UpTo256GB = request.getParameter("to256GB");
					String Space_UpTo512GB = request.getParameter("to512GB");
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
					diskspace.setID(imp.insertDiskSpace(diskspace));
					iddiskspace = diskspace.getID();
					System.out.println(iddiskspace);

				    DiskTransferRate disktransferrate = new DiskTransferRate();
				        String TransferRate_UpTo50MBps = request.getParameter("to50MB");
					String TransferRate_UpTo100MBps = request.getParameter("to100MB");
					String TransferRate_UpTo200MBps = request.getParameter("to200MB");
					String TransferRate_UpTo400MBps = request.getParameter("to400MB");
					String TransferRate_UpTo600MBps = request.getParameter("to600MB");
					String TransferRate_UpTo1200MBps = request.getParameter("to1200MB");
					String TransferRate_UpTo2400MBps = request.getParameter("to2400MB");
					String TransferRate_UpTo3000MBps = request.getParameter("to3000MB");
					disktransferrate.setTransferRate_UpTo3000MBps(TransferRate_UpTo3000MBps);
					disktransferrate.setTransferRate_UpTo2400MBps(TransferRate_UpTo2400MBps);
					disktransferrate.setTransferRate_UpTo1200MBps(TransferRate_UpTo1200MBps);
					disktransferrate.setTransferRate_UpTo600MBps(TransferRate_UpTo600MBps);
					disktransferrate.setTransferRate_UpTo400MBps(TransferRate_UpTo400MBps);
					disktransferrate.setTransferRate_UpTo200MBps(TransferRate_UpTo200MBps);
					disktransferrate.setTransferRate_UpTo100MBps(TransferRate_UpTo100MBps);
					disktransferrate.setTransferRate_UpTo50MBps(TransferRate_UpTo50MBps);
					disktransferrate.setID(imp.insertDiskTransferRate(disktransferrate));
					iddisktransferrate = disktransferrate.getID();
					System.out.println(iddisktransferrate);
					
				
					SAS sas = new SAS();	
					sas.setDiskSpaceID(String.valueOf(iddiskspace));
					sas.setDiskTransferRateID(String.valueOf(iddisktransferrate));				
					imp.insertSAS(sas);
					
					sas.setID(imp.insertSAS(sas));
					idsas = sas.getID();
					System.out.println(idsas);
					response.sendRedirect("DataStorageParamaters.jsp");
					
				 				 
			 }  else if(data.equals("SSD")){			 
				        DiskSpace diskspace = new DiskSpace();
					String Space_UpTo2GB = request.getParameter("to2GB");
					String Space_UpTo4GB = request.getParameter("to4GB");
					String Space_UpTo8GB = request.getParameter("to8GB");
					String Space_UpTo16GB = request.getParameter("to16GB");
					String Space_UpTo32GB = request.getParameter("to32GB");
					String Space_UpTo64GB = request.getParameter("to64GB");
					String Space_UpTo128GB = request.getParameter("to128GB");
					String Space_UpTo256GB = request.getParameter("to256GB");
					String Space_UpTo512GB = request.getParameter("to512GB");
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
					diskspace.setID(imp.insertDiskSpace(diskspace));
					iddiskspace = diskspace.getID();
					System.out.println(iddiskspace);

				    DiskTransferRate disktransferrate = new DiskTransferRate();
				        String TransferRate_UpTo50MBps = request.getParameter("to50MB");
					String TransferRate_UpTo100MBps = request.getParameter("to100MB");
					String TransferRate_UpTo200MBps = request.getParameter("to200MB");
					String TransferRate_UpTo400MBps = request.getParameter("to400MB");
					String TransferRate_UpTo600MBps = request.getParameter("to600MB");
					String TransferRate_UpTo1200MBps = request.getParameter("to1200MB");
					String TransferRate_UpTo2400MBps = request.getParameter("to2400MB");
					String TransferRate_UpTo3000MBps = request.getParameter("to3000MB");
					disktransferrate.setTransferRate_UpTo3000MBps(TransferRate_UpTo3000MBps);
					disktransferrate.setTransferRate_UpTo2400MBps(TransferRate_UpTo2400MBps);
					disktransferrate.setTransferRate_UpTo1200MBps(TransferRate_UpTo1200MBps);
					disktransferrate.setTransferRate_UpTo600MBps(TransferRate_UpTo600MBps);
					disktransferrate.setTransferRate_UpTo400MBps(TransferRate_UpTo400MBps);
					disktransferrate.setTransferRate_UpTo200MBps(TransferRate_UpTo200MBps);
					disktransferrate.setTransferRate_UpTo100MBps(TransferRate_UpTo100MBps);
					disktransferrate.setTransferRate_UpTo50MBps(TransferRate_UpTo50MBps);
					disktransferrate.setID(imp.insertDiskTransferRate(disktransferrate));
					iddisktransferrate = disktransferrate.getID();
					System.out.println(iddisktransferrate);
					
					
					SSD ssd = new SSD();	
					ssd.setDiskSpaceID(String.valueOf(iddiskspace));
					ssd.setDiskTransferRateID(String.valueOf(iddisktransferrate));				
					ssd.setID(imp.insertSSD(ssd));
					idssd = ssd.getID();
					System.out.println(idssd);
					response.sendRedirect("DataStorageParamaters.jsp");
					
				 				 
			 } else if(data.equals("HDD")){			 
				        DiskSpace diskspace = new DiskSpace();
					String Space_UpTo2GB = request.getParameter("to2GB");
					String Space_UpTo4GB = request.getParameter("to4GB");
					String Space_UpTo8GB = request.getParameter("to8GB");
					String Space_UpTo16GB = request.getParameter("to16GB");
					String Space_UpTo32GB = request.getParameter("to32GB");
					String Space_UpTo64GB = request.getParameter("to64GB");
					String Space_UpTo128GB = request.getParameter("to128GB");
					String Space_UpTo256GB = request.getParameter("to256GB");
					String Space_UpTo512GB = request.getParameter("to512GB");
					diskspace.setSpace_UpTo2GB(Space_UpTo2GB);
					diskspace.setSpace_UpTo4GB(Space_UpTo4GB);
					diskspace.setSpace_UpTo8GB(Space_UpTo8GB);
					diskspace.setSpace_UpTo16GB(Space_UpTo16GB);
					diskspace.setSpace_UpTo32GB(Space_UpTo32GB);
					diskspace.setSpace_UpTo64GB(Space_UpTo64GB);
					diskspace.setSpace_UpTo128GB(Space_UpTo128GB);
					diskspace.setSpace_UpTo256GB(Space_UpTo256GB);
					diskspace.setSpace_UpTo512GB(Space_UpTo512GB);
					diskspace.setID(imp.insertDiskSpace(diskspace));
					iddiskspace = diskspace.getID();
					System.out.println(iddiskspace);

				    DiskTransferRate disktransferrate = new DiskTransferRate();
				        String TransferRate_UpTo50MBps = request.getParameter("to50MB");
					String TransferRate_UpTo100MBps = request.getParameter("to100MB");
					String TransferRate_UpTo200MBps = request.getParameter("to200MB");
					String TransferRate_UpTo400MBps = request.getParameter("to400MB");
					String TransferRate_UpTo600MBps = request.getParameter("to600MB");
					String TransferRate_UpTo1200MBps = request.getParameter("to1200MB");
					String TransferRate_UpTo2400MBps = request.getParameter("to2400MB");
					String TransferRate_UpTo3000MBps = request.getParameter("to3000MB");
					disktransferrate.setTransferRate_UpTo3000MBps(TransferRate_UpTo3000MBps);
					disktransferrate.setTransferRate_UpTo2400MBps(TransferRate_UpTo2400MBps);
					disktransferrate.setTransferRate_UpTo1200MBps(TransferRate_UpTo1200MBps);
					disktransferrate.setTransferRate_UpTo600MBps(TransferRate_UpTo600MBps);
					disktransferrate.setTransferRate_UpTo400MBps(TransferRate_UpTo400MBps);
					disktransferrate.setTransferRate_UpTo200MBps(TransferRate_UpTo200MBps);
					disktransferrate.setTransferRate_UpTo100MBps(TransferRate_UpTo100MBps);
					disktransferrate.setTransferRate_UpTo50MBps(TransferRate_UpTo50MBps);
					disktransferrate.setID(imp.insertDiskTransferRate(disktransferrate));
					iddisktransferrate = disktransferrate.getID();
					System.out.println(iddisktransferrate);
				
				
					HDD hdd = new HDD();	
					hdd.setDiskSpaceID(String.valueOf(iddiskspace));
					hdd.setDiskTransferRateID(String.valueOf(iddisktransferrate));			
					hdd.setID(imp.insertHDD(hdd));
					idhdd = hdd.getID();
					System.out.println(idhdd);
				
					DataStorageParam dataStorageParam = new DataStorageParam();	
					dataStorageParam.setHDDStorageID(String.valueOf(idhdd));
					dataStorageParam.setSASStorageID(String.valueOf(idsas));
					dataStorageParam.setSSDStorageID(String.valueOf(idssd));				
					dataStorageParam.setID(imp.insertDataStorageParam(dataStorageParam));
					iddatastorageparam = dataStorageParam.getID();
					System.out.println(iddatastorageparam);
					
				
					SM_NFF sm_nff = new SM_NFF();	
					sm_nff.setQuantityOfOperationsID(String.valueOf(idqte));
					sm_nff.setVolumeOfDataID(String.valueOf(idvolumeofdata));
					sm_nff.setDataRedundancySupportID(String.valueOf(iddataredsupport));
					sm_nff.setDataStorageParamID(String.valueOf(iddatastorageparam));
					
					sm_nff.setID(imp.insertSM_NFF(sm_nff));
					idsm_nff = sm_nff.getID();
					System.out.println(idsm_nff);
					
					
					SM sm = new SM();	
					sm.setDeploymentParameters_DP_NFFsID(String.valueOf(iddp));
					sm.setStreamingAndMultimedia_SM_NFFsID(String.valueOf(idsm_nff));
					sm.setQoSID(String.valueOf(idqos));
					imp.insertSM(sm);
					
					
					response.sendRedirect("ChoisirForm.php");
					
				 				 
			 	}	}
		if(path.equals("/ChoisirForm.php")) {
			Model model = new Model();
			ArrayList<String> FFlist= new ArrayList<>();
			Cookie[]cookies= request.getCookies();
			if(cookies!=null) {
				for(int i=0;i<cookies.length;i++) {
					if(cookies[i].getName().equals("FFList")) {
						String[] coo= cookies[i].getValue().split(",");
						for (int j = 0; j < coo.length; j++) {
							FFlist.add(coo[j]);
						}
			         
					}
				}
			}
		    model.setFF(FFlist);
		    request.setAttribute("model", model);
		    System.out.println(model.getFF());
		    request.getRequestDispatcher("Choisir.jsp").forward(request, response);

		}
			/******************Choisir.php ******************/	
		if(path.equals("/Choisir.php")) {
			String choisir = request.getParameter("choisir");
			if(choisir.equals("HumanRessourceManagement_HRM")){		
			response.sendRedirect("HRM.jsp"); }
			else if(choisir.equals("Streaming And Multimedia")){		
				response.sendRedirect("SM.jsp"); }

		}
                /******************DescriptionQuery.php ******************/	
		else if(path.equals("/DescriptionQuery.php")) {
			
			String FF= request.getParameter("user_message");
			FFQuery input = new FFQuery ();
			input.setFF(FF);
			try {
				JadeGateway.execute(new Behaviour(){
					private boolean finished = false;
					public void onStart() {
						try {
						ACLMessage msg = new ACLMessage(ACLMessage.CFP);
				    	AID agent = new AID("AgentFournisseur",AID.ISLOCALNAME);
				    	msg.addReceiver(agent);
				    	input.setAid(myAgent.getAID());
					    msg.setContentObject(input);
						myAgent.send(msg);
						} catch (IOException e) {
							e.printStackTrace();
						}
					  }

					@Override
				    public void action() {  	
				  ACLMessage res= myAgent.receive();
				  if(res!= null) {
					  switch (res.getPerformative()) {
						case ACLMessage.CFP:
							String FF = (String)res.getContent();
						    Cookie cookie = new Cookie("FF",FF);
					    	response.addCookie(cookie);
					    	System.out.println(FF);
							break;}
					 
					  finished= true;
				      }
					    else {
					      block();
					    }
					  }
					@Override
					public boolean done() {
						return finished;
					}
					 
					});
			} catch (StaleProxyException e) {
				e.printStackTrace();
			} catch (ControllerException e) {
				e.printStackTrace();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Im done");
			    request.getRequestDispatcher("DP1.jsp").forward(request, response);
			   
			
			
		}
		/******************QueryUser.php ******************/	
		else if(path.equals("/QueryUser.php")) {
			String Description= request.getParameter("user_message");
			ArrayList<String> keywords = new ArrayList<String>();
			ArrayList<String> Tokens = new ArrayList<String>();
			ArrayList<String> FinalKeywords = new ArrayList<String>();
			 ArrayList<String> matchedFF= new ArrayList<String>();
			
			try {
				/*** Text Rank ***/
				keywords=TextRank.sentenceDetect(Description);
				System.out.println("Keywords :\n\r"+keywords);
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
				System.out.println("Keywords:");
				System.out.println(FinalKeywords);
			} catch (IOException e) {
				e.printStackTrace();
			}
			/*** Get CloudDictionary ***/
		   	    System.out.println("************GetCloudDictionary**************");
		   	    JSONParser jsonParser = new JSONParser();
			    JSONArray Dictionnary = new JSONArray();
			
		   	    try (FileReader reader = new FileReader("C:\\Users\\pc-click\\Desktop\\CloudDictionary.json"))
	            {
	               //Read JSON file
	                Object obj = jsonParser.parse(reader);
	                Dictionnary = (JSONArray) obj;
	                //System.out.println(Dictionnary);
	  
	             } catch (IOException e) {
	                e.printStackTrace();
	             } catch (ParseException e) {
	                e.printStackTrace();
	             }
			
			   /*** Matching Keywords ***/
			    ArrayList<String> VisitedNode= new ArrayList<String>();
			    try {
					InterfaceImpDAOntologie.BFSbasedMatchingKeywords("OFFs", FinalKeywords, Dictionnary, VisitedNode, matchedFF);
				} catch (OWLException e) {
					e.printStackTrace();
				}	
			    System.out.println("FFS Matched:"+matchedFF);
			    
			    /**************** Get And Ranking Services *********/
			    InterfaceImpDAOntologie imp = new InterfaceImpDAOntologie();
			    ArrayList<JSONObject> RankedCatServices = new ArrayList<JSONObject>();
				try {
					 RankedCatServices =	InterfaceImpDAOntologie.RankingServices(imp.ServicesRetrieval(matchedFF), matchedFF, Dictionnary);
					 System.out.println(":"+RankedCatServices);
					 Collections.reverse(RankedCatServices);

				} catch (OWLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try (FileWriter file = new FileWriter("C:\\Users\\pc-click\\Desktop\\services.json",false)) {
		            //We can write any JSONArray or JSONObject instance to the file
					
				    file.write(RankedCatServices.toString());
			        file.flush();	
		            file.close();
		 
		        } catch (IOException e) {
		            e.printStackTrace();
		        }
				Model model = new Model();
		        model.setRankedCatServices(RankedCatServices);
				request.setAttribute("model", model);
				request.getRequestDispatcher("ServicesDecouvert.jsp").forward(request, response);
		
		/*************** Order.php *********************/
		}else if(path.equals("/Order.php")) {
			   String Title = request.getParameter("title").toString();
			   /*** Get Services List ***/
			   JSONParser jsonParser = new JSONParser();
			    ArrayList<JSONObject> ListServices = new ArrayList<JSONObject>();
			
		   	    try (FileReader reader = new FileReader("C:\\Users\\pc-click\\Desktop\\services.json"))
	            {
	               //Read JSON file
	                Object obj = jsonParser.parse(reader);
	                ListServices = (ArrayList<JSONObject>) obj;
	                //System.out.println(Dictionnary);
	  
	             } catch (IOException e) {
	                e.printStackTrace();
	             } catch (ParseException e) {
	                e.printStackTrace();
	             }
		   	 JSONObject service= SortedServices.GetService(ListServices, Title);
		   	 String FF= service.get("FF").toString();		 
		   	Model model = new Model();
	        model.setService(service);
	        request.setAttribute("model", model);
	        if(FF.equals("StreamingAndMultimedia")) {
	        	request.getRequestDispatcher("ServiceDetail.jsp").forward(request, response);
	        }else {
	        	request.getRequestDispatcher("ServiceDetailHRM.jsp").forward(request, response);
	        }	   
		}
		/******************Select.php ******************/	
	else if(path.equals("/select.php")) {
		String select = request.getParameter("select");
         if(select.equals("Provider")){		
			response.sendRedirect("Connexion.jsp"); }
		else if(select.equals("User")){		
			response.sendRedirect("ConnexionUser.jsp"); }

	}
		/******************update.php ******************/	
	else if(path.equals("/update.php")) {
		UpdateKeyWords up = new UpdateKeyWords();
		try {
			up.UpdateKeywords();
		} catch (OWLException | IOException e) {
			e.printStackTrace();
		}
		response.sendRedirect("update.jsp");
	}
			
		
	}

}
