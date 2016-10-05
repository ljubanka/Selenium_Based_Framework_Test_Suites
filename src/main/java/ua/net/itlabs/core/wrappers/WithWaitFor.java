package ua.net.itlabs.core.wrappers;

import org.openqa.selenium.WebDriverException;
import ua.net.itlabs.core.conditions.element.ElementCondition;

import static ua.net.itlabs.core.WaitFor.waitFor;

public class WithWaitFor {
    LazyElement element;
    ElementCondition condition;

    public static WithWaitFor withWaitFor(LazyElement element, ElementCondition condition) {
        return new WithWaitFor(element, condition);
    }

    public WithWaitFor(LazyElement element, ElementCondition condition) {
        this.element = element;
        this.condition = condition;
    }

    public <T> T run(Command<T> command) {
        try {
            return command.action(element.getWrappedEntity());
        }
        catch (WebDriverException e) {
            return command.action(waitFor(element).until(condition));
        }
    }

}
