package annotation;

/**
 * Create by fengguofei
 * Date: 2018/5/9
 * Time: 9:32
 */
public class Test {

    @SuppressWarnings("deprecation")
    public void sing(){
        Person p = new Child();
        p.sing();
    }
}