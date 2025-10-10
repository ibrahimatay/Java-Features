
// JEP 511: Module Import Declarations
// https://openjdk.org/jeps/511

// Discussion regarding module imports (JEP 511)
// https://www.reddit.com/r/java/comments/1k683ad/discussion_regarding_module_imports_jep_511/

import module java.sql;

import java.sql.Date;

void main(String[] args) {

    Date d = Date.valueOf("2025-06-15");
    System.out.println("Resolved Date: " + d);

    // Resolved Date: 2025-06-15
}
