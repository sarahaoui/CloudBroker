package Web;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
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

import com.github.jsonldjava.shaded.com.google.common.util.concurrent.Service;

import DAO.InterfaceImpDAO;
import DAO.InterfaceImpDAOntologie;
import Metier.entities.DP;


import Metier.entities.FFQuery;

import Metier.entities.QoS;

import Metier.entities.admin;
import Metier.entities.intended_user;
import Metier.entities.license_type;
import Metier.entities.location;
import Metier.entities.provider;

import Metier.entities.openness;
import Metier.entities.payement;
import Metier.entities.service_interface;
import Metier.entities.tax_accounting;
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
	        request.getRequestDispatcher("Home.php").forward(request, response);
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
			response.sendRedirect("Home.php");
			
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
			String version = request.getParameter("version");
			String description = request.getParameter("description");
			String url = request.getParameter("url");
			String impor = request.getParameter("import");	
			dp.setServiceTitle(title);
			dp.setProviderName(String.valueOf(idprovider));	
			dp.setsLA(impor);
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
							dp.setsLATokens(SlaTokens);
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
		
		Double price =Double.parseDouble(request.getParameter("price")) ;
		int availability =Integer.parseInt(request.getParameter("availability")) ;
		
		QoS.setAvailability(availability);
		QoS.setPrice(price);
			
		
		QoS.setID(imp.insertQoS(QoS));
		idqos = QoS.getID();
		System.out.println(idqos);
		// get cookie save dans BD 
		tax_accounting acc = new tax_accounting();
		acc.setDeploymentParameters_DP_NFFsID(String.valueOf(iddp));
		acc.setQoSID(String.valueOf(idqos));
		imp.insertTax_Acc(acc);
		try {
			JadeGateway.execute(new Behaviour(){
				private boolean finished = false;
				public void onStart() {
					ACLMessage msg = new ACLMessage(ACLMessage.CFP);
			    	AID agent = new AID("AgentUpdate",AID.ISLOCALNAME);
			    	msg.addReceiver(agent);
				    msg.setContent("Start Update");
					myAgent.send(msg);
					finished= true;
				  }

				@Override
			    public void action() {  	
			  ACLMessage res= myAgent.receive();
			  finished= true;
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
		request.getRequestDispatcher("Home.php").forward(request, response);
		
		}
			
		
		 /*****************DescriptionQueryAPI.php ******************/
       if(path.equals("/DescriptionQueryAPI.php")) {
			
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
			    request.getRequestDispatcher("ApiProvider.jsp").forward(request, response);
}
                /******************DescriptionQuery.php ******************/	
		 if(path.equals("/DescriptionQuery.php")) {
			
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
			
			try {
				JadeGateway.execute(new Behaviour(){
					private boolean finished = false;
					public void onStart() {
						try {
						ACLMessage msg = new ACLMessage(ACLMessage.CFP);
				    	AID agent = new AID("AgentUtilisateur",AID.ISLOCALNAME);
				    	msg.addReceiver(agent);
				    	
					    msg.setContentObject(Description);
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
						case ACLMessage.INFORM:
							ArrayList<JSONObject> RankedCatServices = new ArrayList<JSONObject>();
						try {
							RankedCatServices = (ArrayList<JSONObject>)res.getContentObject();
							Model model = new Model();
					        model.setRankedCatServices(RankedCatServices);
							request.setAttribute("model", model);
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
			System.out.println("Im done");
			
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
	        
	        	request.getRequestDispatcher("ServiceDetail.jsp").forward(request, response);
	       	   
		}
		/******************Select.php ******************/	
	else if(path.equals("/select.php")) {
		String select = request.getParameter("select");
         if(select.equals("Provider")){		
			response.sendRedirect("Connexion.jsp"); }
		else if(select.equals("User")){		
			response.sendRedirect("ConnexionUser.jsp"); }

	}

/****************** Dashboard *********/
	else if(path.equals("/Home.php")) {
		// get services of provider actuel
		
	ArrayList<DP>services=	InterfaceImpDAO.GetServices(idprovider);
	Model model = new Model();
    model.setServices(services);
    request.setAttribute("model", model);
    request.getRequestDispatcher("Home.jsp").forward(request, response);
	}
		 
 /********************* Ajouter with API**************************/
    else if(path.equals("/ApiQuery.php")){
    	String pathurl= request.getParameter("uri").toString();
    	URL url = new URL(pathurl);
    	JSONObject service = new JSONObject();
    	
		try {
			HttpURLConnection conn= (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.connect();
			// Check if connect is made 
			int responseCode = conn.getResponseCode();
			
			//200 ok
			if(responseCode!=200) {
				throw new RuntimeException("HttpRespondeCode: "+responseCode);
			}else {
				StringBuilder information= new StringBuilder();
				Scanner scanner = new Scanner(url.openStream());
				while(scanner.hasNext()) {
					information.append(scanner.nextLine());
				}
				scanner.close();
				//System.out.println(information);
				try (FileWriter file = new FileWriter("C:\\Users\\pc-click\\Desktop\\api.json",false)) {
		            //We can write any JSONArray or JSONObject instance to the file
					
				    file.write(String.valueOf(information));
			        file.flush();	
		            file.close();
		 
		        } catch (IOException e) {
		            e.printStackTrace();
		        }
				
				JSONParser parse = new JSONParser();
				
				try (FileReader reader = new FileReader("C:\\Users\\pc-click\\Desktop\\api.json"))
	            {
	               //Read JSON file
	                Object obj = parse.parse(reader);
	                service = (JSONObject) obj;  
	                
	             } catch (IOException e) {
	            	 e.printStackTrace();
	             } catch (ParseException e) {
	                e.printStackTrace();
	             }
				
				DP dp = new DP();
				final JSONObject servicefi = service;
				try {
					JadeGateway.execute(new Behaviour(){
						private boolean finished = false;
						public void onStart() {
							try {
							
							ACLMessage msg = new ACLMessage(ACLMessage.CFP);
					    	AID agent = new AID("AgentTraitementAPI",AID.ISLOCALNAME);
					    	msg.addReceiver(agent);
					    	System.out.println(servicefi);
						    msg.setContentObject(servicefi);
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
									case ACLMessage.ACCEPT_PROPOSAL:
						  System.out.println("Im APITraitement");
						  JSONObject service= new JSONObject();
							
							try {
								service = (JSONObject)res.getContentObject();
								System.out.println("Accept from APITraitement");
								} catch (UnreadableException e1) {
									e1.printStackTrace();
								}
							
					    	QoS qos= new QoS();
					    	qos.setAvailability(Integer.valueOf(service.get("availability").toString()));
					    	System.out.println(service.get("rating").toString());
					    	System.out.println(Double.valueOf(service.get("rating").toString()));
					    	qos.setRating(Double.valueOf(service.get("rating").toString()));
					    	qos.setPrice(Double.valueOf(service.get("price").toString()));
					    	qos.setID(imp.insertQoS(qos));
							idqos = qos.getID();
							
							license_type lc = new license_type();
							lc.setProprietary("");
							lc.setOpenSource("");	
							int IDLicenseType=(imp.getIDLicenseType(lc));
							
							intended_user iu = new intended_user();
							JSONObject intended= (JSONObject)service.get("Intended_User");
							String Individuals = intended.get("Individuals").toString();
							String Organizations = intended.get("Organizations").toString();		
							iu.setIndividuals(Individuals);
							iu.setOrganizations(Organizations);	
							int IDintended_user=(imp.getIDIntendedUser(iu));
							
							service_interface si = new service_interface();	
							si.setWebPortal("");
							si.setCLI("");
							si.setAPI("");
							int IDservice_interface=(imp.getIDServiceInterface(si));
							
							
							payement pa = new payement();
							pa.setFree("");
							pa.setPerUnit("");
							pa.setSubscription("");
							pa.setTiered("");
							int IDpayement=(imp.getIDPayement(pa));
							
							
							openness op = new openness();
							op.setLimitedLevel("");
							op.setBasicLevel("");
							op.setCompleteLevel("");
							op.setModerateLevel("");
							int IDopenness=(imp.getIDOpenness(op));
							
									
							location loc = new location();
							loc.setAfrica("");
							loc.setAsia("");
							loc.setAustrallia("");
							loc.setEurope_UK("");
							loc.setUS_Canada("");
							loc.setMiddleeastNorthAfrica("");
							int IDlocation=(imp.getIDLocation(loc));
						
					        		
							dp.setServiceTitle(service.get("Service_Title").toString());
							dp.setProviderName(String.valueOf(idprovider));	
							dp.setsLA("");
							dp.setVersion(service.get("Version").toString());
							dp.setServiceURL(service.get("URL").toString());
							dp.setShortDescription(service.get("Short_Description").toString());
							dp.setPaymentModelID(String.valueOf(IDpayement));		
							dp.setIntendedUserID(String.valueOf(IDintended_user));
							dp.setLicenseTypeID(String.valueOf(IDLicenseType));
							dp.setLocationID(String.valueOf(IDlocation));	
							dp.setOpennessID(String.valueOf(IDopenness));
							dp.setServiceInterfaceID(String.valueOf(IDservice_interface));
							
							ACLMessage msg = new ACLMessage(ACLMessage.CFP);
					    	AID agent = new AID("AgentTraitementTexte",AID.ISLOCALNAME);
					    	msg.addReceiver(agent);
						    msg.setContent(service.get("Short_Description").toString());
							myAgent.send(msg);
							break;
							case ACLMessage.CFP:
								ArrayList<String> FinalKeywords = new ArrayList<String>();
									try {
										FinalKeywords = (ArrayList<String>)res.getContentObject();
									} catch (UnreadableException e) {
										e.printStackTrace();
									}
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
									dp.setsLATokens(SlaTokens);
									dp.setID(imp.insertDP(dp));
									iddp = dp.getID();	
										
										tax_accounting acc = new tax_accounting();
										acc.setDeploymentParameters_DP_NFFsID(String.valueOf(iddp));
										acc.setQoSID(String.valueOf(idqos));
										imp.insertTax_Acc(acc);
										System.out.println("Insertion with ssucess");
										System.out.println("Im done");
										 finished = true;
										break;}
								 
								  }else {
						      block();
						    }
						  }
						@Override
						public boolean done() {
							return finished;
						}
						 
						});
				} catch (ControllerException | InterruptedException e) {
					e.printStackTrace();
				}
				
		}
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.println("Im done 2");
		request.getRequestDispatcher("Home.php").forward(request, response);
			
		}
		 
	/****************** Selection ****************************/
    else if(path.equals("/Selection.php")) {
    	String Availability = request.getParameter("AvailabilityV");
		String Rating = request.getParameter("RatingV");
		String PricePrio = request.getParameter("PriceV");
		
		String AvailabilityR = request.getParameter("AvailabilityS");
		String RatingR = request.getParameter("RatingS");
		String PricePrioR = request.getParameter("PriceS");
		
		QoS qos = new QoS();
		qos.setAvailabilityR(AvailabilityR);
		qos.setRatingR(RatingR);
		qos.setPriceR(PricePrioR);
		
		qos.setPrice(Double.parseDouble(PricePrio));
		qos.setRating(Double.parseDouble(Rating));
		qos.setAvailability(Integer.parseInt(Availability));
		
		try {
			JadeGateway.execute(new Behaviour(){
				private boolean finished = false;
				public void onStart() {
					try {
					ACLMessage msg = new ACLMessage(ACLMessage.CFP);
			    	AID agent = new AID("AgentSelection",AID.ISLOCALNAME);
			    	msg.addReceiver(agent);
				    msg.setContentObject(qos);
					myAgent.send(msg);

					} catch (IOException e) {
						e.printStackTrace();
					}
				  }

				@Override
			    public void action() {  	
			  ACLMessage res= myAgent.receive();
			  if(res!= null) {
				  System.out.println("Im Selection ");
				  JSONObject service= new JSONObject();
					
					try {
						service = (JSONObject)res.getContentObject();
						System.out.println("Accept from AgentSelection");
						} catch (UnreadableException e1) {
							e1.printStackTrace();
						}
			    	ArrayList<JSONObject> list = new ArrayList<JSONObject>();
			    	list.add(service);
					Model model = new Model();
			        model.setRankedCatServices(list);
			        request.setAttribute("model", model);
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
		} catch (ControllerException | InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Im done");
		request.getRequestDispatcher("ServicesDecouvert.jsp").forward(request, response);
    }
		
	}

}
