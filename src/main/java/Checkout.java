import java.math.BigDecimal;
import java.util.List;

public class Checkout {
  ScannedItems scannedItems1 = new ScannedItems();

  public void scan(Item item) {
    scannedItems1.addItem(item);
  }

  public BigDecimal total() {
    List<Item> itemA = scannedItems1.itemsOfName("A");
    BigDecimal totalNonDiscountedItems = scannedItems1.allItems().stream()
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
