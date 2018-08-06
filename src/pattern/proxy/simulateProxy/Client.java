package pattern.proxy.simulateProxy;

/**
 * Create by fengguofei
 * Date: 2018/8/5
 * Time: 20:04
 */
public class Client {

    public static void main(String[] args) throws Exception {
        Car car = new Car();
        InvocationHandler h = new TimeHandler(car);
        Moveable m = (Moveable) Proxy.newProxyInstance(Moveable.class, h);
        m.move();

//        System.out.println(System.getProperty("sun.boot.class.path"));
//        System.out.println(System.getProperty("java.ext.dirs"));
//        System.out.println(System.getProperty("java.class.path"));

//        ClassLoader cl = Test.class.getClassLoader();
//        System.out.println("ClassLoader is:" + cl.toString());
//        System.out.println("ClassLoader\'s parent is: " + cl.getParent().toString());
//        System.out.println("ClassLoader\'s grand father is: " + cl.getParent().getParent().toString());

//        DiskClassLoader diskLoader = new DiskClassLoader("D:\\Document\\java8Learn\\bin\\pattern\\proxy\\simulateProxy");
//        Class c = diskLoader.loadClass("pattern.proxy.simulateProxy.$Proxy0");
//        System.out.println(c.getName());
    }
}
