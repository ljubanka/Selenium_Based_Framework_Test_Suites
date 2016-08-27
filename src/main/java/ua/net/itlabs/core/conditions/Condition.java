package ua.net.itlabs.core.conditions;


import org.openqa.selenium.By;

public abstract class Condition<V> {
    public abstract V apply(By locator);

}
