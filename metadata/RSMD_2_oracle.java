import java.sql.*;

public class RSMD_ex2_oracle {
    static String     driverClassName = "oracle.jdbc.OracleDriver" ;
    static String     url = "jdbc:oracle:thin:@192.168.6.21:1521:dblabs" ;
    static Connection dbConnection = null;
    static String     username = "jordan";
    static String     passwd = "12345";
    static Statement  statement  = null;
    static ResultSet rs  = null;

    public static void main (String[] argv) throws Exception     {
        Class.forName (driverClassName);
        dbConnection = DriverManager.getConnection (url, username, passwd);
        statement    = dbConnection.createStatement();
        
        String selectString = "select * From Sailors ";
        rs = statement.executeQuery(selectString);
        ResultSetMetaData rsmd = rs.getMetaData();
        
        int numberOfColumns = rsmd.getColumnCount();
        System.out.println("Number of columns: " + numberOfColumns);

        for (int i=1; i <= numberOfColumns; i++) {
            String label = rsmd.getColumnLabel(i);
            int jdbcType = rsmd.getColumnType(i);
            String DbmsType = rsmd.getColumnTypeName(i);
            String Typeclassname = rsmd.getColumnClassName(i);
            System.out.print("Η "+i+ "η στήλη με όνομα " + label);
            System.out.print(" έχει JDBC τύπο " + jdbcType);
            System.out.print(", DBMS τύπο " + DbmsType);
            System.out.println(", ο οποίος έχει classtype " + Typeclassname);
        }
        statement.close();
        dbConnection.close();
    }
}
