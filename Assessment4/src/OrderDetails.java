/**
 * This interface defines abstract methods for managing and retrieving order information
 *
 * @author Brennen Chong
 * @version 1.1.2
 */

public interface OrderDetails {

    /**
     * Setter method to set the customer's name, contact number and delivery address
     *
     * @param customerName customer's name
     * @param contactNumber customer's contact number
     * @param deliveryAddress customer's delivery address
     */
    void setCustomerDetails(String customerName, String contactNumber, String deliveryAddress);

    /**
     * Getter method to access the total cost of the food
     *
     * @return the total cost of the food
     */
    double getTotalCost();
}
