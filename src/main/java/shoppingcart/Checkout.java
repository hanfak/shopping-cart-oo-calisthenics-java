package shoppingcart;

public class Checkout {
    private Money totalMoney = new Money(0);

    public Money total(){
        return totalMoney;
    }

    public void scan(Item item) {
        if (item.equals(new Item("A")))
            totalMoney = new Money(50);
        totalMoney = new Money(30);
    }
}
