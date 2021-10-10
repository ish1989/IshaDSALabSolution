package dataStructurelabSolution;

import java.util.Scanner;
import java.util.Stack;

public class BalancedBracket 

{
	static boolean checkExpression(String expression)
	{
		char value;
		
		Stack<Character> stack=new Stack<Character>();
		
		for(int i =0;i<expression.length();i++)
		{
			char ch=expression.charAt(i);

			if(ch=='('||ch=='{'||ch=='[')
			{
				stack.push(ch);
			}



			switch(ch)
			{
			case ')': value=stack.pop();
			          if(value=='{' || value=='[')
			       	  return false;
			          break;

			case ']': value=stack.pop();
			          if(value=='(' || value=='{')
				      return false;
			          break;

			case '}': value=stack.pop();
			          if(value=='(' || value=='[')
				      return false;
			          break;



			}

		}

		return (stack.isEmpty());

	}


	public static void main(String arg[])
	{
		System.out.println("Enter the expression");
		Scanner sc=new Scanner(System.in);
		String expression=sc.next();
		if(checkExpression(expression))
		{
			System.out.println("Expresssion is Balanced");
		}
		else
			System.out.println("Expression is Unbalanced");

		sc.close();
	}

}

