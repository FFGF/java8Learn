package annotation;

/**
 * Create by fengguofei
 * Date: 2018/5/9
 * Time: 9:27
 */
public interface Person {

    public String name();

    public Integer age();

    @Deprecated
    public void sing();
}
