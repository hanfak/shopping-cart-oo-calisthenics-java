package shoppingcart;

public class Checkout {
    private PricingRules pricingRules;
    private Scanner scanner;

    public Checkout(PricingRules pricingRules, Scanner scanner) {
        this.pricingRules = pricingRules;
        this.scanner = scanner;
    }

    public Checkout(PricingRules pricingRules) {
        this(pricingRules, new Scanner(new ScannedItems()));
    }

    public Money total() {
        return pricingRules.totalScannedItems(scanner);
    }

    public void scan(Item item) {
        scanner.scanAnItem(item);
    }
}