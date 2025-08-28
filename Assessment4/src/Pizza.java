import java.util.ArrayList;

/**
 * Subclass to create Pizza objects, inherits from FoodItem
 *
 * @author Brennen Chong
 * @version 2.3.1
 */

public class Pizza extends FoodItem {

    /**
     * Parameterised constructor to create pizza object
     *
     * @param name name of the pizza
     * @param toppings toppings of the pizza
     */
    public Pizza(String name, ArrayList<String> toppings){
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

        for (String topping : toppings) {
            if (topping.equals("pineapple")) {
                additionalCost += 2.50;
            } else if (topping.equals("seafood")) {
                additionalCost += 3.50;
            } else {
                additionalCost += 2.00;
            }
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
        if (toppings.contains("ham") || toppings.contains("seafood"))
        {
            return MealType.MEAT;
        }
        else if (!toppings.contains("ham") && !toppings.contains("seafood"))
        {
            return MealType.VEGETARIAN;
        }
        else if (!toppings.contains("ham") && !toppings.contains("seafood") && !toppings.contains("cheese"))
        {
            return MealType.VEGAN;
        }
        else {
            return MealType.VEGAN;
        }
    }
}

