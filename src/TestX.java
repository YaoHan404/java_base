import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @Author: han yao
 * @Date: $(DATE) 20:10
 */
public class TestX {
    public static void main(String[] args){
        new Test1().test();
    }
}

class Test1{
    public void test(){
        try {
            InetAddress address = InetAddress.getLocalHost();
            address.getClass();
            System.out.println(address);
        }catch (UnknownHostException e){
            System.out.println(e);
        }


    }
}
