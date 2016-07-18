package edu.vs.project.parser;

/**
 * Created by varunsh on 7/14/2016.
 */
public class Validation {
    public static boolean isInteger (String value) {
        return value.matches("^-?\\d+$");
    }

    public static boolean isBoolean (String value) {
        return "true".equals(value) || "false".equals(value);
    }
}
