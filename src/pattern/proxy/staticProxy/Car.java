package pattern.proxy.staticProxy;

import java.util.Random;

/**
 * Create by fengguofei
 * Date: 2018/8/5
 * Time: 13:39
 */
public class Car implements Moveable{

    @Override
    public void move() {
//        long starttime = System.currentTimeMillis();
//        System.out.println("汽车开始行驶。。。");
        //实现开车
        try {
            Thread.sleep(new Random().nextInt(1000));
            System.out.println("汽车行驶中。。。");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        long endtime = System.currentTimeMillis();
//        System.out.println("汽车结束行驶。。。 汽车行驶时间：" + (endtime - starttime) + "毫秒！");
    }
}
