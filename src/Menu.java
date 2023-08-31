/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author harri
 */
public class Menu {

    private int menueID;
    private String name;
    private String description;
    private Double price;

    public Menu(int menueID, String name, String description, Double price) {
        this.menueID = menueID;
        this.name = name;
        this.description = description;
        this.price = price;
    }

    /**
     * Retrieves the menu ID associated with an object.
     *
     * @return The menu ID of the object.
     */
    public int getMenueID() {
        return menueID;
    }

    /**
     * Retrieves the name associated with an object.
     *
     * @return The name of the object.
     */
    public String getName() {
        return name;
    }

    /**
     * Retrieves the description associated with an object.
     *
     * @return The description of the object.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Retrieves the price associated with an object.
     *
     * @return The price of the object.
     */
    public Double getPrice() {
        return price;
    }

}
