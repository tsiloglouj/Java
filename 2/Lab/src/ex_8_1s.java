import java.sql.*;

public class ex_8_1s {
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

        statement.executeUpdate("CREATE TABLE SPONSOR("+
                                "code int not null primary key,"+
                                "name varchar(10),"+
                                "about varchar(10))");
        statement.executeUpdate("CREATE TABLE SPONSORSHIP("+
                                "sponsorcode int not null references sponsor(code),"+
                                "acode int not null, "+ 
                                "primary key(sponsorcode,acode))");

        statement.close();
        dbConnection.close();
    }
}
