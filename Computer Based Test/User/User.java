
package User;
import java.util.*;
import java.io.*;

public abstract class User{
	static public String userName;
	static public char[] password;
	static public String pass_word;
	
	public static void enterCredentials(){
		Scanner s=new Scanner(System.in);
		Console console=System.console();
		System.out.print("UserName: ");
		userName=s.nextLine();
		System.out.println();
		password=console.readPassword("Password: ");
		pass_word=new String(password);

	}
	abstract public void userRules();
	
}


