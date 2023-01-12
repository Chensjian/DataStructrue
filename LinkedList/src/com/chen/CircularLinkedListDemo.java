package com.chen;

/**
 * @author chenchenchen
 * @create 2023-01-12 0:48
 */
public class CircularLinkedListDemo {
    public static void main(String[] args) {
        CircularLinkedList circularLinkedList = new CircularLinkedList();
        circularLinkedList.InsertCircularLinkedList(new Node(1));
        circularLinkedList.InsertCircularLinkedList(new Node(2));
        circularLinkedList.InsertCircularLinkedList(new Node(3));
        circularLinkedList.InsertCircularLinkedList(new Node(4));
        circularLinkedList.InsertCircularLinkedList(new Node(5));
//        circularLinkedList.InsertCircularLinkedList(new Node(6));
//        circularLinkedList.InsertCircularLinkedList(new Node(7));
//        circularLinkedList.InsertCircularLinkedList(new Node(8));
//        circularLinkedList.InsertCircularLinkedList(new Node(9));
//        circularLinkedList.InsertCircularLinkedList(new Node(10));
        circularLinkedList.printCircularLinkedList();
        //circularLinkedList.deleteCircularLinkedListByData(5);
        //circularLinkedList.printCircularLinkedList();
        circularLinkedList.josephu(2);

    }
}
class CircularLinkedList{
    private Node linkedList;
    private Node cur;
    public CircularLinkedList(){

    }
    public void InsertCircularLinkedList(Node node){
        if(linkedList==null){
            linkedList=node;
            node.next=linkedList;
            cur=linkedList;
            return;
        }
        cur.next=node;
        node.next=linkedList;
        cur=node;
//        while(p.next!=linkedList){
//            p=p.next;
//
//        }
//        p.next=node;
//        node.next=linkedList;
    }
    public void printCircularLinkedList(){
        Node p=linkedList;
        if(p==null){
            System.out.println("链表为空");
        }
        while(p.next!=linkedList){
            System.out.print(p.data+"\t");
            p=p.next;
        }
        System.out.println(p.data);
    }
    public void deleteCircularLinkedListByData(int data){
        Node p=linkedList;
        while(p.next.data!=data){
            p=p.next;
        }
        p.next=p.next.next;
    }
    public void josephu(int m){
        Node p=linkedList;
        int k=m;
        while(p.next!=p){
            if(--m==1){
                m=k;
                System.out.print(p.next.data+"\t");
                p.next=p.next.next;
            }
            p=p.next;
        }
        System.out.print(p.data);
    }
}
class Node{
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
    }
}

