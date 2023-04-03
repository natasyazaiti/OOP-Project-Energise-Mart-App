// Raida
package projectmartapplication;

import java.io.*;
import java.util.*;

public class Item implements Serializable {    //Serializable interface is a marker interface, which it has no methods.
    private String ItemName;
    private String ItemGroup;
    private int ItemId;
    private float ItemPrice;

    public static ArrayList<Item> ItemList = new ArrayList<Item>();
    static Scanner in = new Scanner(System.in);
    static File f = new File("Item.txt");

    Item(String ItemName, String ItemGroup, int ItemId, float ItemPrice) {
        this.ItemName = ItemName;
        this.ItemGroup = ItemGroup;
        this.ItemId = ItemId;
        this.ItemPrice = ItemPrice;
    }

    static void ViewOnly() throws IOException {
        for (Item i : ItemList) {
            System.out.println("\nid: " + i.getItemId() + "\nName: " + i.getItemName() + "\nGroup: " + i.getItemGroup() + "\nPrice: " + i.ItemPrice);
        }
        MainMenu.main(null);
    }

    static void ViewAll(int in) throws IOException {
        for (Item i : ItemList) {
            System.out.println("\nid: " + i.getItemId() + "\nName: " + i.getItemName() + "\nGroup: " + i.getItemGroup() + "\nPrice: " + i.ItemPrice);
        }
        Item.main(null);
    }

    static void ViewAll() throws IOException {
        for (Item i : ItemList) {
            System.out.println("\nid: " + i.getItemId() + "\nName: " + i.getItemName() + "\nGroup: " + i.getItemGroup() + "\nPrice: " + i.getItemPrice());
        }
        ItemAdmin.main(null);
    }

    static void ViewItem(int Itemid) throws IOException {
        for (Item i : ItemList) {
            if (i.getItemId() == Itemid) {
                System.out.println("\nid: " + i.getItemId() + "\nName: " + i.getItemName() + "\nGroup: "
                        + i.getItemGroup() + "\nPrice: " + i.ItemPrice);
                System.out.println("Do you want to add this item to cart?");
                System.out.println("1.Yes\n2.No");
                int cartchoice = in.nextInt();
                switch (cartchoice) {
                    case 1:
                        ShoppingCart.addItemToCart(i);
                        break;
                    case 2:
                        Item.main(null);
                        break;
                }
            }
        }
    }

    public static String toString(Item i) {
        return "\nid: " + i.getItemId() + "\nName: " + i.getItemName() + "\nGroup: " + i.getItemGroup() + "\nPrice: "
                + i.ItemPrice;
    }

    public String getItemName() {
        return ItemName;
    }

    public void setItemName(String itemName) {
        ItemName = itemName;
    }

    public String getItemGroup() {
        return ItemGroup;
    }

    public void setItemGroup(String itemGroup) {
        ItemGroup = itemGroup;
    }

    public int getItemId() {
        return ItemId;
    }

    public void setItemId(int itemId) {
        ItemId = itemId;
    }

    public float getItemPrice() {
        return ItemPrice;
    }

    public void setItemPrice(float itemprice) {
        ItemPrice = itemprice;
    }

    static void writeto() {
        File f = new File("Item.txt");
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(f));
            for (Item i : ItemList)
                out.writeObject(i);
            out.close();

        } catch (FileNotFoundException e) {
            System.out.println("File Not Found");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        File f = new File("Item.txt");
        writeto();
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(f));
            while (true) {
                ItemList.add((Item) in.readObject());
            }
        } catch (FileNotFoundException e) {
            System.out.println("File Not Found");
        } catch (IOException ignored) {
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println("1.View All Items\n2.View a selected Item");
        int choose = in.nextInt();
            try {
                if (choose == 1 || choose == 2) {
                    switch (choose) {
                        case 1:
                            ViewAll(choose);
                            break;
                        case 2:
                            System.out.println("Enter id of item to be viewed");
                            int itemid = in.nextInt();
                            ViewItem(itemid);
                            break;
                    }
                } else {
                    System.out.print("Invalid Choice\n");
                    Item.main(null);
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter an integer.");
                Item.main(null);
            }
    }
}
