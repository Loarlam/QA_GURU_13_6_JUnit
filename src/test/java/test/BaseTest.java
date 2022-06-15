package test;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import ru.vsenauka.PageOfBookSearch;

public class BaseTest {

    PageOfBookSearch pageOfBookSearch = new PageOfBookSearch();

    @BeforeAll
    static void beforeAllTests() {
        Configuration.baseUrl = "https://vsenauka.ru/";
        Configuration.browserSize = "1920x1080";
        Configuration.browserPosition = "0x0";
    }
}