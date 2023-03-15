package com.ibrahimatay;

import java.lang.annotation.*;
import java.lang.reflect.Method;

public class JSR175Annotations {
    public static void main(String[] args) {
        if(Foo.class.isAnnotationPresent(AuthorInfo.class)){
            System.out.println("AuthorInfo Annotation inside foo class");
        }

        AuthorInfo info = Foo.class.getAnnotation(AuthorInfo.class);
        System.out.println(String.format("name = %s, email = %s, comment = %s", info.name(), info.email(), info.comment()));

        try {
            Method method = Foo.class.getMethod("bar", null);
            if(method.isAnnotationPresent(AuthorInfo.class)){
                AuthorInfo infoMethod = method.getAnnotation(AuthorInfo.class);
                System.out.println(String.format("ame = %s, email = %s, comment = %s", infoMethod.name(), infoMethod.email(), infoMethod.comment()));
            }
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }
}

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
@Inherited
@interface AuthorInfo {
    public String name();
    public String email() default "";
    public String comment() default "";
}

@AuthorInfo(name = "Ibrahim")
class Foo {
    @AuthorInfo(name = "Ibrahim", email = "contact@ibrahimatay.com", comment = "method comment")
    public void bar() {

    }
}