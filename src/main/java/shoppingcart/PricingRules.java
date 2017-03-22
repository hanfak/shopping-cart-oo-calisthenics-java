package shoppingcart;

import java.util.HashMap;
import java.util.Map;

public class PricingRules {
    private static final int NUMBER_OF_A_ITEMS_FOR_DISCOUNT = 3;
    private static final Money DISCOUNT_FOR_A = new Money(20);
    private static final int NUMBER_OF_B_ITEMS_FOR_DISCOUNT = 2;
    private static final Money DISCOUNT_FOR_B = new Money(15);

    private Map<Item, Money> pricingRules = new HashMap<>();
    private Scanner scanner;

    public PricingRules(Scanner scanner) {
        this.scanner = scanner;
        setItemPrices();
    }

    public Money addScannedItemToTotal() {
        Money totalMoney = new Money(0);
        scanner.scannedItems().stream().map(this::findPrice).forEach(totalMoney::addItemPrice);
        return discountTotal(totalMoney);
    }

    public void addScannedItem(Item item) {
        scanner.scanAnItem(item);
    }

    private void setItemPrices() {
        pricingRules.put(new Item("A"), new Money(50));
        pricingRules.put(new Item("B"), new Money(30));
        pricingRules.put(new Item("C"), new Money(20));
        pricingRules.put(new Item("D"), new Money(15));
    }

    private Money findPrice(Item item) {
        return pricingRules.get(item);
    }

    private Money discountTotal(Money grossTotal) {
        if (scanner.findItemInScannedItems(new Item("A")) == NUMBER_OF_A_ITEMS_FOR_DISCOUNT) {
            grossTotal.discount(DISCOUNT_FOR_A);
        }
        if (scanner.findItemInScannedItems(new Item("B")) == NUMBER_OF_B_ITEMS_FOR_DISCOUNT) {
            grossTotal.discount(DISCOUNT_FOR_B);
        }
        return grossTotal;
    }
}

// Go throuh each item in itemsScanned, count the number of groups of A (%3)
// and discount total