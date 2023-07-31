/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author harri
 */
public class Table {
    private int tableNumber;
    private int currentTabID;
    private String staff;
    private int capacity;

    public Table(int tableNumber, int currentTabID, String staff, int capacity) {
        this.tableNumber = tableNumber;
        this.currentTabID = currentTabID;
        this.staff = staff;
        this.capacity = capacity;
    }

    public int getTableNumber() {
        return tableNumber;
    }

    public int getCurrentTabID() {
        return currentTabID;
    }

    public String getStaff() {
        return staff;
    }

    public int getCapacity() {
        return capacity;
    }
    
    
}
