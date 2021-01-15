package com.sai.queue;

import java.util.Scanner;

/**
 * @Author sai
 * @Description 数组实现队列
 * @Time 2020-06-30 14:36
 */
public class Queue_Array {
    private int maxsize;  //数组的最大容量
    private int front;  //队列头
    private int rear;  //队列尾
    private int[] arr;  //模拟队列的数组

    //构造器，加载数据
    public Queue_Array(int maxsize){
        this.maxsize = maxsize;
        this.rear = -1;
        this.front = -1;
        this.arr = new int[maxsize];
    }

    //查看所有数据
    public void findAll(){
        if(isNull()){
            throw new RuntimeException("队列为空~");
        }
        for(int i=front+1;i<arr.length;i++){
            System.out.println(arr[i]+"\t");
        }
    }

    //拿(获取)数据
    public int getData(){

        if(isNull()){
            throw  new RuntimeException("队列为空~");
        }

        front++;
        System.out.println("获取的数据为："+arr[front]);

        return arr[front];
    }

    //添加数据
    public void addData(int data){

        if(isMaxSize()){
            throw new RuntimeException("队列已满~");
        }

        rear++;
        arr[rear] = data;
        System.out.println("添加成功，您添加的数据是："+data);

    }

    //判断队列是否为空
    public boolean isNull(){

        return rear==front;
    }

    //判断队列是否为满
    public boolean isMaxSize(){

        return rear == maxsize-1;
    }

}