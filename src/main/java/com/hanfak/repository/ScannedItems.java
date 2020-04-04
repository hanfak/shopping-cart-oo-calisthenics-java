package com.hanfak.repository;

import com.hanfak.domain.Item;
import com.hanfak.usecase.ScannedItemsRepository;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class ScannedItems implements ScannedItemsRepository {// TODO make this class a stub and put into test package. Use interface in prod

  List<Item> scannedItems = new ArrayList<>(); // TODO inject arraylist or use interface

  @Override
  public void addItem(Item item) {
    scannedItems.add(item);
  }

  @Override
  public List<Item> allItems() {
    return scannedItems; // TODO: immodifaible list
  }

  @Override
  public List<Item> itemsOfName(String itemName) {
    return scannedItems.stream()
            .filter(item -> item.getName().equals(itemName))
            .collect(toList());
  }

  @Override
  public int numberOfScannedItem(String itemName) {
    return itemsOfName(itemName).size();
  }
}
