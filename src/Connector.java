//Harrison Easter

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class Connector {
   private Connection conn = null;
    private Statement stmt = null;
    
    public Connector () { //Connect
        String driver = "jdbc:ucanaccess://";
        String database = "Resturant.accdb";
        try {
            conn = DriverManager.getConnection(driver + database);
            //JOptionPane.showMessageDialog(null, "Connection successful");
        }
        catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Cannot connect to db");
            System.out.println(e);
        }
        
    }
    
    public ResultSet execQuerySet(String query) { //Select
        ResultSet set = null;
        try {
            Statement statement = conn.createStatement();
            set = statement.executeQuery(query);

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error:\n" + e);
        }
        return set;
    }
    
        public void Insert(String query){ //Insert
        try{
            
            Statement stmt3 = conn.createStatement();
            stmt3.execute(query); 
            

        } catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Error:.\n"+e);
        }
    }
        
            public void Update(String query){ //Insert
        try{

            Statement stmt2 = conn.createStatement(); 
            stmt2.executeUpdate(query);

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error:.\n"+e);
        }
    }
    
    
}
