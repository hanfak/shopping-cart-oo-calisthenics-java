import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Checkout {
  List<Item> scannedItems = new ArrayList<>();

  public void scan(Item item) {
    scannedItems.add(item);
  }

  public BigDecimal total() {
    return scannedItems.stream()
            .map(Item::getPrice)
            .reduce(BigDecimal.ZERO, BigDecimal::add);
  }
}
