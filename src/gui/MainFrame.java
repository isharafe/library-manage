/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * MainFrame.java
 *
 * Created on Jan 5, 2013, 6:57:55 PM
 */
package gui;

import Classes.GuiManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Group 20
 */
public class MainFrame extends javax.swing.JFrame {

    /** Creates new form MainFrame */
    String userType;
    String userName;

    public MainFrame(String userType, String userName) {
        initComponents();
        setTitle(userType + "\t-" + userName);
        this.userType = userType;
        this.userName = userName;
        loadGui(userType);
    }

    private void loadGui(String userType) {

        try {
            Statement stmt=Db.DB.getConnection().createStatement();
            ResultSet rset = stmt.executeQuery("SELECT gui_id FROM permission "
                    + "WHERE member_type='" + userType + "' ORDER BY gui_id");
            ArrayList<Integer> ast = new ArrayList<Integer>();
            while (rset.next()) {
                ast.add(rset.getInt(1));
            }
            rset.close();
            stmt.close();
            
            Member m = null;
            Book b = null;
            ManageBooks mb = null;
            Settings s = null;

            for (int i : ast) {
                if (i > 10 && i < 20) {
                    if (m == null) {
                        m = new Member();
                    }
                    if (i == GuiManager.ADD_MEMBERS) {
                        MemberNew mn = new MemberNew();
                        m.addTab("New Registration", new javax.swing.ImageIcon(getClass().getResource("/Images/Add member.png")), mn);
                        GuiManager.mn = mn;
                    } else if (i == GuiManager.SEARCH_MEMBERS) {
                        MemberSearch ms = new MemberSearch();
                        m.addTab("Search a Member", new javax.swing.ImageIcon(getClass().getResource("/Images/Search member.png")), ms);
                        GuiManager.ms = ms;
                    } else if (i == GuiManager.ENABLE_CHANGE_MEMBERS_DATA) {
                        if (GuiManager.ms != null) {
                            GuiManager.ms.enableChangeData();
                        }
                    }
                    pnlMain.addTab("Member", new javax.swing.ImageIcon(getClass().getResource("/Images/users.png")), m);
                } else if (i > 20 && i < 30) {
                    if (b == null) {
                        b = new Book();
                    }
                    if (i == GuiManager.ADD_BOOKS) {
                        BookNew bn = new BookNew();
                        b.addTab("Add a Book", new javax.swing.ImageIcon(getClass().getResource("/Images/Add book.png")), bn);
                        GuiManager.bn = bn;
                    } else if (i == GuiManager.SEARCH_BOOKS) {
                        BookSearch bs = new BookSearch();
                        b.addTab("Search a Book", new javax.swing.ImageIcon(getClass().getResource("/Images/Search book.png")), bs);
                        GuiManager.bs = bs;
                    } else if (i == GuiManager.ENABLE_CHANGE_BOOKS_DATA) {
                        if (GuiManager.bs != null) {
                            GuiManager.bs.enableChangeData();
                        }
                    }
                    pnlMain.addTab("Book", new javax.swing.ImageIcon(getClass().getResource("/Images/book.png")), b);
                } else if (i > 30 && i < 40) {
                    if (mb == null) {
                        mb = new ManageBooks();
                    }
                    if (i == GuiManager.LEND_BOOKS) {
                        ManageBooksLend mbl = new ManageBooksLend();
                        mb.addTab("Lend Books", new javax.swing.ImageIcon(getClass().getResource("/Images/cart_add.png")), mbl);
                        GuiManager.mbl = mbl;
                    } else if (i == GuiManager.RECEIVE_BOOKS) {
                        ManageBooksReturn mbr = new ManageBooksReturn();
                        mb.addTab("Receive Books", new javax.swing.ImageIcon(getClass().getResource("/Images/Receive.png")), mbr);
                        GuiManager.mbr = mbr;
                    }
                    pnlMain.addTab("Manage Books", new javax.swing.ImageIcon(getClass().getResource("/Images/monitor.png")), mb);
                } else if (i > 40 && i < 50) {
                    if (s == null) {
                        s = new Settings();
                        GuiManager.s=s;
                    }
                    if (i == GuiManager.USER_ACCOUNTS) {
                        SettingsPassword sp = new SettingsPassword();
                        s.addTab("User Account Manage", new javax.swing.ImageIcon(getClass().getResource("/Images/controlpanel.png")), sp);
                        GuiManager.sp = sp;
                    } else if (i == GuiManager.MANAGE_LEND_BOOK_OPTIONS) {
                        SettingsLend sl = new SettingsLend();
                        s.addTab("Lend Book options", new javax.swing.ImageIcon(getClass().getResource("/Images/spanner.png")), sl);
                        GuiManager.sl = sl;
                    } else if (i == GuiManager.GIVE_PERMISSIONS_TO_OTHER_USERS) {
                        SettingsAdmin sa = new SettingsAdmin();
                        s.addTab("Admin Settings", new javax.swing.ImageIcon(getClass().getResource("/Images/Padlock User Control.png")), sa);
                        GuiManager.sa = sa;
                    }
                    pnlMain.addTab("Settings", new javax.swing.ImageIcon(getClass().getResource("/Images/help3.png")), s);
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToggleButton1 = new javax.swing.JToggleButton();
        pnlMain = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jToggleButton1.setText("Log Off");
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jToggleButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 20, -1, -1));
        getContentPane().add(pnlMain, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 980, 570));

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 590));

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-1020)/2, (screenSize.height-625)/2, 1020, 625);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        GuiManager.refreshMemberType();
    }//GEN-LAST:event_formWindowOpened

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
        new LogIn().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jToggleButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                new MainFrame("Admin", "ME").setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JTabbedPane pnlMain;
    // End of variables declaration//GEN-END:variables
}
