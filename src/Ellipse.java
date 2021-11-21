import java.awt.*;

import static java.lang.Math.PI;
import static java.lang.Math.sqrt;

//La classe Ellipse hérite de la classe Figure//
public class Ellipse extends Figure {
    protected int Grandaxe;
    protected int Petitaxe;

    public Ellipse ( int G, int P) {
        super(new Point(0, 0));
        this.Grandaxe=G;
        this.Petitaxe=P;
    }

    //Constructeurs avec arguments//
    public Ellipse (int px, int py,Color c){
        super (new Point(px,py),c);
        Grandaxe = 0;
        Petitaxe = 0;
    }

    //Méthode getter et setter
    public int getGrandaxe (){
        return Grandaxe; }
    public int getPetitaxe(){
        return Petitaxe; }

    public void setGrandaxe(int grandaxe) {
        Grandaxe = grandaxe;
    }
    public void setPetitaxe(int petitaxe) {
        Petitaxe = petitaxe;
    }

    //Redéfinition des classes abstraites setBoundingBox et draw//
    @Override
    public void setBoundingBox(int hauteurBB, int largeurBB) {
        Grandaxe = hauteurBB;
        Petitaxe = largeurBB;
    }
    @Override
    public void draw(Graphics g) {
        g.setColor(c);
        g.fillOval(origine.x, origine.y, Grandaxe, Petitaxe);
    }

    public double getPerimetre( ){
        return 2*PI*sqrt((Grandaxe*Grandaxe + Petitaxe*Petitaxe)/2);
    }
    public double getSurface( ){
        return PI*Grandaxe*Petitaxe/4;
    }


}
