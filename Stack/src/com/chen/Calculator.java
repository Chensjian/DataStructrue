package com.chen;

/**
 * @author chenchenchen
 * @create 2023-01-12 22:39
 */
public class Calculator {
    public static void main(String[] args) {
        String str="30+2*6-20+20+60";
        int num1,num2,opera;
        int res;
        String val="";
        ArrayStack2 numStack = new ArrayStack2(10);
        ArrayStack2 operaStack = new ArrayStack2(10);
        for(int i=0;i<str.length();i++){
            int ch=str.charAt(i);
            if(operaStack.isOpera(ch)){//判断是否为操作符
                numStack.push(Integer.valueOf(val));
                val="";
                //是操作符，则先判断符号栈是否为空，为空则直接压入栈
                if(operaStack.isEmpty()){//判断符号栈是否为空
                    operaStack.push(ch);
                }else{
                    //符号栈不为空，则判断该符号与栈中的符号的优先级
                    //如果当前操作符的优先级小于或者等于栈中的操作符，
                    // 就需要从数栈中pop出两个数，从符号栈中pop出一个符号，进行运算，并将运算的结果压入数栈
                    //在将优先级小的运算符压入符号栈
                    if(operaStack.priority(ch)<=operaStack.priority(operaStack.getTop())){
                        num1=numStack.pop();
                        num2=numStack.pop();
                        opera=operaStack.pop();
                        res=numStack.calculate(num1,num2,opera);
                        numStack.push(res);
                        operaStack.push(ch);
                    }else{//该运算符大于栈顶的运算符则直接入栈
                        operaStack.push(ch);
                    }
                }
            }else{
               val+=ch-48;
            }
        }
        numStack.push(Integer.valueOf(val));
        while(!operaStack.isEmpty()){
            num1=numStack.pop();
            num2=numStack.pop();
            opera=operaStack.pop();
            res=numStack.calculate(num1,num2,opera);
            numStack.push(res);
        }
        System.out.println(str+"="+numStack.pop());
    }
}
class ArrayStack2{
    private int[] arr;
    private int top;
    private int maxSize;
    public ArrayStack2(int capacity){
        this.arr=new int[capacity];
        this.maxSize=capacity;
        this.top=-1;
    }
    //获取栈顶元素
    public int getTop(){
        return arr[top];
    }

    //判断栈是否为空
    public boolean isEmpty(){
        return -1==top;
    }

    //判断栈是否为满
    public boolean isFull(){
        return top==maxSize-1;
    }

    //入栈
    public void push(int data){
        if(isFull()){
            System.out.println("栈已经满了");
            return;
        }
        arr[++top]=data;
    }
    //出栈
    public int pop(){
        if(isEmpty()){
            throw new RuntimeException("栈为空");
        }
        int val=arr[top--];
        return val;
    }
    //遍历栈
    public void showArrayStack(){
        for(int i=top;i>=0;i--){
            System.out.print(arr[i]+"\t");
        }
        System.out.println();
    }
    //获取栈中元素的个数
    public int getSize(){
        return top+1;
    }

    //判断是否为运算符
    public boolean isOpera(int opera){
        return opera=='*'||opera=='/'||opera=='+'||opera=='-';
    }

    //运算符优先级判断
    public int priority(int opera){
        switch (opera){
            case '*':
            case '/':
                return 1;
            case '+':
            case '-':
                return 0;
            default:
                return -1;
        }
    }

    //计算值
    public int calculate(int num1,int num2,int opera){
        int res=0;
        switch(opera){
            case '+':
                res=num1+num2;
                break;
            case '-':
                res=num2-num1;//注意操作数顺序
                break;
            case '*':
                res=num1*num2;
                break;
            case '/':
                res=num2/num1;
                break;
        }
        return res;
    }

}
