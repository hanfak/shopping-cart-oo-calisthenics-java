import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Checkout {
  List<Item> scannedItems = new ArrayList<>();

  public void scan(Item item) {
    scannedItems.add(item);
  }

  public BigDecimal total() {
    List<Item> itemA = scannedItems.stream()
            .filter(item -> item.getName().equals("A"))
            .collect(Collectors.toList());
    BigDecimal totalNonDiscountedItems = scannedItems.stream()
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
