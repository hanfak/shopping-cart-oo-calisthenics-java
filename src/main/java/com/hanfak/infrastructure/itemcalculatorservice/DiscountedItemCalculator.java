package com.hanfak.infrastructure.itemcalculatorservice;

import com.hanfak.domain.DiscountRule;
import com.hanfak.domain.Item;
import com.hanfak.repository.DiscountedItemRepository;
import com.hanfak.repository.ScannedItemsRepository;

import java.math.BigDecimal;

public class DiscountedItemCalculator {
  // TODO inject rules engined, which injects DiscountedItemRepoistory
  private final DiscountedItemRepository discountedItemRepository;

  public DiscountedItemCalculator(DiscountedItemRepository discountedItemRepository) {
    this.discountedItemRepository = discountedItemRepository;
  }

  public BigDecimal calculate(ScannedItemsRepository scannedItems) {
    return discountedItemRepository.findAllDiscounts().stream()
            .map(discountRule -> calulateTotalOfDiscountedItems(scannedItems, discountRule))
            .reduce(BigDecimal.ZERO, BigDecimal::add);
  }

  private BigDecimal calulateTotalOfDiscountedItems(ScannedItemsRepository scannedItems, DiscountRule discountRule) {
    int totalOfItem = scannedItems.numberOfScannedItem(discountRule.getItemName());
    int numberOfGroups = totalOfItem / discountRule.getAmountOfItemsToApplyDiscount(); // TODO extract to ScannedItemsRepository
    int numberOfLeftOver = totalOfItem % discountRule.getAmountOfItemsToApplyDiscount(); // TODO extract to ScannedItemsRepository
    BigDecimal totalOfItemsToBeDiscounted = calculateGroupTotalOfItems(scannedItems, discountRule.getItemName(), totalOfItem - numberOfLeftOver);
    BigDecimal totalIncludingDiscount = totalOfItemsToBeDiscounted.subtract(BigDecimal.valueOf(discountRule.getDiscountAmount()).multiply(BigDecimal.valueOf(numberOfGroups)));
    BigDecimal totalOfItemsToBeNotDiscounted = calculateGroupTotalOfItems(scannedItems, discountRule.getItemName(), numberOfLeftOver);
    return totalIncludingDiscount.add(totalOfItemsToBeNotDiscounted);
  }

  private BigDecimal calculateGroupTotalOfItems(ScannedItemsRepository scannedItems, String itemName, int limit) {
    return scannedItems.itemsOfLength(limit, itemName).stream()
            .map(Item::getPrice)
            .reduce(BigDecimal.ZERO, BigDecimal::add);
  }
}
