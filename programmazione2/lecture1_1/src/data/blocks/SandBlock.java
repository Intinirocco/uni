package data.blocks;

import data.interfaces.Block;
import data.interfaces.SmeltableBlock;

public class SandBlock extends AbstractBlock implements SmeltableBlock {

    public SandBlock() {
        blockname = "Sand";
        contenuto = '°';
        falls_with_gravity = true;
        fall_through = false;
        pickable = true;

    }


    @Override
    public Block smelt() {
        return new GlassBlock();
    }
}
