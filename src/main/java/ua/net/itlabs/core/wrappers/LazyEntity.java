package ua.net.itlabs.core.wrappers;

import org.openqa.selenium.By;

public interface LazyEntity<T> {
    T getWrappedEntity();
}
