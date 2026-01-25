package com.netta.automation.tests.ui;

import com.microsoft.playwright.*;
import com.netta.automation.config.TestConfig;
import com.netta.automation.extensions.AllureArtifactsExtension;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.RegisterExtension;

public abstract class BaseUiTest {

    protected Playwright playwright;
    protected Browser browser;
    protected Page page;

    @RegisterExtension
    TestWatcherExtension watcher = new TestWatcherExtension();

    // Small wrapper so @RegisterExtension can be created before @BeforeEach
    class TestWatcherExtension extends AllureArtifactsExtension {
        TestWatcherExtension() { super(null); }
        void setPage(Page page) { this.pageRef = page; }

        // Hack-free way: keep a mutable reference
        private Page pageRef;

        @Override
        public void testFailed(ExtensionContext context, Throwable cause) {
            if (pageRef != null) {
                try {
                    String url = pageRef.url();
                    io.qameta.allure.Allure.addAttachment("Page URL", "text/plain", url);
                    byte[] png = pageRef.screenshot(new Page.ScreenshotOptions().setFullPage(true));
                    io.qameta.allure.Allure.addAttachment("Screenshot", "image/png",
                            new java.io.ByteArrayInputStream(png), ".png");
                } catch (Exception ignored) {}
            }
        }
    }

    @BeforeEach
    void setUp() {
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
                .setHeadless(TestConfig.headless()));

        page = browser.newPage();
        page.setDefaultTimeout(TestConfig.timeoutMs());

        // give extension access to page
        watcher.setPage(page);
    }

    @AfterEach
    void tearDown() {
        if (page != null) page.close();
        if (browser != null) browser.close();
        if (playwright != null) playwright.close();
    }
}