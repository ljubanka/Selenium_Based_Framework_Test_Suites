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
        //Throwable lastError = null;
        this.locator = locator;
        try {
            V result = check(getWrappedEntity());
            if (result != null) {
                return result;
            }
        }
        catch (WebDriverException | IndexOutOfBoundsException e) {
            //lastError = e;
        }
        return null;
        //throw new TimeoutException(String.format("Timed out after ___ seconds waiting for %s", getClass().getSimpleName()), lastError);
    }

    public String toString() {
        return String.format(getClass().getSimpleName() +
                "\nfor " + identity() + " found by " + locator +
                (expected() == "" ? "" : "\nexpected: " + expected()) +
                (actual() == "" ? "" : "\nactual: " + actual()));
    }

}
