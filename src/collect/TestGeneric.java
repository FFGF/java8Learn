package collect;

import java.util.ArrayList;
import java.util.List;

/**
 * Create by fengguofei
 * Date: 2018/5/16
 * Time: 8:47
 */
public class TestGeneric {

    public List<Course> courses;

    public TestGeneric(){
        this.courses = new ArrayList<Course>();
    }

    public void testAdd(){
        courses.add(new Course(1, "大学语文"));
        courses.add(new Course(2, "汇编语言"));
    }

    public void testForEach(){
        for(Course temp:courses){
            System.out.println(temp);
        }
    }

    public void testChild(){
        ChildCourse ccr = new ChildCourse();
        ccr.id = 3;
        ccr.name = "我是子类";
        courses.add(ccr);
    }

    public static void main(String[] args) {
//        TestGeneric tg = new TestGeneric();
//        tg.testAdd();
//        tg.testForEach();
//        tg.testChild();
//        tg.testForEach();
       int[] score = new int[]{20,22,34};
        System.out.println(score[0]);
        int fgf[] = new int[]{34,56};
        System.out.println(fgf[0]);
    }
}
