package ultis;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

public class DBUItis implements Serializable {

    public static Connection openConnection() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://localhost:1433; databaseName=ProductManagement";
            Connection con = DriverManager.getConnection(url, "sa", "123");
            return con;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return null;
    }
}
