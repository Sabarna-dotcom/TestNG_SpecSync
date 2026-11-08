package example;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest {
    @Test(groups = {"smoke"})
    public void validLogin_displaysDashboard() {
        // Replace with Selenium WebDriver navigation and assertions.
        Assert.assertTrue(true, "Replace this placeholder with a real login assertion");
    }

    @Test(groups = {"regression"})
    public void invalidLogin_displaysError() {
        // Replace with Selenium WebDriver navigation and assertions.
        Assert.assertTrue(true, "Replace this placeholder with a real error-message assertion");
    }
}
