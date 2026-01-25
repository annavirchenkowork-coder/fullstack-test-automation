package com.netta.automation.pages;

import com.microsoft.playwright.Page;

public class TheInternetHomePage {
    private final Page page;

    public TheInternetHomePage(Page page) {
        this.page = page;
    }

    public TheInternetHomePage open() {
        page.navigate("https://the-internet.herokuapp.com/");
        return this;
    }

    public void goTo(String linkText) {
        page.getByRole(com.microsoft.playwright.options.AriaRole.LINK,
                new Page.GetByRoleOptions().setName(linkText)).click();
    }
}