package pakage1;

public class hello {
    public static void main(String[] args){
        System.out.println("hello");
        test();
    }

    public static void test() {
        Count c = new Count();
        addCount(c);
        System.out.println(c.a);
    }

    public static void addCount(Count tmp){
        tmp.a++;
    }
}

class Count{
    public int a = 1;
}