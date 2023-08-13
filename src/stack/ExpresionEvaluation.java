package stack;

import java.util.Stack;

class  myString{
    String str = "raj";
}
public class ExpresionEvaluation {


    public float evaluateExp(String exp){

        return 0;
    }

    public static int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<>();
        int opr1,opr2;
        int result;
        for(String token:tokens){
            char lastChar = token.charAt(token.length()-1);
            if(lastChar >='0' && lastChar <='9'){
               stack.push(token);
            }else{
                opr2 = Integer.parseInt(stack.pop());
                opr1 = Integer.parseInt(stack.pop());

                if("*".equals(token)){
                    result = opr1*opr2;
                }else if("/".equals(token)){
                    result = opr1/opr2;
                }else if("+".equals(token)){
                    result = opr1+opr2;
                }else {
                    result = opr1-opr2;
                }
                stack.push(String.valueOf(result));
            }
        }
        return Integer.parseInt(stack.pop());
    }

    public static void main(String[] args) {

        String [] tokens = {"2","1","+","3","*"};
        System.out.println(evalRPN(tokens));
    }

    public static void doReverse(String str){


    }

}
