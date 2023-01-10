package com.chen;

import java.util.Scanner;

/**
 * @author chenchenchen
 * @create 2023-01-10 21:58
 */
public class SingleLinkListDemo {
    public static void main(String[] args) {
        HeroNode heroNode1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode heroNode2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode heroNode3 = new HeroNode(3, "吴用", "智多星");
        HeroNode heroNode4 = new HeroNode(4, "林冲", "豹子头");
        SingleLinkedList singleLinkedList = new SingleLinkedList();
//        singleLinkedList.addLinkedList(heroNode3);
//        singleLinkedList.addLinkedList(heroNode2);
//        singleLinkedList.addLinkedList(heroNode1);
//        singleLinkedList.addLinkedList(heroNode4);
        singleLinkedList.insertLinkedListbySort(heroNode4);
        singleLinkedList.insertLinkedListbySort(heroNode1);
        singleLinkedList.insertLinkedListbySort(heroNode2);
        singleLinkedList.insertLinkedListbySort(heroNode3);
        singleLinkedList.printLinkedList();
        singleLinkedList.updateHeroNodeById(2);
        singleLinkedList.printLinkedList();
        System.out.println("删除节点2");
        singleLinkedList.deleteLinkedListById(2);
        singleLinkedList.printLinkedList();


    }
}
//单链表
class SingleLinkedList{
    private HeroNode head=new HeroNode(0,"","");//头节点

    //添加元素
    public void addLinkedList(HeroNode heroNode){
        HeroNode p=head;
        //遍历到最后一个节点
        while(p.next!=null){
            p=p.next;
        }
        p.next=heroNode;
    }
    //按id顺序插入
    public void insertLinkedListbySort(HeroNode heroNode){
        if(head.next==null){
            head.next=heroNode;
            return;
        }
        HeroNode p=head;
        while(p.next!=null&&p.next.id<heroNode.id){
            p=p.next;
        }
        if(p.next.id==heroNode.id){
            System.out.println("添加失败,排名重复");
            return;
        }
        heroNode.next=p.next;
        p.next=heroNode;
    }

    //修改节点的信息，根据id来修改，说明id不能被修改
    public void updateHeroNodeById(int id){
        HeroNode heroNode = getHeroNodeById(id);
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入name:");
        heroNode.name=scanner.next();
        System.out.print("请输入nikeName:");
        heroNode.nickName=scanner.next();
    }

    //根据id获取节点
    public HeroNode getHeroNodeById(int id){
        HeroNode p=head.next;
        while(p!=null&&p.id!=id){
            p=p.next;
        }
        if(p!=null){
            return p;
        }else{
            throw new RuntimeException("该id不存在");
        }
    }

    //根据id删除节点
    public void deleteLinkedListById(int id){
        if(head.next==null){
            System.out.println("链表为空");
            return;
        }
        HeroNode p=head;
        while(p.next!=null&&p.next.id!=id){
            p=p.next;
        }
        if(p!=null&&p.next.id==id){
            p.next=p.next.next;
        }else{
            System.out.println("未找到该节点");
        }
    }

    //打印链表
    public void printLinkedList(){
        if(head.next==null){
            System.out.println("链表为空");
            return;
        }
        HeroNode p=head.next;
        while(p!=null){
            System.out.println(p.toString());
            p=p.next;
        }
    }

}
//定义节点
class HeroNode{
    public int id;
    public String name;
    public String nickName;
    public HeroNode next;//下一个节点
    public HeroNode(int id,String name,String nickName){
        this.id=id;
        this.name=name;
        this.nickName=nickName;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}
