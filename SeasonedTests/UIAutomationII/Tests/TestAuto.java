/**
 * Created by alex.esparza on 2/14/17.
 */

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.annotations.*;

import java.util.*;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

public class TestAuto {
    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver, 30);

        driver.get("http://hsp-load-balancer-851875221.us-west-2.elb.amazonaws.com/services/search");
        wait.until(elementToBeClickable(By.cssSelector("ul.bf-head-links>li:nth-of-type(1)>a.bf-head-link-a")));
        driver.findElement(By.cssSelector("ul.bf-head-links>li:nth-of-type(1)>a.bf-head-link-a")).click();

        //Enter in a login
        wait.until(elementToBeClickable(By.cssSelector("div.form-group:nth-of-type(1) * input")));
        driver.findElement(By.cssSelector("div.form-group:nth-of-type(1) * input")).sendKeys("aprofile@mailinator.com");
        driver.findElement(By.cssSelector("div.form-group:nth-of-type(2)>div>div>input")).sendKeys("12348765");
        driver.findElement(By.cssSelector("div.bf-form-actions>div.bf-button-wrapper>button.bf-button")).click();

        //navigate to profile
        wait.until(elementToBeClickable(By.cssSelector("a.username")));
        driver.findElement(By.cssSelector("a.username")).click();
        wait.until(elementToBeClickable(By.cssSelector("ul.bf-menu-items>li:nth-of-type(1)>a")));
        driver.findElement(By.cssSelector("ul.bf-menu-items>li:nth-of-type(1)>a")).click();

        //Navigate to availability
        wait.until(elementToBeClickable(By.cssSelector("div.bf-card>a[href='#/profile/edit/availability?goBackTo=profile']")));
        driver.findElement(By.cssSelector("div.bf-card>a[href='#/profile/edit/availability?goBackTo=profile']")).click();
        driver.findElement(By.cssSelector("div.profile-wizard-availability>div.availability-line:nth-of-type(1) * div.bf-checkbox")).click();
        driver.findElement(By.cssSelector("div.profile-wizard-availability>div.availability-line:nth-of-type(2) * div.bf-checkbox")).click();
        driver.findElement(By.cssSelector("div.profile-wizard-availability>div.availability-line:nth-of-type(3) * div.bf-checkbox")).click();
        driver.findElement(By.cssSelector("div.profile-wizard-availability>div.availability-line:nth-of-type(4) * div.bf-checkbox")).click();
        driver.findElement(By.cssSelector("div.bf-flex-layout * button.bf-button")).click();
        driver.findElement(By.cssSelector(""));
    }

}
