package study.note02.arraysAndStrings02;/*
 *@Auther: wzy
 *@Date:2021/12/28 -12-28
 *@Descreption: study.note02
 *@Version: 1.0
 */

public class Strings {

    public static void main(String[] args) {
        String a="abc";
        System.out.println(a);
        String b="abc中文";
        //单步调试会发现，字符串其实是某种【char】类型的数组形式
        System.out.println(b);
        System.out.println(b.charAt(3)+"+++"+b.charAt(4));
        System.out.println(b.charAt(3)+b.charAt(4));
        //asc码相加
        System.out.println(b.charAt(3)+""+b.charAt(4));

        System.out.println(a.equals(b.charAt(0)+""+b.charAt(1)+""+b.charAt(2)));
    }
}
