package shoppingcart.unittests;

import org.junit.Test;
import shoppingcart.Item;
import shoppingcart.ItemPrices;
import shoppingcart.Money;
import shoppingcart.ScannedItems;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ScannedItemsTest {
    private Item itemA = new Item("A");
    private Item itemB = new Item("B");

    @Test
    public void storeItems() {
        ScannedItems scannedItems = new ScannedItems();

        scannedItems.storeItem(itemA);
        scannedItems.storeItem(itemB);

        assertEquals(itemA, scannedItems.findItemAlreadyScanned(itemA).get(0));
        assertEquals(itemB, scannedItems.findItemAlreadyScanned(itemB).get(0));
    }

    @Test
    public void replaceItemsWithItsPrice() {
        ScannedItems scannedItems = new ScannedItems();
        ItemPrices itemPrices = mock(ItemPrices.class);

        Money price50 = new Money(50);
        Money price30 = new Money(30);
        when(itemPrices.findPrice(itemA)).thenReturn(price50);
        when(itemPrices.findPrice(itemB)).thenReturn(price30);

        scannedItems.storeItem(itemA);
        scannedItems.storeItem(itemB);

        assertEquals(price50, scannedItems.findPricesOfScannedItems(itemPrices).get(0));
        assertEquals(price30, scannedItems.findPricesOfScannedItems(itemPrices).get(1));
    }
}