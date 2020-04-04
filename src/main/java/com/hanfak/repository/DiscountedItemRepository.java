package com.hanfak.repository;

import com.hanfak.domain.Item;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class DiscountedItemRepository {

  // TODO replace with stub(contains map) for test stub and use map
  public List<Item> findAllDiscountedItems() {
    return Arrays.asList(
            new Item("A", BigDecimal.valueOf(50L)),
            new Item("B", BigDecimal.valueOf(30L))
    );
  }
}
