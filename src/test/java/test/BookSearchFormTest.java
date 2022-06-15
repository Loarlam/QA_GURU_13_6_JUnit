package test;

import enumValues.YearsWithBooks;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.stream.Stream;

public class BookSearchFormTest extends TestBaseIncludingBeforeAndAfterTests {

    @DisplayName("Проверяем наличие хотя бы одной книги на сайте \"Всенаука\"")
    @Test
    void displayNameTest() {
        pageOfBookSearch.openingWebsite().checkingOutBooks();
    }

    @ValueSource(strings = {"Докинз", "Марков"})
    @ParameterizedTest(name = "При поиске {0} в результатах отображается текст {0}")
    void parametrizingTestWithValueSource(String valueSource) {
        pageOfBookSearch.openingWebsite().settingFirstName(valueSource).checkingResultFormValues(valueSource);
    }

    @CsvFileSource(resources = "/csvData/Books.csv")
    @ParameterizedTest(name = "При поиске {0} в результатах отображается текст {1}")
    void parametrizingTestWithCsvFileSource(String searchData, String expectedResult) {
        pageOfBookSearch.openingWebsite().settingYearFromSearch(searchData).checkingResultFormValues(expectedResult);
    }

    static Stream<Arguments> parametrizingTestWithMethodSourceDataProvider() {
        return Stream.of(
                Arguments.of("Сапольски"),
                Arguments.of("Панчин")
        );
    }

    @MethodSource(value = "parametrizingTestWithMethodSourceDataProvider")
    @ParameterizedTest(name = "При поиске в яндексе по запросу {0} в результатах отображается текст {1}")
    void parametrizingTestWithMethodSource(String searchData) {
        pageOfBookSearch.openingWebsite().settingFirstName(searchData).checkingResultFormValues(searchData);
    }

    @EnumSource(YearsWithBooks.class)
    @ParameterizedTest(name = "При поиске {0} в результатах отображается текст {1}")
    void parametrizingTestWithEnumSource(YearsWithBooks yearsWithBooks) {
        pageOfBookSearch.openingWebsite().settingYearFromSearch(yearsWithBooks.getYear()).checkingResultFormValues(yearsWithBooks.getDescription());
    }

    @Disabled
    @CsvSource(value = {"2020, Истоки морали. В поисках человеческого у приматов",
            "2021, Что такое наука и как она работает"})
    @ParameterizedTest(name = "При поиске {0} в результатах отображается текст {1}")
    void parametrizingTestWithCsvSourceWithDisabled(String searchData, String expectedResult) {
        pageOfBookSearch.openingWebsite().settingYearFromSearch(searchData).checkingResultFormValues(expectedResult);
    }
}