package shoppingcart;

/**
 * Created by hanfak on 29/03/2017.
 */
public class MoneyCalculator {
    public Money increaseMoney(Money amount, Money moneytoAdd) {
        return new Money(Integer.parseInt(amount.toString()) + Integer.parseInt(moneytoAdd.toString()));
    }
}
