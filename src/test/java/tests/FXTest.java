package tests;

import data.Data;
import lombok.val;
import org.testng.annotations.*;
import pages.EntriesPage;
import pages.LoginPage;

import static com.codeborne.selenide.Condition.matchText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;

public class FXTest {

    @BeforeClass
    void setUp() {
        System.setProperty("selenide.browser", "firefox");
    }

    @Test
    void shouldAddEntry() {
        open("http://igorakintev.ru/admin/");
        val authInfo = Data.getAuthInfo();
        val addInfo = Data.getAddInfo();
        val loginPage = new LoginPage();
        val dashboardPage = loginPage.validLogin(authInfo);
        $("#content").$(withText("Панель управления")).shouldBe(visible);
        val addEntryPage = dashboardPage.addEntry();
        $("#content").$(withText("Добавить entry")).shouldBe(visible);
        addEntryPage.addAll(addInfo);
        $("#content").$(withText("Выберите entry для изменения")).shouldBe(visible);
        open("http://igorakintev.ru/blog/");
        $$("#entries > h2").first().shouldHave(matchText(Data.getAddInfo().getTitle()));
        back();
        $("#content").$(withText("Выберите entry для изменения")).shouldBe(visible);
        val entriesPage = new EntriesPage();
        val confirmPage = entriesPage.deleteTitle();
        confirmPage.successDelete();
        $("body").shouldNotHave(matchText(Data.getAddInfo().getTitle()));


    }

}
