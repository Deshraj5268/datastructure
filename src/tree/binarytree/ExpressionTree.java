package tree.binarytree;

import java.util.Stack;

public class ExpressionTree {

    public static void main(String[] args) {
        String postfix = "ABC*+D/";
        ExpressionBTNode root = constructExpressionTree(postfix);
        expressionPreOrder(root);
    }

    private static void expressionPreOrder(ExpressionBTNode root) {
        if(root != null){
            expressionPreOrder(root.left);
            System.out.print(root.data +" ");
            expressionPreOrder(root.right);
        }
    }


    /*
    * operand push it to stack
    * if operator pop into right and second element in rightNode and form root with current character
    *  then push it to stack
    * */
    public static ExpressionBTNode constructExpressionTree(String postfix){
        if(postfix == null){
            return null;
        }
        Stack<ExpressionBTNode> stack = new Stack<>();
        ExpressionBTNode newNode;
        char ch;
        for(int i=0;i<postfix.length();i++){
            ch = postfix.charAt(i);
            if(!isOperator(ch)){
                newNode = new ExpressionBTNode(ch);
                stack.push(newNode);
            }else{
                ExpressionBTNode right = stack.pop();
                ExpressionBTNode left = stack.pop();
                newNode = new ExpressionBTNode(ch,left,right);
                stack.push(newNode);
            }
        }
        return stack.pop();
    }

    private static boolean isOperator(char ch) {
        return (ch == '*' || ch == '/' || ch == '+' || ch == '-');
    }
}
