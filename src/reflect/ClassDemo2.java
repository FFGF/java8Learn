package reflect;

/**
 * Create by fengguofei
 * Date: 2018/5/9
 * Time: 21:50
 */
public class ClassDemo2 {

    public static void main(String[] args) {

        Class c1 = int.class;
        Class c2 = String.class;
        Class c3 = double.class;
        Class c4 = Double.class;
        Class c5 = void.class;

        System.out.println(c1.getName());
        System.out.println(c2.getName());
        System.out.println(c2.getSimpleName());
        System.out.println(c5.getSimpleName());
    }
}
