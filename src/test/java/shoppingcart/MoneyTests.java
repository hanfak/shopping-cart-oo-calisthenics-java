package shoppingcart;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertTrue;

public class MoneyTests {
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
    public void addPriceOfItemToAmount(){
        Money moneyA = new Money(0);

        moneyA.add(new Money(25));

        assertEquals(new Money(25), moneyA);
    }
}
