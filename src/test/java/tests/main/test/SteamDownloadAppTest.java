package tests.main.test;

import com.framework.base.BaseTest;
import com.framework.utils.FileActions;
import com.framework.utils.JsonParse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.main.pages.SteamMainPage;


public class SteamDownloadAppTest extends BaseTest {

    private static final Logger log = LoggerFactory.getLogger(SteamDownloadAppTest.class.getName());
    private static final String PATH_FOR_FILE = JsonParse.getPropertyFromJson("pathForDownloadedFiles");

    @Test
    public void steamDownloadAppTest() {
        log.info("(Steam Download Application) was start");
        SteamMainPage steamMainPage = new SteamMainPage();
        FileActions.deleteFile(PATH_FOR_FILE);
        steamMainPage.clickOnInstallSteamButton();
        steamMainPage.clickOnDownLoadButton();
        Assert.assertTrue(FileActions.isFileDownloadFull(PATH_FOR_FILE));
    }
}
