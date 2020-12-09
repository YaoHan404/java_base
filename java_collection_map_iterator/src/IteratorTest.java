import java.util.*;

/**
 * @Author: han yao
 * @Date: $(DATE) 14:15
 */
public class IteratorTest {
    public static void main(String[] args){
        test1();
    }
    public static void test1(){
        LinkedHashSet l = new LinkedHashSet();

    }

}

class HashCodeTest{
    int age;
    String name;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        HashCodeTest that = (HashCodeTest) o;

        if (age != that.age) return false;
        return name != null ? name.equals(that.name) : that.name == null;
    }

    @Override
    public int hashCode() {
        int result = age;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}
