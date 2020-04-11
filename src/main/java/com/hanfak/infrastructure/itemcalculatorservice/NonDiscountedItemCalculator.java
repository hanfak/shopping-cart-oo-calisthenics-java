package com.hanfak.infrastructure.itemcalculatorservice;

import com.hanfak.domain.Item;
import com.hanfak.repository.DiscountedItemRepository;
import com.hanfak.repository.ScannedItemsRepository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

public class NonDiscountedItemCalculator {

  private final DiscountedItemRepository discountedItemRepository;

  public NonDiscountedItemCalculator(DiscountedItemRepository discountedItemRepository) {
    this.discountedItemRepository = discountedItemRepository;
  }

  public BigDecimal calculate(ScannedItemsRepository scannedItems) {
    return scannedItems.allItems().stream()
            .filter(this::itemIsNotADiscountedItem)
            .map(Item::getPrice)
            .reduce(BigDecimal.ZERO, BigDecimal::add);
  }

  private boolean itemIsNotADiscountedItem(Item item) {
    List<Item> allDiscountedItems = discountedItemRepository.findAllDiscountedItems();
    return !allDiscountedItems.contains(item);
  }
}

