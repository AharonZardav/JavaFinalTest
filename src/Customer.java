import java.util.ArrayList;

public class Customer{
    private static int idCounter = 0;

    private int customerId;
    private String firstName;
    private String lastName;
    private String email;
    private Address deliveryAddress;
    private CustomerType customerType;
    private Double customerDiscount;
    private ArrayList<Item> favoriteItems;
    private Gift gift;

    public Customer(String firstName, String lastName, String email, Address deliveryAddress, CustomerType customerType,
                    Double customerDiscount, Gift gift) {
        this.customerId = setId();
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.deliveryAddress = deliveryAddress;
        this.customerType = customerType;
        this.customerDiscount = customerDiscount;
        this.favoriteItems = new ArrayList<Item>();
        this.gift = gift;
    }

    public int getCustomerId() {
        return customerId;
    }

    private int setId() {
        return idCounter++;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Address getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(Address deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }

    public Double getCustomerDiscount() {
        return customerDiscount;
    }

    public void setCustomerDiscount(Double customerDiscount) {
        this.customerDiscount = customerDiscount;
    }

    public ArrayList<Item> getFavoriteItems() {
        return favoriteItems;
    }
    
    public void addToFavoriteItemList(Item item){
        boolean itemExists = false;
        for (Item favoriteItem : favoriteItems) {
            if (item.getItemName().equals(favoriteItem.getItemName())) {
                itemExists = true;
                break;
            }
        }
        if (!itemExists) {
            favoriteItems.add(item);
        }
    }

    public void removeFromFavoriteItemList(Item item){
        favoriteItems.removeIf(favoriteItem -> favoriteItem.getItemName().equals(item.getItemName()));
    }

    public Gift getGift() {
        return gift;
    }

    public void takeGift(Gift gift) {
        this.gift = gift;
    }

    void openGift(){
        if (gift != null){
            System.out.println("Congratulations! you got a new gift! Enjoy!");
            gift = null;
        }
        else{
            System.out.println("you dont have gift!");
        }
    }
}
