package ru.vsenauka;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class PageOfBookSearch {
    private SelenideElement author = $("input[name='author']"),
            yearFrom = $("a[href='#book3']"),
            yearOfPublishing = $("input[name='year_since']"),
            checkResultOnPage = $(".result.row");


    public PageOfBookSearch openingWebsite() {
        open("knigi/vsenauchnyie-knigi/");
        return this;
    }

    public PageOfBookSearch settingFirstName(String authorName) {
        author.setValue(authorName).pressEnter();
        return this;
    }

    public PageOfBookSearch settingYearFromSearch(String startYearFromSearch) {
        yearFrom.click();
        yearOfPublishing.setValue(startYearFromSearch).pressEnter();
        return this;
    }

    public PageOfBookSearch checkingOutBooks() {
        $(".book-result").should(exist);
        return this;
    }

    public PageOfBookSearch checkingResultFormValues(String validateValue) {
        checkResultOnPage.shouldHave(text(validateValue)).shouldBe(visible);
        return this;
    }
}
