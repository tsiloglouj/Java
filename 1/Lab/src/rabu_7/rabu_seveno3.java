
package rabu_7;
import java.sql.*;


public class rabu_seveno3 {
    
    //oracle
    static String     OdriverClassName = "oracle.jdbc.OracleDriver" ;
    static String     Ourl = "jdbc:oracle:thin:@192.168.6.21:1521:dblabs" ;
    static Connection OdbConnection = null;
    static String     Ousername = "itsilogl";
    static String     Opasswd = "l219941994";
    static Statement  Ostatement       = null;
    static ResultSet  Ors              = null;
    
    
    
    public static void main(String argsp[]) throws Exception{
        
        //oracle statement
        Class.forName (OdriverClassName);
        OdbConnection = DriverManager.getConnection (Ourl, Ousername, Opasswd);
        Ostatement    = OdbConnection.createStatement();
        
        String Oselectstring = " Select Count(DISTINCT P.athlete )  "+
                               " from Athlete A join Participates P on A.code = P.athlete "+
                               " join Games G on P.game = G.Code "+
                               " join Stadium S on S.name = G.Stadium "+
                               " where S.name = 'Olympic Stadium'";
        
        Ors = Ostatement.executeQuery(Oselectstring);
        
        System.out.println("Arithmos Athliton");
        while(Ors.next()){
            String arithmos = Ors.getString(1);
            System.out.println(arithmos);
        }
        
        /*
         (ANTI GIA TO APO PANW VAZOYME TO (AS ___)
         kai oti GOUSTAROUME KAI TO PERNAME KATW ((π.χ. τεστινγκ))
         
         String Oselectstring = " Select Count(DISTINCT P.athlete ) as TESTING  "+
                               " from Athlete A join Participates P on A.code = P.athlete "+
                               " join Games G on P.game = G.Code "+
                               " join Stadium S on S.name = G.Stadium "+
                               " where S.name = 'Olympic Stadium'";
        
        Ors = Ostatement.executeQuery(Oselectstring);
        
        System.out.println("Arithmos Athliton");
        while(Ors.next()){
            String arithmos = Ors.getString(TESTING);
            System.out.println(arithmos);
        }
         */
        
        
        Ostatement.close();
        OdbConnection.close();
        
    }
}