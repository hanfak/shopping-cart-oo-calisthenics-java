import com.sun.tools.javac.jvm.Items;

import java.math.BigDecimal;
import java.util.List;

import static java.util.Arrays.stream;

public class NonDiscountedItemCalculator {
// TODO inject DiscountedItemRepoistory (interface)

  private final DiscountedItemRepository discountedItemRepository;

  public NonDiscountedItemCalculator(DiscountedItemRepository discountedItemRepository) {
    this.discountedItemRepository = discountedItemRepository;
  }

  public BigDecimal calculate(ScannedItems scannedItems) {
    List<Item> allDiscountedItems = discountedItemRepository.findAllDiscountedItems();
    return scannedItems.allItems().stream()
            .filter(item -> allDiscountedItems.stream().noneMatch(item::equals))
            .map(Item::getPrice)
            .reduce(BigDecimal.ZERO, BigDecimal::add);
  }
}

