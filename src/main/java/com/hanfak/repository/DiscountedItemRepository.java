package com.hanfak.repository;

import com.hanfak.domain.Item;

import java.util.List;

public interface DiscountedItemRepository {
  List<Item> findAllDiscountedItems();
}
