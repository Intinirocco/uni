package visual;

import data.block.*;

import java.util.Random;

public class Map {

    public final int x = 16;
    public final int y = 14;
    public final int RANDOM_BLOCKS_TO_ADD = 12;

    private Block[][] mappa;

    public Map() {
        mappa = new AbstractBlock[x][y];
        Random ran = new Random();
        char blocco = '0';
        for (int r = 0; r < x; ++r) {
            for (int c = 0; c < y; ++c) {
                insert_at_coords(r,c, new AirBlock());
            }
        }
        addRiver();
        randomBlock();
    }

    public void display_on_out() {
        System.out.println("---------------------//---------------------");
        for (int r = 0; r < x; ++r) {
            for (int c = 0; c < y; ++c) {
                System.out.print(mappa[r][c].display() + " ");
            }
            System.out.println("\n");
        }
        System.out.println("---------------------//---------------------");
    }

    public void change_cell(int x, int y) {
        if (x >= 0 && x < this.x && y >= 0 && y < this.y) {
            mappa[x][y] = new AirBlock();
        } else {
            System.err.println("Errore nelle coordinate inserite!!!");
        }
    }

    public void insert_at_coords(int x, int y, Block b) {
        if (b != null && x >= 0 && x < this.x && y >= 0 && y < this.y) {
            mappa[x][y] = b;
            gravita(x, y);
        } else {
            System.err.println("Errore nelle coordinate o nel blocco inserito!!!");
        }
    }

    private void gravita(int x, int y) {
        int index = x;
        while (index < mappa.length - 1 && mappa[index][y].isFalls_with_gravity()) {
            if (mappa[index + 1][y].isFall_through()) {
                swap(index, y);
                index++;
            } else {
                break;
            }
        }
    }

    private void swap(int x, int y) {
        Block temp = mappa[x][y];
        mappa[x][y] = mappa[x + 1][y];
        mappa[x + 1][y] = temp;
    }

    private void addRowsOfWater(){
        Block a = new WaterBlock();
        for(int i = 0; i < mappa[0].length; ++i){
            insert_at_coords(0,i, a);
        }
    }

    public void addSea(){
        for(int i = 0; i < 3; ++i){
            addRowsOfWater();
        }
    }

    public void addRiver(){
        addRowsOfWater();
    }

    public SmeltableBlock getElement(int x, int y){

        return (SmeltableBlock) mappa[x][y];
    }

    public boolean isSmeltable(int r, int c){
        return mappa[r][c] instanceof SmeltableBlock;
    }

    private void randomBlock(){
        Random rand = new Random();
        for (int i = 0 ; i < RANDOM_BLOCKS_TO_ADD; i++){
            Block b = new SandBlock();
            int row = rand.nextInt(this.x);
            int col = rand.nextInt(this.y);
            insert_at_coords(row, col, b);
        }
    }


}
