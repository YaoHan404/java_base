package exception;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Throws {
    public static void main(String[] args){
        ExceptionTest1 e1 = new ExceptionTest1();
//        e1.test2();  // 直接调用会报错
        try{
           e1.test2(); // 在try里面就不会报错
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}

class ExceptionTest1{



    public void test(){
        File file = new File("Hello.java");
//        FileInputStream fis = new FileInputStream(file);
        // 此时是编译时异常
        // 因为文件可能不存在
    }

    public void test1() throws FileNotFoundException{
        File file = new File("Hello.java");
        FileInputStream fis = new FileInputStream(file);
        // 同样的代码，此时就没有异常了
    }

    // 调用test()1，也得throws
    public void test2() throws FileNotFoundException{
        test1();
    }
}