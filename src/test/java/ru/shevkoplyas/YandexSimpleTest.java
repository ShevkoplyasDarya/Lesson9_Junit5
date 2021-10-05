package ru.shevkoplyas;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import ru.shevkoplyas.page.YandexMainPage;

public class YandexSimpleTest extends TestBase {
    private YandexMainPage ymp = new YandexMainPage();
    @ValueSource(strings = {
            "qa.guru"
    })
    @ParameterizedTest(name = "Check search results for input string: {0}")
    void yandexSearchTest(String searchQuery, TestInfo testInfo) {
        Selenide.open(YandexMainPage.URL);
        ymp.doSearch(searchQuery)
                .checkResults(searchQuery);

        System.out.println("Config for test: "
                + testInfo.getDisplayName()
                + " "
                + Configuration.startMaximized
        );
    }
}
