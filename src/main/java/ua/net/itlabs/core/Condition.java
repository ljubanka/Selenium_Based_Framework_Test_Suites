package ua.net.itlabs.core;


import org.openqa.selenium.By;

public abstract class Condition<V> {
    public abstract V apply(By locator);

}
