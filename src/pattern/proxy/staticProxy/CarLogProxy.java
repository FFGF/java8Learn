package pattern.proxy.staticProxy;

/**
 * Create by fengguofei
 * Date: 2018/8/5
 * Time: 14:23
 */
public class CarLogProxy implements Moveable {
    private Moveable m;

    public CarLogProxy(Moveable m) {
        super();
        this.m = m;
    }

    @Override
    public void move() {
        System.out.println("日志开始。。。");
        m.move();
        System.out.println("日志结束。。。");
    }
}
