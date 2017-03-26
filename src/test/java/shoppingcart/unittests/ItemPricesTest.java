package shoppingcart.unittests;

import org.junit.Test;
import shoppingcart.Item;
import shoppingcart.ItemPrices;
import shoppingcart.Money;

import static org.junit.Assert.*;

public class ItemPricesTest {
    private final static Item ITEM_A = new Item("A");
    private final static Money PRICE_10  = new Money(10);
    private final static Item ITEM_B = new Item("B");
    private final static Money PRICE_20  = new Money(20);
    private final static Item ITEM_C = new Item("C");
    private final static Money PRICE_30  = new Money(30);
    @Test
    public void defineAnItemWithItsPrice() {
        ItemPrices itemPrices = new ItemPrices();

        itemPrices.addPriceToItem(ITEM_A, PRICE_10);

        assertEquals(PRICE_10, itemPrices.findPrice(ITEM_A));
    }

    @Test
    public void defineSeveralItemsWithItsPrice() {
        ItemPrices itemPrices = new ItemPrices();

        itemPrices.addPriceToItem(ITEM_A, PRICE_10);
        itemPrices.addPriceToItem(ITEM_B, PRICE_20);
        itemPrices.addPriceToItem(ITEM_C, PRICE_30);

        assertEquals(PRICE_10, itemPrices.findPrice(ITEM_A));
        assertEquals(PRICE_20, itemPrices.findPrice(ITEM_B));
        assertEquals(PRICE_30, itemPrices.findPrice(ITEM_C));
    }

}