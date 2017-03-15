package shoppingcart;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class CheckoutTests {
    public static final String A = "A";
    public static final String B = "B";
    public static final String C = "C";
    public static final String D = "D";
    private Checkout checkout;

    @Test
    public void totalIs0WhenNoItemIsScanned() {
        givenACheckoutSystemIsActive();

        whenNoItemIsScanned();

        thenTotalIs(0);
    }

    @Test
    public void totalIs50WhenNoItemAIsScanned() {
        givenACheckoutSystemIsActive();

        whenItemisScanned(A);

        thenTotalIs(50);
    }

    @Test
    public void totalIs30WhenNoItemBIsScanned() {
        givenACheckoutSystemIsActive();

        whenItemisScanned(B);

        thenTotalIs(30);
    }

    @Test
    public void totalIs35WhenItemCandDAreScanned() {
        givenACheckoutSystemIsActive();

        whenItemisScanned(C);
        whenItemisScanned(D);

        thenTotalIs(35);
    }

    @Test
    public void totalIs130WhenItemAIsScanned3TimesAndDiscountIsApplied() {
        givenACheckoutSystemIsActive();

        whenItemisScanned(A);
        whenItemisScanned(A);
        whenItemisScanned(A);

        thenTotalIs(130);
    }

    private void thenTotalIs(int price) {
        assertEquals(new Money(price), checkout.total());
    }

    private void givenACheckoutSystemIsActive() {
        checkout = new Checkout();
    }

    private void whenNoItemIsScanned() {
    }

    private void whenItemisScanned(String item) {
        checkout.scan(new Item(item));
    }

//    private void thenTotalIs35() {
//        assertEquals(new Money(35), checkout.total());
//    }
//
//    private void thenTotalWillBe0() {
//        assertEquals(new Money(0), checkout.total());
//    }
//
//    private void thenTotalIs50() {
//        assertEquals(new Money(50), checkout.total());
//    }
//
//    private void thenTotalIs30() {
//        assertEquals(new Money(30), checkout.total());
//    }

    //test multiple same item with discount
    //test multiple other item different discount
    //test mulitple items with and without discounts
}
