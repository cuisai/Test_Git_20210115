package com.sai.linkedList;

/**
 * @Author sai
 * @Description 双向链表的增删改查的测试类
 * @Time 2020-07-03 13:58
 */
public class DoubleLinkedList_CRUD_TEst {
    public static void main(String[] args) {

        //实例化几个对象
        DoubleLinkedList_CRUD.HeadNode_Double headNode_double1 = new DoubleLinkedList_CRUD.HeadNode_Double(1,"宋江","及时雨");
        DoubleLinkedList_CRUD.HeadNode_Double headNode_double2 = new DoubleLinkedList_CRUD.HeadNode_Double(2,"卢俊义","玉麒麟");
        DoubleLinkedList_CRUD.HeadNode_Double headNode_double3 = new DoubleLinkedList_CRUD.HeadNode_Double(3,"吴用","智多星");
        DoubleLinkedList_CRUD.HeadNode_Double headNode_double4 = new DoubleLinkedList_CRUD.HeadNode_Double(4,"公孙胜","入云龙");

        DoubleLinkedList_CRUD doubleLinkedList_crud = new DoubleLinkedList_CRUD();

        //添加_无序
        /*doubleLinkedList_crud.add(headNode_double1);
        doubleLinkedList_crud.add(headNode_double2);
        doubleLinkedList_crud.add(headNode_double3);
        doubleLinkedList_crud.add(headNode_double4);*/

        //添加_有序
        doubleLinkedList_crud.add2(headNode_double1);
        doubleLinkedList_crud.add2(headNode_double4);
        doubleLinkedList_crud.add2(headNode_double3);
        doubleLinkedList_crud.add2(headNode_double2);

        //查询
        //doubleLinkedList_crud.find(doubleLinkedList_crud.getHead());
        //System.out.println();

        //修改
        //DoubleLinkedList_CRUD.HeadNode_Double headNode_double = new DoubleLinkedList_CRUD.HeadNode_Double(3,"小吴","星星");
        //doubleLinkedList_crud.update(headNode_double,3);

        //查询
        //doubleLinkedList_crud.find(doubleLinkedList_crud.getHead());
        //System.out.println();

        //删除
        //doubleLinkedList_crud.delete(doubleLinkedList_crud.getHead(),4);
        //查询
        doubleLinkedList_crud.find(doubleLinkedList_crud.getHead());

    }

}
