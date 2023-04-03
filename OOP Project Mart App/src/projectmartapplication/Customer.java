// Danisha
package projectmartapplication;

import java.io.*;
import java.util.*;// library that can import the whole package in java.util
public class Customer{
    // variable/attributes
    static File f = new File("Customer.txt");
    private ArrayList<Customer> Cust = new ArrayList<Customer>();
    Scanner scanner = new Scanner(System.in);
    private String CustName;
    private String CustEmail;
    private String CustPassword;
    private int CustID,id,option;

    public Customer(String CustName, int CustID, String CustEmail, String CustPassword) {
        this.CustName = CustName;
        this.CustEmail = CustEmail;
        this.CustPassword = CustPassword;
        this.CustID = CustID;
    }

    public Customer() {

    }

    // setters and getters
    public void setCustName(String CustName){
        this.CustName = CustName;
    }

    public String getCustName(){
        return CustName;
    }

    public void setCustID(int CustID){
        this.CustID = CustID;
    }

    public int getCustID(){
        return CustID;
    }

    public void setCustEmail(String CustEmail){
        this.CustEmail = CustEmail;
    }

    public String getCustEmail(){
        return CustEmail;
    }

    public void setCustPassword(String CustPassword){
        this.CustPassword = CustPassword;
    }

    public String getCustPassword() {
        return CustPassword;
    }

    // methods
    public void displayRegister() throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Username: ");
        String adminName = scanner.next();
        System.out.println("ID: ");
        int adminID = scanner.nextInt();
        System.out.println("Email: ");
        String adminEmail = scanner.next();
        System.out.println("Password: ");
        String adminPassword = scanner.next();

        setCustName(CustName);
        setCustID(CustID);
        setCustEmail(CustEmail);
        setCustPassword(CustPassword);

        Customer New = new Customer(CustName,CustID,CustEmail,CustPassword);
        Cust.add(New);
        writeto();
        System.out.print("Successfully Registered");
        HomePage(); //enter home page
    }

    public void LoginPage() throws IOException {
        System.out.println("Enter Username: ");
        String CustName = scanner.next();
        System.out.println("Enter Password: ");
        String adminPassword = scanner.next();

        for(int i = 0; i < Cust.size(); i++){
            if(Cust.get(i).getCustName() == CustName && Cust.get(i).getCustPassword() == CustPassword){
                HomePage(); //enter home page
            }
            else{
                System.out.println("Username and/or password incorrect.");
                MainMenu.main(null);
            }
        }
    }
    public void HomePage() throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("welcome"+ "\nChoose options:");
        System.out.println("1.Edit Profile \n2.Item Menu \n3.Back");
        int option = scanner.nextInt();

        switch(option){
            case 1:
                editprofile(id);
                break;
            case 2:
                Item.main(null);
                break;
            case 3:
                MainMenu.main(null);
            default:
                System.out.println("Invalid option");
        }
    }

    public String toString(ArrayList<Customer> Cust){
        StringBuilder sb = new StringBuilder();
        for (Customer c : Cust) {
            sb.append("\nName: ").append(c.getCustName())
                    .append("\nemailid: ").append(c.getCustEmail())
                    .append("\nid: ").append(c.getCustID());
        }
        return sb.toString();
    }

    public void editprofile(int id) throws IOException {
        for(int i = 0; i < Cust.size(); i++)
        {
            if (Cust.get(i).CustID == id ){
                ArrayList<Customer> old = Cust;
                System.out.println(toString(Cust));
                System.out.println("MANAGE ACCOUNT\n1.Change password\n2.Change Email\n3.Back");

                int option= scanner.nextInt();
                switch (option) {
                    case 1:
                        System.out.println("Enter old password: ");
                        String oldp = scanner.nextLine();
                        if (Cust.get(i).getCustPassword() == oldp) {
                            System.out.println("Enter new password: ");
                            int CustPassword = scanner.nextInt();
                            Customer New= new Customer(Cust.get(i).getCustName(), Cust.get(i).getCustID(), Cust.get(i).getCustEmail(), getCustPassword());
                            Cust.add(New);
                            System.out.println("Password changed successfully");
                        }
                        break;
                    case 2:
                        System.out.println("Enter emaild: ");
                        String adminemailid = scanner.next();
                        Customer New = new Customer(Cust.get(i).getCustName(), Cust.get(i).getCustID(), CustEmail, Cust.get(i).getCustPassword());
                        Cust.add(New);
                        System.out.println("Email changed successfully");
                        break;
                    case 3:
                        HomePage();
                        break;
                    default:
                        System.out.println("Invalid Option");
                }
                Cust.remove(old);
                writeto();
                HomePage();
            }
        }
    }
    public void writeto(){
        File f = new File("Customer.txt");
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(f));
            for (Customer i : Cust)
                out.writeObject(i);
            out.close();
        } catch (FileNotFoundException e) {
            System.out.println("File Not Found");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        Customer customer = new Customer();
        File f = new File("Customer.txt");
        customer.writeto();

        ArrayList<Customer>Cust = new ArrayList<>();
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(f));
            while (true) {
                Cust.add((Customer) in.readObject());
            }
        } catch (FileNotFoundException e) {
            System.out.println("File Not Found");
        } catch (IOException e) {
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println("1.Register \n2.Admin Login \n3.Back ");
        int choosemain = scanner.nextInt();
        switch (choosemain) {
            case 1:
                customer.displayRegister();
                break;
            case 2:
                customer.LoginPage();
                break;
            case 3:
                MainMenu.main(null);
                break;
            default:
                System.out.print("Invalid Choice\n");
        }
    }

}
