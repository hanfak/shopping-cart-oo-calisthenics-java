package shoppingcart;

public class Money {
    private int amount;

    public Money(int amount) {
        this.amount = amount;
    }

    // create new money object with new add amount, keep immutable
    // new class Adder???
    public void add(Money itemPrice) {
        amount += itemPrice.amount;
    }
//    public Money add(Money itemPrice) {
//        return new Money(amount + itemPrice.amount);
//    }

    @Override
    public boolean equals(Object object) {
        return ((Money) object).amount == amount;
    }

    @Override
    public String toString(){
        return String.valueOf(amount);
    }
}
