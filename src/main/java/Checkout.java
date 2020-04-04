import java.math.BigDecimal;

public class Checkout {

  private final ScannedItemsRepository scannedItemsRepository;
  private final ItemTotalCalculator itemTotalCalculator;

  public Checkout(ScannedItemsRepository scannedItemsRepository, ItemTotalCalculator itemTotalCalculator) {
    this.scannedItemsRepository = scannedItemsRepository;
    this.itemTotalCalculator = itemTotalCalculator;
  }

  public void scan(Item item) {
    // TODO optional, add defensive prog if this interface available externally
    scannedItemsRepository.addItem(item);
  }

  public BigDecimal total() {
    return itemTotalCalculator.calculateTotal(scannedItemsRepository);
  }
}
