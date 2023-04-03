// Ellya
package projectmartapplication;

import java.util.Scanner;
public class Name {
    private String fname;
    private String lname;

    public Name() {
        this.fname = "fname";
        this.lname = "lname";

    }

    public Name(String fname, String lname) {
        this.fname = fname;
        this.lname = lname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getFname() {
        return fname;
    }

    public String getLname() {
        return lname;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Name name = new Name();

        System.out.print("First name : ");
        String fname = scanner.next();
        name.setFname(fname);

        System.out.print("Last name : ");
        String lname = scanner.next();
        name.setLname(lname);
    }

}
