import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.*;
public class ex_8_5 {
    static String     OdriverClassName = "oracle.jdbc.OracleDriver" ;
    static String     Ourl             = "jdbc:oracle:thin:@192.168.6.21:1521:dblabs" ;
    static String     PdriverClassName = "org.postgresql.Driver" ;
    static String     Purl             = "jdbc:postgresql://dblabs.it.teithe.gr:5432/euclid" ;
    static String     JdriverClassName = "org.apache.derby.jdbc.ClientDriver" ;
    static String     Jurl = "jdbc:derby://localhost:1527/dblabs" ;      
    static String     username        = "euclid";
    static String     passwd          = "tbd2017";  

    static Connection dbConnection    = null;
    static DatabaseMetaData dbmd      = null;
    static Statement statement = null;
    static ResultSet rs = null;   
    static ResultSet rs2 = null;   
    static ResultSetMetaData rsmd     = null;

    public static void main (String[] argv) throws Exception
    {
        BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter the dbms you are using (1) for postgres (2) for oracle (3) for Java DB: ");
	int dbms = Integer.valueOf(keyboard.readLine());
        String parausername = "";
        if (dbms == 1) {
            Class.forName (PdriverClassName);
            dbConnection = DriverManager.getConnection (Purl, username, passwd);
            statement = dbConnection.createStatement();
            parausername = "euclid";
        } else if (dbms == 2) {  
            Class.forName (OdriverClassName);
            dbConnection = DriverManager.getConnection (Ourl, username, passwd) ;
            statement    = dbConnection.createStatement();
            parausername = "EUCLID";
        } else if (dbms == 3) {
            Class.forName (JdriverClassName);
            dbConnection = DriverManager.getConnection (Jurl, username, passwd) ;
            statement    = dbConnection.createStatement();    
            parausername = null;
        }
        dbmd = dbConnection.getMetaData();
        
        String [] tableTypes = { "TABLE" };
        rs = dbmd.getTables("%", parausername, "%", tableTypes);

        int tableno = 0;
         while (rs.next()) {
                 tableno++;
                 String tableName = rs.getString("TABLE_NAME");
                 System.out.println("TABLE: " + tableName);
                 String SelectString = "Select * From " + tableName;
                 rs2 = statement.executeQuery(SelectString);
                 rsmd = rs2.getMetaData();
                 
                 int numberOfColumns = rsmd.getColumnCount();
                 System.out.println("No of columns: " + numberOfColumns);
         }
         System.out.println("No of tables: " + tableno);
       
        statement.close();
        dbConnection.close();
    }
}