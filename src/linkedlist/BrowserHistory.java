package linkedlist;

import java.util.Stack;

public class BrowserHistory {

    Stack<String> backwardHistory = new Stack<>();
    Stack<String> forwardHistory = new Stack<>();

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
        backwardHistory.push(homepage);
    }

    public void visit(String url) {
        while(!forwardHistory.isEmpty()){
            forwardHistory.pop();
        }
        backwardHistory.push(url);
    }

    public String back(int steps) {

        while(steps != 0 && backwardHistory.size() > 1){
            forwardHistory.push(backwardHistory.pop());
            steps--;
        }

        return backwardHistory.peek();
    }

    public String forward(int steps) {
        while(steps != 0 && !forwardHistory.isEmpty()){
            steps--;
            backwardHistory.push(forwardHistory.pop());
        }

        return backwardHistory.peek();
    }
}

