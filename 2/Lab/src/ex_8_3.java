import java.sql.*;
public class ex_8_3 {
    static String     JdriverClassName = "org.apache.derby.jdbc.ClientDriver" ;
    static String     Jurl = "jdbc:derby://localhost:1527/dblabs" ;
    static Connection JdbConnection    = null;
    static String     Jusername = "euclid";
    static String     Jpasswd = "tbd2017";
    static Statement  Jstatement = null;
    static ResultSet  Jrs              = null;

    static String     OdriverClassName = "oracle.jdbc.OracleDriver" ;
    static String     Ourl             = "jdbc:oracle:thin:@192.168.6.21:1521:dblabs" ;
    static Connection OdbConnection    = null;
    static String     Ousername = "euclid";
    static String     Opasswd = "tbd2017";
    static Statement  Ostatement = null;
    static ResultSet  Ors = null;   

    public static void main (String[] argv) throws Exception
    {
     Class.forName (JdriverClassName);
        JdbConnection = DriverManager.getConnection (Jurl, Jusername, Jpasswd);
        Jstatement    = JdbConnection.createStatement();
        
        Class.forName (OdriverClassName);
        OdbConnection = DriverManager.getConnection (Ourl, Ousername, Opasswd);
        Ostatement    = OdbConnection.createStatement();
        
        String OselectString = "SELECT a.code, a.surname " +
                "FROM athlete a, participates p, games g, sport s " +
                "WHERE a.code = p.athlete AND p.game = g.code AND g.sport = s.code AND " +
                "s.gender = 'Male' AND g.glevel = 'Final' AND s.name = '100m' AND " +
                "p.performance = (SELECT min(p2.performance) " +
                                 "FROM participates p2, sport s2, games g2 " +
                                 "WHERE g2.code = p2.game AND g2.sport = s2.code AND " +
                                       "g2.glevel = 'Final' AND s2.name = '100m')";
      
    try {
        Ors = Ostatement.executeQuery(OselectString);
        while(Ors.next()) {
            String acode = Ors.getString("code");
            String JselectString = "SELECT S.name, S.about " +
                                   "FROM SPONSOR S, sponsorship SP " +
                                   "WHERE S.code = SP.sponsorcode AND "   + 
                                         "SP.acode = " + acode; 
            Jrs = Jstatement.executeQuery(JselectString);
            while(Jrs.next()) {
                String name = Jrs.getString("name");
                String about = Jrs.getString("about");
                System.out.println( name + " " + about );                
            }          
            System.out.println();
        }
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
        Ostatement.close();
        OdbConnection.close();        
        Jstatement.close();
        JdbConnection.close();
    }
}