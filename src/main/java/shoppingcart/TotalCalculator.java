package shoppingcart;

public class TotalCalculator {
    //TODO should be instance method???
    public Money calculateTotal(Scanner scanner, ItemPrices itemPrices) {
        Money totalMoney = new Money(0);
        scanner.retrievePricesOfScannedItems(itemPrices)
                .forEach(totalMoney::addItemPrice);
        return totalMoney;
    }
}
