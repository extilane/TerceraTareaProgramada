package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.annotation.XmlElementDecl.GLOBAL;

import redTec.Grafo;
import redTec.Relacion;
import redTec.Usuario;

/**
 * Servlet implementation class LogIn
 */
public class addfriend extends HttpServlet {
    private Grafo   grafo=new Grafo();
    private Usuario logeado=new Usuario();
    private Usuario viendo=new Usuario();
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addfriend() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			this.grafo=this.grafo.read();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String correo=request.getParameter("Amigos");
		String log=request.getParameter("logeado");
		this.logeado=this.grafo.searchCorreo(log);
		this.viendo=this.grafo.searchCorreo(correo);
		this.grafo.relacionar(this.logeado,this.viendo);
		this.grafo.save();
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<script language=\"javascript\">{\n" +
    
        		"            function out(){\n" +
        		"                document.location.href=\"index.html\";}}</script>");
        out.println("<title>Servlet Friend</title>");            
        out.println("</head>");
        out.println("<body onload=\"javascript:out()\">");
        out.println("<h1>Servlet Friend at " + request.getContextPath() + "</h1>");
        out.println("</body>");
        out.println("</html>");
        
    }
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			this.grafo=this.grafo.read();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String correo=request.getParameter("viendo");
		String log=request.getParameter("logeado");
		this.logeado=this.grafo.searchCorreo(log);
		this.viendo=this.grafo.searchCorreo(correo);
		this.viendo.addPeticion(logeado);
		this.grafo.save();
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<script language=\"javascript\">{\n" +
    
        		"            function out(){\n" +
        		"                document.location.href=\"index.html\";}}</script>");
        out.println("<title>Servlet Friend</title>");            
        out.println("</head>");
        out.println("<body onload=\"javascript:out()\">");
        out.println("<h1>Servlet Friend at " + request.getContextPath() + "</h1>");
        out.println("</body>");
        out.println("</html>");
        
    }
	
	
}


