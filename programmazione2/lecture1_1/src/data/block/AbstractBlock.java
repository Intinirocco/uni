package data.block;

public abstract class AbstractBlock implements Block {
    protected char contenuto;
    protected boolean falls_with_gravity;
    protected boolean fall_through;

    protected String blockname;

    public char display() {
        return contenuto;
    }


    public boolean isFalls_with_gravity() {
        return falls_with_gravity;
    }

    public boolean isFall_through() {
        return fall_through;
    }

    @Override
    public String toString() {
        return "AbstractBlock{" +
                "contenuto=" + contenuto +
                ", falls_with_gravity=" + falls_with_gravity +
                ", fall_through=" + fall_through +
                ", blockname='" + blockname + '\'' +
                '}';
    }
}
