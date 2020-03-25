import java.math.BigDecimal;
import java.util.List;

public class Checkout {
  private final ScannedItems scannedItems;
  ItemTotalCalculator itemTotalCalculator = new ItemTotalCalculator();

  public Checkout(ScannedItems scannedItems) {
    this.scannedItems = scannedItems;
  }

  public void scan(Item item) {
    scannedItems.addItem(item);
  }
  // tODO Create Money/Price class instead of BigDec, wiht less implementation
  public BigDecimal total() {
    List<Item> itemA = scannedItems.itemsOfName("A");
    BigDecimal totalNonDiscountedItems = itemTotalCalculator.calulateNonDiscountedItems(scannedItems.allItems(), "A");
    BigDecimal totalDiscountedItemA = itemTotalCalculator.calulate(itemA);
    if (itemA.size() == 3) {
      return totalNonDiscountedItems.add(totalDiscountedItemA).subtract(BigDecimal.valueOf(20L));
    }
    return totalNonDiscountedItems.add(totalDiscountedItemA);
  }
}
