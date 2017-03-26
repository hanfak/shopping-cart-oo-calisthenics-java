package shoppingcart;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ScannedItems {
    private List<Item> scannedItems = new ArrayList<>();

    public void storeItem(Item item) {
        scannedItems.add(item);
    }

    public List<Item> findItemAlreadyScanned(Item item) {
        return scannedItems.stream().filter(item::equals).collect(Collectors.toList());
    }

    public List<Money> findPricesOfScannedItems(ItemPrices itemPrices) {
        return scannedItems.stream().map(itemPrices::findPrice).collect(Collectors.toList());
    }
}
