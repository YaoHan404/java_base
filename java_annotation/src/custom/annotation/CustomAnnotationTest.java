package custom.annotation;

/**
 * @Author: han yao
 * @Date: $(DATE) 15:23
 */
public class CustomAnnotationTest {
    public static void main(String[] args){
        test();
    }

    // 给Annotation的属性赋值
    @MyAnnotation(value = "hello")
    public static void test(){
        System.out.println("using my annotation");
    }
}
