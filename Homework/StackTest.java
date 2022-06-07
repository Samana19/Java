package Homework;

public class StackTest {
    public static void main(String[] args) {
        StackImplementation stack = new StackImplementation();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        stack.print();
        System.out.println(stack.peek());
        stack.pop();
        stack.print();

    }
    
}
