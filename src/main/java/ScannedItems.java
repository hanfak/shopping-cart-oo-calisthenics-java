import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class ScannedItems {
  List<Item> scannedItems = new ArrayList<>(); // TODO inject arraylist or use interface

  void addItem(Item item) {
    scannedItems.add(item);
  }

  List<Item> allItems() {
    return scannedItems; // TODO: immodifaible list
  }

  List<Item> itemsOfName(String itemName) {
    return scannedItems.stream()
            .filter(item -> item.getName().equals(itemName))
            .collect(toList());
  }

  public Long numberOfScannedItem(String itemName) {
    return scannedItems.stream()
            .filter(item -> item.getName().equals(itemName))
            .count();
  }
}
