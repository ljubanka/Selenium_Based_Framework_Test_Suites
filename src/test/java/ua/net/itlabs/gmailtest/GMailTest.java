package ua.net.itlabs.gmailtest;

import org.junit.BeforeClass;
import org.junit.Test;
import ua.net.itlabs.core.Configuration;
import ua.net.itlabs.core.conditions.CollectionCondition;
import ua.net.itlabs.core.conditions.CollectionConditions;
import ua.net.itlabs.core.wrappers.LazyElement;
import ua.net.itlabs.gmailtest.pages.Gmail;
import ua.net.itlabs.gmailtest.pages.Mails;
import ua.net.itlabs.gmailtest.pages.Menu;
import ua.net.itlabs.testconfigs.BaseTest;

import static java.lang.Thread.sleep;
import static ua.net.itlabs.core.ConciseAPI.$$;
import static ua.net.itlabs.core.Helpers.getUniqueText;
import static ua.net.itlabs.core.WaitFor.waitFor;
import static ua.net.itlabs.gmailtest.pages.Mails.emails;
import static ua.net.itlabs.gmailtest.testdata.LoginData.email;
import static ua.net.itlabs.gmailtest.testdata.LoginData.password;

public class GMailTest extends BaseTest {

    @BeforeClass
    public static void config() {
        Configuration.timeoutMs = 16000;
    }

    @Test
    public void testSendAndSearchEmail()  {
        Gmail.vizit();

        Gmail.logIn(email, password);
        String subject  = getUniqueText("Autotest email ");

        Mails.send(email, subject);

        Menu.refresh();

        Menu.goToSent();
        Mails.assertMail(0, subject);

        Menu.goToInbox();
        Mails.searchBySubject(subject);
        Mails.assertMails(subject);
    }

    @Test
    public void testIterator() {
        Gmail.vizit();

        Gmail.logIn(email, password);

        for (LazyElement element:emails) {
            System.out.println(element.getText());
        }
    }

}
