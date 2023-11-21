[![Java CI with Maven](https://github.com/ibrahimatay/Java-Features/actions/workflows/maven.yml/badge.svg)](https://github.com/ibrahimatay/Java-Features/actions/workflows/maven.yml)

# Core Java Features
This repository contains Java examples that are designed to track and document the progress of Java Enhancement Proposals (JEPs), Java Specification Requests (JSRs), and Java Language Revisions (JLRs). These examples provide a comprehensive overview of the various changes, updates, and improvements made to the Java language and platform over time.

## Specifications & Practices

* [Java 21](java-21) (September, 2023)
  * [JEP 430](java-21/src/main/java/com/ibrahimatay/JEP430StringTemplates.java): String Templates
  * [JEP 431](java-21/src/main/java/com/ibrahimatay/JEP431SequencedCollections.java): Sequenced Collections
  * [JEP 444](java-21/src/main/java/com/ibrahimatay/JEP444VirtualThreads.java): Virtual Threads

* [Java 17](java-17/) (September, 2021)
  * [JEP 409](java-17/src/main/java/com/ibrahimatay/JEP409SealedClasses.java): Sealed Classes

* [Java 16](java-16/) (March, 2021)
  * [JEP 395](java-16/src/main/java/com/ibrahimatay/JEP395Records.java): Records

* [Java 11](java-11/) (September, 2018)
  * [JEP 181](java-11/src/main/java/com/ibrahimatay/JEP181NestBasedAccessControl.java): Nest-Based Access Control
  * [JEP 318](java-11/src/main/java/com/ibrahimatay/JEP318MemoryPolluter.java): Epsilon: A No-Op Garbage Collector
  * [JEP 321](java-11/src/main/java/com/ibrahimatay/JEP321HTTPClient.java): HTTP Client (Standard)
  * [JEP 323](java-11/src/main/java/com/ibrahimatay/JEP323LocalVariableSyntaxForLambdaParameters.java): Local-Variable Syntax for Lambda Parameters
  * [JEP 327](java-11/src/main/java/com/ibrahimatay/JEP327Unicode10.java): Unicode 10
  * [JEP 329](java-11/src/main/java/com/ibrahimatay/JEP329ChaCha20Poly1305.java): ChaCha20 and Poly1305 Cryptographic Algorithms
  * [JEP 332](java-11/src/main/java/com/ibrahimatay/JEP332TLS13.java)): Transport Layer Security (TLS) 1.3
  * API Improvements
    * [New String Methods](java-11/src/main/java/com/ibrahimatay/NewFileMethods.java)
      * `isBlank()`
      * `lines()` 
      * `repeat()` 
      * `strip()`, `stripLeading()`, `stripTrailing()`
    * [New File Methods](java-11/src/main/java/com/ibrahimatay/NewStringMethods.java) 
      * `readString(Path)`
      * `writeString(Path, CharSequence, OpenOption...)`
      * `writeString(Path.of("message.txt"), updatedMessage)`
    * [New Collection.toArray() Method](java-11/src/main/java/com/ibrahimatay/NewCollectionToArrayMethod.java)
 
* [Java 10](java-10/) (March, 2018)
  * [JEP 286](java-10/src/main/java/com/ibrahimatay/JEP286LocalVariableTypeInference.java): Local-Variable Type Inference
  * [JEP 314](java-10/src/main/java/com/ibrahimatay/JEP314AdditionalUnicodeLanguage.java): Additional Unicode Language-Tag Extensions
  * [JEP 322](java-10/src/main/java/com/ibrahimatay/JEP322TimeBasedReleaseVersioning.java): Time-Based Release Versioning
  * API Improvements
    * [Standard Class Libraries](java-10/src/main/java/com/ibrahimatay/NewRuntimePIDMethods.java)
      * `java.lang.management.RuntimeMXBean.getPid()`: Returns the pid of the running JVM.
    * [New Collection Methods](java-10/src/main/java/com/ibrahimatay/NewCollectionMethods.java)
      * `List.copyOf()`
      * `Set.copyOf()` 
      * `Map.copyOf()`
    * [New Stream Methods](java-10/src/main/java/com/ibrahimatay/NewStreamMethods.java)
      * `Collectors.toUnmodifiableList() `
      * `Collectors.toUnmodifiableSet()`
      * `Collectors.toUnmodifiableMap()`
      * `Optional.orElseThrow()`

* [Java 9](java-9/) (September, 2017)
  * [JEP 110](https://openjdk.java.net/jeps/110): HTTP/2 Client
  * [JEP 213](https://openjdk.java.net/jeps/213): Milling Project Coin
    * The try-with-resources Improvements
    * Private Methods in the Interface
    * Using underscores in numeric literals
    * SafeVarargs to Support Private Methods

* [Java 8](java-8/) (March, 2014)
  * [JEP 135](https://openjdk.java.net/jeps/135): Base64 Encoding & Decoding
  * [JEP 174](https://openjdk.java.net/jeps/174): Nashorn JavaScript Engine
  * [JEP 150](https://openjdk.java.net/jeps/150): Date & Time API
  * [JEP 107](https://openjdk.java.net/jeps/107): Bulk Data Operations for Collections (`java.util.stream`)
  * [JSR 335](https://jcp.org/en/jsr/detail?id=335)
    * Lambda Expressions
    * Default Methods in Interfaces
    * Functional Interfaces
    * Optional
    * Method References

* [Java 7](java-7/) (September, 2011)
    
* [Java 6](java-6/) (December, 2006)
  * [JSR 160](https://www.jcp.org/en/jsr/detail?id=160): Management Extensions (JMX) Remote API
  
* [Java 5](java-5/) (September, 2004) 
  * [JSR 166](https://jcp.org/en/jsr/detail?id=166): Concurrency Utilities (`java.util.concurrent`)
  * [JSR 14](https://jcp.org/en/jsr/detail?id=14): Generics
  * [JSR 175](https://jcp.org/en/jsr/detail?id=175): Annotations 
  * [JSR 201](https://jcp.org/en/jsr/detail?id=201)
    * Autoboxing
    * `static import` Statement (`import static java.lang.Math.PI;`)
    * For-each Loops (`for ( : )`)
    * Var Args (`public static void greets(String greeting, String... names)`)

## Notes
- [The Java Version Almanac](https://javaalmanac.io/)
- [JDK Release Notes](https://www.oracle.com/java/technologies/javase/jdk-relnotes-index.html)
- [Place to get early releases from Oracle's JDK](https://jdk.java.net/)
- [OpenJDK Projects](https://openjdk.java.net/projects/)
- [List of all Java Specification Requests (JSRs)](https://jcp.org/en/jsr/all)
- [What is the difference (or relation) between JLS, JSR and JEP?](https://stackoverflow.com/questions/51282326/what-is-the-difference-or-relation-between-jls-jsr-and-jep)
- [Maven Plugins Compatibility Plan](https://maven.apache.org/developers/compatibility-plan.html)
- [VM Options Explorer](https://chriswhocodes.com/)
- [Java upgrade example errors and solutions](https://github.com/johanjanssen/JavaUpgrades)
