// Anis
package projectmartapplication;

import java.util.Scanner;

public class Delivery {
    private Name name;
    private Address address;
    private int phoneno;
    private String deliveryDate;

    public Delivery(Name name, Address address, int phoneno, String deliveryDate) {
        this.name = name;
        this.address = address;
        this.phoneno = phoneno;
        this.deliveryDate = deliveryDate;
    }

    public Delivery() {}

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public int getPhoneno() {
        return phoneno;
    }

    public void setPhoneno(int phoneno) {
        this.phoneno = phoneno;
    }

    public String getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(String deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Delivery person1 = new Delivery();
        Name name = new Name();

        System.out.print("Enter your first name: ");
        name.setFname(scanner.nextLine());
        System.out.print("Enter your last name: ");
        name.setLname(scanner.nextLine());
        person1.setName(name);

        //System.out.print("Enter your address (e.g. : V3E-01-02-04): ");
        //person1.setAddress(scanner.nextLine());
        Address.main(null);

        System.out.print("Enter your Phone Number: ");
        person1.setPhoneno(scanner.nextInt());
        scanner.nextLine();

        System.out.print("Enter your Delivery date (e.g. : 02052023): ");
        person1.setDeliveryDate(scanner.nextLine());

        System.out.println("\n" + person1.name.getFname() + " " + person1.name.getLname());
        System.out.println(person1.address);
        System.out.println("+60" + person1.phoneno);
        System.out.println(person1.deliveryDate);
    }
}
