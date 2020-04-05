package com.hanfak.infrastructure.itemcalculatorservice;

import com.hanfak.repository.ScannedItemsRepository;
import com.hanfak.usecase.TotalCalculator;

import java.math.BigDecimal;

public class ItemTotalCalculator implements TotalCalculator {

  private final DiscountedItemCalculator discountedItemCalculator;
  private final NonDiscountedItemCalculator nonDiscountedItemCalculator;

  public ItemTotalCalculator(DiscountedItemCalculator discountedItemCalculator, NonDiscountedItemCalculator nonDiscountedItemCalculator) {
    this.discountedItemCalculator = discountedItemCalculator;
    this.nonDiscountedItemCalculator = nonDiscountedItemCalculator;
  }

  @Override
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
