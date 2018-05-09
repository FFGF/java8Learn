package annotation;

/**
 * Create by fengguofei
 * Date: 2018/5/9
 * Time: 9:29
 */
@Description("I am class annotation")
public class Child implements Person {

    @Override
    @Description("I am method annotation")
    public String name() {
        return null;
    }

    @Override
    public Integer age() {
        return null;
    }

    @Override
    public void sing() {

    }
}
