package com.tpgenielogiciel.serv;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tpgenielogiciel.control.Utilisatcontrole;
import com.tpgenielogiciel.model.Utilisatmodel;

/**
 * Servlet implementation class Servlogin
 */
@WebServlet("/Servlogin")
public class Servlogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		this.getServletContext().getRequestDispatcher("/WEB-INF/Login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		String nom = request.getParameter("nom");
		
		String password = request.getParameter("passwd");
	Map<String, String> erreur = new HashMap<String,String>();
	 Utilisatmodel utilis = new Utilisatmodel();
	 Utilisatcontrole utilisacontr = new Utilisatcontrole();
	 
	 utilis.setNom(nom);
	 utilis.setPasswd(password);
	 
	 String envoi;
	
	 if(utilisacontr.existnom(utilis))
	 {
		 System.out.println("succes de connection");
	 }
	 else
		 erreur.put("nomp", "votre username n est pas correcte");
	 
		 if(utilisacontr.existmotpass(utilis))
		 {
			 System.out.println("succes mot pass");
		 }
		 else {
			 erreur.put("motpass", "votre mot de passe est incorrect");
		 }
		 	
		   if(erreur.isEmpty()) 
		   {
			   this.getServletContext().getRequestDispatcher("/WEB-INF/inscription.jsp").forward(request, response);
			   System.out.println(erreur.size());
		   }
			   
			   
		   
		   else
		  {
			  request.setAttribute("erreur", erreur);
			   this.getServletContext().getRequestDispatcher("/WEB-INF/Login.jsp").forward(request, response);;
				  
			   
		   } 
	 
	 			
	                  
	                  
	                  
	                  //request.setAttribute("envo", envoi);
	                //  this.getServletContext().getRequestDispatcher("/WEB-INF/Login.jsp").forward(request, response);
	       
	}
	

}
