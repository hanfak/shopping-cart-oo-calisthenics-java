import java.math.BigDecimal;
import java.util.List;

public class ItemTotalCalculator {


  public BigDecimal calulate(List<Item> items) {
    return items.get(0).getPrice();
  }
}
