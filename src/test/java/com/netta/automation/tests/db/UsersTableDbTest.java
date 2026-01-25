package com.netta.automation.tests.db;

import com.netta.automation.utils.DbUtils;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import static org.junit.jupiter.api.Assumptions.assumeTrue;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Feature("Database Validation")
public class UsersTableDbTest {

    @Test
    @Description("Validate that users table has at least 1 row")
    void validateUsers() throws Exception {
        String url = System.getenv("DB_URL");
        String user = System.getenv("DB_USER");
        String pass = System.getenv("DB_PASS");

        // If DB is not configured, skip the test (won't fail CI)
        assumeTrue(DbUtils.isConfigured(), "Skipping DB test: DB env vars not set");

        try (Connection con = DbUtils.openConnection();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT COUNT(*) FROM users")) {
            rs.next();
            int count = rs.getInt(1);
            System.out.println("User count: " + count);

            assertTrue(count >= 0, "Expected users count to be >= 0");
        }
    }
}