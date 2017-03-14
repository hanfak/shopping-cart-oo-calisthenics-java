package shoppingcart;

public class Money {
    private int amount;

    public Money(int amount) {
        this.amount = amount;
    }

    public void add(Money itemPrice) {
        amount += itemPrice.amount;
    }

    @Override
    public boolean equals(Object object) {
        return ((Money) object).amount == amount;
    }

//    @Override
//    public String toString(){
//        return String.valueOf(amount);
//    }
}
