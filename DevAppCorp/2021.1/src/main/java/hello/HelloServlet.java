/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hello;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author viter
 */
@WebServlet("/alomundo")
public class HelloServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet HelloServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet HelloServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
   
    
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    	String msg = "";
    
    	String timeStamp = new SimpleDateFormat("HH").format(Calendar.getInstance().getTime());

    	int hora = Integer.parseInt(timeStamp);
	hora = hora - 3;
    	String lang = request.getParameter("lang");
    	if (hora < 12) {
            if(lang == null)
                lang = "pt";
            switch(lang){
                case "pt":
                    msg = "Bom dia, ";
                    break;
                case "en":
                    msg = "Good Morning, ";
                    break;
                case "fr":
                    msg = "Bonjour, ";
                    break;
                case "it":
                    msg = "Buongiorno, ";
                    break;
                case "es":
                    msg = "Buen día, ";
                    break;
            }
    	}
    	else if (hora < 18){

            if(lang == null)
                lang = "pt";
            switch(lang){
                case "pt":
                    msg = "Bom dia, ";
                    break;
                case "en":
                    msg = "Good afternoon, ";
                    break;
                case "fr":
                    msg = "Bon après-midi, ";
                    break;
                case "it":
                    msg = "Buon pomeriggio, ";
                    break;
                case "es":
                    msg = "Buenas tardes, ";
                    break;
            }
    	}
    	else if ((hora > 17)&&(hora < 24)){

            if(lang == null)
                lang = "pt";
            switch(lang){
                case "pt":
                    msg = "Boa noite, ";
                    break;
                case "en":
                    msg = "Good Evening, ";
                    break;
                case "fr":
                    msg = "Bonne nuit, ";
                    break;
                case "it":
                    msg = "Buona Notte, ";
                    break;
                case "es":
                    msg = "Buenas noches, ";
                    break;
            }
    	}
    	
        

        
        String nome = request.getParameter("nome");

        if(nome==null)
            nome = "Fulano";
        
        msg = msg+nome+"!";

        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
        /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet HelloServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet HelloServlet</h1>");
            out.println("<p>" + msg + "</p>");
            out.println("</body>");
            out.println("</html>");
        }
    }


	/**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
              
    	String msg = "";
    
    	String timeStamp = new SimpleDateFormat("HH").format(Calendar.getInstance().getTime());

    	int hora = Integer.parseInt(timeStamp);
        hora = hora - 3;
    	String lang = request.getParameter("lang");
    	if (hora < 12) {
            if(lang == null)
                lang = "pt";
            switch(lang){
                case "pt":
                    msg = "Bom dia, ";
                    break;
                case "en":
                    msg = "Good Morning, ";
                    break;
                case "fr":
                    msg = "Bonjour, ";
                    break;
                case "it":
                    msg = "Buongiorno, ";
                    break;
                case "es":
                    msg = "Buen día, ";
                    break;
            }
    	}
    	else if (hora < 18){

            if(lang == null)
                lang = "pt";
            switch(lang){
                case "pt":
                    msg = "Bom dia, ";
                    break;
                case "en":
                    msg = "Good afternoon, ";
                    break;
                case "fr":
                    msg = "Bon après-midi, ";
                    break;
                case "it":
                    msg = "Buon pomeriggio, ";
                    break;
                case "es":
                    msg = "Buenas tardes, ";
                    break;
            }
    	}
    	else if ((hora > 17)&&(hora < 2243)){

            if(lang == null)
                lang = "pt";
            switch(lang){
                case "pt":
                    msg = "Boa noite, ";
                    break;
                case "en":
                    msg = "Good Evening, ";
                    break;
                case "fr":
                    msg = "Bonne nuit, ";
                    break;
                case "it":
                    msg = "Buona Notte, ";
                    break;
                case "es":
                    msg = "Buenas noches, ";
                    break;
            }
    	}
    	
        
        String nome = request.getParameter("nome");

        if(nome==null)
            nome = "Fulano";
        
        msg = msg+nome+"!";

        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet HelloServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet HelloServlet</h1>");
            out.println("<p>" + msg + "</p>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
