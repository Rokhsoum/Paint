import java.awt.*;

//La classe Carre hérite de la classe Rectangle//
public class Carre extends Rectangle {
    private int cote;


    //Constructeurs avec arguments//
    public Carre(int px, int py, Color c) {
        super(px, py, c);
    }

    //Redéfinition de la classe abstraite setBoundingBox//
    public void setBoundingBox(int hauteurBB,int largeurBB) {
        Longueur = hauteurBB;
        Largeur = hauteurBB;
    }

    public Carre (int cote) {
        super(cote, cote);
        this.cote = cote;
    }

    //Méthode getter//
    public int getcote() {
        return cote;     }

    //Déclaration des méthodes setLongueur et setLargeur qui redéfinissent celles de la super classe//
    @Override
    public void setLongueur(int a) {
        super.setLongueur(a);
        super.setLargeur(a);
    }

}