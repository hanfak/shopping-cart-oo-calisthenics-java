package com.hanfak.usecase;

import com.hanfak.domain.Item;

import java.util.List;

public interface DiscountedItemRepository {
  List<Item> findAllDiscountedItems();
}
