import java.awt.*;
import java.io.*;

public class Test {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        //Instanciation de la classe Fenêtre//
        Fenetre win = new Fenetre("Ma Fenêtre", 200,400,600,400, true );

        //Création un objet de type ObjectOutputStream
        ObjectOutputStream ecrire = null;
        try {
            ecrire = new ObjectOutputStream(new FileOutputStream("Dessins.sto"));
            Ellipse R = new Ellipse(18,40, Color.RED);
            ecrire.writeObject(R);
            ecrire.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("donnees/Dessins.bin"));

        Ellipse E = new Ellipse(20,60, Color.BLUE);
        E.setGrandaxe(50);
        E.setPetitaxe(10);
        objectOutputStream.writeObject(E);
        objectOutputStream.close();

        //Creation un objet de type ObjectInputStream
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("donnees/Dessins.bin"));

        Ellipse Read = (Ellipse) objectInputStream.readObject();

        objectInputStream.close();

        System.out.println(Read.getGrandaxe());
        System.out.println(Read.getPetitaxe());
    }
}