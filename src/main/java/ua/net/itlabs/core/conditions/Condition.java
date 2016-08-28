package ua.net.itlabs.core.conditions;

import org.openqa.selenium.By;

public interface Condition<V> {
    V apply(By locator);
}
