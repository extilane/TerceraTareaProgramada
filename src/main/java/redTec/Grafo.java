package redTec;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Grafo implements Serializable {
    private Lista<Usuario> Vertices;
	private ObjectInputStream ios;
    
    public Grafo(){
        this.Vertices=new Lista<Usuario>();
    }
    public void addVertice(Usuario vertice){
        this.Vertices.add(vertice);
    }
    public Lista<Usuario> getVertices(){
    	return this.Vertices;
    }
    public boolean search(Usuario x){
        return this.Vertices.search(x)!=null;
    }
    public Usuario searchCorreo(String correo){
    	Vertices.moveToFirst();
    	for(int i=0;Vertices.getSize()!=i;i++){
    		if(Vertices.getDataActual().getCorreo().equals(correo)){
    			return Vertices.getDataActual();
    		}
    		Vertices.moveActoNext();
    	}
    	return null;
    }
    
    public void relacionar(Usuario x,Usuario y){
    	Usuario U1= (Usuario)this.Vertices.search(x);
    	Usuario U2= (Usuario)this.Vertices.search(y);
        if(U1!=null&&U2!=null){
            U1.addRelacion(U2);
            U2.addRelacion(U1);
        }
    }
    
    public Usuario getFirst(){
        return this.Vertices.getDataActual();
    }
    public void save() throws IOException{
    	File file= new File("src/BData.txt");
    	FileOutputStream archi=new FileOutputStream(file);
    	ObjectOutputStream oss=new ObjectOutputStream(archi);
    	oss.writeObject(this);  // this es de tipo DatoUdp
    	oss.close();
    }
    public Grafo read() throws IOException, ClassNotFoundException{
    	File file= new File("src/BData.txt");
        FileInputStream fis=new FileInputStream(file);
        ios = new ObjectInputStream(fis);
        Grafo gsaved=(Grafo)ios.readObject();
        return gsaved;
    }
	public Usuario getUser(String correo, String pass) {
		this.Vertices.moveToFirst();
    	for(int i=0;i!=this.Vertices.getSize();i++){
    		if(this.Vertices.getDataActual().getCorreo().equals(correo)&&this.Vertices.getDataActual().getPassword().equals(pass)){
    			return this.Vertices.getDataActual();
    		}
    		this.Vertices.moveActoNext();}
		return null;
	}	
	public boolean somthingIN() {
		try{
	    	File file= new File("src/BData.txt");
	        FileInputStream fis=new FileInputStream(file);
	        ios = new ObjectInputStream(fis);
	        Grafo gsaved=(Grafo)ios.readObject();
	        return true;
	        }catch(Exception e){return false;	}
	}   
}
