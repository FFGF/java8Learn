package reflect;

import java.lang.reflect.Method;

/**
 * Create by fengguofei
 * Date: 2018/5/9
 * Time: 21:53
 */
public class ClassUtil {

    public static void printClassMessage(Object obj){

        Class c = obj.getClass();

        System.out.println("类的名称是： " + c.getName());

        Method[] ms = c.getMethods();
    }
}
