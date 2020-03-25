import java.math.BigDecimal;
import java.util.List;

import static java.util.Arrays.stream;

public class ItemTotalCalculator {

  public BigDecimal calulate(List<Item> items) {
    return items.stream()
            .map(Item::getPrice)
            .reduce(BigDecimal.ZERO, BigDecimal::add);
  }

  public BigDecimal calulateNonDiscountedItems(List<Item> items, String... itemNames) {
    return items.stream()
            .filter(item -> stream(itemNames).noneMatch(itemName -> item.getName().equals(itemName)))
            .map(Item::getPrice)
            .reduce(BigDecimal.ZERO, BigDecimal::add);
  }

  public BigDecimal calulateTotalOfDiscountedItemsA(BigDecimal totalDiscountedItems) {
    return totalDiscountedItems.subtract(BigDecimal.valueOf(20L));
  }

  public BigDecimal calulateTotalOfDiscountedItemsB(BigDecimal totalDiscountedItems) {
    return totalDiscountedItems.subtract(BigDecimal.valueOf(15L));
  }
}
