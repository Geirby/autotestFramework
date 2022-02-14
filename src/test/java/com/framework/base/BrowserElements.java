package com.framework.base;

import com.framework.context.WebDriverContext;
import com.framework.utils.WaitForHelper;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.protocol.BasicHttpContext;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.apache.commons.io.FileUtils.copyInputStreamToFile;

public class BrowserElements {

    protected WebDriver driver = WebDriverContext.getDriver();
    protected WebElement webElement;

    public BrowserElements(WebElement webElement) {
        this.webElement = webElement;
    }

    public void click() {
        webElement.click();
    }

    public void enterText(String text) {
        webElement.clear();
        webElement.sendKeys(text);
    }

    public String getText() {
        return webElement.getText();
    }

    public void moveToElement() {
        new Actions(driver).moveToElement(webElement).build().perform();
    }

    public void pressEnter() {
        webElement.sendKeys(Keys.ENTER);
    }

    public ArrayList<String> getTextFromList(List<WebElement> elementList) {
        ArrayList<String> textFromResult = new ArrayList<String>();
        for (WebElement element : elementList) {
            textFromResult.add(element.getText());
        }
        return textFromResult;
    }

    public void downloadFile(String path) throws IOException {
        String downLoadLink = webElement.getAttribute("href");
        File fileToSave = new File(path);
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(downLoadLink);
        CloseableHttpResponse response = httpClient.execute(httpGet, new BasicHttpContext());
        copyInputStreamToFile(response.getEntity().getContent(), fileToSave);
    }

    public void deleteFile(String path) {
        File file = new File(path);
        file.delete();
    }

    public void waitForElementIsClickable() {
        new WaitForHelper(driver).elementIsClickable(webElement);
    }

    public void waitForElementIsInvisible() {
        new WaitForHelper(driver).elementIsAppeared(webElement);
    }

    public void implicitWait() {
        new WaitForHelper(driver).implicitWait();
    }
}
