#!/usr/bin/bash

# JEP 474: ZGC: Generational Mode by Default
# https://openjdk.org/jeps/474

# Openjdk pull request
# https://github.com/openjdk/jdk/pull/18393

# JEP 474: Generational Mode Now Standard for ZGC in Java
# https://www.infoq.com/news/2024/05/java-zgc-update/

# https://www.reddit.com/r/programming/comments/9bhltd/javas_new_z_garbage_collector_zgc_is_very_exciting/

# Java's new Z Garbage Collector (ZGC) is very exciting
# https://www.opsian.com/blog/javas-new-zgc-is-very-exciting/

# Maybe it will come in handy: https://chriswhocodes.com/vm-options-explorer.html

# -XX:+UseZGC -XX: => Refuse to start with error message
# -XX:+UseZGC -XX:-ZGenerational -XX: => Same as above
# -XX:+UseZGC -XX:-ZGenerational -XX: => Start (with message about deprecation of non-generational ZGC)

# java -XX:+UseZGC -Xmx4G -Xms4G -jar Main.jar
# java -XX:+UseZGC -XX:-ZGenerational -Xmx4G -Xms4G -jar Main.jar
