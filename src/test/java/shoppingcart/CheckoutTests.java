package shoppingcart;

import junit.framework.TestCase;
import org.junit.Test;

public class CheckoutTests {
    @Test
    public void totalIs0WhenNoItemIsScanned() {
        Checkout checkout = new Checkout();

        TestCase.assertEquals(new Money(0), checkout.total());
    }
}
