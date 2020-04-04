import org.junit.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class CheckoutTest {

  @Test
  public void canAddAScannedItem() {
    underTest.scan(ITEM_A);

    verify(scannedItems).addItem(ITEM_A);
  }

  @Test
  public void canFindTotalOfAllScannedItems() {
    when(itemsTotalCalculator.calculateTotal(scannedItems)).thenReturn(BigDecimal.valueOf(50L));
    BigDecimal actualTotal = underTest.total();

    assertThat(actualTotal).isEqualTo(BigDecimal.valueOf(50L));
    verify(itemsTotalCalculator).calculateTotal(scannedItems);
  }

  private static final Item ITEM_A = new Item("A", BigDecimal.valueOf(50L));

  private final ScannedItems scannedItems = mock(ScannedItems.class);
  private final ItemTotalCalculator itemsTotalCalculator = mock(ItemTotalCalculator.class);
  private final Checkout underTest = new Checkout(scannedItems, itemsTotalCalculator);
}