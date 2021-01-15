package com.sai.linkedList;

/**
 * @Author sai
 * @Description SingleLinkedList_CRUD的测试类
 * @Time 2020-07-01 14:59
 */
public class SingleLinkedList_CRUD_Test {
    public static void main(String[] args) {
        SingleLinkedList_CRUD.HeadNode headNode1 = new SingleLinkedList_CRUD.HeadNode(1,"宋江","及时雨");
        SingleLinkedList_CRUD.HeadNode headNode2 = new SingleLinkedList_CRUD.HeadNode(2,"卢俊义","玉麒麟");
        SingleLinkedList_CRUD.HeadNode headNode3 = new SingleLinkedList_CRUD.HeadNode(3,"吴用","智多星");
        SingleLinkedList_CRUD.HeadNode headNode4 = new SingleLinkedList_CRUD.HeadNode(4,"公孙胜","入云龙");

        SingleLinkedList_CRUD.SingleLinkedList singleLinkedList = new SingleLinkedList_CRUD.SingleLinkedList();

        //无序添加
//        singleLinkedList.add(headNode1);
//        singleLinkedList.add(headNode2);
//        singleLinkedList.add(headNode3);
//        singleLinkedList.add(headNode4);

        //根据编号添加
        singleLinkedList.addByOrder(headNode1);
        singleLinkedList.addByOrder(headNode4);
        singleLinkedList.addByOrder(headNode2);
        singleLinkedList.addByOrder(headNode3);

        //遍历输出
        singleLinkedList.find();
        System.out.println();

        //修改
        //SingleLinkedList_CRUD.HeadNode updateHeadNode = new SingleLinkedList_CRUD.HeadNode(3,"小吴","星星");
        //singleLinkedList.update(updateHeadNode);

        //遍历输出
        //singleLinkedList.find();
        //System.out.println();

        //删除
        //singleLinkedList.delete(4);

        //遍历输出
        //singleLinkedList.find();
        //System.out.println();

        //获取链表的长度
        //int i = singleLinkedList.getLenght(SingleLinkedList_CRUD.SingleLinkedList.getHead());
        //System.out.println("该单链表的长度为："+i);

        //输出倒数第K个节点
        //System.out.println(singleLinkedList.findK(SingleLinkedList_CRUD.SingleLinkedList.getHead(),1));

        //反转链表
        //singleLinkedList.getReversal(SingleLinkedList_CRUD.SingleLinkedList.getHead());

        //利用栈的特性，反向输出
        singleLinkedList.getReversalOutPut(SingleLinkedList_CRUD.SingleLinkedList.getHead());

        //遍历输出
//        singleLinkedList.find();
//        System.out.println();



    }
}
