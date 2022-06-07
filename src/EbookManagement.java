import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

/**
 *
 * @author SMITHARAJINI T
 */
public class EbookManagement {
    

    /**
     * @param args the command line arguments
     */
public static void main(String[] args) throws ClassNotFoundException, SQLException {
        // TODO code application logic here
        // Load the driver Class
        Class.forName("oracle.jdbc.driver.OracleDriver");
        // Create connection object
        Connection con=DriverManager.getConnection(
                "jdbc:oracle:thin:@localhost:1521:xe", "system","welcome");
        //create the statement object
        System.out.println("connection done");
       
    }
}
