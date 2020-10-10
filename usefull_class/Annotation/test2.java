package usefull_class.Annotation;

import java.lang.annotation.*;

import static java.lang.annotation.ElementType.*;

import java.lang.ProcessBuilder.Redirect.Type;

@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target({TYPE, FIELD, METHOD, PARAMETER, CONSTRUCTOR, LOCAL_VARIABLE,TYPE_PARAMETER,TYPE_USE})
public @interface test2 {
    test1[] value();
}
