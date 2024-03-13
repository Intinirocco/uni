package data;

public class Block {

    private char contenuto;
    private boolean falls_with_gravity;
    private boolean fall_through;



    public Block() {
        this.contenuto = '*';
        this.falls_with_gravity = false;
        this.fall_through = true;
    }

    public Block(char contenuto) {
        this.contenuto = contenuto;
        this.falls_with_gravity = true;
        this.fall_through = false;
    }



    public char display(){
        return contenuto;
    }

    public boolean isFalls_with_gravity() {
        return falls_with_gravity;
    }

    public boolean isFall_through() {
        return fall_through;
    }

    public void setContenuto(char contenuto) {
        this.contenuto = contenuto;
    }
}
