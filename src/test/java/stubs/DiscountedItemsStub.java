package stubs;

import com.hanfak.domain.DiscountRule;
import com.hanfak.domain.Item;
import com.hanfak.repository.DiscountedItemRepository;
import lombok.Value;

import java.math.BigDecimal;
import java.util.*;

import static java.util.stream.Collectors.toList;

public class DiscountedItemsStub implements DiscountedItemRepository {

  private static final Map<Item, DiscountType> DISCOUNTS = new HashMap<>();

  static {
    DISCOUNTS.put(new Item("A", BigDecimal.valueOf(50L)), new DiscountType(3, 20L));
    DISCOUNTS.put(new Item("B", BigDecimal.valueOf(30L)), new DiscountType(2, 15L));
  }

  @Override
  public List<Item> findAllDiscountedItems() {
    return new ArrayList<>(DISCOUNTS.keySet());
  }

  @Override
  public List<DiscountRule> findAllDiscounts() {
    return DISCOUNTS.entrySet().stream()
            .map(this::discountRuleFactory)
            .collect(toList());
  }

  private DiscountRule discountRuleFactory(Map.Entry<Item, DiscountType> discount) {
    Item key = discount.getKey();
    DiscountType value = discount.getValue();
    return new DiscountRule(key.getName(),
            value.amountOfItemsToApplyDiscountTo,
            value.discountAmountToBeRemovedFromTotal);
  }

  @Value
  private static class DiscountType {
    int amountOfItemsToApplyDiscountTo;
    long discountAmountToBeRemovedFromTotal;
  }
}
