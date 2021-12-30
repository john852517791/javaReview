package study.readFile03;/*
 *@Auther: wzy
 *@Date:2021/12/28 -12-28
 *@Descreption: study.note03
 *@Version: 1.0
 */

public class student {
    private String name;
    private int age;
    private boolean gender;
    private double grade;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if(age<0||age>1000){
            throw new IllegalArgumentException();
        }
        this.age = age;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public Double getGrade() {
        return grade;
    }

    public void setGrade(Double grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                ", grade='" + grade + '\'' +
                '}';
    }
//    boolean isANiceStu(student stu){
//        if(stu.getGrade()=="A"){
//            return true;
//        }else
//            return false;
//    }
}
