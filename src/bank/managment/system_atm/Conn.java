package bank.managment.system_atm;

import java.sql.*;

public class Conn {
    Connection c;
    Statement s;
    public Conn(){
        try{
            class.forName(com.mysql.cj.jdbc.Driver);
            c=DriverManager.getConnection("jdbc:mysql:///bankmanagmentsystem", "root", "mysql@1011");
            s=c.createStatement();
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
