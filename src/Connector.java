//Harrison Easter

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class Connector {

    private Connection conn = null;

    public Connector() {
        String driver = "jdbc:ucanaccess://";
        String database = "Resturant.accdb";
        try {
            conn = DriverManager.getConnection(driver + database);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Cannot connect to db");
            System.out.println(e);
        }

    }

    /**
     * Executes a SELECT query on the database and retrieves the result set.
     *
     * @param query The SELECT query to be executed.
     * @return A ResultSet containing the data retrieved from the query.
     */
    public ResultSet readQuery(String query) {
        ResultSet set = null;
        try {
            Statement statement = conn.createStatement();
            set = statement.executeQuery(query);

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error:\n" + e);
        }
        return set;
    }

    /**
     * Executes a query that writes to the database (UPDATE, DELETE, or INSERT).
     *
     * @param query The query to be executed to modify the database.
     */
    public void writeQuery(String query) {
        try {

            Statement statement = conn.createStatement();
            statement.execute(query);

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error:.\n" + e);
        }
    }
}
