import java.io.Serializable;

public class Point implements Serializable  { //Implementation de l'interface Serializable
    //Déclaration de x et y//
    protected  int x,y;

    //Constructeurs avec arguments//
    public Point ( int a, int b){
        this.x=a;
        this.y=b;}
    //Getter method//
    public int getx(){
        return x;
    }
    public int gety(){
        return y;
    }

    //Constructeurs sans arguments//
    public Point () {
        this.x=0;
        this.y=0;}
}
