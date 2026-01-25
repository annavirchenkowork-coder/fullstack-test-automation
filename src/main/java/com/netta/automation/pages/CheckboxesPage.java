package com.netta.automation.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class CheckboxesPage {
    private final Page page;

    public CheckboxesPage(Page page) {
        this.page = page;
    }

    private Locator checkbox(int index1Based) {
        // The page has two checkboxes; index 1 or 2
        return page.locator("#checkboxes input").nth(index1Based - 1);
    }

    public void setChecked(int index1Based, boolean shouldBeChecked) {
        Locator cb = checkbox(index1Based);
        if (shouldBeChecked) cb.check();
        else cb.uncheck();
    }

    public boolean isChecked(int index1Based) {
        return checkbox(index1Based).isChecked();
    }
}