import java.util.ArrayList;

/**
 * This class is used to manage orders created by the user.
 *
 * @authour
 * @version 2.0.1
 */

public class OrderManager {
    private final ArrayList<Order> orderList;

    /**
     * Non-parameterised constructor to create objects (order list)
     *
     */
    public OrderManager(){
        orderList = new ArrayList<>();
    }

    /**
     * Method to add order(s) created by customer to the order list
     *
     * @param order order(s) created by customer
     */

    public void addOrder(Order order) {
        orderList.add(order);
    }
    /**
     * Method to delivery the oldest order by removing it from the list
     *
     * @return the oldest order
     */
    public Order deliverOldestOrder() {
        if (!orderList.isEmpty()) {
            Order oldestOrder = orderList.get(0);
            orderList.remove(0);
            return oldestOrder;
        }
        return null;
    }

    /**
     * Method to display all the orders details in the order list
     */
    public void displayAllOrders(){
        for (Order order : orderList){
            System.out.println(order.toString());
            System.out.println("-----------------");
        }
    }
}
