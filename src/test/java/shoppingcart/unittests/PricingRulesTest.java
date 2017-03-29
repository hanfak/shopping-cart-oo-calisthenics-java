package shoppingcart.unittests;

import org.junit.Test;
import shoppingcart.*;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


public class PricingRulesTest {
    @Test
    public void totalIsCalculated() {
        ItemPrices itemPrices = mock(ItemPrices.class);
        Scanner scanner = mock(Scanner.class);
        TotalCalculator totalCalculator = mock(TotalCalculator.class);

        PricingRules pricingRules = new PricingRules(itemPrices, totalCalculator);

        pricingRules.totalScannedItems(scanner);

        verify(totalCalculator).calculateTotal(scanner, itemPrices);
    }

    @Test
    public void discountAppliedTo3AItems() {
        ItemPrices itemPrices = mock(ItemPrices.class);
        Scanner scanner = mock(Scanner.class);
        TotalCalculator totalCalculator = mock(TotalCalculator.class);

        PricingRules pricingRules = new PricingRules(itemPrices, totalCalculator);
        when(totalCalculator.calculateTotal(scanner, itemPrices)).thenReturn(new Money(150));
        when(scanner.numberOfDiscounts(new Item("A"), 3)).thenReturn(1L);
//        List<Money> priceList = Arrays.asList(new Money(50), new Money(50), new Money(50));
//        when(scanner.retrievePricesOfScannedItems(itemPrices)).thenReturn(priceList);
        when(scanner.countScannedItem(new Item("A"))).thenReturn(3L);

        assertThat(pricingRules.totalScannedItems(scanner)).isEqualTo(new Money(130));
    }

    @Test
    public void discountAppliedTo2BItems() {
        ItemPrices itemPrices = mock(ItemPrices.class);
        Scanner scanner = mock(Scanner.class);
        TotalCalculator totalCalculator = mock(TotalCalculator.class);

        PricingRules pricingRules = new PricingRules(itemPrices, totalCalculator);
        when(totalCalculator.calculateTotal(scanner, itemPrices)).thenReturn(new Money(60));
        when(scanner.numberOfDiscounts(new Item("B"), 2)).thenReturn(1L);
        when(scanner.countScannedItem(new Item("B"))).thenReturn(2L);

        assertThat(pricingRules.totalScannedItems(scanner)).isEqualTo(new Money(45));
    }
}
