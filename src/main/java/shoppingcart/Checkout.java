package shoppingcart;

public class Checkout {
    private Money totalMoney = new Money(0);

    public Money total(){
        return totalMoney;
    }

    public void scan(Item item) {
        totalMoney = new Money(50);
    }
}
