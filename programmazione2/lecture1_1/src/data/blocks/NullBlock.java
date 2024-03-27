package data.blocks;

public class NullBlock extends AbstractSolidBlock implements  SmeltableBlock{

    public NullBlock() {
        super();
    }

    @Override
    public Block smelt() {
        return new NullBlock();
    }
}
