package pattern.proxy.jdkProxy;

import pattern.proxy.staticProxy.Car;
import pattern.proxy.staticProxy.Moveable;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * Create by fengguofei
 * Date: 2018/8/5
 * Time: 15:21
 */
public class Test {

    /**
     * jdk动态代理测试
     * @param args
     */
    public static void main(String[] args) {
        Car car = new Car();
        InvocationHandler h = new TimeHandler(car);
        Class<?> cls = car.getClass();

        /**
         * loader 类加载器
         * interfaces 实现接口
         * h InvocationHandler
         */
        Moveable m = (Moveable) Proxy.newProxyInstance(cls.getClassLoader(), cls.getInterfaces(), h);

        System.out.println("代理类名字： " + m.getClass().getName());

        InvocationHandler hLog = new LogHandler(m);
        Class<?> clsLog = m.getClass();
        Moveable mLog = (Moveable)Proxy.newProxyInstance(clsLog.getClassLoader(), clsLog.getInterfaces(), hLog);

        mLog.move();
    }
}
