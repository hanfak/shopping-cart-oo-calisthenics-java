package shoppingcart.unittests;

import org.junit.Test;
import shoppingcart.Item;
import shoppingcart.Money;
import shoppingcart.PricingRules;
import shoppingcart.Scanner;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;


public class PricingRulesTest {
    @Test
    public void scanOneItem() {
        PricingRules pricingRules = new PricingRules(new Scanner());

        pricingRules.addScannedItem(new Item("A"));

        assertThat(pricingRules.addScannedItemToTotal().equals(new Money(50)));
    }

    @Test
    public void scanMultipleItems() {
        PricingRules pricingRules = new PricingRules(new Scanner());

        pricingRules.addScannedItem(new Item("A"));
        pricingRules.addScannedItem(new Item("B"));

        assertThat(pricingRules.addScannedItemToTotal().equals(new Money(80)));
    }

}