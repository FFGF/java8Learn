package pattern.proxy.staticProxy;

/**
 * Create by fengguofei
 * Date: 2018/8/5
 * Time: 13:45
 */
public class Client {

    public static void main(String[] args) {
//        Car car = new Car();
//        car.move();

          //使用集成方式
//        Moveable m = new Car2();
//        m.move();

        //使用聚合方式实现
//        Car car = new Car();
//        Moveable m = new Car3(car);
//        m.move();

        Car car = new Car();
        CarLogProxy clp = new CarLogProxy(car);
        CarTimeProxy ctp = new CarTimeProxy(clp);
        ctp.move();

    }
}
