package org.jmunoz.selenium.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUntil {

    public static boolean visibilityOfAllElements(WebDriver driver, By element){

        try{
            new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(element));

            return true;
        }
        catch (Exception e){
            return false;
        }
    }

    public static boolean elementIsDisplayed(WebDriver driver, By element){

        try{
            WebDriverWait wait = new WebDriverWait(driver,5);
            wait.until((d) -> driver.findElement(element).isDisplayed());
            return true;
        }
        catch (Exception e){
            return false;
        }
    }
}
