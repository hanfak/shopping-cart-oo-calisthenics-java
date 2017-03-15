package shoppingcart;

public class Checkout {
    private Money totalMoney = new Money(0);
    //TODO inject
    private PricingRules pricingRules = new PricingRules();

    public Money total(){
        //return items.total(pricingrules);
        return pricingRules.addScannedItemToTotal(totalMoney);
    }


    public void scan(Item item) {
        //items.scan(item)
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