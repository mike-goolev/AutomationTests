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
        /* Login With Email */
        public By loginWithEmailTxt = By.cssSelector("div.bf-divider-message");
        public By emailTxtField = By.id("loginEmailInput");
        public By passwordTxtField = By.id("loginPasswordInput");
        public By forgotPasswordLink = By.id("loginForgotPasswordLink");
        public By rememberMeCheckbox = By.id("loginRememberMeChk");
        public By rememberMeTxt = By.cssSelector("div.bf-checkbox-container>p");
        public By loginButton = By.id("loginBtn");

        /* Login With HotSchedules */
        public By hotschedulesLoginBtn = By.id("loginHSBtn");
        public By loginHotschedulesUsernameField = By.id("loginHSUsernameInput");
        public By loginHotschedulesPasswordField = By.id("loginHSPasswordInput");
        public By loginHotSchedulesCancelBtn = By.id("loginHSCancelLink");
        public By loginHotschedulesLoginBtn = By.id("loginHSSaveBtn");

        /* Login With Facebook */
        public By loginFacebookBtn = By.id("loginFacebookBtn");

        /* Facebook.com Locators */
        public By faceBookEmailField = By.id("email");
        public By faceBookPasswordField = By.id("pass");
        public By facebookLoginBtn = By.id("loginbutton");
    }


    public static class SignUpPageLocators {
        /* Sign Up With Email*/
        public By nameField = By.id("signUpFullNameInput");
        public By emailField = By.id("signUpEmailInput");
        public By passwordField = By.id("signUpPasswordInput");
        public By cancelBtn = By.id("signUpCancelLink");
        public By continueBtn = By.id("signUpContinueBtn");

        /* Sign Up With Facebook */
        public By facebookSignUpBtn = By.id("signUpFacebookBtn");
    }

    public static class ContentPageLocators {
        /* Non Auth Content Locators */
        public By getStartedImg = By.id("marketingCardImg");
        public By getStartedTitle = By.id("marketingCardTitleText");
        public By getStartedTxt = By.id("marketingCardDescriptionText");
        public By getStartedBtn = By.id("marketingCardBtn");

        /* Shared Non Auth and Auth'd Content Locators */
        public By articleImg0 = By.id("articleImg0");
        public By artcleTitleTxt0 = By.id(""); //Still missing
        public By articleSiteTxt0 = By.id("articleSiteNameText0");
        public By articleDescriptionTxt0 = By.id("articleDescriptionText0");
        public By articlePublisherImg0 = By.id("articleAuthorImg0");
        public By articlePublisherNameTxt0 = By.id("articleAuthorNameText0");
        public By articlePublishedDateTxt0 = By.id("articlePostedTimeAgoText0");
        public By articleLikeBtn0 = By.id("articleLikeBtn0");
        public By articleLikeCountTxt0 = By.id("articleLikeCountText0");
        public By trendingTitle = By.id("trendingArticlesPreviewCardTitle");
        public By trendingArticleImg0 = By.id("trendingArticlesPreviewItemImage0");
        public By trendingArticleTitleTxt0 = By.id("trendingArticlesPreviewItemTitle0");
        public By trendingArticleSiteTxt0 = By.id("trendingArticlesPreviewItemSiteName0");
        public By findJobsImg = By.id("dedicatedJobsCardImg");
        public By findJobsTitle = By.id("dedicatedJobsCardTitleText");
        public By findJobsTxt = By.id("dedicatedJobsCardDescriptionText");
        public By findJobsBtn = By.id("dedicatedJobsCardBtn");

        /* Auth'd Content Locators */
        public By viewedArticleTitle = By.id("recentlyViewedArticlesPreviewCardTitle");
        public By viewedArticleImg0 = By.id("recentlyViewedArticlesPreviewItemImage0");
        public By viewedArticleTitleTxt0 = By.id("recentlyViewedArticlesPreviewItemTitle0");
        public By viewedArticleSiteTxt0 = By.id("recentlyViewedArticlesPreviewItemSiteName0");
        public By profilePreviewImg = By.id("profilePreviewCardUserImage");
        public By profilePreviewNameTxt = By.id("profilePreviewNameText");
        public By profilePreviewLocationTxt = By.id("profilePreviewLocationText");
        public By profilePreviewProfileLink = By.id("profilePreviewBuildProfileTitleText");
        public By profilePreviewProfileTxt = By.id("profilePreviewBuildProfileBodyText");
        public By profilePreviewScheduleLink = By.id("profilePreviewScheduleTitleText");
        public By profilePreviewScheduleTxt = By.id("profilePreviewScheduleBodyText");
        public By profilePreviewScheduleBtn = By.id("profilePreviewProfileBtn");
        public By suggestedConnectionTitle = By.id("suggestedConnectionTitleText");
        public By currentSuggestedConnectionBtn = By.id("currentSuggestedConnectionBtn");
        public By currentSuggestedConnectionImg = By.id("currentSuggestedConnectionImg");
        public By nextSuggestedConnectionBtn = By.id("nextSuggestedConnectionBtn");
        public By nextSuggestedConnectionImg = By.id("nextSuggestedConnectionImg");
        public By previousSuggestedConnectionBtn = By.id("previousSuggestedConnectionBtn");
        public By previousSuggestedConnectionImg = By.id("previousSuggestedConnectionImg");
    }

    public static class ProfilePageLocators {
        /* Basic Info Section */
        public By addBasicInfoBtn = By.cssSelector("div.bf-card>a[href='#/profile/edit/basic-info?goBackTo=profile']");
        public By editBasicInfoBtn = By.cssSelector("div.bf-card>div>a[href='#/profile/edit/basic-info?goBackTo=profile']");
        public By basicInfoAgeTxt = By.cssSelector("div.bf-col>div:nth-of-type(6)>div.bf-list>div:nth-of-type(1)>div.bf-list-item>div");
        public By basicInfoAgeYesBtn = By.cssSelector("div.bf-col>div:nth-of-type(6)>div.bf-list>div:nth-of-type(1)>div.bf-circle.green");
        public By basicInfoAgeNoBtn = By.cssSelector("div.bf-col>div:nth-of-type(6)>div.bf-list>div:nth-of-type(1)>div.bf-circle.red");
        public By basicInfoTransportTxt = By.cssSelector("div.bf-col>div:nth-of-type(6)>div.bf-list>div:nth-of-type(2)>div.bf-list-item>div");
        public By basicInfoTransportYesBtn = By.cssSelector("div.bf-col>div:nth-of-type(6)>div.bf-list>div:nth-of-type(2)>div.bf-circle.green");
        public By basicInfoTransportNoBtn = By.cssSelector("div.bf-col>div:nth-of-type(6)>div.bf-list>div:nth-of-type(2)>div.bf-circle.red");
        public By basicInfoLegalTxt = By.cssSelector("div.bf-col>div:nth-of-type(6)>div.bf-list>div:nth-of-type(3)>div.bf-list-item>div");
        public By basicInfoLegalYesBtn = By.cssSelector("div.bf-col>div:nth-of-type(6)>div.bf-list>div:nth-of-type(3)>div.bf-circle.green");
        public By basicInfoLegalNoBtn = By.cssSelector("div.bf-col>div:nth-of-type(6)>div.bf-list>div:nth-of-type(3)>div.bf-circle.red");

        /* Availability Section */
        public By addAvailabilityBtn = By.id("availabilityCardEmptyAddBtn");
        public By editAvailabilityBtn = By.id("availabilityCardEditBtn");
        public By availabilityMorningsSelectedImg = By.id("availabilityCardListItem0Img");
        public By availabilityAfternoonsSelectedImg = By.id("availabilityCardListItem1Img");
        public By availabilityEveningsSelectedImg = By.id("availabilityCardListItem2Img");
        public By availabilityNightsSelectedImg = By.id("availabilityCardListItem3Img");

        /*About Section */
        public By addAboutBtn = By.cssSelector("div.bf-card>a[href='#/profile/edit/about?goBackTo=profile']");
        public By editAboutBtn = By.cssSelector("div.bf-card>div>a[href='#/profile/edit/about?goBackTo=profile']");
        public By aboutHeader = By.cssSelector("div.bf-col>div:nth-of-type(5)>div>h3");
        public By aboutTxtField = By.cssSelector("div.bf-col>div:nth-of-type(5)>p");
        public By emptyAboutTxtField = By.cssSelector("div.bf-col>div:nth-of-type(5)>div>p");

        /* Skills Section */
        public By skillsHeader = By.cssSelector ("div.bf-col>div:nth-of-type(3)>div>h3");
        public By addSkillsBtn = By.id ("skillsCardEmptyAddBtn");
        public By editSkillsBtn = By.id ("skillsCardEditBtn");
        public By skillBakerTxt = By.id ("skillsCardListItemBaker");
        public By skillBarback = By.id ("skillsCardListItemBar-back");
        public By skillBarista = By.id ("skillsCardListItemBarista");
        public By skillBartender = By.id ("skillsCardListItemBartender");
        public By skillBusser = By.id ("skillsCardListItemBusser");
        public By skillCashier = By.id ("skillsCardListItemCashier");
        public By skillChef = By.id ("skillsCardListItemChef");
        public By skillCook = By.id ("skillsCardListItemCook");
        public By skillCrew = By.id ("skillsCardListItemCrew");
        public By skillDishwasher = By.id ("skillsCardListItemDishwasher");
        public By skillDrivethru = By.id ("skillsCardListItemDrive-Thru");
        public By skillDriver = By.id ("skillsCardListItemDriver");
        public By skillHost = By.id ("skillsCardListItemHost");
        public By skillManager = By.id ("skillsCardListItemManager");
        public By skillPrepCook = By.id ("skillsCardListItemPrepCook");
        public By skillRunner = By.id ("skillsCardListItemRunner");
        public By skillServer = By.id ("skillsCardListItemServer");
        public By skillSommelier = By.id ("skillsCardListItemSommelier");
        public By skillSousChef = By.id ("skillsCardListItemSousChef");
        public By skillTeamMember = By.id ("skillsCardListItemTeamMember");
        public By skillTrainer = By.id ("skillsCardListItemTrainer");
        public By emptySkillsTxt = By.id ("skillsCardEmptyDescriptionText");

        /* Shared profile page locators */
        public By successToastDiv = By.id("edit-skills-loader");
        public By profileBackBtn = By.id("editProfileBackBtn");
    }

    public static class BasicInfoPageLocators {
        public By headerTitle = By.cssSelector("h1.bf-body-side-menu-title");
        public By headerText = By.cssSelector("div.bf-body-side-menu-header>p");
        public By ageQuestionText = By.id("editEligibility0Text");
        public By ageYesBtn = By.id("editEligibility0YesBtn");
        public By ageYesBtnSelected = By.cssSelector("ul.bf-eligibility-questions>li.question-wrapper:nth-of-type(1)>div.bf-toggle-button.on");
        public By ageNoBtn = By.id("editEligibility0NoBtn");
        public By ageNoBtnSelected = By.cssSelector("ul.bf-eligibility-questions>li.question-wrapper:nth-of-type(1)>div.bf-toggle-button.off");
        public By transportQuestionTxt = By.id("editEligibility1Text");
        public By transportYesBtn = By.id("editEligibility1YesBtn");
        public By transportYesBtnSelected = By.cssSelector("ul.bf-eligibility-questions>li.question-wrapper:nth-of-type(2)>div.bf-toggle-button.on");
        public By transportNoBtn = By.id("editEligibility1NoBtn");
        public By transportNoBtnSelected = By.cssSelector("ul.bf-eligibility-questions>li.question-wrapper:nth-of-type(2)>div.bf-toggle-button.off");
        public By legalQuestionTxt = By.id("editEligibility2Text");
        public By legalYesBtn = By.id("editEligibility2YesBtn");
        public By legalYesBtnSelected = By.cssSelector("ul.bf-eligibility-questions>li.question-wrapper:nth-of-type(3)>div.bf-toggle-button.on");
        public By legalNoBtn = By.id("editEligibility2NoBtn");
        public By legalNoBtnSelected = By.cssSelector("ul.bf-eligibility-questions>li.question-wrapper:nth-of-type(3)>div.bf-toggle-button.off");
        public By saveBtn = By.id("editEligibilitySaveBtn");
    }

    public static class AboutPageLocators {
        public By aboutHeader = By.cssSelector("h1.bf-body-side-menu-title");
        public By aboutTextField = By.cssSelector("textarea.form-control");
        public By aboutSaveBtn = By.cssSelector("div.bf-flex-layout * button.bf-button");
    }

    public static class AvailabilityPageLocators {
        public By morningCheckbox = By.id("editAvailability0Chk");
        public By afternoonCheckbox = By.id("editAvailability1Chk");
        public By eveningCheckbox = By.id("editAvailability2Chk");
        public By nightsCheckbox = By.id("editAvailability3Chk");
        public By saveBtn = By.id("editAvailabilitySaveBtn");
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
    }

    public static class HourlyConnectionLocators {
        public By connectionBackBtn = By.id("connectionsBackBtn");
        public By connectionsTitle = By.id("");
        public By connectionCardImg0 = By.id("");
        public By connectionCardNameTxt0 = By.id("");
        public By connectionCardWorkTxt0 = By.id("");
        public By connectionCardLocationTxt0 = By.id("");
        public By connectionCardViewBtn = By.id("");
        public By connectionPage1Btn = By.id("");
        public By connectionPage2Btn = By.id("");
        public By connectionPage3Btn = By.id("");
        public By connectionPage4Btn = By.id("");
        public By connectionNextPageBtn = By.id("");
        public By connectionPreviousPageBtn = By.id("");
    }

    public static class HourlySuggestedConnectionLocators {
        public By suggestedConnectionBackBtn = By.id("suggestedConnectionsBackBtn");
        public By suggestedConnectionsTitle = By.id("");
        public By suggestedConnectionCardImg0 = By.id("");
        public By suggestedConnectionCardNameTxt0 = By.id("");
        public By suggestedConnectionCardWorkTxt0 = By.id("");
        public By suggestedConnectionCardLocationTxt0 = By.id("");
        public By suggestedConnectionCardViewBtn = By.id("");
        public By suggestedConnectionPage1Btn = By.id("suggestedConnectionsPage1Btn");
        public By suggestedConnectionPage2Btn = By.id("suggestedConnectionsPage2Btn");
        public By suggestedConnectionPage3Btn = By.id("suggestedConnectionsPage3Btn");
        public By suggestedConnectionPage4Btn = By.id("suggestedConnectionsPage4Btn");
        public By suggestedConnectionNextPageBtn = By.id("suggestedConnectionsNextBtn");
        public By suggestedConnectionPreviousPageBtn = By.id("suggestedConnectionsPreviousBtn");
    }

    public static class HourlyMessagePageLocators {
        public By messageListSenderNameTxt0 = By.id("messageListItemSenderNameText0");
        public By messageListSenderImg0 = By.id("messageListItemSenderImg0");
        public By messageListSenderPositionTxt0 = By.id("messageListItemSenderPositionText0");
        public By messageListDateTxt0 = By.id("messageListItemSentDate0");
        public By messageListDeleteBtn0 = By.id("messageListItemDeleteBtn0");
        public By messageListYearDividerTxt = By.id("messageListItemYearDivider0");
        public By messageThreadSenderImg0 = By.id("senderMessageImg0");
        public By messageThreadSenderTxt0 = By.id("senderMessageText0");
        public By messageThreadSenderTimeTxt0 = By.id("senderMessageSentTimeText0");
        public By messageThreadRecipientImg0 = By.id("recipientMessageImg0");
        public By messageThreadRecipientTxt0 = By.id("recipientMessageText0");
        public By messageThreadRecipientTimeTxt0 = By.id("recipientMessageSentTimeText0");
        public By messageThreadYearDividerTxt0 = By.id("senderMessageDividerText0");
        public By messageThreadTextField = By.id("chatMessageTextArea");
        public By messageThreadSendBtn = By.id("chatMessageSendBtn");
    }
}