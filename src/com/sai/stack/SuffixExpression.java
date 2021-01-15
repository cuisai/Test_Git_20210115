package com.sai.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Author sai
 * @Description 用字符串转为后缀表达式，并实现简单计算器
 * @Time 2020-07-08 10:45
 */
public class SuffixExpression {


    /**
     * 将ArrayList类型的中缀表达式 转换为 ArrayList类型的后缀表达式
     * @param ls
     * @return
     */
    public List<String> getPostfixExpression(List<String> ls){

        Stack<String> s1 = new Stack<String>();  //运算符栈
        List<String> s2 = new ArrayList<String>();  //结果栈

        for (String item : ls){  //遍历每个
            if(item.matches("\\d+")){  //如果是数字，直接加入s2
                s2.add(item);
            }else if(item.equals("(")){  //如果是（ 直接压入s1
                s1.push(item);
            }else if(item.equals(")")){  //如果是 ） 进行判断
                while (!s1.peek().equals("(")){  //如果s1栈顶的不是（ 就把s1栈顶的值弹出，并加入到s2中
                    s2.add(s1.pop());
                }
                s1.pop();  // 如果是s1栈顶是（ 就把它弹出，----->消除一对括号
            }else {
                while (s1.size() != 0 && isPriority(item) <= isPriority(s1.peek())){  //如果当前符号的优先级 <= s1栈顶的优先级  就把s1栈顶的弹出，并加入到s2中
                    s2.add(s1.pop());
                }
                s1.push(item);  //如果s1栈中没有符号，就直接压入
            }

        }

        while (s1.size() !=  0){  //如果s1中有符号，就弹出，并加入s2中
            s2.add(s1.pop());
        }

        return s2;
    }

    /**
     * @Description 获取字符串表达式，给出ArrayList
     * @param s
     * @return
     */
    public List<String> getListString(String s){

        List<String> list = new ArrayList<String>();

        String str;
        char c;
        for (int i=0;i<s.length();i++){
            if((c=s.charAt(i))<48 || (c=s.charAt(i))>57){  //判断   ---字符
                list.add(""+c);
            }else {
                str = "";
                int p = 0;
                while (i<s.length() && (c=s.charAt(i))>=48 && (c=s.charAt(i))<=57){  //是数字
                    str += c;
                    p = i+1;
                    if(p<s.length() && (c=s.charAt(p))>=48 && (c=s.charAt(p))<=57){
                        i++;
                    }else {
                        break;
                    }


                }
                list.add(str);
            }
        }

        return list;
    }


    //获取计算结果
    public int get(List<String> list){

        int sum = 0;
        Stack<String> stack = new Stack<String>();
        for (String item : list){
            if(item.matches("\\d+")){
                stack.push(item);
            }else {
                int num2 = Integer.parseInt(stack.pop());
                int num1 = Integer.parseInt(stack.pop());
                if(item.equals("+")){
                    sum = num1 + num2;
                }else if (item.equals("-")){
                    sum = num1 - num2;
                }else if (item.equals("*")){
                    sum = num1 * num2;
                }else if (item.equals("/")){
                    sum = num1 / num2;
                }else {
                    throw new RuntimeException("字符有误！");
                }

//                System.out.println("----->"+sum);
                stack.push(""+sum);
            }
        }
        sum = Integer.parseInt(stack.pop());

        return sum;
    }

    //获取集合
    public List<String> getList(String expression){
        List list = new ArrayList();

        String[] l = expression.split(" ");

        for (String item:l) {
            list.add(item);
        }

        return list;
    }

    //判断运算符的优先级
    public int isPriority(String val){

        if(val.equals("*")  ||  val.equals("/")){
            return 1;
        }
        else if(val.equals("+")  ||  val.equals("-")){
            return 0;
        }else {
            return -1;
        }
    }


}