package Debugging;

public class DebugginPractise1 {

	public static int addi(int a , int b)
	{
		int c=a+b;// 10+20 = 30
		//return c;// val, var, expres,,   obj, arr
//		return 10;
//		return c;
		return c;// last stmt inside methdo
		// we cannot execute it throws  some error if we write stmts after return stmt
//		return 10;
//		System.out.println("after return ");
		//Unreachable code
	}
	
	// break pt:   insert break pt;   break progr execution
	// Step into -- always line by line execution -whethe it is simple stmt or any method
	// step over --   executes all stmts inside mthod and it gets stopped in the next line
	// step return --- used to come out of the   method  and it gets stopped in next line(we should be inside method)
	
	//  where can w see varaible 
	// how Can I see specifi var
	// vars, Expressions
	
	// check these options:  Resume, suspend, Teminate
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String s1="Rama";		
		String s2 = "Sita";
		
		System.out.println("s1="+s1);
		System.out.println("s2="+s2);
	
		int a=10,b=20;
		int res= addi(a,b);
		System.out.println("res="+res);
		
		

	}

}
