import java.sql.*;

public class Myjdbc
{
	public static void main(String[] arg)
	{
		try
		{
		Connection con;
		Statement s;
		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/aaravdb","root","aarav");
		s = con.createStatement();
		s.execute("create table address(ename char(20), address varchar(35))");
		System.out.println("Table is created");
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}