import java.util.*;


public class RestaurantDriver
{
    public static void main(String[] args)
    {
        OrderManager orderManager = new OrderManager();
        Scanner scanner = new Scanner(System.in);

        int choice;
        do {
            System.out.println("Welcome to Take Away Management Order");
            System.out.println("1. Enter Order details");
            System.out.println("2. Deliver an order");
            System.out.println("3. Display order details and customer details");
            System.out.println("4. Exit");
            System.out.print("Enter your choice (1-4): ");

            choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character


            switch (choice) {
                case 1 -> {
                    // Enter the details of a customer order
                    Order order = createOrder(scanner);
                    orderManager.addOrder(order);
                    System.out.println("Order added successfully!");
                }
                case 2 -> {
                    // Deliver an order
                    Order deliveredOrder = orderManager.deliverOldestOrder();
                    if (deliveredOrder != null) {
                        System.out.println("Delivered Order Details:");
                        System.out.println(deliveredOrder);
                    } else {
                        System.out.println("No orders to deliver.");
                    }
                }
                case 3 ->
                    // Print details of all orders
                        orderManager.displayAllOrders();
                case 4 ->
                    System.out.println("Exiting the program.");

                default -> System.out.println("Invalid choice. Please select a valid option.");
            }
        } while (choice != 4);
    }

    // Helper method to create an order by taking user input
    private static Order createOrder(Scanner scanner) {
        Order order = new Order();

        System.out.print("Customer Name: ");
        String name = scanner.nextLine();

        System.out.print("Contact Number: ");
        String contactNumber = scanner.nextLine();

        System.out.print("Delivery Address: ");
        String deliveryAddress = scanner.nextLine();

        order.setCustomerDetails(name, contactNumber, deliveryAddress);

        // Add food items to the order
        int foodItemChoice;
        do {
            System.out.println("Select a food item:");
            System.out.println("1. Pizza");
            System.out.println("2. Pasta");
            System.out.println("3. Finish Order");

            System.out.print("Enter your choice: ");
            foodItemChoice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            if (foodItemChoice == 1) {
                Pizza pizza = createPizza(scanner);
                order.addFoodItem(pizza);
            } else if (foodItemChoice == 2) {
                Pasta pasta = createPasta(scanner);
                order.addFoodItem(pasta);
            } else if (foodItemChoice == 3) {
                break;
            } else {
                System.out.println("Invalid choice. Please select a valid option.");
            }
        } while (foodItemChoice != 3);

        return order;
    }

    // Helper method to create a Pizza by taking user input
    private static Pizza createPizza(Scanner scanner) {
        System.out.print("Pizza Name (->pizza): ");
        String name = scanner.nextLine();

        ArrayList<String> toppingsList = new ArrayList<>();
        int toppingChoice;

        do {
            System.out.println("Select a pizza topping:");
            System.out.println("1 - Cheese");
            System.out.println("2 - Ham");
            System.out.println("3 - Pineapple");
            System.out.println("4 - Mushrooms");
            System.out.println("5 - Tomato");
            System.out.println("6 - Seafood");
            System.out.println("7 - Finish Pizza");

            System.out.print("Enter your number choice for your pizza topping (one at a time): ");
            toppingChoice = scanner.nextInt();
            scanner.nextLine();

            switch (toppingChoice) { // add toppings based on the user input
                case 1:
                    toppingsList.add("cheese");
                    break;
                case 2:
                    toppingsList.add("ham");
                    break;
                case 3:
                    toppingsList.add("pineapple");
                    break;
                case 4:
                    toppingsList.add("mushrooms");
                    break;
                case 5:
                    toppingsList.add("tomato");
                    break;
                case 6:
                    toppingsList.add("seafood");
                    break;
                case 7:
                    break;
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        } while (toppingChoice != 7);

        return new Pizza(name, toppingsList);
    }

    // Helper method to create a Pasta by taking user input
    private static Pasta createPasta(Scanner scanner) {
        System.out.print("Pasta Name (->pasta): ");
        String name = scanner.nextLine();

        System.out.print("Type only one pasta topping: \n"+
                "bolognese \n" +
                "marinara \n" +
                "primavera \n" +
                "tomato \n" );
        String topping = scanner.nextLine();

        ArrayList<String> toppingsList = new ArrayList<>();
        toppingsList.add(topping);

        return new Pasta(name, toppingsList);
    }
}
