import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.*;
public class ex_8_2 {
    static String     driverClassName = "org.apache.derby.jdbc.ClientDriver" ;
    static String     url = "jdbc:derby://localhost:1527/dblabs" ;
    static Connection dbConnection    = null;
    static String     username = "euclid";
    static String     passwd = "tbd2017";
    
    static PreparedStatement insertData = null;

    public static void main (String[] argv) throws Exception
    {
        Class.forName (driverClassName);
        dbConnection = DriverManager.getConnection (url, username, passwd);
        String insertString = "INSERT INTO SPONSOR VALUES (?, ?, ?)";
        insertData = dbConnection.prepareStatement(insertString);
        int par1 = 0;
        String par2 = null;
        String par3 = null;
        System.out.println("--- Insert values to Sponsor table --- ");
        BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
        while(par1 != 999) {
            System.out.print("Enter sponsor code : ");
            par1 = Integer.parseInt(keyboard.readLine());
            if (par1 != 999) {
                System.out.print("Enter sponsor name : ");
                par2 = keyboard.readLine();
                System.out.print("Enter relevant to: ");
                par3 = keyboard.readLine();
                insertData.setInt(1, par1);
                insertData.setString(2, par2);
                insertData.setString(3, par3);
                insertData.executeUpdate();
            }
        }       

        System.out.println("--- Insert values to Sponsorship table --- ");
        insertString = "INSERT INTO SPONSORSHIP VALUES (?, ?)";
        insertData = dbConnection.prepareStatement(insertString);
        int par11 = 0;
        int par12 = 0;
        while(par11 != 999) {
            System.out.print("Enter sponsor code : ");
            par11 = Integer.parseInt(keyboard.readLine());
            if (par11 != 999) {
                System.out.print("Enter athlete code : ");
                par12 = Integer.parseInt(keyboard.readLine());
                insertData.setInt(1, par11);
                insertData.setInt(2, par12);
                insertData.executeUpdate();
            }
        }
        
        insertData.close();
        dbConnection.close();
    }
}
