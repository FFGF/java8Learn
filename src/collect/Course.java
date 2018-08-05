package collect;

/**
 * Create by fengguofei
 * Date: 2018/5/16
 * Time: 8:55
 */
public class Course {

    public int id;
    public String name;

    public Course(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Course(){

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Course)) return false;

        Course course = (Course) o;

        if (id != course.id) return false;
        return name != null ? name.equals(course.name) : course.name == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
