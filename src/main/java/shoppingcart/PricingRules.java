package shoppingcart;

import java.util.HashMap;
import java.util.Map;

public class PricingRules {
    private Map<Item, Money> pricingRules = new HashMap<>();

    public PricingRules() {
        setItemPrices();
    }

    public void addScannedItemToTotal(Item item, Money totalMoney) {
        Money itemPrice = findPrice(item);
        totalMoney.add(itemPrice);
    }

    private void setItemPrices() {
        pricingRules.put(new Item("A"), new Money(50));
        pricingRules.put(new Item("B"), new Money(30));
        pricingRules.put(new Item("C"), new Money(20));
        pricingRules.put(new Item("D"), new Money(15));
    }

    private Money findPrice(Item item) {
        return pricingRules.get(item);
    }
}
