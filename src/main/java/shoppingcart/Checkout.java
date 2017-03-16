package shoppingcart;

public class Checkout {
    private Money totalMoney;
    private PricingRules pricingRules;

    public Checkout(Money totalMoney, PricingRules pricingRules) {
        this.totalMoney = totalMoney;
        this.pricingRules = pricingRules;
    }

    public Money total(){
        return pricingRules.addScannedItemToTotal(totalMoney);
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