import java.util.ArrayList;

/**
 * Abstract super class to create food object in a restaurant.
 *
 * @author Brennen Chong
 * @version 1.2.3
 */
public abstract class FoodItem {

    protected String foodName;
 
    protected ArrayList<String> toppings;


    /**
     * Parameterised constructor which creates the object of the abstract class FoodItem
     *
     * @param foodName the name of the food
     * @param toppings the name of the toppings of the food
     */
    protected FoodItem(String foodName, ArrayList<String> toppings){//, double price) {
        this.foodName = foodName;
        this.toppings = toppings;
    }

    /**
     * Getter method to return the name of the food
     *
     * @return name of the food
     */
    protected String getFoodName() {
        return foodName;
    }

    /**
     * Getter method to return the name of the toppings
     *
     * @return the name of the toppings
     */
    protected ArrayList<String> getToppings() {
        return toppings;
    }

    /**
     * Abstract method to calculate the price of the food
     *
     * @return the price of the food
     */
    protected abstract double calculatePrice();

    /**
     * Abstract method to determine to type of the meal
     *
     * @return type of the meal
     */
    protected abstract MealType MealType();

}


