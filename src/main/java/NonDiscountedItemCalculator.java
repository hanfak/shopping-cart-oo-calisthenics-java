import java.math.BigDecimal;
import java.util.List;

public class NonDiscountedItemCalculator {

  private final DiscountedItemRepository discountedItemRepository;

  public NonDiscountedItemCalculator(DiscountedItemRepository discountedItemRepository) {
    this.discountedItemRepository = discountedItemRepository;
  }

  public BigDecimal calculate(ScannedItemsRepository scannedItemsRepository) {
    List<Item> allDiscountedItems = discountedItemRepository.findAllDiscountedItems();
    return scannedItemsRepository.allItems().stream()
            .filter(item -> !allDiscountedItems.contains(item))
            .map(Item::getPrice)
            .reduce(BigDecimal.ZERO, BigDecimal::add);
  }
}

