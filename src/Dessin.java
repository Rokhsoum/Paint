import javax.swing.*;
import java.awt.* ;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;


//Implémentation de l'interface MouseMotionListener pour gérer les mouvements  et
// l'interface MouseListener pour gérer les boutons de la souris //
public class Dessin extends JPanel implements MouseMotionListener, MouseListener {

    private ArrayList<Figure> liste ;
    private Color c;
    private String nomFigure;
    private int x, y; //Déclaration de la position du clic de la souris avant relachement

    public Dessin() { //Constructeur par deafut
        super();

        c =Color.BLACK; //inisialisation de c avec une couleur noir
        nomFigure = "Rectangle"; //Initialisation de nom de figure par defaut en Rectangle
        liste = new ArrayList<Figure>(); //Instanciation d'une liste de figure vide

        this.addMouseListener(this);
        this.addMouseMotionListener(this);

    }

    @Override
    public void paintComponent(Graphics graphics) { //redefinition de la méthode paintComponents
        super.paintComponent(graphics);
        setBackground(Color.white);// la couleur du fond est blanc
        for(Figure f : liste) {
            f.draw(graphics); //on renvoie ici le polymorphisme dynamique
        }
    }
    //Modificateurs//
    public void setColor (Color c){
        this.c=c;
    }
    public void setnomFigure (String nomFigure){
        this.nomFigure = nomFigure;
    }

    //Accesseur>//
    public ArrayList<Figure> getliste (){
        return liste;
    }

    public Color getColor() {
        return c;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    //
    @Override
    public void mousePressed(MouseEvent e) {
        x = e.getX();
        y = e.getY();
        if(nomFigure.equals("Rectangle"))    { liste.add(new Rectangle(x,y,c)); }
        else if(nomFigure.equals("Carre"))   { liste.add(new Carre(x,y,c)); }
        else if(nomFigure.equals("Ellipse")) { liste.add(new Ellipse(x,y,c)); }
        else if(nomFigure.equals("Cercle"))  { liste.add(new Cercle(x,y,c)); }

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        x = e.getX();
        y = e.getY();
        int dx = e.getX()-x ;
        int dy = e.getY()-y ;
        repaint();

    }
    @Override
    public void mouseEntered(MouseEvent e) {
    }
    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        int dx = e.getX()-x ;
        int dy = e.getY()-y ;

        int i=0;
        for(Figure f : liste)
        {
            i++;
        }
        liste.get(i-1).setBoundingBox(dx, dy);
        repaint();

    }
    @Override
    public void mouseMoved(MouseEvent e){

    }
}
