package ua.net.itlabs.core.wrappers;

import org.openqa.selenium.WebElement;

public interface Command<T> {
    T action(WebElement element);
}
