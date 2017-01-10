package User;
import java.util.*;
import java.io.*;
public class StudentCredentials implements Serializable{
	public String username,password;
	public StudentCredentials(){
		
	}
	public StudentCredentials(String a,String b){
		this.username=a;
		this.password=b;

	}

}