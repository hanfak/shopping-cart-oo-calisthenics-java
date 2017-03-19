package shoppingcart.unittests;

import junit.framework.TestCase;
import org.junit.Ignore;
import org.junit.Test;
import shoppingcart.Checkout;
import shoppingcart.Item;
import shoppingcart.Money;
import shoppingcart.PricingRules;

import static junit.framework.TestCase.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class CheckoutTests {
    public static final String A = "A";
    public static final String B = "B";
    public static final String C = "C";
    public static final String D = "D";
    private Item itemA = mock(Item.class);
    private PricingRules rules = mock(PricingRules.class);
    private Money total = mock(Money.class);
    private Checkout checkout = new Checkout(rules);


    @Test
    public void itemIsScanned() {
        checkout.scan(itemA);

        verify(rules).addScannedItemToBasket(itemA);
    }

    @Test
    public void totalOfAllItemsIsAskedFor() {
        checkout.total();

        verify(rules).addScannedItemToTotal();
    }
}
