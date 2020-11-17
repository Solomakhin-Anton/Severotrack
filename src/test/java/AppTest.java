import lombok.val;
import org.testng.annotations.*;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class AppTest {

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


    }

}
