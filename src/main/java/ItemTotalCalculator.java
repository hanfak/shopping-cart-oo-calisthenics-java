import java.math.BigDecimal;
import java.util.List;

public class ItemTotalCalculator {

  public BigDecimal calulate(List<Item> items) {
    return items.stream()
            .map(Item::getPrice)
            .reduce(BigDecimal.ZERO, BigDecimal::add);
  }

  public BigDecimal calulateNonDiscountedItems(List<Item> items, String itemName) {
    return items.stream()
            .filter(item -> !item.getName().equals(itemName))
            .map(Item::getPrice)
            .reduce(BigDecimal.ZERO, BigDecimal::add);
  }
}
