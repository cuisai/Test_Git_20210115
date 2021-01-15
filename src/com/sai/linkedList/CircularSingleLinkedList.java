package com.sai.linkedList;

/**
 * @Author sai
 * @Description 约瑟夫问题_单向环形链表
 * @Time 2020-07-06 10:25
 */
public class CircularSingleLinkedList {

    public Boy first = null;  //创建一个first头节点


    /**
     *
     * @param startNo  表示从第几个小孩开始数数
     * @param countNum  表示数几下
     * @param nums  表示最初有多少个小孩在圈中
     */
    public void countBoy(int startNo,int countNum,int nums){

        if(startNo<1 || first == null || startNo>nums){  //判断所给参数是否有意义
            System.out.println("输入的参数有误~");
            return;
        }

        //1.创建一个辅助指针，指向环形链表的最后一个节点
        Boy helper = first;
        while (true){
            if(helper.getNext() == first){  //证明该节点指向环形链表的最后的一个节点
                break;
            }
            helper = helper.getNext();  //指针后移
        }

        //2.报数前，让frist和helper移动k-1次
        for (int i=0;i<startNo-1;i++){
            first = first.getNext();
            helper = helper.getNext();
        }

        //3.这时将frist指向的小孩出圈
        while (true){
            if(first == helper){  //只剩一个小孩
                break;
            }

            //报数
            for (int j=0;j<countNum-1;j++){
                first = first.getNext();
                helper = helper.getNext();
            }

            System.out.println("小孩"+first.getNo()+"出圈~");
            //设置小孩出圈
            first = first.getNext();
            helper.setNext(first);
        }
        System.out.println("最后在圈里的小孩编号为:"+first.getNo());

    }

    /**
     * 添加节点的方法
     * @param nums  要添加几个节点的数值
     */
    public void addBoy(int nums){

        if(nums < 1){  //判断数值是否小于1，如果是，没有意义
            System.out.println("输入的数值不正确~");
            return;
        }

        Boy curBoy = null;  //辅助指针
        for(int i=1;i<=nums;i++){
            Boy boy = new Boy(i);  //创建一个节点
            if(i == 1){  //判断是否是第一个节点

                first = boy;  //添加头部节点
                first.setNext(first);  //添加的节点的next指向头部，形成环形链表
                curBoy = first;  //让curBoy指向第一个小孩
            }else {

                curBoy.setNext(boy);  //设置连接添加的节点
                boy.setNext(first);  //添加的节点的next指向头部，形成环形链表
                curBoy = boy;  //指针后移
            }

        }

    }

    /**
     * 查询全部
     */
    public void findAll(){

        if(first == null){  //判断链表是否为空
            System.out.println("该链表为空~");
            return;
        }

        Boy curBoy = first;  //辅助指针
        while (true){

            System.out.println(curBoy);  //输出信息
            if(curBoy.getNext() == first){  //判断是否遍历完成
                break;
            }
            curBoy = curBoy.getNext();  //指针后移
        }


    }


}
//创建一个实体
class Boy {
    private int no;
    private Boy next;

    public Boy(int no) {
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "Boy{" +
                "no=" + no +
                '}';
    }
}