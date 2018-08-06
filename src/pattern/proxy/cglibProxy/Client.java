package pattern.proxy.cglibProxy;

/**
 * Create by fengguofei
 * Date: 2018/8/5
 * Time: 18:55
 */
public class Client {

    public static void main(String[] args) {

        CglibProxy proxy = new CglibProxy();
        Train t = (Train)proxy.getProxy(Train.class);

        t.move();
    }
}
