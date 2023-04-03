// Anis
package projectmartapplication;

import java.io.IOException;
import java.util.Scanner;

public class CheckOut {
    private static Address address;
    private static String phoneno;

    static Scanner in = new Scanner(System.in);

    static void getDeliveryDetails() throws IOException {
        System.out.println("The delivery details for your order: ");
        Address.main(null);
        System.out.println("Enter Phoneno: ");
        phoneno = in.next();
    }

    public static void main(String[] args) throws IOException {

        System.out.println("--Mode of Payment--" + "\n" + "Choose the option:" + "\n" + "1. Debit /Credit /ATM cards"
                + "\n" + "2. Cash on Delivery (COD)" + "\n" + "3.Back");

        int choice = in.nextInt();
        switch (choice) {
            // pay using Cards
            case 1:
                getDeliveryDetails();
                System.out.print("Enter the name of the card holder:");
                String cardName = in.next();
                System.out.print("Enter the card number:");
                long cardNo = in.nextLong();
                System.out.println("Enter CVV (the three digit number printed on the back of the card):");
                int cvv = in.nextInt();
                System.out.print("Enter the expiry DD/MM/YYYY");
                int expDate = in.nextInt();
                System.out.println("1. To continue payment" + "\n" + "2. To stop payment" + "\n");
                int cardchoice = in.nextInt();
                if (cardchoice == 1) {
                    System.out.println("-----------Your order is success----------");
                    System.out.println("Thank you for using Energizing mart!");
                    System.exit(0);
                } else {
                    System.out.println("-----------Your order is cancelled-----------");
                    // The PrintInvoice method is not defined, so it will not compile
                    // ShoppingCart.PrintInvoice();
                }
                break;

            // pay using Cash on Delivery
            case 2:
                getDeliveryDetails();
                System.out.println("Verify your delivery details");
                System.out.println(address + "\n" + "0" + phoneno);
                System.out.println("\n" + "1. To continue the COD" + "\n" + "2. To stop the COD" + "\n");
                int codchoice = in.nextInt();
                if (codchoice == 1) {
                    System.out.println("-----------Your order is success----------");
                    System.out.println("Thank you for using Energizing mart!");
                    System.exit(0);
                } else {
                    System.out.println("-----------Your order is cancelled-----------");
                }
        }
    }
}
