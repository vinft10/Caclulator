import java.util.Arrays;
import java.util.Stack;

public class Calculate {

    public String postfix(String exp, int expSize){

       
        Stack<Character> stack = new Stack<Character>();
        
        String output = new String();
        
        
        for(int i = 0; i < expSize; i ++)
        {
        	if(isOperand(exp.charAt(i)))
        	{
        		while(i < expSize && !isOperator(exp.charAt(i))){
        			output += exp.charAt(i);
        			i++;
        		}
        		output += '$';
        		i--;
        	}
        	else if(isOperator(exp.charAt(i)))
        	{
        				while(!stack.isEmpty() && higherPrec(exp.charAt(i),stack.peek()))
        				{
        					if(stack.peek() != '(')
        					{
        						output += stack.pop();
        					}else{
        						stack.pop();
        						break;
        					}
        					
        				}   
        				if(exp.charAt(i) != ')')
        				{	
        					if(exp.charAt(i) == '(' &&  i >= 1 &&isOperand(exp.charAt(i-1)))
        					{
        						stack.push('*');
        					}
        					stack.push(exp.charAt(i));		
        					
        				}
        	}
        }
        while(!stack.isEmpty())
        {
        	output += stack.pop();
        }
 
        return output;
        
    }
    public float result(String post, int postSize){
    	
    	Stack<Float> stack = new Stack<Float>();
    	Functions func = new Functions();
    	String string = "";
    	
    	for(int i = 0; i < postSize; i++)
    	{
    		if(isOperand(post.charAt(i)))
    		{
    			while(post.charAt(i) != '$'){
    			string = string + post.charAt(i);
    			i++;
    			}
    			i--;
    			stack.push(Float.parseFloat(string));
    			string = "";
    	
    		}
    		else if(isOperator(post.charAt(i)) && i >= 2)
    		{
    			float y = stack.pop();
    			float x = stack.pop();
    			if(post.charAt(i) == '+')
    			{
        			stack.push((func.add(x,y)));
    			}
    			if(post.charAt(i)  == '-')
    			{
        			stack.push((func.sub(x,y)));
    			}
    			if(post.charAt(i)  == '*')
    			{
        			stack.push((func.mult(x,y)));
    			}
    			if(post.charAt(i)  == '/')
    			{
        			stack.push((func.div(x,y)));
    			}
    		}
    	}
    	while(stack.size() >=2)
    	{
    		float y = stack.pop();
			float x = stack.pop();
			stack.push((func.mult(x,y)));
    	}
    	
    	if(!stack.empty()){
    		return stack.pop();
    	}
    	else{
    		return 0;
    	}
    }
    
    public boolean isOperator(char x){
    	
        	switch (x) 
        	{
    			case '(':
        			return true;
    			case ')':
    				return true;
        		case '+':
        			return true;
        		case '-':
        			return true;
        		case '*':
        			return true;
        		case '/':
        			return true;
        		case '^':
        			return true;
        		default:
        			return false;
        	}
    }
    public boolean isOperand(char x){
    	
    	switch (x) 
    	{
    		case '0':
    			return true;
    		case '1':
    			return true;
    		case '2':
    			return true;
    		case '3':
    			return true;
    		case '4':
    			return true;
    		case '5':
    			return true;
    		case '6':
    			return true;
    		case '7':
    			return true;
    		case '8':
    			return true;
    		case '9':
    			return true;
    		default:
    			return false;
    	}
}
public boolean higherPrec(char exp, char peek){
    	
    	switch (exp) 
    	{
    		case '(':	
    				return false;	
    		case ')':
    				return true;
    		case '^':
    			if(peek == '*')
    			{
        			return false;
    			}else{
    				return true;
    			}
    				
    		case '*':
    			if(peek == '^' ||  peek == '/' || peek == '*')
    			{
    				return true;
    			}else{
        			return false;
    			}
    		case '/':
    			if(peek == '^' ||  peek == '*' || peek == '/')
    			{
    				return true;
    			}else{
        			return false;
    			}    		
    		case '+':
    			if(peek == '^' || peek == '*' || peek == '/' || peek == '-' || peek == '+')
    			{
    				return true;
    			}else{
        			return false;
    			}
    		case '-':
    			if(peek == '^' || peek == '*' || peek == '/' || peek == '+' || peek == '-')
    			{
    				return true;
    			}else{
        			return false;
    			}
    		default:
    				return false;
    		
    			     		
    	}
}

    


}

