package data.blocks;

import data.interfaces.Block;
import data.interfaces.SmeltableBlock;

public class RawIronBlock extends AbstractSolidBlock implements SmeltableBlock {


    @Override
    public Block smelt() {
        return new IronSwordBlock();
    }
}
