package shoppingcart;

public class Item {
    private String item;

    public Item(String item) {
        this.item = item;
    }

    // TODO - create and extend ValueType to cover overriden method

    @Override
    public boolean equals(Object object) {
        return ((Item) object).item == item;
    }

    @Override
    public int hashCode(){
        return item.hashCode();
    }

    @Override
    public String toString(){
        return String.valueOf(item);
    }
}
