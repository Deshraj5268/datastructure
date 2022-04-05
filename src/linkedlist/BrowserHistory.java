package linkedlist;

import java.util.Stack;

public class BrowserHistory {

    Stack<String> stack1 = new Stack<>();
    Stack<String> stack2 = new Stack<>();

    /*
    * using two stack
    *  backwardStack (s1)
    *  forwardStack (s2)
    *
    * */

    public static void main(String[] args) {

        String homepage ="leetcode.com";
        BrowserHistory obj = new BrowserHistory(homepage);
        obj.visit("google.com");
        obj.visit("facebook.com");
        obj.visit("youtube.com");
        System.out.println(obj.back(1));
        System.out.println(obj.back(1));
        System.out.println(obj.forward(1));
        obj.visit("linkedin.com");
        System.out.println(obj.forward(2));
        System.out.println(obj.back(2));
        System.out.println(obj.back(2));
    }


    public BrowserHistory(String homepage) {
        stack1.push(homepage);
    }

    public void visit(String url) {
        while(!stack2.isEmpty()){
            stack2.pop();
        }
        stack1.push(url);
    }

    public String back(int steps) {

        while(steps != 0 && stack1.size() > 1){
            stack2.push(stack1.pop());
            steps--;
        }

        return stack1.peek();
    }

    public String forward(int steps) {
        while(steps != 0 && !stack2.isEmpty()){
            steps--;
            stack1.push(stack2.pop());
        }

        return stack1.peek();
    }
}

