package pages;

import base.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class Header extends PageBase {
    public Header(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[@role='button' and contains (@title, 'Account')]")
    private WebElement userAccontICO;
    @FindBy(xpath = "//a[text()='Sign out']")
    private WebElement signOutButton;


    public LoginPage signOut() {
        userAccontICO.click();
        signOutButton.click();
        return new LoginPage(driver);
    }

    public Header checkLogInSuccess() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assert.assertTrue(userAccontICO.isDisplayed());
        return this;
    }

}
