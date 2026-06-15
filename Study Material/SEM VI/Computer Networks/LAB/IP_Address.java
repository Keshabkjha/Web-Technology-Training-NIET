import java.net.*;
import java.io.*;
import java.util.*;
import java.net.InetAddress;

public class IP_Address
{
	public static void main(String args[]) throws Exception
	{
		// Returns the instance of InetAddress containing
		// local host name and address
		InetAddress localhost = InetAddress.getLocalHost();
		System.out.println("System IP Address : " +
					(localhost.getHostAddress()).trim());

		
		String systemipaddress = "";
		try
		{
			URL url_name = new URL("http://bot.whatismyipaddress.com");

			BufferedReader sc = new BufferedReader(new InputStreamReader(url_name.openStream()));

			// reads system IPAddress
			systemipaddress = sc.readLine().trim();
		}
		catch (Exception e)
		{
			systemipaddress = "Cannot Execute Properly";
		}
	}
}
