package ua.net.itlabs.core.conditions;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriverException;

public abstract class AbstractCondition<V> implements Condition<V>{

    protected By locator;
    public abstract V getWrappedEntity();
    public abstract V check(V entity);
    public abstract String identity();
    public abstract String expected();
    public abstract String actual();

    public V apply(By locator) {
        this.locator = locator;
        V result = check(getWrappedEntity());
        if (result != null) {
            return result;
        }
        return null;
    }

    public String toString() {
        return String.format(getClass().getSimpleName() +
                "\nfor " + identity() + " found by " + locator +
                (expected() == "" ? "" : "\nexpected: " + expected()) +
                (actual() == "" ? "" : "\nactual: " + actual()));
    }

}
