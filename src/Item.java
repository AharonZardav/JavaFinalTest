public class Item {
    private static int idCounter = 0;

    private int itemId;
    private String itemName;
    private double itemPrice;

    public Item(String itemName, double itemPrice) {
        this.itemId = setId();
        this.itemName = itemName;
        this.itemPrice = itemPrice;
    }

    public int getItemId() {
        return itemId;
    }

    private int setId() {
        return idCounter++;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public double getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(double itemPrice) {
        this.itemPrice = itemPrice;
    }
}
