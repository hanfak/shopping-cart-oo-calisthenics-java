import org.junit.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

// tODO use mocks or stub
public class NonDiscountedItemCalculatorTest {

  @Test
  public void findTotalWithOneItemAndNoDiscountedItemsAvailable() {
    ScannedItems scannedItems = new ScannedItems();
    scannedItems.addItem(ITEM_C);

    BigDecimal actualTotal = underTest.calculate(scannedItems);

    assertThat(actualTotal).isEqualTo(BigDecimal.valueOf(20L));
  }

  @Test
  public void findTotalWithMutlipleItemsAndNoDiscountedItemsAvailable() {
    ScannedItems scannedItems = new ScannedItems();
    scannedItems.addItem(ITEM_C);
    scannedItems.addItem(ITEM_D);

    BigDecimal actualTotal = underTest.calculate(scannedItems);

    assertThat(actualTotal).isEqualTo(BigDecimal.valueOf(35L));
  }

  @Test
  public void findTotalWithOneDiscountedItemsAvailable() {
    ScannedItems scannedItems = new ScannedItems();
    scannedItems.addItem(ITEM_A);

    BigDecimal actualTotal = underTest.calculate(scannedItems, "A");

    assertThat(actualTotal).isEqualTo(BigDecimal.ZERO);
  }

  @Test
  public void findTotalWithMultipleDiscountedItemsAvailable() {
    ScannedItems scannedItems = new ScannedItems();
    scannedItems.addItem(ITEM_A);
    scannedItems.addItem(ITEM_B);
    scannedItems.addItem(ITEM_C);
    scannedItems.addItem(ITEM_D);

    BigDecimal actualTotal = underTest.calculate(scannedItems, "A", "B");

    assertThat(actualTotal).isEqualTo(BigDecimal.valueOf(35L));
  }

  private static final Item ITEM_A = new Item("A", BigDecimal.valueOf(50L));
  private static final Item ITEM_B = new Item("B", BigDecimal.valueOf(30L));
  private static final Item ITEM_C = new Item("C", BigDecimal.valueOf(20L));
  private static final Item ITEM_D = new Item("D", BigDecimal.valueOf(15L));

  private final NonDiscountedItemCalculator underTest = new NonDiscountedItemCalculator();
}