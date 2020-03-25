import org.junit.Test;

import java.math.BigDecimal;
import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;

public class ItemTotalCalculatorTest {

  @Test
  public void findTotalOfOneItem() {
    assertThat(underTest.calulate(Collections.singletonList(ITEM_A))).isEqualTo(BigDecimal.valueOf(50L));
  }

  private static final Item ITEM_A = new Item("A", BigDecimal.valueOf(50L));
  private static final Item ITEM_B = new Item("B", BigDecimal.valueOf(30L));
  private static final Item ITEM_C = new Item("C", BigDecimal.valueOf(20L));
  private static final Item ITEM_D = new Item("D", BigDecimal.valueOf(15L));

  private final ItemTotalCalculator underTest = new ItemTotalCalculator();
}