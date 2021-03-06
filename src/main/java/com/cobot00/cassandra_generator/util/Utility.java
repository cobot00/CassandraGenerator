package com.cobot00.cassandra_generator.util;

import java.io.File;

import com.google.common.base.CaseFormat;

public class Utility {

    private Utility() {
        // no instance
    }

    public static String toLowerCamel(String word) {
        return CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, word);
    }

    public static String toUpperCamel(String word) {
        return CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.UPPER_CAMEL, word);
    }

    public static String toFilePath(String packagePath) {
        String[] dirs = packagePath.split("\\.");
        return String.join(File.separator, dirs);
    }
}
