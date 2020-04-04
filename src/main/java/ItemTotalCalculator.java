import java.math.BigDecimal;

public class ItemTotalCalculator {

  private final DiscountedItemCalculator discountedItemCalculator;
  private final NonDiscountedItemCalculator nonDiscountedItemCalculator;

  public ItemTotalCalculator(DiscountedItemCalculator discountedItemCalculator, NonDiscountedItemCalculator nonDiscountedItemCalculator) {
    this.discountedItemCalculator = discountedItemCalculator;
    this.nonDiscountedItemCalculator = nonDiscountedItemCalculator;
  }

  public BigDecimal calculateTotal(ScannedItemsRepository scannedItemsRepository) {
    return calculateTotalOfAllNonDiscountedItems(scannedItemsRepository).add(calculateTotalOfAllDiscountedItems(scannedItemsRepository));
  }

  private BigDecimal calculateTotalOfAllDiscountedItems(ScannedItemsRepository scannedItemsRepository) {
    return discountedItemCalculator.calculate(scannedItemsRepository);
  }

  private BigDecimal calculateTotalOfAllNonDiscountedItems(ScannedItemsRepository scannedItemsRepository) {
    return nonDiscountedItemCalculator.calculate(scannedItemsRepository);
  }
}
