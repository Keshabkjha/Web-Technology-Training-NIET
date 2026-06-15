import java.sql.*;

class ShowTable
{       Statement stmt;
	Connection con;
	ShowTable()
	{
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/aaravdb","root","aarav");  //test1 is dbname,   root is dbusername and dbpassword
			
			 stmt=con.createStatement();  
			ResultSet rs=stmt.executeQuery("select * from employee"); 
                        System.out.println("****ADDRESS TABLE*****"); 
			while(rs.next())  
			System.out.println(rs.getString(1)+"   "+rs.getString(2));  
			con.close();	
		}

		catch(Exception e)
		{
			e.printStackTrace();
		}
         }
}

public class read_query
{
 public static void main(String[] str)
 {
     ShowTable obj =new ShowTable();
 }
}
