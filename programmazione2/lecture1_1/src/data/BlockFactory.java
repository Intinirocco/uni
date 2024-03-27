package data;
import data.blocks.*;

import java.util.Random;

public class BlockFactory {
    private static final int RAND_UPPERBOUND = 3;
    public BlockFactory(){}

    public Block random_block(){
        Random rand = new Random();
        int r = rand.nextInt(RAND_UPPERBOUND);
        switch (r){
            case 0:
                return this.rawIronBlock();
            case 1:
                return this.sand_block();
            case 2:
                return this.waterBlock();
            default:
                return null;
        }

    }

    public AirBlock default_block(){
        return new AirBlock();
    }
    public SandBlock sand_block(){
        return new SandBlock();
    }
    public WaterBlock waterBlock(){
        return new WaterBlock();
    }
    public NullBlock nullBlock(){
        return new NullBlock();
    }
    public RawIronBlock rawIronBlock(){
        return new RawIronBlock();
    }
}
