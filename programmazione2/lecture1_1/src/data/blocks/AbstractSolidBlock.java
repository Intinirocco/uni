package data.blocks;

public abstract class AbstractSolidBlock extends AbstractBlock{
    public AbstractSolidBlock() {
        super();
        falls_with_gravity = false;
        fall_through = false;
        pickable = true;
    }


}
