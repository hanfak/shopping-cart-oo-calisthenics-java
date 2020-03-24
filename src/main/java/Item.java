import java.math.BigDecimal;

public class Item {
  private final String name;
  private final BigDecimal price;

  public Item(String name, BigDecimal price) {
    this.name = name;
    this.price = price;
  }

  public BigDecimal getPrice() {
    return price;
  }

  public String getName() {
    return name;
  }
}
