package study.note03.readFile03;/*
 *@Auther: wzy
 *@Date:2021/12/28 -12-28
 *@Descreption: study.note03
 *@Version: 1.0
 */


import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class readFile {
    public static void main(String[] args) throws IOException {
//        student stu=new student();
//        stu.setName("wzy");
//        stu.setGrade("b");
//
//        System.out.println(stu.isANiceStu(stu));


        InputStream in=new FileInputStream("D:\\文件\\研\\javaCode\\DataStructure\\src\\main\\java\\study\\note03\\info.txt");
        Scanner scanner = new Scanner(in, "UTF-8");
        while (scanner.hasNextLine()){
            String info= scanner.nextLine();
            String[] infos=info.split(",");
            student student = new student();
            student.setName(String.valueOf(infos[0]));
            student.setAge(Integer.valueOf(infos[1]));
            student.setGrade(Double.valueOf(infos[2]));
            System.out.println(student.toString());
        }
        in.close();

    }



}
