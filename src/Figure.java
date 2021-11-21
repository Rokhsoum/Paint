import java.awt.*;
import java.io.Serializable;


public abstract class Figure implements Serializable {  //Implementation de l'interface Serialisable
    protected Point origine;
    protected Color c;

    //Constructeurs Figure avec arguments//
    public Figure(Point p,Color co){
        origine = p;
        c = co;
    }

    public Figure (Point origine) {
        this.origine = origine;}

    //Définition des méthodes abstraites//
    public abstract void setBoundingBox(int hauteurBB, int largeurBB);
    public abstract void draw(Graphics g);


    @Override
    //toString method//
    public String toString() {
        return "Rectangle : ("+origine.getx()+","+origine.gety()+")";
    }


    // Les methodes getPerimetre et getSurface de type abstarct//
    /**
     * @return perimetre de la figure
     */
    public abstract double getPerimetre();
    /**
     * @return surface de la figure
     */
    public abstract double getSurface();

}

