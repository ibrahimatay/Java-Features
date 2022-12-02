[![Java CI with Maven](https://github.com/ibrahimatay/Java-Features/actions/workflows/maven.yml/badge.svg)](https://github.com/ibrahimatay/Java-Features/actions/workflows/maven.yml)

# Core Java Features
Examples of the Java programming language feature.

## Version History

* [Java 11](java-11/) (September, 2018)
  * [JEP 181](https://openjdk.java.net/jeps/181): Nest-Based Access Control
  * [JEP 318](https://openjdk.java.net/jeps/318): Epsilon: A No-Op Garbage Collector
  * [JEP 321](https://openjdk.java.net/jeps/321): HTTP Client (Standard)
  * [JEP 323](https://openjdk.java.net/jeps/323): Local-Variable Syntax for Lambda Parameters
  * [JEP 327](https://openjdk.java.net/jeps/327): Unicode 10
  * [JEP 329](https://openjdk.java.net/jeps/329): ChaCha20 and Poly1305 Cryptographic Algorithms
  * [JEP 332](https://openjdk.java.net/jeps/332): Transport Layer Security (TLS) 1.3
  * API Improvements
    * New String Methods
      * `isBlank()`
      * `lines()` 
      * `repeat()` 
      * `strip()`, `stripLeading()`, `stripTrailing()`
    * New File Methods 
      * `readString(Path)`
      * `writeString(Path, CharSequence, OpenOption...)`
      * `writeString(Path.of("message.txt"), updatedMessage)`
    * New `Collection.toArray()` Method

  
* [Java 10](java-10/) (March, 2018)
  * [JEP 286](https://openjdk.java.net/jeps/286): Local-Variable Type Inference
  * [JEP 314](https://openjdk.java.net/jeps/314): Additional Unicode Language-Tag Extensions
  * [JEP 322](https://openjdk.java.net/jeps/322): Time-Based Release Versioning
  * API Improvements
    * Standard Class Libraries
      * `java.lang.management.RuntimeMXBean.getPid()`: Returns the pid of the running JVM.
    * New Collection Methods
      * `List.copyOf()`
      * `Set.copyOf()` 
      * `Map.copyOf()`
    * New Stream Methods
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
  * [JEP 150](https://openjdk.java.net/jeps/150): Date & Time API
  * [JEP 174](https://openjdk.java.net/jeps/174): Nashorn JavaScript Engine
  * Method Reference
  * Stream API
  * Base64
  * Static and Default Methods in Interface
  * Functional interface 
  * Optional 

## Notes
- [The Java Version Almanac](https://javaalmanac.io/)
- [JDK Release Notes](https://www.oracle.com/java/technologies/javase/jdk-relnotes-index.html)
- [Place to get early releases from Oracle's JDK](https://jdk.java.net/)
- [OpenJDK Projects](https://openjdk.java.net/projects/)
- [What is the difference (or relation) between JLS, JSR and JEP?](https://stackoverflow.com/questions/51282326/what-is-the-difference-or-relation-between-jls-jsr-and-jep)
