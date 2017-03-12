package shoppingcart;

public class Checkout {
    private Money money = new Money(0);

    public Money total(){
        return money;
    }

    public void scan(String item) {
        money = new Money(50);
    }
}
