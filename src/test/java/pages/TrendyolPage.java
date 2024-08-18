package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class TrendyolPage {
    public TrendyolPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//div[@class='homepage-popup']")
    public WebElement genderPopup;
    @FindBy(xpath = "//div[@class='modal-close' and @title='Kapat']")
    public WebElement genderPopupCloseButton;
    @FindBy(xpath = "//button[@class='ot-sdk-row']")
    public WebElement cookiesPopup;
    @FindBy(xpath = "//button[@id='onetrust-accept-btn-handler' and text()='KABUL ET']")
    public WebElement cookiesAcceptButton;
    @FindBy(xpath = "//div[@class='link account-user']")
    public WebElement loginButton;
    @FindBy(xpath = "//input[@class='q-input' and @id='login-email']")
    public WebElement loginPageEmailInput;
    @FindBy(xpath = "//input[@class='q-input' and @id='login-password-input']")
    public WebElement loginPagePasswordInput;
    @FindBy(xpath = "//button[@class='q-primary q-fluid q-button-medium q-button submit' and @type='submit']")
    public WebElement loginPageLoginButton;
    @FindBy(xpath = "//span[contains(text(),'E-posta adresiniz ve/veya şifreniz hatalı.')]")
    public WebElement loginErrorMessage;
    @FindBy(xpath = "//div[@class='prdct-cntnr-wrppr']//div//a")
    public List<WebElement> productList;
    @FindBy(xpath = "//button[@class='onboarding-button']")
    public WebElement chooseLocationPopupAggreeButton;
    @FindBy(xpath = "//input[@placeholder='Aradığınız ürün, kategori veya markayı yazınız']")
    public WebElement searchBox;
    @FindBy(xpath = "//span[@class='prc-dsc']")
    public WebElement productPrice;
    @FindBy(xpath = "//h1[@class='pr-new-br']")
    public WebElement productTitle;
    @FindBy(xpath = "//button[@class='add-to-basket' and @component-id='1']")
    public WebElement addToCart;
    @FindBy(xpath = "//div[@class='basket-preview-popup-container display-block']")
    public WebElement cartDropDown;
    @FindBy(xpath = "//a[@class='link account-basket']")
    public WebElement goToCart;
    @FindBy(xpath = "//div[@class='tooltip-content']//button")
    public WebElement chooseUtilitiesPopupAggreeButton;
    @FindBy(xpath = "//div[@class='pb-basket-item-price']")
    public WebElement priceInCart;
    @FindBy(xpath = "//input[@class='counter-content']")
    public WebElement  numberOfProduct;
    @FindBy(xpath = "//div[@class='pb-basket-item-bulk-sales-limit-label show']")
    public WebElement productLimitWarning;
    @FindBy(xpath = "//button[@class='checkout-saving-remove-button']")
    public WebElement deleteProduct;
    @FindBy(xpath = "//p[text()=' ürünü sepetinden kaldırıldı.']")
    public WebElement deletedProductInfo;
    @FindBy(xpath = "//span[text()='Sepetinde ürün bulunmamaktadır.']")
    public WebElement emptyCart;
}
