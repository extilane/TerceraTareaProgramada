package servlets;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import redTec.Grafo;
import redTec.ImageUtils;
import redTec.Relacion;
import redTec.Usuario;

/**
 * Servlet implementation class Registro
 */
@WebServlet("/upload")
@MultipartConfig	
public class Registro extends HttpServlet {
	private Usuario first;
    private Grafo   grafo=new Grafo();
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Registro() {
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
		/**
	     * @param args the command line arguments
	     */
		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		String nombre=request.getParameter("nombre");
        String correo=request.getParameter("correo");
        String carrera=request.getParameter("carrera");
        String año=request.getParameter("ano");
        String edad=request.getParameter("edad");
        String direc=request.getParameter("direc");
        String celular=request.getParameter("cel");
        String pass=request.getParameter("contra");
        Part filePart = request.getPart("foto");
        String filename = getFilename(filePart);
        InputStream filecontent = filePart.getInputStream();
        String fotox = ImageUtils.encodeToString(filecontent);
        this.first=new Usuario(nombre, carrera, direc, correo,edad,año,celular,pass);
        this.first.setFoto(fotox);
        this.grafo.addVertice(this.first);
        LogIn.setUser(this.first);
        this.grafo.save();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<script language=\"javascript\">{\n" +
        		"            function out(){\n" +
        		"                document.location.href=\"index.html\";\n" +
        		"            }\n" +
        		"            \n" +
        		"          function noBack(){\n" +
        		"          window.location.hash=\"no-back-button\";\n" +
        		"          window.location.hash=\"Again-No-back-button\" //chrome\n" +
        		"          window.onhashchange=function(){window.location.hash=\"no-back-button\";}}\n" +
        		"            \n" +
        		"function friend(){\n" +
				"document.Lusers.submit();}"+
        		"            function validar(){\n" +
        		"                document.location.href=\"index.xhtml\";}}\n" +
        		"        </script>");
        out.println("<title>Servlet LogIn</title>"); 
        out.println("<style type=text/css>");
        out.println("</style>");
        out.println("</head>");
        out.println("<body onload=\"javascript:noBack()\">");
        out.println("<h1 style=\"background: skyblue\"><font color=\"white\">SocialTec</font> </h1>");
        out.println("<DIV STYLE=\"position:absolute; top:019px; left:800px\"><b><font color=\"white\">Personas que quizas conozcas:</font></b></DIV>");
        if(5+1==8){
        	out.println("<DIV STYLE=\"position:absolute; top:80px; left:830px\">");
    		this.grafo.getVertices().moveToFirst();
    		out.println("<form action=\"Friend\"method=\"post\" name=\"Lusers\" align=\"right\"><select name=\"users\" size=\"10\">");
    		for(int i=0;this.grafo.getVertices().getSize()!=i;i++){
    			if(!this.first.equals(this.grafo.getVertices().getDataActual())){
    				out.println("<option  onclick=\"javascript:friend()\" >"+this.grafo.getVertices().getDataActual().getCorreo()+"</option>");
    				}
    		this.grafo.getVertices().moveActoNext();}
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
        	out.println("<form><select name=\"Amigos\" size=\"10\">");
           this.first.getRelaciones().moveToFirst();
           for(int i=0;this.first.getRelaciones().getSize()!=i;i++){
               Relacion temp=(Relacion)this.first.getRelaciones().getDataActual();
               out.println("<option>"+temp.getAmigo().getNombre()+"</option>");}
       }
       out.println("</select></form>");
       out.println("<input type=\"submit\" onclick=\"javascript:out()\" value=\"Salir\" /></html>");
        
	}
	 private static String getFilename(Part part) {
		    for (String cd : part.getHeader("content-disposition").split(";")) {
		        if (cd.trim().startsWith("filename")) {
		            String filename = cd.substring(cd.indexOf('=') + 1).trim().replace("\"", "");
		            return filename.substring(filename.lastIndexOf('/') + 1).substring(filename.lastIndexOf('\\') + 1); // MSIE fix.
		        }
		    }
		    return null;
		}

}

