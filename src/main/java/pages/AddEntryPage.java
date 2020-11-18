package pages;

import com.codeborne.selenide.SelenideElement;
import data.Data;

import static com.codeborne.selenide.Selenide.$;

public class AddEntryPage {

    private SelenideElement addTitle = $("#id_title");
    private SelenideElement addSlug = $("#id_slug");
    private SelenideElement addTextMd = $("#id_text_markdown");
    private SelenideElement addText = $("#id_text");
    private SelenideElement saveButton = $("[name = '_save']");

    public void addAll (Data.AddInfo info) {
        addTitle.setValue(info.getTitle());
        addSlug.setValue(info.getSlug());
        addTextMd.setValue(info.getTextMd());
        addText.setValue(info.getText());
        saveButton.click();
    }

}
