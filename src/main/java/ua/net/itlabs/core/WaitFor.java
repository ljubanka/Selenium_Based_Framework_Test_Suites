package ua.net.itlabs.core;

import org.openqa.selenium.*;
import ua.net.itlabs.core.conditions.Condition;

public class WaitFor {
    public By locator;

    public WaitFor(By locator) {
        this.locator = locator;
    }

    public static WaitFor waitFor(By locator) {
        return new WaitFor(locator);
    }

    public <V> V until(Condition<V> condition) {
        return until(condition, Configuration.timeout*1000);
    }

    public <V> V until(Condition<V> condition, long timeoutMs) {
        //Throwable lastError = null;
        final long startTime = System.currentTimeMillis();

        do {
            //try {
                V result = condition.apply(locator);
                if (result != null) {
                    return result;
                }
//            } catch (WebDriverException | IndexOutOfBoundsException e) {
//                lastError = e;
//            }

            sleep(Configuration.pollingInterval);
        }
        while (System.currentTimeMillis() - startTime < timeoutMs);

        //return null;
        throw new TimeoutException(String.format("Timed out after %s seconds waiting for %s", timeoutMs/1000, condition.toString()));
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

    private void sleep(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }

}
