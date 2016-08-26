package ua.net.itlabs.core;


import com.gargoylesoftware.htmlunit.ElementNotFoundException;
import org.openqa.selenium.*;


public class WaitFor {
    public By locator;

    public WaitFor(By locator) {
        this.locator = locator;
    }

    public static WaitFor waitFor(By locator) {
        return new WaitFor(locator);
    }

    public <V> V until(Condition<V> condition) throws WebDriverException {
        return until(condition, Configuration.timeout*1000);
    }

    public <V> V until(Condition<V> condition, long timeoutMs) throws WebDriverException{
        final long startTime = System.currentTimeMillis();

        do {
            try {
                V result = condition.apply(locator);
                if (result != null) {
                    return result;
                }
            } catch (StaleElementReferenceException | ElementNotVisibleException | IndexOutOfBoundsException e) {
            }

            sleep(Configuration.pollingInterval);
        }
        while (System.currentTimeMillis() - startTime < timeoutMs);

        throw new ElementNotFoundException(String.format("Condition %s not achieved while waiting with timeout of %s, Ms", condition.toString(), timeoutMs), "", "");
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
