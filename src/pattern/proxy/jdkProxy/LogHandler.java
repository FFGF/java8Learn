package pattern.proxy.jdkProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Create by fengguofei
 * Date: 2018/8/5
 * Time: 16:15
 */
public class LogHandler implements InvocationHandler {

    private Object target;

    public LogHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("日志开始。。。");
        method.invoke(target);
        System.out.println("日志结束。。。");
        return null;
    }
}
