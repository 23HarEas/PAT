
import java.time.LocalDateTime;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author harri
 */
public class BookingTab extends Tab {

    private String name;
    private String cellphoneNumber;

    /**
     * Retrieves the name associated with the tab.
     *
     * @return The name associated with the tab.
     */
    public String getName() {
        return name;
    }

    /**
     * Retrieves the cellphone number associated with the tab.
     *
     * @return The cellphone number associated with the tab.
     */
    public String getCellphoneNumber() {
        return cellphoneNumber;
    }

    /**
     * Represents a booking-specific tab that extends the base Tab class. This
     * class includes additional information such as the name and cellphone
     * number of the booker.
     *
     * @param name The name of the booker associated with this booking tab.
     * @param cellphoneNumber The cellphone number of the booker.
     * @param tabID The unique ID of the booking tab.
     * @param tableNumber The table number associated with this tab.
     * @param pax The number of people (pax) at the table or booking.
     * @param booking A boolean indicating if this tab is associated with a
     * booking.
     * @param time The timestamp when the tab was opened or the booking was
     * made.
     */
    public BookingTab(String name, String cellphoneNumber, int tabID, int tableNumber, int pax, boolean booking, LocalDateTime time) {
        super(tabID, tableNumber, pax, booking, time);
        this.name = name;
        this.cellphoneNumber = cellphoneNumber;
    }

}
