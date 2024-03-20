package Main;

import data.block.SandBlock;
import visual.Map;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Map m = new Map();
        m.display_on_out();

        m.insert_at_coords(0,0, new SandBlock());

        m.display_on_out();

    }
}
