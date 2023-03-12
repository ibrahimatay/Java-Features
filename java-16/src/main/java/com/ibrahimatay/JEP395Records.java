package com.ibrahimatay;

/*
* JEP 395: Records / Java 16
* https://openjdk.org/jeps/395
*
* JEP 359: Records (Preview) / Java 14
* https://openjdk.org/jeps/359
*
* JEP 384: Records (Second Preview) / Java 15
* https://openjdk.org/jeps/384
* */
public class JEP395Records {
    public static void main(String[] args) {
        var developer01 = new Developer(1, "Ibrahim", "contact@ibrahimatay.com");
        System.out.println(developer01);

        var developer02 = new Developer.Builder(42).name("Ibrahim").email("contact@ibrahimatay.com");
        System.out.println(developer02);
    }
}

record Developer(Integer id, String name, String email) {
    public static final class Builder {
        private Integer id;
        private String name;
        private String email;

        Builder(Integer id) {
            this.id = id;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        @Override
        public String toString() {
            return "Developer.Builder{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", email='" + email + '\'' +
                    '}';
        }
    }
};



