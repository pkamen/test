import java.sql.*;

public class Validate {

  public static Connection connectToOracleDB(String server, int port, String sid, String uid, String password){
    String connectStr = "jdbc:oracle:thin:@" + server + ":" + port + ":" + sid;
        
    Connection conn = null;
    try{
      DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
      conn = DriverManager.getConnection(connectStr, uid, password);
      if (conn != null){
        System.out.println("Connection successfull");
      }
    } catch (SQLException e){
      System.out.println("Connection Failed! Check output console");
      e.printStackTrace();
    }
       
    return conn;
  }
                                                                                                    
  public static boolean checkUser(String email,String pass) throws SQLException {
    boolean st =false;
    
    Connection con = connectToOracleDB("176.9.156.71", 1521, "XE", "wltp", "lsyas");
    String uid_name = "pkamen";
    String uid_pass = "lsyas";
    String query = "SELECT * FROM M_USER WHERE uid_name=? AND uid_pass=?";

    PreparedStatement ps = con.prepareStatement(query);
    ps.setString(1, uid_name);
    ps.setString(2, uid_pass);

    ResultSet rs = ps.executeQuery(query);
    st = rs.next();
    con.close();
      
    return st;                 
   }   
}
                                                                                                                                                                                                 