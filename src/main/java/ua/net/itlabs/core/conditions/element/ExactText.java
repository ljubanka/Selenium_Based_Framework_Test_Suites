package ua.net.itlabs.core.conditions.element;

import org.openqa.selenium.WebElement;

public class ExactText extends Text {

    public ExactText(String expectedText) {
        super(expectedText);
    }

    @Override
    public WebElement check(WebElement element) {
        actualText = element.getText();
        return actualText.equals(expectedText)?element:null;
    }

}
