package data.blocks;

public class Furnace{

    private SmeltableBlock input;
    private Block output;

    public Furnace() {
        this.input = new NullBlock();
        this.output = new NullBlock();
    }

    public SmeltableBlock getInput() {
        return input;
    }

    public Block getOutput() {
        return output;
    }

    public void display_on_out(){
        System.out.println("|| "
                +this.getInput().display()
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
