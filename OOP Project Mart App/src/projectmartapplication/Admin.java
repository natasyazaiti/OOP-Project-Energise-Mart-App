// Ellya
package projectmartapplication;

import java.io.*;
import java.util.*;// library that can import the whole package in java.util
public class Admin{
    // variable/attributes
    static File f = new File("Admin.txt");
    private static ArrayList<Admin> admins = new ArrayList<Admin>();
    Scanner scanner = new Scanner(System.in);
    private String adminName;
    private String adminEmail;
    private String adminPassword;
    private int adminID,id,option;

    public Admin(String adminName, int adminID, String adminEmail, String adminPassword) {
        this.adminName = adminName;
        this.adminEmail = adminEmail;
        this.adminPassword = adminPassword;
        this.adminID = adminID;
    }

    public Admin() {

    }

    // setters and getters
    public void setAdminName(String adminName){
        this.adminName = adminName;
    }

    public String getAdminName(){
        return adminName;
    }

    public void setAdminID(int adminID){
        this.adminID = adminID;
    }

    public int getAdminID(){
        return adminID;
    }

    public void setAdminEmail(String adminEmail){
        this.adminEmail = adminEmail;
    }

    public String getAdminEmail(){
        return adminEmail;
    }

    public void setAdminPassword(String adminPassword){
        this.adminPassword = adminPassword;
    }

    public String getAdminPassword() {
        return adminPassword;
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

        setAdminName(adminName);
        setAdminID(adminID);
        setAdminEmail(adminEmail);
        setAdminPassword(adminPassword);

        Admin New = new Admin(adminName,adminID,adminEmail,adminPassword);
        admins.add(New);
        //writeto();
        System.out.print("Successfully Registered\n");
        HomePage(); //enter home page
    }

    public void LoginPage() throws IOException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter Username: ");
        String adminName = scanner.next();
        System.out.println("Enter Password: ");
        String adminPassword = scanner.next();

        for (int i = 0; i < admins.size(); i++){
            if(admins.get(i).getAdminName() == adminName && admins.get(i).getAdminPassword() == adminPassword){
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
        System.out.println("welcome" + getAdminName() +"\nChoose options:");
        System.out.println("1.Edit Profile \n2.Item Menu \n3.Back");
        int option = scanner.nextInt();

        switch(option){
            case 1:
                editprofile(id);
                break;
            case 2:
                ItemAdmin.main(null);
                break;
            case 3:
                MainMenu.main(null);
                break;
            default:
                System.out.println("Invalid option");
        }
    }

    public static String toString(ArrayList<Admin> admins){
        StringBuilder sb = new StringBuilder();
        for (Admin admin : admins) {
            sb.append("\nName: ").append(admin.getAdminName())
                    .append("\nemailid: ").append(admin.getAdminEmail())
                    .append("\nid: ").append(admin.getAdminID())
                    .append("\n");
        }
        return sb.toString();
    }

    public void editprofile(int id) throws IOException {
        for(int i = 0; i < admins.size(); i++)
        {
            if (admins.get(i).getAdminID() == id ){
                ArrayList<Admin> old = admins;
                System.out.println(toString(admins));
                System.out.println("MANAGE ACCOUNT\n1.Change password\n2.Change emailid\n3.Back");

                int option= scanner.nextInt();
                switch (option) {
                    case 1:
                        System.out.println("Enter old password: ");
                        String oldp = scanner.nextLine();
                        if (admins.get(i).getAdminPassword() == oldp) {
                            System.out.println("Enter new password: ");
                            int AdminPassword = scanner.nextInt();
                            Admin New= new Admin(admins.get(i).adminName, admins.get(i).getAdminID(), admins.get(i).getAdminEmail(), adminPassword);
                            admins.add(New);
                            System.out.println("Password changed successfully");
                        }
                        break;
                    case 2:
                        System.out.println("Enter emaild: ");
                        String adminemailid = scanner.next();
                        Admin New = new Admin(admins.get(i).getAdminName(), admins.get(i).getAdminID(), adminEmail, admins.get(i).getAdminPassword());
                        admins.add(New);
                        System.out.println("Email changed successfully");
                        break;
                    case 3:
                        HomePage();
                        break;
                    default:
                        System.out.println("Invalid Option");
                }
                admins.remove(old);
                writeto();
                HomePage();
            }
        }
    }

    public void writeto(){
        File f = new File("Admin.txt");
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(f));
            for (Admin i : admins)
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
        Admin admin = new Admin();
        File f = new File("Admin.txt");
        admin.writeto();

        ArrayList<Admin>admins = new ArrayList<>();
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(f));
            while (true) {
                admins.add((Admin) in.readObject());
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
                admin.displayRegister();
                break;
            case 2:
                admin.LoginPage();
                break;
            case 3:
                MainMenu.main(null);
                break;
            default:
                System.out.print("Invalid Choice\n");
        }
    }

}
