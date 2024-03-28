package data.interfaces;

public interface Block extends InventoryBlock{
    char display();

    boolean isFalls_with_gravity();

    boolean isFall_through();

    boolean is_pickable();


}
