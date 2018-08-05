package reflect;

import java.lang.reflect.Method;

/**
 * Create by fengguofei
 * Date: 2018/5/10
 * Time: 10:48
 */
public class ReflectCase {

    public static void main(String[] args) throws Exception {
        Proxy target = new Proxy();
        Method method = Proxy.class.getDeclaredMethod("run");
        method.invoke(target);
    }

    static class Proxy {
        public void run() {
            System.out.println("run");
        }
    }
}
