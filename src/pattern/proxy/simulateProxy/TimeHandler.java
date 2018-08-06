package pattern.proxy.simulateProxy;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Create by fengguofei
 * Date: 2018/8/6
 * Time: 10:16
 */
public class TimeHandler implements InvocationHandler {

    private Object target;

    public TimeHandler(Object target) {
        super();
        this.target = target;
    }

    @Override
    public void invoke(Object o, Method m) {

        try {
            long starttime = System.currentTimeMillis();
            System.out.println("汽车开始行驶。。。");
            m.invoke(target);
            long endtime = System.currentTimeMillis();
             System.out.println("汽车结束行驶。。。 汽车行驶时间：" + (endtime - starttime) + "毫秒！");
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
