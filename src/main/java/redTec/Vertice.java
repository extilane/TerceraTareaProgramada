package redTec;

import java.io.Serializable;

public class Vertice implements Serializable  {
    private Object vertice;
    private Lista relaciones;
    public Vertice(Object x){
        this.relaciones=new Lista();
        this.vertice=x;
    }
    public void relacionar(Vertice x,Vertice y){
        x.addrelacion(y);
        y.addrelacion(x);
    }
    private void addrelacion(Vertice x){
        this.relaciones.add(x);
    }
    public Object getData(){
        return this.vertice;
    }
}
