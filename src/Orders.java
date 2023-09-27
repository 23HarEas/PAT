
import java.time.LocalDateTime;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author harri
 */
public class Orders {

    private int orderID;
    private boolean status;
    private String item;
    private int table;
    private LocalDateTime time;
    private String staff;
    private String notes;
    private int tabID;
    private int itemID;

    /**
     * Initializes an Orders object with the provided data.
     *
     * @param orderID The unique identifier for the order.
     * @param status The status of the order (e.g., true for completed, false
     * for in progress).
     * @param item The name of the menu item associated with the order.
     * @param table The table number where the order was placed.
     * @param time The date and time when the order was placed.
     * @param staff The name of the staff member who took the order.
     * @param notes Any additional notes or comments related to the order.
     * @param tabID The unique identifier for the tab associated with the order.
     * @param itemID The unique identifier for the menu item associated with the
     * order.
     */
    public Orders(int orderID, boolean status, String item, int table, LocalDateTime time, String staff, String notes, int tabID, int itemID) {
        this.orderID = orderID;
        this.status = status;
        this.item = item;
        this.table = table;
        this.time = time;
        this.staff = staff;
        this.notes = notes;
        this.tabID = tabID;
        this.itemID = itemID;
    }

    /**
     * Retrieves the order ID associated with an object.
     *
     * @return The order ID of the object.
     */
    public int getOrderID() {
        return orderID;
    }

    /**
     * Retrieves the status associated with an object.
     *
     * @return The status of the object.
     */
    public boolean getStatus() {
        return status;
    }

    /**
     * Retrieves the item associated with an object.
     *
     * @return The item of the object.
     */
    public String getItem() {
        return item;
    }

    /**
     * Retrieves the table number associated with an object.
     *
     * @return The table number of the object.
     */
    public int getTable() {
        return table;
    }

    /**
     * Retrieves the time associated with an object.
     *
     * @return The time of the object.
     */
    public LocalDateTime getTime() {
        return time;
    }

    /**
     * Retrieves the staff member associated with an object.
     *
     * @return The staff member of the object.
     */
    public String getStaff() {
        return staff;
    }

    /**
     * Retrieves the notes associated with an object.
     *
     * @return The notes of the object.
     */
    public String getNotes() {
        return notes;
    }

    /**
     * Retrieves the tab ID associated with an object.
     *
     * @return The tab ID of the object.
     */
    public int getTabID() {
        return tabID;
    }

    /**
     * Retrieves the item ID associated with an object.
     *
     * @return The item ID of the object.
     */
    public int getItemID() {
        return itemID;
    }

    /**
     * Sets the status of an object.
     *
     * @param status The status to be set for the object.
     */
    public void setStatus(boolean status) {
        this.status = status;
    }

}
