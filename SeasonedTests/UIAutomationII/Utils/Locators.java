import org.openqa.selenium.By;

public class Locators {

    public static class NavPageLocators {
        /* Non Auth Nav Header Locators */
        public By BrushfireLogo = By.id("headerLogoImg");
        public By jobSearchTxtField = By.id("headerSearchInput");
        public By loginBtn = By.id("headerLoginLink");
        public By signUpBtn = By.id("headerJoinLink");
        public By managerBtn = By.id("headerManagersLink");

        /* Auth'd Nav Header Locators */
        public By contentFeedBtn = By.id("headerFeedLink");
        public By messagesBtn = By.id("headerMessagesLink");
        public By userNameBtn = By.cssSelector("a.username");
        public By userPhotoBtn = By.id("headerMenuToggleBtn");
        public By userFullNameTxt = By.id("headerMenuFullNameTxt");
        public By userEmailTxt = By.id("headerMenuEmailTxt");
        public By menuProfileLink = By.id("headerMenuProfileLink");
        public By menuSettingsLink = By.id("headerMenuSettingsLink");
        public By menuLogoutLink = By.id("headerMenuLogOutLink");
    }

    public static class LoginPageLocators {
        public By facebookLoginBtn = By.id("loginFacebookBtn");
        public By hotschedulesLoginBtn = By.id("loginHSBtn");
        /* Login With Email */
        public By loginWithEmailTxt = By.cssSelector("div.bf-divider-message");
        public By emailTxtField = By.id("loginEmailInput");
        public By passwordTxtField = By.id("loginPasswordInput");
        public By forgotPasswordLink = By.id("loginForgotPasswordLink");
        public By rememberMeCheckbox = By.id("loginRememberMeChk");
        public By rememberMeTxt = By.cssSelector("div.bf-checkbox-container>p");
        public By loginButton = By.id("loginBtn");
        public By loginHotschedulesBtn = By.id("loginHSBtn");
        public By loginHotschedulesUsernameField = By.id("loginHSUsernameInput");
        public By loginHotschedulesPasswordField = By.id("loginHSPasswordInput");
        public By loginHotSchedulesCancelBtn = By.id("loginHSCancelLink");
        public By loginHotschedulesLoginBtn = By.id("loginHSSaveBtn");
        public By loginFacebookBtn = By.id("loginFacebookBtn");
    }

    public static class SignUpPageLocators {
        public By facebookLoginBtn = By.id("loginFacebookBtn");
        public By hotschedulesLoginBtn = By.id("loginHSBtn");
        /* Login With Email */
        public By loginWithEmailTxt = By.cssSelector("div.bf-divider-message");
        public By emailTxtField = By.id("loginEmailInput");
        public By passwordTxtField = By.id("loginPasswordInput");
        public By forgotPasswordLink = By.id("loginForgotPasswordLink");
        public By rememberMeCheckbox = By.id("loginRememberMeChk");
        public By rememberMeTxt = By.cssSelector("div.bf-checkbox-container>p");
        public By loginButton = By.id("loginBtn");
    }

    public static class ProfilePageLocators {
        public By addBasicInfoBtn = By.id("basicInfoCardEmptyAddBtn");
        public By editBasicInfoBtn = By.id("basicInfoCardEditBtn");
        public By basicInfoAgeTxt = By.id("basicInfoCardListItemAgeText");
        public By basicInfoAgeYesBtn = By.id("basicInfoCardListItemAgeYesImg");
        public By basicInfoAgeNoBtn = By.id("basicInfoCardListItemAgeNoImg");
        public By basicInfoTransportTxt = By.id("basicInfoCardListItemTransportText");
        public By basicInfoTransportYesBtn = By.id("basicInfoCardListItemTransportYesImg");
        public By basicInfoTransportNoBtn =  By.id("basicInfoCardListItemTransportNoImg");
        public By basicInfoLegalTxt = By.id("basicInfoCardListItemLegalText");
        public By basicInfoLegalYesBtn = By.id("basicInfoCardListItemLegalYesImg");
        public By basicInfoLegalNoBtn = By.id("basicInfoCardListItemLegalNoImg");

        public By addAvailabilityBtn = By.id("availabilityCardEmptyAddBtn");
        public By editAvailabilityBtn = By.id("availabilityCardEditBtn");
        public By availabilityMorningsSelectedImg = By.id("availabilityCardListItemMorningsImg");
        public By availabilityAfternoonsSelectedImg = By.id("availabilityCardListItemAfternoonsImg");
        public By availabilityEveningsSelectedImg = By.id("availabilityCardListItemEveningsImg");
        public By availabilityNightsSelectedImg = By.id("availabilityCardListItemNightsImg");

        public By addAboutBtn = By.id("aboutCardEmptyAddBtn");
        public By editAboutBtn = By.id("aboutCardEditBtn");
        public By aboutHeader = By.id("aboutCardTitleText");
        public By aboutTxtField = By.id("aboutCardAboutText");
        public By emptyAboutTxtField = By.id("aboutCardEmptyDescriptionText");

        public By skillsHeader = By.cssSelector ("div.bf-col>div:nth-of-type(3)>div>h3");
        public By addSkillsBtn = By.id ("skillsCardEmptyAddBtn");
        public By editSkillsBtn = By.id ("skillsCardEditBtn");
        public By skillsBakerTxt = By.id ("skillsCardListItemBaker");
        public By skillsBarBackTxt = By.id ("skillsCardListItemBar-back");
        public By skillsBaristaTxt = By.id ("skillsCardListItemBarista");
        public By skillsBartenderTxt = By.id ("skillsCardListItemBartender");
        public By skillsBusserTxt = By.id ("skillsCardListItemBusser");
        public By skillsCashierTxt = By.id ("skillsCardListItemCashier");
        public By skillsChefTxt = By.id ("skillsCardListItemChef");
        public By skillsCookTxt = By.id ("skillsCardListItemCook");
        public By skillsCrewTxt = By.id ("skillsCardListItemCrew");
        public By skillsDishwasherTxt = By.id ("skillsCardListItemDishwasher");
        public By skillsDriveThruTxt = By.id ("skillsCardListItemDrive-Thru");
        public By skillsDriverTxt = By.id ("skillsCardListItemDriver");
        public By skillsHostTxt = By.id ("skillsCardListItemHost");
        public By skillsManagerTxt = By.id ("skillsCardListItemManager");
        public By skillsPrepCookTxt = By.id ("skillsCardListItemPrepCook");
        public By skillsRunnerTxt = By.id ("skillsCardListItemRunner");
        public By skillsServerTxt = By.id ("skillsCardListItemServer");
        public By skillsSommelierTxt = By.id ("skillsCardListItemSommelier");
        public By skillsSousChefTxt = By.id ("skillsCardListItemSousChef");
        public By skillsTeamMemberTxt = By.id ("skillsCardListItemTeamMember");
        public By skillsTrainerTxt = By.id ("skillsCardListItemTrainer");
        public By emptySkillsTxt = By.id ("skillsCardEmptyDescriptionText");

        public By successToastDiv = By.cssSelector("div.bf-toast.success>div");
        public By profileBackBtn = By.cssSelector("button.bf-button");
    }

    public static class BasicInfoPageLocators {
        public By headerTitle = By.id("editProfileBasicInfoTitleText");
        public By headerText = By.id("editProfileBasicInfoSubTitleText");
        public By ageQuestionText = By.id("editEligibilityAgeText");
        public By ageYesBtn = By.id("editEligibilityAgeYesBtn");
        public By ageYesBtnSelected = By.cssSelector("ul.bf-eligibility-questions>li.question-wrapper:nth-of-type(1)>div.bf-toggle-button.on");
        public By ageNoBtn = By.id("editEligibilityAgeNoBtn");
        public By ageNoBtnSelected = By.cssSelector("ul.bf-eligibility-questions>li.question-wrapper:nth-of-type(1)>div.bf-toggle-button.off");
        public By transportQuestionTxt = By.id("editEligibilityTransportText");
        public By transportYesBtn = By.id("editEligibilityTransportYesBtn");
        public By transportYesBtnSelected = By.cssSelector("ul.bf-eligibility-questions>li.question-wrapper:nth-of-type(2)>div.bf-toggle-button.on");
        public By transportNoBtn = By.id("editEligibilityTransportNoBtn");
        public By transportNoBtnSelected = By.cssSelector("ul.bf-eligibility-questions>li.question-wrapper:nth-of-type(2)>div.bf-toggle-button.off");
        public By legalQuestionTxt = By.id("editEligibilityLegalText");
        public By legalYesBtn = By.id("editEligibilityLegalYesBtn");
        public By legalYesBtnSelected = By.cssSelector("ul.bf-eligibility-questions>li.question-wrapper:nth-of-type(3)>div.bf-toggle-button.on");
        public By legalNoBtn = By.id("editEligibilityLegalNoBtn");
        public By legalNoBtnSelected = By.cssSelector("ul.bf-eligibility-questions>li.question-wrapper:nth-of-type(3)>div.bf-toggle-button.off");
        public By saveBtn = By.id("editEligibilitySaveBtn");
    }

    public static class AboutPageLocators {
        public By aboutHeader =  By.id("editProfileAboutTitleText");
        public By aboutTextField =  By.id("editAboutTextArea");
        public By aboutSaveBtn =  By.id("editAboutSaveBtn");
    }

    public static class AvailabilityPageLocators {
        public By morningCheckbox = By.id("editAvailabilityMorningsChk");
        public By afternoonCheckbox = By.id("editAvailabilityAfternoonsChk");
        public By eveningCheckbox = By.id("editAvailabilityEveningsChk");
        public By nightsCheckbox = By.id("editAvailabilityNightsChk");
        public By saveBtn = By.id("editAvailabilitySaveBtn");
        public By successToastDiv = By.id("bodySideMenuToast");
    }

    public static class SkillsPageLocators {
        public By headerTitle = By.id("editProfileSkillsTitleText");
        public By bakerText = By.id("editSkillsBakerChkLabelText");
        public By bakerCheckbox = By.id("editSkillsBakerChk");
        public By bakerCheckboxSelected = By.cssSelector("div#editSkillsBakerChk.checked");
        public By barbackText = By.id("editSkillsBar-backChkLabelText");
        public By barbackCheckbox = By.id("editSkillsBar-backChk");
        public By barbackCheckboxSelected = By.cssSelector("div#editSkillsBar-backChk.checked");
        public By baristaText = By.id("editSkillsBaristaChkLabelText");
        public By baristaCheckbox = By.id("editSkillsBaristaChk");
        public By baristaCheckboxSelected = By.cssSelector("div#editSkillsBaristaChk.checked");
        public By bartenderText = By.id("editSkillsBartenderChkLabelText");
        public By bartenderCheckbox = By.id("editSkillsBartenderChk");
        public By bartenderCheckboxSelected = By.cssSelector("div#editSkillsBartenderChk.checked");
        public By busserText = By.id("editSkillsBusserChkLabelText");
        public By busserCheckbox = By.id("editSkillsBusserChk");
        public By busserCheckboxSelected = By.cssSelector("div#editSkillsBusserChk.checked");
        public By cashierText = By.id("editSkillsCashierChkLabelText");
        public By cashierCheckbox = By.id("editSkillsCashierChk");
        public By cashierCheckboxSelected = By.cssSelector("div#editSkillsCashierChk.checked");
        public By chefText = By.id("editSkillsChefChkLabelText");
        public By chefCheckbox = By.id("editSkillsChefChk");
        public By chefCheckboxSelected = By.cssSelector("div#editSkillsChefChk.checked");
        public By cookText = By.id("editSkillsCookChkLabelText");
        public By cookCheckbox = By.id("editSkillsCookChk");
        public By cookCheckboxSelected = By.cssSelector("div#editSkillsCookChk.checked");
        public By crewText = By.id("editSkillsCrewChkLabelText");
        public By crewCheckbox = By.id("editSkillsCrewChk");
        public By crewCheckboxSelected = By.cssSelector("div#editSkillsCrewChk.checked");
        public By dishwasherText = By.id("editSkillsDishwasherChkLabelText");
        public By dishwasherCheckbox = By.id("editSkillsDishwasherChk");
        public By dishwasherCheckboxSelected = By.cssSelector("div#editSkillsDishwasherChk.checked");
        public By driverText = By.id("editSkillsDriverChkLabelText");
        public By driverCheckbox = By.id("editSkillsDriverChk");
        public By driverCheckboxSelected = By.cssSelector("div#editSkillsDriverChk.checked");
        public By drivethruText = By.id("editSkillsDrive-ThruChkLabelText");
        public By drivethruCheckbox = By.id("editSkillsDrive-ThruChk");
        public By drivethruCheckboxSelected = By.cssSelector("div#editSkillsDrive-ThruChk.checked");
        public By hostText = By.id("editSkillsHostChkLabelText");
        public By hostCheckbox = By.id("editSkillsHostChk");
        public By hostCheckboxSelected = By.cssSelector("div#editSkillsHostChk.checked");
        public By managerText = By.id("editSkillsManagerChkLabelText");
        public By managerCheckbox = By.id("editSkillsManagerChk");
        public By managerCheckboxSelected = By.cssSelector("div#editSkillsManagerChk.checked");
        public By prepCookText = By.id("editSkillsPrepCookChkLabelText");
        public By prepCookCheckbox = By.id("editSkillsPrepCookChk");
        public By prepCookCheckboxSelected = By.cssSelector("div#editSkillsPrepCookChk.checked");
        public By runnerText = By.id("editSkillsRunnerChkLabelText");
        public By runnerCheckbox = By.id("editSkillsRunnerChk");
        public By runnerCheckboxSelected = By.cssSelector("div#editSkillsRunnerChk.checked");
        public By serverText = By.id("editSkillsServerChkLabelText");
        public By serverCheckbox = By.id("editSkillsServerChk");
        public By serverCheckboxSelected = By.cssSelector("div#editSkillsServerChk.checked");
        public By sommelierText = By.id("editSkillsSommelierChkLabelText");
        public By sommelierCheckbox = By.id("editSkillsSommelierChk");
        public By sommelierCheckboxSelected = By.cssSelector("div#editSkillsSommelierChk.checked");
        public By sousChefText = By.id("editSkillsSousChefChkLabelText");
        public By sousChefCheckbox = By.id("editSkillsSousChefChk");
        public By sousChefCheckboxSelected = By.cssSelector("div#editSkillsSousChefChk.checked");
        public By teamMemberText = By.id("editSkillsTeamMemberChkLabelText");
        public By teamMemberCheckbox = By.id("editSkillsTeamMemberChk");
        public By teamMemberCheckboxSelected = By.cssSelector("div#editSkillsTeamMemberChk.checked");
        public By trainerText = By.id("editSkillsTrainerChkLabelText");
        public By trainerCheckbox = By.id("editSkillsTrainerChk");
        public By trainerCheckboxSelected = By.cssSelector("div#editSkillsTrainerChk.checked");
        public By saveBtn = By.id("editSkillsSaveBtn");
        public By successToastDiv = By.id("bodySideMenuToast");
    }
}