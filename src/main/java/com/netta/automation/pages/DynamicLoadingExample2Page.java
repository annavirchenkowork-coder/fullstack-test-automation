package com.netta.automation.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class DynamicLoadingExample2Page {
    private final Page page;

    private final Locator startButton;
    private final Locator finishMessage;

    public DynamicLoadingExample2Page(Page page) {
        this.page = page;
        this.startButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Start"));
        this.finishMessage = page.locator("#finish h4"); // the actual "Hello World!" text element
    }

    public void open() {
        page.navigate("https://the-internet.herokuapp.com/dynamic_loading/2");
    }

    public void start() {
        startButton.click();
    }

    public String finishText() {
        finishMessage.waitFor();
        return finishMessage.innerText().trim();
    }
}