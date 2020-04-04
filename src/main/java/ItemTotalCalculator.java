import java.math.BigDecimal;

public class ItemTotalCalculator {

  private final DiscountedItemCalculator discountedItemCalculator;
  private final NonDiscountedItemCalculator nonDiscountedItemCalculator;

  public ItemTotalCalculator(DiscountedItemCalculator discountedItemCalculator, NonDiscountedItemCalculator nonDiscountedItemCalculator) {
    this.discountedItemCalculator = discountedItemCalculator;
    this.nonDiscountedItemCalculator = nonDiscountedItemCalculator;
  }

  public BigDecimal calculateTotal(ScannedItems scannedItems) {
    return calculateTotalOfAllNonDiscountedItems(scannedItems).add(calculateTotalOfAllDiscountedItems(scannedItems));
  }

  private BigDecimal calculateTotalOfAllDiscountedItems(ScannedItems scannedItems) {
    return discountedItemCalculator.calculate(scannedItems);
  }

  private BigDecimal calculateTotalOfAllNonDiscountedItems(ScannedItems scannedItems) {
    return nonDiscountedItemCalculator.calculate(scannedItems, "A", "B"); // TODO should not pass this list here
  }
}
