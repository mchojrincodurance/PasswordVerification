package com.codurance.password;

public class MinimumUnderscoresValidation extends ValidationRule {

    public static final char UNDERSCORE = '_';
    private final long minUnderscores;

    public MinimumUnderscoresValidation(int minUnderscores) {
        super("Minimum underscores error");
        this.minUnderscores = minUnderscores;
    }

    @Override
    public boolean isValid(String password) {
        return password.chars().filter(c -> c == UNDERSCORE).count() >= minUnderscores;
    }
}
