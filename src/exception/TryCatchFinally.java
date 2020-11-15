package exception;

public class TryCatchFinally {
    public static void main(String[] args){
        ExceptionTest e = new ExceptionTest();
        e.test();
    }
}

class ExceptionTest{
    public void test(){
        String str = "abc";
        try{
            int num = Integer.parseInt(str);
            //异常之后的代码不执行
            System.out.println("aaaaa");
        }catch (NumberFormatException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
            System.out.println("bbbbb");
        }
        // 后续的代码可以继续运行
        System.out.println("ccccc");
    }
    //输出结果是：bbbbb ccccc

    public void test1(){
        String str = "abc";
        int num = Integer.parseInt(str);
        System.out.println("aaaaa");
    }
    //输出结果：出现Exception报错
}