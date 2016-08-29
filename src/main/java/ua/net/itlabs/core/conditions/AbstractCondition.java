package ua.net.itlabs.core.conditions;

import org.openqa.selenium.By;

import java.util.List;

import static ua.net.itlabs.core.Helpers.getTexts;

public abstract class AbstractCondition<V> implements Condition<V>{

    protected By locator;
    public abstract V getWrappedEntity();
    public abstract V check(V entity);
    public abstract List<String> elementsString();
    public abstract String elementOrElements();
    public abstract String resultDescription();
    public abstract String expectedResultString();
    public abstract String actualResultString();

    public V apply(By locator) {
        this.locator = locator;
        try {
            V entity = getWrappedEntity();
            return check(entity);
        }
        catch (Exception e) {
            throw e;
        }

    }

    public String toString() {

        return String.format(this.getClass().getName().substring(this.getClass().getName().lastIndexOf(".")+1) +
                        "\nfor %s %s, found by: %s locator \nexpected %s to be %s,\n" +
                "actual %s is %s", elementOrElements(), elementsString(), locator.toString().split(" ")[1], resultDescription(),
                    expectedResultString(), resultDescription(), actualResultString());
    }

}
