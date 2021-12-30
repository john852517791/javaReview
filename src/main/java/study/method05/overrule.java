package study.method05;/*
 *@Auther: wzy
 *@Date:2021/12/30 -12-30
 *@Descreption: study.note05
 *@Version: 1.0
 */

import study.objectOriented04.person;

public class overrule extends person {
    public static void main(String[] args) {
        overrule overrule = new overrule();
        overrule.drink();
    }
    public void drink(){
        System.out.println("overrule");
    }
}
