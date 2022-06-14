package test;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import ru.vsenauka.PageOfBookSearch;

public class TestBaseIncludingBeforeAndAfterTests {

    PageOfBookSearch pageOfBookSearch = new PageOfBookSearch();

    @BeforeAll
    static void beforeAllTests() {
        Configuration.baseUrl = "https://vsenauka.ru/";
        Configuration.browserSize = "1920x1080";
        Configuration.browserPosition = "0x0";
    }

    @AfterAll
    static void afterAllTest() throws InterruptedException {
        Configuration.holdBrowserOpen = true;
        Thread.sleep(1000);
        Configuration.holdBrowserOpen = false;
    }
}