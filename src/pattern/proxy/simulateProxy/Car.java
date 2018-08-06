package pattern.proxy.simulateProxy;

import java.util.Random;

/**
 * Create by fengguofei
 * Date: 2018/8/5
 * Time: 13:39
 */
public class Car implements Moveable{

    @Override
    public void move() {
        //实现开车
        try {
            Thread.sleep(new Random().nextInt(1000));
            System.out.println("汽车行驶中。。。");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
