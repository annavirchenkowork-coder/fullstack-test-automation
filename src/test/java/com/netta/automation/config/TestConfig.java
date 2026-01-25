package com.netta.automation.config;

public final class TestConfig {
    private TestConfig() {}

    public static boolean headless() {
        String prop = System.getProperty("HEADLESS");
        if (prop != null) return Boolean.parseBoolean(prop);

        String env = System.getenv("HEADLESS");
        if (env != null) return Boolean.parseBoolean(env);

        return true;
    }

    public static String baseUrl() {
        String prop = System.getProperty("BASE_URL");
        if (prop != null && !prop.isBlank()) return prop;

        String env = System.getenv("BASE_URL");
        if (env != null && !env.isBlank()) return env;

        return "https://the-internet.herokuapp.com/";
    }

    public static int timeoutMs() {
        String prop = System.getProperty("TIMEOUT_MS");
        if (prop != null) return Integer.parseInt(prop);
        return 30_000;
    }
}