package User;
import java.util.*;
import java.io.*;

public class Faculty extends User{
		
	final String ANSI_CLS = "\u001b[2J";
    final String ANSI_HOME = "\u001b[H";
	public static int noOfQuestions;
	public static int[] marksForEachQuestion;
	public static int time;
	public static HashSet<StudentCredentials> hs=new HashSet<StudentCredentials>();

	
	public Faculty(){
		userRules();
		addStudents();
		setNoOfQuestions();
		addQuestions();
		setTime();
		System.out.println("\n\t\t\tThankYou For Opting PARIKSHA TEST SUITE");

		try{Thread.sleep(4000);}
		catch(Exception e){}    
	}
	
	public void setTime(){
		Scanner t=new Scanner(System.in);
		System.out.println("\nSet Timer for the exam.(Enter Time in seconds)");
		time=t.nextInt();

	}
	
	public static int getTimeForExam(){
		return time;
	} 


	public void userRules(){
		System.out.println("              		*----------RULES----------*              ");
		System.out.println("           1.Enter the credentials of Students' who can take the test");
		System.out.println("           2.Enter number of questions");
		System.out.println("	   3.Place All the Questions along with correct option in one SINGLE LINE Separated by a comma(,) ");
		System.out.println("           4.Set marks for each question");
		System.out.println("           5.Set TIME for the exam\n");

	}
	
	public void addStudents(){
		int number_Of_Students_For_The_Test;
		
		try{
			Scanner s=new Scanner(System.in);
			Scanner s1=new Scanner(System.in);
			System.out.println();
			System.out.println("Enter number_Of_Students_For_Taking_The_Test");
			number_Of_Students_For_The_Test=s.nextInt();
			System.out.println("Set username's and password's for the Students who can take the test");
			System.out.println();
			System.out.println("Enter Username Space Separated By password To set the Credentials for the User");

			while(number_Of_Students_For_The_Test!=0){
				String[] credentials=s1.nextLine().split(" ");

				StudentCredentials c = new StudentCredentials(credentials[0],credentials[1]);
				hs.add(c);
				number_Of_Students_For_The_Test--;
			}
			
		}
		
		catch(Exception e){
			e.printStackTrace();
		} 


   }


   public void setNoOfQuestions(){
   		Scanner in=new Scanner(System.in);
   		System.out.println("Enter the Number of Questions For the Test");
   		noOfQuestions=in.nextInt();
   	}

    
    public static int getNoOfQuestions(){
   		return noOfQuestions;
   }

   
    public static HashSet<StudentCredentials> getSet(){
   		return hs;
			
	} 
	
	int count=1;

	public void addQuestions(){
		Scanner text=new Scanner(System.in);
		try{
			FileOutputStream fos=new FileOutputStream("Questions.txt");
			ObjectOutputStream oos=new ObjectOutputStream(fos);

			while(count<=noOfQuestions){
				System.out.println("\nEnter Details of Question"+" "+count);
				System.out.println("\nEnter question type~\n\n\t'mcq' for multiple choice question\t 'blank or t/f' for blanks or true/false\n");

				String y=text.nextLine();
				System.out.print(ANSI_CLS + ANSI_HOME);
				if(y.equals("mcq")){
					System.out.println("Enter the Question in the format :=> question,option1,option2,option3,option4,correct_answer,mark_for_question\n");
					String[] question=text.nextLine().split(",");

					MakeQuestion mk=new MakeQuestion(question[0],question[1],question[2],question[3],question[4],question[5],Integer.parseInt(question[6]));
					oos.writeObject(mk);
					count++;

				}
				else if(y.equals("blank")||y.equals("t/f")){
					System.out.println("Enter the Question in the format :=> question,correct_answer,mark_for_question\n");
					String[] question=text.nextLine().split(",");

					MakeQuestion mk=new MakeQuestion(question[0],question[1],Integer.parseInt(question[2]));
					oos.writeObject(mk);
					count++;

				}
				else{
					System.out.println("Enter Correct Question format");
				}

			}
			oos.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}

	}
}
