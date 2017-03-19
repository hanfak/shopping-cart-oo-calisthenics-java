package shoppingcart.unittests;

import org.junit.Test;
import shoppingcart.Item;
import shoppingcart.Money;
import shoppingcart.PricingRules;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;


public class PricingRulesTest {
    @Test
    public void scanOneItem() {
        PricingRules pricingRules = new PricingRules();

        pricingRules.addScannedItemToBasket(new Item("A"));

        assertThat(pricingRules.addScannedItemToTotal().equals(new Money(50)));
    }

    @Test
    public void scanMultipleItems() {
        PricingRules pricingRules = new PricingRules();

        pricingRules.addScannedItemToBasket(new Item("A"));
        pricingRules.addScannedItemToBasket(new Item("B"));

        assertThat(pricingRules.addScannedItemToTotal().equals(new Money(80)));
    }

}