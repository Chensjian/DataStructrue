package com.chen;

/**
 * @author chenchenchen
 * @create 2023-01-10 20:34
 */
public class ArrayCircularQueue {
    public static void main(String[] args) {
        CircularQueue circularQueue= new CircularQueue(10);
        for(int i=0;i<7;i++){
            circularQueue.enQueue((int)(Math.random()*100+1));
        }
        try {
            circularQueue.showQueue();
            System.out.print("入队");
            circularQueue.enQueue(99);
            System.out.println();
            System.out.print("入队");
            circularQueue.enQueue(99);
            System.out.println();
            System.out.print("入队");
            circularQueue.enQueue(99);
            System.out.println();
            System.out.println("出队:"+circularQueue.deQueue());
            System.out.println("出队:"+circularQueue.deQueue());
            System.out.print("入队");
            circularQueue.enQueue(99);
            System.out.println();
            System.out.print("入队");
            circularQueue.enQueue(99);
            System.out.println();
            circularQueue.showQueue();
            System.out.println();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
//使用数组实现循环队列
class CircularQueue{
    private int maxSize;//队列最大容量
    private int front;//队列头部
    private int rear;//队列尾部
    private int[] arr;//队列数组

    //队列构造器
    public CircularQueue(int maxSize){
        this.maxSize=maxSize;
        arr=new int[maxSize];
        this.front=0;
        this.rear=0;
    }

    //判断队列是否为空
    public boolean isEmpty(){
        return front==rear;
    }

    //判断队列是否为满
    public boolean isFull(){
        System.out.println("rear="+rear+"\tfront="+front);
        return (rear+1)%maxSize==front;
    }

    //入队
    public void enQueue(int e){
        if(isFull()){
            System.out.println("队列已满，无法入队");
            return;
        }
        arr[rear]=e;
        rear=((rear+1)%maxSize);

    }

    //出队
    public int deQueue(){
        if(isEmpty()){
            throw new RuntimeException("队列为空，没有元素可以出队");
        }
        int e=arr[front];
        front=(front+1)%maxSize;
        return e;
    }

    //获取队列头元素
    public int headQueue(){
        if(isEmpty()){
            throw new RuntimeException("队列为空，没有元素");
        }
        return arr[front];
    }

    //打印队列
    public void showQueue(){
        if(isEmpty()){
            throw new RuntimeException("队列为空");
        }
        for(int i=front;i<front+size();i++){

            System.out.print(arr[i%maxSize]+"\t");
        }
        System.out.println();
    }
    //求出当前队列元素个数
    public int size(){
        return (rear+maxSize-front)%maxSize;
    }
}

