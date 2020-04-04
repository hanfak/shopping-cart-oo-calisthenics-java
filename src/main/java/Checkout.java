import java.math.BigDecimal;

public class Checkout {

  private final ScannedItemsRepository scannedItems;
  private final ItemTotalCalculator itemTotalCalculator;

  public Checkout(ScannedItemsRepository scannedItems, ItemTotalCalculator itemTotalCalculator) {
    this.scannedItems = scannedItems;
    this.itemTotalCalculator = itemTotalCalculator;
  }

  public void scan(Item item) {
    // TODO optional, add defensive prog if this interface available externally
    scannedItems.addItem(item);
  }

  public BigDecimal total() {
    return itemTotalCalculator.calculateTotal(scannedItems);
  }
}
