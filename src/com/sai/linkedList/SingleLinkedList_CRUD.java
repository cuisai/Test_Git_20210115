package com.sai.linkedList;

import java.util.Stack;

/**
 * @Author sai
 * @Description 单链表的添加和查看
 * @Time 2020-07-01 10:16
 */
public class SingleLinkedList_CRUD {


static class SingleLinkedList{
        //创建头节点
        public static HeadNode head = new HeadNode(0,"","");


        /**
         * 单链表的反向输出
         * 利用栈的特性（先进后出），将链表存入到栈中，然后再拿出来
         */
        public void getReversalOutPut(HeadNode head){
            if(head.next==null){  //判断链表是否为空
                System.out.println("链表为空~");
                return;
            }

            HeadNode temp = head.next;  //辅助指针
            Stack<HeadNode> s = new Stack<HeadNode>();

            while (temp != null){
                s.push(temp);
                temp = temp.next;
            }

            while (s.size() > 0){
                System.out.println(s.pop());
            }

        }

        /**
         * 添加链表_无序
         * @param headNode
         * 1.找到最后的节点
         * 2.将最后的next指向下一个节点
         */
        public void add(HeadNode headNode){
            //创建头结点
            HeadNode temp = head;

            //遍历节点，找到最后
            while (true){
                if(temp.next == null){
                    break;
                }
                temp = temp.next;
            }

            //指向下一个节点
            temp.next = headNode;

        }


    /**
         * 添加链表_有序
         * @param headNode
         * 1.找到位置
         * 2.设置位置前一个个节点的指针指向，和添加数据的指针方向
         */
        public void addByOrder(HeadNode headNode){
            HeadNode temp = head;
            Boolean q = false;
            while (true){
                if(temp.next == null){  //队列尾部
                    break;
                }
                if(temp.next.no > headNode.no){  //找到真确的位置
                    break;
                }
                else if(temp.next.no == headNode.no){  //已有该编号
                    q = true;
                    break;
                }
                temp = temp.next;  //以上三种都不是，指向下一个继续判断
            }

            if(q){
                System.out.println("该编号以存在~");
            }
            else{
                headNode.next = temp.next;  //将要添加的数据的next域指向后一个
                temp.next = headNode;  //将要添加数据的前一个的next域指向要添加的数据
            }


        }




    /**
     * 修改数据
     */
    public void update(HeadNode newHeadNode){

        if(head.next == null){  //判断链表是否为空
            System.out.println("该链表为空~");
            return;
        }

        //辅助节点
        HeadNode temp = head.next;
        Boolean flag = false;
        while (true){
            if(temp.next == null){  //遍历到了尾节点
                break;
            }
            if(temp.next.no == newHeadNode.no){  //判断要修改的对象的编号与链表中存在的编号相同
                flag = true;
                break;
            }
            temp = temp.next;  //指针向后移
        }

        if(flag){
            temp.next.name = newHeadNode.name;
            temp.next.nackName = newHeadNode.nackName;
        }
        else {
            System.out.println("没有找该编号:"+newHeadNode.no);
        }


    }

    /**
     * 删除节点
     * 1.找到要删除的节点的前一个节点
     * 2.把该节点的next域指向下一个节点的再下一个节点
     */
    public void delete(int no){
        HeadNode temp = head;  //辅助指针
        Boolean falg = false;  //表示是否找到要修改的前一个节点

        if (temp.next == null){  //判断链表是否为空
            System.out.println("该链表为空~");
            return;
        }
        while (true){
            if(temp.next == null){  //到达尾节点
                break;
            }
            if(temp.next.no == no){  //找到要删除的节点的前一个节点
                falg = true;
                break;
            }
            temp = temp.next;  //指针后移
        }

        if(falg){
            temp.next = temp.next.next;  //把该节点的next域指向下一个节点的再下一个节点
        }
        else {
            System.out.println("未找到该节点~");
        }

    }

    /**
     * 查询全部链表的方法
     */
    public void find(){
            //判断链表是否为空
            if(head.next == null){
                System.out.println("此链表为空~");
                return;
            }

            HeadNode temp = head.next;  //头部节点往后的节点
            while (true){
                //判断节点是否最后
                if(temp == null){
                    break;
                }
                System.out.println(temp.toString());  //输出节点信息

                temp = temp.next;  //将节点指针向后移
            }

        }

    /**
     * 计算单链表的长度
     * @param head
     * @return
     */
    public int getLenght(HeadNode head){

            HeadNode temp = head;

            if(temp.next == null){
                System.out.println("此链表为空~");

            }

            int sum = 0;
            Boolean falg = false;
            while (true){
                if(temp.next == null){  //到达尾部
                    break;
                }
                sum++;
                temp = temp.next;
            }

            return sum;
        }

    /**
     * 查找倒数第K个元素
     * @param headNode
     * @param k
     * 1.获取链表的总长度
     * 2.第K位 = 总长度-k
     */
    public HeadNode findK(HeadNode headNode,int k){
        if(headNode.next == null){  //判断是否为空
            return null;
        }
        int lenght = getLenght(headNode);  //获取长度

        if(k>lenght || k<=0){  //判断是否无效
            return null;
        }

        HeadNode temp = headNode.next;

        for(int i=0;i<lenght-k;i++){
            temp = temp.next;
        }
        return temp;

    }

    /**
     * 单链表的反转
     * @return
     * 1.遍历链表，每遍历一个节点，就把该节点放到链表的最前端
     */
    public static void getReversal(HeadNode headNode){
        if(headNode.next==null || headNode.next.next==null){  //判断链表是否为空，或者只有一个节点
            return;
        }

        HeadNode temp = headNode.next;  //辅助指针
        HeadNode next = null;  //保留当前节点的下一个节点
        HeadNode reversal = new HeadNode(0,"","");  //创建反转后的头节点

        while (temp != null){
            next = temp.next;   //保存当前节点的下一个节点

            temp.next = reversal.next;  //将temp的下一个节点指向新的链表的最前端
            reversal.next = temp;  //将temp连接到新的链表上

            temp = next;  //指针后移

        }

        headNode.next = reversal.next;  //原来的头部指向转换后的头部,实现链表反转

    }

    public static HeadNode getHead() {
        return head;
    }
}

    /**
     * 设置一个实体类
     */
    static class HeadNode {

    private int no;  //编号
    private String name;  //姓名
    private String nackName;  //诨名
    private HeadNode next;  //指针（next域）

    //构造方法
    public HeadNode(int no, String name, String nackName) {
        this.no = no;
        this.name = name;
        this.nackName = nackName;
    }


    @Override
    public String toString() {
        return "HeadNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nackName='" + nackName + '\''+
                '}';
    }

    }
}
