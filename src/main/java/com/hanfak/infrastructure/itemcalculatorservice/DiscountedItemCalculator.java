package com.hanfak.infrastructure.itemcalculatorservice;

import com.hanfak.domain.Item;
import com.hanfak.repository.ScannedItemsRepository;

import java.math.BigDecimal;

public class DiscountedItemCalculator {
  // TODO inject DiscountedItemRepoistory (interface)
  // TODO inject rules engined, which injects DiscountedItemRepoistory

  public BigDecimal calculate(ScannedItemsRepository scannedItems) {
    BigDecimal itemADiscountedTotal = calulateTotalOfDiscountedItems(scannedItems, "A", 3, 20L);
    BigDecimal itemBDiscountedTotal = calulateTotalOfDiscountedItems(scannedItems, "B", 2, 15L);
    return itemADiscountedTotal.add(itemBDiscountedTotal);
  }

  private BigDecimal calulateTotalOfDiscountedItems(ScannedItemsRepository scannedItems, String a, int i, long l) {
    int totalOfItemA = scannedItems.numberOfScannedItem(a);
    int numberOfGroups = totalOfItemA / i; // extract to ScannedItemsRepository
    int numberOfLeftOver = totalOfItemA % i; // extract to ScannedItemsRepository
    BigDecimal totalOfItemsToBeDiscounted = calculateGroupTotalOfItems(scannedItems, a, totalOfItemA - numberOfLeftOver);
    BigDecimal totalIncludingDiscount = totalOfItemsToBeDiscounted.subtract(BigDecimal.valueOf(l).multiply(BigDecimal.valueOf(numberOfGroups)));
    BigDecimal totalOfItemsToBeNotDiscounted = calculateGroupTotalOfItems(scannedItems, a, numberOfLeftOver);
    return totalIncludingDiscount.add(totalOfItemsToBeNotDiscounted);
  }

  private BigDecimal calculateGroupTotalOfItems(ScannedItemsRepository scannedItems, String itemName, int limit) {
    return scannedItems.itemsOfLength(limit, itemName).stream()
            .map(Item::getPrice)
            .reduce(BigDecimal.ZERO, BigDecimal::add);
  }
}
