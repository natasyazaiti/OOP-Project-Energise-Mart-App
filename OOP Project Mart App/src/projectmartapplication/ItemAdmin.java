// Raida
package projectmartapplication;

import java.io.*;
import java.util.*;

public class ItemAdmin extends Item {

    static Scanner in = new Scanner(System.in);

    ItemAdmin(String ItemName, String ItemGroup, int Itemid, float ItemPrice) {
        super(ItemName, ItemGroup, Itemid, ItemPrice);
    }

    static void ViewItem(int Itemid) throws IOException {
        boolean found = false;
        for (Item i : Item.ItemList) {
            if (i.getItemId() == Itemid) {
                System.out.println("\nid: " + i.getItemId() + "\nName: " + i.getItemName() + "\nGroup: "
                        + i.getItemGroup() + "\nPrice: " + i.getItemPrice());
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Invalid id. Item is not found.");
        }
    }

    static void AddItem() throws IOException {
        System.out.println("Enter Item Name: ");
        String Name = in.next();
        System.out.println("Enter Item Group: ");
        String Group = in.next();
        System.out.println("Enter Item id: ");
        int id = in.nextInt();
        System.out.println("Enter Item Price: ");
        float Price = in.nextFloat();

        Item New = new Item(Name, Group, id, Price);
        ItemList.add(New);
        writeto();
        System.out.print("Item added.");
    }


    public static void main(String[] args) throws IOException {
        writeto();
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(f));
            while (true) {
                ItemList.add((Item) in.readObject());
            }
        } catch (FileNotFoundException e) {
            System.out.println("File Not Found");
        } catch (IOException e) {
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("\n1.View all Items\n2.View selected item\n3.Add Item\n4.Back");
        int choosea2 = in.nextInt();
        switch (choosea2) {
            case 1:
                Item.ViewAll();
                break;
            case 2:
                System.out.println("Enter id of item to be viewed");
                int itemid = in.nextInt();
                ItemAdmin.ViewItem(itemid);
                break;
            case 3:
                ItemAdmin.AddItem();
                break;
            case 5:
                Admin.main(args);
                break;
            default:
                System.out.println("Invalid Choice");
        }
    }
}
