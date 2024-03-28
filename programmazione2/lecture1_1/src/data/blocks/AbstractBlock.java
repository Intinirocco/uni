package data.blocks;

import data.interfaces.Block;

public abstract class AbstractBlock implements Block {
    protected char contenuto;
    protected boolean falls_with_gravity;
    protected boolean fall_through;

    protected boolean pickable;

    protected String blockname;

    public char display() {
        return contenuto;
    }


    public AbstractBlock() {
        this.pickable = false;
    }

    @Override
    public boolean is_pickable() {
        return pickable;
    }

    @Override
    public void display_in_inventory() {
        System.out.println("[" + contenuto + "]");
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
