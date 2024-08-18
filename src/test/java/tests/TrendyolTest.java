package tests;

import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.NoSuchElementException;
import pages.TrendyolPage;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;
import java.util.Set;

@ExtendWith(TestResultLogger.class)
public class TrendyolTest {

    TrendyolPage trendyolPage=new TrendyolPage();
    String price;

    @Test(priority = 1)
    public void enterHomePage(){
        Driver.getDriver().get(ConfigReader.getProperty("TrendyolUrl"));
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains("trendyol"));
    }

    @Test(priority = 2)
    public void closeTheGenderPopUp() throws InterruptedException {
        trendyolPage.genderPopupCloseButton.click();

        try {
            Assert.assertFalse(trendyolPage.genderPopup.isDisplayed());
        } catch (NoSuchElementException e){
            Assert.assertTrue(true);
        }
    }

    @Test(priority = 3)
    public void closeCookiesPopUp(){
        trendyolPage.cookiesAcceptButton.click();

        try {
            Assert.assertFalse(trendyolPage.cookiesPopup.isDisplayed());
        } catch (NoSuchElementException e){
            Assert.assertTrue(true);
        }
    }

    @Test(priority = 4)
    public void loginWithIncorrectEmailCorrectPassword() throws InterruptedException {
        trendyolPage.loginButton.click();
        trendyolPage.loginPageEmailInput.sendKeys(ConfigReader.getProperty("TrendyolIncorrectEmail"));
        trendyolPage.loginPagePasswordInput.sendKeys(ConfigReader.getProperty("TrendyolCorrectPassword"));
        trendyolPage.loginPageLoginButton.click();
        Thread.sleep(5000);
        Assert.assertTrue(trendyolPage.loginErrorMessage.isDisplayed());

    }

    @Test(priority = 5)
    public void loginWithCorrectEmailInCorrectPassword() throws InterruptedException {
        trendyolPage.loginButton.click();
        trendyolPage.loginPageEmailInput.sendKeys(ConfigReader.getProperty("TrendyolCorrectEmail"));
        trendyolPage.loginPagePasswordInput.sendKeys(ConfigReader.getProperty("TrendyolIncorrectPassword"));
        trendyolPage.loginPageLoginButton.click();
        Thread.sleep(5000);
        Assert.assertTrue(trendyolPage.loginErrorMessage.isDisplayed());

    }

    @Test(priority = 6)
    public void loginWithInCorrectEmailInCorrectPassword() throws InterruptedException {
        trendyolPage.loginButton.click();
        trendyolPage.loginPageEmailInput.sendKeys(ConfigReader.getProperty("TrendyolIncorrectEmail"));
        trendyolPage.loginPagePasswordInput.sendKeys(ConfigReader.getProperty("TrendyolIncorrectPassword"));
        trendyolPage.loginPageLoginButton.click();
        Thread.sleep(5000);
        Assert.assertTrue(trendyolPage.loginErrorMessage.isDisplayed());

    }

    @Test(priority = 7)
    public void searchLaptop() {
        trendyolPage.searchBox.sendKeys(ConfigReader.getProperty("SearchWord")+ Keys.ENTER);
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains(ConfigReader.getProperty("SearchWord")));
    }

    @Test(priority = 8)
    public void selectRandomProduct() {
        String originalWindow = Driver.getDriver().getWindowHandle();

        int randomProduct = (int) (Math.random() * trendyolPage.productList.size());
        trendyolPage.productList.get(randomProduct).click();

        Set<String> windowHandles = Driver.getDriver().getWindowHandles();
        for (String handle : windowHandles) {
            if (!handle.equals(originalWindow)) {
                Driver.getDriver().switchTo().window(handle);
                break;
            }
        }

        Assert.assertNotEquals(Driver.getDriver().getWindowHandle(), originalWindow, "No new tab was opened.");
        Assert.assertTrue(trendyolPage.chooseLocationPopupAggreeButton.isDisplayed());
        Assert.assertTrue(trendyolPage.productTitle.isDisplayed(), "Product details are not displayed in the new tab.");

    }

    @Test(priority = 9)
    public void addRandomlySelectedProductToCart() throws InterruptedException {
        trendyolPage.chooseLocationPopupAggreeButton.click();
        price = trendyolPage.productPrice.getText();
        trendyolPage.addToCart.click();
        Thread.sleep(5000);
        Assert.assertTrue(trendyolPage.cartDropDown.isDisplayed());
    }

    @Test(priority = 10)
    public void goToCart(){
        trendyolPage.goToCart.click();
        trendyolPage.chooseUtilitiesPopupAggreeButton.click();
        Assert.assertTrue(trendyolPage.priceInCart.isDisplayed());
    }
    @Test(priority = 11)
    public void comparePriceWithPriceInCart() {
        String priceInCart=trendyolPage.priceInCart.getText();
        Assert.assertEquals(price,priceInCart);
    }

    @Test(priority = 12)
    public void increaseTheNumberOfProduct() {
        trendyolPage.numberOfProduct.click();
        Assert.assertTrue(trendyolPage.productLimitWarning.isDisplayed());
    }

    @Test(priority = 13)
    public void deleteAllProductFromCart() throws InterruptedException {
        trendyolPage.deleteProduct.click();
        Thread.sleep(1000);
        Assert.assertTrue(trendyolPage.deletedProductInfo.isDisplayed());
    }

    @Test(priority = 14)
    public void checkIfCartEmpty() throws InterruptedException {
        Thread.sleep(3000);
        trendyolPage.goToCart.click();
        Assert.assertTrue(trendyolPage.emptyCart.isDisplayed());
        Driver.getDriver().quit();
    }

}