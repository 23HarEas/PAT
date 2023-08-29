
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
    private Boolean status;
    private String item;
    private int table;
    private LocalDateTime time;
    private String staff;
    private String notes;
    private int tabID;
    private int itemID;

    public Orders(int orderID, Boolean status, String item, int table, LocalDateTime time, String staff, String notes, int tabID, int itemID) {
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

    public int getOrderID() {
        return orderID;
    }

    public Boolean getStatus() {
        return status;
    }

    public String getItem() {
        return item;
    }

    public int getTable() {
        return table;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public String getStaff() {
        return staff;
    }

    public String getNotes() {
        return notes;
    }

    public int getTabID() {
        return tabID;
    }

    public int getItemID() {
        return itemID;
    }

}
