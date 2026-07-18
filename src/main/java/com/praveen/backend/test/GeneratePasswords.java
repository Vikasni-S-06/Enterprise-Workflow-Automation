package com.praveen.backend.test;

import com.praveen.backend.util.PasswordUtil;

public class GeneratePasswords {

    public static void main(String[] args) {

        System.out.println("admin123   : " + PasswordUtil.hashPassword("admin123"));
        System.out.println("manager123 : " + PasswordUtil.hashPassword("manager123"));
        System.out.println("employee123: " + PasswordUtil.hashPassword("employee123"));
        System.out.println("hr123      : " + PasswordUtil.hashPassword("hr123"));

    }

}