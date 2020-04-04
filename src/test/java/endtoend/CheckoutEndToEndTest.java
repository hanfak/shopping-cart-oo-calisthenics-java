package endtoend;

import com.hanfak.domain.Item;
import com.hanfak.usecase.*;
import org.junit.Ignore;
import org.junit.Test;
import stubs.DiscountedItemsStub;
import stubs.ScannedItemsStub;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

// TODO use BDD langauge
public class CheckoutEndToEndTest {

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

  private final ScannedItemsStub scannedItems = new ScannedItemsStub();
  private final DiscountedItemCalculator discountedItemCalculator = new DiscountedItemCalculator();
  private final DiscountedItemRepository discountedItemRepository = new DiscountedItemsStub();
  private final NonDiscountedItemCalculator nonDiscountedItemCalculator = new NonDiscountedItemCalculator(discountedItemRepository);
  private final ItemTotalCalculator itemTotalCalculator = new ItemTotalCalculator(discountedItemCalculator, nonDiscountedItemCalculator);
  private final Checkout underTest = new Checkout(scannedItems, itemTotalCalculator);
}
