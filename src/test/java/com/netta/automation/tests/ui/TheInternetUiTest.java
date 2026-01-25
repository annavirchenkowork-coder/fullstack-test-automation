package com.netta.automation.tests.ui;

import com.netta.automation.pages.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TheInternetUiTest extends BaseUiTest {

    @Test
    void dropdownSelectionWorks() {
        TheInternetHomePage home = new TheInternetHomePage(page).open();
        home.goTo("Dropdown");

        DropdownPage dropdown = new DropdownPage(page);
        dropdown.selectOption("2");

        assertEquals("2", dropdown.selectedValue());
    }

    @Test
    void checkboxesCanBeToggled() {
        TheInternetHomePage home = new TheInternetHomePage(page).open();
        home.goTo("Checkboxes");

        CheckboxesPage checkboxes = new CheckboxesPage(page);

        checkboxes.setChecked(1, true);
        assertTrue(checkboxes.isChecked(1));

        checkboxes.setChecked(2, false);
        assertFalse(checkboxes.isChecked(2));
    }

    @Test
    void dynamicLoadingExample2ShowsHelloWorld() {
        DynamicLoadingExample2Page dynamic = new DynamicLoadingExample2Page(page);
        dynamic.open();
        dynamic.start();

        assertEquals("Hello World!", dynamic.finishText());
    }
}