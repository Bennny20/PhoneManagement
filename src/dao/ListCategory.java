package dao;

import dto.Category;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import ultis.DBUItis;

public class ListCategory {

    Vector<Category> listCategory = new Vector<Category>();

    public Vector<Category> getListCategory() {
        return listCategory;
    }

    public DefaultTableModel tableCategory() throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        DefaultTableModel dataModel = null;

        try {
            con = DBUItis.openConnection();
            if (con != null) {
                String sql = "SELECT * FROM TblCategories";

                ps = con.prepareStatement(sql);
                rs = ps.executeQuery();

                ResultSetMetaData rsmd = rs.getMetaData();
                int NumOfCol = rsmd.getColumnCount();

                Vector ColumnName = new Vector();
                for (int i = 1; i <= NumOfCol; i++) {
                    ColumnName.add(rsmd.getColumnName(i));
                }

                Vector myList = new Vector();
                while (rs.next()) {
                    Vector data = new Vector();
                    for (int i = 1; i <= NumOfCol; i++) {
                        data.add(rs.getString(i));
                    }
                    listCategory.add(new Category(rs.getString(1), rs.getString(2), rs.getString(3)));
                    myList.add(data);
                }

                dataModel = new DefaultTableModel(myList, ColumnName);
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
        return dataModel;
    }
    
    public static void setColumnOrder(int[] indices, TableColumnModel columnModel){
        TableColumn column[] = new TableColumn[indices.length];//123
        
        for (int i=0; i< column.length; i++){
            column[i]= columnModel.getColumn(indices[i]);
        }
        
        while (columnModel.getColumnCount()>0){
            columnModel.removeColumn(columnModel.getColumn(0));
        }
        for (int i=0; i< column.length; i++){
            columnModel.addColumn(column[i]);
        }
    }

    public static void setTitleOder(String[] header, JTable table) {
        for (int i = 0; i < table.getColumnCount(); i++) {
            table.getColumnModel().getColumn(i).setHeaderValue(header[i]);
        }
    }

    public boolean addCategory(Category category) throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = DBUItis.openConnection();
            if (con != null) {
                String sql = "Insert TblCategories Values(?,?,?)";

                ps = con.prepareStatement(sql);
                ps.setString(1, category.getCategoryID());
                ps.setString(2, category.getCategoryName());
                ps.setString(3, category.getDescription());
                ps.executeUpdate();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            return false;
        } finally {
            if (ps != null) {
                ps.close();
            }
            if (con != null) {
                con.close();
            }
        }
        JOptionPane.showMessageDialog(null, "Add category successful!");
        return true;
    }

    public boolean updateCategory(Category category) throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = DBUItis.openConnection();
            if (con != null) {
                String sql = "UPDATE TblCategories SET categoryName=?, description=? WHERE categoryID=?";
                ps = con.prepareStatement(sql);

                ps = con.prepareStatement(sql);
                ps.setString(1, category.getCategoryName());
                ps.setString(2, category.getDescription());
                ps.setString(3, category.getCategoryID());
                ps.executeUpdate();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            return false;
        } finally {
            if (ps != null) {
                ps.close();
            }
            if (con != null) {
                con.close();
            }
        }
        JOptionPane.showMessageDialog(null, "Update category successful!!");
        return true;
    }

    public boolean deleteCategory(Category category) throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = DBUItis.openConnection();
            if (con != null) {
                String sql = "DELETE FROM TblCategories WHERE categoryID=?";
                ps = con.prepareStatement(sql);
                ps.setString(1, category.getCategoryID());
                ps.executeUpdate();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            return false;
        } finally {
            if (ps != null) {
                ps.close();
            }
            if (con != null) {
                con.close();
            }
        }
        JOptionPane.showMessageDialog(null, "Delete category successful!");
        return true;
    }
}