package data.blocks;

import data.interfaces.Block;
import data.interfaces.SmeltableBlock;

public class Furnace{

    private SmeltableBlock input;
    private Block output;

    public Furnace() {
        this.input = new NullBlock();
        this.output = new NullBlock();
    }

    public SmeltableBlock get_input() {
        return input;
    }

    public Block getOutput() {
        return output;
    }

    public void display_on_out(){
        System.out.println("|| "
                +this.get_input().display()
                +" --> "
                +this.getOutput().display()
                +" ||");
    }

    public void smelt(){
        output = input.smelt();
        input = new NullBlock();
    }

    public void setInput(SmeltableBlock input) {
        this.input = input;
        output = input.smelt();
    }




}
