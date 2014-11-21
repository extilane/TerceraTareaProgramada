package redTec;
import java.io.Serializable;
/**
*
* @param <E>
*/
public class Lista<E>implements Serializable{
    private class Nodo <E>implements Serializable {
        private E data;
        private Nodo next;
        private Nodo previous;
        
    public Nodo(E data){
        this.data=data;
        this.next=null;
        this.previous=null;
    }
    public E getData(){
        return this.data;
    }
    public void setNext(Nodo x){
        this.next=x;
    }
    public void setPrevious(Nodo y){
        this.previous=y;
    }
    public Nodo getNext(){
        return this.next;
    }
    public Nodo getPrevious(){
        return this.previous;
    }
    public void setData(E e){
        this.data=e;
    }
    public void exchange(Nodo e){
        E t=(E) e.getData();
        e.setData(this.getData());
        this.setData(t);
    }
    }
    private int size;
    private Nodo first;
    private Nodo last;
    private Nodo actual;
    
    public Lista(){
        this.size=0;
        this.first=null;
        this.last=null;
        this.actual=null;
    }
    public void add(E o){
        Nodo node=new Nodo(o);
        if(this.size==0){
            this.first=node;
            this.last=node;
            this.actual=node;}
        else{
            this.last.setNext(node);
            node.setPrevious(this.last);
            this.last=node;this.actual=node;}
        size++;
        }
    public void deleteFirst(){
        this.first=this.first.getNext();
        this.first.setPrevious(null);
        this.size--;
    }
    public E getDataActual(){
        return (E) this.actual.getData();
    }
    public E getFirst(){
        if (this.size!=0){
            return (E) this.first.getData();}
        return null;
        }
    public void moveToFirst(){
        this.actual=this.first;
    }
    public void moveActoNext(){
        this.actual=this.actual.getNext();
    }
    public E search(E x){
        if(this.size!=0){
            this.moveToFirst();
            for(int i=0;i!=this.size;i++){
                if(x==this.getDataActual()){
                    return this.getDataActual();
                }else{
                    this.actual=this.actual.getNext();
                    i++;
                }
            }
        }
        return null;
    }
    public int getSize(){
        return this.size;
    }
    public void ToString(){
        this.moveToFirst();
        for(int i=0;i!=this.size;i++){
            System.out.println(this.actual.getData());
            this.actual=this.actual.getNext();
        }
        
    }

} 	
