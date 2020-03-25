import java.math.BigDecimal;
import java.util.List;

public class Checkout {

  private final ScannedItems scannedItems;
  private final ItemTotalCalculator itemTotalCalculator;

  public Checkout(ScannedItems scannedItems, ItemTotalCalculator itemTotalCalculator) {
    this.scannedItems = scannedItems;
    this.itemTotalCalculator = itemTotalCalculator;
  }

  public void scan(Item item) {
    scannedItems.addItem(item);
  }

  public BigDecimal total() {
    BigDecimal totalDiscountedItemA = itemTotalCalculator.calulate(scannedItems.itemsOfName("A"));
    BigDecimal totalDiscountedItemB = itemTotalCalculator.calulate(scannedItems.itemsOfName("B"));

    if (scannedItems.numberOfScannedItem("A") == 3) {
      return itemTotalCalculator.calulateTotalOfDiscountedItemsA(totalDiscountedItemA);
    }

    if (scannedItems.numberOfScannedItem("B") == 2) {
      return itemTotalCalculator.calulateTotalOfDiscountedItemsB(totalDiscountedItemB);
    }

    return itemTotalCalculator.calulateNonDiscountedItems(scannedItems.allItems(), "A", "B")
            .add(totalDiscountedItemA)
            .add(totalDiscountedItemB);
  }
}
