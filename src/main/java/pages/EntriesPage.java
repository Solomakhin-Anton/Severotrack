package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class EntriesPage {

    private SelenideElement checkbox = $(By.xpath("//*[@id=\"result_list\"]/tbody/tr[1]/td[1]/input"));
    private SelenideElement action = $("[name='action']");
    private SelenideElement delete = $("[value='delete_selected']");
    private SelenideElement deleteButton = $("[class='button']");

    public ConfirmPage deleteTitle() {
        checkbox.click();
        action.click();
        delete.click();
        deleteButton.click();
        return new ConfirmPage();
    }

}
