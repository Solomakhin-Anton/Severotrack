package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class ConfirmPage {

    private SelenideElement confirmButton = $("[value='Да, я уверен']");

    public void successDelete() {
        confirmButton.click();
    }
}
