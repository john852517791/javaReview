# 快速找回java的记忆

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

继承会形成继承树

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

复写的概念和继承相关

在继承关系中，子类继承了父类的方法和变量，但有些时候子类需要方法操作与父类有些许不同，因此就需要复写这个方法

⭐这里的复写方法需要签名与父类相同，即方法名以及形式参数都相同



⭐Question：override和overrule很容易搞混，一不小心形式参数写的不一致就会造成“本来想复写”，结果变成了复写

解决方式——加@overrule注解，这样的话如果形参写错了会直接报错



## polymorphism

