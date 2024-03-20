package data.block;

public class AirBlock extends  AbstractBlock{

    public AirBlock() {
        this.contenuto = '.';
        this.falls_with_gravity = false;
        this.fall_through = true;
    }


}
