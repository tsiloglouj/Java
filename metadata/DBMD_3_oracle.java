import java.sql.*;

public class DBMD_ex3_oracle {
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
        System.out.println("στην " + dbmsName + ": ");
// Tables        
        String [] tableTypes = { "TABLE", "VIEW" };
        rs = dbmd.getTables("%", "EUCLID", "%", tableTypes);
        while (rs.next()) {
            String tableName = rs.getString("TABLE_NAME");
            String tableType = rs.getString("TABLE_TYPE");
            System.out.println(tableType+ " " + tableName + " ");
// primary keys               
            ResultSet pkrs = dbmd.getPrimaryKeys(null, "EUCLID", tableName); 
            System.out.println("Primary keys");
            while (pkrs.next()) {
                String primarykeyName = pkrs.getString("COLUMN_NAME");
                System.out.println(primarykeyName+ " ");
            }
            System.out.println(); 
//  foreign keys
            ResultSet fkrs = dbmd.getImportedKeys("", "EUCLID",tableName);
            System.out.println("Foreign keys");
            while (fkrs.next()) {
                String foreignkeyName = fkrs.getString("FKCOLUMN_NAME");
                String foreignkeytableName = fkrs.getString("PKTABLE_NAME");
                System.out.println(foreignkeyName + " " + foreignkeytableName);
            }
            System.out.println();
 
//  table columns      
            ResultSet colrs = dbmd.getColumns("%", "EUCLID", tableName, "%");
            System.out.println("Columns");
            while (colrs.next()) {
                String columnName = colrs.getString("COLUMN_NAME");
                String columnTN = colrs.getString("TYPE_NAME");
                System.out.println(columnName+ " " + " " + columnTN);
            }
            System.out.println();

        }
        dbConnection.close();
    }      
}
