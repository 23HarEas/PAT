
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

    public BookingTab(String name, String cellphoneNumber, int tabID, int tableNumber, int pax, boolean booking, LocalDateTime time) {
        super(tabID, tableNumber, pax, booking, time);
        this.name = name;
        this.cellphoneNumber = cellphoneNumber;
    }

}
