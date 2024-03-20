package Main;

import data.block.Furnace;
import data.block.GlassBlock;
import data.block.SandBlock;
import visual.MainView;
import visual.Map;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        MainView m = new MainView();

        m.display();

        m.move_into_furnace(13,0);
        m.display();



    }
}
