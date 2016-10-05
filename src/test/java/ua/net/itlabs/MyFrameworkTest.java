package ua.net.itlabs;

import org.junit.BeforeClass;
import org.junit.Test;
import ua.net.itlabs.core.Configuration;
import ua.net.itlabs.core.wrappers.LazyElement;
import ua.net.itlabs.gmailtest.pages.Gmail;
import ua.net.itlabs.gmailtest.pages.Mails;
import ua.net.itlabs.testconfigs.BaseTest;

import static ua.net.itlabs.core.conditions.CollectionConditions.minimumSize;
import static ua.net.itlabs.gmailtest.pages.Mails.emails;
import static ua.net.itlabs.gmailtest.testdata.LoginData.email;
import static ua.net.itlabs.gmailtest.testdata.LoginData.password;

public class MyFrameworkTest extends BaseTest {

    @BeforeClass
    public static void config() {
        Configuration.timeoutMs = 36000;
    }

    @Test
    public void testIterator() {
        Gmail.vizit();

        Gmail.logIn(email, password);

        Mails.emails.shouldHave(minimumSize(1));
        for (LazyElement element:emails) {
            System.out.println(element.getText());
        }
    }
}
