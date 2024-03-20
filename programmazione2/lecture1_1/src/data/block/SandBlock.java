package data.block;

public class SandBlock extends AbstractBlock implements SmeltableBlock{

    public SandBlock() {
        blockname = "Sand";
        contenuto = '°';
        falls_with_gravity = true;
        fall_through = false;

    }


    @Override
    public Block smelt() {
        return new GlassBlock();
    }
}
