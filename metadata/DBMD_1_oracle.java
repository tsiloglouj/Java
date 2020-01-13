import java.sql.*;

public class DBMD_ex1_oracle {
    static String     driverClassName = "oracle.jdbc.OracleDriver" ;
    static String     url = "jdbc:oracle:thin:@192.168.6.21:1521:dblabs" ;
    static Connection dbConnection = null;
    static String     username = "jordan";
    static String     passwd = "12345";
    static Statement  statement  = null;    
    static ResultSet rs  = null;
    static DatabaseMetaData dbmd = null;
    
    public static void main (String[] argv) throws Exception     {
        Class.forName (driverClassName);
        dbConnection = DriverManager.getConnection (url, username, passwd);
        dbmd = dbConnection.getMetaData();
        String dbmsName = dbmd.getDatabaseProductName();
        rs = dbmd.getTableTypes();
        System.out.print("Οι παρακάτω τύποι πινάκων είναι διαθέσιμοι ");
        System.out.println("στην " + dbmsName + ": ");
        while (rs.next()) {
           String tableType = rs.getString("TABLE_TYPE");
           System.out.println(" " + tableType);
        }
        dbConnection.close();
    }      
}
