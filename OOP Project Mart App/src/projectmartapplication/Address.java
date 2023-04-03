// Danisha
package projectmartapplication;

import java.util.Scanner;

public class Address {
    private char village;
    private char block;
    private char floor;
    private char house;
    private char room;
    private String roomaddr;

    public Address() {

    }// constructor can be overloaded (repeated but with different parameters)
    public Address(char village, char block, char floor, char house, char room) {
        this.village = village;
        this.block = block;
        this.floor = floor;
        this.house = house;
        this.room = room;
    }
    public void setVillage(char village) {
        this.village = village;
    }
    public char getVillage() {
        return village;
    }
    public void setBlock(char block) {
        this.block = block;
    }
    public char getBlock() {
        return block;
    }
    public void setFloor(char floor) {
        this.floor = floor;
    }
    public char getFloor() {
        return floor;
    }
    public void setHouse(char house) {
        this.house= house;
    }
    public char getHouse() {
        return house;
    }

    public void setRoom(char room) {
        this.room= room;
    }
    public char getRoom() {
        return room;
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        Address addr = new Address();// calling a constructor

        System.out.print("Please Enter Your Room Address (e.g. : V3E-01-02-04) = ");
        String roomaddr = scanner.nextLine();
        char village = roomaddr.charAt(1);//scan the char value at the 1st index which is the village

        //Check if the village exist or not
        while(village < '1' || village > '6') {
            System.out.println("Invalid village, please enter your room address again:");
            roomaddr = scanner.nextLine();
            village = roomaddr.charAt(1);
        }
        addr.setVillage(village);

        char block = roomaddr.charAt(2); //scan the char value at the 2nd index which is the Block
        addr.setBlock(block);

        char floor = roomaddr.charAt(5); //scan the char value at the 5th index which is the floor
        addr.setFloor(floor);

        char house = roomaddr.charAt(8); //scan the char value at the 8th index which is the house
        addr.setHouse(house);

        char room = roomaddr.charAt(11); //scan the char value at the 11th index which is the room
        addr.setRoom(room);

        System.out.println("Village : " + addr.getVillage());
        System.out.println("Block : " + addr.getBlock());
        System.out.println("Floor : " + addr.getFloor());
        System.out.println("House : " + addr.getHouse());
        System.out.println("Room : " + addr.getRoom());

    }
}
