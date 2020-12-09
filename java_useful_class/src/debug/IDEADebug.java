package debug;
import org.junit.Test;
/**
 * @author han yao
 * @date 2020/11/14 下午1:00
 */
public class IDEADebug {
    @Test
    public void testStringBuffer(){
        String str = null;
        StringBuffer sb = new StringBuffer();
        sb.append(str);

        System.out.println(sb.length()); //4  ('n' 'u' 'l' 'l' 四个char)
        System.out.println(sb); //"null"

        StringBuffer sb1 = new StringBuffer(str); // 抛出异常
        System.out.println(sb1);  // null
    }
}
