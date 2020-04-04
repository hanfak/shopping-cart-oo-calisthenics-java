import java.math.BigDecimal;
import java.util.List;

public class DiscountedItemCalculator {
  // TODO inject DiscountedItemRepoistory (interface)
  // TODO inject rules engined, which injects DiscountedItemRepoistory

  public BigDecimal calculate(ScannedItemsRepository scannedItems) {
    BigDecimal itemADiscountedTotal = calulateTotalOfDiscountedItemsA(calculateTotalOfItems(scannedItems.itemsOfName("A")), scannedItems);
    BigDecimal itemBDiscountedTotal = calulateTotalOfDiscountedItemsB(calculateTotalOfItems(scannedItems.itemsOfName("B")), scannedItems);
    return itemADiscountedTotal.add(itemBDiscountedTotal);
  }

  // TODO apply a rules engine
  private BigDecimal calulateTotalOfDiscountedItemsA(BigDecimal totalDiscountedItems, ScannedItemsRepository scannedItems) {
    if (scannedItems.numberOfScannedItem("A") == 3) {
      return totalDiscountedItems.subtract(BigDecimal.valueOf(20L));
    }
    return totalDiscountedItems;
  }

  private BigDecimal calulateTotalOfDiscountedItemsB(BigDecimal totalDiscountedItems, ScannedItemsRepository scannedItems) {
    if (scannedItems.numberOfScannedItem("B") == 2) {
      return totalDiscountedItems.subtract(BigDecimal.valueOf(15L));
    }
    return totalDiscountedItems;
  }

  private BigDecimal calculateTotalOfItems(List<Item> items) {
    return items.stream()
            .map(Item::getPrice)
            .reduce(BigDecimal.ZERO, BigDecimal::add);
  }
}
