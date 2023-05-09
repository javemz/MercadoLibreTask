package org.jmunoz.selenium;

import org.jmunoz.selenium.pages.MLHomePage;
import org.jmunoz.selenium.pages.MLResultPage;
import org.jmunoz.selenium.utils.FileManagement;

//import org.testng.Assert;
import org.openqa.selenium.WebDriver;
import java.util.List;

public class MercadoLibre extends PageSearchTemplate{

    private String product;

    private MLHomePage mlHomePage;

    private MLResultPage mlResultPage;

    private List<List<String>> productsFound;

    public MercadoLibre(WebDriver driver, String product, int numPagesToSearch) {
        this.product = product;
        this.mlHomePage = new MLHomePage(driver);
        this.mlResultPage = new MLResultPage(driver, numPagesToSearch);
    }

    @Override
    public boolean launchSite() {
        return this.mlHomePage.goTo();
    }

    @Override
    public void searchProduct() {
        this.mlHomePage.search(this.product);
    }

    @Override
    public boolean getProductPrice() {
        productsFound = mlResultPage.search();
        return productsFound.size() > 0;
    }

    @Override
    public void createAndWriteFileText() {
        FileManagement.WriteAList("MercadoLibre", productsFound);
    }


}
