package data.block;

public abstract class AbstractSolidBlock extends AbstractBlock{
    public AbstractSolidBlock() {
        falls_with_gravity = false;
        fall_through = false;
    }
}
