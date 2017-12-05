
/**
 * Created by Vinny on 10/31/17.
 */
public class Functions  {

    public float add(float x, float y){
    	float sum = x + y; 
        return sum;
    }
    public float mult(float x, float y){
    	float prod = x * y;
        return prod;
    }
    public float div(float x, float y){        
    	float quo = x / y;

        return quo;

    }
    public float sub(float x, float y){
        float sub = x - y;
        return sub;

    }
    
    public void printExp(String exp){
    	for(int i = 0; i < exp.length();i++){
    		if(exp.charAt(i) != 'a')
    		{
    			System.out.print(exp.charAt(i));
    		}
    	}
    }
    
    public float charToInt(char x){
    	float y = (char) (x - 48);
    	return y;
    }
    public char intToChar(int x){
    	char y = Character.forDigit(x, 10);
    	
    	return y;
    }

}
