import java.util.Scanner;
import java.io.*;

public class Closest {

    static final int b = 100;

    public static void main(String[] args) {

        Node[][] grid = new Node[b][b];

        File f = new File("points.txt");

        try {
            Scanner scnr = new Scanner(f);

            while (scnr.hasNext()) {
                double x = scnr.nextDouble();
                double y = scnr.nextDouble();

                grid[hash(x)][hash(y)] = new Node(x, y, grid[hash(x)][hash(y)]);

            }
            double min = 3;

            for (int i = 0; i < b; i++) {
                for (int j = 0; j < b; j++) {
                    Node node = grid[i][j];

                    while (node != null) {
                        for (int row = i - 1; row <= i + 1 && row < b; row++) {
                            if (row == -1)
                                row++;

                            else if (row == b)
                                row--;

                            for (int col = j - 1; col <= j + 1 && col < b; col++) {
                                if (col == -1)
                                    col++;
                                
                                Node comp = grid[row][col];

                                while (comp != null && comp != node) {
                                    double dist = dist(comp, node);

                                    if (dist < min) 
                                        min = dist;

                                    comp = comp.next;
                                }
                            }
                        }

                        node = node.next;
                    }

                }
            }

            System.out.println("The closest pair of points is: " + min);

            // for (int i = 0; i < b; i++) {
            // for (int j = 0; j < b; j++) {
            // Node node = grid[i][j];

            // if (node != null)
            // System.out.println(node.xCord + " " + node.yCord);
            // }
            // }

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