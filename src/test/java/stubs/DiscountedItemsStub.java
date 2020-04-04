package stubs;

import com.hanfak.domain.Item;
import com.hanfak.usecase.DiscountedItemRepository;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class DiscountedItemsStub implements DiscountedItemRepository {
  @Override
  public List<Item> findAllDiscountedItems() {
    return Arrays.asList(
            new Item("A", BigDecimal.valueOf(50L)),
            new Item("B", BigDecimal.valueOf(30L))
    );
  }
}
