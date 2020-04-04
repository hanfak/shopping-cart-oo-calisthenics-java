import java.math.BigDecimal;
import java.util.List;

import static java.util.Arrays.stream;

public class NonDiscountedItemCalculator {
// TODO inject DiscountedItemRepoistory (interface)

  public BigDecimal calculate(ScannedItems scannedItems, String... itemNames) {
    return scannedItems.allItems().stream()
            .filter(item -> stream(itemNames).noneMatch(itemName -> item.getName().equals(itemName)))
            .map(Item::getPrice)
            .reduce(BigDecimal.ZERO, BigDecimal::add);

  }
}

