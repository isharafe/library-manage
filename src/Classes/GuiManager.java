package Classes;

import gui.BookNew;
import gui.BookSearch;
import gui.ManageBooksLend;
import gui.ManageBooksReturn;
import gui.MemberNew;
import gui.MemberSearch;
import gui.Settings;
import gui.SettingsAdmin;
import gui.SettingsLend;
import gui.SettingsPassword;
import javax.swing.DefaultComboBoxModel;

public class GuiManager {

    public static int ADD_MEMBERS = 11;
    public static int SEARCH_MEMBERS = 12;
    public static int ENABLE_CHANGE_MEMBERS_DATA = 16;
    public static int ADD_BOOKS = 21;
    public static int SEARCH_BOOKS = 22;
    public static int ENABLE_CHANGE_BOOKS_DATA = 26;
    public static int LEND_BOOKS = 31;
    public static int RECEIVE_BOOKS = 32;
    public static int USER_ACCOUNTS = 41;
    public static int MANAGE_LEND_BOOK_OPTIONS = 42;
    public static int GIVE_PERMISSIONS_TO_OTHER_USERS = 43;
    public static int LOGIN_WITHOUT_USERNAME = 51;
    
    //////////////////////////////////////////////////////////////
    public static BookNew bn;
    public static BookSearch bs;
    public static ManageBooksLend mbl;
    public static ManageBooksReturn mbr;
    public static MemberNew mn;
    public static MemberSearch ms;
    public static Settings s;
    public static SettingsAdmin sa;
    public static SettingsLend sl;
    public static SettingsPassword sp;

    public static void refreshMemberType() {
        DefaultComboBoxModel dcbm = Db.DB.getMemberType();
        if (mbl != null) {
            mbl.cmbLendMemberType.setModel(dcbm);
        }
        if (mbr != null) {
            mbr.cmbReturnMemberType.setModel(dcbm);
        }
        if (mn != null) {
            mn.cmbMemberType.setModel(dcbm);
        }
        if (ms != null) {
            ms.cmbMemberType.setModel(dcbm);
        }
        if (sa != null) {
            sa.cmbMemberType.setModel(dcbm);
        }
        if (sl != null) {
            sl.cmbMemberType.setModel(dcbm);
        }
        if (sp != null) {
            sp.cmbMemberType1.setModel(dcbm);
            sp.cmbMemberType2.setModel(dcbm);
            sp.cmbMemberType3.setModel(dcbm);
            sp.cmbMemberType4.setModel(dcbm);
        }
    }
}
