import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * Created by alex.esparza on 2/16/17.
 */
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
        public By addBasicInfoBtn = By.cssSelector("div.bf-card>a[href='#/profile/edit/basic-info?goBackTo=profile']");
        public By editBasicInfoBtn = By.cssSelector("div.bf-card>div>a[href='#/profile/edit/basic-info?goBackTo=profile']");
        public By basicInfoAgeTxt = By.cssSelector("div.bf-col>div:nth-of-type(6)>div.bf-list>div:nth-of-type(1)>div.bf-list-item>div");
        public By basicInfoAgeYesBtn = By.cssSelector("div.bf-col>div:nth-of-type(6)>div.bf-list>div:nth-of-type(1)>div.bf-circle.green");
        public By basicInfoAgeNoBtn = By.cssSelector("div.bf-col>div:nth-of-type(6)>div.bf-list>div:nth-of-type(1)>div.bf-circle.red");
        public By basicInfoTransportTxt = By.cssSelector("div.bf-col>div:nth-of-type(6)>div.bf-list>div:nth-of-type(2)>div.bf-list-item>div");
        public By basicInfoTransportYesBtn = By.cssSelector("div.bf-col>div:nth-of-type(6)>div.bf-list>div:nth-of-type(2)>div.bf-circle.green");
        public By basicInfoTransportNoBtn =  By.cssSelector("div.bf-col>div:nth-of-type(6)>div.bf-list>div:nth-of-type(2)>div.bf-circle.red");
        public By basicInfoLegalTxt = By.cssSelector("div.bf-col>div:nth-of-type(6)>div.bf-list>div:nth-of-type(3)>div.bf-list-item>div");
        public By basicInfoLegalYesBtn = By.cssSelector("div.bf-col>div:nth-of-type(6)>div.bf-list>div:nth-of-type(3)>div.bf-circle.green");
        public By basicInfoLegalNoBtn = By.cssSelector("div.bf-col>div:nth-of-type(6)>div.bf-list>div:nth-of-type(3)>div.bf-circle.red");
        public By addAvailabilityBtn = By.cssSelector("div.bf-card>a[href='#/profile/edit/availability?goBackTo=profile']");
        public By editAvailabilityBtn = By.cssSelector("div.bf-card>div>a[href='#/profile/edit/availability?goBackTo=profile']");
        public By addAboutBtn = By.cssSelector("div.bf-card>a[href='#/profile/edit/about?goBackTo=profile']");
        public By editAboutBtn = By.cssSelector("div.bf-card>div>a[href='#/profile/edit/about?goBackTo=profile']");
        public By aboutHeader = By.cssSelector("div.bf-col>div:nth-of-type(5)>div>h3");
        public By aboutTxtField = By.cssSelector("div.bf-col>div:nth-of-type(5)>p");
        public By emptyAboutTxtField = By.cssSelector("div.bf-col>div:nth-of-type(5)>div>p");
        public By skillsHeader = By.cssSelector ("div.bf-col>div:nth-of-type(3)>div>h3");
        public By addSkillsBtn = By.id ("skillsCardEmptyAddBtn");
        public By editSkillsBtn = By.id ("skillsCardEditBtn");
        public By skill0 = By.id ("skillsCardListItem0");
        public By skill1 = By.id ("skillsCardListItem1");
        public By skill2 = By.id ("skillsCardListItem2");
        public By skill3 = By.id ("skillsCardListItem3");
        public By skill4 = By.id ("skillsCardListItem4");
        public By skill5 = By.id ("skillsCardListItem5");
        public By skill6 = By.id ("skillsCardListItem6");
        public By skill7 = By.id ("skillsCardListItem7");
        public By skill8 = By.id ("skillsCardListItem8");
        public By skill9 = By.id ("skillsCardListItem9");
        public By skill10 = By.id ("skillsCardListItem10");
        public By skill11 = By.id ("skillsCardListItem11");
        public By skill12 = By.id ("skillsCardListItem12");
        public By skill13 = By.id ("skillsCardListItem13");
        public By skill14 = By.id ("skillsCardListItem14");
        public By skill15 = By.id ("skillsCardListItem15");
        public By skill16 = By.id ("skillsCardListItem16");
        public By skill17 = By.id ("skillsCardListItem17");
        public By skill18 = By.id ("skillsCardListItem18");
        public By skill19 = By.id ("skillsCardListItem19");
        public By skill20 = By.id ("skillsCardListItem20");
        public By emptySkillsTxt = By.id ("skillsCardEmptyDescriptionText");
        public By successToastDiv = By.cssSelector("div.bf-toast.success>div");
        public By profileBackBtn = By.cssSelector("button.bf-button");
    }

    public static class BasicInfoPageLocators {
        public By headerTitle = By.cssSelector("h1.bf-body-side-menu-title");
        public By headerText = By.cssSelector("div.bf-body-side-menu-header>p");
        public By ageQuestionText = By.cssSelector("ul.bf-eligibility-questions>li.question-wrapper:nth-of-type(1)>div.question");
        public By ageYesBtn = By.cssSelector("ul.bf-eligibility-questions>li.question-wrapper:nth-of-type(1) * div#on");
        public By ageYesBtnSelected = By.cssSelector("ul.bf-eligibility-questions>li.question-wrapper:nth-of-type(1)>div.bf-toggle-button.on");
        public By ageNoBtn = By.cssSelector("ul.bf-eligibility-questions>li.question-wrapper:nth-of-type(1) * div#off");
        public By ageNoBtnSelected = By.cssSelector("ul.bf-eligibility-questions>li.question-wrapper:nth-of-type(1)>div.bf-toggle-button.off");
        public By transportQuestionTxt = By.cssSelector("ul.bf-eligibility-questions>li.question-wrapper:nth-of-type(2)>div.question");
        public By transportYesBtn = By.cssSelector("ul.bf-eligibility-questions>li.question-wrapper:nth-of-type(2) * div#on");
        public By transportYesBtnSelected = By.cssSelector("ul.bf-eligibility-questions>li.question-wrapper:nth-of-type(2)>div.bf-toggle-button.on");
        public By transportNoBtn = By.cssSelector("ul.bf-eligibility-questions>li.question-wrapper:nth-of-type(2) * div#off");
        public By transportNoBtnSelected = By.cssSelector("ul.bf-eligibility-questions>li.question-wrapper:nth-of-type(2)>div.bf-toggle-button.off");
        public By legalQuestionTxt = By.cssSelector("ul.bf-eligibility-questions>li.question-wrapper:nth-of-type(3)>div.question");
        public By legalYesBtn = By.cssSelector("ul.bf-eligibility-questions>li.question-wrapper:nth-of-type(3) * div#on");
        public By legalYesBtnSelected = By.cssSelector("ul.bf-eligibility-questions>li.question-wrapper:nth-of-type(3)>div.bf-toggle-button.on");
        public By legalNoBtn = By.cssSelector("ul.bf-eligibility-questions>li.question-wrapper:nth-of-type(3) * div#off");
        public By legalNoBtnSelected = By.cssSelector("ul.bf-eligibility-questions>li.question-wrapper:nth-of-type(3)>div.bf-toggle-button.off");
        public By saveBtn = By.cssSelector("div.bf-flex-layout * button.bf-button");
    }

    public static class AboutPageLocators {
        public By aboutHeader =  By.cssSelector("h1.bf-body-side-menu-title");
        public By aboutTextField =  By.cssSelector("textarea.form-control");
        public By aboutSaveBtn =  By.cssSelector("div.bf-flex-layout * button.bf-button");
    }

    public static class AvailabilityPageLocators {
        public By morningCheckbox = By.cssSelector("div.profile-wizard-availability>div.availability-line:nth-of-type(1) * div.bf-checkbox");
        public By afternoonCheckbox = By.cssSelector("div.profile-wizard-availability>div.availability-line:nth-of-type(2) * div.bf-checkbox");
        public By eveningCheckbox = By.cssSelector("div.profile-wizard-availability>div.availability-line:nth-of-type(3) * div.bf-checkbox");
        public By nightsCheckbox = By.cssSelector("div.profile-wizard-availability>div.availability-line:nth-of-type(4) * div.bf-checkbox");
        public By morningCheckboxSelected = By.cssSelector("div.profile-wizard-availability>div.availability-line:nth-of-type(1) * div.checked");
        public By afternoonCheckboxSelected = By.cssSelector("div.profile-wizard-availability>div.availability-line:nth-of-type(2) * div.checked");
        public By eveningCheckboxSelected = By.cssSelector("div.profile-wizard-availability>div.availability-line:nth-of-type(3) * div.checked");
        public By nightsCheckboxSelected = By.cssSelector("div.profile-wizard-availability>div.availability-line:nth-of-type(4) * div.checked");
        public By saveBtn = By.cssSelector("div.bf-flex-layout * button.bf-button");
        public By successToastDiv = By.cssSelector("div.bf-toast.success>div");
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
        public By successToastDiv = By.cssSelector("div.bf-toast.success>div");
    }
}