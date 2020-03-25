import java.math.BigDecimal;
import java.util.List;

public class Checkout {
  private final ScannedItems scannedItems;

  public Checkout(ScannedItems scannedItems) {
    this.scannedItems = scannedItems;
  }

  public void scan(Item item) {
    scannedItems.addItem(item);
  }

  public BigDecimal total() {
    List<Item> itemA = scannedItems.itemsOfName("A");
    BigDecimal totalNonDiscountedItems = scannedItems.allItems().stream()
            .filter(item -> !item.getName().equals("A"))
            .map(Item::getPrice)
            .reduce(BigDecimal.ZERO, BigDecimal::add);
    BigDecimal totalDiscountedItemA = itemA.stream()
            .map(Item::getPrice)
            .reduce(BigDecimal.ZERO, BigDecimal::add);
    if (itemA.size() == 3) {
      return totalNonDiscountedItems.add(totalDiscountedItemA).subtract(BigDecimal.valueOf(20L));
    }
    return totalNonDiscountedItems.add(totalDiscountedItemA);
  }
}
