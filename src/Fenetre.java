import javax.swing.*;
import java.awt.*;
import java.awt.event.*; //*comme ActionListener


// La classe fenetre hérite de JFrame//
public class Fenetre extends JFrame  implements ActionListener { //Classe Fenêtre implémente l'interface ActionListener//

    private Dessin monDessin;


    public Fenetre (String titre){
        super(titre); }


    public Fenetre (String titre, int locX, int locY, int sizeX, int sizeY, boolean visible) {
        super(titre);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // sert a faire arreter l'execution de programme une fois on sort de la fenetre
        setLocation(locX, locY);
        setSize(sizeX, sizeY);


        Container contentPane = getContentPane() ;
        //MenuBar//
        JMenuBar m= new JMenuBar();
        // Bare de Menu "Fichiers"//
        JMenu menu1 =new JMenu("Fichiers");
        // Les sous-menus : Ouvrir, Nouveau, Enregistrer, Quitter//
        JMenuItem Ouvrir = new JMenuItem("Ouvrir") ;
        Ouvrir.addActionListener(this);
        menu1.add(Ouvrir); // on ajoute le sous-menu"Ouvrir" au bare de menu"Fichier"

        JMenuItem Nouveau = new JMenuItem("Nouveau");
        Nouveau.addActionListener(this);
        menu1.add(Nouveau);

        JMenuItem Enregistrer = new JMenuItem("Enregistrer") ;
        Enregistrer.addActionListener(this);
        menu1.add(Enregistrer);

        // Trait de separation entre les sous-menus Enregistrer et Quitter //
        menu1.addSeparator();
        JMenuItem Quitter = new JMenuItem("Quitter");
        Quitter.addActionListener(this);
        menu1.add(Quitter);
        m.add(menu1); // on ajoute le menu1"Fichier" au Bare de Menu

        // Bare de Mneu "A propos"
        JMenu menu2 = new JMenu("  A propos");
        // sous-menus :Auteurs
        JMenuItem Auteurs = new JMenuItem("Auteurs");
        Auteurs.addActionListener(this);
        menu2.add(Auteurs);
        m.add(menu2);
        setJMenuBar(m);

        //raccourci Ctrl+S
        Enregistrer.setAccelerator(KeyStroke.getKeyStroke('S',Toolkit.getDefaultToolkit().getMenuShortcutKeyMask(), true));

        //GridLayout//
        // Panneau de Base//
        JPanel panneau =new JPanel();
        panneau.setLayout(new GridLayout(1,2)); //A gauche on va mettre Panneau de couleur et A droite on va mettre Panneau d'outil

        //Panneau de couleurs//

        JPanel PanneauCouleur = new JPanel();
        PanneauCouleur.setLayout(new GridLayout(2,4)); //Panneau de couleurs de 2 lignes et 4 couleus et donc 8 buttons

        JButton Noir = new JButton("Noir");
        Noir.addActionListener(this);
        Noir.setBackground(Color.black);
        PanneauCouleur.add(Noir);

        JButton Jaune  = new JButton("Rouge");
        Jaune.addActionListener(this);
        Jaune.setBackground(Color.red);
        PanneauCouleur.add(Jaune);

        JButton Rouge = new JButton("Vert");
        Rouge.addActionListener(this);
        Rouge.setBackground(Color.green);
        PanneauCouleur.add(Rouge);

        JButton Rose = new JButton("Bleu");
        Rose.addActionListener(this);
        Rose.setBackground(Color.blue);
        PanneauCouleur.add(Rose);

        JButton Vert = new JButton("Jaune");
        Vert.addActionListener(this);
        Vert.setBackground(Color.yellow);
        PanneauCouleur.add(Vert);

        JButton Magenta = new JButton("Rose");
        Magenta.addActionListener(this);
        Magenta.setBackground(Color.pink);
        PanneauCouleur.add(Magenta);

        JButton Bleu = new JButton("Magenta");
        Bleu.addActionListener(this);
        Bleu.setBackground(Color.magenta);
        PanneauCouleur.add(Bleu);

        JButton Orange = new JButton("Orange");
        Orange.addActionListener(this);
        Orange.setBackground(Color.orange);
        PanneauCouleur.add(Orange);

        panneau.add(PanneauCouleur);

        // Panneau d'outils //

        JPanel PanneauOutil = new JPanel();
        PanneauOutil.setLayout(new GridLayout(2,2)); //Panneau d'outils de 2 lignes et 2 couleurs donc 4 bouttons

        JButton Ellipse = new JButton("Ellipse");
        PanneauOutil.add(Ellipse) ;
        Ellipse.addActionListener(this);
        JButton Cercle =new JButton("Cercle");
        PanneauOutil.add(Cercle);
        Cercle.addActionListener(this);
        JButton Carre = new JButton("Carre");
        PanneauOutil.add(Carre);
        Carre.addActionListener(this);

        JButton Rectangle =new JButton("Rectangle");
        PanneauOutil.add(Rectangle);
        Rectangle.addActionListener(this);

        panneau.add(PanneauOutil);

        //BorderLayout//

        contentPane.add(panneau,"South");
        //on remplace dans ce constructeur la zone de texte du centre par dessin et instancier //
        monDessin = new Dessin();
        contentPane.add(monDessin,"Center");

        setVisible(visible);
    }

    public void actionPerformed(ActionEvent e){  //Capter la demande d'un événenement (action)
        String cmd = e.getActionCommand();

        if(cmd.equals("Nouveau"))          { System.out.println("tu as appuye sur " + cmd);
            monDessin.getliste().clear();
            repaint(); }
        else if(cmd.equals("Fichier"))     { System.out.println("tu as appuye sur "+ cmd);}
        else if(cmd.equals("Ouvrir"))      { System.out.println("tu as appuye sur " + cmd); }
        else if(cmd.equals("Enregistrer")) { System.out.println("tu as appuye sur " + cmd); }
        else if(cmd.equals("Quitter"))     { System.exit(0); }
        else if(cmd.equals("Auteurs"))     { System.out.println("tu as appuye sur " + cmd);
            JOptionPane Author = new JOptionPane();
            Author.showMessageDialog( new Frame(), " L'auteur est Rokhaya SOUMARE", "Author", JOptionPane.PLAIN_MESSAGE);}
        else if(cmd.equals("Noir"))        { System.out.println("tu as appuye sur " + cmd);
            monDessin.setColor(Color.black);}
        else if(cmd.equals("Rouge"))       { System.out.println("tu as appuye sur " + cmd);
            monDessin.setColor(Color.red);}
        else if(cmd.equals("Vert"))        { System.out.println("tu as appuye sur " + cmd);
            monDessin.setColor(Color.green);}
        else if(cmd.equals("Bleu"))        { System.out.println("tu as appuye sur " + cmd);
            monDessin.setColor(Color.blue); }
        else if(cmd.equals("Jaune"))       { System.out.println("tu as appuye sur " + cmd);
            monDessin.setColor(Color.yellow); }
        else if(cmd.equals("Rose"))        { System.out.println("tu as appuye sur " + cmd);
            monDessin.setColor(Color.pink); }
        else if(cmd.equals("Magenta"))     { System.out.println("tu as appuye sur " + cmd);
            monDessin.setColor(Color.magenta); }
        else if(cmd.equals("Orange"))      { System.out.println("tu as appuye sur " + cmd);
            monDessin.setColor(Color.orange); }
        else if(cmd.equals("Ellipse"))     { System.out.println("tu as appuye sur " + cmd);
            monDessin.setnomFigure("Ellipse");}
        else if(cmd.equals("Cercle"))      { System.out.println("tu as appuye sur " + cmd);
            monDessin.setnomFigure("Cercle");}
        else if(cmd.equals("Carre"))       { System.out.println("tu as appuye sur " + cmd);
            monDessin.setnomFigure("Carre");}
        else if(cmd.equals("Rectangle"))   { System.out.println("tu as appuye sur " + cmd);
            monDessin.setnomFigure("Rectangle");}
        else if(cmd.equals("Quit"))        { System.out.println("tu as appuye sur " + cmd);
            System.exit(0); }
        else { System.err.println(cmd); }
    }

}
