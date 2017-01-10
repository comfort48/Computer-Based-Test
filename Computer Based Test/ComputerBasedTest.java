import User.*;
import java.util.*;
import java.io.*;

abstract class ComputerBasedTest {
	public static void main(String[] args){

		final String ANSI_CLS = "\u001b[2J";
        final String ANSI_HOME = "\u001b[H";
       
		boolean testIsReady=false;
		System.out.print(ANSI_CLS + ANSI_HOME);
		System.out.println("                   \t\t\t\tWELCOME TO THE ONLINE TEST SUITE-PARIKSHA\n");
		System.out.println("\nEnter ~ \n 	1 for Faculty Login | 2 for Student Login\n");
		Scanner in=new Scanner(System.in);
		int choice=in.nextInt();
		if(choice==2){
			System.out.println("				Sorry The Test is not YET set 	\n	");
			System.out.println(" 		{~~~~~~ Please Contact your Faculty for More Details ~~~~~~}\n  ");

		}
		else if(choice==1){
			
			System.out.println("Enter Faculty Credentials\n");
			User.enterCredentials();
			if((User.userName).equals("faculty")&&(User.pass_word).equals("faculty")){
				Faculty fac=new Faculty();
				testIsReady=true;
				 System.out.print(ANSI_CLS + ANSI_HOME);
        		 
			}
			else{
				System.out.println("                    Incorrect Login      \n");
			}
		}
		else{
			System.out.println("           		Sorry You are Not Allowed to Enter This EXAM SUITE\n");
			System.out.println("           		Please ComeBack after resolving your ISSUE\n");
		}
			

			HashSet<StudentCredentials> h=Faculty.getSet();
			int noOfQuestionsForTheTest=Faculty.getNoOfQuestions();
			int time=Faculty.getTimeForExam();

			
			
			
			
			if(testIsReady){
				System.out.println("Students can Login to take the test\n");
				System.out.println();
				System.out.print("Enter Students' ");

				User.enterCredentials();

				Student stu=new Student(User.userName,User.pass_word,h,noOfQuestionsForTheTest,time);

			}
			

	} 	
}