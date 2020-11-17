import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class DashboardPage {

    private SelenideElement addButton = $("#module_2 > div > ul:nth-child(2) > li:nth-child(1) > ul > li:nth-child(1) > a");

    public AddEntryPage addEntry() {
        addButton.click();
        return new AddEntryPage();
    }

}
