package dao;

import dto.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import ultis.DBUItis;

public class ListUser {

    Vector<User> listUser = new Vector<User>();

    public Vector<User> getListUser() {
        return listUser;
    }

    public void CreateListUser() throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            con = DBUItis.openConnection();
            if (con != null) {
                String sql = "SELECT * FROM TblUsers";

                ps = con.prepareStatement(sql);
                rs = ps.executeQuery();

                while (rs.next()) {
                    listUser.add(new User(rs.getString(1), rs.getString(2), rs.getString(3), rs.getBoolean(4)));
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (con != null) {
                con.close();
            }
        }
    }

    public boolean checkLogin(String userID, String password) {
        for (int i = 0; i < listUser.size(); i++) {
            if (userID.equals(listUser.get(i).getUserID()) && password.equals(listUser.get(i).getPassword())) {
                return true;
            }
        }
        return false;
    }
}
