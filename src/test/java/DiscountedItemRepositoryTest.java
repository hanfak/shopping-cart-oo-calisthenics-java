import org.junit.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;


public class DiscountedItemRepositoryTest {

  @Test
  public void returnAllItemsThatAreDiscounted() {
    DiscountedItemRepository underTest = new DiscountedItemRepository();
    assertThat(underTest.findAllDiscountedItems()).containsExactly(ITEM_A, ITEM_B);
  }

  private static final Item ITEM_A = new Item("A", BigDecimal.valueOf(50L));
  private static final Item ITEM_B = new Item("B", BigDecimal.valueOf(30L));
}