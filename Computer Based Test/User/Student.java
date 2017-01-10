package User;
import java.util.*;
import java.io.*;

public class Student extends User{

	final String ANSI_CLS = "\u001b[2J";
    final String ANSI_HOME = "\u001b[H";
	String username,password;
	HashSet<StudentCredentials> set=new HashSet<StudentCredentials>();
	int noOfQuestionsForTheTest;
	int time;
	int score;
	

	

	public Student(String username,String password,HashSet<StudentCredentials> set,int noOfQuestionsForTheTest,int time){
		this.username=username;
		this.password=password;
		this.set=set;
		this.noOfQuestionsForTheTest=noOfQuestionsForTheTest;
		boolean x=checkCredentials(this.set);
		
		if(x){
			userRules();
		}
		else{
			System.out.println("\t\tError:\n\t\t"+
				"Either You are not eligible to take the test (or) You might have entered wrong credentials.");
				System.exit(0);
			}

		score=takeTest(time);
		System.out.println(username+" Scored: "+score);
		System.out.println("\nThank You For Using PARIKSHA");
		
	}

	public void userRules(){
		System.out.println("              		*----------RULES----------*              ");
		System.out.println("		1.Don't Share your login credentials with anyone");
		System.out.println("		2.Once you Start the EXAM,Timer starts");
		System.out.println("		3.Each question has one Correct answer");
		System.out.println("		4.Final Score will be given once you exit from the test\n\n");

	}


	public boolean checkCredentials(HashSet<StudentCredentials> hashs){	

		
		boolean value=false;
		StudentCredentials a=new StudentCredentials(username,password);
		

		Iterator<StudentCredentials> i=hashs.iterator();
		StudentCredentials sc=new StudentCredentials();
		while(i.hasNext()){
			
			sc=(StudentCredentials)i.next();
			if(sc.username.equals(a.username)&&(sc.password.equals(a.password))){
				value=true;
			}
		}
	
		return value;
	}
	public int takeTest(int t){
		int temp;
		
		System.out.println("\n\t\t\tThe Timer For The Test Has Started");
		System.out.println("\n\t\t\tYou Have"+"  "+(double)t/60+"  "+"Minutes To Complete the Test");
		Reminder r=new Reminder(t+5);

		System.out.println("\nNOTE:=>\n\t1)Write the complete answer for the question,DONT simply write 'a' for optionA and so on\n\t2)Write true or false completely\n");
		try{Thread.sleep(5000);}
		catch(Exception e){}
		Scanner choice=new Scanner(System.in);
		int s=0;
		try{
			
				FileInputStream fis=new FileInputStream("Questions.txt");
				ObjectInputStream ois=new ObjectInputStream(fis);
				MakeQuestion mak=new MakeQuestion();
				int i=1;
				System.out.print(ANSI_CLS + ANSI_HOME);

				while((mak=(MakeQuestion)ois.readObject())!=null){
					if((temp=r.getTimerFlag())!=1){
						if(mak.optionA!=null&&mak.optionB!=null&&mak.optionC!=null&&mak.optionD!=null){

							System.out.println(i+")"+" "+mak.question+"\n");
							System.out.println("A)"+" "+mak.optionA);
							System.out.println("B)"+" "+mak.optionB);
							System.out.println("C)"+" "+mak.optionC);
							System.out.println("D)"+" "+mak.optionD);
							i++;
							System.out.print("\nAnswer: ");
							String answer=choice.nextLine();
							System.out.print(ANSI_CLS + ANSI_HOME);

							if(answer.equals(mak.answer)){
								s=s+(mak.mark);
							}
							System.out.println();
						}
						else{
							System.out.println(i+")"+" "+mak.question);
							i++;
							String answer=choice.nextLine();
							System.out.print(ANSI_CLS + ANSI_HOME);

							if(answer.equals(mak.answer)){
								s=s+(mak.mark);


							}
						}
					}

					else{
						System.out.println("\n\t\t\tTime Is UP");
						return s;
					}
				}
				if((mak=(MakeQuestion)ois.readObject())==null){
					return s;

				}

			
		}


		catch(Exception e){
			
		}
		
	return s;

	}
	
		

}


