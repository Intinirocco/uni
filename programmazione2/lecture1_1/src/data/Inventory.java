package data;

import Utils.AlphabeticalBlockComparator;
import Utils.BlockComparator;
import Utils.BlockErrorException;
import data.blocks.SandBlock;
import data.interfaces.Block;
import data.interfaces.SmeltableBlock;

import javax.swing.text.html.HTMLDocument;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;

public class Inventory {

    private ArrayList<Block> blocchi;

    private Comparator<Block> comp;
    public Inventory() {
        this.blocchi = new ArrayList<Block>();
        comp = new AlphabeticalBlockComparator();
    }

    public void printInventory(){
        if(!blocchi.isEmpty()) {
            for (Block block : blocchi) {
                block.display_in_inventory();
            }

        }else{
            System.out.println("L'inventario è vuoto");
        }
    }

    public void add_block(Block b){
        blocchi.add(b);
        sorting();
    }

    private boolean is_smeltable(int index) throws BlockErrorException {
        return blocchi.get(index) instanceof SmeltableBlock;
    }

    public SmeltableBlock get_smeltable_item(int index) throws Exception {
        if(is_smeltable(index)){
            return (SmeltableBlock) blocchi.get(index);
        }else{
            throw new Exception("L'oggetto all'indice index non è uno SmeltableBlock");
        }
    }

    public void removeFromInventory(int index){
        blocchi.remove(index);
    }


    public void chandeComp(){
        if(comp instanceof AlphabeticalBlockComparator){
            comp = new BlockComparator();
        }else{
            comp = new AlphabeticalBlockComparator();
        }
    }

    private void sorting(){
        blocchi.sort(comp);
    }


}
