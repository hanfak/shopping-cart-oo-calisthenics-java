package shoppingcart;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class CheckoutTests {
    private Checkout checkout;

    @Test
    public void totalIs0WhenNoItemIsScanned() {
        givenACheckoutSystemIsActive();
        
        thenTotalWillBe0();
    }

    private void givenACheckoutSystemIsActive() {
        checkout = new Checkout();
    }

    private void thenTotalWillBe0() {
        assertEquals(new Money(0), checkout.total());
    }

    @Test
    public void totalIs50WhenNoItemAIsScanned() {
        Checkout checkout = new Checkout();
        checkout.scan(new Item("A"));

        assertEquals(new Money(50), checkout.total());
    }

    @Test
    public void totalIs30WhenNoItemBIsScanned() {
        Checkout checkout = new Checkout();
        checkout.scan(new Item("B"));

        assertEquals(new Money(30), checkout.total());
    }
}
