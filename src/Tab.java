
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

    /**
     * Retrieves the ID of the tab.
     *
     * @return The ID of the tab.
     */
    public int getTabID() {
        return tabID;
    }

    /**
     * Retrieves the number of the table.
     *
     * @return The number of the table.
     */
    public int getTableNumber() {
        return tableNumber;
    }

    /**
     * Retrieves the time associated with the tab.
     *
     * @return The time associated with the tab.
     */
    public LocalDateTime getTime() {
        return time;
    }

    /**
     * Retrieves the total amount for the tab.
     *
     * @return The total amount for the tab.
     */
    public Double getTotal() {
        return total;
    }

    /**
     * Retrieves the number of people (pax) associated with the tab.
     *
     * @return The number of people associated with the tab.
     */
    public int getPax() {
        return pax;
    }

    /**
     * Checks if the tab is a booking.
     *
     * @return True if the tab is a booking, false otherwise.
     */
    public boolean isBooking() {
        return booking;
    }

}
