package ua.net.itlabs.core.conditions;

import org.openqa.selenium.By;

public interface Condition<T> {
    T apply(By locator);
}
