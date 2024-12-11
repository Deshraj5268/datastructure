package stack;

import java.util.Stack;

public class InfixToPostfixConversion {

    public static void main(String[] args) {
        String [] exps = {"A+B-C" , "A*B*C", "A*B+C/D" , "1+2+3", "A+B*C+D", "((A+B)-C*(D/E))+F"};
        String [] postfixs = {"AB+C-", "AB*C*", "AB*CD/+", "12+3+", "ABC*+D+", "AB+CDE/*-F+"};
        String infixExpression;
        for(int i=0;i<exps.length;i++) {
            infixExpression = exps[i];
            String result = convertInfixToPostfix(infixExpression);
            System.out.println("infix : " + infixExpression + " to postfix : " + result + " matched : "+postfixs[i].equals(result));
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
        for(int i=0;i<infixExpression.length();i++){
            out = infixExpression.charAt(i);
            if(isOperand(out)){
                postfixExpression.append(out);
            } else if(out == '('){
                operatorStack.push(out);
            } else if(out == ')'){
                while (operatorStack.peek() != '('){
                    postfixExpression.append(operatorStack.pop());
                }
                operatorStack.pop();
            }
            else{
                while (!operatorStack.isEmpty() && findPrecedence(out) <= findPrecedence(operatorStack.peek())){
                    postfixExpression.append(operatorStack.pop());
                }
                operatorStack.push(out);
            }
        }
        while (!operatorStack.isEmpty()){
            postfixExpression.append(operatorStack.pop());
        }

        return postfixExpression.toString();
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
