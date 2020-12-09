package custom.annotation;

/**
 * @Author: han yao
 * @Date: $(DATE) 17:31
 */

// 1. 注解声明为 @interface
// 自定义注解必须配上注解的信息处理流程（使用反射）才有意义
public @interface MyAnnotation {
    // 2. 内部的成员，用方法的写法来写，可以在外面使用时赋值
    // 如果自定义Annotation里啥也没有，那就是一个标识的作用，例如@Override
    String value();
    // 2. 内部的成员，用方法的写法来写，可以给它默认值
    String value1() default "world";
//    String[] value(); // 多个参数
}
