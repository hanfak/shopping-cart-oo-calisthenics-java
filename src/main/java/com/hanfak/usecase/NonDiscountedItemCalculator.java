package com.hanfak.usecase;

import com.hanfak.domain.Item;

import java.math.BigDecimal;
import java.util.List;

public class NonDiscountedItemCalculator {

  private final DiscountedItemRepository discountedItemRepository;

  public NonDiscountedItemCalculator(DiscountedItemRepository discountedItemRepository) {
    this.discountedItemRepository = discountedItemRepository;
  }

  public BigDecimal calculate(ScannedItemsRepository scannedItems) {
    List<Item> allDiscountedItems = discountedItemRepository.findAllDiscountedItems();
    return scannedItems.allItems().stream()
            .filter(item -> !allDiscountedItems.contains(item))
            .map(Item::getPrice)
            .reduce(BigDecimal.ZERO, BigDecimal::add);
  }
}

