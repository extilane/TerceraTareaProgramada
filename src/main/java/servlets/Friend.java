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
public class Friend extends HttpServlet {
	private Usuario view=new Usuario();//el loggeado
	private Usuario friend=new Usuario();//el que elige
    private Grafo   grafo=new Grafo();
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Friend() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		String correo=request.getParameter("Amigos");
		String log=request.getParameter("logeado");
		try{
			this.grafo=this.grafo.read();
			this.setFriend(correo);
			this.setView(log);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		//this.friend=LogIn.getUsers()[];
        //this.first=new Usuario("Marvin","ATI","qww", "mar09f@gmail.com","2","3","88676834","qwerty");//seqta
        //this.grafo.addVertice(new Usuario("abc","ATI","qww", "a@gmail.com","2","3","88676834","qwefrty"));
        //this.grafo.addVertice(new Usuario("fernan","ATI","qww", "s@gmail.com","2","3","88676834","qwertyf"));
        //this.grafo.addVertice(new Usuario("lalala","ATI","qww", "maddr09f@gmail.com","2","3","88676834","qwverty"));
        PrintWriter out = response.getWriter(); 
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<head>");
        out.println("<script language=\"javascript\">{\n" +
        		"function value(){\n" +
        		"                var e=document.getElementById(\"users\");\n" +
        		"                 var x=e.value;\n" +
        		"                 t=e.selectedIndex;\n" +
        		"            }"+
        		"            function out(){\n" +
        		"                document.location.href=\"index.html\";\n" +
        		"            }\n" +
        		"            \n" +
        		"          function noBack(){\n" +
        		"          window.location.hash=\"no-back-button\";\n" +
        		"          window.location.hash=\"Again-No-back-button\" //chrome\n" +
        		"          window.onhashchange=function(){window.location.hash=\"no-back-button\";}}\n" +
        		"            \n" +
        		"            function validar(){\n" +
        		"                document.location.href=\"index.xhtml\";}}\n" +
        		"function friend(){\n" +
        				"document.Lusers.submit();}"+
        		
        		"        </script>");
        out.println("<title>"+this.friend.getNombre()+"</title>"); //
        out.println("<style type=text/css>");
        out.println("</style>");          
        out.println("</head>");
        out.println("<body>");
        out.println("<h1 style=\"background: skyblue\"><font color=\"white\">SocialTec</font> </h1>");
        out.println("<h1>");
        out.println("<img src=\"data:image/jpg;base64,"+this.friend.getFoto()+"\" BORDER=\"2\" />");
        out.println("</h1>");
        if(this.view.isFriend(friend)){
        out.println("<table>");
        out.println("<tr><td><b style=\"font-size: medium\">Nombre: "+this.friend.getNombre());
        out.println("<tr><td><b style=\"font-size: medium\">Celular :"+this.friend.getCel()+"</b></td></tr>");
        out.println("<tr><td><b style=\"font-size: medium\">Correo electronico: "+this.friend.getCorreo()+"</b></td></tr>");
        out.println("<tr><td><div><b style=\"font-size: medium\">Carrera: "+this.friend.getCarrera()+"</b></td></tr>");
        out.println("<tr><td><div><b style=\"font-size: medium\">Año de carrera: "+this.friend.getAcarrera()+"</b></td></tr>");
        out.println("<tr><td><div><b style=\"font-size: medium\">Edad: "+this.friend.getEdad()+"</b></td></tr>");
        out.println("<<tr><td><div><b style=\"font-size: medium\">Dirección: "+this.friend.getDireccion()+"</b></td></tr>");
        out.println("<tr><td><div><b style=font-size: medium>Amigos:</b></td></tr>");
        out.println("</table>");}else{
        	 out.println("<form action=\"addfriend\"method=\"post\" name=\"Lusers\"><table>");
             out.println("<tr><td><b style=\"font-size: medium\">Nombre: "+this.friend.getNombre()+"</b></td></tr>");
             out.println("<input size=\"10\" name=\"logeado\" type=\"hidden\"  value=\""+this.friend.getCorreo()+"\"></input>");
             out.println("<input size=\"10\" name=\"viendo\" type=\"hidden\"  value=\""+this.view.getCorreo()+"\"></input>");
             out.println("<input value=\"Agregar amigo\"onclick=\"javascript:friend()\" type=\"button\"style=\"font-size: x-large\" ></input></form></table>"); 
        }
        out.println("</body>");
        out.println("</html>");
        
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		String correo=request.getParameter("users");
		String log=request.getParameter("logeado");
		try{
			this.grafo=this.grafo.read();
			this.setFriend(correo);
			this.setView(log);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		//this.friend=LogIn.getUsers()[];
        //this.first=new Usuario("Marvin","ATI","qww", "mar09f@gmail.com","2","3","88676834","qwerty");//seqta
        //this.grafo.addVertice(new Usuario("abc","ATI","qww", "a@gmail.com","2","3","88676834","qwefrty"));
        //this.grafo.addVertice(new Usuario("fernan","ATI","qww", "s@gmail.com","2","3","88676834","qwertyf"));
        //this.grafo.addVertice(new Usuario("lalala","ATI","qww", "maddr09f@gmail.com","2","3","88676834","qwverty"));
        PrintWriter out = response.getWriter(); 
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<head>");
        out.println("<script language=\"javascript\">{\n" +
        		"function value(){\n" +
        		"                var e=document.getElementById(\"users\");\n" +
        		"                 var x=e.value;\n" +
        		"                 t=e.selectedIndex;\n" +
        		"            }"+
        		"            function out(){\n" +
        		"                document.location.href=\"index.html\";\n" +
        		"            }\n" +
        		"            \n" +
        		"          function noBack(){\n" +
        		"          window.location.hash=\"no-back-button\";\n" +
        		"          window.location.hash=\"Again-No-back-button\" //chrome\n" +
        		"          window.onhashchange=function(){window.location.hash=\"no-back-button\";}}\n" +
        		"            \n" +
        		"            function validar(){\n" +
        		"                document.location.href=\"index.xhtml\";}}\n" +
        		"function friend(){\n" +
        				"document.Lusers.submit();}"+
        		
        		"        </script>");
        out.println("<title>"+this.friend.getNombre()+"</title>"); //
        out.println("<style type=text/css>");
        out.println("</style>");          
        out.println("</head>");
        out.println("<body>");
        out.println("<h1 style=\"background: skyblue\"><font color=\"white\">SocialTec</font> </h1>");
        out.println("<h1>");
        out.println("<img src=\"data:image/jpg;base64,"+this.friend.getFoto()+"\" BORDER=\"2\" />");
        out.println("</h1>");
        if(this.view.isFriend(friend)){
        out.println("<table>");
        out.println("<tr><td><b style=\"font-size: medium\">Nombre: "+this.friend.getNombre());
        out.println("<tr><td><b style=\"font-size: medium\">Celular :"+this.friend.getCel()+"</b></td></tr>");
        out.println("<tr><td><b style=\"font-size: medium\">Correo electronico: "+this.friend.getCorreo()+"</b></td></tr>");
        out.println("<tr><td><div><b style=\"font-size: medium\">Carrera: "+this.friend.getCarrera()+"</b></td></tr>");
        out.println("<tr><td><div><b style=\"font-size: medium\">Año de carrera: "+this.friend.getAcarrera()+"</b></td></tr>");
        out.println("<tr><td><div><b style=\"font-size: medium\">Edad: "+this.friend.getEdad()+"</b></td></tr>");
        out.println("<<tr><td><div><b style=\"font-size: medium\">Dirección: "+this.friend.getDireccion()+"</b></td></tr>");
        out.println("<tr><td><div><b style=font-size: medium>Amigos:</b></td></tr>");
        out.println("</table>");}else{
        	 out.println("<form action=\"addfriend\"method=\"post\" name=\"Lusers\"><table>");
             out.println("<tr><td><b style=\"font-size: medium\">Nombre: "+this.friend.getNombre()+"</b></td></tr>");
             out.println("<input size=\"10\" name=\"logeado\" type=\"hidden\"  value=\""+this.friend.getCorreo()+"\"></input>");
             out.println("<input size=\"10\" name=\"viendo\" type=\"hidden\"  value=\""+this.view.getCorreo()+"\"></input>");
             out.println("<input value=\"Agregar amigo\"onclick=\"javascript:friend()\" type=\"button\"style=\"font-size: x-large\" ></input></form></table>"); 
        }
        out.println("</body>");
        out.println("</html>");
        
        
	}
	/**
	 * @see doPeticionHttpServlet#(HttpServletRequest request, HttpServletResponse response)
	 */

	public void setFriend(String correo){
		this.friend=this.grafo.searchCorreo(correo);
	}
	public void setView(String correo){
		this.view=this.grafo.searchCorreo(correo);
	}

	
}


