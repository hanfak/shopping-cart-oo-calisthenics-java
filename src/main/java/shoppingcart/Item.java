package shoppingcart;

public class Item {
    private String item;

    public Item(String item) {
        this.item = item;
    }

    @Override
    public boolean equals(Object object) {
        return ((Item) object).item == item;
    }

    @Override
    public int hashCode(){
        return item.hashCode();
    }
}
