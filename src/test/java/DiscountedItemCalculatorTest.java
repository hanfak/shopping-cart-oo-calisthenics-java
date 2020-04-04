import org.junit.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;
//TODO use mocks or stub
public class DiscountedItemCalculatorTest {

  @Test
  public void findTotalOfDiscountAppliedOnlyOneAItemsScanned() {
    ScannedItems scannedItems = new ScannedItems();
    scannedItems.addItem(ITEM_A);

    BigDecimal actualTotal = underTest.calculate(scannedItems);

    assertThat(actualTotal).isEqualTo(BigDecimal.valueOf(50L));
  }

  @Test
  public void findTotalOfDiscountAppliedWithThreeAItemsScanned() {
    ScannedItems scannedItems = new ScannedItems();
    scannedItems.addItem(ITEM_A);
    scannedItems.addItem(ITEM_A);
    scannedItems.addItem(ITEM_A);

    BigDecimal actualTotal = underTest.calculate(scannedItems);

    assertThat(actualTotal).isEqualTo(BigDecimal.valueOf(130L));
  }

  @Test
  public void findTotalOfDiscountAppliedOnlyOneBItemsScanned() {
    ScannedItems scannedItems = new ScannedItems();
    scannedItems.addItem(ITEM_B);

    BigDecimal actualTotal = underTest.calculate(scannedItems);

    assertThat(actualTotal).isEqualTo(BigDecimal.valueOf(30L));
  }

  @Test
  public void findTotalOfDiscountAppliedWithTwoBItemsScanned() {
    ScannedItems scannedItems = new ScannedItems();
    scannedItems.addItem(ITEM_B);
    scannedItems.addItem(ITEM_B);

    BigDecimal actualTotal = underTest.calculate(scannedItems);

    assertThat(actualTotal).isEqualTo(BigDecimal.valueOf(45L));
  }

  @Test
  public void findTotalOfCombinationOfDiscountedAAndBItems() {
    ScannedItems scannedItems = new ScannedItems();
    scannedItems.addItem(ITEM_A);
    scannedItems.addItem(ITEM_A);
    scannedItems.addItem(ITEM_A);
    scannedItems.addItem(ITEM_B);
    scannedItems.addItem(ITEM_B);

    BigDecimal actualTotal = underTest.calculate(scannedItems);

    assertThat(actualTotal).isEqualTo(BigDecimal.valueOf(175L));
  }

  @Test
  public void findTotalOfCombinationOfDiscountedAAndNoDiscountAppliedToBItems() {
    ScannedItems scannedItems = new ScannedItems();
    scannedItems.addItem(ITEM_A);
    scannedItems.addItem(ITEM_A);
    scannedItems.addItem(ITEM_A);
    scannedItems.addItem(ITEM_B);

    BigDecimal actualTotal = underTest.calculate(scannedItems);

    assertThat(actualTotal).isEqualTo(BigDecimal.valueOf(160L));
  }

  @Test
  public void findTotalOfCombinationOfDiscountedBAndNoDiscountAppliedToAItems() {
    ScannedItems scannedItems = new ScannedItems();
    scannedItems.addItem(ITEM_A);
    scannedItems.addItem(ITEM_A);
    scannedItems.addItem(ITEM_B);
    scannedItems.addItem(ITEM_B);

    BigDecimal actualTotal = underTest.calculate(scannedItems);

    assertThat(actualTotal).isEqualTo(BigDecimal.valueOf(145L));
  }

  @Test
  public void findTotalOfCombinationOfDiscountedItemsWhereNoDiscountApplied() {
    ScannedItems scannedItems = new ScannedItems();
    scannedItems.addItem(ITEM_A);
    scannedItems.addItem(ITEM_A);
    scannedItems.addItem(ITEM_B);

    BigDecimal actualTotal = underTest.calculate(scannedItems);

    assertThat(actualTotal).isEqualTo(BigDecimal.valueOf(130L));
  }

  private static final Item ITEM_A = new Item("A", BigDecimal.valueOf(50L));
  private static final Item ITEM_B = new Item("B", BigDecimal.valueOf(30L));

  private final DiscountedItemCalculator underTest = new DiscountedItemCalculator();
}