package shoppingcart.acceptancetests;

import com.googlecode.yatspec.junit.SpecRunner;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;

import static junit.framework.TestCase.assertEquals;
import static org.assertj.core.api.Assertions.assertThat;

import shoppingcart.*;

@RunWith(SpecRunner.class)
public class ShoppingCartTests {
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
    public void totalIs35WhenItemCandDAreScanned() {
        givenACheckoutSystemIsActive();

        whenItemisScanned(C);
        whenItemisScanned(D);

        thenTotalIs35();
    }

    @Test
    public void totalIs130WhenItemAIsScanned3TimesAndDiscountIsApplied() {
        givenACheckoutSystemIsActive();

        whenItemisScanned(A);
        whenItemisScanned(A);
        whenItemisScanned(A);

        thenTotalIs(130);
    }

    @Test
    public void totalIs180WhenDiscountAppliedOnce() {
        givenACheckoutSystemIsActive();

        whenItemisScanned(A);
        whenItemisScanned(A);
        whenItemisScanned(A);
        whenItemisScanned(A);

        thenTotalIs(180);
    }

    @Test
    public void totalIs260WhenDiscountAppliedTwice() {
        givenACheckoutSystemIsActive();

        whenItemisScanned(A);
        whenItemisScanned(A);
        whenItemisScanned(A);
        whenItemisScanned(A);
        whenItemisScanned(A);
        whenItemisScanned(A);

        thenTotalIs(260);
    }

    @Test
    public void totalIs75WhenDiscountAppliedTwice() {
        givenACheckoutSystemIsActive();

        whenItemisScanned(B);
        whenItemisScanned(B);
        whenItemisScanned(B);
        whenItemisScanned(B);
        whenItemisScanned(B);

        thenTotalIs(120);
    }

    @Test
    public void totalIs175WhenMultipeDiscountAppliedForDifferentItems() {
        givenACheckoutSystemIsActive();

        whenItemisScanned(A);
        whenItemisScanned(B);
        whenItemisScanned(A);
        whenItemisScanned(B);
        whenItemisScanned(A);

        thenTotalIs(175);
    }

    @Test
    public void totalIs210WhenGeneralMixOfItemsScanned() {
        givenACheckoutSystemIsActive();

        whenItemisScanned(A);
        whenItemisScanned(C);
        whenItemisScanned(B);
        whenItemisScanned(A);
        whenItemisScanned(D);
        whenItemisScanned(B);
        whenItemisScanned(A);

        thenTotalIs(210);
    }

    private void givenACheckoutSystemIsActive() {
        checkout = new Checkout(new PricingRules(new ItemPrices(), new TotalCalculator()));
    }

    private void whenNoItemIsScanned() {
    }

    private void whenItemisScanned(String item) {
        checkout.scan(new Item(item));
    }

    private void thenTotalIs(int price) {
        assertEquals(new Money(price), checkout.total());
    }

    private void thenTotalIs35() {
        assertThat(checkout.total()).isEqualTo(new Money(35));
    }




    //test 4 A or 3 B
    // test 6A or 4B
    //test mulitple items with and without discounts
    // Error checking
        // Item not in stock

    //Refactor test, instead of multiple scans, use for loop
    //or equivalent
    /*private void whenMultipleItemsAreScanned(String items) {
        Stream<Character> characterStream = items.chars().mapToObj(i -> (char) i);
        Stream<String> stringStream = characterStream.map(String::valueOf);
        Stream<Item> itemStream = stringStream.map(Item::new);//.forEach(System.out::println);
        itemStream.forEach(i -> checkout.scan(i));

    }*/

   /* private void multiple(String items) {
        for(String String.valueOf(item) : items.toCharArray()) {
            whenItemisScanned(item);
        }
    }*/
}
