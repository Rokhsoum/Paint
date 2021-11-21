import java.awt.*;

import static java.lang.Math.PI;

//La classe Cercle hérite de la classe Ellipse//
public class Cercle extends Ellipse {
    private int Rayon;


    public Cercle (int Rayon)
    {super(Rayon,Rayon);
        this.Rayon=Rayon;
    }

    //Constructeurs avec arguments//
    public Cercle (int px, int py,Color c){

        super(px, py, c);
    }

    //Redéfinition de la classe abstraite setBoundingBox//
    public void setBoundingBox(int hauteurBB, int largeurBB) {
        Grandaxe = hauteurBB;
        Petitaxe = hauteurBB;
    }

    public int getRayon(int a){
        return a;}
    public double getPerimetre() {
        return PI*2*Rayon ;
    }
    public double getSurface(){
        return PI*(Rayon*Rayon);
    }
}
