import org.junit.Test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ItemTotalCalculatorTest {

  @Test
  public void findTotalOfOneItem() {
    List<Item> item = Collections.singletonList(ITEM_A);
    assertThat(underTest.calulate(item)).isEqualTo(BigDecimal.valueOf(50L));
  }

  @Test
  public void findTotalOfMultipleItems() {
    List<Item> items = Arrays.asList(ITEM_A, ITEM_B, ITEM_C, ITEM_D);
    assertThat(underTest.calulate(items)).isEqualTo(BigDecimal.valueOf(115L));
  }

  @Test
  public void findTotalOfNonDiscountedItems() {
    List<Item> items = Arrays.asList(ITEM_A, ITEM_B, ITEM_C, ITEM_D);
    assertThat(underTest.calulateNonDiscountedItems(items, "A"))
            .isEqualTo(BigDecimal.valueOf(65L));
  }

  @Test
  public void findTotalOfNonDiscountedItemsRemoveMultipleDiscountedItems() {
    List<Item> items = Arrays.asList(ITEM_A, ITEM_B, ITEM_C, ITEM_D);
    assertThat(underTest.calulateNonDiscountedItems(items, "A", "B"))
            .isEqualTo(BigDecimal.valueOf(35L));
  }

  @Test
  public void findTotalOfDiscountedAndNonDiscountedItems() {
    assertThat(underTest.calulateTotalOfDiscountedItemsA(BigDecimal.valueOf(150L)))
            .isEqualTo(BigDecimal.valueOf(130L));
  }

  private static final Item ITEM_A = new Item("A", BigDecimal.valueOf(50L));
  private static final Item ITEM_A_1 = new Item("A", BigDecimal.valueOf(50L));
  private static final Item ITEM_A_2 = new Item("A", BigDecimal.valueOf(50L));
  private static final Item ITEM_B = new Item("B", BigDecimal.valueOf(30L));
  private static final Item ITEM_C = new Item("C", BigDecimal.valueOf(20L));
  private static final Item ITEM_D = new Item("D", BigDecimal.valueOf(15L));

  private final ItemTotalCalculator underTest = new ItemTotalCalculator();
}