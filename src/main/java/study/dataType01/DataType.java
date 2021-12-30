package study.dataType01;/*
 *@Auther: wzy
 *@Date:2021/12/27 -12-27
 *@Descreption: study.note01
 *@Version: 1.0
 */

public class DataType {
    public static void main(String[] args) {
        byte a=-128;//1B
        short g;//2B
        int b;//4B
        long c;//8B
        double d;//8B
        float e;//4B
        char f;//2B
        boolean h;

        System.out.println();
        /*
        * 多态特性——函数的使用不仅仅看函数名，还要看形参。
        * 形参不同，所调用的函数也会自动调整
        * */

        int j=119;
        for (int i=0;i<10;i++){
            a=(byte)j;
            j++;
        }
    }
}
