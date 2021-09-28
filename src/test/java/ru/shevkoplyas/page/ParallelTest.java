package ru.shevkoplyas.page;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.MethodSource;
import ru.shevkoplyas.page.domain.NavigationItem;
import ru.shevkoplyas.page.page.GithubPage;

import java.util.stream.Stream;

import static com.codeborne.selenide.Selenide.open;


public class ParallelTest {

    private GithubPage githubPage = new GithubPage();

    @CsvSource({
            "Overview",
            "Repositories",
            "Projects",
            "Packages"
    })

    @DisplayName("Check navigation bar ob Github Profile with CsvSource")
    @ParameterizedTest(name = "Check dispalyed tabs in github Profile with CsvSource: {0} tab")
    void testForGithubProfile(String navigationItems, TestInfo testInfo) {
        open(GithubPage.URL);
        githubPage.checkNavigationBar(navigationItems);
        System.out.println("Executed test: "
                + testInfo.getDisplayName());
    }

    @EnumSource(NavigationItem.class)
    @DisplayName("Check navigation bar ob Github Profile with EnumSource")
    @ParameterizedTest(name = "Check dispalyed tabs in github Profile with EnumSource: {0} tab")
    void test2ForGithubProfile(NavigationItem navigationItem, TestInfo testInfo) {
        open(GithubPage.URL);
        githubPage.switchToNavigationItem(navigationItem);
        System.out.println("Executed test: "
                + testInfo.getDisplayName());

    }

    @EnumSource(value = NavigationItem.class, names = {"OVERVIEW", "REPOSITORIES"})
    @DisplayName("Check navigation bar ob Github Profile with EnumSource and required values")
    @ParameterizedTest(name = "Check dispalyed tabs in github Profile with EnumSource and required values: {0} tab")
    void testForGithubProfileWithSelectedValues(NavigationItem navigationItem, TestInfo testInfo) {
        open(GithubPage.URL);
        githubPage.switchToNavigationItem(navigationItem);
        System.out.println("Executed test: "
                + testInfo.getDisplayName());

    }

    @EnumSource(value = NavigationItem.class, names = {"PACKAGES"}, mode = EnumSource.Mode.EXCLUDE)
    @DisplayName("Check navigation bar ob Github Profile with EnumSource and excluded values")
    @ParameterizedTest
            (name = "Check dispalyed tabs in github Profile with EnumSource and excluded values: {0} tab name")
    void testForGithubProfileWithExcludedValues(NavigationItem navigationItem, TestInfo testInfo) {
        open(GithubPage.URL);
        githubPage.switchToNavigationItem(navigationItem);
        System.out.println("Executed test: "
                + testInfo.getDisplayName());

    }

    static Stream<Arguments> checkNavigationBarItems() {
        return Stream.of(
                Arguments.of("Overview"),
                Arguments.of("Repositories"),
                Arguments.of("Projects"),
                Arguments.of("Packages")

        );
    }

    @MethodSource("checkNavigationBarItems")
    @DisplayName("Check navigation bar ob Github Profile with MethodSource")
    @ParameterizedTest(name = "Check dispalyed tabs in github Profile with MethodSource: {0} tab")
    void checkNavigationBarItems(String barItem, TestInfo testInfo) {
        open(GithubPage.URL);
        githubPage.checkNavigationBar(barItem);
        System.out.println("Executed test: "
                + testInfo.getDisplayName());

    }

}
