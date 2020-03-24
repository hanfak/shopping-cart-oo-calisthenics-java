import org.junit.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

public class CheckoutTest {

  private final Checkout underTest = new Checkout();
  private final Item ITEM_A = new Item("A");

  @Test
  public void scanItems() {
    underTest.scan(ITEM_A);

    assertThat(underTest.total()).isEqualTo(BigDecimal.valueOf(50L));
  }
}
