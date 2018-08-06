package pattern.proxy.simulateProxy;

import java.lang.reflect.Method;

/**
 * Create by fengguofei
 * Date: 2018/8/6
 * Time: 10:11
 */
public interface InvocationHandler {

    void invoke(Object o, Method m);
}
