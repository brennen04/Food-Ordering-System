import java.util.ArrayList;

/**
 * Subclass to create Pasta objects, inherits from FoodItem
 *
 * @author Brennen Chong
 * @version 1.2.3
 */

public class Pasta extends FoodItem {

    /**
     * Parameterised constructor to create pasta object
     *
     * @param name name of the pasta
     * @param toppings toppings of the pasta
     */
    public Pasta(String name, ArrayList<String> toppings) {
        super(name, toppings);
    }

    /**
     * Override method to calculate the price of the pasta based on toppings
     *
     * @return price of pasta
     */
    @Override
    public double calculatePrice() {
        double basePrice = 11.50;
        double additionalCost = 0;

        if (toppings.contains("bolognese") || toppings.contains("primavera")){
            additionalCost += 5.20;
        } else if (toppings.contains("marinara")) {
            additionalCost += 6.80;
        } else if (toppings.contains("tomato")) {
            additionalCost += 4.00;
        } else {
            additionalCost += 0.00;
        }

        return basePrice + additionalCost;
    }

    /**
     * Override method to determine the type of the meal
     *
     * @return the type of the meal
     */
    @Override
    public MealType MealType() {
        if (toppings.contains("bolognese") || toppings.contains("marinara")){
            return MealType.MEAT;
        } else if (toppings.contains("primavera")) {
            return MealType.VEGETARIAN;
        }
        else {
            return MealType.VEGAN; //vegan if others or no toppings
        }
    }
}
