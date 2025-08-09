package stack;

import java.util.Stack;

public class InfixToPostfixConversion {

    private static final char SEPARATOR = ' ';
    public static void main(String[] args) {
        String [] exps = {/*"ADFSR+B-C" , "A*B*C", "A*B+C/D" , */"1+2+3"/*, "A+B*C+D", "((A+B)-C*(D/E))+F"*/};
        String [] postfixs = {/*"ADFSR B + C -", "A B * C *", "A B * C D / +",*/ "1 2 + 3 +"/*, "A B C * + D +", "A B + C D E / * - F +"*/};
        String infixExpression;
        for(int i=0;i<exps.length;i++) {
            infixExpression = exps[i];
            String result = convertInfixToPostfix(infixExpression);
            System.out.println("infix :" + infixExpression + " to postfix :" + result + " matched :"+postfixs[i].equals(result));
        }
    }


    /*
     * Scan expression from left to right
     * if operand then add into result
     * else
     *  check precedence on stack operator(in) and current operator(out)
     * if in >= out then pop from stack until stack is empty
     *  at the end push into stack
     *
     * finally pop all the operator form stack
     *
     * */
    public static String convertInfixToPostfix(String infixExpression){
        if(infixExpression == null || infixExpression.isEmpty()){
            return infixExpression;
        }
        StringBuilder postfixExpression = new StringBuilder();
        Stack<Character> operatorStack = new Stack<>();
        char out;
        int n = infixExpression.length();
        for(int i=0;i<n;i++){
            out = infixExpression.charAt(i);
            if(isOperand(out)){
                // postfixExpression.append(out);

                //multi digit handling
                while (i < n && isOperand(infixExpression.charAt(i))) {
                    postfixExpression.append(infixExpression.charAt(i));
                    i++;
                }
                postfixExpression.append(SEPARATOR);
                i--;
            } else if(out == '('){
                operatorStack.push(out);
            } else if(out == ')'){
                while (operatorStack.peek() != '('){
                    postfixExpression.append(operatorStack.pop()).append(SEPARATOR);
                }
                operatorStack.pop();
            }
            else{
                while (!operatorStack.isEmpty() && findPrecedence(out) <= findPrecedence(operatorStack.peek())){
                    postfixExpression.append(operatorStack.pop()).append(SEPARATOR);
                }
                operatorStack.push(out);
            }
        }
        while (!operatorStack.isEmpty()){
            postfixExpression.append(operatorStack.pop()).append(SEPARATOR);;
        }

        return postfixExpression.toString().trim();
    }

    private static boolean isOperand(char out) {
        return Character.isLetter(out) || Character.isDigit(out);
    }

    /*
     * ^, * , / ,+ , -
     * */
    private static int findPrecedence(Character operator) {
        if(operator == '^'){
            return 3;
        }else if(operator == '/' || operator == '*'){
            return 2;
        }else if(operator == '+' || operator == '-'){
            return 1;
        }else{
            return -1;
        }
    }
}
