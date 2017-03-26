package shoppingcart;

import java.util.List;

public class Scanner {
    private ScannedItems scannedItems;

    public Scanner(ScannedItems scannedItems) {
        this.scannedItems = scannedItems;
    }

    public void scanAnItem(Item item) {
        scannedItems.storeItem(item);
    }

    public List<Money> retrievePricesOfScannedItems(ItemPrices itemPrices) {
        return scannedItems.findPricesOfScannedItems(itemPrices);
    }

/*     TODO Should .count() be part of this method, or should it be in another class
     ie ScannerCalculator????*/
    public long countScannedItem(Item item) {
        return scannedItems.findItemAlreadyScanned(item).stream().count();
    }
}

