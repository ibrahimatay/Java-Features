package com.ibrahimatay;

import java.util.Arrays;
import java.util.stream.Collectors;

/*
* javap - The Java Class File Disassembler
* https://docs.oracle.com/javase/7/docs/technotes/tools/windows/javap.html
* https://docs.oracle.com/en/java/javase/11/tools/javap.html
*
* JEP 181: Nest-Based Access Control
* https://openjdk.org/jeps/181
* */
public class NestBasedAccessControl {
    public void publicMethod() {

    }

    private void privateMethod() {

    }

    class NestedClass {
        public void nestedPublic() {

        }
    }

    class NestedClass2 {
        public void nestedPublic2() {

        }
    }

    static class NestedClass3 {
        public void nestedPublic3() {

        }
    }

    public static void main(String[] args) {
        Class<?> nestedHost = NestBasedAccessControl.class.getNestHost();
        Arrays.stream(nestedHost.getNestMembers()).collect(Collectors.toList()).forEach(System.out::println);
        // class com.ibrahimatay.NestBasedAccessControl
        // class com.ibrahimatay.NestBasedAccessControl$NestedClass

        Class<?>[] nestedMembers = NestBasedAccessControl.class.getNestMembers();
        Arrays.stream(nestedMembers).collect(Collectors.toList()).forEach(System.out::println);
        // class com.ibrahimatay.NestBasedAccessControl
        // class com.ibrahimatay.NestBasedAccessControl$NestedClass

        System.out.println("NestedClass class is class in NestBasedAccessControl:"+ NestBasedAccessControl.class.isNestmateOf(NestedClass.class));
        System.out.println("NestBasedAccessControl class is not class in NestedClass:"+ NestedClass.class.isNestmateOf(NestBasedAccessControl.class));
        // NestedClass class is class in NestBasedAccessControl:true
        // NestBasedAccessControl class is not class in NestedClass:true
    }
}
