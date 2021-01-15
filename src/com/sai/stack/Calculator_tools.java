package com.sai.stack;

/**
 * @Author sai
 * @Description 简单计算器的工具类
 * @Time 2020-07-07 14:22
 */
public class Calculator_tools {

    private int maxSize;  //栈的最大容量
    private int[] stack;  //用数组模拟栈
    private int top = -1;  //栈顶，默认-1，表示栈空

    public Calculator_tools(int maxSize) {
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
    public int pop(){
        if(isNull()){
            System.out.println("栈空-----");
            return -1;
        }
        int s = stack[top];
        top--;
        return s;
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

    //判断是否是运算符
    public Boolean isOperator(int val){

        if(val == '+'  || val == '-'  ||  val == '*'  ||  val == '/' ){
            return true;
        }
        return false;
    }

    //判断运算符的优先级
    public int isPriority(int val){

        if(val == '*'  ||  val == '/'){
            return 1;
        }
        else if(val == '+'  ||  val == '-'){
            return 0;
        }else {
            return -1;
        }
    }

    //计算方法
    public int sum(int sum1,int sum2,int oper){
        int sum = 0;
        switch (oper){
            case '+' :
                sum = sum1 + sum2;
                break;

            case '-' :
                sum = sum2 - sum1;
                break;

            case '*' :
                sum = sum1 * sum2;
                break;

            case '/' :
                sum = sum2 / sum1;
                break;
        }
        return sum;
    }

    //返回当前栈顶的数据
    public int stackTop(){
        return stack[top];
    }

}
