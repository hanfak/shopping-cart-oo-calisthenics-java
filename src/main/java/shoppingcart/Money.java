package shoppingcart;

public class Money {
    private int amount;

    public Money(int amount) {
        this.amount = amount;
    }

    @Override
    public boolean equals(Object object) {
        return ((Money) object).amount == amount;
    }
}
