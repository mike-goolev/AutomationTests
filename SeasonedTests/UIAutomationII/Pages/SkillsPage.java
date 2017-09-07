import org.openqa.selenium.WebDriver;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.openqa.selenium.support.ui.ExpectedConditions.invisibilityOfElementLocated;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class SkillsPage extends BasePage {

    Locators.SkillsPageLocators skillsPageLocators;
    Locators.ProfilePageLocators profilePageLocators;

    public SkillsPage(WebDriver driver) {
        super(driver);
        skillsPageLocators = new Locators.SkillsPageLocators();
        profilePageLocators = new Locators.ProfilePageLocators();
    }

    /**
     * Selects a skill at the specified index
     * @param index The index of the skill to select
     */
    public void toggleSkill(String index) {
        wait.until(elementToBeClickable(skillsPageLocators.skillLbl(index)));
        driver.findElement(skillsPageLocators.skillLbl(index)).click();
    }

    /**
     * Checks to see if the skill at the specified index is selected
     * @param index The index of the skill to select
     * @return Whether or not the skill at the specified is selected
     */
    public boolean isSkillSelected(String index) {
        return elementExists(skillsPageLocators.skillSelectedLbl(index));
    }

    /**
     * Checks to see if the skill at the specified index is selected
     * @param index The index of the skill to select
     * @return Whether or not the skill at the specified is selected
     */
    public String getSkillTxt(String index) {
        return driver.findElement(skillsPageLocators.skillLbl(index)).getText();
    }

    /**
     * Clicks the save button on the skills page
     */
    public void clickSaveBtn() {
        wait.until(elementToBeClickable(skillsPageLocators.skillsSaveBtn));
        driver.findElement(skillsPageLocators.skillsSaveBtn).click();
    }

    /**
     * Checks to see if the skills success toast is visible
     * @return Whether or not the skills success toast is visible
     */
    public boolean verifySkillsSuccessToast(){
        wait.until(visibilityOfElementLocated(skillsPageLocators.skillsSuccessToast));
        return elementExists(skillsPageLocators.skillsSuccessToast);
    }

    /**
     * Clicks the 'X' to dismiss the skills success toast
     */
    public void dismissSkillsSuccessToast(){
        wait.until(elementToBeClickable(skillsPageLocators.skillSuccessToastCloseBtn));
        driver.findElement(skillsPageLocators.skillSuccessToastCloseBtn).click();
        wait.until(invisibilityOfElementLocated(skillsPageLocators.skillsSuccessToast));
    }

    /**
     * Checks to see if the skills save button is enabled
     * @return Whether or not the personal info save button is enabled
     */
    public boolean isSaveButtonEnabled(){
        return (driver.findElement(skillsPageLocators.skillsSaveBtn).isEnabled());
    }

    /**
     * Checks to see if the skills tooltip is displayed
     * @return Whether or not the skills tooltip is displayed
     */
    public boolean isSkillsTooltipDisplayed() {
        return elementExists(skillsPageLocators.skillsTooltip);
    }

    /**
     * Get skills title from the skills tooltip
     *
     * @return The skills tooltip title
     */
    public String getSkillsTitleTooltip() {
        return driver.findElement(skillsPageLocators.skillsTitleTooltip).getText();
    }

    /**
     * Get skills text from the skills tooltip
     *
     * @return The skills tooltip text
     */
    public String getSkillsTxtTooltip() {
        return driver.findElement(skillsPageLocators.skillsTxtTooltip).getText();
    }
}