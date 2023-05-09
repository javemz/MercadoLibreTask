package org.jmunoz.selenium;

public abstract class PageSearchTemplate {

    public abstract boolean launchSite();
    public abstract void searchProduct();
    public abstract boolean getProductPrice();
    public abstract void createAndWriteFileText();

}
