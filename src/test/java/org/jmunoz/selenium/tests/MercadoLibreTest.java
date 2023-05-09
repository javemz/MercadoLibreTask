package org.jmunoz.selenium.tests;

import org.jmunoz.selenium.BaseTest;
import org.jmunoz.selenium.MercadoLibre;
import org.jmunoz.selenium.PageSearchTemplate;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;

public class MercadoLibreTest extends BaseTest {

    @Test(dataProvider = "getData")
    public void getPrices(PageSearchTemplate pageSearchTemplate) {

        Assert.assertTrue(pageSearchTemplate.launchSite(), "The input search from Home Page did not load correctly");

        pageSearchTemplate.searchProduct();

        Assert.assertTrue(pageSearchTemplate.getProductPrice(),"The page not show products");

        pageSearchTemplate.createAndWriteFileText();
    }

    @DataProvider
    public Object[] getData(){
        return new Object[]{
                new MercadoLibre(driver, "camisetas", 3)
        };
    }



}
