package data.blocks;

public class RawIronBlock extends AbstractSolidBlock implements SmeltableBlock{


    @Override
    public Block smelt() {
        return new IronSwordBlock();
    }
}
