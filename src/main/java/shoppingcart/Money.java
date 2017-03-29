package shoppingcart;

public class Money {
    private int amount;
//    private MoneyCalculator moneyCalculator;

    public Money(int amount) {
        this.amount = amount;
    }

    public void addItemPrice(Money itemPrice) {
        amount += itemPrice.amount;
    }

    // TODO - create and extend ValueType to cover overriden methods
    public void discount(Money discountPrice) {
        amount -= discountPrice.amount;
    }

// TODO - Should new Money object be created when adding or discounting
    // Money calculator static
//    public Money add(Money itemPrice) {
//        int newAmount = amount + itemPrice.amount;
//        return new Money(newAmount);
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
