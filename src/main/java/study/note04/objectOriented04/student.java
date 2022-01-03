package study.note04.objectOriented04;/*
 *@Auther: wzy
 *@Date:2021/12/30 -12-30
 *@Descreption: study.note04
 *@Version: 1.0
 */

public class student extends person {
    private double grade;

    public  student(){

    }
    public student(double grade) {
        this.grade = grade;
    }

    public student(String name, int age, double grade) {
        super(name, age);
        this.grade = grade;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }
}
