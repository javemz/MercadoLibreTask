package org.jmunoz.selenium.pages;

import org.jmunoz.selenium.utils.WaitUntil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MLHomePage {

    private WebDriver driver;
    private By inputSearch = By.id("cb1-edit");
    private By buttonSearch = By.cssSelector("button.nav-search-btn");
    private By cookiesMessage = By.cssSelector("button.cookie-consent-banner-opt-out__action--key-accept");

    public MLHomePage(WebDriver driver) {

        this.driver = driver;
    }

    public boolean goTo() {

        this.driver.get("https://www.mercadolibre.com.uy/");
        this.driver.findElements(cookiesMessage)
                .stream()
                .findFirst()
                .ifPresent(WebElement::click);
        return driver.findElement(inputSearch).isDisplayed();
    }


    public void search(String product) {
        WaitUntil.elementIsDisplayed(driver, inputSearch);
        driver.findElement(inputSearch).sendKeys(product);
        driver.findElement(buttonSearch).click();
    }


}
