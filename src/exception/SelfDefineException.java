package exception;

public class SelfDefineException {
}

//先继承现有的异常结构
//class MyException extends Exception
class MyException extends RuntimeException{
    //全局常量，它是对我们这个类的标识
    //和IO流有关，序列化机制，不同主机上的同名方法同名类可能不一样
    static final long serialVersionUID = -5148515613L;
    public MyException(){

    }
    public MyException(String msg){

    }
}