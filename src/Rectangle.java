import java.awt.*;

//La classe Rectange hérite de la classe Figure//
public class Rectangle extends Figure {
    protected int Longueur;
    protected int Largeur;


    //Constructeurs avec arguments//
    public Rectangle(int px, int py,Color c) {
        super(new Point (px,py),c);
        Longueur = 0;
        Largeur = 0;
    }

    public Rectangle(int Long, int Larg) {
        super(new Point(0, 0));
        this.Longueur = Long;
        this.Largeur = Larg;
    }
    //Méthodes getter et setter//
    public int getLongueur() {
        return Longueur;
    }
    public int getLargeur() {
        return Largeur;
    }
    public void setLongueur(int a) {
        this.Longueur = a;
    }
    public void setLargeur(int b) {
        this.Largeur = b;
    }
    public double getPerimetre() {
        return Longueur * 2 + Largeur * 2;
    }
    public double getSurface() {
        return Longueur * Largeur;
    }

    //Redéfinition des classes abstraites setBoundingBox et draw////
    @Override
    public void setBoundingBox(int hauteurBB, int largeurBB) {
        Longueur = hauteurBB;
        Largeur = largeurBB;
    }
    @Override
    public void draw(Graphics g) {
        g.setColor(c);
        g.fillRect(origine.x, origine.y, Longueur, Largeur);

    }


    public String toString() {
        int i, j;
        System.out.print("\n+");
        for (i = 0; i < Longueur; i++) {
            System.out.print("--");
        }
        System.out.println("+");
        for (j = 0; j < Largeur; j++) {
            System.out.print("|");
            for (i = 0; i < Longueur; i++) {
                System.out.print("  ");
            }
            System.out.println("|");
        }
        System.out.print("+");
        for (i = 0; i < Longueur; i++) {
            System.out.print("--");
        }
        return "+";

    }

}
