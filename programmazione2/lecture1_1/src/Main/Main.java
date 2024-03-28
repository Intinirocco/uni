package Main;

import Utils.Coordinates;
import visual.MainView;

import java.util.Scanner;



public class Main {
    public final static int INTERACTION = 8;

    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);

        MainView m = new MainView();
        m.display();
        for (int i = 0 ; i < INTERACTION ; i++){
            System.out.println("Enter row and then column to pick that block");
            System.out.println("Enter '9' and the item number to move the item to the furnace");
            System.out.println("Enter '99' and then '9' to smelt");
            System.out.println("Enter '99' and then '0' to toggle the inventory sorting");
            System.out.println("Enter '99' and then any number to take from the furnace into the inventory");
            Scanner myObj = new Scanner(System.in);
            int row = myObj.nextInt();
            int col = myObj.nextInt();
            if (row == 9){
                m.move_into_furnace_from_inventory(col);
            }else if( row == 99 ){
                if (col == 9) {
                    m.smelt();
                }else if (col == 0){
                    m.toggle_inventory_comparator();
                }else {
                    m.move_into_inventory_from_furnace();
                }
            } else{
                Coordinates c = new Coordinates(row,col);
                m.pick_up_block(row, col);
            }
            m.display();
        }

        /*m.display();
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
        }*/

    }
}
