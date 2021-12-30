package study.objectOriented04;/*
 *@Auther: wzy
 *@Date:2021/12/30 -12-30
 *@Descreption: study.note04
 *@Version: 1.0
 */

public class teacher extends person {
    private int salary;
    public teacher(){

    }
    public teacher(int salary) {
        this.salary = salary;
    }

    public teacher(String name, int age, int salary) {
        super(name, age);
        this.salary = salary;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}
