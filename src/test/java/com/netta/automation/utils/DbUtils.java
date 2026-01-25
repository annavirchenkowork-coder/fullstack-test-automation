package com.netta.automation.utils;

import java.sql.Connection;
import java.sql.DriverManager;

public final class DbUtils {
    private DbUtils() {}

    public static boolean isConfigured() {
        String url = System.getProperty("DB_URL", System.getenv("DB_URL"));
        String user = System.getProperty("DB_USER", System.getenv("DB_USER"));
        String pass = System.getProperty("DB_PASS", System.getenv("DB_PASS"));
        return url != null && !url.isBlank()
                && user != null && !user.isBlank()
                && pass != null && !pass.isBlank();
    }

    public static Connection openConnection() throws Exception {
        String url = System.getProperty("DB_URL", System.getenv("DB_URL"));
        String user = System.getProperty("DB_USER", System.getenv("DB_USER"));
        String pass = System.getProperty("DB_PASS", System.getenv("DB_PASS"));

        if (url == null || user == null || pass == null) {
            throw new IllegalStateException("DB_URL/DB_USER/DB_PASS must be set to use DB utilities");
        }
        return DriverManager.getConnection(url, user, pass);
    }
}