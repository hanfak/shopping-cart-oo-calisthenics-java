package shoppingcart;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PricingRules {
    private static final int NUMBER_OF_A_ITEMS_FOR_DISCOUNT = 3;
    private static final Money DISCOUNT_FOR_A = new Money(20);

    private Map<Item, Money> pricingRules = new HashMap<>();
    private List<Item> itemsScanned = new ArrayList<>();

    public PricingRules() {
        setItemPrices();
    }

    //TODO extract itemsScanned to new class
    // Move to scanner class
    public Money addScannedItemToTotal() {
        Money totalMoney = new Money(0);
        itemsScanned.stream().map(this::findPrice).forEach(totalMoney::add); //one dot per line for chaining object methods or includes functional aspect
        return discountTotal(totalMoney);
    }

//    public Money addScannedItemToTotal() {
//        Money totalMoney = new Money(0);
//        Stream<Money> list = itemsScanned.stream().map(this::findPrice);
//        ArrayList<Money> a = list.map(add).collect(Collectors.toCollection(ArrayList::new));
//        System.out.println(a.get(0));
//        System.out.println(a.get(1));
//        return discountTotal(a.get(a.size()-1));
//    }

    // Move to scanner class
    public void addScannedItemToBasket(Item item) {
        itemsScanned.add(item);
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
        if(numberOfAItemsInScannedList() == NUMBER_OF_A_ITEMS_FOR_DISCOUNT) {
            grossTotal.discount(DISCOUNT_FOR_A);
        }
        return grossTotal;
    }

    // TODO Move to Scanner class
    private long numberOfAItemsInScannedList() {
        return itemsScanned.stream().filter(p -> p.equals(new Item("A"))).count();
    }

}

// Go throuh each item in itemsScanned, count the number of groups of A (%3)
// and discount total