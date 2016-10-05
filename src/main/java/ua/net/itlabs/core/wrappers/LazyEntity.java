package ua.net.itlabs.core.wrappers;

import org.openqa.selenium.By;
import ua.net.itlabs.core.conditions.DescribesEntity;

public interface LazyEntity<T> extends DescribesEntity<T> {
    T getWrappedEntity();
}
