package com.hanfak.infrastructure.itemcalculatorservice;

import com.hanfak.domain.Item;
import com.hanfak.repository.ScannedItemsRepository;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DiscountedItemCalculator {
  // TODO inject DiscountedItemRepoistory (interface)
  // TODO inject rules engined, which injects DiscountedItemRepoistory
  private static final Map<Item, DiscountRule> discounts = new HashMap<>();

  static {
    // TODO calculate discount amount from item price???
    discounts.put(new Item("A", BigDecimal.valueOf(50L)), new DiscountRule(3, 20L));
    discounts.put(new Item("B", BigDecimal.valueOf(30L)), new DiscountRule(2, 15L));
  }

  public BigDecimal calculate(ScannedItemsRepository scannedItems) {
    return discounts.entrySet().stream()
            .map(discount -> calulateTotalOfDiscountedItems(scannedItems,
                    discount.getKey().getName(),
                    discount.getValue().amountOfItemsToApplyDiscount,
                    discount.getValue().discountAmount))
            .reduce(BigDecimal.ZERO, BigDecimal::add);
  }

  private BigDecimal calulateTotalOfDiscountedItems(ScannedItemsRepository scannedItems, String itemName, int itemAmountToApplyDiscountTo, long discountAmount) {
    int totalOfItemA = scannedItems.numberOfScannedItem(itemName);
    int numberOfGroups = totalOfItemA / itemAmountToApplyDiscountTo; // extract to ScannedItemsRepository
    int numberOfLeftOver = totalOfItemA % itemAmountToApplyDiscountTo; // extract to ScannedItemsRepository
    BigDecimal totalOfItemsToBeDiscounted = calculateGroupTotalOfItems(scannedItems, itemName, totalOfItemA - numberOfLeftOver);
    BigDecimal totalIncludingDiscount = totalOfItemsToBeDiscounted.subtract(BigDecimal.valueOf(discountAmount).multiply(BigDecimal.valueOf(numberOfGroups)));
    BigDecimal totalOfItemsToBeNotDiscounted = calculateGroupTotalOfItems(scannedItems, itemName, numberOfLeftOver);
    return totalIncludingDiscount.add(totalOfItemsToBeNotDiscounted);
  }

  private BigDecimal calculateGroupTotalOfItems(ScannedItemsRepository scannedItems, String itemName, int limit) {
    return scannedItems.itemsOfLength(limit, itemName).stream()
            .map(Item::getPrice)
            .reduce(BigDecimal.ZERO, BigDecimal::add);
  }

  private static class DiscountRule {
    private final int amountOfItemsToApplyDiscount;
    private final long discountAmount;

    public DiscountRule(int amountOfItemsToApplyDiscount, long discountAmount) {
      this.amountOfItemsToApplyDiscount = amountOfItemsToApplyDiscount;
      this.discountAmount = discountAmount;
    }
  }
}
