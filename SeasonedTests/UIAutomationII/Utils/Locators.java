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

        public By loader = By.cssSelector("div.bf-loader");
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

    public static class JobSearchPageLocators {
        /*Search Fields*/
        public By searchJobEmployerField = By.id("searchTermTextField");
        public By searchLocationField = By.id("searchLocationTextField");
        public By searchBtn = By.id("searchButton");

        /* Search Results */
        public By searchResultPaginationTxt = By.id("searchShowResults");
        public By searchResultEmployerImg0 = By.id("searchResultEmployerPhoto0");
        public By searchResultPositionTxt0 = By.id("searchResultJobNameText0");
        public By searchResultEmployerNameTxt0 = By.id("searchResultEmployerNameText0");
        public By searchResultEmployerDistanceTxt0 = By.id("searchResultEmployerDistanceText0");
        public By searchResultEmployerZipTxt0 = By.id("searchResultEmployerZipText0");
        public By searchResultViewBtn0 = By.id("searchResultViewBtn0");
        public By searchResultApplyBtn0 = By.id("searchResultLoggedInApplyBtn0");
        public By searchResultApplyLoadingBtn0 = By.cssSelector("button#searchResultLoggedInApplyBtn0.loading");
        public By searchResultAppliedBtn0 = By.id("searchResultAppliedBtn0");
        public By searchResultsPage1Btn = By.id("searchPage1");
        public By searchResultsPage2Btn = By.id("searchPage2");
        public By searchResultsNextPageBtn = By.id("searchPaginationArrowNext");
        public By searchResultsPreviousPageBtn = By.id("searchPaginationArrowPrev");

        /* Empty Search Results */
        public By searchResultsEmptyTitleTxt = By.cssSelector("div.bf-search-empty-result-content>h2");
        public By searchResultsEmptyMessageTxt = By.cssSelector("div.bf-search-empty-result-content>p");
        public By searchResultsEmptySuggestionsTitleTxt = By.cssSelector("div.bf-search-empty-result-content:nth-of-type(3)>p");
        public By searchResultsEmptySuggestionBartenderBtn = By.cssSelector("div.bf-search-empty-result-content:nth-of-type(3)>div.buttons-wrapper>div:nth-of-type(1)>a");
        public By searchResultsEmptySuggestionCashierBtn = By.cssSelector("div.bf-search-empty-result-content:nth-of-type(3)>div.buttons-wrapper>div:nth-of-type(2)>a");
        public By searchResultsEmptySuggestionCookBtn = By.cssSelector("div.bf-search-empty-result-content:nth-of-type(3)>div.buttons-wrapper>div:nth-of-type(3)>a");
        public By searchResultsEmptySuggestionServerBtn = By.cssSelector("div.bf-search-empty-result-content:nth-of-type(3)>div.buttons-wrapper>div:nth-of-type(4)>a");
        public By searchResultsEmptySuggestionTeamMemberBtn = By.cssSelector("div.bf-search-empty-result-content:nth-of-type(3)>div.buttons-wrapper>div:nth-of-type(5)>a");

        /* Job Details - Auth'd */
        public By jobDetailsBackBtn = By.id("job-details-back-button");
        public By jobDetailsPosition = By.id("jobDetailsHeaderNameText");
        public By jobDetailsWage = By.id("jobDetailsHeaderWageText");
        public By jobDetailsApplyBtn = By.id("jobDetailsLoggedInHeaderApplyBtn");
        public By jobDetailsAppliedBtn = By.id("jobDetailsAppliedBtn");
        public By jobDetailsJobDescriptionTitleTxt = By.cssSelector("div.bf-bf-job-details-content>h3:nth-of-type(1)");
        public By jobDetailsJobDescriptionTxt = By.id("jobDetailsDescriptionText");
        public By jobDetailsEmployerDescriptionTtitleTxt = By.cssSelector("div.bf-job-details-content>h3:nth-of-type(2)");
        public By jobDetailsEmployerDescriptionTxt = By.id("jobDetailsEmployerAboutText");
        public By jobDetailsEmployerLogoImg = By.id("employerCardPhoto");
        public By jobDetailsEmployerNameTxt = By.id("employerCardNameText");
        public By jobDetailsEmployerAddressTxt = By.id("employerCardAddressText");
        public By jobDetailsEmployerPPATxt = By.cssSelector("ul.bf-employer-info-list>li:nth-of-type(1)");
        public By jobDetailsEmployerTypeTxt = By.cssSelector("ul.bf-employer-info-list>li:nth-of-type(2)");
        public By jobDetailsEmployerDistanceTxt = By.id("employerCardDistanceText");
        public By jobDetailsEmployerFollowBtn = By.id("employerCardFollowBtn");
    }

    public static class ProfilePageLocators {
        /* Personal Info Section */
        public By personInfoUserPhotoImg = By.id("personalInfoCardProfileImg");
        public By personalInfoUserFirstAndLastNameTxt = By.id("personalInfoCardUsernameText");
        public By personalInfoUserPrimaryJobTxt = By.id("personalInfoCardPrimaryWorkHistoryText");
        public By personalInfoUserLocationTxt = By.id("personalInfoCardLocationText");
        public By personalInfoEditBtn = By.id("personalInfoCardEditBtn");

        /* Work History Section */
        public By workHistoryEmptyCardHeader = By.id("workHistoryCardEmptyTitleText");
        public By workHistoryCardHeader = By.id("workHistoryCardTitleText");
        public By workHistoryAddBtn = By.id("workHistoryCardEmptyAddBtn");
        public By workHistoryEditBtn = By.id("workHistoryCardEditBtn");
        public By workHistoryEmployerImg0 = By.id("workHistoryCardListItemImg0");
        public By workHistoryJobPosition0 = By.id("workHistoryCardListItem0JobNameText0");
        public By workHistoryEmployerName0 = By.id("workHistoryCardListItemTitleText0");
        public By workHistoryEmployerLocation0 = By.id("workHistoryCardListItemEmployerLocationText0");
        public By workHistoryEmployerTimePeriod0 = By.id("workHistoryCardListItemWorkPeriodText0");
        public By workHistoryEmployerImg1 = By.id("workHistoryCardListItemImg1");
        public By workHistoryJobPosition1 = By.id("workHistoryCardListItem1JobNameText0");
        public By workHistoryEmployerName1 = By.id("workHistoryCardListItemTitleText1");
        public By workHistoryEmployerLocation1 = By.id("workHistoryCardListItemEmployerLocationText1");
        public By workHistoryEmployerTimePeriod1 = By.id("workHistoryCardListItemWorkPeriodText1");
        public By workHistoryEmptyCardTxt = By.id("workHistoryCardEmptyDescriptionText");

        /**
         * Locates an employer logo on the profile page by index
         * @param index The index (Starting at 0) of the employer you wish to locate
         * @return A locator for the employer logo at the given index
         */
        public By findWorkHistoryEmployerLogoByIndex(String index) {
            return By.id("workHistoryCardListItemImg" + index);
        }

        /**
         * Locates a job position on the profile page by index for the employer and job name
         * @param employerIndex The index (Starting at 0) of the employer you wish to locate
         * @param jobIndex The index (Starting at 0) of the job name you wish to locate
         * @return A locator for the job position at the given indexes
         */
        public By findWorkHistoryJobPositionByIndex(String employerIndex, String jobIndex) {
            return By.id("workHistoryCardListItem" + employerIndex + "JobNameText" + jobIndex);
        }

        /**
         * Locates an employer name on the profile page by index
         * @param index The index (Starting at 0) of the employer you wish to locate
         * @return A locator for the employer name at the given index
         */
        public By findWorkHistoryEmployerNameByIndex(String index) {
            return By.id("workHistoryCardListItemTitleText" + index);
        }

        /**
         * Locates an employer's location on the profile page by index
         * @param index The index (Starting at 0) of the employer you wish to locate
         * @return A locator for the employer's location at the given index
         */
        public By findWorkHistoryEmployerLocationByIndex(String index) {
            return By.id("workHistoryCardListItemEmployerLocationText" + index);
        }

        /**
         * Locates the time period the user worked at the employer by index
         * @param index The index (Starting at 0) of the employer you wish to locate
         * @return A locator for the time period the user work at the employer by index
         */
        public By findWorkHistoryEmployerTimePeriodByIndex(String index) {
            return By.id("workHistoryCardListItemWorkPeriodText" + index);
        }

        /* Certifications Section */
        public By certsEmptyHeader = By.id("certificationsCardEmptyTitleText");
        public By certsHeader = By.id("certificationsCardTitleText");
        public By certsAddButton = By.id("certificationsCardEmptyAddBtn");
        public By certsEditButton = By.id("certificationsCardEditBtn");
        public By certsAlcoholImg = By.id("certificationsCardListItemAlcoholSeller/ServerImg");
        public By certsAlcoholTxt = By.id("certificationsCardListItemAlcoholSeller/ServerText");
        public By certsFoodHandlerImg = By.id("certificationsCardListItemFoodHandlerImg");
        public By certsFoodHandlerTxt = By.id("certificationsCardListItemFoodHandlerText");
        public By certsFoodProtectionImg = By.id("certificationsCardListItemFoodProtectionManagerImg");
        public By certsFoodProtectionTxt = By.id("certificationsCardListItemFoodProtectionManagerText");
        public By certsHACCPImg = By.id("certificationsCardListItemHACCPImg");
        public By certsHACCPTxt = By.id("certificationsCardListItemHACCPText");
        public By certsEmptyCardTxt = By.id("certificationsCardEmptyDescriptionText");

        /* Skills Section */
        public By skillsHeader = By.cssSelector("div.bf-col>div:nth-of-type(3)>div>h3");
        public By addSkillsBtn = By.id("skillsCardEmptyAddBtn");
        public By editSkillsBtn = By.id("skillsCardEditBtn");
        public By skillsBakerTxt = By.id("skillsCardListItemBaker");
        public By skillsBarBackTxt = By.id("skillsCardListItemBar-back");
        public By skillsBaristaTxt = By.id("skillsCardListItemBarista");
        public By skillsBartenderTxt = By.id("skillsCardListItemBartender");
        public By skillsBusserTxt = By.id("skillsCardListItemBusser");
        public By skillsCashierTxt = By.id("skillsCardListItemCashier");
        public By skillsChefTxt = By.id("skillsCardListItemChef");
        public By skillsCookTxt = By.id("skillsCardListItemCook");
        public By skillsCrewTxt = By.id("skillsCardListItemCrew");
        public By skillsDishwasherTxt = By.id("skillsCardListItemDishwasher");
        public By skillsDriveThruTxt = By.id("skillsCardListItemDrive-Thru");
        public By skillsDriverTxt = By.id("skillsCardListItemDriver");
        public By skillsHostTxt = By.id("skillsCardListItemHost");
        public By skillsManagerTxt = By.id("skillsCardListItemManager");
        public By skillsPrepCookTxt = By.id("skillsCardListItemPrepCook");
        public By skillsRunnerTxt = By.id("skillsCardListItemRunner");
        public By skillsServerTxt = By.id("skillsCardListItemServer");
        public By skillsSommelierTxt = By.id("skillsCardListItemSommelier");
        public By skillsSousChefTxt = By.id("skillsCardListItemSousChef");
        public By skillsTeamMemberTxt = By.id("skillsCardListItemTeamMember");
        public By skillsTrainerTxt = By.id("skillsCardListItemTrainer");
        public By emptySkillsTxt = By.id("skillsCardEmptyDescriptionText");

        /* About Section */
        public By addAboutBtn = By.id("aboutCardEmptyAddBtn");
        public By editAboutBtn = By.id("aboutCardEditBtn");
        public By aboutHeader = By.id("aboutCardTitleText");
        public By aboutTxtField = By.id("aboutCardAboutText");
        public By emptyAboutTxtField = By.id("aboutCardEmptyDescriptionText");

        /* Basic Info Section */
        public By addBasicInfoBtn = By.id("basicInfoCardEmptyAddBtn");
        public By editBasicInfoBtn = By.id("basicInfoCardEditBtn");
        public By basicInfoAgeTxt = By.id("basicInfoCardListItemAgeText");
        public By basicInfoAgeYesBtn = By.id("basicInfoCardListItemAgeYesImg");
        public By basicInfoAgeNoBtn = By.id("basicInfoCardListItemAgeNoImg");
        public By basicInfoTransportTxt = By.id("basicInfoCardListItemTransportText");
        public By basicInfoTransportYesBtn = By.id("basicInfoCardListItemTransportYesImg");
        public By basicInfoTransportNoBtn = By.id("basicInfoCardListItemTransportNoImg");
        public By basicInfoLegalTxt = By.id("basicInfoCardListItemLegalText");
        public By basicInfoLegalYesBtn = By.id("basicInfoCardListItemLegalYesImg");
        public By basicInfoLegalNoBtn = By.id("basicInfoCardListItemLegalNoImg");

        /* Availability Section */
        public By addAvailabilityBtn = By.id("availabilityCardEmptyAddBtn");
        public By editAvailabilityBtn = By.id("availabilityCardEditBtn");
        public By availabilityMorningsSelectedImg = By.id("availabilityCardListItemMorningsImg");
        public By availabilityAfternoonsSelectedImg = By.id("availabilityCardListItemAfternoonsImg");
        public By availabilityEveningsSelectedImg = By.id("availabilityCardListItemEveningsImg");
        public By availabilityNightsSelectedImg = By.id("availabilityCardListItemNightsImg");

        /* Shared profile page locators */
        public By successToastDiv = By.cssSelector("div#bodySideMenuToast.success");
        public By failToastDiv = By.cssSelector("div#bodySideMenuToast.error");
        public By profileBackBtn = By.id("editProfileBackBtn");
    }

    public static class PersonalInfoPageLocators {
        public By personalInfoTitleTxt = By.id("editProfilePersonalInfoTitleText");
        public By personalInfoUserPhotoImg = By.id("personalInfoProfilePhoto");
        public By personalInfoUploadUserPhotoBtn = By.id("personalInfoUploadPhotoBtn");
        public By personalInfoUploadUserPhotoFromFacebookBtn = By.id("uploadFacebookPhotoBtn");
        public By personalInfoFirstLastNameTxtField = By.id("personalInfoUsernameInput");
        public By personalInfoLocationTxtField = By.id("personalInfoLocationInput");
        public By personalInfoPhoneTxtField = By.id("personalInfoPhoneNumberInput");
        public By personalInfoSaveBtn = By.cssSelector("div.bf-flex-layout:nth-of-type(5) * button.bf-button");
    }

    public static class WorkHistoryPageLocators {
        public By employerLocationTxtField = By.id("addWorkHistoryLocationInput");
        public By iDontSeeMyStoreLink = By.id("addWorkHistoryToggleSearchBtn");
        public By jobPositionSelect = By.id("addWorkHistoryJobTypesSelectBox");
        public By fromMonthDateSelect = By.id("addWorkHistoryStartMonthSelectBox");
        public By fromYearDateSelect = By.id("addWorkHistoryStartYearSelectBox");
        public By toMonthDateSelect = By.id("editWorkHistoryEndMonthSelectBox");
        public By toYearDateSelect = By.id("editWorkHistoryEndYearSelectBox");
        public By customEmployerNameTxtField = By.id("addWorkHistoryCustomNameInput");
        public By customEmployerLocationTxtField = By.id("addWorkHistoryCustomLocationInput");
        public By searchForStoreLink = By.id("addWorkHistoryToggleSearchBtn");
        public By firstJobChk = By.id("addWorkHistoryFirstJobChk");
        public By yesDeleteBtn = By.cssSelector(".bf-button.filled.bold");
        public By cancelDeleteBtn = By.cssSelector(".bf-button.bold.bf-mrg-r");
        public By addWorkHistorySaveBtn = By.id("addWorkHistorySaveBtn");
        public By editWorkHistorySaveBtn = By.id("editWorkHistorySaveBtn");
        public By editWorkHistoryCancelBtn = By.id("editWorkHistoryCancelBtn");
        public By editWorkHistoryDeleteBtn = By.id("editWorkHistoryDeleteBtn");
        public By googlePlacesMyStoreBtns = By.cssSelector(".bf-button.primary");

        /**
         * Locates a edit work history button for a given index
         * @param index index The index (Starting at 0) of the employer you wish to locate
         * @return Returns a locator for the edit work history button by index
         */
        public By findEditWorkHistoryItemByIndex(String index) {
            return By.id("editWorkHistoryListItemEditBtn" + index);
        }
    }

    public static class CertificationsPageLocators {
        public By editCertsHeader = By.id("editProfileCertificationsTitleText");
        public By editCertsHeaderMsg = By.id("editProfileCertificationsSubTitleText");
        public By alcoholSellerImg = By.id("editCertificationsListItemAlcoholSeller/ServerImg");
        public By alcoholSellerTxt = By.id("editCertificationsListItemAlcoholSeller/ServerLabelText");
        public By alcoholSellerChk = By.id("editCertificationsListItemAlcoholSeller/ServerChk");
        public By alcoholSellerUploadBtn = By.id("editCertificationsListItemAlcoholSeller/ServerUploadBtn0");
        public By foodHandlerImg = By.id("editCertificationsListItemFoodHandlerImg");
        public By foodHandlerTxt = By.id("editCertificationsListItemFoodHandlerLabelText");
        public By foodHandlerChk = By.id("editCertificationsListItemFoodHandlerChk");
        public By foodHandlerUploadBtn = By.id("editCertificationsListItemFoodHandlerUploadBtn1");
        public By foodProtectionImg = By.id("editCertificationsListItemFoodProtectionManagerImg");
        public By foodProtectionTxt = By.id("editCertificationsListItemFoodProtectionManagerLabelText");
        public By foodProtectionChk = By.id("editCertificationsListItemFoodProtectionManagerChk");
        public By foodProtectionUploadBtn = By.id("editCertificationsListItemFoodProtectionManagerUploadBtn2");
        public By haccpImg = By.id("editCertificationsListItemHACCPImg");
        public By haccpTxt = By.id("editCertificationsListItemHACCPLabelText");
        public By haccpChk = By.id("editCertificationsListItemHACCPChk");
        public By haccpUploadBtn = By.id("editCertificationsListItemHACCPUploadBtn3");
        public By saveBtn = By.id("saveCertificationsBtn");
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

    public static class AboutPageLocators {
        public By aboutHeader =  By.id("editProfileAboutTitleText");
        public By aboutTextField =  By.id("editAboutTextArea");
        public By aboutSaveBtn =  By.id("editAboutSaveBtn");
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

    public static class AvailabilityPageLocators {
        public By morningCheckbox = By.id("editAvailabilityMorningsChk");
        public By afternoonCheckbox = By.id("editAvailabilityAfternoonsChk");
        public By eveningCheckbox = By.id("editAvailabilityEveningsChk");
        public By nightsCheckbox = By.id("editAvailabilityNightsChk");
        public By saveBtn = By.id("editAvailabilitySaveBtn");
        public By successToastDiv = By.id("bodySideMenuToast");
    }

    public static class HourlyConnectionLocators {
        public By connectionBackBtn = By.id("connectionsBackBtn");
        public By connectionsTitle = By.id("connectionsTitleText");
        public By connectionCardImg0 = By.id("connectionImg0");
        public By connectionCardNameTxt0 = By.id("connectionNameText0");
        public By connectionCardWorkTxt0 = By.id("connectionPrimaryWorkText0");
        public By connectionCardLocationTxt0 = By.id("connectionLocationText0");
        public By connectionCardViewBtn = By.id("connectionViewBtn0");
        public By connectionPage1Btn = By.id("connectionsPage1Btn");
        public By connectionPage2Btn = By.id("connectionsPage2Btn");
        public By connectionPage3Btn = By.id("connectionsPage3Btn");
        public By connectionPage4Btn = By.id("connectionsPage4Btn");
        public By connectionNextPageBtn = By.id("connectionsNextBtn");
        public By connectionPreviousPageBtn = By.id("connectionsPreviousBtn");
    }

        public static class HourlySuggestedConnectionLocators {
            public By suggestedConnectionBackBtn = By.id("suggestedConnectionsBackBtn");
            public By suggestedConnectionsTitle = By.id("suggestedConnectionsTitleText");
            public By suggestedConnectionCardImg0 = By.id("suggestedConnectionImg0");
            public By suggestedConnectionCardNameTxt0 = By.id("suggestedConnectionNameText0");
            public By suggestedConnectionCardReasonTxt0 = By.id("suggestedConnectionConnectionReasonText0");
            public By suggestedConnectionCardViewBtn0 = By.id("suggestedConnectionViewBtn0");
            public By suggestedConnectionCardConnectBtn0 = By.id("suggestedConnectionConnectBtn0");
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
            public By successToastDiv = By.id("bodySideMenuToast");
        }
    }