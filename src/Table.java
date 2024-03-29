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

    /**
     * Initializes a new Table object with the given parameters.
     *
     * @param tableNumber The unique number associated with this table.
     * @param currentTabID The ID of the current tab associated with this table.
     * @param staff The name of the staff member associated with this table.
     * @param capacity The capacity (number of people) that this table can
     * accommodate.
     */
    public Table(int tableNumber, int currentTabID, String staff, int capacity) {
        this.tableNumber = tableNumber;
        this.currentTabID = currentTabID;
        this.staff = staff;
        this.capacity = capacity;
    }

    /**
     * Returns the table number associated with this tab.
     *
     * @return The table number.
     */
    public int getTableNumber() {
        return tableNumber;
    }

    /**
     * Returns the ID of the current tab for this table.
     *
     * @return The current tab ID.
     */
    public int getCurrentTabID() {
        return currentTabID;
    }

    /**
     * Returns the name of the staff member assigned to this table.
     *
     * @return The staff member's name.
     */
    public String getStaff() {
        return staff;
    }

    /**
     * Returns the capacity (number of people) of this table.
     *
     * @return The table's capacity.
     */
    public int getCapacity() {
        return capacity;
    }

}
