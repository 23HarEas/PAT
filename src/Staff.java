
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author harri
 */
public class Staff {
    private String staffID;
    private String name;
    private String surname;
    private String cellphoneNumber;
    private String position;
    private Double salary;

    public Staff(String staffID, String name, String surname, String cellphoneNumber, String position, Double salary) {
        this.staffID = staffID;
        this.name = name;
        this.surname = surname;
        this.cellphoneNumber = cellphoneNumber;
        this.position = position;
        this.salary = salary;
    }

    public String getStaffID() {
        return staffID;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getCellphoneNumber() {
        return cellphoneNumber;
    }

    public String getPosition() {
        return position;
    }

    public Double getSalary() {
        return salary;
    }
    
    
    
    
}