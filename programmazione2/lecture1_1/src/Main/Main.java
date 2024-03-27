package Main;

import visual.MainView;

import java.util.Scanner;



public class Main {
    public final static int INTERACTION = 8;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        MainView m = new MainView();

        m.display();
        for(int i = 0; i < INTERACTION; ++i){
            System.out.print("Enter row and then column, or enter '9' and then '9' for smelting: ");
            int row = in.nextInt();
            int col = in.nextInt();
            if (row == 9 && col == 9){
                m.smelt();
            }else{
                m.move_into_furnace(row, col);
            }
            m.display();
        }

    }
}
