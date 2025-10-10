import static java.lang.ScopedValue.where;

static final ScopedValue<String> CONTEXT = ScopedValue.newInstance();

// JEP 506: Scoped Values
// https://openjdk.org/jeps/506

void main() {
    where(CONTEXT, "CTX-12345").run(() -> {
        foo();
        bar();
    });

    /*
    foo sees context: CTX-12345
    bar sees context: CTX-12345
    bar->nested sees: CTX-OVERRIDE
    bar after nested sees: CTX-12345
    * */
}

static void foo() {
    System.out.println("foo sees context: " + CONTEXT.get());
}

static void bar() {
    System.out.println("bar sees context: " + CONTEXT.get());
    // Nested binding
    where(CONTEXT, "CTX-OVERRIDE").run(() -> {
        System.out.println("bar->nested sees: " + CONTEXT.get());
    });
    System.out.println("bar after nested sees: " + CONTEXT.get());
}