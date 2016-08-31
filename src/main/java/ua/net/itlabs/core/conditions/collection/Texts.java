package ua.net.itlabs.core.conditions.collection;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebElement;
import ua.net.itlabs.core.Helpers;

import java.util.List;

public class Texts extends CollectionCondition {
    protected List<String> actualTexts;
    protected String[] expectedTexts;

    public Texts(String... expectedTexts) {
        this.expectedTexts = expectedTexts;
    }

    @Override
    public List<WebElement> check(List<WebElement> elements) {
        return checkElements(elements);
    }

    public List<WebElement> checkElements(List<WebElement> elements) {
        actualTexts = Helpers.getTexts(elements);
        if (actualTexts.size() != expectedTexts.length) {
            return null;
        }
        for (int i = 0; i < actualTexts.size(); i++) {
            if (!actualTexts.get(i).contains(expectedTexts[i])) {
                return null;
            }
        }
        return elements;
    }

    @Override
    public String expected() {
        return StringUtils.join(expectedTexts, ", ");
    }

    @Override
    public String actual() {
        return actualTexts.toString();
    }

}
