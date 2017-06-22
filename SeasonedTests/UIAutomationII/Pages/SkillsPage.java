import org.openqa.selenium.WebDriver;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

public class SkillsPage extends BasePage {

    Locators.SkillsPageLocators skillsPageLocators;
    Locators.ProfilePageLocators profilePageLocators;

    public SkillsPage(WebDriver driver) {
        super(driver);
        skillsPageLocators = new Locators.SkillsPageLocators();
        profilePageLocators = new Locators.ProfilePageLocators();
    }

    /**
     * Selects the Baker skill checkbox
     */
    public void selectBakerSkillCheckbox() {
        wait.until(elementToBeClickable(skillsPageLocators.bakerCheckbox));
        driver.findElement(skillsPageLocators.bakerCheckbox).click();
    }

    /**
     * Deselects the Baker skill checkbox
     */
    public void deselectBakerSkillCheckbox() {
        if (isBakerSkillCheckboxSelectedYes()) {
            wait.until(elementToBeClickable(skillsPageLocators.bakerCheckboxSelected));
            driver.findElement(skillsPageLocators.bakerCheckboxSelected).click();
        }
    }

    /**
     * Checks to see if the Baker skill is selected
     * @return Whether or not the Baker skill is selected
     */
    public boolean isBakerSkillCheckboxSelectedYes() {
        return elementExists(skillsPageLocators.bakerCheckboxSelected);
    }

    /**
     * Checks to see if the Baker skill is deselected
     * @return Whether or not the Baker skill is deselected
     */
    public boolean isBakerSkillCheckboxSelectedNo() {
        return elementExists(skillsPageLocators.bakerCheckbox);
    }

    /**
     * Selects the Bar-back skill checkbox
     */
    public void selectBarbackSkillCheckbox() {
        wait.until(elementToBeClickable(skillsPageLocators.barbackCheckbox));
        driver.findElement(skillsPageLocators.barbackCheckbox).click();
    }

    /**
     * Deselects the Bar-back skill checkbox
     */
    public void deselectBarbackSkillCheckbox() {
        if (isBarbackSkillCheckboxSelectedYes()) {
            wait.until(elementToBeClickable(skillsPageLocators.barbackCheckboxSelected));
            driver.findElement(skillsPageLocators.barbackCheckboxSelected).click();
        }
    }

    /**
     * Checks to see if the Bar-back skill is selected
     * @return Whether or not the Bar-back skill is selected
     */
    public boolean isBarbackSkillCheckboxSelectedYes() {
        return elementExists(skillsPageLocators.barbackCheckboxSelected);
    }

    /**
     * Checks to see if the Bar-back skill is deselected
     * @return Whether or not the Bar-back skill is deselected
     */
    public boolean isBarbackSkillCheckboxSelectedNo() {
        return elementExists(skillsPageLocators.barbackCheckbox);
    }

    /**
     * Selects the Barista skill checkbox
     */
    public void selectBaristaSkillCheckbox() {
        wait.until(elementToBeClickable(skillsPageLocators.baristaCheckbox));
        driver.findElement(skillsPageLocators.baristaCheckbox).click();
    }

    /**
     * Deselects the Barista skill checkbox
     */
    public void deselectBaristaSkillCheckbox() {
        if (isBaristaSkillCheckboxSelectedYes()) {
            wait.until(elementToBeClickable(skillsPageLocators.baristaCheckboxSelected));
            driver.findElement(skillsPageLocators.baristaCheckboxSelected).click();
        }
    }

    /**
     * Checks to see if the Barista skill is selected
     * @return Whether or not the Barista skill is selected
     */
    public boolean isBaristaSkillCheckboxSelectedYes() {
        return elementExists(skillsPageLocators.baristaCheckboxSelected);
    }

    /**
     * Checks to see if the Barista skill is deselected
     * @return Whether or not the Barista skill is deselected
     */
    public boolean isBaristaSkillCheckboxSelectedNo() {
        return elementExists(skillsPageLocators.baristaCheckbox);
    }

    /**
     * Selects the Bartender skill checkbox
     */
    public void selectBartenderSkillCheckbox() {
        wait.until(elementToBeClickable(skillsPageLocators.bartenderCheckbox));
        driver.findElement(skillsPageLocators.bartenderCheckbox).click();
    }

    /**
     * Deselects the Bartender skill checkbox
     */
    public void deselectBartenderSkillCheckbox() {
        if (isBartenderSkillCheckboxSelectedYes()) {
            wait.until(elementToBeClickable(skillsPageLocators.bartenderCheckboxSelected));
            driver.findElement(skillsPageLocators.bartenderCheckboxSelected).click();
        }
    }

    /**
     * Checks to see if the Bartender skill is selected
     * @return Whether or not the Bartender skill is selected
     */
    public boolean isBartenderSkillCheckboxSelectedYes() {
        return elementExists(skillsPageLocators.bartenderCheckboxSelected);
    }

    /**
     * Checks to see if the Bartender skill is deselected
     * @return Whether or not the Bartender skill is deselected
     */
    public boolean isBartenderSkillCheckboxSelectedNo() {
        return elementExists(skillsPageLocators.bartenderCheckbox);
    }

    /**
     * Selects the Busser skill checkbox
     */
    public void selectBusserSkillCheckbox() {
        wait.until(elementToBeClickable(skillsPageLocators.busserCheckbox));
        driver.findElement(skillsPageLocators.busserCheckbox).click();
    }

    /**
     * Deselects the Busser skill checkbox
     */
    public void deselectBusserSkillCheckbox() {
        if (isBusserSkillCheckboxSelectedYes()) {
            wait.until(elementToBeClickable(skillsPageLocators.busserCheckboxSelected));
            driver.findElement(skillsPageLocators.busserCheckboxSelected).click();
        }
    }

    /**
     * Checks to see if the Busser skill is selected
     * @return Whether or not the Busser skill is selected
     */
    public boolean isBusserSkillCheckboxSelectedYes() {
        return elementExists(skillsPageLocators.busserCheckboxSelected);
    }

    /**
     * Checks to see if the Busser skill is deselected
     * @return Whether or not the Busser skill is deselected
     */
    public boolean isBusserSkillCheckboxSelectedNo() {

        return elementExists(skillsPageLocators.busserCheckbox);
    }

    /**
     * Selects the Cashier skill checkbox
     */
    public void selectCashierSkillCheckbox() {
        wait.until(elementToBeClickable(skillsPageLocators.cashierCheckbox));
        driver.findElement(skillsPageLocators.cashierCheckbox).click();
    }

    /**
     * Deselects the Cashier skill checkbox
     */
    public void deselectCashierSkillCheckbox() {
        if (isCashierSkillCheckboxSelectedYes()) {
            wait.until(elementToBeClickable(skillsPageLocators.cashierCheckboxSelected));
            driver.findElement(skillsPageLocators.cashierCheckboxSelected).click();
        }
    }

    /**
     * Checks to see if the Cashier skill is selected
     * @return Whether or not the Cashier skill is selected
     */
    public boolean isCashierSkillCheckboxSelectedYes() {
        return elementExists(skillsPageLocators.cashierCheckboxSelected);
    }

    /**
     * Checks to see if the Cashier skill is deselected
     * @return Whether or not the Cashier skill is deselected
     */
    public boolean isCashierSkillCheckboxSelectedNo() {
        return elementExists(skillsPageLocators.cashierCheckbox);
    }

    /**
     * Selects the Chef skill checkbox
     */
    public void selectChefSkillCheckbox() {
        wait.until(elementToBeClickable(skillsPageLocators.chefCheckbox));
        driver.findElement(skillsPageLocators.chefCheckbox).click();
    }

    /**
     * Deselects the Chef skill checkbox
     */
    public void deselectChefSkillCheckbox() {
        if (isChefSkillCheckboxSelectedYes()) {
            wait.until(elementToBeClickable(skillsPageLocators.chefCheckboxSelected));
            driver.findElement(skillsPageLocators.chefCheckboxSelected).click();
        }
    }

    /**
     * Checks to see if the Chef skill is selected
     * @return Whether or not the Chef skill is selected
     */
    public boolean isChefSkillCheckboxSelectedYes() {
        return elementExists(skillsPageLocators.chefCheckboxSelected);
    }

    /**
     * Checks to see if the Chef skill is deselected
     * @return Whether or not the Chef skill is deselected
     */
    public boolean isChefSkillCheckboxSelectedNo() {
        return elementExists(skillsPageLocators.chefCheckbox);
    }

    /**
     * Selects the Cook skill checkbox
     */
    public void selectCookSkillCheckbox() {
        wait.until(elementToBeClickable(skillsPageLocators.cookCheckbox));
        driver.findElement(skillsPageLocators.cookCheckbox).click();
    }

    /**
     * Deselects the Cook skill checkbox
     */
    public void deselectCookSkillCheckbox() {
        if (isCookSkillCheckboxSelectedYes()) {
            wait.until(elementToBeClickable(skillsPageLocators.cookCheckboxSelected));
            driver.findElement(skillsPageLocators.cookCheckboxSelected).click();
        }
    }

    /**
     * Checks to see if the Cook skill is selected
     * @return Whether or not the Cook skill is selected
     */
    public boolean isCookSkillCheckboxSelectedYes() {
        return elementExists(skillsPageLocators.cookCheckboxSelected);
    }

    /**
     * Checks to see if the Cook skill is deselected
     * @return Whether or not the Cook skill is deselected
     */
    public boolean isCookSkillCheckboxSelectedNo() {
        return elementExists(skillsPageLocators.cookCheckbox);
    }

    /**
     * Selects the Crew skill checkbox
     */
    public void selectCrewSkillCheckbox() {
        wait.until(elementToBeClickable(skillsPageLocators.crewCheckbox));
        driver.findElement(skillsPageLocators.crewCheckbox).click();
    }

    /**
     * Deselects the Crew skill checkbox
     */
    public void deselectCrewSkillCheckbox() {
        if (isCrewSkillCheckboxSelectedYes()) {
            wait.until(elementToBeClickable(skillsPageLocators.crewCheckboxSelected));
            driver.findElement(skillsPageLocators.crewCheckboxSelected).click();
        }
    }

    /**
     * Checks to see if the Crew skill is selected
     * @return Whether or not the Crew skill is selected
     */
    public boolean isCrewSkillCheckboxSelectedYes() {
        return elementExists(skillsPageLocators.crewCheckboxSelected);
    }

    /**
     * Checks to see if the Crew skill is deselected
     * @return Whether or not the Crew skill is deselected
     */
    public boolean isCrewSkillCheckboxSelectedNo() {
        return elementExists(skillsPageLocators.crewCheckbox);
    }

    /**
     * Selects the Dishwasher skill checkbox
     */
    public void selectDishwasherSkillCheckbox() {
        wait.until(elementToBeClickable(skillsPageLocators.dishwasherCheckbox));
        driver.findElement(skillsPageLocators.dishwasherCheckbox).click();
    }

    /**
     * Deselects the Dishwasher skill checkbox
     */
    public void deselectDishwasherSkillCheckbox() {
        if (isDishwasherSkillCheckboxSelectedYes()) {
            wait.until(elementToBeClickable(skillsPageLocators.dishwasherCheckboxSelected));
            driver.findElement(skillsPageLocators.dishwasherCheckboxSelected).click();
        }
    }

    /**
     * Checks to see if the Dishwasher skill is selected
     * @return Whether or not the Dishwasher skill is selected
     */
    public boolean isDishwasherSkillCheckboxSelectedYes() {
        return elementExists(skillsPageLocators.dishwasherCheckboxSelected);
    }

    /**
     * Checks to see if the Dishwasher skill is deselected
     * @return Whether or not the Dishwasher skill is deselected
     */
    public boolean isDishwasherSkillCheckboxSelectedNo() {
        return elementExists(skillsPageLocators.dishwasherCheckbox);
    }

    /**
     * Selects the Driver skill checkbox
     */
    public void selectDriverSkillCheckbox() {
        wait.until(elementToBeClickable(skillsPageLocators.driverCheckbox));
        driver.findElement(skillsPageLocators.driverCheckbox).click();
    }

    /**
     * Deselects the Driver skill checkbox
     */
    public void deselectDriverSkillCheckbox() {
        if (isDriverSkillCheckboxSelectedYes()) {
            wait.until(elementToBeClickable(skillsPageLocators.driverCheckboxSelected));
            driver.findElement(skillsPageLocators.driverCheckboxSelected).click();
        }
    }

    /**
     * Checks to see if the Driver skill is selected
     * @return Whether or not the Driver skill is selected
     */
    public boolean isDriverSkillCheckboxSelectedYes() {
        return elementExists(skillsPageLocators.driverCheckboxSelected);
    }

    /**
     * Checks to see if the Driver skill is deselected
     * @return Whether or not the Driver skill is deselected
     */
    public boolean isDriverSkillCheckboxSelectedNo() {
        return elementExists(skillsPageLocators.driverCheckbox);
    }

    /**
     * Selects the Drive-thru skill checkbox
     */
    public void selectDrivethruSkillCheckbox() {
        wait.until(elementToBeClickable(skillsPageLocators.drivethruCheckbox));
        driver.findElement(skillsPageLocators.drivethruCheckbox).click();
    }

    /**
     * Deselects the Drive-thru skill checkbox
     */
    public void deselectDrivethruSkillCheckbox() {
        if (isDrivethruSkillCheckboxSelectedYes()) {
            wait.until(elementToBeClickable(skillsPageLocators.drivethruCheckboxSelected));
            driver.findElement(skillsPageLocators.drivethruCheckboxSelected).click();
        }
    }

    /**
     * Checks to see if the Drive-thru skill is selected
     * @return Whether or not the Drivethru skill is selected
     */
    public boolean isDrivethruSkillCheckboxSelectedYes() {
        return elementExists(skillsPageLocators.drivethruCheckboxSelected);
    }

    /**
     * Checks to see if the Drive-thru skill is deselected
     * @return Whether or not the Drivethru skill is deselected
     */
    public boolean isDrivethruSkillCheckboxSelectedNo() {
        return elementExists(skillsPageLocators.drivethruCheckbox);
    }

    /**
     * Selects the Host skill checkbox
     */
    public void selectHostSkillCheckbox() {
        wait.until(elementToBeClickable(skillsPageLocators.hostCheckbox));
        driver.findElement(skillsPageLocators.hostCheckbox).click();
    }

    /**
     * Deselects the Host skill checkbox
     */
    public void deselectHostSkillCheckbox() {
        if (isHostSkillCheckboxSelectedYes()) {
            wait.until(elementToBeClickable(skillsPageLocators.hostCheckboxSelected));
            driver.findElement(skillsPageLocators.hostCheckboxSelected).click();
        }
    }

    /**
     * Checks to see if the Host skill is selected
     * @return Whether or not the Host skill is selected
     */
    public boolean isHostSkillCheckboxSelectedYes() {
        return elementExists(skillsPageLocators.hostCheckboxSelected);
    }

    /**
     * Checks to see if the Host skill is deselected
     * @return Whether or not the Host skill is deselected
     */
    public boolean isHostSkillCheckboxSelectedNo() {
        return elementExists(skillsPageLocators.hostCheckbox);
    }

    /**
     * Selects the Manager skill checkbox
     */
    public void selectManagerSkillCheckbox() {
        wait.until(elementToBeClickable(skillsPageLocators.managerCheckbox));
        driver.findElement(skillsPageLocators.managerCheckbox).click();
    }

    /**
     * Deselects the Manager skill checkbox
     */
    public void deselectManagerSkillCheckbox() {
        if (isManagerSkillCheckboxSelectedYes()) {
            wait.until(elementToBeClickable(skillsPageLocators.managerCheckboxSelected));
            driver.findElement(skillsPageLocators.managerCheckboxSelected).click();
        }
    }

    /**
     * Checks to see if the Manager skill is selected
     * @return Whether or not the Manager skill is selected
     */
    public boolean isManagerSkillCheckboxSelectedYes() {
        return elementExists(skillsPageLocators.managerCheckboxSelected);
    }

    /**
     * Checks to see if the Manager skill is deselected
     * @return Whether or not the Manager skill is deselected
     */
    public boolean isManagerSkillCheckboxSelectedNo() {
        return elementExists(skillsPageLocators.managerCheckbox);
    }

    /**
     * Selects the Prep Cook skill checkbox
     */
    public void selectPrepCookSkillCheckbox() {
        wait.until(elementToBeClickable(skillsPageLocators.prepCookCheckbox));
        driver.findElement(skillsPageLocators.prepCookCheckbox).click();
    }

    /**
     * Deselects the Prep Cook skill checkbox
     */
    public void deselectPrepCookSkillCheckbox() {
        if (isPrepCookSkillCheckboxSelectedYes()) {
            wait.until(elementToBeClickable(skillsPageLocators.prepCookCheckboxSelected));
            driver.findElement(skillsPageLocators.prepCookCheckboxSelected).click();
        }
    }

    /**
     * Checks to see if the Prep Cook skill is selected
     * @return Whether or not the Prep Cook skill is selected
     */
    public boolean isPrepCookSkillCheckboxSelectedYes() {
        return elementExists(skillsPageLocators.prepCookCheckboxSelected);
    }

    /**
     * Checks to see if the Prep Cook skill is deselected
     * @return Whether or not the Prep Cook skill is deselected
     */
    public boolean isPrepCookSkillCheckboxSelectedNo() {
        return elementExists(skillsPageLocators.prepCookCheckbox);
    }

    /**
     * Selects the Runner skill checkbox
     */
    public void selectRunnerSkillCheckbox() {
        wait.until(elementToBeClickable(skillsPageLocators.runnerCheckbox));
        driver.findElement(skillsPageLocators.runnerCheckbox).click();
    }

    /**
     * Deselects the Runner skill checkbox
     */
    public void deselectRunnerSkillCheckbox() {
        if (isRunnerSkillCheckboxSelectedYes()) {
            wait.until(elementToBeClickable(skillsPageLocators.runnerCheckboxSelected));
            driver.findElement(skillsPageLocators.runnerCheckboxSelected).click();
        }
    }

    /**
     * Checks to see if the Runner skill is selected
     * @return Whether or not the Runner skill is selected
     */
    public boolean isRunnerSkillCheckboxSelectedYes() {
        return elementExists(skillsPageLocators.runnerCheckboxSelected);
    }

    /**
     * Checks to see if the Runner skill is deselected
     * @return Whether or not the Runner skill is deselected
     */
    public boolean isRunnerSkillCheckboxSelectedNo() {
        return elementExists(skillsPageLocators.runnerCheckbox);
    }

    /**
     * Selects the Server skill checkbox
     */
    public void selectServerSkillCheckbox() {
        wait.until(elementToBeClickable(skillsPageLocators.serverCheckbox));
        driver.findElement(skillsPageLocators.serverCheckbox).click();
    }

    /**
     * Deselects the Server skill checkbox
     */
    public void deselectServerSkillCheckbox() {
        if (isServerSkillCheckboxSelectedYes()) {
            wait.until(elementToBeClickable(skillsPageLocators.serverCheckboxSelected));
            driver.findElement(skillsPageLocators.serverCheckboxSelected).click();
        }
    }

    /**
     * Checks to see if the Server skill is selected
     * @return Whether or not the Server skill is selected
     */
    public boolean isServerSkillCheckboxSelectedYes() {
        return elementExists(skillsPageLocators.serverCheckboxSelected);
    }

    /**
     * Checks to see if the Server skill is deselected
     * @return Whether or not the Server skill is deselected
     */
    public boolean isServerSkillCheckboxSelectedNo() {
        return elementExists(skillsPageLocators.serverCheckbox);
    }

    /**
     * Selects the Sommelier skill checkbox
     */
    public void selectSommelierSkillCheckbox() {
        wait.until(elementToBeClickable(skillsPageLocators.sommelierCheckbox));
        driver.findElement(skillsPageLocators.sommelierCheckbox).click();
    }

    /**
     * Deselects the Sommelier skill checkbox
     */
    public void deselectSommelierSkillCheckbox() {
        if (isSommelierSkillCheckboxSelectedYes()) {
            wait.until(elementToBeClickable(skillsPageLocators.sommelierCheckboxSelected));
            driver.findElement(skillsPageLocators.sommelierCheckboxSelected).click();
        }
    }

    /**
     * Checks to see if the Sommelier skill is selected
     * @return Whether or not the Sommelier skill is selected
     */
    public boolean isSommelierSkillCheckboxSelectedYes() {
        return elementExists(skillsPageLocators.sommelierCheckboxSelected);
    }

    /**
     * Checks to see if the Sommelier skill is deselected
     * @return Whether or not the Sommelier skill is deselected
     */
    public boolean isSommelierSkillCheckboxSelectedNo() {
        return elementExists(skillsPageLocators.sommelierCheckbox);
    }

    /**
     * Selects the Sous Chef skill checkbox
     */
    public void selectSousChefSkillCheckbox() {
        wait.until(elementToBeClickable(skillsPageLocators.sousChefCheckbox));
        driver.findElement(skillsPageLocators.sousChefCheckbox).click();
    }

    /**
     * Deselects the Sous Chef skill checkbox
     */
    public void deselectSousChefSkillCheckbox() {
        if (isSousChefSkillCheckboxSelectedYes()) {
            wait.until(elementToBeClickable(skillsPageLocators.sousChefCheckboxSelected));
            driver.findElement(skillsPageLocators.sousChefCheckboxSelected).click();
        }
    }

    /**
     * Checks to see if the Sous Chef skill is selected
     * @return Whether or not the Sous Chef skill is selected
     */
    public boolean isSousChefSkillCheckboxSelectedYes() {
        return elementExists(skillsPageLocators.sousChefCheckboxSelected);
    }

    /**
     * Checks to see if the Sous Chef skill is deselected
     * @return Whether or not the Sous Chef skill is deselected
     */
    public boolean isSousChefSkillCheckboxSelectedNo() {

        return elementExists(skillsPageLocators.sousChefCheckbox);
    }

    /**
     * Selects the Team Member skill checkbox
     */
    public void selectTeamMemberSkillCheckbox() {
        wait.until(elementToBeClickable(skillsPageLocators.teamMemberCheckbox));
        driver.findElement(skillsPageLocators.teamMemberCheckbox).click();
    }

    /**
     * Deselects the Team Member skill checkbox
     */
    public void deselectTeamMemberSkillCheckbox() {
        if (isTeamMemberSkillCheckboxSelectedYes()) {
            wait.until(elementToBeClickable(skillsPageLocators.teamMemberCheckboxSelected));
            driver.findElement(skillsPageLocators.teamMemberCheckboxSelected).click();
        }
    }

    /**
     * Checks to see if the Team Member skill is selected
     * @return Whether or not the Team Member skill is selected
     */
    public boolean isTeamMemberSkillCheckboxSelectedYes() {
        return elementExists(skillsPageLocators.teamMemberCheckboxSelected);
    }

    /**
     * Checks to see if the Team Member skill is deselected
     * @return Whether or not the Team Member skill is deselected
     */
    public boolean isTeamMemberSkillCheckboxSelectedNo() {
        return elementExists(skillsPageLocators.teamMemberCheckbox);
    }

    /**
     * Selects the Trainer skill checkbox
     */
    public void selectTrainerSkillCheckbox() {
        wait.until(elementToBeClickable(skillsPageLocators.trainerCheckbox));
        driver.findElement(skillsPageLocators.trainerCheckbox).click();
    }

    /**
     * Deselects the Trainer skill checkbox
     */
    public void deselectTrainerSkillCheckbox() {
        if (isTrainerSkillCheckboxSelectedYes()) {
            wait.until(elementToBeClickable(skillsPageLocators.trainerCheckboxSelected));
            driver.findElement(skillsPageLocators.trainerCheckboxSelected).click();
        }
    }

    /**
     * Checks to see if the Trainer skill is selected
     * @return Whether or not the Trainer skill is selected
     */
    public boolean isTrainerSkillCheckboxSelectedYes() {
        return elementExists(skillsPageLocators.trainerCheckboxSelected);
    }

    /**
     * Checks to see if the Trainer skill is deselected
     * @return Whether or not the Trainer skill is deselected
     */
    public boolean isTrainerSkillCheckboxSelectedNo() {
        return elementExists(skillsPageLocators.trainerCheckbox);
    }

    /**
     * Select all skills from an empty state
     */
    public void selectAllSkills() {
        selectBakerSkillCheckbox();
        selectBarbackSkillCheckbox();
        selectBaristaSkillCheckbox();
        selectBartenderSkillCheckbox();
        selectBusserSkillCheckbox();
        selectCashierSkillCheckbox();
        selectChefSkillCheckbox();
        selectCookSkillCheckbox();
        selectCrewSkillCheckbox();
        selectDishwasherSkillCheckbox();
        selectDriverSkillCheckbox();
        selectDrivethruSkillCheckbox();
        selectHostSkillCheckbox();
        selectManagerSkillCheckbox();
        selectPrepCookSkillCheckbox();
        selectRunnerSkillCheckbox();
        selectServerSkillCheckbox();
        selectSommelierSkillCheckbox();
        selectSousChefSkillCheckbox();
        selectTeamMemberSkillCheckbox();
        selectTrainerSkillCheckbox();
        clickSaveBtn();
    }

    /**
     * Remove all skills from a state where all skills are selected
     */
    public void removeAllSkills() {
        deselectBakerSkillCheckbox();
        deselectBarbackSkillCheckbox();
        deselectBaristaSkillCheckbox();
        deselectBartenderSkillCheckbox();
        deselectBusserSkillCheckbox();
        deselectCashierSkillCheckbox();
        deselectChefSkillCheckbox();
        deselectCookSkillCheckbox();
        deselectCrewSkillCheckbox();
        deselectDishwasherSkillCheckbox();
        deselectDriverSkillCheckbox();
        deselectDrivethruSkillCheckbox();
        deselectHostSkillCheckbox();
        deselectManagerSkillCheckbox();
        deselectPrepCookSkillCheckbox();
        deselectRunnerSkillCheckbox();
        deselectServerSkillCheckbox();
        deselectSommelierSkillCheckbox();
        deselectSousChefSkillCheckbox();
        deselectTeamMemberSkillCheckbox();
        deselectTrainerSkillCheckbox();
        clickSaveBtn();
    }

    /**
     * Verify that all skills have been selected
     * @return Whether or not all skills have been selected
     */
    public boolean allSkillsSelected() {
        if (isBakerSkillCheckboxSelectedYes() &&
                isBarbackSkillCheckboxSelectedYes() &&
                isBaristaSkillCheckboxSelectedYes() &&
                isBartenderSkillCheckboxSelectedYes() &&
                isBusserSkillCheckboxSelectedYes() &&
                isCashierSkillCheckboxSelectedYes() &&
                isChefSkillCheckboxSelectedYes() &&
                isCookSkillCheckboxSelectedYes() &&
                isCrewSkillCheckboxSelectedYes() &&
                isDishwasherSkillCheckboxSelectedYes() &&
                isDriverSkillCheckboxSelectedYes() &&
                isDrivethruSkillCheckboxSelectedYes() &&
                isHostSkillCheckboxSelectedYes() &&
                isManagerSkillCheckboxSelectedYes() &&
                isPrepCookSkillCheckboxSelectedYes() &&
                isRunnerSkillCheckboxSelectedYes() &&
                isServerSkillCheckboxSelectedYes() &&
                isSommelierSkillCheckboxSelectedYes() &&
                isSousChefSkillCheckboxSelectedYes() &&
                isTeamMemberSkillCheckboxSelectedYes() &&
                isTrainerSkillCheckboxSelectedYes()
                ) {
            return true;
        }
        return false;
    }

    /**
     * Verify that all skills have been deselected
     * @return Whether or not all skills have been deselected
     */
    public boolean noSkillsSelected() {
        if (isBakerSkillCheckboxSelectedNo() &&
                isBarbackSkillCheckboxSelectedNo() &&
                isBaristaSkillCheckboxSelectedNo() &&
                isBartenderSkillCheckboxSelectedNo() &&
                isBusserSkillCheckboxSelectedNo() &&
                isCashierSkillCheckboxSelectedNo() &&
                isChefSkillCheckboxSelectedNo() &&
                isCookSkillCheckboxSelectedNo() &&
                isCrewSkillCheckboxSelectedNo() &&
                isDishwasherSkillCheckboxSelectedNo() &&
                isDriverSkillCheckboxSelectedNo() &&
                isDrivethruSkillCheckboxSelectedNo() &&
                isHostSkillCheckboxSelectedNo() &&
                isManagerSkillCheckboxSelectedNo() &&
                isPrepCookSkillCheckboxSelectedNo() &&
                isRunnerSkillCheckboxSelectedNo() &&
                isServerSkillCheckboxSelectedNo() &&
                isSommelierSkillCheckboxSelectedNo() &&
                isSousChefSkillCheckboxSelectedNo() &&
                isTeamMemberSkillCheckboxSelectedNo() &&
                isTrainerSkillCheckboxSelectedNo()
                ) {
            return true;
        }
        return false;
    }

    /**
     * Clicks the save button on the skills page.
     */
    public void clickSaveBtn() {
        wait.until(elementToBeClickable(skillsPageLocators.saveBtn));
        driver.findElement(skillsPageLocators.saveBtn).click();
    }
}