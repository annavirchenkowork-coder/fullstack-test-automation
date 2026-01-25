package com.netta.automation.pages;

import com.microsoft.playwright.Page;

public class DynamicLoadingExample2Page {
    private final Page page;

    public DynamicLoadingExample2Page(Page page) {
        this.page = page;
    }

    public void open() {
        page.navigate("https://the-internet.herokuapp.com/dynamic_loading/2");
    }

    public void start() {
        page.locator("#start button").click();
    }

    public String finishText() {
        // Wait for "Hello World!" to appear
        page.locator("#finish").waitFor();
        return page.locator("#finish").innerText().trim();
    }
}