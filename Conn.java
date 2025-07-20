package atm.simulator.syatem;

import java.sql.*;  
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conn{
    Connection c;
    Statement s;
    Object Conn;
    public Conn(){  
        try{  
            Class.forName("com.mysql.cj.jdbc.Driver");  
            c =DriverManager.getConnection("jdbc:mysql:///atmsimulatorsyatem","root","Ankithakash@609");    
            s =c.createStatement(); 
           
          
            
        }catch(Exception e){ 
            System.out.println(e);
        }  
    } 

}