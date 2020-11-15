package string;

/**
 * @author han yao
 * @date 2020/11/12 下午8:20
 */
public class StringTest {
    public static void main(String[] args){
        new Test().test2();
    }
}

class Test{
    public void test2(){
        String str = null;

    }

    public void test1(){
        String s = "abc";
        String s1 = s + "aa";
        System.out.println(s1);
        s = "xxx";
        System.out.println(s1);
    }
    public void test(){
        String s1 = "abc";  //没有new，而是字面量的定义方式
        String s2 = "abc";

        /*
        比较 s1 和 s2 的地址，相同
        s1 s2 指向 方法区的字符串常量池，而不是堆空间
        常量池不会保存相同的数据，总是复用
         */
        System.out.println(s1 == s2);  // true
        System.out.println("*****************");


        /*
        由于String中的char[] value 是 final 的无法修改，所以修改s1,
        会在字符串常量池中创建一个新的字符串，s1指向新的字符串
        s2指向原来的字符串（原来的字符串无法被修改）
         */
        s1 = "hello";
        System.out.println(s1);   // hello
        System.out.println(s2);   // abc
        System.out.println("*****************");


        /*
        对现有的字符串进行连接操作，也需要重新指定内存区域赋值，
        不能在原来的value上增加，即会新建一个字符串
         */
        String s3 = "abc";
        s3 += "def";
        System.out.println(s3);  // abcdef
        System.out.println(s2);  // abc
        System.out.println("*****************");


        /*
        当调用replace()方法时，也需要重新指定内存区域赋值，
        不能在原来的value上修改，即会新建一个字符串
         */
        String s4 = "abc";
        String s5 = s4.replace('a', 'e');
        System.out.println(s4);   // abc
        System.out.println(s5);   // ebc
        System.out.println("*****************");


        String s6 = "abc";
        String s7 = "abc";
        String s8 = new String("abc");
        String s9 = new String("abc");
        System.out.println(s6 == s7);  // true
        System.out.println(s8 == s9);  // false
        System.out.println("*****************");
    }
}
