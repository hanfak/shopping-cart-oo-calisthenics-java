package stubs;

import com.hanfak.domain.Item;
import com.hanfak.usecase.ScannedItemsRepository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class ScannedItemsStub implements ScannedItemsRepository {// TODO make this class a stub and put into test package. Use interface in prod

  List<Item> scannedItems = new ArrayList<>();

  @Override
  public void addItem(Item item) {
    scannedItems.add(item);
  }

  @Override
  public List<Item> allItems() {
    return Collections.unmodifiableList(scannedItems);
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
