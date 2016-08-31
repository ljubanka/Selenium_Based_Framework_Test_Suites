package ua.net.itlabs.core.conditions.collection;

import org.openqa.selenium.WebElement;
import ua.net.itlabs.core.Helpers;

import java.util.List;

public class ExactTexts extends Texts {
    public ExactTexts(String... expectedTexts) {
        this.expectedTexts = expectedTexts;
    }

    @Override
    public List<WebElement> checkElements(List<WebElement> elements) {
        actualTexts = Helpers.getTexts(elements);
        if (actualTexts.size() != expectedTexts.length) {
            return null;
        }
        for (int i = 0; i < actualTexts.size(); i++) {
            if (!actualTexts.get(i).equals(expectedTexts[i])) {
                return null;
            }
        }
        return elements;
    }
}
