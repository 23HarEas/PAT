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

    public int getMenueID() {
        return menueID;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Double getPrice() {
        return price;
    }

}
