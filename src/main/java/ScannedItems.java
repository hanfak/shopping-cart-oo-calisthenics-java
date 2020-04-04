import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;
// TODO interface
public class ScannedItems {// TODO make this class a stub and put into test package. Use interface in prod

  List<Item> scannedItems = new ArrayList<>(); // TODO inject arraylist or use interface

  public void addItem(Item item) {
    scannedItems.add(item);
  }

  public List<Item> allItems() {
    return scannedItems; // TODO: immodifaible list
  }

  public List<Item> itemsOfName(String itemName) {
    return scannedItems.stream()
            .filter(item -> item.getName().equals(itemName))
            .collect(toList());
  }

  public int numberOfScannedItem(String itemName) {
    return itemsOfName(itemName).size();
  }
}
