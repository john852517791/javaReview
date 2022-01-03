package study.note06.studyInterface;

/**
 * @author：wzy
 * @date：2022/1/3-01-03-11:40
 */
public interface sample {

    public emo  foobar();
    public emo  foobar1();


}


interface random extends sample{
    public emo foobar2();

}

class emo implements random{

    @Override
    public emo foobar() {
        System.out.println("foobar");
        return this;
    }

    @Override
    public emo foobar1() {
        System.out.println("foobar1");
        return this;
    }

    @Override
    public emo foobar2() {
        System.out.println("foobar2");
        return this;
    }
}