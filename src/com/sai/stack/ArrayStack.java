package com.sai.stack;

/**
 * @Author sai
 * @Description 用数组模拟栈的入门练习
 * @Time 2020-07-06 17:13
 */
public class ArrayStack {
    private int maxSize;  //栈的最大容量
    private int[] stack;  //用数组模拟栈
    private int top = -1;  //栈顶，默认-1，表示栈空

    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        this.stack = new int[maxSize];
    }

    //栈满
    public Boolean isFull(){
        return top == maxSize-1;
    }

    //栈空
    public Boolean isNull(){
        return top == -1;
    }

    //入栈
    public void push(int value){
        if(isFull()){
            System.out.println("栈满，无法添加~");
            return;
        }
        top++;
        stack[top] = value;
    }

    //出栈
    public void pop(){
        if(isNull()){
            System.out.println("栈空-----");
            return;
        }
        int s = stack[top];
        top--;
        System.out.println("出栈的数值为："+s);
    }

    //显示栈
    public void show(){
        if(isNull()){
            System.out.println("栈空-----");
            return;
        }
        for(int i=top;i>=0;i--){
            System.out.println("stack["+i+"]:"+stack[i]);
        }
    }

}