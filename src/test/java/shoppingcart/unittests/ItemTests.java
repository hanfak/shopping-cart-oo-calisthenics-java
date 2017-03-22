package shoppingcart.unittests;

import org.junit.Test;
import shoppingcart.Item;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ItemTests {
    @Test
    public void twoItemsAreEqual() {
        Item itemA = new Item("A");
        Item itemB = new Item("A");

        assertTrue(itemA.equals(itemB));
    }

    @Test
    public void twoItemsAreNotEqual() {
        Item itemA = new Item("A");
        Item itemB = new Item("B");

        assertFalse(itemA.equals(itemB));
    }

    @Test
    public void valueOfMoney(){
        Item itemA = new Item("A");

        assertEquals("A", itemA.toString());
    }
}