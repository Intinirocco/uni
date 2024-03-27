package visual;

import Utils.Coordinates;
import data.BlockFactory;
import data.blocks.Block;
import data.blocks.Furnace;
import data.blocks.SmeltableBlock;

public class MainView {
    private final Furnace furnace;
    private final Map map;

    private BlockFactory blockF;

    public MainView() {
        furnace = new Furnace();
        map = new Map();
    }

    public void move_into_furnace(int x, int y) {
        Block block = map.getElement(x, y);
        if (block instanceof SmeltableBlock) {
            furnace.setInput((SmeltableBlock) block);
            map.insert_at_coords(block, x,y);
        }
    }



    public void smelt(){
        furnace.smelt();
    }

    public void display() {
        furnace.display_on_out();
        System.out.println("\n//////////////////////////////////////////\n");
        map.display_on_out();


    }
}
