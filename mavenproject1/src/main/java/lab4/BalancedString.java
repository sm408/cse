/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab4;

/**
 *
 * Name: Shubham Maurya 
 * Roll No.: 2010110615 
 * Course: CSD213
 */
class Stack {

    int top = -1;
    int bal = 1;
    char arr[] = new char[100];

    public void push(char val) {
        if (val == '[' || val == '{' || val == '(') {
            this.arr[++top] = val;
        } else {
            if (peek() + 1 == val || peek() + 2 == val) {
                pop();
            } else {
                bal = 0;
            }
        }
    }

    public char peek() {
        return arr[top];
    }

    public void pop() {
        --top;
    }

    public void printStack() {
        for (int i = 0; i <= top; i++) {
            System.out.print(arr[i]);
        }
    }

    public void balancedStack() {
        if (bal == 1) {
            System.out.println("This is a balanced String.");
        } else {
            System.out.println("This is an unbalanced string.");
        }
    }
}

public class BalancedString {

    public static void main(String[] args) {
        Stack test = new Stack();
        test.push('(');
        test.push('{');
        test.push('}');
        test.push('[');
        test.push(']');
        test.push(')');
        test.balancedStack();
        Stack test2 = new Stack();
        test2.push('(');
        test2.push('{');
        test2.push('{');
        test2.push('}');
        test2.push('}');
        test2.push(')');
        test2.balancedStack();

    }
}
