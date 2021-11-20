package dao;

import dto.Product;
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

public class ListProduct {

    Vector<Product> listProduct = new Vector<Product>();

    public Vector<Product> getListProduct() {
        return listProduct;
    }

    public DefaultTableModel tableProduct() throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        DefaultTableModel dataModel = null;

        try {
            con = DBUItis.openConnection();
            if (con != null) {
                String sql = "SELECT * FROM TblProducts";

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
                    listProduct.add(new Product(rs.getString(1), rs.getString(2), rs.getString(3), rs.getFloat(4), rs.getInt(5), rs.getString(6)));
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
                    
    public static void setColumnOrder(int[] indices, TableColumnModel columnModel) {
        TableColumn column[] = new TableColumn[indices.length];

        for (int i = 0; i < column.length; i++) {
            column[i] = columnModel.getColumn(indices[i]);
        }

        while (columnModel.getColumnCount() > 0) {
            columnModel.removeColumn(columnModel.getColumn(0));
        }

        for (int i = 0; i < column.length; i++) {
            columnModel.addColumn(column[i]);
        }
    }

    public static void setTitleOder(String[] header, JTable table) {
        for (int i = 0; i < table.getColumnCount(); i++) {
            table.getColumnModel().getColumn(i).setHeaderValue(header[i]);
        }
    }

    public boolean addProduct(Product product) throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = DBUItis.openConnection();
            if (con != null) {
                String sql = "Insert TblProducts Values(?,?,?,?,?,?)";

                ps = con.prepareStatement(sql);
                ps.setString(1, product.getProductID());
                ps.setString(2, product.getProductName());
                ps.setString(3, product.getUnit());
                ps.setFloat(4, product.getPrice());
                ps.setInt(5, product.getQuantity());
                ps.setString(6, product.getCategoryid());
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
        JOptionPane.showMessageDialog(null, "Add product successful!");
        return true;
    }

    public boolean updateProduct(Product product) throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = DBUItis.openConnection();
            if (con != null) {
                String sql = "UPDATE TblProducts SET productName=?, unit=?, price=?, quantity=?, categoryid=? WHERE productID=?";
                ps = con.prepareStatement(sql);

                ps = con.prepareStatement(sql);
                ps.setString(1, product.getProductName());
                ps.setString(2, product.getUnit());
                ps.setFloat(3, product.getPrice());
                ps.setInt(4, product.getQuantity());
                ps.setString(5, product.getCategoryid());
                ps.setString(6, product.getProductID());
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
        JOptionPane.showMessageDialog(null, "Update product successful!!");
        return true;
    }

    public boolean deleteProduct(Product product) throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = DBUItis.openConnection();
            if (con != null) {
                String sql = "DELETE FROM TblProducts WHERE productID=?";
                ps = con.prepareStatement(sql);
                ps.setString(1, product.getProductID());
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
        JOptionPane.showMessageDialog(null, "Delete product successful!");
        return true;
    }
}
