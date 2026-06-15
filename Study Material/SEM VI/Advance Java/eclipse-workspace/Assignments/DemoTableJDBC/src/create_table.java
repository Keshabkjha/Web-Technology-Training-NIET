import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

class Myjdbc
{

 Connection con;
 Statement s;
 Myjdbc(){
   try{
        Class.forName("com.mysql.jdbc.Driver");
        con=DriverManager.getConnection("jdbc:mysql://localhost:3306/aaravdb","root","aarav");
        s=con.createStatement();
        s.execute("create table employee1(ename varchar(20), salary varchar(20))");
        System.out.println("Table created");
      }

  catch(Exception  e)
  {
   System.out.println(e);
  }
 } 
}
public class create_table
{
 public static void main(String[] str)
 {
 Myjdbc obj=new Myjdbc();
 
 }
}