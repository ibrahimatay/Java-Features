import module java.desktop;

void main() {
    // JEP 476: Module Import Declarations (Preview)
    // https://openjdk.org/jeps/476

    // reddit discussions
    // https://www.reddit.com/r/java/comments/1c6k2dn/jep_476_module_import_declarations_preview/
    // https://www.reddit.com/r/java/comments/1bqneuy/jep_draft_module_import_declarations_preview/

    Date d = new Date();
    println(String.format("Date: %1$s", d));
}