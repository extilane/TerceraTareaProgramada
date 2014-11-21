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
public class LogIn extends HttpServlet {
	private  Usuario first=new Usuario();
	private static Usuario view=new Usuario();
    private Grafo   grafo=new Grafo();
	private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogIn() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html;charset=UTF-8");
		String correo=request.getParameter("email");
        String pass=request.getParameter("password");
        //this.first=new Usuario("Marvin","ATI","qww", "mar09f@gmail.com","2","3","88676834","qwerty");//seqta
        //this.grafo.addVertice(new Usuario("abc","ATI","qww", "a@gmail.com","2","3","88676834","qwefrty"));
        //this.grafo.addVertice(new Usuario("fernan","ATI","qww", "s@gmail.com","2","3","88676834","qwertyf"));
        //this.grafo.addVertice(new Usuario("lalala","ATI","qww", "maddr09f@gmail.com","2","3","88676834","qwverty"));
        //this.grafo.save();
        if(this.grafo.somthingIN()){
        try{
			this.grafo=this.grafo.read();
			this.first=this.grafo.getUser(correo, pass);
			view=this.first;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        }else{this.first=null;}
        PrintWriter out = response.getWriter(); 
        out.println("<!DOCTYPE html>");
        out.println("<html>");
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
        		"function solicitud(){\n" +
        				"document.aceptar.submit();}"+
        		
        		"        </script>");
        out.println("<title>LogIn</title>"); 
        out.println("<style type=text/css>");
        out.println("</style>");
        out.println("</head>");
      //  if(!this.grafo.somthingIN()){
        //	out.println("<body onload=\"javascript:out()\">");
        	//out.println("</body>");
        	//out.println("</html>");
        	//return;
        //}
		if(this.first!=null){
        	out.println("<body onload=\"javascript:noBack()\">");
        }else{out.println("<body onload=\"javascript:out()\">");
        out.println("</body>");
    	out.println("</html>");
    	return;}
        out.println("<h1 style=\"background: skyblue\"><font color=\"white\">SocialTec</font> </h1>");
        out.println("<DIV STYLE=\"position:absolute; top:040px; left:800px\"><b><font color=\"white\">Personas que quizas conozcas:</font></b></DIV>");
        if(this.grafo.getVertices().getSize()!=1){
        	out.println("<DIV STYLE=\"position:absolute; top:80px; left:830px\">");
    		this.grafo.getVertices().moveToFirst();
    		out.println("<form action=\"Friend\"method=\"post\" name=\"Lusers\" align=\"right\"><select name=\"users\" size=\"10\">");
    		for(int i=0;this.grafo.getVertices().getSize()!=i;i++){
    			if(!this.first.equals(this.grafo.getVertices().getDataActual())){
    				out.println("<option  onclick=\"javascript:friend()\" >"+this.grafo.getVertices().getDataActual().getCorreo()+"</option>");
    				}
    		this.grafo.getVertices().moveActoNext();}
    		out.println("<input size=\"10\" name=\"logeado\" type=\"hidden\"  value=\""+this.first.getCorreo()+"\"></input>");
    		out.println("</select></form></DIV>");
    	}
        if(this.first.getPeticiones().getSize()!=0){
        	out.println("<form action=\"addfriend\"method=\"get\" name=\"aceptar\" align=\"right\">");
        	this.first.getPeticiones().moveToFirst();
        	out.println("<DIV STYLE=\"position:absolute; top:040px; left:400px\"><b><font color=\"white\">Solicitud de amistad:</font></b></DIV>");
        	out.println("<DIV STYLE=\"position:absolute; top:80px; left:400px\">");
        	out.println("<select id=\"selec\" ALIGN=\"right\"  name=\"Amigos\" size=\"8\" style=\"alignment-adjust: alphabetic \" >");
        	for(int i=0;i!=this.first.getPeticiones().getSize();i++){	
        		out.println("<option  onclick=\"javascript:solicitud()\" >"+this.first.getPeticiones().getDataActual().getCorreo()+"</option>");
        		this.first.getPeticiones().moveActoNext();
        	}
        	out.println("<input size=\"10\" name=\"logeado\" type=\"hidden\"  value=\""+this.first.getCorreo()+"\"></input>");
        	out.println("</select></form></DIV>");
        }
        out.println("<h1>");
        out.println("<img src=\"data:image/jpg;base64,"+this.first.getFoto()+"\" BORDER=\"2\" />");
        out.println("</h1>");
        out.println("<table>");
        out.println("<tr><td><b style=\"font-size: medium\">Nombre: "+this.first.getNombre());
        out.println("<tr><td><b style=\"font-size: medium\">Celular :"+this.first.getCel()+"</b></td></tr>");
        out.println("<tr><td><b style=\"font-size: medium\">Correo electronico: "+this.first.getCorreo()+"</b></td></tr>");
        out.println("<tr><td><div><b style=\"font-size: medium\">Carrera: "+this.first.getCarrera()+"</b></td></tr>");
        out.println("<tr><td><div><b style=\"font-size: medium\">Año de carrera: "+this.first.getAcarrera()+"</b></td></tr>");
        out.println("<tr><td><div><b style=\"font-size: medium\">Edad: "+this.first.getEdad()+"</b></td></tr>");
        out.println("<<tr><td><div><b style=\"font-size: medium\">Dirección: "+this.first.getDireccion()+"</b></td></tr>");
        out.println("<tr><td><div><b style=font-size: medium>Amigos:</b></td></tr>");
        out.println("</table>");
        if(this.first.getRelaciones().getSize()!=0){
           out.println("<form name=\"registro\" action=\"Friend\" method=\"post\"><select name=\"Amigos\" size=\"10\">");
           this.first.getRelaciones().moveToFirst();
           for(int i=0;this.first.getRelaciones().getSize()!=i;i++){
              // Relacion temp=(Relacion)this.first.getRelaciones().getDataActual();
               out.println("<option  onclick=\"javascript:friend()\" >"+this.first.getRelaciones().getDataActual().getAmigo().getCorreo()+"</option>");
                       this.first.getRelaciones().moveActoNext();
                       }
           
           out.println("</select></form>");
       }
        out.println("<input size=\"10\" name=\"logeado\" type=\"hidden\"  value=\""+this.first.getCorreo()+"\"></input>");
       out.println("<input type=\"submit\" onclick=\"javascript:out()\" value=\"Salir\" /></html>");
        
	}
	public static Usuario getView(){
		return view;
	}
	public static void setUser(Usuario x){
		view=x;
	}
	
}


