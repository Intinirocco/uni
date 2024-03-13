package Main;

import data.Block;
import data.Map;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Map m = new Map();
        m.display_on_out();
        int row = 0;
        int col = 0;

        for (int i = 0; i < 2; ++i) {
            System.out.println("Inserisci la riga: ");
            row = in.nextInt();
            System.out.println("Inserisci la Colonna: ");
            col = in.nextInt();
            System.out.println("Changing: " + row + " - " + col);
            m.change_cell(row, col);
            m.display_on_out();
        }

        Block b = new Block('F');

        System.out.println("Inserisci la riga dove vuoi far cadere l'oggetto: ");
        row = in.nextInt();
        System.out.println("Inserisci la colonna da dove vuoi far cadere l'oggetto: ");
        col = in.nextInt();

        m.insert_at_coords(row, col, b);
        m.display_on_out();
    }
}
