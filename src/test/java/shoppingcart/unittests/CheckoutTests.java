package shoppingcart.unittests;

import org.junit.Test;
import shoppingcart.*;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class CheckoutTests {
    private Item itemA = mock(Item.class);
    private PricingRules rules = mock(PricingRules.class);
    private Scanner scanner = mock(Scanner.class);
    private Checkout checkout = new Checkout(rules, scanner);

    @Test
    public void itemIsScanned() {
        checkout.scan(itemA);

        verify(scanner).scanAnItem(itemA);
    }

    @Test
    public void totalOfAllItemsIsAskedFor() {
        checkout.total();

        verify(rules).totalScannedItems(scanner);
    }
}
