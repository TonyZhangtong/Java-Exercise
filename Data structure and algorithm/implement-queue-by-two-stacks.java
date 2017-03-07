/*
@Copyright:LintCode
@Author:   tong12
@Problem:  http://www.lintcode.com/problem/implement-queue-by-two-stacks
@Language: Java
@Datetime: 17-02-08 22:00
*/

public class Queue {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public Queue() {
       // do initialization if necessary
       stack1  = new Stack<Integer>();
       stack2 = new Stack<Integer>();
    }
    
    private void stack2ToStack1() {
        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }
    }
    
    public void push(int element) {
        
        stack2.push(element);
        // write your code here
        
    }

    public int pop() {
        if (stack1.empty() == true) {
        stack2ToStack1();
        
        }// write your code here
        return stack1.pop();
    }

    public int top() {
        if (stack1.empty() == true) {
        stack2ToStack1();
        
        }
        // write your code here
        return stack1.peek();
    }
}