
import com.formdev.flatlaf.*;


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

    /**
     * The main entry point of the application.
     *
     * @param args The command-line arguments.
     */
    public static void main(String[] args) {
        // TODO code application logic here
        FlatIntelliJLaf.setup();
        mainScreen = new MainScreen();
        mainScreen.setVisible(true);

    }

}
