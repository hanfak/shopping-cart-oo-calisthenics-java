package shoppingcart;

public class Checkout {
    private PricingRules pricingRules;

    public Checkout(PricingRules pricingRules) {
        this.pricingRules = pricingRules;
    }

    public Money total(){
        return pricingRules.addScannedItemToTotal();
    }

    public void scan(Item item) {
        pricingRules.addScannedItemToBasket(item);
    }
}

/*
* class items
*
*
*
*
*
* */