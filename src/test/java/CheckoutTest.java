import org.junit.Ignore;
import org.junit.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

public class CheckoutTest {

  @Test
  public void scanOneItem() {
    underTest.scan(ITEM_A);

    assertThat(underTest.total()).isEqualTo(BigDecimal.valueOf(50L));
  }

  @Test
  public void scanMultipleItems() {
    underTest.scan(ITEM_A);
    underTest.scan(ITEM_B);
    underTest.scan(ITEM_C);
    underTest.scan(ITEM_D);

    assertThat(underTest.total()).isEqualTo(BigDecimal.valueOf(115L));
  }

  @Test
  public void scanMultipleDiscountedItemsOfTypeA() {
    underTest.scan(ITEM_A);
    underTest.scan(ITEM_A);
    underTest.scan(ITEM_A);

    assertThat(underTest.total()).isEqualTo(BigDecimal.valueOf(130L));
  }

  @Test
  public void scanMultipleDiscountedItemsOfTypeB() {
    underTest.scan(ITEM_B);
    underTest.scan(ITEM_B);

    assertThat(underTest.total()).isEqualTo(BigDecimal.valueOf(45L));
  }

  @Test
  @Ignore
  public void scanMultipleDiscountedItemsAndOtherItemThatDoesnotGetDiscounted() {
    underTest.scan(ITEM_A);
    underTest.scan(ITEM_A);
    underTest.scan(ITEM_A);
    underTest.scan(ITEM_A);

    assertThat(underTest.total()).isEqualTo(BigDecimal.valueOf(180L));
  }

  private static final Item ITEM_A = new Item("A", BigDecimal.valueOf(50L));
  private static final Item ITEM_B = new Item("B", BigDecimal.valueOf(30L));
  private static final Item ITEM_C = new Item("C", BigDecimal.valueOf(20L));
  private static final Item ITEM_D = new Item("D", BigDecimal.valueOf(15L));

  // TODO use mocks or keep and use as end to end test??
  private final ScannedItems scannedItems = new ScannedItems();
  private final ItemTotalCalculator itemTotalCalculator = new ItemTotalCalculator();
  private final Checkout underTest = new Checkout(scannedItems, itemTotalCalculator);
}
