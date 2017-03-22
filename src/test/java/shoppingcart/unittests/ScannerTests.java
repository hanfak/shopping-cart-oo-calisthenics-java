package shoppingcart.unittests;

import org.junit.Test;
import shoppingcart.Item;
import shoppingcart.Scanner;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class ScannerTests {
    @Test
    public void scanAnItem() {
        Scanner scanner = new Scanner();
        Item itemA = new Item("A");

        scanner.scanAnItem(itemA);

        assertThat(scanner.scannedItems().get(0).equals(itemA));
    }

    @Test
    public void findNumberOfItemsAlreadyScanned() {
        Scanner scanner = new Scanner();
        long expectedNumberOfItemsAScanned = 2;
        Item itemA = new Item("A");
        Item itemB = new Item("B");
        Item itemA2 = new Item("A");

        scanner.scanAnItem(itemA);
        scanner.scanAnItem(itemB);
        scanner.scanAnItem(itemA2);

        assertEquals(expectedNumberOfItemsAScanned, scanner.findItemInScannedItems(itemA));
    }
}
