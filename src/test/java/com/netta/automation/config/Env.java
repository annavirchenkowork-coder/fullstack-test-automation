package com.netta.automation.config;
import io.github.cdimascio.dotenv.Dotenv;

public final class Env {
    private static final Dotenv DOTENV = Dotenv.configure()
            .ignoreIfMissing()
            .load();

    public static String get(String key, String defaultValue) {
        String sys = System.getProperty(key);
        if (sys != null && !sys.isBlank()) return sys;

        String env = System.getenv(key);
        if (env != null && !env.isBlank()) return env;

        String dot = DOTENV.get(key);
        if (dot != null && !dot.isBlank()) return dot;

        return defaultValue;
    }
}