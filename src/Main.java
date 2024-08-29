import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Address address1 = new Address("Lod", "Lea goldberg", "21");

        Gift gift = new Gift();

        Item phone = new Item("iPhone", 2500.000);
        Item mouse = new Item("Mouse", 150.000);

        ArrayList<Item> orderList = new ArrayList<Item>();
        orderList.add(phone);
        orderList.add(phone);

        Customer Aharon = new Customer("Aharon", "Zardav", "aharonzardav8@gmail.com", address1, CustomerType.VIP_COSTUMER,
                250.00,gift);

        Order order1 = new Order(address1, orderList, Aharon, PaymentType.CREDIT_CARD, OrderType.REGULAR_ORDER);
        Order order2 = new Order(address1, orderList, Aharon, PaymentType.CREDIT_CARD, OrderType.REGULAR_ORDER);


        System.out.println(order1.getId());
        System.out.println(order2.getId());
        System.out.println(order1.getTotalPrice());

//        Aharon.setCustomerType(CustomerType.REGULAR_COSTUMER);

        Order order = new Order(address1, orderList, Aharon, PaymentType.CREDIT_CARD, OrderType.VIP_ORDER);
        System.out.println(order.getTotalPrice());
        System.out.println(phone.getItemId());
        System.out.println(mouse.getItemId());

        System.out.println(Aharon.getCustomerId());

        Aharon.openGift();
        Aharon.openGift();

    }
}