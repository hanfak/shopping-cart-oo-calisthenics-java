package shoppingcart;

import java.util.ArrayList;
import java.util.function.Predicate;

public class Scanner {
    private ArrayList<Item> scannedItems = new ArrayList<>();

    public void scanAnItem(Item item) {
        scannedItems.add(item);
    }

    //TODO - Getter, how to refactor out
    public ArrayList<Item> scannedItems() {
        return scannedItems;
    }

    public long findItemInScannedItems(Item item) {
        return scannedItems.stream().filter(isItemTheSame(item)).count();
    }

    private Predicate<Item> isItemTheSame(Item item) {
        return p -> p.equals(item);
    }
}

