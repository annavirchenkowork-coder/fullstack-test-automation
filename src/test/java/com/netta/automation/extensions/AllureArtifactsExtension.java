package com.netta.automation.extensions;

import com.microsoft.playwright.Page;
import io.qameta.allure.Allure;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;

import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;
import java.util.Optional;

public class AllureArtifactsExtension implements TestWatcher {

    private final Page page;

    public AllureArtifactsExtension(Page page) {
        this.page = page;
    }

    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {
        attachUrl();
        attachScreenshot();
    }

    // Optional: attach URL even on success (comment out if you want only on failure)
    @Override
    public void testSuccessful(ExtensionContext context) {
        // attachUrl();
    }

    private void attachUrl() {
        try {
            String url = page.url();
            Allure.addAttachment("Page URL", "text/plain",
                    new ByteArrayInputStream(url.getBytes(StandardCharsets.UTF_8)), ".txt");
        } catch (Exception ignored) {}
    }

    private void attachScreenshot() {
        try {
            byte[] png = page.screenshot(new Page.ScreenshotOptions().setFullPage(true));
            Allure.addAttachment("Screenshot", "image/png",
                    new ByteArrayInputStream(png), ".png");
        } catch (Exception ignored) {}
    }
}