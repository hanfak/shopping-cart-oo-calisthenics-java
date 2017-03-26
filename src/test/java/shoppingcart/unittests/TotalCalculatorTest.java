package shoppingcart.unittests;

import org.junit.Test;
import shoppingcart.ItemPrices;
import shoppingcart.Money;
import shoppingcart.Scanner;
import shoppingcart.TotalCalculator;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TotalCalculatorTest {
    private Scanner scanner = mock(Scanner.class);
    private ItemPrices itemPrices = mock(ItemPrices.class);
    private TotalCalculator totalCalculator = new TotalCalculator();
    private Money price_a = new Money(10);
    private Money price_b = new Money(20);
    private Money price_c = new Money(30);

    @Test
    public void totalOfOneItem() {
        List<Money> prices = Arrays.asList(price_a);
        when(scanner.retrievePricesOfScannedItems(itemPrices)).thenReturn(prices);
        Money expected_total = new Money(10);

        Money actual_total = totalCalculator.calculateTotal(scanner, itemPrices);

        assertEquals(expected_total, actual_total);
    }

    @Test
    public void totalOfMultipleItems() {
        List<Money> prices = Arrays.asList(price_a, price_b, price_c);
        when(scanner.retrievePricesOfScannedItems(itemPrices)).thenReturn(prices);
        Money expected_total = new Money(60);

        Money actual_total = totalCalculator.calculateTotal(scanner, itemPrices);

        assertEquals(expected_total, actual_total);
    }
}