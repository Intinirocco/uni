package Utils;

import data.interfaces.Block;

import java.util.Comparator;

public class BlockComparator implements Comparator<Block> {

    public BlockComparator() {
    }

    @Override
    public int compare(Block o1, Block o2) {
        int b1 = o1.display();
        int b2 = o2.display();

        return Integer.compare(b1,b2);
    }
}
