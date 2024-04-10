package visual;

import Utils.Coordinates;
import data.BlockFactory;
import data.Inventory;
import data.blocks.AirBlock;
import data.blocks.NullBlock;
import data.interfaces.Block;
import data.blocks.Furnace;
import data.interfaces.SmeltableBlock;

public class MainView {
    private final Furnace furnace;
    private final Map map;

    private BlockFactory blockF;

    private Inventory inventario;

    public MainView() {
        furnace = new Furnace();
        map = new Map();
        inventario = new Inventory();
    }


    public void move_into_furnace(int x, int y) {
        Coordinates c = new Coordinates(x,y);
        if(c.is_inbound()) {
            Block block = map.getElement(x, y);
            if (block instanceof SmeltableBlock) {
                furnace.setInput((SmeltableBlock) block);
                map.insert_at_coords(block, x, y);
                map.drop(x,y);
            }
        }
    }



    public void smelt(){
        furnace.smelt();
        inventario.add_block(furnace.getOutput());
    }

    public void display(){
        furnace.display_on_out();
        System.out.println("\n//////////////////////////////////////////\n");
        map.display_on_out();
        System.out.println("\n//////////////////////////////////////////\n");
        inventario.printInventory();
    }


    public void move_into_furnace_from_inventory(int index) throws Exception {
        furnace.setInput(inventario.get_smeltable_item(index));
        inventario.removeFromInventory(index);
    }

    public void move_into_inventory_from_furnace(){
        inventario.add_block(furnace.get_input());
        furnace.setInput(new NullBlock());
    }

    public void pick_up_block(int x, int y) throws Exception {
        Coordinates c = new Coordinates(x,y);
        if(c.is_inbound()){
            if(map.getElement(x,y).is_pickable()){
                inventario.add_block(map.getElement(x,y));
                map.insert_at_coords(new AirBlock(),x,y);
                int z = x;
                map.drop(x,y);
            }else{
                System.err.println("L'elemento a quelle coordinate non si può prendere");
            }
        }else{
            System.err.println("Coordinate non valide");
        }
    }

    public void toggle_inventory_comparator(){}


}
