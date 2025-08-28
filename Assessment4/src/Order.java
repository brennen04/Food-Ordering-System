import java.util.ArrayList;

/**
 * This class implements OrderDetails class by providing various method to manage order details
 *
 * @author Brennen Chong
 * @version 3.2.1
 */
public class Order implements OrderDetails{

    private String customerName;
    private String contactNumber;
    private String deliveryAddress;
    private ArrayList<FoodItem> foodItemsList;


    /**
     * Non-parameterised constructor to create order object
     */
    public Order(){
        foodItemsList = new ArrayList<>();
    }

    /**
     * Getter method to access the name of the customer
     *
     * @return customer's name
     */
    public String getCustomerName() {
        return customerName;
    }

    /**
     * Getter method to access the customer's contact number
     *
     * @return customer's contact number
     */
    public String getContactNumber() {
        return contactNumber;
    }

    /**
     * Getter method to access the customer's delivery address
     *
     * @return customer's delivery address
     */
    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    /**
     * Getter method to access the food item list of the order
     *
     * @return food item list
     */
    public ArrayList<FoodItem> getFoodItemsList() {
        return foodItemsList;
    }

    /**
     * Setter method to mutate the customer's contact number
     *
     * @param contactNumber customer's contact number
     */
    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    /**
     * Setter method to mutate the customer's name
     *
     * @param customerName customer's name
     */
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    /**
     * Setter method to mutate the customer's delivery address
     *
     * @param deliveryAddress customer's delivery address
     */
    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    /**
     * Setter method to mutate the food item list in the order
     *
     * @param foodItemsList food item list
     */
    public void setFoodItemsList(ArrayList<FoodItem> foodItemsList) {
        this.foodItemsList = foodItemsList;
    }

    /**
     * Override Setter method to set the customer's name, contact number and delivery address
     *
     * @param customerName customer's name
     * @param contactNumber customer's contact number
     * @param deliveryAddress customer's delivery address
     */
    @Override
    public void setCustomerDetails(String customerName, String contactNumber, String deliveryAddress) {
        this.customerName = customerName;
        this.contactNumber = contactNumber;
        this.deliveryAddress = deliveryAddress;
    }

    /**
     * Getter method to access the calculated total cost of the food
     *
     * @return the total cost of the food
     */
    @Override
    public double getTotalCost(){
        double totalCost = 0.00;
        for (FoodItem foodItem :  getFoodItemsList()){
            totalCost += foodItem.calculatePrice();
        }
        return totalCost;
    }

    /**
     * Method to add the created food object into food item list
     *
     * @param foodItem created food object
     */
    public void addFoodItem(FoodItem foodItem) {
        getFoodItemsList().add(foodItem);
    }


    /**
     * Overriding toString method to display the order details
     *
     * @return order details
     */
    @Override
    public String toString() {
        StringBuilder orderDetails = new StringBuilder();
        orderDetails.append("Customer Name: ").append(getCustomerName()).append("\n");
        orderDetails.append("Contact Number: ").append(getContactNumber()).append("\n");
        orderDetails.append("Delivery Address: ").append(getDeliveryAddress()).append("\n");

        for (FoodItem foodItem :  getFoodItemsList()) {
            orderDetails.append("Food Item: ").append(foodItem.getFoodName()).append("\n");
            orderDetails.append("Toppings: ").append(foodItem.getToppings()).append("\n");
            orderDetails.append("Price: $").append(foodItem.calculatePrice()).append("\n");
            orderDetails.append("Meal Type: ").append(foodItem.MealType()).append("\n");
        }

        orderDetails.append("Total Cost: $").append(getTotalCost()).append("\n");
        return orderDetails.toString();
    }
}

