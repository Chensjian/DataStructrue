package com.chen;

/**
 * @author chenchenchen
 * @create 2023-01-12 21:00
 */
public class ArrayStackDemo {
    public static void main(String[] args) {
        ArrayStack arrayStack = new ArrayStack(10);
        for(int i=1;i<11;i++){
            arrayStack.push(i);
        }
        arrayStack.showArrayStack();
        System.out.println("当前栈的长度为:"+arrayStack.getSize());
        System.out.print("出栈:");
        for(int i=1;i<11;i++){
            System.out.print(arrayStack.pop()+"\t");
        }
        System.out.println();
        System.out.println("当前栈的长度为:"+arrayStack.getSize());
    }
}
class ArrayStack{
    private int[] arr;
    private int top;
    private int maxSize;
    public ArrayStack(int capacity){
        this.arr=new int[capacity];
        this.maxSize=capacity;
        this.top=-1;
    }
    public void push(int data){
        if(top+1==maxSize){
            System.out.println("栈已经满了");
            return;
        }
        arr[++top]=data;
    }
    public int pop(){
        if(top==-1){
            throw new RuntimeException("栈为空");
        }
        int val=arr[top--];
        return val;
    }
    public void showArrayStack(){
        for(int i=top;i>=0;i--){
            System.out.print(arr[i]+"\t");
        }
        System.out.println();
    }
    public int getSize(){
        return top+1;
    }

}

