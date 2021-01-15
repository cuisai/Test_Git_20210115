package com.sai.stack;

/**
 * @Author sai
 * @Description Calculator
 * @Time 2020-07-07 15:00
 */
public class Calculator {
    public void expression(String expression) {

        //创建两个栈数栈，符号栈
        Calculator_tools numCtack = new Calculator_tools(10);
        Calculator_tools operCtack = new Calculator_tools(10);
        //定义变量
        int index = 0;  //辅助，用于循环
        int num1 = 0;  //运算时，数栈 出栈的第一个数
        int num2 = 0;  //运算时，数栈 出栈的第二个数
        int oper = 0;  //运算时，符号栈 出栈的符数
        int res = 0;  //运算的结果
        char ch = ' ';  //每次扫描得到char保存到ch

        String loop = "";  //用来连接数字的

        //开始扫描expression
        while (true){
            //遍历每一个字符
            ch = expression.substring(index, index+1).charAt(0);

            if(numCtack.isOperator(ch)){  //判断是否是运算符
                if(operCtack.isNull()){  //判断符号栈是否为空
                    operCtack.push(ch);
                }
                else {
                    if(operCtack.isPriority(ch) <= operCtack.isPriority(operCtack.stackTop())){  //判断当前符号的优先级是否小于符号栈顶的优先级
                        num1 = numCtack.pop();  //出栈两个数 和 一个运算符
                        num2 = numCtack.pop();
                        oper = operCtack.pop();
                        res = operCtack.sum(num1,num2,oper);  //计算得到的结果

                        numCtack.push(res);  //将运算结果压入数栈中
                        operCtack.push(ch);  //将当前运算符压入符号栈
                    }else {
                        operCtack.push(ch);  //直接压入
                    }
                }

            }
            else {  //如果是数的话
                loop = loop + ch;

                if(index == expression.length()-1){  //判断是否是最后一个
                    numCtack.push(Integer.parseInt(loop));
                }
                else {
                    int a = expression.substring(index+1,index+2).charAt(0);
                    if(operCtack.isOperator(a)){  //判断下一位是否还是数字

                        numCtack.push(Integer.parseInt(loop));
                        loop = "";
                    }
                }


            }

            index++;  // 指针后移，获取下一个
            if(index == expression.length()){  //判断是否遍历到最后
                break;
            }
        }

        //将栈中的数运算
        while (true){
            num1 = numCtack.pop();
            num2 = numCtack.pop();
            oper = operCtack.pop();
            res = operCtack.sum(num1,num2,oper);  //计算得到的结果

            numCtack.push(res);  //将结果压入数栈

            if(operCtack.isNull()){  //判断是否全部运算完毕
                break;
            }
        }

        int he = numCtack.pop();  //获取最后运算完成的数，输出
        System.out.println("最后的运算结果为："+he);

    }
}
