package shoppingcart.unittests;

import org.junit.Test;
import shoppingcart.*;
import shoppingcart.Scanner;

import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class ScannerTests {
    @Test
    public void retrievesPricesOfScannedItem() {
        ScannedItems scannedItems = mock(ScannedItems.class);
        Scanner scanner = new Scanner(scannedItems);
        ItemPrices itemPrices = mock(ItemPrices.class);

        scanner.retrievePricesOfScannedItems(itemPrices);

        verify(scannedItems).findPricesOfScannedItems(itemPrices);
    }

    @Test
    public void findNumberOfItemsAlreadyScanned() {
        Scanner scanner = new Scanner(new ScannedItems());
        long expectedNumberOfItemsAScanned = 2;
        Item itemA = new Item("A");
        Item itemB = new Item("B");
        Item itemA2 = new Item("A");

        scanner.scanAnItem(itemA);
        scanner.scanAnItem(itemB);
        scanner.scanAnItem(itemA2);

        assertEquals(expectedNumberOfItemsAScanned, scanner.countScannedItem(itemA));
    }

    @Test
    public void findNumberOfItemsAlreadyScannedAAA() {
        ScannedItems scannedItems = mock(ScannedItems.class);
        long expectedNumberOfItemsAScanned = 2L;

        Scanner scanner = new Scanner(scannedItems);
        Item itemA = new Item("A");
        List<Item> itemsFound = Arrays.asList(itemA, itemA);

        when(scannedItems.findItemAlreadyScanned(itemA)).thenReturn(itemsFound);

        assertEquals(expectedNumberOfItemsAScanned, scanner.countScannedItem(itemA));
    }
}
