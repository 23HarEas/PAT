
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
public class ScreenBuild {

    public static MainScreen mainScreen;
    public static LoginScreen loginScreen;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        FlatIntelliJLaf.setup();
        mainScreen = new MainScreen();
        mainScreen.setVisible(true);
        mainScreen.setBtnIcons();

        //loginScreen = new LoginScreen();
        //loginScreen.setVisible(true);
    }

}
