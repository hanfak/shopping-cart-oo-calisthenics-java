package shoppingcart;

import java.util.HashMap;
import java.util.Map;

public class ItemPrices {
    private Map<Item, Money> itemPrice = new HashMap<>();

    public void addPriceToItem(Item item, Money price) {
        itemPrice.put(item, price);
    }

    public Money findPrice(Item item) {
        return itemPrice.get(item);
    }
}
