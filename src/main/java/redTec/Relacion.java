package redTec;

import java.io.Serializable;

public class Relacion implements Serializable {
    private Usuario amigo;
    
    public Relacion(Usuario amigo){
        this.amigo=amigo;
    }
    public Usuario getAmigo(){
        return this.amigo;
    }
    
}
