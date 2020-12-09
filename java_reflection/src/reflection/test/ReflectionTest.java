package reflection.test;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectionTest {

    @Test
    public void test1() throws Exception{
        Class cla = Person.class;
        // 1. 通过反射，调用对象的构造器，创建Person类的对象
        Constructor cons = cla.getConstructor(String.class, int.class);  // 创建构造器
        Object obj  = cons.newInstance("Tom", 12);   // 调用构造器
        System.out.println(obj.toString());

        // 2.通过反射，调用对象指定的属性
        Field age = cla.getDeclaredField("age");
        age.set(obj, 10);
        System.out.println(obj.toString());

        // 3，通过反射，调用对象指定的方法
        Method show = cla.getDeclaredMethod("show");
        show.invoke(obj);

        // 4. 通过反射，调用对象private构造器、属性、方法
        Constructor cons1 = cla.getConstructor(String.class);  // 调用私有构造器
        cons1.setAccessible(true);
        Person p1 = (Person)cons1.newInstance("Jerry");
        System.out.println(p1);
        Field privateName = cla.getDeclaredField("name");  // 调用私有属性
        privateName.setAccessible(true);
        privateName.set(p1, "NewJerry");
        Method privateShowNation = cla.getDeclaredMethod("showNation", String.class);  // 调用私有方法
        privateShowNation.setAccessible(true);
        privateShowNation.invoke(p1, "中国");

    }
}
