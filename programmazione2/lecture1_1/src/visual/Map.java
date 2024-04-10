package visual;

import Utils.BlockErrorException;
import data.BlockFactory;
import data.blocks.*;
import java.util.Random;
import Utils.Coordinates;
import data.interfaces.Block;
import data.interfaces.SmeltableBlock;

public class Map {
    public final int RANDOM_BLOCKS_TO_ADD = 2;

    private Block[][] mappa;
    private BlockFactory bF;

    public Map(BlockFactory bF){
        this();
    }
    public Map() {
        this.bF = new BlockFactory();

        mappa = new AbstractBlock[Coordinates.DIMENSION_ROWS][Coordinates.DIMENSION_COLUMNS];
        for (int i = 0; i < Coordinates.DIMENSION_ROWS; i++) {
            for (int k = 0; k < Coordinates.DIMENSION_COLUMNS; k++) {
                Block b = bF.default_block();
                insert_at_coords(b, i,k);
            }
        }
        this.addSea();
        this.randomBlock();
    }

    public void display_on_out() {
        for (int r = 0; r < Coordinates.DIMENSION_ROWS; r++){
            System.out.print(r);
            System.out.print("|");
            for (int c = 0; c < Coordinates.DIMENSION_COLUMNS; c++){
                System.out.print(mappa[r][c].display());
            }
            System.out.print("||");
            System.out.println();
        }

    }

    public void change_cell(int x, int y) {
        if (x >= 0 && x <Coordinates.DIMENSION_ROWS && y >= 0 && y < Coordinates.DIMENSION_COLUMNS) {
            mappa[x][y] = new AirBlock();
        } else {
            System.err.println("Errore nelle coordinate inserite!!!");
        }
    }

    public void insert_at_coords(Block b, int x, int y) {
        if (b != null ) {
            mappa[x][y] = b;
            gravita(x,y);
        } else {
            System.err.println("Errore nelle coordinate o nel blocco inserito!!!");
        }

    }

    public void gravita(int x, int y) {
        int index = x;
        while (index < Coordinates.DIMENSION_ROWS - 1 && mappa[index][y].isFalls_with_gravity()) {
            if (mappa[index + 1][y].isFall_through()) {
                if((mappa[index][y] instanceof SandBlock) && (mappa[index+1][y] instanceof TorchBlock)){
                    mappa[index][y] = new AirBlock();
                }else {
                    swap(index, y);
                    index++;
                }
            } else {
                break;
            }
        }
    }

    public void drop(int x, int y){
        for(int i = x; i > 0; --i){
            gravita(x,y);
        }

    }

    private void swap(int x, int y) {
        Block temp = mappa[x][y];
        mappa[x][y] = mappa[x + 1][y];
        mappa[x + 1][y] = temp;
    }

    private void addRowsOfWater(){
        Coordinates c;
        AbstractBlock a = new WaterBlock();
        for(int i = 0; i < mappa[0].length; ++i){
            insert_at_coords(a,0,i);
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

    public Block getElement(int x, int y){
        return mappa[x][y];
    }

    private boolean is_smeltable(int r, int c) throws BlockErrorException {
        return mappa[r][c] instanceof SmeltableBlock;
    }

    public SmeltableBlock getSmeltableBlock(int r, int c){
        return (SmeltableBlock) mappa[r][c];
    }

    private void randomBlock(){
        Random rand = new Random();
        for (int i = 0 ; i < RANDOM_BLOCKS_TO_ADD; i++){
            Block b = new SandBlock();
            int row = rand.nextInt(Coordinates.DIMENSION_ROWS);
            int col = rand.nextInt(Coordinates.DIMENSION_COLUMNS);
            insert_at_coords(b,row,col);
        }
    }

    private boolean is_pickable(Coordinates c) throws Exception {
        if(!c.is_inbound()){
            int row = c.getRow();
            int col = c.getCol();

            return mappa[row][col].is_pickable();
        }else{
            throw new Exception("Le coordinate inserite non sono valide");
        }
    }

    public Block gimme_pickable(Coordinates c)throws BlockErrorException{
        return mappa[c.getRow()][c.getCol()];
    }

}

