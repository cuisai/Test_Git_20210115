package com.sai.linkedList;

/**
 * @Author sai
 * @Description CircularSingleLinkedList的测试类
 * @Time 2020-07-06 11:18
 */
public class CircularSingleLinkedList_Test {
    public static void main(String[] args) {
        CircularSingleLinkedList cir = new CircularSingleLinkedList();

        //添加五个，构成单向环形链表
        cir.addBoy(5);

        //查询显示链表
        cir.findAll();

        //测试小孩出圈（约瑟夫问题）
        cir.countBoy(1,2,5);

    }
}
