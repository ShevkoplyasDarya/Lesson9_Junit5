package ru.shevkoplyas.page.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import ru.shevkoplyas.page.TestBase;
import ru.shevkoplyas.page.domain.NavigationItem;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class GithubPage extends TestBase {

    public static final String URL = "https://github.com/ShevkoplyasDarya";
    private final SelenideElement navigationBar = $("nav.UnderlineNav-body");
    private final SelenideElement pageContent = $(".application-main ");

    public void checkNavigationBar(String expected) {
        navigationBar.shouldHave(Condition.text(expected));
    }

    public GithubPage switchToNavigationItem(NavigationItem navigationItem) {
        $$("nav.UnderlineNav-body").find(Condition.text(navigationItem.
                getDesc())).click();
        return this;
    }

    public GithubPage checkOpenedTab(NavigationItem navigationItem) {
        pageContent.shouldHave(Condition.text(navigationItem.getDesc()));
        return this;
    }

}
