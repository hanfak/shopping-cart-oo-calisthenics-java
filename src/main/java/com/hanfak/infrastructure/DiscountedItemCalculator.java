package com.hanfak.infrastructure;

import com.hanfak.domain.Item;
import com.hanfak.repository.ScannedItemsRepository;

import java.math.BigDecimal;

public class DiscountedItemCalculator {
  // TODO inject DiscountedItemRepoistory (interface)
  // TODO inject rules engined, which injects DiscountedItemRepoistory

  public BigDecimal calculate(ScannedItemsRepository scannedItems) {
    BigDecimal itemADiscountedTotal = calulateTotalOfDiscountedItemsA(scannedItems);
    BigDecimal itemBDiscountedTotal = calulateTotalOfDiscountedItemsB(scannedItems);
    return itemADiscountedTotal.add(itemBDiscountedTotal);
  }

  private BigDecimal calulateTotalOfDiscountedItemsA(ScannedItemsRepository scannedItems) {
    BigDecimal total = calculateTotalOfItems(scannedItems, "A");
    if (3 == scannedItems.numberOfScannedItem("A")) {
      return total.subtract(BigDecimal.valueOf(20L));
    }
    return total;
  }

  private BigDecimal calulateTotalOfDiscountedItemsB(ScannedItemsRepository scannedItems) {
    BigDecimal total = calculateTotalOfItems(scannedItems, "B");
    if (2 == scannedItems.numberOfScannedItem("B")) {
      return total.subtract(BigDecimal.valueOf(15L));
    }
    return total;
  }

  private BigDecimal calculateTotalOfItems(ScannedItemsRepository scannedItems, String itemName) {
    return scannedItems.itemsOfName(itemName).stream()
            .map(Item::getPrice)
            .reduce(BigDecimal.ZERO, BigDecimal::add);
  }
}
