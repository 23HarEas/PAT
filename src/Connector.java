//Harrison Easter

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class Connector {

    private Connection conn = null;

    public Connector() { //Connect to the database
        String driver = "jdbc:ucanaccess://";
        String database = "Resturant.accdb";
        try {
            conn = DriverManager.getConnection(driver + database);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Cannot connect to db");
            System.out.println(e);
        }

    }

    public ResultSet readQuery(String query) { //Read from the database, Select
        ResultSet set = null;
        try {
            Statement statement = conn.createStatement();
            set = statement.executeQuery(query);

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error:\n" + e);
        }
        return set;
    }

    public void writeQuery(String query) { //Wrtie to the database, Update, Delete, Append
        try {

            Statement statement = conn.createStatement();
            statement.execute(query);

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error:.\n" + e);
        }
    }
}
