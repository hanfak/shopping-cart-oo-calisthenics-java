import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class ScannedItemsTest {

  private final Item ITEM_A = new Item("A", BigDecimal.valueOf(50L));
  private final Item ITEM_A_1 = new Item("A", BigDecimal.valueOf(50L));
  private final Item ITEM_A_2 = new Item("A", BigDecimal.valueOf(50L));
  private final Item ITEM_B = new Item("B", BigDecimal.valueOf(30L));
  private final Item ITEM_C = new Item("C", BigDecimal.valueOf(20L));
  private final Item ITEM_D = new Item("D", BigDecimal.valueOf(15L));

  private final ScannedItems underTest = new ScannedItems();

  @Test
  public void returnZeroItemsWhenNoItemsAreAdded() {
    List<Item> actualResult = underTest.allItems();

    assertThat(actualResult).hasSize(0);
    assertThat(actualResult).isEmpty();
  }

  @Test
  public void returnAllItemsWhenItemsAreAdded() {
    underTest.addItem(ITEM_A);
    underTest.addItem(ITEM_B);
    underTest.addItem(ITEM_C);

    List<Item> actualResult = underTest.allItems();

    assertThat(actualResult).hasSize(3);
    assertThat(actualResult).containsExactly(ITEM_A, ITEM_B, ITEM_C);
  }

  @Test
  public void returnItemsOfSpecificName() {
    underTest.addItem(ITEM_A);
    underTest.addItem(ITEM_A_1);
    underTest.addItem(ITEM_A_2);

    List<Item> actualResult = underTest.itemsOfName("A");

    assertThat(actualResult).hasSize(3);
    assertThat(actualResult).containsExactly(ITEM_A, ITEM_A_1, ITEM_A_2);
  }

}