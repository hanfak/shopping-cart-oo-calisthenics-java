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

    @Test
    public void totalIs50WhenNoItemAIsScanned() {
        givenACheckoutSystemIsActive();

        whenItemAisScanned();

        thenTotalIs50();
    }

    @Test
    public void totalIs30WhenNoItemBIsScanned() {
        givenACheckoutSystemIsActive();

        whenItemBIsScanned();

        thenTotalIs30();
    }
    
    private void givenACheckoutSystemIsActive() {
        checkout = new Checkout();
    }

    private void thenTotalWillBe0() {
        assertEquals(new Money(0), checkout.total());
    }

    private void thenTotalIs50() {
        assertEquals(new Money(50), checkout.total());
    }

    private void whenItemAisScanned() {
        checkout.scan(new Item("A"));
    }

    private void thenTotalIs30() {
        assertEquals(new Money(30), checkout.total());
    }

    private void whenItemBIsScanned() {
        checkout.scan(new Item("B"));
    }


    //test multiple different no discount
    //test multiple same item with discount
    //test multiple other item different discount
    //test mulitple items with and without discounts
}
