package study.note02.arraysAndStrings02;/*
 *@Auther: wzy
 *@Date:2021/12/27 -12-27
 *@Descreption: study.note02
 *@Version: 1.0
 */

import java.util.Arrays;


public class Array {

   
    public static void main(String[] args) {
        int Maxsize=10;

        //创建数组
        int[] a = new int[Maxsize];
        //数据初始值都为类型的初始值，数字为0，字符为null
        for(int i=0;i<a.length;i++){
            System.out.print(a[i]+" ");
        }
        //尝试赋值
        a[0]=2;
        System.out.println("\n"+a[0]);

//        若想要直接初始化赋值
        int[] b={6,5,4,3,2,1};
//        上下两行代码效果一样
        int[] c=new int[]{1,2,3,4,5,6};

//        迭代器输出数组元素
        for(int i : c){
            System.out.print(" "+i);
        }
//        用数组tostring方法来输出数组元素
        System.out.println(Arrays.toString(b));

        int[][] q={
                {1,2,3},
                {2,3,4},
                {3,4,5},
                {5,6,7}
        };
        System.out.println(Arrays.toString(q));
        //java二维数组实际是一维指针数组加上多个类型数组，即引用
        //因此上面实际输出的是数组的地址
        for (int[] p:q){
            System.out.println(Arrays.toString(p));
        }
        //上面这种方法才能完整输出二维数组
    }
}
