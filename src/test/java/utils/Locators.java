package utils;

import org.openqa.selenium.By;

public class Locators {

    public static class NavPageLocators {
        /* Common Nav Header Locators */
        public By largeBrushfireLogo = By.id("headerBigLogoImg");
        public By myHomeBtn = By.id("headerDashboardLink");
        public By findJobsBtn = By.id("headerFindJobsLink");
        public By careerBtn = By.id("headerCareerPathLink");
        public By networkBtn = By.id("headerGetConnectedLink");
        public By searchBtn = By.id("headerSearchButton");
        public By jobSearchTxtField = By.id("headerSearchInput");

        /* Non Auth Nav Header Locators */
        public By loginBtn = By.id("headerLoginLink");
        public By signUpBtn = By.id("headerJoinBtn");

        /* Auth'd Nav Header Locators - Hourly */
        public By contentFeedBtn = By.id("headerFeedLink");
        public By messagesBtn = By.id("headerMessagesLink");
        public By userNameBtn = By.id("headerMenuToggleBtn");
        public By userNameTxt = By.id("headerUsernameTxt");
        public By userPhotoImg = By.id("headerProfilePictureImg");
        public By userAvatarImg = By.id("headerProfilePictureImgIcon");

        /* Auth'd Nav Header Locators - Manager */
        public By dashBtn = By.id("headerHiringDashboardLink");
        public By talentBtn = By.id("headerFindTalentLink");

        public By menuProfileBtn = By.id("headerMenuProfileLink");
        public By menuStoreProfileBtn = By.id("headerMenuStoreProfileLink");
        public By menuSettingsBtn = By.id("headerMenuSettingsLink");
        public By menuManagerBtn = By.id("headerMenuSwitchToLink");
        public By menuMemberBtn = By.id("headerMenuSwitchViewsLink");
        public By menuLogoutBtn = By.id("headerMenuLogOutLink");

        /* Nav utility methods */
        public By rebrandingModalBtn = By.id("rebrandAnnouncementSubmitBtn");
    }

    public static class LoginPageLocators {
        /* Login With Email */
        public By loginHeaderTxt = By.id("loginTitle");
        public By emailTxtField = By.id("loginEmailInput");
        public By passwordTxtField = By.id("loginPasswordInput");
        public By forgotPasswordLink = By.id("loginForgotPasswordLink");
        public By loginBtn = By.id("loginBtn");
        public By joinBtn = By.id("loginJoinNowLink");

        /* Login With Facebook */
        public By loginFacebookBtn = By.id("loginFacebookBtn");

        /* Facebook.com Locators */
        public By faceBookEmailField = By.id("email");
        public By faceBookPasswordField = By.id("pass");
        public By facebookLoginBtn = By.id("loginbutton");
    }

    public static class SignUpPageLocators {
        /* Shared onboarding elements */
        public By dismissBtn = By.id("overlayPageCloseBtn");

        /* Customize Experience */
        public By logoImg = By.id("customizeExperienceLogoImg");
        public By jobsBtn = By.id("lookingForJobButton");
        public By careerBtn = By.id("growCareerButton");
        public By networkBtn = By.id("buildNetworkButton");
        public By managerBtn = By.id("hireTalentButton");

        /* Location */
        public By locationTitleTxt = By.id("locationTitle");
        public By locationField = By.id("locationSelectInput");
        public By locationSuggestionsTitle = By.id("locationSelectDropdownLabel");

        /**
         * Locates a location suggestion by index
         *
         * @param index The index (Starting at 0) of the location you wish to locate
         * @return A locator for the location suggestion at the given index
         */
        public By locationSuggestionBtn(String index) {
            return By.id("locationSelectOption" + index);
        }

        public By locationBackBtn = By.id("locationBackBtn");
        public By locationNextBtn = By.id("locationNextBtn");

        /* Jobs */
        public By jobsField = By.id("jobsSelectInput");
        public By allJobsBtn = By.id("jobsSelectConnection0");
        public By popularJobsBtn = By.id("jobsSelectConnection1");
        public By selectedJobsBtn = By.id("jobsSelectConnection2");

        /**
         * Locates a job type selection by index
         *
         * @param index The index (Starting at 0) of the job type you wish to locate
         * @return A locator for a job type selection at the given index
         */
        public By jobsPositionSelection(String index) {
            return By.id("jobsSelectValue" + index);
        }

        public By jobsBackBtn = By.id("jobsBackBtn");
        public By jobsNextBtn = By.id("jobsNextBtn");

        /**
         * Locates a job type checkbox by index
         *
         * @param index The index (Starting at 0) of the job type you wish to locate
         * @return A locator for a job type checkbox at the given index
         */
        public By jobsPositionCheckbox(String index) {
            return By.id("jobTypeChk" + index);
        }

        /* Topics */

        /**
         * Locates a preferred topic checkbox by index
         *
         * @param index The index (Starting at 0) of the job type you wish to locate
         * @return A locator for a job type checkbox at the given index
         */
        public By topicsCheckbox(String index) {
            return By.id("preferredTopicsChk" + index);
        }

        public By topicsBackBtn = By.id("topicsBackBtn");
        public By topicsNextBtn = By.id("topicsNextBtn");

        /* Sign Up */
        public By emailSignUpBtn = By.id("chooseSignUpEmailSignUpBtn");
        public By facebookSignUpBtn = By.id("signUpFacebookBtn");
        public By termsText = By.id("chooseSignUpTermsOfServiceText");
        public By termsBtn = By.id("chooseSignUpTermsOfServiceLink");
        public By signupBackBtn = By.id("chooseSignUpBackBtn");

        /* Sign Up With Email*/
        public By firstNameField = By.id("EmailSignUpUserFirstname");
        public By lastNameField = By.id("EmailSignUpUserLastname");
        public By emailField = By.id("EmailSignUpEmailInput");
        public By passwordField = By.id("EmailSignUpPasswordInput");
        public By emailSignupBackBtn = By.id("EmailSignUpBackBtn");
        public By emailSignupNextBtn = By.id("EmailSignUpNextBtn");
        public By emailSignUpNextLoadingBtn = By.cssSelector("button#EmailSignUpNextBtn.loading");

        /* Facebook.com Locators */
        public By faceBookEmailField = By.id("email");
        public By faceBookPasswordField = By.id("pass");
        public By facebookLoginBtn = By.id("loginbutton");
    }

    public static class ContentPageLocators {

        public By myHomeHeaderTxt = By.id("myHomeHeaderTxt");

        /**
         * Locates an article image for a given index
         *
         * @param index The index (Starting at 0) of the article image you wish to locate
         * @return Returns a locator for an article's image by index
         */
        public By articleImgByIndex(String index) {
            return By.id("myHomeCardImg" + index);
        }

        /**
         * Locates an article title for a given index
         *
         * @param index The index (Starting at 0) of the article title you wish to locate
         * @return Returns a locator for an article's title by index
         */
        public By artcleTitleTxtByIndex(String index) {
            return By.id("myHomeCardTitleTxt" + index);
        }

        /**
         * Locates an article site name for a given index
         *
         * @param index The index (Starting at 0) of the article site name you wish to locate
         * @return Returns a locator for an article's site name by index
         */
        public By articleSiteTxtByIndex(String index) {
            return By.id("myHomeCardSiteNameTxt" + index);
        }

        /**
         * Locates an article publisher image for a given index
         *
         * @param index The index (Starting at 0) of the article publisher image you wish to locate
         * @return Returns a locator for an article's publisher image by index
         */
        public By articlePublisherImgByIndex(String index) {
            return By.id("myHomeCardAuthorImg" + index);
        }

        /**
         * Locates an article publisher name for a given index
         *
         * @param index The index (Starting at 0) of the article publisher name you wish to locate
         * @return Returns a locator for an article's publisher name by index
         */
        public By articlePublisherNameTxtByIndex(String index) {
            return By.id("myHomeCardAuthorNameTxt" + index);
        }

        /**
         * Locates an article publisher date for a given index
         *
         * @param index The index (Starting at 0) of the article publisher date you wish to locate
         * @return Returns a locator for an article's publisher date by index
         */
        public By articlePublishedDateTxtByIndex(String index) {
            return By.id("myHomeCardPostedTimeAgoTxt" + index);
        }

        /**
         * Locates an article like button for a given index
         *
         * @param index The index (Starting at 0) of the article like button you wish to locate
         * @return Returns a locator for an article's like button by index
         */
        public By articleLikeBtnByIndex(String index) {
            return By.id("myHomeCardLikeBtn" + index);
        }

        public By articleLikeBtnLiked(String index){
            return By.cssSelector("#myHomeCardLikeBtn" + index + ".liked");
        }
        /**
         * Locates an article like count for a given index
         *
         * @param index The index (Starting at 0) of the article like count you wish to locate
         * @return Returns a locator for an article's like count by index
         */
        public By articleLikeCountTxtByIndex(String index) {
            return By.id("myHomeCardLikeCountTxt" + index);
        }

        public By trendingTitle = By.id("trendingArticlesPreviewCardTitle");

        /**
         * Locates a trending article image for a given index
         *
         * @param index The index (Starting at 0) of the trending article image you wish to locate
         * @return Returns a locator for a trending article's image by index
         */
        public By trendingArticleImgByIndex(String index) {
            return By.id("trendingArticlesPreviewItemImage" + index);
        }

        /**
         * Locates a trending article title for a given index
         *
         * @param index The index (Starting at 0) of the trending article title you wish to locate
         * @return Returns a locator for a trending article's title by index
         */
        public By trendingArticleTitleTxtByIndex(String index) {
            return By.id("trendingArticlesPreviewItemTitle" + index);
        }

        /**
         * Locates a trending article site name for a given index
         *
         * @param index The index (Starting at 0) of the trending article site name you wish to locate
         * @return Returns a locator for a trending article's site name by index
         */
        public By trendingArticleSiteTxtByIndex(String index) {
            return By.id("trendingArticlesPreviewItemSiteName" + index);
        }

        /* Auth'd Content Locators */
        public By viewedArticleTitle = By.id("recentlyViewedArticlesPreviewCardTitle");

        /**
         * Locates a viewed article image for a given index
         *
         * @param index The index (Starting at 0) of the viewed article image you wish to locate
         * @return Returns a locator for a viewed article's image by index
         */
        public By viewedArticleImgByIndex(String index) {
            return By.id("recentlyViewedArticlesPreviewItemImage" + index);
        }

        /**
         * Locates a viewed article title for a given index
         *
         * @param index The index (Starting at 0) of the viewed article title you wish to locate
         * @return Returns a locator for a viewed article's title by index
         */
        public By viewedArticleTitleTxtByIndex(String index) {
            return By.id("recentlyViewedArticlesPreviewItemTitle" + index);
        }

        /**
         * Locates a viewed article site name for a given index
         *
         * @param index The index (Starting at 0) of the viewed article site name you wish to locate
         * @return Returns a locator for a viewed article's site name by index
         */
        public By viewedArticleSiteTxtByIndex(String index) {
            return By.id("recentlyViewedArticlesPreviewItemSiteName" + index);
        }

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
        public By articleLoadingIndicator = By.cssSelector("button#myHomeLoadMore>div.button-content.loading");
    }

    public static class JobSearchPageLocators {

        public By searchPositionDropdown = By.id("jobSearchLocationInput");
        public By searchPositionDropdownLbl = By.id("jobSearchLocationInput");

        /**
         * Locates a job search position in the dropdown for a given index
         *
         * @param index The index (Starting at 0) of the job search position in the dropdown you wish to locate
         * @return Returns a locator for a job search position in the dropdown by index
         */
        public By findJobSearchPositionByIndex(String index) {
            return By.id("searchJobTypeDropDownOption" + index);
        }

        public By searchLocationField = By.id("jobSearchLocationInput");

        /* Search Results */

        /**
         * Locates a job search result employer logo for a given index
         *
         * @param index The index (Starting at 0) of the job search result employer logo you wish to locate
         * @return Returns a locator for a job search result employer logo by index
         */
        public By findSearchResultEmployerImgByIndex(String index) {
            return By.id("articleImg" + index + "ContainerImg");
        }

        /**
         * Locates a job search result position for a given index
         *
         * @param index The index (Starting at 0) of the job search result position you wish to locate
         * @return Returns a locator for a job search result position by index
         */
        public By findSearchResultPositionTxtByIndex(String index) {
            return By.id("jobCardJobNameText" + index);
        }

        /**
         * Locates a job search result employer name for a given index
         *
         * @param index The index (Starting at 0) of the job search result employer name you wish to locate
         * @return Returns a locator for a job search result employer name by index
         */
        public By findSearchResultEmployerNameTxtByIndex(String index) {
            return By.id("jobCardEmployerNameText" + index);
        }

        /**
         * Locates a job search result location for a given index
         *
         * @param index The index (Starting at 0) of the job search result location you wish to locate
         * @return Returns a locator for a job search result location by index
         */
        public By findSearchResultEmployerLocationTxtByIndex(String index) {
            return By.id("jobCardEmployerNameAndLocationText" + index);
        }

        /**
         * Locates a job search result view button for a given index
         *
         * @param index The index (Starting at 0) of the job search result view button you wish to locate
         * @return Returns a locator for a job search result view button by index
         */
        public By findSearchResultViewBtnByIndex(String index) {
            return By.id("jobCardViewBtn" + index);
        }

        /**
         * Locates a job search result apply button for a given index
         *
         * @param index The index (Starting at 0) of the job search result apply button you wish to locate
         * @return Returns a locator for a job search result apply button by index
         */
        public By findSearchResultApplyBtnByIndex(String index) {
            return By.id("jobCardApplyBtn" + index);
        }

        public By searchResultsCountTxt = By.id("jobSearchJobCount");
        public By emptySearchTextTitle = By.id("emptySearchTextTitle");
        public By searchResultsEmptyMessageTxt = By.id("emptySearchTextContent");

        /* Job Details - Auth'd */
        public By jobDetailsPositionTxt = By.id("jobDetailsJobNameTxt");
        public By jobDetailsWageTxt = By.id("jobWageTxt");
        public By jobDetailsApplyBtn = By.id("jobDetailsjobApplyBtn");
        public By jobDetailsViewMyProfileBtn = By.id("viewProfiletBtn");
        public By jobDetailsApplySuccessToastTxt = By.id("applyForJobToast");
        public By jobDetailsApplySuccessToastDismissBtn = By.id("applyForJobToastCloseBtn");
        public By jobDetailsJobDescriptionTitleTxt = By.xpath("//div[@id='ExpandableContentWrapper']/section/h2");
        public By jobDetailsJobDescriptionTxt = By.xpath("//div[@id='ExpandableContentWrapper']/section/div/p");
        public By jobDetailsEmployerLogoImg = By.id("jobDetailsStoreLogoImg");
        public By jobDetailsEmployerNameTxt = By.id("jobDetailsAddressTxt");
        public By jobDetailsEmployerDescriptionTitleTxt = By.id("employerDescriptionTitleTxt");
        public By jobDetailsEmployerDescriptionTxt = By.id("employerDescriptionTxt");
        public By jobDetailsEmployerAddressTxt = By.id("jobDetailsAddressText");
        public By jobDetailsEmployerPPATxt = By.id("employerPPATypeTxt");
        public By jobDetailsEmployerTypeTxt = By.id("employerTypeTxt");
        public By jobDetailsEmployerDistanceTxt = By.id("jobDetailsDistanceText");
        public By jobDetailsEmployerFollowBtn = By.xpath("//span[@id='jobDetailsemployerFollowLink'][contains(text(), 'Follow Store')]");
        public By jobDetailsEmployerFollowingBtn = By.xpath("//span[@id='jobDetailsemployerFollowLink'][contains(text(), 'Unfollow Store')]");
        public By jobDetailsEmployerFollowToastTxt = By.id("jobDetailsToast");
        public By jobDetailsEmployerFollowToastDismissBtn = By.id("jobDetailsToastCloseBtn");
    }


    public static class AttributionModal {
        public By attributionModal = By.className("ReactModalPortal");
        public By attributionCloseBtn = By.id("overlayPageCloseBtn");
        public By attributionDropdown = By.id("attributionModalDropDown");
        public By getAttrigutionByIndex(String index){return By.id("attributionModalDropDownOption" + index);}
        public By attributionDoneBtn = By.id("promptBtn");
    }
    public static class ApplicationFlowModal {

        /* Sign Up - Join Using Email button */
        public By joinUsingEmailBtn = By.id("button");

        /* Sign Up - Enter Name,email,password */
        public By firstNameTxt = By.id("joinWithEmailDialogUserFirstname");
        public By firstNameWrapper = By.id("joinWithEmailDialogUserFirstnameWrapper");
        public By lastNameTxt = By.id("joinWithEmailDialogUserLastname");
        public By emailTxt  = By.id("joinWithEmailDialogEmailInput");
        public By passwordTxt = By.id("joinWithEmailDialogPasswordInput");
        public By continueSignUpBtn = By.id("joinWithEmailDialogContinueBtn");

        /* Confirm to continue to add more info modal */
        public By continueToApplicationFlowBtn = By.id("promptBtn");

        /* Experience modal */
        public By restaurantInputDropdown = By.id("addWorkHistoryLocationInput");
        public By jobtitleInputDropdown = By.id("addWorkHistoryJobsSelectBoxMultiSelect");

        /**
         * Get Job Type by Index
         * @param index
         * @return
         */
        public By getJobByIndex(String index){
            return By.id("addWorkHistoryJobsSelectBoxOption" + index);
        }
        public By fromMonthSelectBox = By.id("addWorkHistoryStartMonthSelectBox");
        public By fromYearSelectBox = By.id("addWorkHistoryStartYearSelectBox");
        public By toMonthSelectBox = By.id("addWorkHistoryEndMonthSelectBox");
        public By toYearSelectBox = By.id("addWorkHistoryEndYearSelectBox");
        public By currentWorkToggle = By.id("addWorkHistoryToggleEndDateBtn");
        public By currentworkToggleOff = By.id("addWorkHistoryToggleEndDateBtnOff");
        public By currentworkToggleOn = By.id("addWorkHistoryToggleEndDateBtnOn");
        public By responsabilitiesTxt = By.id("addWorkHistoryDescriptionTxt");
        public By firstJobCheckbox = By.id("addWorkHistoryFirstJobCheckboxBox");
        public By continueExperienceBtn = By.id("addWorkHistorySaveBtn");
        public By cancelExperienceBtn = By.id("overlayPageCloseBtn");

        /* Availability Modal */
        public By anythingCardBtn = By.id("editAvailabilityCardAnything");
        public By fullTimeCardBtn = By.id("editAvailabilityCardFull-Time");
        public By partTimeCardBtn = By.id("editAvailabilityCardPart-Time");
        public By seasonalCardBtn = By.id("editAvailabilityCardSeasonal");

        public By morningsCardBtn = By.id("editAvailabilityCardMornings");
        public By afternoonsCardBtn = By.id("editAvailabilityCardAfternoons");
        public By eveningsCardBtn = By.id("editAvailabilityCardEvenings");
        public By nightsCardBtn = By.id("editAvailabilityCardNights");

        public By continueAvailabilityBtn = By.id("editAvailabilitySaveBtn");
        public By backAvailabilityBtn = By.id("EditAvailablityBackBtn");

        /**
         * Get Skill by Index
         * @param index
         * @return
         */
        public By getSkillsbyIndex(String index){
           return By.id("editProfileSkillLabel" + index);
        }

        public By skillsSubmitBtn = By.id("editProfileSkillSaveBtn");
        public By skillsBackBtn = By.id("editProfileSkillBackBtn");

        public By successDoneBtn = By.id("doneBtn");
        public By successViewProfileBtn = By.id("viewProfiletBtn");

    }
    public static class ProfilePageLocators {
        /* Global profile page locators */
        public By profileEditBtn = By.id("editProfileBtn");

        /* Personal Info Section */
        public By personInfoUserPhotoImg = By.id("profilePhotoImage");
        public By personalInfoUserFirstAndLastNameTxt = By.id("profileNameTxt");
        public By findPrimaryJobTxt = By.id("profileSubtitleTxt");
        public By personalInfoSkillsTxt = By.id("profileTopSkillsTxt");
        public By personalInfoActionsMenuBtn = By.cssSelector("div.actions-menu-toggle");
        public By personalInfoDisconnectBtn = By.id("disconnectLink");

        /* Badges Section */
        public By lockedProfileBadgeImg = By.id("profileBadgeLocked");
        public By lockedConnectionBadgeImg = By.id("connectionBadgeLocked");
        public By unlockedProfileBadgeImg = By.id("profileBadgeUnlocked");
        public By unlockedConnectionBadgeImg = By.id("connectionBadgeUnlocked");

        /* Work History Section */
        public By workHistoryTitleTxt = By.id("workHistoryCardListItemprofileExperienceTitle");
        public By workHistoryEmptyTxt = By.id("workHistoryCardListItemProfileEmptyText");
        public By workHistoryAddBtn = By.id("workHistoryCardListItemeditBtn");
        public By workHistoryEditBtn = By.id("workHistoryCardListItemEditLink");

        /**
         * Locates an employer logo on the profile page by index
         *
         * @param index The index (Starting at 0) of the employer you wish to locate
         * @return A locator for the employer logo at the given index
         */
        public By findWorkHistoryEmployerLogoByIndex(String index) {
            return By.id("workHistoryCardListItemImg" + index);
        }

        /**
         * Locates a job position on the profile page by index for the employer and job name
         *
         * @param listIndex     The index (Starting at 0) of the employer you wish to locate
         * @param positionIndex The index (Starting at 0) of the job name you wish to locate
         * @return A locator for the job position at the given indexes
         */
        public By findWorkHistoryJobPositionByIndex(String listIndex, String positionIndex) {
            return By.id("workHistoryCardListItem" + listIndex + "Position" + positionIndex);
        }

        /**
         * Locates an employer name on the profile page by index
         *
         * @param index The index (Starting at 0) of the employer you wish to locate
         * @return A locator for the employer name at the given index
         */
        public By findWorkHistoryEmployerNameByIndex(String index) {
            return By.id("workHistoryCardListItemTitleText" + index);
        }

        /**
         * Locates the time period the user worked at the employer by index
         *
         * @param index The index (Starting at 0) of the employer you wish to locate
         * @return A locator for the time period the user work at the employer by index
         */
        public By findWorkHistoryEmployerTimePeriodByIndex(String index) {
            return By.id("workHistoryCardListItemWorkPeriodText" + index);
        }

        /**
         * Locates the duration the user worked at the employer by index
         *
         * @param index The index (Starting at 0) of the employer you wish to locate
         * @return A locator for the duration the user worked at the employer by index
         */
        public By findWorkHistoryEmployerDurationByIndex(String index) {
            return By.id("workHistoryCardListItemDurationText" + index);
        }

        /**
         * Locates the work history description by index
         *
         * @param index The index (Starting at 0) of the work history description you wish to locate
         * @return A locator for the work history description by index
         */
        public By findWorkHistoryJobDescriptionByIndex(String index) {
            return By.id("workHistoryCardListItemDescriptionTxt" + index);
        }

        /* Certifications Section */
        public By certsTitleTxt = By.id("profileCertificationsTitleText");
        public By certsEmptyTxt = By.id("profileCertificationsProfileEmptyText");
        public By certsAddBtn = By.id("profileCertificationseditBtn");
        public By certsEditBtn = By.id("profileCertificationsEditLink");
        public By certsAlcoholImg = By.id("profileCertificationAlcoholSeller/ServerCardListItemImg");
        public By certsAlcoholTxt = By.id("certificationsCardListItemAlcoholSeller/ServerText");
        public By certsFoodHandlerImg = By.id("profileCertificationFoodHandlerCardListItemImg");
        public By certsFoodHandlerTxt = By.id("certificationsCardListItemFoodHandlerText");
        public By certsFoodProtectionImg = By.id("profileCertificationFoodProtectionManagerCardListItemImg");
        public By certsFoodProtectionTxt = By.id("certificationsCardListItemFoodProtectionManagerText");
        public By certsHACCPImg = By.id("profileCertificationHACCPCardListItemImg");
        public By certsHACCPTxt = By.id("certificationsCardListItemHACCPText");

        /* Education Section */
        public By educationTitleTxt = By.id("viewProfileEducationTitle");
        public By educationEmptyTxt = By.id("viewProfileEducationProfileEmptyText");
        public By educationAddBtn = By.id("viewProfileEducationeditBtn");
        public By educationEditBtn = By.id("/viewProfileEducationEditLink");

        /**
         * Locates education school for a given index
         *
         * @param index The index (Starting at 0) of the education school you wish to locate
         * @return Returns a locator for the education school by index
         */
        public By findEducationSchoolByIndex(String index) {
            return By.id("viewProfileEducationInstitutionText" + index);
        }

        /**
         * Locates education degree for a given index
         *
         * @param index The index (Starting at 0) of the education degree you wish to locate
         * @return Returns a locator for the education degree by index
         */
        public By findEducationDegreeByIndex(String index) {
            return By.id("viewProfileEducationDegreeText" + index);
        }

        /**
         * Locates education duration for a given index
         *
         * @param index The index (Starting at 0) of the education duration you wish to locate
         * @return Returns a locator for the education duration by index
         */
        public By findEducationDurationByIndex(String index) {
            return By.id("viewProfileEducationStudyingPeriodText" + index);
        }

        /* Skills Section */
        public By skillsTitleTxt = By.id("viewProfileSkillTitle");
        public By skillsEmptyTxt = By.id("viewProfileSkillProfileEmptyText");
        public By skillsAddBtn = By.id("viewProfileSkilleditBtn");
        public By skillsEditBtn = By.id("viewProfileSkillEditLink");

        /**
         * Locates a skill label for a given index
         *
         * @param index The index (Starting at 0) of the skill you wish to locate
         * @return Returns a locator for the skill by index
         */
        public By findSkillLabelByIndex(String index) {
            return By.id("viewProfileSkillLabel" + index);
        }

        /* About Section */
        public By aboutTitleTxt = By.id("profileAboutTitleText");
        public By aboutEmptyTxt = By.id("profileAboutProfileEmptyText");
        public By aboutAddBtn = By.id("profileAbouteditBtn");
        public By aboutTxtField = By.id("profileAboutText");

        /* Availability Section */
        public By availabilityTitleTxt = By.id("profileAvailabilityTitle");
        public By availabilityEmptyTxt = By.id("profileAvailabilityProfileEmptyText");
        public By availabilityAddBtn = By.id("profileAvailabilityeditBtn");
        public By availabilityEditBtn = By.id("profileAvailabilityEditLink");
        public By availabilityMorningsCard = By.id("profileAvailabilityCardMornings");
        public By availabilityAfternoonsCard = By.id("profileAvailabilityCardAfternoons");
        public By availabilityEveningsCard = By.id("profileAvailabilityCardEvenings");
        public By availabilityNightsCard = By.id("profileAvailabilityCardNights");
        public By availabilityInterestStatusTxt = By.id("profileAvailabilityEmploymentInterestStatus");
        public By availabilityInterestTypeTxt = By.id("profileAvailabilityEmploymentInterestType");


        /* Connections Section */
        public By connectionsTitleTxt = By.cssSelector("h5.card-title");
        public By connectionsCountTxt = By.id("profileConnectionMoreConnectionsCountTxt");
        public By viewAllConnectionsBtn = By.id("profileConnectionMoreConnectionsBtn");

        /**
         * Locates a connection's photo for a given index
         *
         * @param index The index (Starting at 0) of the user you wish to locate
         * @return Returns a locator for the connection's image by index
         */
        public By findConnectionImgByIndex(String index) {
            return By.id("profileConnectionPhotoImg" + index);
        }

        /**
         * Locates a connection's view profile link for a given index
         *
         * @param index The index (Starting at 0) of the user you wish to locate
         * @return Returns a locator for the connection's view profile link by index
         */
        public By findConnectionLinkByIndex(String index) {
            return By.id("profileConnectionLink" + index);
        }

        /* Suggested Connections Section */
        public By suggestedConnectionsTitleTxt = By.id("suggestedConnectionsTitleTxt");
        public By suggestedConnectionImg = By.id("currentSuggestedConnectionImg");
        public By suggestedConnectionNameTxt = By.id("suggestedConnectionCurrentNameText");
        public By suggestedConnectionConnectBtn = By.id("suggestedConnectionsCurrentConnectBtn");
        public By suggestedConnectionDismissBtn = By.id("suggestedConnectionsCurrentConnectBtn");
        public By suggestedConnectionNextBtn = By.id("nextSuggestedConnectionImg");

        /* Shared profile page locators */
        public By successToastDiv = By.cssSelector("div#bodySideMenuToast.success");
        public By failToastDiv = By.cssSelector("div#bodySideMenuToast.error");
        public By profileBackBtn = By.id("editProfileBackBtn");
        public By publicProfileViewBackBtn = By.cssSelector("button.bf-button");
        public By editProfileBtn = By.id("editProfileBtn");
        public By cancelPendingConnectionRequestBtn = By.id("profileConnectBtn");
    }

    public static class EditProfilePageLocators {
        public By editProfilePersonalInfoLink = By.id("editProfilePersonalInfoLink");
        public By editProfileExperienceLink = By.id("editProfileExperienceLink");
        public By editProfileWorkAvailabilityLink = By.id("editProfileAvailabilityLink");
        public By editProfileSkillsLink = By.id("editProfileSkillsLink");
        public By editProfileCertificationsLink = By.id("editProfileCertificationsLink");
        public By editProfileEducationLink = By.id("editProfileEducationLink");
        public By editProfileAboutLink = By.id("editProfileAboutLink");
        public By editProfileViewProfileLink = By.id("editProfileViewProfileLink");
    }

    public static class PersonalInfoPageLocators {
        public By personalInfoPhotoTxt = By.id("profileInfoPhotoTxt");
        public By personalInfoUserPhotoAvatarImg = By.id("personalInfoCardProfileImg");
        public By personalInfoUserPhotoImg = By.id("personalInfoCardProfileImg");
        public By personalInfoUploadUserPhotoToggleBtn = By.id("personalInfoAddPhotoBtn");
        public By personalInfoUploadUserPhotoBtn = By.id("profileInfoUploadPhotoBtn");
        public By personalInfoUploadUserPhotoFromFacebookBtn = By.id("profileInfoImportFromFacebookBtn");
        public By personalInfoFirstNameTxtField = By.id("personalInfoFirstNameInput");
        public By personalInfoLastNameTxtField = By.id("personalInfoLastNameInput");
        public By personalInfoLocationTxtField = By.id("personalInfoLocationInput");
        public By personalInfoPhoneTxtField = By.id("personalInfoPhoneInput");
        public By personalInfoBirthdayMonthSelect = By.id("personalInfoMonthSelect");
        public By personalInfoBirthdayDaySelect = By.id("personalInfoDaySelect");
        public By personalInfoBirthdayYearSelect = By.id("personalInfoYearSelect");
        public By personalInfoSaveBtn = By.id("savePersonalInfoBtn");
        public By personalInfoSuccessToastTxt = By.id("personalInfoToastTypeTxt");
        public By personalInfoSuccessToast = By.cssSelector("div#personalInfoToast.success");
        public By personalInfoSuccessToastCloseBtn = By.id("personalInfoToastCloseBtn");
        public By personalInfoTooltip = By.id("tooltip");
        public By personalInfoLocationTitleTooltip = By.id("personalInfoLocationTitleTooltip");
        public By personalInfoPhoneTitleTooltip = By.id("personalInfoPhoneTitleTooltip");
        public By personalInfoBirthdateTitleTooltip = By.id("personalInfoBirthDateTitleTooltip");
        public By personalInfoLocationTxtTooltip = By.id("personalInfoLocationDescriptionTooltip");
        public By personalInfoPhoneTxtTooltip = By.id("personalInfoPhoneDescriptionTooltip");
        public By personalInfoBirthdateTxtTooltip = By.id("personalInfoBirthDateDescriptionTooltip");
    }

    public static class WorkHistoryPageLocators {
        public By editExperienceSuccessToast = By.id("editWorkHistorySuccessToast");
        public By editExperienceSuccessToastCloseBtn = By.id("editWorkHistorySuccessToastCloseBtn");
        public By addExperienceSuccessToast = By.id("addWorkHistorySuccessToast");
        public By addExperienceSuccessToastCloseBtn = By.id("addWorkHistorySuccessToastCloseBtn");
        public By addWorkHistoryBtn = By.id("addExperienceBtn");
        public By emptyWorkHistoryTitle = By.id("experienceMessageTitleText");
        public By emptyWorkHistoryTxt = By.id("experienceMessageText");
        public By firstJobChk = By.id("addWorkHistoryFirstJobCheckboxBox");
        public By firstJobChkLbl = By.id("addWorkHistoryFirstJobCheckboxLabel");

        public By workHistoryTooltip = By.id("tooltip");

        /**
         * Locates a work history entry's employer logo by index
         *
         * @param index The index (Starting at 0) of the work history employer logo you wish to locate
         * @return A locator for a work history employer logo at the given index
         */
        public By findWorkHistoryEmployerLogoByIndex(String index) {
            return By.id("workHistoryCardListItemImg" + index);
        }

        /**
         * Locates a work history entry's position by index
         *
         * @param listIndex     The index (Starting at 0) of the work history list item position you wish to locate
         * @param positionIndex The index (Starting at 0) of the work history position
         * @return A locator for a work history position at the given index
         */
        public By findWorkHistoryPositionByIndex(String listIndex, String positionIndex) {
            return By.id("workHistoryCardListItem" + listIndex + "Position" + positionIndex);
        }

        /**
         * Locates a work history entry's employer by index
         *
         * @param index The index (Starting at 0) of the work history employer you wish to locate
         * @return A locator for a work history employer at the given index
         */
        public By findWorkHistoryEmployerByIndex(String index) {
            return By.id("workHistoryCardListItemTitleText" + index);
        }

        /**
         * Locates a work history entry's time period by index
         *
         * @param index The index (Starting at 0) of the work history time period you wish to locate
         * @return A locator for a work history time period at the given index
         */
        public By findWorkHistoryTimePeriodByIndex(String index) {
            return By.id("workHistoryCardListItemWorkPeriodText" + index);
        }

        /**
         * Locates a work history entry's duration by index
         *
         * @param index The index (Starting at 0) of the work history duration you wish to locate
         * @return A locator for a work history duration at the given index
         */
        public By findWorkHistoryDurationByIndex(String index) {
            return By.id("workHistoryCardListItemDurationText" + index);
        }

        /**
         * Locates a work history entry's edit button by index
         *
         * @param index The index (Starting at 0) of the work history edit button you wish to locate
         * @return A locator for a work history edit button at the given index
         */
        public By findWorkHistoryEditBtnByIndex(String index) {
            return By.id("workHistoryCardListItemEditBtn" + index);
        }

        /**
         * Locates a selected position by index
         *
         * @param index The index (Starting at 0) of the selected position you wish to locate
         * @return A locator for a selected position at the given index
         */
        public By findSelectedPositionLblByIndex(String index) {
            return By.id("addWorkHistoryJobsSelectBoxSelectedOptionLabel" + index);
        }

        /**
         * Locates a selected position remove button by index
         *
         * @param index The index (Starting at 0) of the selected position remove button you wish to locate
         * @return A locator for a selected position remove button at the given index
         */
        public By findSelectedPositionRemoveBtnByIndex(String index) {
            return By.id("addWorkHistoryJobsSelectBoxSelectedOptionCloseBtn" + index);
        }

        public By jobPositionDropdown = By.id("addWorkHistoryJobsSelectBoxDropdownArrow");

        /**
         * Locates a position to add by index
         *
         * @param index The index (Starting at 0) of the position you wish to locate
         * @return A locator for a position to add at the given index
         */
        public By findPositionByIndex(String index) {
            return By.id("addWorkHistoryJobsSelectBoxOption" + index);
        }

        public By employerLocationTxtField = By.id("addWorkHistoryLocationInput");
        public By iDontSeeMyStoreLink = By.id("addWorkHistoryToggleSearchBtn");
        public By fromMonthDateSelect = By.id("addWorkHistoryStartMonthSelectBox");
        public By fromYearDateSelect = By.id("addWorkHistoryStartYearSelectBox");
        public By toMonthDateSelect = By.id("addWorkHistoryEndMonthSelectBox");
        public By toYearDateSelect = By.id("addWorkHistoryEndYearSelectBox");
        public By currentWorkHistoryDisableBtn = By.id("addWorkHistoryToggleEndDateBtnOff");
        public By currentWorkHistoryEnableBtn = By.id("addWorkHistoryToggleEndDateBtnOn");
        public By editjobDescriptionField = By.id("editWorkHistoryDescriptionTxt");
        public By addjobDescriptionField = By.id("addWorkHistoryDescriptionTxt");

        public By customPositionTxtField = By.id("addWorkHistoryCustomJobName");
        public By customEmployerNameTxtField = By.id("addWorkHistoryCustomNameInput");
        public By customEmployerLocationTxtField = By.id("addWorkHistorycustomLocationInput");
        public By searchForStoreLink = By.id("addWorkHistoryToggleSearchBtn");

        public By addWorkHistorySaveBtn = By.id("addWorkHistorySaveBtn");
        public By addWorkHistoryCancelBtn = By.id("addWorkHistoryCancelBtn");
        public By editWorkHistorySaveBtn = By.id("editWorkHistorySaveBtn");
        public By editWorkHistoryCancelBtn = By.id("editWorkHistoryCancelBtn");
        public By editWorkHistoryDeleteBtn = By.id("editWorkHistoryDeleteBtn");

        public By deleteWorkHistoryTitle = By.id("");
        public By deleteWorkHistoryTxt = By.id("");
        public By deleteWorkHistoryDeleteBtn = By.id("editWorkHistoryDeleteConfirmationBtn");
        public By deleteWorkHistoryCancelBtn = By.id("editWorkHistoryCancelDeleteBtn");
        public By deleteWorkHistorySuccessToast = By.id("deleteWorkHistorySuccessToast");
        public By deleteWorkHistorySuccessToastCloseBtn = By.id("deleteWorkHistorySuccessToastCloseBtn");
        public By googlePlacesMyStoreBtns = By.cssSelector("div.pac-container>div.pac-item");

        /**
         * Locates a edit work history button for a given index
         *
         * @param index The index (Starting at 0) of the employer you wish to locate
         * @return Returns a locator for the edit work history button by index
         */
        public By findEditWorkHistoryItemByIndex(String index) {
            return By.id("workHistoryCardListItemEditBtn" + index);
        }
    }

    public static class CertificationsPageLocators {
        public By editCertsHeader = By.id("editProfileCertificationsTitleText");
        public By editCertsHeaderMsg = By.id("editProfileCertificationsSubTitleText");
        public By alcoholSellerImg = By.id("editCertificationsListItemAlcoholSeller/ServerImg");
        public By alcoholSellerTxt = By.id("editCertificationsListItemAlcoholSeller/ServerLabelText");
        public By alcoholSellerChk = By.id("editCertificationsListItemAlcoholSeller/ServerChk");
        public By alcoholSellerChkBox = By.id("editCertificationsListItemAlcoholSeller/ServerChkBox");
        public By alcoholSellerUploadBtn = By.cssSelector("div.certification-item:nth-of-type(1)>div.upload-btn");
        public By foodHandlerImg = By.id("editCertificationsListItemFoodHandlerImg");
        public By foodHandlerTxt = By.id("editCertificationsListItemFoodHandlerLabelText");
        public By foodHandlerChk = By.id("editCertificationsListItemFoodHandlerChk");
        public By foodHandlerChkBox = By.id("editCertificationsListItemFoodHandlerChkBox");
        public By foodHandlerUploadBtn = By.cssSelector("div.certification-item:nth-of-type(2)>div.upload-btn");
        public By foodProtectionImg = By.id("editCertificationsListItemFoodProtectionManagerImg");
        public By foodProtectionTxt = By.id("editCertificationsListItemFoodProtectionManagerLabelText");
        public By foodProtectionChk = By.id("editCertificationsListItemFoodProtectionManagerChk");
        public By foodProtectionChkBox = By.id("editCertificationsListItemFoodProtectionManagerChkBox");
        public By foodProtectionUploadBtn = By.cssSelector("div.certification-item:nth-of-type(3)>div.upload-btn");
        public By haccpImg = By.id("editCertificationsListItemHACCPImg");
        public By haccpTxt = By.id("editCertificationsListItemHACCPLabelText");
        public By haccpChk = By.id("editCertificationsListItemHACCPChk");
        public By haccpChkBox = By.id("editCertificationsListItemHACCPChkBox");
        public By haccpUploadBtn = By.cssSelector("div.certification-item:nth-of-type(4)>div.upload-btn");
        public By saveBtn = By.id("saveProfileCertificationsBtn");
        public By certsSuccessToastDiv = By.cssSelector("div#editProfileCertificationsToast.success");
        public By certsBannerCloseBtn = By.id("editProfileCertificationsToastCloseBtn");
        public By certsTooltip = By.id("tooltip");
        public By certsTitleTooltip = By.id("certificationsTitleTooltip");
        public By certsTxtTooltip = By.id("certificationsDescriptionTooltip0");
    }

    public static class SkillsPageLocators {
        public By skillsTitleTxt = By.id("editProfileSkillTitle");
        public By skillsTooltip = By.id("tooltip");
        public By skillsTitleTooltip = By.id("skillsTitleTooltip");
        public By skillsTxtTooltip = By.id("skillsDescriptionTooltip0");

        /**
         * Locates a skill by index
         *
         * @param index The index (Starting at 0) of the skill you wish to locate
         * @return A locator for a skill at the given index
         */
        public By skillLbl(String index) {
            return By.id("editProfileSkillLabel" + index);
        }

        /**
         * Locates a selected skill by index
         *
         * @param index The index (Starting at 0) of the selected skill you wish to locate
         * @return A locator for a selected skill at the given index
         */
        public By skillSelectedLbl(String index) {
            return By.cssSelector("div#editProfileSkillLabel" + index + ".selected");
        }

        public By skillsSaveBtn = By.id("editProfileSkillSaveBtn");
        public By skillsSuccessToast = By.id("editProfileSkillToast");
        public By skillSuccessToastCloseBtn = By.id("editProfileSkillToastCloseBtn");
    }

    public static class AboutPageLocators {
        public By aboutHeader = By.id("editProfileAboutTitleText");
        public By aboutTextField = By.id("editProfileAboutTextArea");
        public By aboutSaveBtn = By.id("saveProfileAboutBtn");
        public By aboutBannerDiv = By.id("editProfileAboutToast");
        public By aboutSuccessToastDiv = By.cssSelector("div#editProfileAboutToast.success");
        public By aboutBannerCloseBtn = By.id("editProfileAboutToastCloseBtn");
        public By aboutTooltip = By.id("tooltip");
    }

    public static class AvailabilityPageLocators {
        public By availabilityStatusDropDown = By.id("editAvailabilityEmploymentStatus");
        public By availabilityGigsChkBox = By.id("editAvailabilityGigsCheckboxBox");
        public By availabilityFullTimeCard = By.id("editAvailabilityCardFull-Time");
        public By availabilityPartTimeCard = By.id("editAvailabilityCardPart-Time");
        public By availabilitySeasonalCard = By.id("editAvailabilityCardSeasonal");
        public By availabilityAnythingCard = By.id("editAvailabilityCardAnything");
        public By morningCard = By.id("editAvailabilityCardMornings");
        public By afternoonCard = By.id("editAvailabilityCardAfternoons");
        public By eveningCard = By.id("editAvailabilityCardEvenings");
        public By nightsCard = By.id("editAvailabilityCardNights");
        public By saveBtn = By.id("editAvailabilitySaveBtn");
        public By availabilitySuccessToastDiv = By.cssSelector("div#editProfileAvailabilityToast.success");
        public By availabilityBannerCloseBtn = By.id("editProfileAvailabilityToastCloseBtn");
        public By availabilityTooltip = By.id("tooltip");
        public By availabilityTitleTooltip = By.id("availabilityTitleTooltip");
        public By availabilityTxtTooltip = By.id("availabilityDescriptionTooltip");
    }

    public static class EducationPageLocators {
        public By educationAddBtn = By.id("viewEducationBtn");
        public By educationAddSchoolField = By.id("addEducationSchoolInput");
        public By educationEditSchoolField = By.id("editEducationSchoolInput");
        public By educationAddDegreeField = By.id("addEducationDegreeInput");
        public By educationEditDegreeField = By.id("editEducationDegreeInput");
        public By educationAddFromYearSelect = By.id("addEducationFromYearSelect");
        public By educationEditFromYearSelect = By.id("editEducationFromYearSelect");
        public By educationAddToYearSelect = By.id("addEducationToYearSelect");
        public By educationEditToYearSelect = By.id("editEducationToYearSelect");
        public By educationAddSaveBtn = By.id("addEducationSaveBtn");
        public By educationEditSaveBtn = By.id("editEducationSaveBtn");
        public By educationAddCancelBtn = By.id("addEducationCancelBtn");
        public By educationEditCancelBtn = By.id("editEducationCancelBtn");
        public By educationEditDeleteBtn = By.id("editEducationDeleteLink");
        public By educationEditDeleteConfirmationBtn = By.id("editEducationDeleteConfirmationBtn");
        public By educationAddTooltipTitleTxt = By.id("addEducationTitleTooltip");
        public By educationEditTooltipTitleTxt = By.id("editEducationTitleTooltip");
        public By educationAddTooltipP1Txt = By.id("addEducationDescriptionTooltip0");
        public By educationEditTooltipP1Txt = By.id("editEducationDescriptionTooltip0"); //Need to fix duplicate ID
        public By educationAddTooltipP2Txt = By.id("addEducationDescriptionTooltip1");
        public By educationEditTooltipP2Txt = By.id("editEducationDescriptionTooltip0"); //Need to fix duplicate ID
        public By educationAddSuccessToast = By.id("addEducationSuccessToast");
        public By educationAddSuccessToastCloseBtn = By.id("addEducationSuccessToastCloseBtn");
        public By educationEditSuccessToast = By.id("editEducationSuccessToast");
        public By educationEditSuccessToastCloseBtn = By.id("editEducationSuccessToastCloseBtn");

        /**
         * Locates an education record by index
         *
         * @param index The index (Starting at 0) of the education record you wish to locate
         * @return A locator for a education record at the given index
         */
        public By findEducationEditBtnByIndex(String index) {
            return By.id("viewEducationEditBtn" + index);
        }

        /**
         * Locates an education record's school by index
         *
         * @param index The index (Starting at 0) of the education record's school you wish to locate
         * @return A locator for a education record's school at the given index
         */
        public By findEducationSchoolTxtByIndex(String index) {
            return By.id("viewEducationInstitutionText" + index);
        }

        /**
         * Locates an education record's degree by index
         *
         * @param index The index (Starting at 0) of the education record's degree you wish to locate
         * @return A locator for a education record's degree at the given index
         */
        public By findEducationDegreeTxtByIndex(String index) {
            return By.id("viewEducationDegreeText" + index);
        }

        /**
         * Locates an education record's duration by index
         *
         * @param index The index (Starting at 0) of the education record's duration you wish to locate
         * @return A locator for a education record's duration at the given index
         */
        public By findEducationDurationTxtByIndex(String index) {
            return By.id("viewEducationStudyingPeriodText" + index);
        }
    }

    public static class HourlyNetworkPageLocators {
        /* Global connections page locators */
        public By connectionsGetConnectedBtn = By.id("communityGetConnectedLinkTab");
       // public By connectionsMyConnectionsBtn = By.xpath("//a[@id='MyConnectionsBlockViewConnectionsBtn' and @title='View Connections']");
        public By connectionsMyConnectionsBtn = By.id("myConnectionsBlockViewConnectionsBtn");
        public By connectionsInvitationsBtn = By.id("communityInvitationsLinkTab");
        public By userSearchTextField = By.id("suggestedConnectionsMemberSearchInputDesktopView");

        /**
         * Locates a member search result by index
         *
         * @param index The index (Starting at 0) of the member search result you wish to locate
         * @return A locator for a member search result at the given index
         */
        public By findMemberSearchResultByIndex(String index) {
            return By.id("suggestedConnectionsMemberSearchListItem" + index + "NameText" + index);
        }

        public By userSearchListResultTxt = By.id("memberSearchListItem");
        public By invitationsTitleTxt = By.id("invitationsBlockHeaderTxt");

        /**
         * Return invitation Request by index
         * @param index
         * @return
         */
        @Deprecated
        public By invitationsCountTxt(String index) { return By.id("invitationRequestCarouselCard"+index);} ;



        /* My Connections section */
        public By emptyConnectionsTitleTxt = By.id("myConnectionsEmptySearchTextTitle");

        /**
         * Locates a connection box Link at a given index
         *
         * @param index The index (Starting at 0) of the user you wish to locate
         * @return Returns a locator for the user card's image by index
         */
        public By findConnectionCardLinkbyIndex(String index) {
            return By.id("myConnectionsConnectionCardLink" + index);

        }

        /**
         * Locates a connection's photo for a given index
         *
         * @param index The index (Starting at 0) of the user you wish to locate
         * @return Returns a locator for the user card's image by index
         */
        public By findConnectionCardImgByIndex(String index) {
            return By.id("myConnectionsPhotoImg" + index);

        }

        /**
         * Locates a connection's name for a given index
         */
       public  By findConnectionCardNameTxtByIndex(String index){return By.id("myConnectionsNameTxt" + index);}


        /**
         * Locates a connection's work history for a given index
         */
        public By findConnectionCardWorkTxtByIndex(String index) {return By.id("myConnectionsPositionTxt" + index);};


        /**
         * Locates a connection's work history for a given index
         */
        public By findConnectionCarMutualTxtByIndex = By.id("myConnectionsMutualConnectionNumber" );

        /**
         * Locates a connection's message button for a given index
         */
       public  By findConnectionCardMessageBtnByIndex = By.id("myConnectionsMessageBtn");


        public By connectionPage1Btn = By.id("connectionsPage1Btn");
        public By connectionPage2Btn = By.id("connectionsPage2Btn");
        public By connectionPage3Btn = By.id("connectionsPage3Btn");
        public By connectionPage4Btn = By.id("connectionsPage4Btn");
        public By connectionNextPageBtn = By.id("connectionsNextBtn");
        public By connectionPreviousPageBtn = By.id("connectionsPreviousBtn");

        /* Suggested connections section */

        /**
         * Locates a connection box Link at a given index
         *
         * @param index The index (Starting at 0) of the user you wish to locate
         * @return Returns a locator for the user card's image by index
         */
        public By findSuggestionCardLinkbyIndex(String index) {
            return By.id("getConnectedConnectionCardLink" + index);

        }

        /**
         * Locates a connection box Link at a given index to click it
         */
        public By findSuggestionToClick() {
            return By.id("col-12 col-md-6 col-lg-6 col-xl-4");

        }

        /**
         * Locates a suggested connection's photo for a given index
         *
         * @param index The index (Starting at 0) of the user you wish to locate
         * @return Returns a locator for the user card's image by index
         */
        public By findSuggestionCardImgByIndex(String index) {
            return By.id("getConnectedPhotoImg" + index);

        }

        /**
         * Locates a suggested connection's name for a given index
         */
        public By findSuggestionCardNameTxtByIndex(String index) { return By.id("getConnectedNameTxt" + index);};

        /**
         * Locates a suggested connection's reason for a given index
         *
         * @param index The index (Starting at 0) of the user you wish to locate
         * @return Returns a locator for the user card's reason by index
         */
        public By findSuggestionCardReasonTxtByIndex(String index) {
            return By.id("getConnectedReasonTxt" + index);
        }

        /**
         * Locates a suggested connection's view button for a given index
         */
        public By findSuggestionCardViewProfileLink = By.xpath("//div[@class='d-flex flex-column styles__wrapper___2Vct1']");

        /**
         * Locates a suggested connection's connect button for a given index
         */
        public By findSuggestionCardConnectBtnByIndex(String index){ return  By.id("getConnectedConnectBtn" + index);};


        public By suggestionsPage1Btn = By.id("suggestedConnectionsPage1Btn");
        public By suggestionsPage2Btn = By.id("suggestedConnectionsPage2Btn");
        public By suggestionsPage3Btn = By.id("suggestedConnectionsPage3Btn");
        public By suggestionsPage4Btn = By.id("suggestedConnectionsPage4Btn");
        public By suggestionsnNextPageBtn = By.id("suggestedConnectionsNextBtn");
        public By suggestionsnPreviousPageBtn = By.id("suggestedConnectionsPreviousBtn");

        /* Invitations section */
        public By invitationNoList = By.id("invitationRequestCarouselCard0");
        public By invitationList = By.xpath("//div[@class='swiper-wrapper d-flex']");
        public By invitationListElement = By.tagName("a");
       // public By invitationEmptyTitleTxt = By.id("invitationsEmptySearchTextTitle");
        //public By invitationEmptyTxt = By.id("invitationsEmptySearchTextContent");
        //public By invitationEmptySuggestionsBtn = By.id("invitationsGetConnectedBtn");

        /* Get Connected - Invitation Request section */

        /**
         * Locates an invitation's photo for a given index
         *
         * @param index The index (Starting at 0) of the user you wish to locate
         * @return Returns a locator for the user card's image by index
         */
        public By findInvitationCardImgByIndex(String index) {
            return By.id("invitationRequestsCarouselCardImg" + index + "Icon");
        }

        /**
         * Locates an invitation's name for a given index
         *
         * @param index The index (Starting at 0) of the user you wish to locate
         * @return Returns a locator for the user card's name by index
         */
        public By findInvitationCardNameTxtByIndex(String index) {
            return By.id("invitationRequestsCarouselCardFullNameTxt" + index);
        }

        /**
         * Locates an invitation's work history for a given index
         *
         * @param index The index (Starting at 0) of the user you wish to locate
         * @return Returns a locator for the user card's work history by index
         */
        public By findInvitationCardJobTxtByIndex(String index) {
            return By.id("invitationRequestsCarouselCardPositionTxt" + index);
        }

        /**
         * Locates an invitation's ignore button for a given index
         *
         * @param index The index (Starting at 0) of the user's ignore button you wish to locate
         * @return Returns a locator for the user card's ignore button by index
         */
        public By findInvitationCardIgnoreBtnByIndex(String index) {
            return By.id("invitationRequestsCarouselCardRejectBtn" + index);
        }

        /**
         * Locates an invitation's connect button for a given index
         *
         * @param index The index (Starting at 0) of the user you wish to locate
         * @return Returns a locator for the user card's connect button by index
         */
        public By findInvitationCardConnectBtnByIndex(String index) {
            return By.id("invitationRequestsCarouselCardAcceptBtn" + index);
        }
    }

    public static class HourlyMessagePageLocators {
        public By messageThreadRecipientTitle = By.id("messageThreadTitle");
        public By messageComposeSelectedConnection0NameTxt = By.id("messageComposeConnectionsSelectConnection0NameTxt");
        public By messageListItem = By.xpath("//div[contains(@id, 'messageListItem')]");

        /**
         * Find the message list item by index
         * @param index
         * @return
         */

        public By messagesListItemByIndex(String index) {
            return By.id("messageListItem" + index);
        }
        public By messageDeleteTrashIcon = By.id("deleteMessageTrashIcon");
        public By messageListRecipientName = By.id("messageListItem0UsernameText");
        public By messageListRecipientImg = By.id("messageListItem0ImgIcon");
        public By messageListRecipientDate = By.id("messageListItem0UsernameDate");
        public By messageListMsgTxt = By.id("messageListItem0MessageText");
        public By messageListSenderPositionTxt0 = By.id("messageListItemSenderPositionText0");
        public By messageListYearDividerTxt = By.id("messageListItemYearDivider0");
        public By messageThreadSenderImg0 = By.id("messageThreadWdgMessageAvatarImg0");
        public By messageThreadSenderTxt0 = By.className("text-break-word");
        public By messageThreadSenderTimeTxt0 = By.id("messageThreadWdgMessage0SentTimeText");
        public By messageThreadRecipientImg0 = By.id("messageThreadWdgMessageTextMessageAvatarImg0");
        public By messageThreadTxt0 = By.id("messageThreadWdgMessageText0");
        public By messageThreadRecipientTimeTxt0 = By.id("recipientMessageSentTimeText0");
        public By messageThreadYearDividerTxt0 = By.id("senderMessageDividerText0");
        public By messageThreadWdgInput = By.id("messageThreadWdgInput");
        public By messageThreadWdgSendBtn = By.id("messageThreadWdgSendBtn");
        public By messageThreadWdgCloseBtn = By.id("messageThreadWdgCloseBtn");
        public By messageThreadWdgSettingsBtn = By.id("messageThreadWdgSettingsBtn");
        public By messageThreadWdgDeleteMenu = By.id("messageThreadWdgDeleteMenu");
        public By successToastDiv = By.id("bodySideMenuToast");
        public By msgListModal = By.id("messagesMenu");
        public By msgListModalTitle = By.id("messagesListTitle");
        public By msgMenuHeaderNewMsgBtn = By.id("messagesMenuHeaderNewMessageBtn");
        public By emptyMsg = By.className("messages-empty");
        public By emptyMsgH4 = By.xpath("//div[@class='messages-empty']/h4");
        public By msgComposeModal = By.className("message-compose show");
        public By msgComposeModalTitle = By.id("messageComposeTitleTxt");
        public By textboxMsgComposeModalSearchConnections = By.id("messageComposeConnectionsSelectInput");
        public By labelMsgComposeModalNoConnection = By.id("messageComposeNoConnectionsTxt");
        public By buttonGetConnected = By.id("messageComposeGetConnectedBtn");
        public By msgComposeConnectionsList = By.id("messageComposeConnectionsSelect");
        public By msgComposeConnection0 = By.id("messageComposeConnectionsSelectConnection0");
        public By msgThreadWdg = By.id("messageThreadWdg");
        public By msgRedBadge = By.cssSelector("#headerMessagesLink.with-badge");
        public By msgNoRedBadge = By.cssSelector("#headerMessagesLink");

        public By msgItemInThread(String index){
            return By.id("messageThreadWdgMessageText" + index);
        }

        public By msgReferralTextItem(){
            return By.xpath(".//div[@class='messages-item-text']");
        }

        public By msgReferralTinyURLItem(){
            return By.xpath(".//div[@class='messages-item-tinyurl']");
        }
      
        public By messageThreadMessageWrapper0 = By.cssSelector("#messageThreadWdgMessageWrapper0");

    }

    public static class HourlyBeSuccessfulPageLocators {
        public By beSuccessfulTitleTxt = By.id("beSuccessfulHeadlineTxt");
    }

    public static class HorariosCalientesLocators {
        /* HS Main (Labor) */
        public By loadingSpinnerIndicator = By.id("hs-LoadingAnimation");
        public By loadingBarIndicator = By.id("loadingImage");
        public By loginUsernameField = By.id("loginusername");
        public By loginPasswordField = By.id("loginpassword");
        public By loginBtn = By.id("loginBtn");
        public By pendingTasksCancelBtn = By.id("cancelButton");
        public By appDropdownBtn = By.id("hs-logo");
        public By bfSsoBtn = By.id("bfEntry");
        public By staffTabBtn = By.cssSelector("div.menu-column>div.hs-menu>div:nth-of-type(4)");
//        public By staffTabBtn = By.cssSelector("ul#new_ui_menu>li:nth-of-type(4)");
        public By staffTabAddEmployeeBtn = By.cssSelector("div#left-container>div>div>a");
//        public By staffTabAddEmployeeBtn = By.cssSelector("div#addOrImportEmployeeButtonDiv>a");
        public By addEmployeeFirstNameField = By.id("first-name");
        public By addEmployeeLastNameField = By.id("last-name");
        public By addEmployeeUsernameField = By.id("userId");
        public By addEmployeePasswordField = By.id("password");
        public By addEmployeeEmailField = By.id("email");
        public By addEmployeeSaveBtn = By.id("btnSaveEmpDetails");
        public By addEmployeeJobsTabBtn = By.id("1");
        public By addEmployeeJobBartenderChk = By.id("job_1027072066");
        public By addEmployeeJobManager1Chk = By.id("job_1027072067");
        public By addEmployeeJobManager2Chk = By.id("job_1047288764");
        public By addEmployeeJobServer1Chk = By.id("job_1047288766");
        /* HS Support Site */
        public By supportInfoSearchBtn = By.id("info-search");
        public By supportSearchField = By.id("search-box");
        public By supportEmployerResultBtn = By.cssSelector("div#search-list * tbody * td:nth-of-type(2)>a");
        public By supportUsernameFilterField = By.id("filter-username");
        public By supportApplyFilterBtn = By.cssSelector("table.dataTable>thead>tr:nth-of-type(3) * input:nth-of-type(2)");
        public By employeeIdTxt = By.cssSelector("div#info-table_wrapper>div.dataTables_scroll * tbody * td:nth-of-type(2)");
    }

    public static class MailinatorLocators {
        public By inboxField = By.id("inboxfield");
        public By checkEmailBtn = By.cssSelector("button.btn.btn-dark");
        public By emailSubjectLink = By.cssSelector("ul#inboxpane>li>div>div:nth-of-type(4)");
        public By iFrame = By.id("msg_body");
        public By activationActionLink = By.cssSelector("table:nth-of-type(2)>tbody>tr>td>a");
        public By viewJobActionLink = By.cssSelector("table:nth-of-type(3)>tbody>tr>td>a");
        public By viewApplicantActionLink = By.className("button");

    }

    public static class AutoProvisionSignUpLocators {
        public By firstNameField = By.id("undefinedUserFirstname");
        public By lastNameField = By.id("undefinedUserLastname");
        public By emailField = By.id("undefinedEmailInput");
        public By passwordField = By.id("undefinedPasswordInput");
        public By createAccountBtn = By.id("ConfirmSignUpSubmitBtn");
    }

    public static class EmployerSignUpLocators {
        /* Global */
        public By closeSignupBtn = By.id("overlayPageCloseBtn");

        /* Choose sign up method */
        public By signUpTitleTxt = By.id("chooseSignUpTitleText0");
        public By signUpByEmailBtn = By.id("chooseSignUpEmailSignUpBtn");
        public By signUpByFacebookBtn = By.id("signUpFacebookBtnIcon");
        public By termsTxt = By.id("chooseSignUpTermsOfServiceText");
        public By termsLink = By.id("chooseSignUpTermsOfServiceLink");
        public By signUpMethodBackBtn = By.id("chooseSignUpBackBtn");


        /* Email signup */
        public By emailSignupTitleTxt = By.id("EmailSignUpTitle");
        public By firstNameField = By.id("EmailSignUpUserFirstname");
        public By lastNameField = By.id("EmailSignUpUserLastname");
        public By emailField = By.id("EmailSignUpEmailInput");
        public By passwordField = By.id("EmailSignUpPasswordInput");
        public By emailSignupBackBtn = By.id("EmailSignUpBackBtn");
        public By emailSignupNextBtn = By.id("EmailSignUpNextBtn");

        /* Store location */
        //.../webapp/hiring/storelocation
        public By storeLocationTtitleTxt = By.id("storeLocationTitle");
        public By storeLocationSearchField = By.id("storeLocationSelectInput");

        /**
         * Locates an employer result for a given index
         *
         * @param index The index (Starting at 0) of the employer result you wish to locate
         * @return Returns a locator for the employer result by index
         */
        public By findEmployerResultByIndex(String index) {
            return By.id("storeLocationSelectConnection" + index);
        }

        public By storeLocationClaimedTitleTxt = By.id("storeClaimedBasicDialog");
        public By storeLocationClaimedTxt = By.id("storeClaimedText");
        public By storeLocationClaimedBtn = By.id("requestStoreAccessBtn");
        public By storeLocationClaimedCloseBtn = By.id("storeClaimedDialogCloseBtn");
        public By storeNameTxt = By.id("storeLocationSelectionStoreDetailsNameTxt");
        public By storeLocationTxt = By.id("storeLocationSelectionStoreDetailsAddressTxt");
        public By storeLocationCancelBtn = By.id("storeLocationBackBtn");
        public By storeLocationNextBtn = By.id("storeLocationNextBtn");

        /* Store logo */
        //.../webapp/hiring/storelogo/<employerGuid>
        public By storeLogoTtitleTxt = By.id("storeLogoTitleTxt");
        public By storeLogoFileInput = By.cssSelector("div.content>div.dropzone>input");
        public By storeLogoUploadTxt = By.id("storeLogoUploadHintTxt");
        public By storeLogoUploadBtn = By.id("storeLogoUploadBtn");
        public By storeLogoEditBtn = By.id("storeLogoEditBtn");
        public By storeLogoCropRotateBtn = By.id("cropToolRotateBtn");
        public By storeLogoCropCancelBtn = By.id("cropToolCancelBtn");
        public By storeLogoCropSaveBtn = By.id("cropToolSaveBtn");
        public By storeLogoEditUploadBtn = By.id("storeLogoUploadPhotoBtn");
        public By storeLogoEditRemoveBtn = By.id("storeLogoRemovePhotoBtn");
        public By storeLogoCancelBtn = By.id("storeLogoBackBtn");
        public By storeLogoNextBtn = By.id("storeLogoNextBtn");

        /* Store photos */
        public By storePhotosTitleTxt = By.id("storePhotosTitleTxt");
        public By storePhotosUploadBtn = By.id("storePhotosUploadBtn");

        /**
         * Locates a store photo button for a given index
         *
         * @param index The index (Starting at 0) of the store photo button you wish to locate
         * @return Returns a locator for the store photo button by index
         */
        public By findStorePhotoBtnByIndex(String index) {
            return By.id("storePhotosImageSelectBtn" + index);
        }

        public By storePhotosBackBtn = By.id("storePhotosBackBtn");
        public By storePhotosNextBtn = By.id("storePhotosNextBtn");

        /* Store type */
        //.../webapp/hiring/storetype/<employerGuid>
        public By storeTypeTitleTxt = By.id("storeTypeTitleTxt");
        public By storeTypeTxt = By.id("storeTypeChooseStoreTypeTxt");
        public By storeTypeDropdownTxt = By.id("storeTypeDropDown");
        public By storeTypeDropdownBtn = By.id("jobSearchJobTypeArrow");

        /**
         * Locates a store type selection for a given index
         *
         * @param index The index (Starting at 0) of the store type selection you wish to locate
         * @return Returns a locator for the store type selection by index
         */
        public By findStoreTypeByIndex(String index) {
            return By.id("storeTypeDropDownOption" + index);
        }

        /**
         * Locates a store type job type checkbox for a given index
         *
         * @param index The index (Starting at 0) of the store type job type checkbox you wish to locate
         * @return Returns a locator for the store type job type checkbox by index
         */
        public By findStoreTypeJobTypeChkByIndex(String index) {
            return By.id("storeTypeFormChk" + index + "Box");
        }

        /**
         * Locates a store type job type label for a given index
         *
         * @param index The index (Starting at 0) of the store type job type label you wish to locate
         * @return Returns a locator for the store type job type label by index
         */
        public By findStoreTypeJobTypeTxtByIndex(String index) {
            return By.id("storeTypeFormChk" + index + "Label");
        }

        /**
         * Locates a store type job type toggle for a given index
         *
         * @param index The index (Starting at 0) of the store type job type toggle you wish to locate
         * @return Returns a locator for the store type job type toggle by index
         */
        public By findStoreTypeJobTypeToggleOnByIndex(String index) {
            return By.id("storeTypeFormToggleBtn" + index + "On");
        }

        /**
         * Locates a store type job type toggle for a given index
         *
         * @param index The index (Starting at 0) of the store type job type toggle you wish to locate
         * @return Returns a locator for the store type job type toggle by index
         */
        public By findStoreTypeJobTypeToggleOffByIndex(String index) {
            return By.id("storeTypeFormToggleBtn" + index + "Off");
        }

        public By storeTypeBackBtn = By.id("storeTypeBackBtn");
        public By storeTypeFinishBtn = By.id("storeTypeNextBtn");

        /* Registration complete */
        public By storeCreatedTitle = By.id("storeCreatedDialogTitle");
        public By storeCreatedTxt = By.id("storeCreatedDialogTitle");
        public By storeCreatedEditProfileBtn = By.id("acceptBtn");
        public By storeCreatedViewProfileBtn = By.id("editBtn");
    }

    public static class EmployerProfileViewPageLocators {

        /**
         * Locates an employer photo for a given index
         *
         * @param index The index (Starting at 0) of the employer photo you wish to locate
         * @return Returns a locator for the employer photo by index
         */
        public By findEmployerPhotoByIndex (String index) {
            return By.id("storeProfilePhoto" + index);
        }

        public By employerProfileLoadingIndicator = By.cssSelector("div.spinner.active");
        public By employerHeaderNameTxt = By.id("storeProfileTitle");
        public By employerHeaderAddressTxt  = By.id("storeProfileSubtitle");
        public By employerHeaderEditProfileBtn = By.id("manageMyStoreBtn");
        public By employerHeaderLogoImg  = By.id("storeProfileLogo");
        public By employerHeaderLikeBtn = By.id("storeProfileLikeBtn");
        public By employerHeaderFollowBtn = By.id("storeProfileFollowBtn");
        public By employerEditProfileBtn = By.id("manageMyStoreBtn");
        public By employerMapImg = By.id("storeMapImg");
        public By employerMapLink = By.id("storeMapLink");
        public By employerCityTxt = By.id("employerCityText");
        public By employerDistanceTxt  = By.id("employerDistanceText");
        public By employerAddressTxt = By.id("employerAddressText");
        public By employerGetDirectionsLbl  = By.id("employerGetDirectionsLabel");
        public By employerGetDirectionsLink = By.id("employerGetDirectionsLink");
        public By employerWebsiteLbl = By.id("employerWebsiteLabel");
        public By employerWebsiteLink  = By.id("employerWebsiteLink");
        public By employerWebsitePhoneLbl = By.id("employerPhoneLabel");
        public By employerPhoneLink = By.id("employerPhoneLink");
        public By employerFacebookBtn = By.id("storeProfileFacebookBtn");
        public By employerTwitterBtn = By.id("storeProfileTwitterBtn");
        public By employerShareProfileBtn = By.id("storeProfileShareLinkBtn");
        public By employerAboutTitleTxt = By.id("storeProfileAboutTitle");
        public By employerAboutTxt = By.id("storeProfileAboutText");
        public By employerAboutExpandTextBtn = By.id("storeProfileAboutExpandableContentIconBtn");
        public By employerAboutEditBtn = By.id("storeProfileAboutEditBtn");
        public By employerManagementTitleTxt = By.id("storeProfileTeamSection");
        public By employerManagementEditBtn = By.id("storeProfileEditBtn");
        public By employerStoreCreatedTxt = By.id("addStoredDetailsReminder");

        /**
         * Locates an employer manager photo for a given index
         *
         * @param index The index (Starting at 0) of the employer manager photo you wish to locate
         * @return Returns a locator for the employer manager photo by index
         */
        public By findEmployerManagerPhotoByIndex(String index) {
            return By.id("storeProfileStoreManager" + index + "Avatar");
        }

        /**
         * Locates an employer manager name for a given index
         *
         * @param index The index (Starting at 0) of the employer manager name you wish to locate
         * @return Returns a locator for the employer manager name by index
         */
        public By findEmployerManagerNameByIndex(String index) {
            return By.id("storeProfileStoreManager" + index + "NameText");
        }

        /**
         * Locates an employer manager label for a given index
         *
         * @param index The index (Starting at 0) of the employer manager label you wish to locate
         * @return Returns a locator for the employer manager label by index
         */
        public By findEmployerManagerLabelByIndex(String index) {
            return By.id("storeProfileStoreManager" + index + "Label");
        }

        /**
         * Locates an employer manager description for a given index
         *
         * @param index The index (Starting at 0) of the employer manager description you wish to locate
         * @return Returns a locator for the employer manager description by index
         */
        public By findEmployerManagerDescriptionByIndex(String index) {
            return By.id("storeMember" + index + "DescriptionText" + index);
        }

        public By employerJobTitleTxt = By.id("jobsTitleLabel");

        /**
         * Locates an employer job position for a given index
         *
         * @param index The index (Starting at 0) of the employer job position you wish to locate
         * @return Returns a locator for the employer job position by index
         */
        public By findEmployerJobCardPositionByIndex(String index) {
            return By.id("JobCardStoreProfileJobNameTextJobCard" + index);
        }

        /**
         * Locates an employer job wage for a given index
         *
         * @param index The index (Starting at 0) of the employer job wage you wish to locate
         * @return Returns a locator for the employer job wage by index
         */
        public By findEmployerJobCardWageByIndex(String index) {
            return By.id("searchResultWageTextJobCard" + index);
        }

        /**
         * Locates an employer job availability for a given index
         *
         * @param index The index (Starting at 0) of the employer job availability you wish to locate
         * @return Returns a locator for the employer job availability by index
         */
        public By findEmployerJobCardAvailabilityByIndex(String index) {
            return By.id("searchResultAvailabilityTextJobCard" + index);
        }

        /**
         * Locates an employer job view button for a given index
         *
         * @param index The index (Starting at 0) of the employer job view button you wish to locate
         * @return Returns a locator for the employer job view button by index
         */
        public By findEmployerJobCardViewBtnByIndex(String index) {
            return By.id("jobCardViewBtnJobCard" + index);
        }

        /**
         * Locates an employer job edit button for a given index
         *
         * @param index The index (Starting at 0) of the employer job edit button you wish to locate
         * @return Returns a locator for the employer job edit button by index
         */
        public By findEmployerJobCardEditBtnByIndex(String index) {
            return By.id("jobOpeningEditBtn" + index);
        }

        /**
         * Locates an employer job apply button for a given index
         *
         * @param index The index (Starting at 0) of the employer job apply button you wish to locate
         * @return Returns a locator for the employer job apply button by index
         */
        public By findEmployerJobCardApplyBtnByIndex(String index) {
            return By.id("searchResultApplyBtnJobCard" + index);
        }

        /**
         * Locates a job's employer logo for a given index
         *
         * @param index The index (Starting at 0) of the job's employer logo you wish to locate
         * @return Returns a locator for the job's employer logo by index
         */
        public By findEmployerJobCardLogoByIndex(String index) {
            return By.id("articleImgJobCard" + index + "ContainerImg");
        }

        /**
         * Locates a job's employer name for a given index
         *
         * @param index The index (Starting at 0) of the job's employer name you wish to locate
         * @return Returns a locator for the job's employer name by index
         */
        public By findEmployerJobCardNameByIndex(String index) {
            return By.id("JobCardStoreProfileEmployerNameTextJobCard" + index);
        }

        /**
         * Locates a job's employer address for a given index
         *
         * @param index
         * @return
         */
        public By findEmployerJobCardAddressByIndex(String index){
            return By.id("JobCardStoreProfileAddressTextJobCard" + index);

        }

    }

    public static class EmployerProfileEditInfoPageLocators {
        public By employerProfileEditInfoLogoLbl = By.id("editStoreInfoLogo");
        public By employerProfileEditInfoLogoImg = By.id("storeLogoImg");
        public By employerProfileEditInfoLogoUploadBtn = By.id("storeLogoUploadBtn");
        public By employerProfileEditInfoLogoEditBtn = By.id("storeLogoEditBtn");
        public By employerProfileEditInfoLogoTxt = By.id("storeLogoUploadHintEmbeddedTxt");
        public By employerProfileEditInfoNameField = By.id("storeLocationFormStoreName");
        public By employerProfileEditInfoAddress1Field = By.id("storeLocationFormAddress1");
        public By employerProfileEditInfoAddress2Field = By.id("storeLocationFormAddress2");
        public By employerProfileEditInfoCityField = By.id("storeLocationFormCity");
        public By employerProfileEditInfoStateTxt = By.id("storeLocationFormDropdownValueText");
        public By employerProfileEditInfoStateDropdownBtn = By.id("storeLocationFormDropdownDropDown");
        public By employerProfileEditInfoStateList = By.id("storeLocationFormDropdownDropDownList");

        /**
         * Locates a state for a given index
         *
         * @param index The index (Starting at 0) of the state you wish to locate
         * @return Returns a locator for the state by index
         */
        public By findEmployerStateByIndex(String index) {
            return By.id("storeLocationFormDropdownDropDownOption" + index);
        }

        public By employerProfileEditInfoZipField = By.id("storeLocationFormZipCode");
        public By employerProfileEditInfoPhoneField = By.id("storeLocationFormPhoneNumber");
        public By employerProfileEditInfoWebsiteField = By.id("storeLocationFormWebsite");
        public By employerProfileEditInfoSaveBtn = By.id("storeLocationFormSaveBtn");
        public By employerProfileEditInfoSaveBtnLoader = By.id("storeLocationFormSaveBtnLoader");
        public By employerProfileInfoSuccessToast = By.id("storeLocationFormToast");
        public By employerProfileInfoSuccessToastCloseBtn = By.id("storeLocationFormToastCloseIcon");
        public By employerProfileEditInfoTooltipTitle = By.id("storeInfoTitleTooltip");
        public By employerProfileEditInfoTooltipTxt = By.id("storeInfoDescriptionTooltip");
    }

    public static class EmployerProfileEditPhotosPageLocators {
        public By employerProfileEditPhotosTitleTxt = By.id("editPhotosTitle");
        public By employerProfileEditPhotosUploadBtn = By.id("storePhotosUploadBtn");
        public By employerProfilePhotosUploadLoadingIndicator = By.id("Loader");
        public By employerProfilePhotosDeleteLoadingIndicator = By.cssSelector("button#storePhotosDeletePhotosBtn>div.button-content>div.loader");
        public By employerProfileEditPhotosFileInput = By.cssSelector("div.dropzone>input");
        public By employerProfileEditPhotosDeletePhotosBtn = By.id("storePhotosDeletePhotosBtn");

        /**
         * Locates an employer photo for a given index
         *
         * @param index The index (Starting at 0) of the employer photo you wish to locate
         * @return Returns a locator for the employer photo by index
         */
        public By findEmployerPhotoByIndex(String index) {

            return By.id("storePhotosImageSelectBtn" + index);
        }

        public By employerProfileEditPhotosDeleteConfirmYesBtn = By.id("removeBtn");
        public By employerProfileEditPhotosDeleteConfirmCancelBtn = By.id("cancelBtn");
        public By employerProfileEditPhotosSuccessToast = By.id("storePhotosSelectionToast");
        public By employerProfileEditPhotosSuccessToastCloseBtn = By.id("storePhotosSelectionToastCloseBtn");
        public By employerProfileEditPhotoTooltipTitle = By.id("storeInfoTitleTooltip");
        public By employerProfileEditPhotoTooltipTxt = By.id("storeInfoDescriptionTooltip");
    }

    public static class EmployerProfileEditAboutPageLocators {
        public By employerProfileEditAboutTitleTxt = By.id("");
        public By employerProfileEditAboutField = By.id("editStoreAboutDescriptionTextArea");
        public By employerProfileEditAboutSaveBtn = By.id("editStoreAboutAddButton");
        public By employerProfileEditAboutSuccessToast = By.id("editStoreAboutSuccessToast");
        public By employerProfileEditAboutSuccessToastDismissBtn = By.id("editStoreAboutSuccessToastCloseBtn");
        public By employerProfileEditAboutTooltipTitle = By.id("storeAboutTitleTooltip");
        public By employerProfileEditAboutTooltipTxt = By.id("storeAboutDescriptionTooltip");
        public By employerProfileEditAboutSaveSpinner = By.id("editStoreAboutAddButtonLoader");
    }

    public static class EmployerProfileEditJobsPageLocators {

        public By employerProfileEditHiringAddNewJobBtn = By.id("addPosition");
        public By employerProfileEditHiringLoadingIndicator = By.id("storeManagersLoaderIcon");
        public By employerProfileEditHiringJobTypeInput = By.id("jobPostingAddJobTypeInput");

        /**
         * Locates an employer job type for a given index
         *
         * @param index The index (Starting at 0) of the employer job type you wish to locate
         * @return Returns a locator for the employer job type by index
         */
        public By findEmployerJobTypeByIndex(String index) {
            return By.id("jobPostingAddJobTypeOption" + index);
        }

        public By employerProfileEditHiringCustomJobNameField = By.id("jobPostingAddname");
        public By employerProfileEditHiringJobDescriptionField = By.id("jobPostingAddTxtAreadescription");
        public By employerProfileEditHiringJobResponsibilitiesField = By.id("jobPostingAddTxtArearesponsibilities");
        public By employerProfileEditHiringJobAgeRequirementChk = By.id("jobPostingAddChkageRequirementBox");

        /**
         * Locates a required skill by index
         *
         * @param index The index (Starting at 0) of the skill you wish to locate
         * @return A locator for a skill at the given index
         */
        public By findSkillByIndex(String index) {
            return By.id("jobPostingAddLabel" + index);
        }

        /**
         * Locates a required skill's selected state by index
         *
         * @param index The index (Starting at 0) of the skill you wish to locate
         * @return A locator for a skill's selected state at the given index
         */
        public By findSelectedSkillByIndex(String index) {
            return By.cssSelector("div#jobPostingAddLabel" + index + ".skill.selected");
        }

        /**
         * Locates a required certification by index
         *
         * @param index The index (Starting at 0) of the certification you wish to locate
         * @return A locator for a certification at the given index
         */
        public By findCertificationByIndex(String index) {
            return By.id("jobPostingAddChk" + index + "Box");
        }

        public By employerProfileEditHiringMinimumWageTxt = By.id("wageOption0");
        public By employerProfileEditHiringMinimumWageSlider = By.cssSelector("div.handle-0");
        public By employerProfileEditHiringMaximumWageTxt = By.id("wageOption1");
        public By employerProfileEditHiringMaximumWageSlider = By.cssSelector("div.handle-1");
        public By employerProfileEditHiringAvailabilityFTBtn = By.id("jobPostingAddFull-Time");
        public By employerProfileEditHiringAvailabilityPTBtn = By.id("jobPostingAddPart-Time");
        public By employerProfileEditHiringAvailabilitySeasonalBtn = By.id("jobPostingAddSeasonal");
        public By employerProfileEditHiringAvailabilityAnythingBtn = By.id("jobPostingAddAnything");
        public By employerProfileEditHiringShiftScheduleMorningsBtn = By.id("jobPostingAddCardMornings");
        public By employerProfileEditHiringShiftScheduleMorningsSelectedBtn = By.cssSelector("div#jobPostingAddCardMornings.selected");
        public By employerProfileEditHiringShiftScheduleAfternoonsBtn = By.id("jobPostingAddCardAfternoons");
        public By employerProfileEditHiringShiftScheduleAfternoonsSelectedBtn = By.cssSelector("div#jobPostingAddCardAfternoons.selected");
        public By employerProfileEditHiringShiftScheduleEveningsBtn = By.id("jobPostingAddCardEvenings");
        public By employerProfileEditHiringShiftScheduleEveningsSelectedBtn = By.cssSelector("div#jobPostingAddCardEvenings.selected");
        public By employerProfileEditHiringShiftScheduleNightsBtn = By.id("jobPostingAddCardNights");
        public By employerProfileEditHiringShiftScheduleNightsSelectedBtn = By.cssSelector("div#jobPostingAddCardNights.selected");
        public By employerProfileEditHiringSaveBtn = By.id("jobPostingAddSavePositionBtn");
        public By employerProfileEditHiringCancelBtn = By.id("jobPostingAddCancelBtn");
        public By employerProfileEditHiringDeleteBtn = By.id("jobPostingAddDeletePositionBtn");
        public By employerProfileEditHiringDeleteConfirmBtn = By.id("removeBtn");
        public By employerProfileEditHiringAddJobConfirmationToast = By.id("jobPostingAddToast");
        public By employerProfileEditHiringAddJobConfirmationToastDismissBtn = By.id("jobPostingAddToastCloseIcon");
    }

    public static class EmployerProfileStaffPageLocators {
        public By employerProfileEditStaffListLabelTxt = By.id("storeManagersLabelTxt");

        /**
         * Locates a staff avatar for a given index
         *
         * @param index The index (Starting at 0) of the staff avatar you wish to locate
         * @return Returns a locator for the staff avatar by index
         */
        public By findStaffAvatarByIndex(String index) {
            return By.id("managerListItem" + index + "OptionAvatar");
        }

        /**
         * Locates a staff name for a given index
         *
         * @param index The index (Starting at 0) of the staff name you wish to locate
         * @return Returns a locator for the staff name by index
         */
        public By findStaffNameByIndex(String index) {
            return By.id("managerListItem" + index + "UserNameTxt");
        }

        /**
         * Locates a staff added date for a given index
         *
         * @param index The index (Starting at 0) of the staff added date you wish to locate
         * @return Returns a locator for the staff added date by index
         */
        public By findStaffAddedDateByIndex(String index) {
            return By.id("managerListItem" + index + "SubTitleTxt");
        }

        /**
         * Locates a staff edit button for a given index
         *
         * @param index The index (Starting at 0) of the staff edit button you wish to locate
         * @return Returns a locator for the staff edit button by index
         */
        public By findStaffEditBtnByIndex(String index) {
            return By.id("managerListItem" + index + "EditBtn");
        }

        public By employerProfileEditStaffAddNewStaffBtn = By.id("addAdminBtn");
        public By employerProfileEditStaffAddNewStaffTxt = By.id("");
        public By employerProfileEditStaffTooltipTitleTxt = By.id("manageStoreTitleTooltip");
        public By employerProfileEditStaffTooltipTxt = By.id("manageStoreTitleTooltip");
        public By employerProfileEditStaffMemberLabelTxt = By.id("editStoreMemberstoreMemberLabelTxt");
        public By employerProfileEditStaffMemberAvatarImg = By.id("editStoreMemberListItemOptionAvatar");
        public By employerProfileEditStaffMemberNameTxt = By.id("editStoreMemberListItemOptionAvatar");
        public By employerProfileEditStaffMemberAddedDateTxt = By.id("editStoreMemberListItemSubTitleTxt");
        public By employerProfileEditStaffMemberDescriptionTxt = By.id("editStoreMemberDescriptionTextArea");
        public By employerProfileEditStaffMemberDisplayProfileChk = By.id("editStoreMemberCheckboxBox");
        public By employerProfileEditStaffMemberTooltipTitleTxt = By.id("manageStoreEditTitleTooltip");
        public By employerProfileEditStaffMemberTooltipTxt = By.id("manageStoreEditDescriptionTooltip");
        public By employerProfileEditStaffMemberRemoveConfirmationTitleTxt = By.id("editStoreMemberTitle");
        public By employerProfileEditStaffMemberRemoveConfirmationTxt = By.id("editStoreMemberText");
        public By employerProfileEditStaffMemberRemoveConfirmationRemoveBtn = By.id("removeStoreMemberBtn");
        public By employerProfileEditStaffMemberRemoveConfirmationCancelBtn = By.id("cancelRemoveStoreMemberBtn");
        public By getEmployerProfileEditStaffMemberRemoveSuccessToast = By.id("editStoreMemberToast");
        public By getEmployerProfileEditStaffMemberRemoveSuccessToastCloseBtn = By.id("editStoreMemberToastCloseBtn");
        public By employerProfileEditStaffInviteStaffLabelTxt = By.id("inviteStoreManagerLabelTxt");
        public By employerProfileEditStaffInviteStaffSearchField = By.id("inviteStoreManagerSearchUsersDropdownInput");

        /**
         * Locates a selected staff member to add for a given index
         *
         * @param index The index (Starting at 0) of the staff member to be added that you wish to locate
         * @return Returns a locator for the staff member to be added by index
         */
        public By findInviteStaffSelectionByIndex(String index) {
            return By.id("inviteStoreManagerSearchUsersDropdownValue" + index + "Label" + index);
        }

        /**
         * Locates a staff member search result to add for a given index
         *
         * @param index The index (Starting at 1) of the staff member search result that you wish to locate
         * @return Returns a locator for the staff member search result by index
         */
        public By findInviteStaffSearchResultByIndex(Integer index) {
            return By.cssSelector("div.select-advanced-dropdown-options-wrapper>div:nth-child" + "(" + index + ")>div#undefinedOptionAvatar");
        }

        public By employerProfileEditStaffInviteStaffAddBtn = By.id("inviteStoreManagersaveButton");
        public By employerProfileEditStaffInviteStaffSaveBtn = By.id("editStoreMemberAddButton");

        public By employerProfileEditStaffInviteStaffRemoveBtn = By.id("editStoreMemberremoveButton");
        public By employerProfileEditStaffInviteStaffAddedConfirmationTitleTxt = By.id("");
        public By employerProfileEditStaffInviteStaffAddedConfirmationTxt = By.id("editprofileManagementLink");
        public By employerProfileEditStaffInviteStaffAddedConfirmationBtn = By.id("inviteStoreManagerDoneButton");
        public By employerProfileEditStaffInviteStaffSaveBtnLoader = By.id("inviteStoreManagersaveButtonLoader");
        public By employerProfileEditStaffLoader = By.id("storeManagersLoaderIcon");
    }

    public static class EmployerProfileEditPageLocators {
        public By employerProfileEditInfoBtn = By.id("editprofileInfoLink");
        public By employerProfileEditPhotosBtn = By.id("editprofilePhotosLink");
        public By employerProfileEditAboutBtn = By.id("editprofileAboutMyStoreLink");
        public By employerProfileEditJobsBtn = By.id("editprofileHiringLink");
        public By employerProfileEditStaffBtn = By.id("editprofileTeamLink");
        public By employerProfileEditViewProfileBtn = By.id("editprofileViewProfileLink");
        public By employerProfileEditPageLoader = By.id("storeManagersLoaderIcon");
    }

    public static class EmployerDashPageLocators {
        public By employerDashTitleTxt = By.id("dashboardWelcomeText");
        public By employerDashLoader = By.id("managerDashboardLoader");
        public By employerDashApplicantsTitleTxt = By.id("applicantsTitleTxt");
        public By employerDashApplicantsLink = By.id("managerDashboardApplicantsLink");
        public By employerDashApplicantCardEmptyTitleTxt = By.id("emptyApplicantsCardTitleTxt");
        public By employerDashApplicantCardEmptyTxt = By.id("emptyApplicantsCardBodyTxt");
        public By employerDashApplicantCardEmptyJobsBtn = By.id("managerDashboardCreateJobBtn");
        public By employerDashApplicantCardEditStoreProfileBtn = By.id("managerDashboardEditProfileBtn");
        public By employerDashApplicantNextBtn = By.id("applicantNextBtn");

        /**
         * Locates an applicant card for a given index
         *
         * @param index The index (Starting at 0) of the applicant you wish to locate
         * @return Returns a locator for the applicant by index
         */
        public By findEmployerDashApplicantCardByIndex(String index) {
            return By.id("Applicant" + index + "Card");
        }

        /**
         * Locates an applicant card's photo for a given index
         *
         * @param index The index (Starting at 0) of the applicant's photo you wish to locate
         * @return Returns a locator for the applicant's photo by index
         */
        public By findEmployerDashApplicantCardPhotoByIndex(String index) {
            return By.id("Applicant" + index + "CardPlaceholderIcon");
        }

        /**
         * Locates an applicant card's name for a given index
         *
         * @param index The index (Starting at 0) of the applicant's name you wish to locate
         * @return Returns a locator for the applicant's name by index
         */
        public By findEmployerDashApplicantCardNameByIndex(String index) {
            return By.id("Applicant" + index + "CardUserName");
        }

        /**
         * Locates an applicant card's position for a given index
         *
         * @param index The index (Starting at 0) of the applicant's position you wish to locate
         * @return Returns a locator for the applicant's position by index
         */
        public By findEmployerDashApplicantCardPositionByIndex(String index) {
            return By.id("Applicant" + index + "CardUserPosition");
        }

        /**
         * Locates an applicant card's time for a given index
         *
         * @param index The index (Starting at 0) of the applicant's time you wish to locate
         * @return Returns a locator for the applicant's time by index
         */
        public By findEmployerDashApplicantCardTimeByIndex(String index) {
            return By.id("Applicant" + index + "CardUserTimeAppliedAgo");
        }

        /**
         * Locates an applicant card's shared connections for a given index
         *
         * @param index The index (Starting at 0) of the applicant's shared connections you wish to locate
         * @return Returns a locator for the applicant's shared connections by index
         */
        public By findEmployerDashApplicantCardSharedConnectionsByIndex(String index) {
            return By.id("Applicant" + index + "CardUserSharedConnections");
        }

        /**
         * Locates an applicant card's view profile button for a given index
         *
         * @param index The index (Starting at 0) of the applicant's view profile button you wish to locate
         * @return Returns a locator for the applicant's view profile button by index
         */
        public By findEmployerDashApplicantCardViewProfileBtnByIndex(String index) {
            return By.id("Applicant" + index + "ViewApplicantBtn");
        }

        /**
         * Locates an applicant card's action button for a given index
         *
         * @param index The index (Starting at 0) of the applicant's action button you wish to locate
         * @return Returns a locator for the applicant's action button by index
         */
        public By findEmployerDashApplicantCardActionsBtnByIndex(String index) {
            return By.id("Applicant" + index + "MenuTriggerBtn");
        }

        /**
         * Locates an applicant card's interview button for a given index
         *
         * @param index The index (Starting at 0) of the applicant's interview button you wish to locate
         * @return Returns a locator for the applicant's interview button by index
         */
        public By findEmployerDashApplicantCardActionsInterviewByIndex(String index) {
            return By.id("Applicant" + index + "InterviewApplicantBtn");
        }

        /**
         * Locates an applicant card's good fit button for a given index
         *
         * @param index The index (Starting at 0) of the applicant's good fit button you wish to locate
         * @return Returns a locator for the applicant's good fit button by index
         */
        public By findEmployerDashApplicantCardActionsGoodFitByIndex(String index) {
            return By.id("Applicant" + index + "GoodFitBtn");
        }

        /**
         * Locates an applicant card's !good fit button for a given index
         *
         * @param index The index (Starting at 0) of the applicant's !good fit button you wish to locate
         * @return Returns a locator for the applicant's !good fit button by index
         */
        public By findEmployerDashApplicantCardActionsBadFitByIndex(String index) {
            return By.id("Applicant" + index + "NotAFitBtn");
        }

        /**
         * Locates an applicant card's message button for a given index
         *
         * @param index The index (Starting at 0) of the applicant's message button you wish to locate
         * @return Returns a locator for the applicant's message button by index
         */
        public By findEmployerDashApplicantCardActionsMessageByIndex(String index) {
            return By.id("Applicant" +index + "MessageBtn");
        }

        /**
         * Locates an applicant success toast for a given index
         *
         * @param index The index (Starting at 0) of the applicant success toast
         * @return Returns a locator for the applicant success toast
         */
        public By findEmployerDashApplicantSuccessToastByIndex(String index) {
            return By.id("Applicant" +index + "Toast");
        }

        /**
         * Locates an applicant success toast close button for a given index
         *
         * @param index The index (Starting at 0) of the applicant success toast close button
         * @return Returns a locator for the applicant success toast close button
         */
        public By findEmployerDashApplicantSuccessToastCloseBtnByIndex(String index) {
            return By.id("Applicant" +index + "ToastCloseBtn");
        }

        public By employerDashTalentTitleTxt = By.id("talentTitleTxt");
        public By employerDashTalentLink = By.id("managerDashboardFindTalentLink");
        public By employerDashTalentCardEmptyTitleTxt = By.id("emptyTalentCardTitleTxt");
        public By employerDashTalentCardEmptyTxt = By.id("emptyTalentCardBodyTxt");
        public By employerDashTalentCardPostJobBtn = By.id("managerDashboardPostJobBtn");
        public By employerDashTalentNextBtn = By.id("talentNextBtn");

        /**
         * Locates a talent card for a given index
         *
         * @param index The index (Starting at 0) of the talent you wish to locate
         * @return Returns a locator for the talent by index
         */
        public By findEmployerDashTalentCardByIndex(String index) {
            return By.id("Talent" + index + "Card");
        }

        /**
         * Locates a talent card's photo for a given index
         *
         * @param index The index (Starting at 0) of the talent's photo you wish to locate
         * @return Returns a locator for the talent's photo by index
         */
        public By findEmployerDashTalentCardPhotoByIndex(String index) {
            return By.id("Talent" + index + "CardPlaceholderIcon");
        }

        /**
         * Locates a talent card's name for a given index
         *
         * @param index The index (Starting at 0) of the talent's name you wish to locate
         * @return Returns a locator for the talent's name by index
         */
        public By findEmployerDashTalentCardNameByIndex(String index) {
            return By.id("Talent" + index + "CardUserName");
        }

        /**
         * Locates a talent card's position for a given index
         *
         * @param index The index (Starting at 0) of the talent's position you wish to locate
         * @return Returns a locator for the talent's position by index
         */
        public By findEmployerDashTalentCardPositionByIndex(String index) {
            return By.id("Talent" + index + "CardUserPosition");
        }

        /**
         * Locates an talent card's view profile button for a given index
         *
         * @param index The index (Starting at 0) of the talent's view profile button you wish to locate
         * @return Returns a locator for the talent's view profile button by index
         */
        public By findEmployerDashTalentCardViewProfileByIndex(String index) {
            return By.id("Talent" + index + "ViewProfileBtn");
        }

        /**
         * Locates an talent card's action button for a given index
         *
         * @param index The index (Starting at 0) of the talent's action button you wish to locate
         * @return Returns a locator for the talent's action button by index
         */
        public By findEmployerDashTalentCardActionsByIndex(String index) {
            return By.id("Talent" + index + "MenuTriggerBtn");
        }

        /**
         * Locates an talent card's invite button for a given index
         *
         * @param index The index (Starting at 0) of the applicant's invite button you wish to locate
         * @return Returns a locator for the applicant's invite button by index
         */
        public By findEmployerDashTalentCardActionsInviteByIndex(String index) {
            return By.id("Talent" + index + "InviteToApplyBtn");
        }

        /**
         * Locates an talent card's good fit button for a given index
         *
         * @param index The index (Starting at 0) of the talent's good fit button you wish to locate
         * @return Returns a locator for the talent's good fit button by index
         */
        public By findEmployerDashTalentCardActionsGoodFitByIndex(String index) {
            return By.id("Talent" + index + "GoodFitBtn");
        }

        /**
         * Locates an talent card's !good fit button for a given index
         *
         * @param index The index (Starting at 0) of the talent's !good fit button you wish to locate
         * @return Returns a locator for the talent's !good fit button by index
         */
        public By findEmployerDashTalentCardActionsBadFitByIndex(String index) {
            return By.id("Talent" + index + "NotAFitBtn");
        }

        /**
         * Locates an talent success toast for a given index
         *
         * @param index The index (Starting at 0) of the talent success toast
         * @return Returns a locator for the talent success toast
         */
        public By findEmployerDashTalentSuccessToastByIndex(String index) {
            return By.id("Talent" +index + "Toast");
        }

        /**
         * Locates an applicant success toast close button for a given index
         *
         * @param index The index (Starting at 0) of the talent success toast close button
         * @return Returns a locator for the talent success toast close button
         */
        public By findEmployerDashTalentSuccessToastCloseBtnByIndex(String index) {
            return By.id("Talent" +index + "ToastCloseBtn");
        }

        public By employerJobsTitleTxt = By.id("jobsTitleTxt");
        public By employerDashJobsViewLink = By.id("managerDashboardJobsLink");
        public By employerDashJobsCardEmptyTitleTxt = By.id("emptyJobCardBodyTxt");
        //public By employerDashJobsCardEmptyTxt = By.id("emptyJobCardBodyTxt");
        public By employerDashJobsCardPostJobBtn = By.id("managerDashboardCreateJobBtn");
        public By employerDashJobsNextBtn = By.id("jobPositionNextBtn");

        /**
         * Locates an employer job position for a given index
         *
         * @param index The index (Starting at 0) of the employer job position you wish to locate
         * @return Returns a locator for the employer job position by index
         */
        public By findEmployerJobCardPositionByIndex(String index) {
            return By.id("jobCardJobNameTextJobCard" + index);
        }

        /**
         * Locates an employer job wage for a given index
         *
         * @param index The index (Starting at 0) of the employer job wage you wish to locate
         * @return Returns a locator for the employer job wage by index
         */
        public By findEmployerJobCardWageByIndex(String index) {
            return By.id("searchResultWageTextJobCard" + index);
        }

        /**
         * Locates an employer job availability for a given index
         *
         * @param index The index (Starting at 0) of the employer job availability you wish to locate
         * @return Returns a locator for the employer job availability by index
         */
        public By findEmployerJobCardAvailabilityByIndex(String index) {
            return By.id("searchResultAvailabilityTextJobCard" + index);
        }

        /**
         * Locates an employer job view button for a given index
         *
         * @param index The index (Starting at 0) of the employer job view button you wish to locate
         * @return Returns a locator for the employer job view button by index
         */
        public By findEmployerJobCardGetReferralsBtnByIndex(String index) {
            return By.id("managerDashboardRequestReferralBtn" + index);
        }

        /**
         * Locates an employer job edit button for a given index
         *
         * @param index The index (Starting at 0) of the employer job edit button you wish to locate
         * @return Returns a locator for the employer job edit button by index
         */
        public By findEmployerJobCardEditBtnByIndex(String index) {
            return By.id("managerDashboardEditBtn" + index);
        }

        /**
         * Locates a job's employer logo for a given index
         *
         * @param index The index (Starting at 0) of the job's employer logo you wish to locate
         * @return Returns a locator for the job's employer logo by index
         */
        public By findEmployerJobCardLogoByIndex(String index) {
            return By.id("articleImgJobCard" + index + "ContainerImg");
        }

        /**
         * Locates a job's employer name for a given index
         *
         * @param index The index (Starting at 0) of the job's employer name you wish to locate
         * @return Returns a locator for the job's employer name by index
         */
        public By findEmployerJobCardNameAndAddressByIndex(String index) {
            return By.id("jobCardEmployerNameAndLocationTextJobCard" + index);
        }

        /**
         * Locates a Job Card's Job Name field
         * @param index
         * @return
         */
        public By findEmployerJobCardJobNameByIndex(String index){
            return By.id("jobCardJobNameTextJobCard" + index);
        }
    }

    public static class EmployerTalentPageLocators {

        /* Global */
        public By employerTalentLoader = By.cssSelector("div.spinner.active");
        public By employerTalentInviteLoader = By.cssSelector("button#inviteBtn>div.button-content.loading");

        /* Talent tab navigation */
        public By employerTalentAllBtn = By.id("allTalentTab");
        public By employerTalentGoodBtn = By.id("potentialTab");
        public By employerTalentInviteBtn = By.id("inviteToApplyTab");
        public By employerTalentAppliantsBtn = By.id("applicantTab");
        public By employerTalentBadBtn = By.id("archivedTab");
        public By employerTalentInterrviewsBtn = By.id("interviewScheduledTab");

        /* Talent availability filter */
        public By employerTalentAvailabilityDropdownBtn = By.id("filterAvailabilityDropDown");
        public By employerTalentAvailabilityFilterAnythingBtn = By.id("AnythingCheckboxBox");
        public By employerTalentAvailabilityFilterFullTimeBtn = By.id("Full-TimeCheckboxBox");
        public By employerTalentAvailabilityFilterPartTimeBtn = By.id("Part-TimeCheckboxBox");
        public By employerTalentAvailabilityFilterSeasonalBtn = By.id("SeasonalCheckboxBox");
        public By employerTalentAvailabilityDaypartFilterMorningsBtn = By.id("MorningsCheckboxBox");
        public By employerTalentAvailabilityDaypartFilterAfternoonsBtn = By.id("AfternoonsCheckboxBox");
        public By employerTalentAvailabilityDaypartFilterEveningsBtn = By.id("EveningsCheckboxBox");
        public By employerTalentAvailabilityDaypartFilterNightsBtn = By.id("Late NightCheckboxBox");

        /* Empty State */
        public By employerTalentAllEmptyTitleTxt = By.id("FindTalentEmptySearchTextTitle");
        public By employerTalentAllEmptyTxt = By.id("FindTalentEmptySearchTextContent");
        public By employerTalentGoodEmptyTitleTxt = By.id("FindTalentEmptySearchTextTitle");
        public By employerTalentGoodEmptyTxt = By.id("FindTalentEmptySearchTextContent");
        public By employerTalentInvitedEmptyTitleTxt = By.id("FindTalentEmptySearchTextTitle");
        public By employerTalentInvitedEmptyTxt = By.id("FindTalentEmptySearchTextContent");
        public By employerTalentApplicantsEmptyTitleTxt = By.id("FindTalentEmptySearchTextTitle");
        public By employerTalentApplicantsEmptyTxt = By.id("FindTalentEmptySearchTextContent");
        public By employerTalentBadEmptyTitleTxt = By.id("FindTalentEmptySearchTextTitle");
        public By employerTalentBadEmptyTxt = By.id("FindTalentEmptySearchTextContent");

        /* Talent */
        public By employerTalentAllTitleTxt = By.cssSelector("div.h2.job-position-selection>span");
        public By employerTalentGoodTitleTxt = By.cssSelector("div.h2.job-position-selection>span");
        public By employerTalentInvitedTitleTxt = By.cssSelector("div.h2.job-position-selection>span");
        public By employerTalentApplicantsTitleTxt = By.cssSelector("div.h2.job-position-selection>span");
        public By employerTalentBadTitleTxt = By.cssSelector("div.h2.job-position-selection>span");

        /**
         * Locates a talent card for a given index
         *
         * @param index The index (Starting at 0) of the talent you wish to locate
         * @return Returns a locator for the talent by index
         */
        public By findEmployerTalentCardByIndex(String index) {
            return By.id("Talent" + index + "Card");
        }

        /**
         * Locates a talent card's photo for a given index
         *
         * @param index The index (Starting at 0) of the talent's photo you wish to locate
         * @return Returns a locator for the talent's photo by index
         */
        public By findEmployerTalentCardPhotoByIndex(String index) {
            return By.id("Talent" + index + "CardPlaceholderIcon");
        }

        /**
         * Locates a talent card's name for a given index
         *
         * @param index The index (Starting at 0) of the talent's name you wish to locate
         * @return Returns a locator for the talent's name by index
         */
        public By findEmployerTalentCardNameByIndex(String index) {
            return By.id("Talent" + index + "CardUserName");
        }

        /**
         * Locates a talent card's user location for a given index
         *
         * @param index The index (Starting at 0) of the talent's location you wish to locate
         * @return Returns a locator for the talent's location by index
         */
        public By findEmployerTalentCardLocationByIndex(String index) {
            return By.id("Talent" + index + "CardUserLocation");
        }

        /**
         * Locates a talent card's position for a given index
         *
         * @param index The index (Starting at 0) of the talent's position you wish to locate
         * @return Returns a locator for the talent's position by index
         */
        public By findEmployerTalentCardPositionByIndex(String index) {
            return By.id("Talent" + index + "CardUserPosition");
        }

        /**
         * Locates a talent card's shared connections for a given index
         *
         * @param index The index (Starting at 0) of the talent's shared connections you wish to locate
         * @return Returns a locator for the talent's shared connections by index
         */
        public By findEmployerTalentCardSharedConnectionsByIndex(String index) {
            return By.id("Talent" + index + "CardUserSharedConnections");
        }

        /**
         * Locates a talent card's view profile button for a given index
         *
         * @param index The index (Starting at 0) of the talent's view profile button you wish to locate
         * @return Returns a locator for the talent's view profile button by index
         */
        public By findEmployerTalentCardViewProfileByIndex(String index) {
            return By.id("Talent" + index + "ViewProfileBtn");
        }

        /**
         * Locates a talent card's action button for a given index
         *
         * @param index The index (Starting at 0) of the talent's action button you wish to locate
         * @return Returns a locator for the talent's action button by index
         */
        public By findEmployerTalentCardActionsByIndex(String index) {
            return By.id("Talent" + index + "ConnectBtn");
        }

        /**
         * Locates a talent card's invite button for a given index
         *
         * @param index The index (Starting at 0) of the applicant's invite button you wish to locate
         * @return Returns a locator for the applicant's invite button by index
         */
        public By findEmployerTalentCardActionsInviteByIndex(String index) {
            return By.id("Talent" + index + "InviteToApplyBtn");
        }

        public By employerTalentInviteTitleTxt = By.id("CandidateInviteToApplyDialogInviteToApplyDialogTitle");
        public By employerTalentInviteSelectPositionBtn = By.id("CandidateInviteToApplyDialogJobPositionSelectDropDown");

        /**
         * Locates a position for the invite for a given index
         *
         * @param index The index (Starting at 0) of the position to invite you wish to locate
         * @return Returns a locator for the position to invite by index
         */
        public By findEmployerTalentInvitePositionByIndex(String index) {
            return By.id("CandidateInviteToApplyDialogJobPositionSelectDropDownOption" + index);
        }

        public By employerTalentInviteModalPositionTxt = By.id("CandidateInviteToApplyDialogJobPositionSelectValueText");
        public By employerTalentInviteModalMessageTxt = By.id("CandidateInviteToApplyDialogInviteMessage");
        public By employerTalentInviteModalSendBtn = By.id("inviteBtn");
        public By employerTalentInviteModalCancelBtn = By.id("cancelBtn");
        public By employerTalentInvitedModalTitleTxt = By.id("CandidateInviteToApplyDialogInviteToApplyDialogTitle");
        public By employerTalentInvitedModalTxt = By.id("CandidateInviteToApplyDialogInviteToApplyDialogText");
        public By employerTalentInvitedModalDoneBtn = By.id("inviteBtn");
        public By employerTalentInvitedModalCloseBtn = By.id("CandidateInviteToApplyDialogInviteToApplyDialogDialogCloseBtn");

        /**
         * Locates a talent card's good fit button for a given index
         *
         * @param index The index (Starting at 0) of the talent's good fit button you wish to locate
         * @return Returns a locator for the talent's good fit button by index
         */
        public By findEmployerTalentCardActionsGoodFitByIndex(String index) {
            return By.id("Talent" + index + "GoodFitBtn");
        }

        /**
         * Locates a talent card's !good fit button for a given index
         *
         * @param index The index (Starting at 0) of the talent's !good fit button you wish to locate
         * @return Returns a locator for the talent's !good fit button by index
         */
        public By findEmployerTalentCardActionsBadFitByIndex(String index) {
            return By.id("Talent" + index + "NotAFitBtn");
        }

        /**
         * Locates a talent success toast for a given index
         *
         * @param index The index (Starting at 0) of the talent success toast
         * @return Returns a locator for the talent success toast
         */
        public By findEmployerTalentSuccessToastByIndex(String index) {
            return By.id("Talent" +index + "Toast");
        }

        /**
         * Locates a talent success toast close button for a given index
         *
         * @param index The index (Starting at 0) of the talent success toast close button
         * @return Returns a locator for the talent success toast close button
         */
        public By findEmployerTalentSuccessToastCloseBtnByIndex(String index) {
            return By.id("Talent" +index + "ToastCloseBtn");
        }

        /* Applicants */

        /**
         * Locates an applicant card for a given index
         *
         * @param index The index (Starting at 0) of the applicant you wish to locate
         * @return Returns a locator for the applicant by index
         */
        public By findEmployerApplicantCardByIndex(String index) {

            return By.id("Applicant" + index + "Card");
        }

        /**
         * Locates an applicant card's photo for a given index
         *
         * @param index The index (Starting at 0) of the applicant's photo you wish to locate
         * @return Returns a locator for the applicant's photo by index
         */
        public By findEmployerApplicantCardPhotoByIndex(String index) {
            return By.id("Applicant" + index + "CardPlaceholderIcon");
        }

        /**
         * Locates an applicant card's name for a given index
         *
         * @param index The index (Starting at 0) of the applicant's name you wish to locate
         * @return Returns a locator for the applicant's name by index
         */
        public By findEmployerApplicantCardNameByIndex(String index) {
            return By.id("Applicant" + index + "CardUserName");
        }

        /**
         * Locates an applicant card's position for a given index
         *
         * @param index The index (Starting at 0) of the applicant's position you wish to locate
         * @return Returns a locator for the applicant's position by index
         */
        public By findEmployerApplicantCardPositionByIndex(String index) {
            return By.id("Applicant" + index + "CardUserPosition");
        }

        /**
         * Locates an applicant card's applied time ago for a given index
         *
         * @param index The index (Starting at 0) of the applicant's applied time ago you wish to locate
         * @return Returns a locator for the applicant's applied time ago by index
         */
        public By findEmployerApplicantCardAppliedTimeAgoByIndex(String index) {
            return By.id("Applicant" + index + "CardUserTimeAppliedAgo");
        }

        /**
         * Locates an applicant card's view profile button for a given index
         *
         * @param index The index (Starting at 0) of the applicant's view profile button you wish to locate
         * @return Returns a locator for the applicant's view profile button by index
         */
        public By findEmployerApplicantCardViewProfileByIndex(String index) {
            return By.id("Applicant" + index + "ViewProfileBtn");
        }

        /**
         * Locates an applicant card's action button for a given index
         *
         * @param index The index (Starting at 0) of the applicant's action button you wish to locate
         * @return Returns a locator for the applicant's action button by index
         */
        public By findEmployerApplicantCardActionsByIndex(String index) {
            return By.id("Applicant" + index + "MenuTriggerBtn");
        }

        /**
         * Locates an talent card's action button for a given index
         *
         * @param index The index (Starting at 0) of the talent's action button you wish to locate
         * @return Returns a locator for the talent's action button by index
         */
        public By findTalentCardActionBtnByIndex(String index) {
            return By.id("Talent" + index + "MenuTriggerBtn");
        }

        /**
         * Locates an applicant card's invite button for a given index
         *
         * @param index The index (Starting at 0) of the applicant's invite button you wish to locate
         * @return Returns a locator for the applicant's invite button by index
         */
        public By findEmployerApplicantCardActionsMessageByIndex(String index) {
            return By.id("Applicant" + index + "MessageBtn");
        }

        /**
         * Locates an applicant card's good fit button for a given index
         *
         * @param index The index (Starting at 0) of the applicant's good fit button you wish to locate
         * @return Returns a locator for the applicant's good fit button by index
         */
        public By findEmployerApplicantCardActionsGoodFitByIndex(String index) {
            return By.id("Applicant" + index + "GoodFitBtn");
        }

        /**
         * Locates an applicant card's !good fit button for a given index
         *
         * @param index The index (Starting at 0) of the talent's !good fit button you wish to locate
         * @return Returns a locator for the talent's !good fit button by index
         */
        public By findEmployerApplicantCardActionsBadFitByIndex(String index) {
            return By.id("Applicant" + index + "NotAFitBtn");
        }

        /**
         * Locates an applicant card's schedule interview button for a given index
         *
         * @param index The index (Starting at 0) of the applicant's schedule interview button you wish to locate
         * @return Returns a locator for the applicant's schedule interview button by index
         */
        public By findEmployerApplicantCardActionsScheduleInterviewByIndex(String index) {
            return By.id("Applicant" + index + "ScheduleInterviewBtn");
        }

        /**
         * Locates an applicant card's shared connections for a given index
         *
         * @param index The index (Starting at 0) of the applicant's shared connections you wish to locate
         * @return Returns a locator for the applicant's shared connections by index
         */
        public By findEmployerApplicantCardSharedConnectionsByIndex(String index) {
            return By.id("Applicant" + index + "CardUserSharedConnections");
        }

        /**
         * Locates an applicant success toast for a given index
         *
         * @param index The index (Starting at 0) of the applicant success toast
         * @return Returns a locator for the applicant success toast
         */
        public By findEmployerApplicantSuccessToastByIndex(String index) {
            return By.id("Applicant" +index + "Toast");
        }

        /**
         * Locates an applicant success toast close button for a given index
         *
         * @param index The index (Starting at 0) of the talent success toast close button
         * @return Returns a locator for the talent success toast close button
         */
        public By findEmployerApplicantSuccessToastCloseBtnByIndex(String index) {
            return By.id("Applicant" +index + "ToastCloseBtn");
        }

        public By employerAddAvailabilityBtn = By.id("availabilityBtnIcon");
        public By employerAddAvailabilityModal = By.id("interviewSchedulerAvailabilityDialogBasicDialog");
        public By calendarTodayBtn = By.id("todayBtn");
        public By calendarBackBtn = By.id("calendarToolbarBackBtn");
        public By calendarNextBtn = By.id("calendarToolbarNextBtn");
        public By calendarWeekRangeTxt = By.id("weekRangeTxt");
        public By dayOfMonthTxt = By.id("day0OfMonthTxt");
        /* https://stackoverflow.com/questions/13133738/multiple-buttons-with-same-type-and-id?utm_medium=organic&utm_source=google_rich_qa&utm_campaign=google_rich_qa */
        public By availabilityDialogTitle = By.id("interviewSchedulerAvailabilityDialogTitle");
        public By availabilityDialogTxt = By.id("interviewSchedulerAvailabilityDialogText");
        public By interviewSchedulercurrentDate = By.id("interviewSchedulercurrentDate");
        public By interviewSchedulercurrentMonthTxt = By.id("availabilityModalToolbarCurrentMonthTxt");
        public By day0OfWeekTxt = By.id("availabilityModalToolbarDay0OfWeekTxt");
        public By day1OfWeekTxt = By.id("availabilityModalToolbarDay1OfWeekTxt");
        public By day2OfWeekTxt = By.id("availabilityModalToolbarDay2OfWeekTxt");
        public By day3OfWeekTxt = By.id("availabilityModalToolbarDay3OfWeekTxt");
        public By day4OfWeekTxt = By.id("availabilityModalToolbarDay4OfWeekTxt");
        public By day5OfWeekTxt = By.id("availabilityModalToolbarDay5OfWeekTxt");
        public By day6OfWeekTxt = By.id("availabilityModalToolbarDay6OfWeekTxt");
        public By interviewScheduledHint = By.id("interviewScheduledHint");
        public By saveScheduleBtn = By.id("primaryBtn");
        public By cancelScheduleBtn = By.id("secondaryBtn");
        public By availabilityDialogCloseBtn = By.id("interviewSchedulerAvailabilityDialogDialogCloseBtn");
        public By availabilityDialogTimeSlot1 = By.id("availabilityModalTimeSlot15");
        public By availabilityDialogTimeSlot2 = By.id("availabilityModalTimeSlot16");
        public By updatedAvailabilitySuccessDialog = By.id("UpdatedAvailabilitySuccessDialogBasicDialog");
        public By successDialogSuccessIcon = By.id("UpdatedAvailabilitySuccessDialogSuccessIcon");
        public By successDialogTitle = By.id("UpdatedAvailabilitySuccessDialogTitle");
        public By successDialogTxt = By.id("UpdatedAvailabilitySuccessDialogText");
        public By dismissAvailabilitySuccessDialogBtn = By.id("dismissBtn");
        public By successDialogCloseBtn = By.id("UpdatedAvailabilitySuccessDialogDialogCloseBtn");
        public By calendarCellEmptyTimeSlot = By.xpath("//div[@class='rbc-time-slot day-6-timeslot-17']");
        public By calendarCellFilledTimeSlot = By.xpath("//div[contains(@class,\"available\")]");
        public By calendarCellUpdatedFilledTimeSlot = By.xpath("//div[contains(@class,\"available\")]");
        public By cancelAvailabilityChangesDialog = By.id("cancelAvailabilityChangesDialogBasicDialog");
        public By cancelAvailabilityChangesTitleDialog = By.id("cancelAvailabilityChangesDialogTitle");
        public By cancelAvailabilityChangesTxtDialog = By.id("cancelAvailabilityChangesDialogText");
        public By cancelAvailabilityChangesBackBtn = By.id("backBtn");
        public By cancelAvailabilityChangesDiscardBtn = By.id("discardBtn");
        public By inviteToInterviewMessageTextArea = By.id("inviteToInterviewMessageTextArea");
        public By sendInviteToInterviewBtn = By.id("primaryBtn");
        public By cancelInviteToInterviewBtn = By.id("secondaryBtn");
        public By inviteToInterviewSuccessDialog = By.id("inviteToInterviewSuccessDialogBasicDialog");
        public By dismissInviteToInterviewSuccessDialogBtn = By.id("dismissBtn");
        public By messageScheduleInterviewStatus = By.xpath("//p [contains(@class,\"interview-status-message\")]");
        public By messageScheduleInterviewMesssageThread = By.xpath("//div [contains(@class,\"messages-item-text\")]");
        public By messageThreadScheduleInterviewCard = By.xpath("//*[contains(@id,\"messageThreadWdgMessageScheduleInterview\")]");
        public By messageThreadScheduleInterviewContentMsg = By.xpath("//div[contains(@class,\"message-content action-button-displayed\")]/div");
        //public By messageThreadScheduleInterviewBtn = By.xpath("//*[contains(@id,\"chatCardActionScheduleInterviewBtn\") and not(@disabled)]");
        public By messageThreadScheduleInterviewBtn = By.xpath("//*[contains(@id,\"chatCardActionScheduleInterviewBtn\")]");
        public By messageThreadChooseNewTimeBtn = By.xpath("//*[contains(@id,\"chatCardActionChooseNewTimeBtn\")]");
        public By inviteToInterviewAvailabilityDialogTitle = By.id("inviteToInterviewAvailabilityDialogTitle");
        public By inviteToInterviewcurrentDate = By.id("inviteToInterviewcurrentDate");
        public By availabilityModalToolbarToolbarPrevBtn = By.id("availabilityModalToolbarToolbarPrevBtn");
        public By availabilityModalToolbarToolbarNextBtn = By.id("availabilityModalToolbarToolbarNextBtn");
        public By inviteToInterviewAvailabilityDialogSelectedDay = By.xpath("//div[@class='day-selector d-flex flex-column align-items-center selected']/span[1]");
        public By availabilityModalToolbarCurrentMonthTxt = By.id("availabilityModalToolbarCurrentMonthTxt");
        public By availableTimesHintTxt = By.id("availableTimesHintTxt");
        public By notAvailableHintTxt = By.id("notAvailableHintTxt");
        public By confirmInterviewBtn = By.id("primaryBtn");
        public By requestNewTimesBtn = By.id("secondaryBtn");
        public By inviteToInterviewInviteSuccessDialogSuccessIcon = By.id("inviteToInterviewInviteSuccessDialogSuccessIcon");
        public By inviteToInterviewInviteSuccessDialogBasicDialog = By.id("inviteToInterviewInviteSuccessDialogBasicDialog");
        public By inviteToInterviewInviteSuccessDialogTitle = By.id("inviteToInterviewInviteSuccessDialogTitle");
        public By inviteToInterviewInviteSuccessDialogText = By.id("inviteToInterviewInviteSuccessDialogText");
        public By viewDetailsBtn = By.id("viewDetailsBtn");
        public By messageThreadInterviewReminderEmployerDialog = By.id("messageThreadWdgMessageInterviewReminderEmployerInterviewDialogBasicDialog");
        public By messageThreadInterviewReminderEmployerDialogTitle = By.id("messageThreadWdgMessageInterviewReminderEmployerInterviewDialogTitle");
        public By messageThreadInterviewReminderEmployerNameTxt = By.id("messageThreadWdgMessageInterviewReminderEmployerNameTxt");
        public By messageThreadWdgInterviewReminderLogo = By.id("messageThreadWdgMessageInterviewReminderLogo");
        public By messageThreadInterviewReminderEmployerTypeTxt = By.id("messageThreadWdgMessageInterviewReminderEmployerTypeTxt");
        public By messageThreadInterviewReminderLocationTxt = By.id("messageThreadWdgMessageInterviewReminderLocationTxt");
        public By messageThreadInterviewReminderLocationPin = By.id("messageThreadWdgMessageInterviewReminderGoogleMapsLink");
        public By messageThreadInterviewReminderDateTxt = By.id("messageThreadWdgMessageInterviewReminderdateTxt");
        public By inviteToInterviewDetailsDialog = By.id("inviteToInterviewEmployerInterviewDialogBasicDialog");
        public By inviteToInterviewDetailsDialogTitle = By.id("inviteToInterviewEmployerInterviewDialogTitle");
        public By inviteToInterviewDetailsEmployerNameTxt = By.id("inviteToInterviewEmployerNameTxt");
        public By inviteToInterviewDetailsLogo = By.id("inviteToInterviewLogo");
        public By inviteToInterviewDetailsEmployerTypeTxt = By.id("inviteToInterviewEmployerTypeTxt");
        public By inviteToInterviewDetailsLocationTxt = By.id("inviteToInterviewLocationTxt");
        public By inviteToInterviewDetailsLocationPin = By.id("inviteToInterviewGoogleMapsLink");
        public By inviteToInterviewDetailsDateTxt = By.id("inviteToInterviewdateTxt");
        public By inviteToInterviewDetailsCloseBtnDialog = By.id("inviteToInterviewEmployerInterviewDialogDialogCloseBtn");
        public By rescheduleInterviewBtn = By.id("rescheduleBtn");
        public By cancelInterviewBtn = By.id("cancelBtn");
        public By messageThreadWdgMessageInterviewReminder = By.xpath("//div [contains(@id,\"messageThreadWdgMessageInterviewReminder\")]");
        public By calendarInterviewCard = By.xpath("//div [contains(@class,\"wrapper interview\")]");
        public By calendarPendingInterviewCard = By.xpath("//div [contains(@class,\"wrapper interview pending\")]");
        public By applicantNameTxt = By.id("applicantNameTxt");
        public By applicantPositionTxt = By.id("applicantPositionTxt");
        public By applicantImg = By.id("applicantImg");
        public By messageThreadInterviewReminderDialogCloseBtn = By.id("messageThreadWdgMessageInterviewReminderEmployerInterviewDialogDialogCloseBtn");
        public By messageThreadInterviewReminderEmployerInterviewDialog= By.id("messageThreadWdgMessageInterviewReminderinterviewDialogBasicDialog");
        public By messageThreadInterviewReminderEmployerInterviewDialogTitle = By.id("messageThreadWdgMessageInterviewReminderinterviewDialogTitle");
        public By messageThreadWdgMessageInterviewReminderApplicantTxt = By.id("messageThreadWdgMessageInterviewReminderApplicantTxt");
        public By messageThreadWdgMessageInterviewReminderApplicantPosition = By.id("messageThreadWdgMessageInterviewReminderCurrentPositionTxt");
        public By messageThreadWdgMessageInterviewReminderavatarIcon = By.id("messageThreadWdgMessageInterviewReminderavatar");
        public By messageThreadWdgMessageInterviewReminderDateTxt = By.id("messageThreadWdgMessageInterviewReminderdateTxt");
        public By messageThreadInterviewReminderViewProfileBtn = By.id("viewProfileBtn");
        public By messageThreadInterviewReminderActionBtn = By.id("actionBtn");
        public By messageThreadWdgInterviewReminderDialogCloseBtn = By.id("messageThreadWdgMessageInterviewReminderinterviewDialogDialogCloseBtn");
        public By interviewSchedulerinterviewDialogBasicDialog = By.id("interviewSchedulerinterviewDialogBasicDialog");
        public By interviewSchedulerCalendariInterviewDialogTitle = By.id("interviewSchedulerinterviewDialogTitle");
        public By interviewSchedulerCalendarApplicantTxt = By.id("interviewSchedulerApplicantTxt");
        public By interviewSchedulerCalendarApplicantPosition = By.id("interviewSchedulerCurrentPositionTxt");
        public By interviewSchedulerCalendarAvatar = By.id("interviewScheduleravatar");
        public By interviewSchedulerCalendarDateTxt = By.id("interviewSchedulerdateTxt");
        public By interviewSchedulerCalendarViewProfileBtn = By.id("viewProfileBtn");
        public By interviewSchedulerCalendarActionBtn = By.id("actionBtn");
        public By interviewSchedulerApplicantProfileMessageBtn = By.id("messageBtn");
        public By messageThreadInterviewReminderRescheduleBtn = By.id("undefinedRescheduleBtn");
        public By messageThreadInterviewReminderMessageBtn = By.id("undefinedMessageBtn");
        public By messageThreadInterviewReminderCancelInterviewBtn = By.id("undefinedCancelBtn");
        public By messageThreadInterviewRescheduleAvailabilityDialog = By.id("messageThreadWdgMessageInterviewReminderAvailabilityDialogBasicDialog");
        public By messageThreadInterviewRescheduleAvailabilityDialogTitle = By.id("messageThreadWdgMessageInterviewReminderAvailabilityDialogTitle");
        public By messageThreadInterviewRescheduleAvailabilityDialogText = By.id("messageThreadWdgMessageInterviewReminderAvailabilityDialogText");
        public By messageThreadInterviewRescheduleAvailabilityDialogMessageText = By.id("messageThreadWdgMessageInterviewReminderMessageTextArea");
        public By messageThreadInterviewRescheduleAvailabilityDialogRescheduleBtn = By.id("primaryBtn");
        public By messageThreadInterviewRescheduleAvailabilityDialogCanceleBtn = By.id("secondaryBtn");
        public By interviewRescheduleAvailabilityDialog = By.id("inviteToInterviewAvailabilityDialogBasicDialog");
        public By interviewRescheduleAvailabilityDialogConfirmInterviewBtn = By.id("primaryBtn");
        public By interviewRescheduleAvailabilityDialogRequestNewTimesBtn = By.id("secondaryBtn");
        public By messageThreadRescheduleSuccessDialog = By.id("messageThreadWdgMessageInterviewReminderRescheduleSuccessDialogBasicDialog");
        public By messageThreadRescheduleSuccessDialogTitle = By.id("messageThreadWdgMessageInterviewReminderRescheduleSuccessDialogTitle");
        public By messageThreadRescheduleSuccessDialogText = By.id("messageThreadWdgMessageInterviewReminderRescheduleSuccessDialogText");
        public By messageThreadRescheduleSuccessDialogDismissBtn = By.id("dismissBtn");
        public By messageThreadRescheduleSuccessDialogCloseBtn = By.id("inviteToInterviewInviteSuccessDialogDialogCloseBtn");
        public By referralsBannerCloseBtn = By.id("referralsbannerSMCloseIcon");
    }
}