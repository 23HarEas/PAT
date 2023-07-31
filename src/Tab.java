
import java.time.LocalDateTime;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author harri
 */
public class Tab {
    private int tabID;
    private int tableNumber;
    private Double total;
    private int pax;
    private boolean booking;
    private LocalDateTime time;
    private int numberOrders;

    public Tab(int tabID, int tableNumber, int pax, boolean booking, LocalDateTime time) {
        this.tabID = tabID;
        this.tableNumber = tableNumber;
        this.total = 0.0;
        this.pax = pax;
        this.booking = booking;
        this.time = time;
    }
    
    public int getTabID() {
        return tabID;
    }

    public int getTableNumber() {
        return tableNumber;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public Double getTotal() {
        return total;
    }

    public int getPax() {
        return pax;
    }

    public boolean isBooking() {
        return booking;
    }
    
    
    
}
