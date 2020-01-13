import java.sql.*;

public class ex_8_4_oracle {
    static String     driverClassName = "oracle.jdbc.OracleDriver" ;
    static String     url             = "jdbc:oracle:thin:@192.168.6.21:1521:dblabs" ;
    static String     username = "EUCLID";
    static String     passwd = "tbd2017";  
    static Connection dbConnection    = null;
    static Statement  statement = null;
    static ResultSet  rs = null;
    static ResultSet  rs2 = null;   
    static ResultSetMetaData rsmd     = null;
    static DatabaseMetaData dbmd      = null;

    public static void main (String[] argv) throws Exception
    {
        Class.forName (driverClassName);
        dbConnection = DriverManager.getConnection (url, username, passwd); ;
        statement    = dbConnection.createStatement();
        dbmd = dbConnection.getMetaData();
        String dbmsName = dbmd.getDatabaseProductName();
        System.out.println("DBMS: " + dbmsName);
        String [] tableTypes = { "TABLE" };
        rs = dbmd.getTables("%", username, "%", tableTypes);
        
         while (rs.next()) {
                     System.out.println("TABLES");

                 String tableName = rs.getString("TABLE_NAME");
                 System.out.println("TABLE: " + tableName);
                 String SelectString = "Select * From " + tableName;
                 rs2 = statement.executeQuery(SelectString);
                 rsmd = rs2.getMetaData();
                 
                 int numberOfColumns = rsmd.getColumnCount();
                    for (int i = 1; i<= numberOfColumns; i++){
                       String columnName = rsmd.getColumnLabel(i);
                       System.out.print(columnName+ "     "); 
                    }
                System.out.println(); 

                 
                    while (rs2.next()) {
                       for (int i = 1; i<= numberOfColumns; i++){
                          String columndata = rs2.getString(i);
                          System.out.print(columndata+ "     "); 
                       }
                          System.out.println(); 
                    }
         }
        statement.close();
        dbConnection.close();
    }
}
