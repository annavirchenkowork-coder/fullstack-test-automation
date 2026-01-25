package com.netta.automation.pages;

import com.microsoft.playwright.Page;

public class DropdownPage {
    private final Page page;

    public DropdownPage(Page page) {
        this.page = page;
    }

    public void selectOption(String optionValue) {
        page.locator("#dropdown").selectOption(optionValue); // "1" or "2"
    }

    public String selectedValue() {
        return page.locator("#dropdown").inputValue();
    }
}