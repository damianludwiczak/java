package com.javafee.java.lessons.CrudApp.service;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Utils {
    public static final String ACCOUNT_FILE = "account_v1.db";
    public static final String CLIENT_FILE = "client_v1.db";
    public static final String COMPANY_FILE = "company_v1.db";

    public static String createMd5(String password) {
        String md5 = null;
        try {
            MessageDigest digest = MessageDigest.getInstance("MD5");
            digest.update(password.getBytes(), 0, password.length());
            md5 = new BigInteger(1, digest.digest()).toString(16);
        } catch (NoSuchAlgorithmException e) {
            System.err.println(e.getMessage());
        }
        return md5;
    }
}
