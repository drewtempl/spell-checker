import java.util.Scanner;
import java.io.*;

public class Closest {

    static final int b = 1000;

    public static void main(String[] args) {

        Node[][] grid = new Node[b][b];

        File f = new File("points.txt");
        double min = 2;

        try {
            Scanner scnr = new Scanner(f);

            while (scnr.hasNext()) {
                double x = scnr.nextDouble();
                double y = scnr.nextDouble();

                int xCord = hash(x);
                int yCord = hash(y);

                grid[xCord][yCord] = new Node(x, y, grid[xCord][yCord]);

                Node node = grid[xCord][yCord];

                for (int i = xCord - 1; i <= xCord + 1 && i < b; i++) {
                    if (i < 0)
                        i = 0;

                    for (int j = yCord - 1; j <= yCord + 1 && j < b; j++) {
                        if (j < 0)
                            j = 0;

                        Node comp = grid[i][j];

                        while (comp != null) {
                            if (comp != node) {
                                double dist = dist(comp, node);

                                if (dist < min)
                                    min = dist;
                            }
                            comp = comp.next;

                        }

                    }
                }

            }

            System.out.println("The closest pair of points is: " + min);
            scnr.close();

        } catch (FileNotFoundException e) {
            System.out.println("Cannot open file " + f.getAbsolutePath());
            System.out.println(e);
        }
    }

    private static int hash(double k) {
        return (int) (k * b) % b;
    }

    private static double dist(Node a, Node b) {
        return Math.sqrt(Math.pow((a.xCord - b.xCord), 2) +
                Math.pow((a.yCord - b.yCord), 2));
    }
}