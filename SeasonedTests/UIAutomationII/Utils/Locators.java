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
}
