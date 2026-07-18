package com.praveen.backend.test;

import com.praveen.backend.util.ValidationUtil;

public class TestValidationUtil {

    public static void main(String[] args) {

        System.out.println(
                ValidationUtil.isValidEmail("admin@workflow.com"));

        System.out.println(
                ValidationUtil.isValidPhone("9876543210"));

        System.out.println(
                ValidationUtil.isValidPassword("admin123"));

    }

}