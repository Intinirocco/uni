package visual;

import data.block.AirBlock;
import data.block.Furnace;
import data.block.SmeltableBlock;

public class MainView {
    private Furnace f;
    private Map field;


    public MainView() {
        f = new Furnace();
        field = new Map();
    }

    public void move_into_furnace(int x, int y){
        if(field.isSmeltable(x,y)) {
            f.setInput(field.getElement(x, y));
            field.insert_at_coords(x, y, new AirBlock());
        }
    }

    public void display(){
        field.display_on_out();
        System.out.println("\n///////////////////////////\n");
        f.display_on_out();
    }
}
