package data.blocks;

import data.interfaces.Block;
import data.interfaces.SmeltableBlock;

public class NullBlock extends AbstractSolidBlock implements SmeltableBlock {

    public NullBlock() {
        super();
        pickable = false;
    }

    @Override
    public Block smelt() {
        return new NullBlock();
    }
}
