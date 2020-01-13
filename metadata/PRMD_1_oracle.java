import java.sql.*;

public class PRMD_ex1_oracle  {
    static String     driverClassName = "oracle.jdbc.OracleDriver" ;
    static String     url = "jdbc:oracle:thin:@192.168.6.21:1521:dblabs" ;
    static Connection dbConnection = null;
    static String     username = "jordan";
    static String     passwd = "12345";
    static PreparedStatement  prstatement  = null;
    static ResultSet rs  = null;
    static ParameterMetaData paramInfo = null;
    
    public static void main (String[] argv) throws Exception     {
        Class.forName (driverClassName);
        dbConnection = DriverManager.getConnection (url, username, passwd);
        String updateString = "UPDATE SAILORS SET RATING = ? WHERE AGE > ? ";
        String insertString = "insert into Boats (bid, bname, color) values (?, ?, ?)";
        String selectString = "SELECT DISTINCT sname " +
                              "FROM Sailors S INNER JOIN Reserves R ON S.sid = R.sid INNER JOIN Boats b ON R.bid = B.bid " +
                              "WHERE \"B.color\" = ? ";

//         insertString
        System.out.println("-----------------");        
        System.out.println(insertString);        
        prstatement = dbConnection.prepareStatement(insertString);
        paramInfo = prstatement.getParameterMetaData();
        int NumberOfParameters = paramInfo.getParameterCount();
        System.out.println("Number of parameters: "+NumberOfParameters);
        for (int i=1;i<NumberOfParameters+1;i++) {
            String typeName = paramInfo.getParameterTypeName(i); 
            System.out.println("Type of parameters: "+typeName);         
        } 
        
//         updateString
        System.out.println(updateString);
        prstatement = dbConnection.prepareStatement(updateString);
        paramInfo = prstatement.getParameterMetaData();
        NumberOfParameters = paramInfo.getParameterCount();
        System.out.println("Number of parameters: "+NumberOfParameters);
        for (int i=1;i<NumberOfParameters+1;i++) {
            String typeName = paramInfo.getParameterTypeName(i); 
            System.out.println("Type of parameters: "+typeName);         
        }
        
//         selectString
        System.out.println("-----------------");        
        System.out.println(selectString);
        prstatement = dbConnection.prepareStatement(selectString);
        paramInfo = prstatement.getParameterMetaData();
        NumberOfParameters = paramInfo.getParameterCount();
        System.out.println("Number of parameters: "+NumberOfParameters);
        for (int i=1;i<NumberOfParameters+1;i++) {
            String typeName = paramInfo.getParameterTypeName(i); 
            System.out.println("Type of parameters: "+typeName);         
        }
        
       prstatement.close();        
       dbConnection.close();     
    }      
}
