package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controlers.CtrlABMPersona;
import entity.Persona;
import util.AppDataException;
import util.Emailer;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.Level;

/**
 * Servlet implementation class Start
 */
@WebServlet({ "/Start", "/start" })
public class Start extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Logger logger;
    /**
     * Default constructor. 
     */
    public Start() {
    	logger = LogManager.getLogger(getClass());
		
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			
			String user=request.getParameter("user");
			String pass=request.getParameter("pass");
			
			Persona per=new Persona();
			per.setUser(user);
			per.setPass(pass);
			
			CtrlABMPersona ctrl= new CtrlABMPersona();
			
			Persona pers=ctrl.login(per);
			
			try {
				request.setAttribute("listaPersonas", ctrl.getAll());
			} catch (AppDataException ade) {
				request.setAttribute("Error", ade.getMessage());
			} catch (Exception e) {
				response.setStatus(502);
			}
			
			request.getSession().setAttribute("user", pers);
			
			logger.log(Level.INFO,"log in "+pers.getDni());
			Emailer.getInstance().send("adrianmeca@gmail.com","Lista Personas",ctrl.personaListText());
			request.getRequestDispatcher("WEB-INF/welcome.jsp").forward(request, response);
			//response.getWriter().append(user).append(" ").append(pass);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		//doGet(request, response);
	}

}
