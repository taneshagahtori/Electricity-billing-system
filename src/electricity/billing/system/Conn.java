
package electricity.billing.system;
import java.sql.*;

public class Conn {
    
    Connection c;
    Statement s;
    Conn(){
        //registers driver class
        //creating connection by giving our mysql info
        //creating statements
        //executing mysql queries
        try{
            c=DriverManager.getConnection("jdbc:mysql://localhost:3306/ebs","root","gtanesha2003");
            s=c.createStatement();
        }
        catch (Exception e){
            e.printStackTrace();
            
        }
        
    }
}
