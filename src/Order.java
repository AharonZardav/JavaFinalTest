import java.time.LocalDate;
import java.util.ArrayList;

public class Order {
    private static int idCounter = 0;

    private int id;
    private Address deliveryAddress;
    private ArrayList<Item> itemsInOrder;
    private Customer customer;
    private double totalPrice;
    private PaymentType paymentType;
    private LocalDate orderDate;
    private OrderType orderType;

    public Order(Address deliveryAddress, ArrayList<Item> itemsInOrder, Customer customer, PaymentType paymentType, OrderType orderType) {
        this.id = setId();
        this.deliveryAddress = deliveryAddress;
        this.itemsInOrder = itemsInOrder;
        this.customer = customer;
        this.paymentType = paymentType;
        this.orderDate = LocalDate.now();
        this.orderType = orderType;
        this.totalPrice = calculateTotalPrice();
        updateCustomerFavoriteItemList();
    }

    public int getId() {
        return id;
    }

    private int setId(){
        return idCounter++;
    }

    public Address getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(Address deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public ArrayList<Item> getItemsInOrder() {
        return itemsInOrder;
    }

//    public void updateItemsInOrder(){
//
//    }

    public Customer getCustomer() {
        return customer;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    private double calculateTotalPrice(){
        double sum = 0;
        for(Item item : itemsInOrder){
            sum += item.getItemPrice();
        }
        if(orderType == OrderType.VIP_ORDER){
            if (customer.getCustomerType() == CustomerType.VIP_COSTUMER){
                if(sum >= customer.getCustomerDiscount()){
                    sum -= customer.getCustomerDiscount();
                }
                else{
                    sum = 0;
                }
            }
            else{
                throw new Error("The order you tried to do, is a VIP order. only VIP customers allowed to order VIP orders!");
            }
        }
        return sum;
    }

    public PaymentType getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(PaymentType paymentType) {
        this.paymentType = paymentType;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public OrderType getOrderType() {
        return orderType;
    }

    public void setOrderType(OrderType orderType) {
        this.orderType = orderType;
    }

    private void updateCustomerFavoriteItemList(){
        ArrayList<Item> favoriteItems = customer.getFavoriteItems();

        for (Item item : itemsInOrder) {
            boolean isItemAlreadyInFavorites = false;
            for (Item favoriteItem : favoriteItems) {
                if (item.getItemName().equals(favoriteItem.getItemName())) {
                    isItemAlreadyInFavorites = true;
                    break;
                }
            }
            if (!isItemAlreadyInFavorites) {
                favoriteItems.add(item);
            }
        }
    }
}
