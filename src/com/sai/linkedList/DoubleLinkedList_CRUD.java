package com.sai.linkedList;

/**
 * @Author sai
 * @Description 双向链表的增删改查
 * @Time 2020-07-03 11:16
 */
public class DoubleLinkedList_CRUD {
    public HeadNode_Double head = new HeadNode_Double(0,"","");   //头节点

    public HeadNode_Double getHead() {  //获取头节点
        return head;
    }

    /**
     * 添加_有序
     * @param headNode_double
     */
    public void add2(HeadNode_Double headNode_double){

        HeadNode_Double temp = head;  //创建辅助指针
        Boolean falg1 = false;  //表示是否编号已经存在
        Boolean falg2 = false;  //表示是否到达尾部
        while (true){

            if(temp.next  != null  && temp.next.no == headNode_double.no){  //有相同的编号了

                falg1 = true;
                break;
            }
            if(temp.next == null){  //到达尾部

                falg2 = true;
                break;
            }
            if(temp.next.no > headNode_double.no){  //遍历找到编号比这个大的位置 (找到要插入的位置)

                break;
            }
            temp = temp.next;  //指针后移
        }

        if(falg1){
            System.out.println("已经有相同编号的对象了，无法添加了！");
        }
        else if (falg2){  //在尾部插入

            headNode_double.pre = temp;
            temp.next = headNode_double;
        }
        else{  //在头部或者中间插入

            headNode_double.next = temp.next;
            temp.next.pre = headNode_double;
            temp.next = headNode_double;
            headNode_double.pre = temp;
        }


    }

    /**
     * 添加_无序
     * @param headNode_double
     */
    public void add(HeadNode_Double headNode_double){

        HeadNode_Double temp = head;  //创建辅助指针

        while (true){
            if(temp.next == null){  //遍历找到尾部
                break;
            }
            temp = temp.next;  //指针后移
        }

        temp.next = headNode_double;  //构建连接下一个的指针
        headNode_double.pre = temp;  //构建连接上一个的指针

    }

    /**
     * 查询
     * @param head
     */
    public void find(HeadNode_Double head){

        if(head.next == null){  //判断链表是否为空
            System.out.println("该链表为空！");
            return;
        }

        HeadNode_Double temp = head.next;
        while (temp != null){

            System.out.println(temp);
            temp = temp.next;

        }

    }

    /**
     * 修改
     * @param newHead  链表头
     * @param no  要修改的节点的编号
     */
    public void update(HeadNode_Double newHead,int no){

        if(head.next == null){  //判断是否为空
            System.out.println("此链表为空！");
            return;
        }

        HeadNode_Double temp = head;  //获取辅助指针
        Boolean falg = false;  //标识是否找到要修改的节点
        while (true){
            if(temp.next == null){  //到达尾部，跳出循环
                break;
            }
            if(temp.next.no == no){  //找到要修改的节点
                falg = true;
                break;
            }
            temp = temp.next;
        }

        if(falg){

            temp.next.name = newHead.name;
            temp.next.nackName = newHead.nackName;
            System.out.println("修改成功！");
        }
        else {
            System.out.println("未找到要修改的节点！");
        }

    }

    /**
     * 删除
     * @param head  要删除的节点的头部
     * @param no  要删除的节点的编号
     */
    public void delete(HeadNode_Double head,int no){

        if(head.next == null){  //判断是否为空
            System.out.println("该链表为空！");
            return;
        }

        HeadNode_Double temp = head.next;  //获取辅助指针
        Boolean falg = false;  //标识是否找到要删除的节点
        while (true){

            if(temp == null){  //到达尾部，跳出循环
                break;
            }

            if(temp.no == no){  //找到要删除的节点
                falg = true;
                break;
            }
            temp = temp.next;  //指针后移
        }

        if(falg){

            if(temp.next != null){  //判断是否是最后一个节点
                temp.pre.next = temp.next;
                temp.next.pre = temp.pre;

            }

            temp.pre.next = null;
            System.out.println("删除成功！");
        }
        else {
            System.out.println("没有找到要删除的节点！");
        }

    }


    /**
     * 设置一个实体类
     */
    static class HeadNode_Double {

        private int no;  //编号
        private String name;  //姓名
        private String nackName;  //诨名
        private HeadNode_Double next;  //指针  指向下一个节点（next域）
        private HeadNode_Double pre;  //指针  指向上一个节点（pre域）

        //构造方法
        public HeadNode_Double(int no, String name, String nackName) {
            this.no = no;
            this.name = name;
            this.nackName = nackName;
        }

        @Override
        public String toString() {
            return "HeadNode{" +
                    "no=" + no +
                    ", name='" + name + '\'' +
                    ", nackName='" + nackName + '\'' +
                    '}';
        }

    }

}
