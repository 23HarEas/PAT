
import com.formdev.flatlaf.*;
import java.awt.event.ActionEvent;


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author harri
 */
public class ScreenBuild{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        FlatIntelliJLaf.setup();
        new LoginScreen().setVisible(true);
        new MainScreen().setVisible(true);
        new TableScreen().setVisible(true);
    }
    
    public void Submit(ActionEvent e) {
        // TODO add your code here
        System.out.println("1");
    }
    
    
}
