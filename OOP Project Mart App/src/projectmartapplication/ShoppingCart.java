// Zaiti

package projectmartapplication;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.IOException;

public class ShoppingCart {
    // variables/attributes
    private static float TotalPrice;    // this variable is only accessible within the class (private)
                                        // it can be accessed and updated by any method in the class (static)
    private static ArrayList<Item> cart = new ArrayList<Item>();

    // method to add items to cart
    public static void addItemToCart(Item item) {
        Scanner scanner = new Scanner(System.in);

        // java add method to add the item into the cart array list
        cart.add(item);
        System.out.println("Item has been added to your cart.");

        // ask the customer to choose from options
        System.out.println("Do you want to continue shopping or head to checkout? [1-Continue Shopping   2-Checkout]");
        while (true) {
            try {       // try block to catch exceptions
                int option = scanner.nextInt();
                if (option == 1 || option == 2) {   // to make sure it will execute the statement when the input is only 1 or 2
                    switch (option) {
                        case 1:
                            Item.main(null);    // option 1 will bring customer back to item class
                            break;
                        case 2:
                            printInvoice();     // option 2 will bring customer to PrintInvoice() method
                            break;
                    }
                } else {
                    System.out.println("Invalid option. Please enter 1 for Continue Shopping or 2 for Checkout.");
                }
            } catch (InputMismatchException e) {    // a specific catch exception for integer data type
                System.out.println("Invalid input. Please enter an integer.");      // ask the user to re-enter their option
                scanner.next();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    // method to remove item from cart
    public static void removeItem() throws IOException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter the name of the item you want to remove: ");
        while (true) {
            try {       // try block to catch exceptions
                String name = scanner.nextLine();
                boolean found = false;
                for (int i=0; i< cart.size(); i++) {
                    if (name.equals(cart.get(i).getItemName())) {   // to make sure it will execute the statement when the input is only 1 or 2
                        TotalPrice -= cart.get(i).getItemPrice();
                        cart.remove(i);
                        found = true;
                        break;
                    }
                }
                if (found == false) {
                    System.out.println("The item is not in your cart.");
                }
                break;
            } catch (Exception e) {    // a specific catch exception for integer data type
                System.out.println("Invalid input. Please enter the name of the item.");      // ask the user to re-enter their option
                scanner.next();
            }
        }

        printInvoice();
    }

    // method to edit the cart
    public static void editCart() throws InputMismatchException{
        Scanner scanner = new Scanner(System.in);

        // ask the customer if they want to edit the cart by removing or adding item
        System.out.println("Do you want to remove items or add items? [1-Remove Item   2-Add Item]");
        while (true) {
            try {       // try block to catch exceptions
                int option = scanner.nextInt();
                if (option == 1 || option == 2) {   // to make sure it will execute the statement when the input is only 1 or 2
                    switch (option) {
                        case 1:
                            removeItem();    // option 1 will bring customer to RemoveItem() method
                            break;
                        case 2:
                            Item.main(null);     // option 2 will bring customer to Item class
                            break;
                    }
                } else {
                    System.out.println("Invalid option. Please enter 1 for Remove Item or 2 for Add Item.");
                }
            } catch (InputMismatchException | IOException e) {    // a specific catch exception for integer data type
                System.out.println("Invalid input. Please enter an integer.");      // ask the user to re-enter their option
                scanner.next();
            }
        }
    }

    // method to calculate the total price of the items in the cart
    private static float totalPrice() {
        TotalPrice = 0;
        for (int i=0; i<cart.size(); i++) {
            TotalPrice += cart.get(i).getItemPrice();
        }

        return TotalPrice;
    }

    // method to print the receipt
    public static void printInvoice() throws NullPointerException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("---------------------");
        System.out.println("       RECEIPT");
        System.out.println("---------------------");

        // to print out all the items' details the customer added to cart
        for (int i=0; i<cart.size(); i++) {
            System.out.println(cart.get(i).getItemGroup() + " " + cart.get(i).getItemName() + "\t\t" + cart.get(i).getItemPrice());
        }

        // to print out the total amount of price of the items
        System.out.println("TOTAL(RM):\t\t\t\t" + totalPrice());

        // to ask the customer if they want to proceed with payment or edit their cart
        System.out.println("\nDo you want to proceed with payment or edit your cart? [1-Payment   2-Edit Cart]");
        while (true) {
            try {       // try block to catch exceptions
                int option = scanner.nextInt();
                if (option == 1 || option == 2) {   // to make sure it will execute the statement when the input is only 1 or 2
                    switch (option) {
                        case 1:
                            CheckOut.main(null);    // option 1 will bring customer to CheckOut class
                            break;
                        case 2:
                            editCart();     // option 2 will bring customer to EditCart() method to edit their cart
                            break;
                    }
                } else {
                    System.out.println("Invalid option. Please enter 1 for Payment or 2 for Edit Cart.");
                }
            } catch (InputMismatchException | NullPointerException | IOException e) {    // a specific catch exception for integer data type
                System.out.println("Invalid input. Please enter an integer.");      // ask the user to re-enter their option
                scanner.next();
            }
        }
    }

    // application code to test the ShoppingCart class
    public static void main(String[] args) throws IOException {
        Item item1 = new Item("nescafe latte", "drinks", 1, 3);
        Item item2 = new Item("roti gardenia", "snacks", 2, 1);

        ShoppingCart.addItemToCart(item1);
        ShoppingCart.addItemToCart(item1);
    }
}
