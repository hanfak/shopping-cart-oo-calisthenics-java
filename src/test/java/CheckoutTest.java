import org.junit.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

public class CheckoutTest {

  private final Checkout underTest = new Checkout();
  private final Item ITEM_A = new Item("A", BigDecimal.valueOf(50L));
  private final Item ITEM_B = new Item("B", BigDecimal.valueOf(30L));
  private final Item ITEM_C = new Item("C", BigDecimal.valueOf(20L));
  private final Item ITEM_D = new Item("D", BigDecimal.valueOf(15L));

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
}
