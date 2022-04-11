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
import Metier.entities.login;
import Métier.BabelNetConnection;
import Métier.Test2;
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
		String path =request.getServletPath();
		

		/******************Inscription.php ******************/	
		if(path.equals("/Inscrire.php")) {
			
			login newUser = new login();			
			String nom = request.getParameter("nom");
			String motdepasse = request.getParameter("motdepasse");
			String email = request.getParameter("email");
			String telephone = request.getParameter("telephone");
			String nom_entreprise = request.getParameter("nom_entreprise");
			String pays = request.getParameter("pays");
			
		//	login newUser = new login (nom, motdepasse, email, telephone, nom_entreprise, pays);
			
			newUser.setNom(nom);
			newUser.setMotdepasse(motdepasse);
			newUser.setEmail(email);
			newUser.setTelephone(telephone);
			newUser.setNom_entreprise(nom_entreprise);
			newUser.setPays(pays);
			
			imp.insertProvider(newUser);
			response.sendRedirect("DP1.jsp");
			
		}else if(path.equals("/DescriptionQuery.php")) {
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
			
			
		}
	}
	
		
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("nom");
		String email = request.getParameter("email");
		
		HttpSession session = request.getSession();
		session.setAttribute("nom",name);
		session.setAttribute("email",email);
		
		doGet(request, response);
	}

}
