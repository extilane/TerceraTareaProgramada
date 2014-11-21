package redTec;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

//import org.apache.tomcat.jni.File;
public class Usuario implements Serializable {
	public static Usuario user=null;
    private String nombre,carrera,direccion,correo,pass;
    private String edad,Acarrera,telefono,foto;
    private Lista<Relacion> relaciones;
    private Lista<Usuario>  peticiones;
    public Usuario(String nombre,String carrera,String direccion,String correo,String edad,String año,String celular,String pass){
        this.nombre=nombre;this.carrera=carrera;this.direccion=direccion;
	this.correo=correo;this.pass=pass;
	this.edad=edad;this.Acarrera=año;
	this.telefono=celular;	
    this.relaciones=new Lista<Relacion>();
    this.peticiones=new Lista<Usuario>();
    }
    public Usuario(){
    	
    }
    public String getNombre(){
	return this.nombre;
    }
    public String getCarrera(){
        return this.carrera;
    }
    public String getDireccion(){
        return this.direccion;
    }
    public String getCorreo(){
        return this.correo;
    }
    public String getEdad(){
        return this.edad;
    }
    public String getAcarrera(){
        return this.Acarrera;
    }
    public String getCel(){
        return this.telefono;
	}
    public void setFoto(String ruta){///////////////
		this.foto=ruta;///////////////////
    }///////////////////////////////////////77
    
    public String getFoto(){//////////////////////////////////
	return this.foto;///////////////////////////////
    }/////////////////////////
    public String getPassword(){
        return this.pass;
    }
    public void addRelacion(Usuario amigo){
        this.relaciones.add(new Relacion(amigo));
    }
    
    public Lista<Relacion> getRelaciones(){
        return this.relaciones;
    }
    public void addPeticion(Usuario amigo){
        this.peticiones.add(amigo);
    }
    public Lista<Usuario> getPeticiones(){
    	return this.peticiones;
    }
    public boolean isFriend(Usuario usuario){
        if(this.relaciones.getSize()!=0){
         for(int i=0;this.relaciones.getSize()!=i;i++){
            if(this.relaciones.getDataActual().getAmigo()==usuario){
                return true;
            }
         }
        }
        return false;
    }
    public void save() throws IOException{
    	File file= new File("src/BData.txt");
    	FileOutputStream archi=new FileOutputStream(file);
    	ObjectOutputStream oss=new ObjectOutputStream(archi);
    	oss.writeObject(this);  // this es de tipo DatoUdp
    	oss.close();
    }
    public Usuario read() throws IOException, ClassNotFoundException{
    	File file= new File("src/BData.txt");
        FileInputStream fis=new FileInputStream(file);
        ObjectInputStream ios=new ObjectInputStream(fis);
        Usuario user=(Usuario)ios.readObject();
        return user;
    }
	public static void setGlobal(Usuario x){
		user=x;
	}
    public static Usuario getGlobal(){
    	return user;
    }
}
