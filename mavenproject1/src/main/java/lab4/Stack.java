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

class MinimumStack{
    int top = -1;
    int arr[] = new int[100];
    
    public void push(int val){
        this.arr[++top] = val;
    }
    
    public void pop(){
        --top;
    }
    
    public int peek(){
        return arr[top];
    }
    
    public int top(){
        return arr[top--];
    }
    
    public int getMin(){
        int min = arr[top];
        for(int i = 0; i<=top; i++)
            if(arr[i]<min)
                min = arr[i];
        return min;
    }
    
    public void printStack(){
        for(int i = 0; i<=top; i++){
            System.out.print(arr[i]);
        }
    }
}

public class Stack {
    public static void main(String[] args) {
        MinimumStack stack1 = new MinimumStack();
        stack1.push(1);
        stack1.push(2);
        stack1.push(3);
        stack1.push(4);
        stack1.push(5);
        stack1.push(6);
        stack1.push(7);
        stack1.push(8);
        
        System.out.println(stack1.peek());
        System.out.println(stack1.top());
        stack1.printStack();
        System.out.println("\n"+stack1.getMin());
        System.out.println(stack1.peek());
        stack1.pop();
        stack1.printStack();
    }
}
