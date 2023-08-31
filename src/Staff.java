

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author harri
 */
public class Staff {

    private int staffID;
    private String name;
    private String surname;
    private String cellphoneNumber;
    private String position;
    private Double wage;

    public Staff(int staffID, String name, String surname, String cellphoneNumber, String position, Double wage) {
        this.staffID = staffID;
        this.name = name;
        this.surname = surname;
        this.cellphoneNumber = cellphoneNumber;
        this.position = position;
        this.wage = wage;
    }

    /**
     * Retrieves the staff ID associated with an object.
     *
     * @return The staff ID of the object.
     */
    public int getStaffID() {
        return staffID;
    }

    /**
     * Retrieves the name of a staff member.
     *
     * @return The name of the staff member.
     */
    public String getName() {
        return name;
    }

    /**
     * Retrieves the surname of a staff member.
     *
     * @return The surname of the staff member.
     */
    public String getSurname() {
        return surname;
    }

    /**
     * Retrieves the cellphone number of a staff member.
     *
     * @return The cellphone number of the staff member.
     */
    public String getCellphoneNumber() {
        return cellphoneNumber;
    }

    /**
     * Retrieves the position of a staff member.
     *
     * @return The position of the staff member.
     */
    public String getPosition() {
        return position;
    }

    /**
     * Retrieves the wage of a staff member.
     *
     * @return The wage of the staff member.
     */
    public Double getWage() {
        return wage;
    }

}
