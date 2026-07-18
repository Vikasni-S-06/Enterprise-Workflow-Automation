package com.praveen.backend.util;

import org.mindrot.jbcrypt.BCrypt;

/**
 * Utility class for password hashing and verification.
 */
public class PasswordUtil {

    /**
     * Hash a plain text password.
     */
    public static String hashPassword(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt(12));
    }

    /**
     * Verify a plain password against the hashed password.
     */
    public static boolean verifyPassword(String plainPassword,
                                         String hashedPassword) {

        if (plainPassword == null || hashedPassword == null) {
            return false;
        }

        return BCrypt.checkpw(plainPassword, hashedPassword);

    }

}