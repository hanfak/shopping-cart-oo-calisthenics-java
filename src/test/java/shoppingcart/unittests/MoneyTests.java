package shoppingcart.unittests;

import org.junit.Test;
import shoppingcart.Money;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertFalse;
import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.junit.Assert.assertTrue;

public class MoneyTests {
    @Test
    public void addPriceOfItemToAmount(){
        Money moneyA = new Money(0);

        moneyA.addItemPrice(new Money(25));

        assertEquals(new Money(25), moneyA);
    }

    @Test
    public void discountPriceOfItem() {
        Money money = new Money(50);

        money.discount(new Money(20));

        assertThat(money.equals(new Money(30)));
    }

    @Test
    public void twoMoneyObjectsNotEqual() {
        Money moneyA = new Money(10);
        Money moneyB = new Money(20);

        assertFalse(moneyA.equals(moneyB));
    }

    @Test
    public void twoMoneyObjectsEqual() {
        Money moneyA = new Money(10);
        Money moneyB = new Money(10);

        assertTrue(moneyA.equals(moneyB));
    }

    @Test
    public void valueOfMoney(){
        Money moneyA = new Money(0);

        assertEquals("0", moneyA.toString());
    }
}
