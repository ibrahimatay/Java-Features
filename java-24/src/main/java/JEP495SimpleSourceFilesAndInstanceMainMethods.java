// JEP 495: Simple Source Files and Instance Main Methods (Fourth Preview)
// https://openjdk.org/jeps/495

public void main() {
    System.out.printf("%1$s + %2$s = %3$s", 1,2, sum(1,2));
}

int sum(int x, int y) {
    return x+y;
}