package pages;

import com.codeborne.selenide.SelenideElement;
import data.Data;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage {

    private SelenideElement loginField = $("[name='username']");
    private SelenideElement passwordField = $("[name='password']");
    private SelenideElement loginButton = $("[type='submit']");

    public DashboardPage validLogin(Data.AuthInfo info) {
        loginField.setValue(info.getLogin());
        passwordField.setValue(info.getPassword());
        loginButton.click();
        return new DashboardPage();
    }
}
