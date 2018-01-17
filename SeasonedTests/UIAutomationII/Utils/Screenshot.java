import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Screenshot {

    public void takeScreenShot(String fileName, WebDriver driver) {
        DateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        Date currentDate = new Date();
        String today = dateFormat.format(currentDate);
        try {
            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

            FileUtils.copyFile(src, new File("out/screenshots/" + today + fileName + ".jpg"));

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
