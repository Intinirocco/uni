package Utils;

import data.interfaces.Block;

import java.util.Comparator;
import java.util.function.Function;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;
import java.util.function.ToLongFunction;

public class AlphabeticalBlockComparator implements Comparator<Block> {

    public AlphabeticalBlockComparator() {

    }


    @Override
    public int compare(Block o1, Block o2) {
        return o1.toString().compareToIgnoreCase(o2.toString());
    }
}
