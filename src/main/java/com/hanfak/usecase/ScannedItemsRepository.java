package com.hanfak.usecase;

import com.hanfak.domain.Item;

import java.util.List;

public interface ScannedItemsRepository {
  void addItem(Item item);

  List<Item> allItems();

  List<Item> itemsOfName(String itemName);

  int numberOfScannedItem(String itemName);
}
