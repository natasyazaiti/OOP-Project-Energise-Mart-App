// Zaiti

package projectmartapplication;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MainMenu {
    // variables/attributes
    private int option;

    //constructor to display welcoming remarks when object for MainMenu() is created
    public MainMenu() {
        System.out.println("---------------------");
        System.out.println("      Welcome to");
        System.out.println("  ENERGIZE MART APP");
        System.out.println("---------------------");
    }

    // setters and getters
    public int getOption() {
        return option;
    }

    public void setOption(int option) {
        this.option = option;
    }

    // method to determine if the user is an admin or a customer
    public void chooseOption() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Are you an admin or a customer? [1-Admin   2-Customer]");
        while (true) {
            try {       // try block, if user enter a non-integer input, it will catch the exception
                int opt = scanner.nextInt();
                if (opt == 1 || opt == 2) {     // to make sure the input is only of integer 1 or 2
                    setOption(opt);
                    break;
                } else {
                    System.out.println("Invalid option. Please enter 1 for Admin or 2 for Customer.");
                }
            } catch (InputMismatchException e) {    // a specific catch exception for integer data type
                System.out.println("Invalid input. Please enter an integer.");      // ask the user to re-enter their option
                scanner.next();
            }
        }
    }

    // application code to test the MainMenu class
    public static void main(String[] args) throws IOException {
        MainMenu mainmenu = new MainMenu();
        mainmenu.chooseOption();    // to call the method chooseOption()

        // switch expression, to execute the block according to the option (1 or 2)
        switch (mainmenu.getOption()) {
            case 1:
                Admin.main(null);
                break;
            case 2:
                Customer.main(null);
                break;
        }
    }
}
