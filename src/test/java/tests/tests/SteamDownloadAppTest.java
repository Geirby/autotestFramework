package tests.tests;

import com.framework.base.BaseElements;
import com.framework.base.BaseTest;
import com.framework.utils.JsonParse;
import com.framework.utils.WaitForHelper;
import org.apache.commons.io.FilenameUtils;
import org.testng.annotations.Test;
import pages.SteamMainPage;

import java.io.IOException;

public class SteamDownloadAppTest extends BaseTest {

    @Test
    public void steamDownloadAppTest() throws IOException {
        SteamMainPage steamMainPage = new SteamMainPage();
        steamMainPage.deleteFile(JsonParse.getPropertyFromJson("pathForDownloadedFiles"));
        steamMainPage.clickOnInstallSteamButton();
        steamMainPage.downLoadSteamApp();
        WaitForHelper.isFileDownloaded(JsonParse.getPropertyFromJson("pathForDownloadedFiles"), FilenameUtils.getName(JsonParse.getPropertyFromJson("pathForDownloadedFiles")));
        steamMainPage.deleteFile(JsonParse.getPropertyFromJson("pathForDownloadedFiles"));



    }
}
