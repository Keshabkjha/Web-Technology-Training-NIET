import java.sql.*;

class Myjdbc
{

 Connection con;
 Statement s;
 Myjdbc(){
   try{
        Class.forName("com.mysql.jdbc.Driver");
        con=DriverManager.getConnection("jdbc:mysql://localhost:3306/aaravdb","root","aarav");
        s=con.createStatement();
        s.execute("create table employee(ename varchar(20), salary varchar(20))");
        System.out.println("Table created");
      }

  catch(Exception  e)
  {
   System.out.println(e);
  }
 } 
}
class InsertTable
{
	Statement s;
	Connection c;
	InsertTable()
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			c=DriverManager.getConnection("jdbc:mysql://localhost:3306/aaravdb","root","aarav");  //test1 is dbname,   root is dbusername and dbpassword
			s=c.createStatement(); 
                        String str="insert into employee values('jaykumar','15000')";
                        //String str="insert into employee values('Ravi','20000')";
                         //String str="insert into employee values('Pawan','22000')";
                          //String str="insert into employee values('sachin','28000')";
			s.executeUpdate(str);
			System.out.println("Record Inserted Successfully!!!");
				
		}

		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	
}
public class insert_record
{
 public static void main(String[] str)
 {
    InsertTable obj = new InsertTable();
 }
}
