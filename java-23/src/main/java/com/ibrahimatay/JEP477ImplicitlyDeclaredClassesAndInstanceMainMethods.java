// JEP 477: Implicitly Declared Classes and Instance Main Methods
// https://openjdk.org/jeps/477

void main() {
    System.out.println("Hello, World!");

    String name = readln("Please enter your name: ");
    print("Pleased to meet you, ");
    println(name);

    // output:
    // Hello, World!
    // Please enter your name: İbrahim
    // Pleased to meet you, İbrahim
}