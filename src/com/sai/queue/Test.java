package com.sai.queue;

import java.util.Scanner;

/**
 * @Author sai
 * @Description 测试类
 * @Time 2020-07-02 16:55
 */
public class Test {
    public static void main(String[] args) {
        System.out.println("欢迎来到本队列系统~");

        Queue_Array queue = new Queue_Array(3);

        boolean loop = true;
        Scanner s = new Scanner(System.in);
        while (loop){

            System.out.println("输入'a'，添加数据");
            System.out.println("输入'f'，查看数据");
            System.out.println("输入'g'，获取数据");
            System.out.println("输入'e'，退出程序");

            String data = s.next();
            switch (data){
                case "a" :

                    try {
                        System.out.println("请输入您要添加的数据~");
                        Scanner ss = new Scanner(System.in);
                        int addData = ss.nextInt();
                        queue.addData(addData);
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }

                    break;

                case "f" :
                    try {
                        queue.findAll();
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }

                    break;

                case "g" :
                    try {
                        queue.getData();
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }

                    break;

                case "e" :
                    System.out.println("程序以退出~");
                    loop = false;
                    break;
            }

        }


    }
}
