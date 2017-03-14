package shoppingcart;

public class Checkout {
    private Money totalMoney = new Money(0);
    private PricingRules pricingRules = new PricingRules();

    public Money total(){
        return totalMoney;
    }

    public void scan(Item item) {
        pricingRules.addScannedItemToTotal(item, totalMoney);
    }
}
