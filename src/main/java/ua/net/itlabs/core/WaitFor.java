package ua.net.itlabs.core;

import org.openqa.selenium.*;
import ua.net.itlabs.core.conditions.Condition;
import ua.net.itlabs.core.wrappers.LazyEntity;

public class WaitFor {
    public LazyEntity entity;

    public WaitFor(LazyEntity entity) {
        this.entity = entity;
    }

    public static WaitFor waitFor(LazyEntity entity) {
        return new WaitFor(entity);
    }

    public <V> V until(Condition<V> condition) {
        return until(condition, Configuration.timeoutMs);
    }

    public <V> V until(Condition<V> condition, long timeoutMs) {
        Throwable lastError = null;
        final long startTime = System.currentTimeMillis();

        do {
            try {
                V result = (V) condition.apply(entity);
                if (result != null) {
                    return result;
                }
            } catch (WebDriverException e) {
                lastError = e;
            }
            sleep(Configuration.pollingInterval);
        }
        while (System.currentTimeMillis() - startTime < timeoutMs);

        throw new TimeoutException(String.format("Failed while waiting %s seconds to assert %s", Long.toString(timeoutMs/1000), condition.toString()), lastError);
    }

    public <V> V until(Condition<V>... conditions) {
        V result = null;
        for (Condition<V> condition: conditions) {
            result = until(condition);
            if (result == null) {
                return null;
            }
        }
        return result;
    }

    private void sleep(long milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }

}
