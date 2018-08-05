package reflect;

/**Class类的使用
 * Create by fengguofei
 * Date: 2018/5/9
 * Time: 21:14
 */
public class main {

    public static void main(String[] args) {

        Foo foo1 = new Foo();

        //第一种表示方式
        Class c1 = Foo.class;
        //第二种表示方式
        Class c2 = foo1.getClass();
        System.out.println(c1 == c2);
        //第三种表示
        Class c3 = null;
        try {
            c3 = Class.forName("reflect.Foo");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(c2 == c3);
        try {
            Foo foo = (Foo) c1.newInstance();
            foo.print();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}

class Foo{
    void print(){
        System.out.println("我是Foo");
    }
}
