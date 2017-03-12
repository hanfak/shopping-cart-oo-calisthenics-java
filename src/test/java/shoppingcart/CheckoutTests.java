package shoppingcart;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class CheckoutTests {
    @Test
    public void totalIs0WhenNoItemIsScanned() {
        Checkout checkout = new Checkout();

        assertEquals(new Money(0), checkout.total());
    }
}
