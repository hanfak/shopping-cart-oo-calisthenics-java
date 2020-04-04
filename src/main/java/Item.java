import java.math.BigDecimal;
// todo make immutable
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

  //TODO equals, hashcode, toString, formatter??, comparable??
}
