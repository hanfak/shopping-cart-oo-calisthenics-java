package shoppingcart;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PricingRules {
    private Map<Item, Money> pricingRules = new HashMap<>();
    private List<Item> itemsScanned = new ArrayList<>();

    public PricingRules() {
        setItemPrices();
    }
    //TODO extract itemsScanned to new class
    // TODO test
    // Move to scanner class
    public Money addScannedItemToTotal(Money totalMoney) {
        itemsScanned.stream().map(this::findPrice).forEach(totalMoney::add);
        return totalMoney;
    }
    //TODO test
    // Move to scanner class
    public void addScannedItemToBasket(Item item) {
        itemsScanned.add(item);
    }

    private void setItemPrices() {
        // Class ProductList???
        pricingRules.put(new Item("A"), new Money(50));
        pricingRules.put(new Item("B"), new Money(30));
        pricingRules.put(new Item("C"), new Money(20));
        pricingRules.put(new Item("D"), new Money(15));
    }

    private Money findPrice(Item item) {
        return pricingRules.get(item);
    }
}
