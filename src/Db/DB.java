/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Db;

import Classes.Book;
import Classes.DbData;
import Classes.LendSettings;
import Classes.Lend_Return;
import Classes.Member;
import Classes.Permission;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * @author pothgula By Heala Sisu Hawula.
 */
public class DB {

    private static String driver = "com.mysql.jdbc.Driver";
    private static String url = "jdbc:mysql://localhost:3306/";
    public static String dbName = "library_g_20";
    private static String user = "";
    private static String psw = "";
    private static Connection con;

    public static void loadDbData() {
        File f = new File(System.getProperty("user.dir") + "/db_data.lib");
        if (f.exists()) {
            {
                ObjectInputStream oi = null;
                try {
                    FileInputStream fi = new FileInputStream(f);
                    oi = new ObjectInputStream(fi);
                    DbData d = (DbData) oi.readObject();
                    DB.user = d.userName;
                    DB.psw = d.password;
                } catch (Exception ex) {
                    Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
                } finally {
                    try {
                        oi.close();
                    } catch (IOException ex) {
                        Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }

        } else {
            FileOutputStream fo = null;
            ObjectOutputStream oo = null;
            try {
                DbData d = new DbData();
                String userName = JOptionPane.showInputDialog("Enter user name for the data base access.\n(i.e \"root\")");
                if (userName != null) {
                    String password = JOptionPane.showInputDialog("Enter password for the data base acess.\n(i.e \"12345\")\n(keep empty if no password)");
                    if (password != null) {
                        fo = new FileOutputStream(f);
                        oo = new ObjectOutputStream(fo);
                        d.userName = userName;
                        d.password = password;
                        oo.writeObject(d);
                        oo.flush();
                        loadDbData();
                    }
                }
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Couldn't write to disk.\nPlease run the application as \"Administrator\" ONCE", "Error occured", JOptionPane.ERROR_MESSAGE);
                Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                try {
                    if (fo != null) {
                        fo.close();
                        oo.close();
                    }
                } catch (IOException ex) {
                    Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    public static boolean hasDatabase() {
        try {
            Statement stmt = getConnection().createStatement();
            stmt.execute("USE " + Db.DB.dbName);
            stmt.close();
            return true;
        } catch (Exception ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public static void changeURL() {
        url = url + dbName;
        try {
            con.close();
            con = null;
        } catch (SQLException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static boolean createDatabase() {
        boolean isScriptExecuted = false;
        try {
            Statement stmt = getConnection().createStatement();
            stmt.execute("CREATE DATABASE " + dbName);
            stmt.close();
            changeURL();
            stmt = getConnection().createStatement();
            FileReader fr = new FileReader(System.getProperty("user.dir") + "/" + dbName + ".sql");
            BufferedReader br = new BufferedReader(fr);
            String line = "";
            String query = "";
            while ((line = br.readLine()) != null) {
                query += line;

                if (!line.isEmpty() && line.lastIndexOf(";") == line.length() - 1) {
                    stmt.execute(query);
                    query = "";
                }
            }
            isScriptExecuted = true;
        } catch (Exception ex) {
            isScriptExecuted = false;
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return isScriptExecuted;

    }

    public static Connection getConnection() throws Exception {

        if (con == null) {
            Class.forName(driver);
            con = DriverManager.getConnection(url, user, psw);
        }
        return con;
    }

    public static void saveData(Object obj) throws Exception {
        Statement stmt = getConnection().createStatement();
        if (obj instanceof Book) {
            Book b = (Book) obj;
            stmt.executeUpdate("INSERT INTO book "
                    + "(author1, author2, book_id, category, edition, isbn, language, publisher, series, "
                    + "summary, title, volume, add_date, price, publish_date,quantity) "
                    + "VALUES "
                    + "('" + b.author1 + "','" + b.author2 + "','" + b.bookId + "','" + b.category + "',"
                    + "'" + b.edition + "','" + b.isbn + "','" + b.language + "','" + b.publisher + "',"
                    + "'" + b.series + "','" + b.summary + "','" + b.title + "','" + b.volume + "',"
                    + " '" + new Date(b.addDate.getTime()) + "','" + b.price + "',"
                    + " '" + new Date(b.publishDate.getTime()) + "','" + b.quantity + "')");

        } else if (obj instanceof Member) {
            Member m = (Member) obj;
            stmt.executeUpdate("INSERT INTO member "
                    + "(address, email, feedback, name, tp, member_id, dob, gender, member_type, psw)"
                    + "VALUES "
                    + "('" + m.address + "','" + m.email + "', '" + m.feedBack + "','" + m.name + "','" + m.tp + "','" + m.userName + "',"
                    + "'" + new Date(m.dob.getTime()) + "','" + m.gender + "','" + m.userType + "', PASSWORD('" + m.password + "'))");

        } else if (obj instanceof Lend_Return) {
            Lend_Return l = (Lend_Return) obj;
            stmt.executeUpdate("INSERT INTO lend_return "
                    + "(member_type, member_id, book_id, lend_date, should_return_date, return_date) "
                    + "VALUES "
                    + "('" + l.memberType + "','" + l.memberId + "', '" + l.bookId + "','" + l.lendDate + "',"
                    + "'" + l.shouldReturnDate + "','" + l.returnDate + "')");
        } else if (obj instanceof Permission) {
            Permission p = (Permission) obj;
            deleteData(obj);
            for (Integer in : p.guiId) {
                stmt.executeUpdate("INSERT INTO permission VALUES ('" + p.memberType + "', '" + in + "')");
            }
        } else if (obj instanceof LendSettings) {
            LendSettings l = (LendSettings) obj;
            deleteData(obj);
            stmt.executeUpdate("INSERT INTO lend_days_fine VALUES "
                    + "('" + l.memberType + "', '" + l.lendDays + "', '" + l.maxBook + "', '" + l.fineForDay + "')");
        }
        stmt.close();
    }

    public static void updateData(Object obj) throws Exception {
        deleteData(obj);
        saveData(obj);

    }

    public static void deleteData(Object obj) throws Exception {
        Statement stmt = getConnection().createStatement();
        if (obj instanceof Book) {
            Book b = (Book) obj;
            stmt.executeUpdate("DELETE FROM book WHERE book_id='" + b.bookId + "'");

        } else if (obj instanceof Member) {
            Member m = (Member) obj;
            stmt.executeUpdate("DELETE FROM member WHERE member_type='" + m.userType + "' AND member_id='" + m.userName + "'");
        } else if (obj instanceof Lend_Return) {
            Lend_Return l = (Lend_Return) obj;
            stmt.executeUpdate("DELETE FROM lend_return WHERE member_type='" + l.memberType + "' AND member_id='" + l.memberId + "'"
                    + "AND book_id='" + l.bookId + "' AND lend_date='" + l.lendDate + "'");
        } else if (obj instanceof Permission) {
            Permission p = (Permission) obj;
            stmt.executeUpdate("DELETE FROM permission WHERE member_type='" + p.memberType + "'");
        } else if (obj instanceof LendSettings) {
            LendSettings l = (LendSettings) obj;
            stmt.executeUpdate("DELETE FROM lend_days_fine WHERE member_type='" + l.memberType + "'");
        }
    }

    public static DefaultComboBoxModel getMemberType() {
        DefaultComboBoxModel dcbm = null;
        try {
            Statement stmt = getConnection().createStatement();
            ResultSet rset = stmt.executeQuery("SELECT member_type FROM member_type");
            ArrayList<String> ast = new ArrayList<String>();
            ast.add("[Select type]");
            while (rset.next()) {
                ast.add(rset.getString(1));
            }
            dcbm = new DefaultComboBoxModel(ast.toArray());
        } catch (Exception ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dcbm;
    }
}
