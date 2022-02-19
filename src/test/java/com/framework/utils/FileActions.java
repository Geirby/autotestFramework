package com.framework.utils;

import org.apache.commons.io.FilenameUtils;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.protocol.BasicHttpContext;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;

import static org.apache.commons.io.FileUtils.copyInputStreamToFile;

public class FileActions {

    public static final int MAX_DOWNLOAD_TIME = 10000;
    protected static WebElement webElement;
    private static final Logger log = LoggerFactory.getLogger(FileActions.class.getName());
    public static final String PATH_FOR_FILE = JsonParse.getPropertyFromJson("pathForDownloadedFiles");


    public FileActions(WebElement webElement) {
        FileActions.webElement = webElement;
    }

    public static void downloadFileByLink(WebElement webElement) {
        String downLoadLink = webElement.getAttribute("href");
        File fileToSave = new File(JsonParse.getPropertyFromJson("pathForDownloadedFiles"));
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(downLoadLink);
        try {
            CloseableHttpResponse response = httpClient.execute(httpGet, new BasicHttpContext());
            copyInputStreamToFile(response.getEntity().getContent(), fileToSave);
        } catch (IOException e) {
            log.info("Link for download file is not available");
        }
    }

    public static void waitForDownloadUniversal(String path) {
        int timer = 0;
        File file = new File(path);
        while (!file.exists()) {
            try {
                timer += 10;
                Thread.sleep(10);
                if (timer > MAX_DOWNLOAD_TIME) {
                    log.error("Time out for download");
                    break;
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public static boolean isFileDownloadFull(String path) {
        File file = new File(path);
        return file.exists();
    }

    public static void deleteFile(String path) {
        File file = new File(path);
        file.delete();
    }
}
