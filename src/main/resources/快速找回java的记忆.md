# 快速找回java的记忆

# 声明

文档部分是根据B站UP刘二大人的java基础视频整理而来，后面部分则是根据java官网教程整理

[刘二大人——java基础]: https://www.bilibili.com/video/BV1nZ4y1G7g1
[java官网教程]: https://docs.oracle.com/javase/tutorial/tutorialLearningPaths.html



# Datatype

byte

int

long

float

double

char

boolean

# ArraysAndStrings

数组需要new来创建

```java
int[] array=new int[20];
```

语法糖直接使用{}

```java
int[] array={1,2,3,4,5}
```

会自动计算数组长度

数组实例有一些方法

```java
array.length
```

遍历数组

```java
for(int a: array){
	system.out.println(a);
}
```



字符串String

```java
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
//引用对象是否相等的判别需要使用实例的equals方法
```



# ObjectOriented

```java
public class student {
    private String name;
    private int age;
    private boolean gender;
    private String grade;

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
            throw new IllegalArgumentException("wrong score");
        }
        this.age = age;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
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
    boolean isANiceStu(student stu){
        if(stu.getGrade()=="A"){
            return true;
        }else
            return false;
    }
}
```



tips:

​	1.将变量类型设置为private，防止直接访问对象变量，也可以在参数赋值里面加一些限制

​	2.可在对象类中设置方法，private即外界无法访问，default与public外界可以访问

⭐this

这个this指的是所用实例，利用return this可以搞链式编程

⭐引用类型的数据变动问题

在给对象赋值的时候，要注意是否是引用类型，如数组

要避免另外的变量能改变数据，从而导致对象里的数据跟着改变了



# read file

从文件中获取数据，再将数据进行拆分赋值给对象

使用对象为student，对象的变量包括name【string】、age【int】、grade【double】

```txt
wzy,22,4.0
ljx,22,5.0
mzy,21,5.0
```

读取数据流，需要inputstream和scanner的协助

```java
InputStream in=new FileInputStream("D:\\文件\\研\\javaCode\\DataStructure\\src\\main\\java\\study\\note03\\info.txt");
Scanner scanner = new Scanner(in, "UTF-8");
```

再借助scanner对象来读取文件，以行为单位来读取

```java
while (scanner.hasNextLine()){
            String info= scanner.nextLine();
            String[] infos=info.split(",");
            student student = new student();
            student.setName(String.valueOf(infos[0]));
            student.setAge(Integer.valueOf(infos[1]));
            student.setGrade(Double.valueOf(infos[2]));
            System.out.println(student.toString());
            }
```

首先是读取一行，这一整行数据以单个字符串形式存在

再对字符串进行拆分，拆分的数据赋值给字符串数组，使用split函数

最终取数据的时候再做类型转换，调用string、integer、double等类型中自带的valueof方法



⭐warn——在用上述方法读完文件之后，最好在最后关文件

即调用inputstream对象的close方法



⭐question

若需要将整个文件的数据放到一个数组中，但不知道数据个数怎么办？

⭐answer

笨比方法——在数据第一行标明有多少个

后面要学的——用集合



# inheritance

## graph

继承关系即多叉树【继承树】

树中的节点都会有各自的方法和变量【has】

子节点继承父节点会继承父节点所有的变量与方法【子属于父，但父不属于子】

⭐java只能单继承

## how to inherit

继承实例

关系：person、student、teacher三个类，student与teacher以person为父类

```java
public class person {
    protected String name;
    protected int age;

    public person() {
    }

    public person(String name, int age) {
        this.name = name;
        this.age = age;
    }

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
        this.age = age;
    }
}
```



```java
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

```



```java
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
```

## constructor

类的构造函数分有参构造和无参构造

这个很好理解

但继承关系中，构造就需要注意父类是否有相应的构造函数

如上一小节中的代码

⭐person中的构造为两个参数构造【对person来说是全参构造】，那么在子类中创建全参构造时候就需要使用super关键字来调用父类的构造来辅助完成构造

【super指的是当前所使用的类的上一级父类；this指的是当前所使用的类】

## protected

**question**：子类拥有父类的变量，若父类的变量为private属性，子类就会出现一种尴尬的境地——子类拥有变量但不能直接访问到继承自父类的变量

**how to solve**：将变量的private改为protected，使这个变量只能被子类直接访问，而不能被其他的类直接访问到，相当于对子类为public、对其他类为private

## class casting

### creating objects

在创建对象的时候，创建的子类能被父类所接受，但创建的父类不能用子类来接受，如下

```java
student stu = new student();
//正确
person stu = new person();
//正确

person stu = new student();
//正确
student stu = new person();
//错误
```

### using objects

⭐向上转型

```java
person stu = new student();
```

由上述方法所创建的stu对象，只能使用person类中的方法与变量

但允许如下强制类型转换

```java
student stup = (student)stu;
```

转换之后就可以调用student以及person中的方法和变量



⭐warn：向下转型

若是如下操作，会报class cast exception错误

```java
person stu = new person();
((student)stu).method();
```

因为对象的初始化是person类型，强制转换在编译时不会检查类型是否符合，会在方法被调用运行时检测出类型不匹配

### instanceof method

⭐question：我们如何直接的判断对象是否属于某个继承树呢

解决方法：使用instance of方法

```java
person stu = new student();
boolean b = stu instanceof person;
```

这个方法会返回一个布尔类型

A instanceof B

其会判断A是否为B类或者B类的子类



# method

## overload

重载的概念与方法相关

在C语言中，方法的唯一签名即方法名

在java中，方法的唯一签名为方法名和形式参数【⭐不包括返回值类型 】

因此允许同名不同参数的方法存在

典型的例子就是对象的构造函数，允许无参和有参

## override

覆写的概念和继承相关

在继承关系中，子类继承了父类的方法和变量，但有些时候子类需要方法操作与父类有些许不同，因此就需要复写这个方法

⭐这里的复写方法需要签名与父类相同，即方法名以及形式参数都相同



⭐Question：override和overload很容易搞混，一不小心形式参数写的不一致就会造成“本来想覆写”，结果变成了重载

解决方式——加@override注解，这样的话如果形参写错了会直接报错



## polymorphism

多态

由于java中，创建子类对象能被父类所接住，即如下【父类为person，子类为student】

```java
person stu = new student();
```

这就很自然的出现疑问：

按照上述方法创建的对象stu，我调用的this，到底是person的还是student的

答案：new后面是啥，this指的就是啥

⭐应用场景①：需要管理学生成绩，而学生中不同学院的学生成绩计算方法可能不一致，55开37开都有，怎那么统一管理学生还能区分不同计算方法来计算成绩呢？

——我们可以构造一棵继承树，不同学院的学生继承自一个统一的父类，父类中有计算成绩的方法，让子类来覆写方法即可，如下

```java
public class polymorphism {
    public static void main(String[] args) {
        student[] stus={
                new stuOfAI(80,60),
                new stuOfEC(80,60)
        };
        for (student stu:stus
             ) {
            System.out.println(stu.finalGrade());
        }
    }
}
class student{
    protected double regular;
    protected double finalMark;
    public double finalGrade(){
        return 0;
    }

    public student(double regular, double finalMark) {
        this.regular = regular;
        this.finalMark = finalMark;
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
```

这样的话，所有学生都能在一个数组中维护，并且有各自的方法来计算成绩



⭐应用场景②：子类中有共同的方法，如tostring方法，我们可以利用多态来将此方法提取出来放到父类中，简化代码【善用this】

在父类中覆写tostring方法如下

```java
@Override
    public String toString() {
        return "平时成绩："+this.regular+",期末考试成绩："+this.finalMark+"\n最终成绩："+this.finalGrade();
    }
```

我们就可以在遍历中，student对象调用此方法还能调用正确的期末成绩计算方法



## final

当使用final关键字来修饰类、方法以及变量时候，默认其不能再被改变

变量——其初始化有两种方法，如下

```java
final int age=0;
```

```java
final int age;
//在构造方法中进行赋值
public student(age){
	this.age=age;
}
```

类——用final修饰完之后，此类不允许被继承

```java
final class lastSon(){
	
}
```

方法——用final修饰之后，此方法不能被覆写【以上面的学生最终成绩的方法为例】

```java
public final double finalGrade(){
        return 0;
    }
```



# abstract

abstract抽象修饰符 

用来修饰方法和类，且是同时出现的

即若有方法是抽象的，这个类一定是抽象类

且若类为抽象类，则其至少有一个方法为抽象类

⭐应用场景——很多情况下，父类的方法并不需要父类自己实现，甚至说父类都不需要实现，而是让子类自己去各自实现。若加上个abstract就标明这个方法必须由子类来自己实现



# interface

接口——定义：一种特殊的抽象类，其中没有变量，没有方法的实现，只有方法的声明

tips——接口之间是可以互相继承的



⭐question——java中只提供单继承，那么当多个子类实现了新的方法A，我们很自然的会想着提取这些共同的方法A到父类，实际上不能，因为还有其他子类没有实现这个方法A，那么该如何扩展？

【如父类为门，方法为开门关门，子类包括：密码门、指纹门、钥匙门、无锁门等等，其中有些门有锁的功能，有的没有，因此不能把锁这个方法提取到父类门中】

⭐接口机制就很好的解决了这种问题，因为接口可以实现多“继承”【其实是实现接口】











