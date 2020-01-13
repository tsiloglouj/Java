
package rabu_7;

import java.sql.*;


public class rabu_seveno2 {
    
    //oracle
    static String     OdriverClassName = "oracle.jdbc.OracleDriver" ;
    static String     Ourl = "jdbc:oracle:thin:@192.168.6.21:1521:dblabs" ;
    static Connection OdbConnection = null;
    static String     Ousername = "itsilogl";
    static String     Opasswd = "l219941994";
    static Statement  Ostatement       = null;
    static ResultSet  Ors              = null;
    
    /*postgres
    static String     PdriverClassName = "org.postgresql.Driver" ;
    static String     Purl             = "jdbc:postgresql://dblabs.it.teithe.gr:5432/gbarkos" ;
    static String     Pusername = "gbarkos";
    static String     Ppasswd = "eibeiN3t";
    static Connection PdbConnection    = null;
    static Statement  Pstatement       = null; */
    
    public static void main(String argsp[]) throws Exception{
        
        //oracle statement
        Class.forName (OdriverClassName);
        OdbConnection = DriverManager.getConnection (Ourl, Ousername, Opasswd);
        Ostatement    = OdbConnection.createStatement();
        
        String Oselectstring = " Select A.name, A.surname, S.name as sportname"+
                               " from Athlete A join Participates P on A.code = P.athlete "+
                               " join Games G on P.game = G.code "+
                               " join Sport S on S.code = G.sport "+
                               " where G.glevel = 'Final' ";
        
        Ors = Ostatement.executeQuery(Oselectstring);
        
        System.out.println("Name    Surname   Sport");
        while(Ors.next()){
            String name = Ors.getString("name");
            String sname = Ors.getString("surname");
            String sport = Ors.getString("sportname");
            System.out.println(name + " " + sname + " " + sport);
        }
        Ostatement.close();
        OdbConnection.close();
    
    }
}