package study.note05.method05;/*
 *@Auther: wzy
 *@Date:2021/12/30 -12-30
 *@Descreption: study.note05
 *@Version: 1.0
 */

public class overload {
    public static void main(String[] args) {
        sample sample = new sample();
        sample.foobar();
        sample.foobar(1,2);
    }
}

class sample{
    public void foobar(){
        System.out.println("无参");
    }
    public void foobar(int i,int j){
        System.out.println("有参");
    }

}