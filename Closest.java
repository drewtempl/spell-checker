import java.util.Scanner;
import java.io.*;

public class Closest {

    public static void main(String [] args) {

        Node [][] grid = new Node[100][100];

        File f = new File("points.txt");

        try {
            Scanner scnr = new Scanner(f);
            boolean status = true;

            while (status) {
                double x = scnr.nextDouble();
                double y = scnr.nextDouble();

                status = false;
            }



        } catch (FileNotFoundException e) {
            System.out.println("Cannot open file " + f.getAbsolutePath());
            System.out.println(e);
        }
    }

    private static int hash(double k) {
        return 1;
    }
}