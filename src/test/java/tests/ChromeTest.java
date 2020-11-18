package tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import data.Data;
import io.qameta.allure.selenide.AllureSelenide;
import lombok.val;
import org.testng.annotations.*;
import pages.EntriesPage;
import pages.LoginPage;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;

public class ChromeTest {

    @BeforeClass
    static void setUpAll() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @AfterClass
    static void tearDownAll() {
        SelenideLogger.removeListener("allure");
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
