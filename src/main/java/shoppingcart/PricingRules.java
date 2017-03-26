package shoppingcart;

public class PricingRules {
    private static final int NUMBER_OF_ITEM_A_FOR_DISCOUNT = 3;
    private static final Money DISCOUNT_FOR_A = new Money(20);
    private static final int NUMBER_OF_ITEM_B_FOR_DISCOUNT = 2;
    private static final Money DISCOUNT_FOR_B = new Money(15);
    public static final Item ITEM_B = new Item("B");
    public static final Item ITEM_A = new Item("A");

    private ItemPrices itemPrices;
    private TotalCalculator totalCalculator;

    public PricingRules(ItemPrices itemPrices, TotalCalculator totalCalculator) {
        this.itemPrices = itemPrices;
        this.totalCalculator = totalCalculator;
        setItemPrices();
    }

    public Money totalScannedItems(Scanner scanner) {
        return discountTotal(totalCalculator.calculateTotal(scanner, itemPrices), scanner);
    }

    private void setItemPrices() {
        //TODO Builder pattern
        itemPrices.addPriceToItem(new Item("A"), new Money(50));
        itemPrices.addPriceToItem(new Item("B"), new Money(30));
        itemPrices.addPriceToItem(new Item("C"), new Money(20));
        itemPrices.addPriceToItem(new Item("D"), new Money(15));
    }

    // TODO extract to DiscountRules, pass as argument
    private Money discountTotal(Money grossTotal, Scanner scanner) {
        // TODO Use immutable list instead of if
        if (NumberOfItemMatchesDiscountAmount(scanner.countScannedItem(ITEM_A), NUMBER_OF_ITEM_A_FOR_DISCOUNT)) {
            grossTotal.discount(DISCOUNT_FOR_A);
        }
        if (NumberOfItemMatchesDiscountAmount(scanner.countScannedItem(ITEM_B), NUMBER_OF_ITEM_B_FOR_DISCOUNT)) {
            grossTotal.discount(DISCOUNT_FOR_B);
        }
        return grossTotal;
    }
    // TODO wrap the two parameters as NumberOfItems??
    private boolean NumberOfItemMatchesDiscountAmount(long totalNumberOfASpecificItem, int numberOfItemsForDiscount) {
        return ((int) totalNumberOfASpecificItem) == numberOfItemsForDiscount;
    }
}