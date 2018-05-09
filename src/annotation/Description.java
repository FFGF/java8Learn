package annotation;

import java.lang.annotation.*;

/**
 * Create by fengguofei
 * Date: 2018/5/9
 * Time: 14:33
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface Description {
    String value();
}
