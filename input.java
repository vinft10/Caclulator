
public class input {

	public static void main(String[] args)  {
		Calculate calc = new Calculate();
		Functions func = new Functions();
		
		
		String expression = ("12+.2");
		func.printExp(expression);
		System.out.print('=');
        
		expression = calc.postfix(expression,expression.length());

		func.printExp(expression);
		System.out.print('=');


		
		float c = calc.result(expression, expression.length());
		System.out.print(c);

		

	}

}
