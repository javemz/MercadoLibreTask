package org.jmunoz.selenium.pages;

import org.jmunoz.selenium.utils.WaitUntil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class MLResultPage {

    private WebDriver driver;

    private By products = By.className("ui-search-layout__item");
    private By productName = By.xpath(".//div[@class='ui-search-item__group ui-search-item__group--title shops__items-group']");
    private By productPrice = By.cssSelector("div.ui-search-price > div > span.price-tag > span.price-tag-amount");
    private By productLink = By.cssSelector(" a");
    private By nextButton = By.cssSelector("li.andes-pagination__button--next");

    private int numPages;
    List<List<String>> productsResult = new ArrayList<>();

    public MLResultPage(WebDriver driver, int numPages) {
        this.driver = driver;
        this.numPages = numPages;
    }

    public List<List<String>> search() {
        int i = 0;
        while (i < numPages) {
            getProductPrices();
            driver.findElement(nextButton).click();
            i++;
        }

        return productsResult;
    }

    public void getProductPrices() {

        WaitUntil.visibilityOfAllElements(driver, products);
        List<WebElement> productsElement = driver.findElements(products);

        for(WebElement element: productsElement) {
            List<String> details = new ArrayList<>();

            details.add(element.findElement(productName).getText());
            details.add(element.findElement(productPrice).getText().replace("\n",""));
            details.add(element.findElement(productLink).getAttribute("href"));

            productsResult.add(details);
        }

    }

}
