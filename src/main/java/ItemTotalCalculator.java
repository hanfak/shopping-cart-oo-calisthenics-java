import java.math.BigDecimal;

public class ItemTotalCalculator {

  private final DiscountedItemCalculator discountedItemCalculator;
  private final NonDiscountedItemCalculator nonDiscountedItemCalculator;

  public ItemTotalCalculator(DiscountedItemCalculator discountedItemCalculator, NonDiscountedItemCalculator nonDiscountedItemCalculator) {
    this.discountedItemCalculator = discountedItemCalculator;
    this.nonDiscountedItemCalculator = nonDiscountedItemCalculator;
  }

  public BigDecimal calculateTotal(ScannedItemsRepository scannedItems) {
    return calculateTotalOfAllNonDiscountedItems(scannedItems).add(calculateTotalOfAllDiscountedItems(scannedItems));
  }

  private BigDecimal calculateTotalOfAllDiscountedItems(ScannedItemsRepository scannedItems) {
    return discountedItemCalculator.calculate(scannedItems);
  }

  private BigDecimal calculateTotalOfAllNonDiscountedItems(ScannedItemsRepository scannedItems) {
    return nonDiscountedItemCalculator.calculate(scannedItems);
  }
}
