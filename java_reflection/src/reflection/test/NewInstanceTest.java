package reflection.test;

import org.junit.Test;
import java.util.Random;


/**
 * 通过反射去创建对应的运行时类的对象
 * @author han yao
 * @date 2020/12/1 11:57
 */
public class NewInstanceTest {
    @Test
    public void test1() throws Exception{
        Class clazz = Person.class;
        /*
        newInstance(): 调用此方法，创建对应的运行时类的对象
        要想次方法正常的创建运行时类的对象，要求：
        1. 内部调用了运行时类的空参构造器
        2. 此构造器的访问权限要够。通常设置为public
        所以在Java bean中要求有一个空参的public构造器，原因：
        1. 便于通过反射创建运行时类的对象
        2. 便于子类继承此运行时类时，默认调用super()时,保证父类有此构造器
        只要是造对象，就一定会用到构造器
         */
        Person obj = (Person) clazz.newInstance();  // 这里默认调用了空参的构造器
        System.out.println(obj);

        /*
        调用指定的含参的构造器
        明确调用类中的构造器，并将参数传递进去之后，可以实例化操作。步骤如下
        通过Class类的getDeclaredConstructor(Class … parameterTypes)取得本类的指定形参类型的构造器
        向构造器的形参中传递一个对象数组进去，里面包含了构造器中所需的各个参数
         */
        Person obj1 = (Person) clazz.getDeclaredConstructor(String.class, int.class).newInstance("A",1);
        System.out.println(obj1);
    }


    /*
    反射的动态性
    创建一个指定类的对象
     */
    @Test
    public void test2(){
        // 编译时无法确定创建的对象，只有运行才会确定
        int num = new Random().nextInt(3);
        String classPath = "";
        switch (num){
            case 0:
                classPath = "java.util.Date";
                break;
            case 1:
                classPath = "java.lang.Object";
                break;
            case 2:
                classPath = "reflection.test.Person";
                break;
        }
        try{
            Object obj = getInstance(classPath);
            System.out.println(obj);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /*
    创建一个指定类的对象
    classPath: 指定类的全类名
     */
    public Object getInstance(String classPath) throws Exception{
        Class clazz = Class.forName(classPath);
        return clazz.newInstance();
    }
}
