package com.praveen.backend.util;

import java.util.regex.Pattern;

public class ValidationUtil {

    private ValidationUtil() {
    }

    private static final Pattern EMAIL_PATTERN =
            Pattern.compile("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");

    private static final Pattern PHONE_PATTERN =
            Pattern.compile("^[6-9]\\d{9}$");

    public static boolean isValidEmail(String email) {

        if (email == null || email.isBlank()) {
            return false;
        }

        return EMAIL_PATTERN.matcher(email).matches();

    }

    public static boolean isValidPhone(String phone) {

        if (phone == null || phone.isBlank()) {
            return false;
        }

        return PHONE_PATTERN.matcher(phone).matches();

    }

    public static boolean isValidPassword(String password) {

        if (password == null) {
            return false;
        }

        return password.length() >= 8;

    }

}