package ua.net.itlabs.core;

import org.openqa.selenium.WebElement;

public interface Command<T> {
    T action(WebElement element);

}
