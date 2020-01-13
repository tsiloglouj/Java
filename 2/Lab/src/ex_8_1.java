import java.sql.*;

public class ex_8_1 {
    static String     driverClassName = "org.apache.derby.jdbc.ClientDriver" ;
    static String     url = "jdbc:derby://localhost:1527/dblabs" ;
    static Connection dbConnection    = null;
    static String     username = "euclid";
    static String     passwd = "tbd2017";
    static Statement statement = null;

    public static void main (String[] argv) throws Exception
    {
        Class.forName (driverClassName);
        dbConnection = DriverManager.getConnection (url, username, passwd);
        statement = dbConnection.createStatement();
        try {
            statement.executeUpdate("DROP TABLE SPONSORSHIP");
            statement.executeUpdate("DROP TABLE SPONSOR");
        } catch(SQLException ex) {
            System.out.println("\n -- SQL Exception --- \n");
            while(ex != null) {
		System.out.println("Message: " + ex.getMessage());
		System.out.println("SQLState: " + ex.getSQLState());
		System.out.println("ErrorCode: " + ex.getErrorCode());
		ex = ex.getNextException();
		System.out.println("");
            }
        }
        try {
        statement.executeUpdate("CREATE TABLE SPONSOR("+
                                "code int not null primary key,"+
                                "name varchar(10),"+
                                "about varchar(10))");
        statement.executeUpdate("CREATE TABLE SPONSORSHIP("+
                                "sponsorcode int not null references sponsor(code),"+
                                "acode int not null, "+ 
                                "primary key(sponsorcode,acode))");
        } catch(SQLException exc) {
            System.out.println("\n -- SQL Exception --- \n");
            while(exc != null) {
		System.out.println("Message: " + exc.getMessage());
		System.out.println("SQLState: " + exc.getSQLState());
		System.out.println("ErrorCode: " + exc.getErrorCode());
		exc = exc.getNextException();
		System.out.println("");
            }
        }
        statement.close();
        dbConnection.close();
    }
}
