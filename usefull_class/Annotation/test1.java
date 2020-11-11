// package usefull_class.Annotation;

// import java.lang.annotation.Inherited;


// @Inherited //可以继承
// public @interface test1 {
//     String value() default "hello";
// }
package usefull_class.Annotation;

import java.lang.annotation.*;

import static java.lang.annotation.ElementType.*;

import java.lang.ProcessBuilder.Redirect.Type;

/**
 * @author shkstart
 * @create 2019 上午 11:56
 */

@Inherited
@Repeatable(test2.class) //课重复使用注解
// @Repeatable(MyAnnotations.class)
//!RUNTIME生命周期的注解，才能通过反射获取
@Retention(RetentionPolicy.RUNTIME)
//!可以修饰那种元素
@Target({TYPE, FIELD, METHOD, PARAMETER, CONSTRUCTOR, LOCAL_VARIABLE,TYPE_PARAMETER,TYPE_USE})
public @interface test1 {
    String value() default "hello";
}