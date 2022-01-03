package study.note06.abstractClass06;

/**
 * @author：wzy
 * @date：2022/1/2-01-02-10:56
 */
public class sample {
    public static void main(String[] args) {
        foobar exm = new example();
        exm.drink();
        exm.method();
    }
}

abstract class foobar{
    abstract void drink();
    void method(){

    }
}

class example extends foobar{

    @Override
    void drink() {
        System.out.println("实现完成");

    }

    void method(){
        System.out.println("覆写");
    }
}
