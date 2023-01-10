package com.chen;

/**
 * @author chenchenchen
 * @create 2023-01-10 19:33
 */
public class ArrayQueue {
    public static void main(String[] args) {
        ArrQueue arrQueue = new ArrQueue(10);
        for(int i=0;i<10;i++){
            arrQueue.enQueue((int)(Math.random()*100+1));
        }
        arrQueue.showQueue();
        arrQueue.deQueue();
        System.out.println();
        arrQueue.showQueue();
        System.out.println();
        System.out.println(arrQueue.headQueue());
    }
}
//使用数组实现队列
class ArrQueue{
    private int maxSize;//队列最大容量
    private int front;//队列头部
    private int rear;//队列尾部
    private int[] arr;//队列数组

    //队列构造器
    public ArrQueue(int maxSize){
        this.maxSize=maxSize;
        arr=new int[maxSize];
        this.front=-1;
        this.rear=-1;
    }

    //判断队列是否为空
    public boolean isEmpty(){
        return front==rear;
    }

    //判断队列是否为满
    public boolean isFull(){
        return rear==maxSize-1;
    }

    //入队
    public void enQueue(int e){
        if(isFull()){
            System.out.println("队列已满，无法入队");
            return;
        }
        arr[++rear]=e;
    }

    //出队
    public int deQueue(){
        if(isEmpty()){
            throw new RuntimeException("队列为空，没有元素可以出队");
        }
        return arr[++front];
    }

    //获取队列头元素
    public int headQueue(){
        if(isEmpty()){
            throw new RuntimeException("队列为空，没有元素");
        }
        return arr[front+1];
    }

    //打印队列
    public void showQueue(){
        if(isEmpty()){
            throw new RuntimeException("队列为空");
        }
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+"\t");
        }
    }
}
