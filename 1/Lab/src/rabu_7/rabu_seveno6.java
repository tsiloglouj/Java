
package rabu_7;

import java.sql.*;


public class rabu_seveno6 {
    
    //oracle
    static String     OdriverClassName = "oracle.jdbc.OracleDriver" ;
    static String     Ourl = "jdbc:oracle:thin:@192.168.6.21:1521:dblabs" ;
    static Connection OdbConnection = null;
    static String     Ousername = "itsilogl";
    static String     Opasswd = "l219941994";
    static Statement  Ostatement       = null;
    static ResultSet  Ors              = null;
    
    //postgres
    static String     PdriverClassName = "org.postgresql.Driver" ;
    static String     Purl             = "jdbc:postgresql://dblabs.it.teithe.gr:5432/gbarkos" ;
    static String     Pusername = "gbarkos";
    static String     Ppasswd = "eibeiN3t";
    static Connection PdbConnection    = null;
    static Statement  Pstatement       = null; 
    static ResultSet  Prs              = null;
    
    public static void main(String argsp[]) throws Exception{
        
        //oracle statement
        Class.forName (OdriverClassName);
        OdbConnection = DriverManager.getConnection (Ourl, Ousername, Opasswd);
        Ostatement    = OdbConnection.createStatement();
        
        Class.forName (PdriverClassName);
        PdbConnection = DriverManager.getConnection (Purl, Pusername, Ppasswd);
        Pstatement    = PdbConnection.createStatement();
        
        String Oselectstring = " Select DISTINCT G.code "+
                               " from Athlete A join Participates P on A.code = P.athlete "+
                               " join Games G on P.game = G.code "+
                               " join Sport S on S.code = G.sport "+
                               " where S.gender = 'Male' and G.glevel = 'Final' and S.name = '100m' ";
        
        Ors = Ostatement.executeQuery(Oselectstring);
        
        System.out.println("Name    Surname");
        
        while(Ors.next()){
            String sportcode = Ors.getString("code");
            String Pselectstring = " Select V.name, V.surname "+
                                   " from Volunteer V join Helps H on V.at = H.volunteer "+
                                   " where H.game = " + sportcode ;
            
            Prs = Pstatement.executeQuery(Pselectstring);
            
            while(Prs.next()){
                String name = Prs.getString("name");
                String sname = Prs.getString("surname");
                System.out.println(name + " " + sname);
            }
        }
        
        Ostatement.close();
        OdbConnection.close();
    }
}