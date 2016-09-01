package ua.net.itlabs.core.conditions.collection;

import org.openqa.selenium.WebElement;
import ua.net.itlabs.core.Helpers;

import java.util.List;

public class ExactTexts extends Texts {
    public ExactTexts(String... expectedTexts) {
        super(expectedTexts);
        //this.expectedTexts = expectedTexts;
    }

    @Override
    public boolean checkElement(int index) {
        return actualTexts.get(index).equals(expectedTexts[index]);
    }
}
