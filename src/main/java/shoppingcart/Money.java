package shoppingcart;

public class Money {
    private int amount;

    public Money(int amount) {
        this.amount = amount;
    }

    public void addItemPrice(Money itemPrice) {
        amount += itemPrice.amount;
    }

// TODO - Should new Money object be created when adding or discounting
//    public Money add(Money itemPrice) {
//        int newAmount = amount + itemPrice.amount;
//        return new Money(newAmount);
//    }

    public void discount(Money discountPrice) {
         amount -= discountPrice.amount;
    }

    @Override
    public boolean equals(Object object) {
        return ((Money) object).amount == amount;
    }

    @Override
    public String toString(){
        return String.valueOf(amount);
    }
}
