package ua.net.itlabs.core.elements;

import org.openqa.selenium.By;

public interface LazyEntity<V> {
    V getWrappedEntity();
}
