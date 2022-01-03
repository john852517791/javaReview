package study.note05.method05;/*
 *@Auther: wzy
 *@Date:2021/12/31 -12-31
 *@Descreption: study.note05.method05
 *@Version: 1.0
 */

public class polymorphism {
    public static void main(String[] args) {
        student[] stus={
                new stuOfAI(80,60),
                new stuOfEC(80,60)
        };
        for (student stu:stus
             ) {
            System.out.println(stu.finalGrade());
            System.out.println(stu.toString());
        }
    }
}
class student{
    protected double regular;

    protected double finalMark;
    public  double finalGrade(){
        return 0;
    }

    public student(double regular, double finalMark) {
        this.regular = regular;
        this.finalMark = finalMark;
    }

    @Override
    public String toString() {
        return "平时成绩："+this.regular+",期末考试成绩："+this.finalMark+"\n最终成绩："+this.finalGrade();
    }

}

class stuOfAI extends student{
    public stuOfAI(double regular, double finalMark) {
        super(regular, finalMark);
    }

    @Override
    public double finalGrade(){
        return 0.3*this.regular+0.7*this.finalMark;
    }
}


class stuOfEC extends student{
    public stuOfEC(double regular, double finalMark) {
        super(regular, finalMark);
    }

    @Override
    public double finalGrade(){
        return 0.5*this.regular+0.5*this.finalMark;
    }
}
