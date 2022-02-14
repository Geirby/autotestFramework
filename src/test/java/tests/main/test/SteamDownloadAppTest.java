package tests.main.test;

import com.framework.base.BaseTest;
import com.framework.utils.JsonParse;
import com.framework.utils.WaitForHelper;
import org.apache.commons.io.FilenameUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;
import tests.main.pages.SteamMainPage;

import java.io.IOException;

public class SteamDownloadAppTest extends BaseTest {

    private static final Logger log = LoggerFactory.getLogger(SteamDownloadAppTest.class.getName());

    @Test
    public void steamDownloadAppTest() throws IOException {
        log.info("(Steam Download Application) was start");
        SteamMainPage steamMainPage = new SteamMainPage();
        steamMainPage.deleteFile(JsonParse.getPropertyFromJson("pathForDownloadedFiles"));
        steamMainPage.clickOnInstallSteamButton();
        steamMainPage.downLoadSteamApp();
        WaitForHelper.isFileDownloaded(JsonParse.getPropertyFromJson("pathForDownloadedFiles"), FilenameUtils.getName(JsonParse.getPropertyFromJson("pathForDownloadedFiles")));
        steamMainPage.deleteFile(JsonParse.getPropertyFromJson("pathForDownloadedFiles"));



    }
}
