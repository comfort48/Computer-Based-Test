package User;
import java.util.*;
import java.io.*;
public class MakeQuestion implements Serializable{
	public String question,optionA,optionB,optionC,optionD,answer;
	int mark;
	MakeQuestion(){

	}
	MakeQuestion(String question,String optionA,String optionB,String optionC,String optionD,String answer,int mark){
		this.question=question;
		this.optionA=optionA;
		this.optionB=optionB;
		this.optionC=optionC;
		this.optionD=optionD;
		this.answer=answer;
		this.mark=mark;
	}
	MakeQuestion(String question,String answer,int mark){
		this.question=question;
		this.answer=answer;
		this.mark=mark;
	}
}