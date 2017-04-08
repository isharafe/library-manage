/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import gui.FirstStart;
import gui.LogIn;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import org.jvnet.substance.skin.SubstanceMangoLookAndFeel;

/**
 *
 * @author Group 20
 */
public class Main {

    public static void main(String[] args) {
//        try {
            //UIManager.setLookAndFeel(new SubstanceMangoLookAndFeel());
            Db.DB.loadDbData();
            if (Db.DB.hasDatabase()) {
                Db.DB.changeURL();
                new LogIn().setVisible(true);
            } else {
                try {
                    boolean ok = Db.DB.createDatabase();
                    if (ok) {
                        new FirstStart().setVisible(true);
                    } else {
                        JOptionPane.showMessageDialog(null, "An error occured while creating database");
                    }
                } catch (Exception ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
//        } catch (UnsupportedLookAndFeelException ex) {
//            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }
}
