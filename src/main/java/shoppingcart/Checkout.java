package shoppingcart;

import java.util.HashMap;
import java.util.Map;

public class Checkout {
    private Money totalMoney = new Money(0);
    private Map<Item, Money> pricingRules;

    public Checkout() {
        pricingRules = new HashMap<>();
        pricingRules.put(new Item("A"), new Money(50));
        pricingRules.put(new Item("B"), new Money(30));
    }

    public Money total(){
        return totalMoney;
    }

    public void scan(Item item) {
        totalMoney = pricingRules.get(item);
    }
}
