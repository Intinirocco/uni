package data.blocks;

import data.blocks.AbstractBlock;

public class WaterBlock extends AbstractBlock {

    public WaterBlock() {
        blockname = "Water";
        contenuto = '~';
        falls_with_gravity = true;
        fall_through = true;
    }

}
