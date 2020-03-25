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
  // tODO Create Money/Price class instead of BigDec, wiht less implementation
  public BigDecimal total() {
    List<Item> itemA = scannedItems.itemsOfName("A");
    BigDecimal totalDiscountedItemA = itemTotalCalculator.calulate(itemA);
    if (scannedItems.numberOfScannedItem("A") == 3) {
      return itemTotalCalculator.calulateTotalOfDiscountedItemsA(totalDiscountedItemA);
    }
    return itemTotalCalculator.calulateNonDiscountedItems(scannedItems.allItems(), "A")
            .add(totalDiscountedItemA);
  }
}
