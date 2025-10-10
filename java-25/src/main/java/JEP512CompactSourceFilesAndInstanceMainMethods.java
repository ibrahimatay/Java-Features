
// JEP 512: Compact Source Files and Instance Main Methods
// https://openjdk.org/jeps/512

// Compact Source Files and Instance main Methods
// https://docs.oracle.com/en/java/javase/25/language/compact-source-files-and-instance-main-methods.html

void main() {
    IO.println("Hello, World!");

    String name = IO.readln("Enter your name: ");
    IO.println("Nice to meet you, " + name);

    // Nice to meet you, İbrahim

    var authors = List.of("Alice", "Bob");
    IO.println(authors.get(0));

    // Alice
}
