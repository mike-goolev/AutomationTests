import org.openqa.selenium.By;

public class Locators {

    public static class NavPageLocators {
        /* Common Nav Header Locators */
        public By largeBrushfireLogo = By.id("headerBigLogoImg");
        public By myHomeBtn = By.id("headerMyHomeLink");
        public By findJobsBtn = By.id("headerFindJobsLink");
        public By careerBtn = By.id("headerCareerPathLink");
        public By networkBtn = By.id("headerCommunityLink");
        public By searchBtn = By.id("headerSearchButton");
        public By jobSearchTxtField = By.id("headerSearchInput");

        /* Non Auth Nav Header Locators */
        public By loginBtn = By.id("headerLoginLink");
        public By signUpBtn = By.id("headerJoinBtn");

        /* Auth'd Nav Header Locators */
        public By contentFeedBtn = By.id("headerFeedLink");
        public By messagesBtn = By.id("headerMessagesLink");
        public By userNameBtn = By.id("headerMenuToggleBtn");
        public By userNameTxt = By.id("usernameText");
        public By userPhotoImg = By.id("profilePictureImg");
        public By userAvatarImg = By.id("profilePictureImg");

        public By menuProfileBtn = By.id("headerMenuProfileLink");
        public By menuStoreProfileBtn = By.id("headerMenuStoreProfileLink");
        public By menuSettingsBtn = By.id("headerMenuSettingsLink");
        public By menuManagerBtn = By.id("headerMenuSwitchViewsLink");
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
    }

    public static class JobSearchPageLocators {

        public By searchPositionDropdown = By.id("searchJobTypeDropDown");
        public By searchPositionDropdownLbl = By.id("searchJobTypeDropDownLabel");

        /**
         * Locates a job search position in the dropdown for a given index
         *
         * @param index The index (Starting at 0) of the job search position in the dropdown you wish to locate
         * @return Returns a locator for a job search position in the dropdown by index
         */
        public By findJobSearchPositionByIndex(String index) {
            return By.id("searchJobTypeDropDownOption" + index);
        }

        public By searchLocationField = By.id("searchLocationTextField");

        /* Search Results */

        /**
         * Locates a job search result employer logo for a given index
         *
         * @param index The index (Starting at 0) of the job search result employer logo you wish to locate
         * @return Returns a locator for a job search result employer logo by index
         */
        public By findSearchResultEmployerImgByIndex(String index) {
            return By.id("searchResultEmployerPhoto" + index);
        }

        /**
         * Locates a job search result position for a given index
         *
         * @param index The index (Starting at 0) of the job search result position you wish to locate
         * @return Returns a locator for a job search result position by index
         */
        public By findSearchResultPositionTxtByIndex(String index) {
            return By.id("searchResultJobNameText" + index);
        }

        /**
         * Locates a job search result employer name for a given index
         *
         * @param index The index (Starting at 0) of the job search result employer name you wish to locate
         * @return Returns a locator for a job search result employer name by index
         */
        public By findSearchResultEmployerNameTxtByIndex(String index) {
            return By.id("searchResultEmployerNameText" + index);
        }

        /**
         * Locates a job search result location for a given index
         *
         * @param index The index (Starting at 0) of the job search result location you wish to locate
         * @return Returns a locator for a job search result location by index
         */
        public By findSearchResultEmployerLocationTxtByIndex(String index) {
            return By.id("searchResultAddressText" + index);
        }

        /**
         * Locates a job search result view button for a given index
         *
         * @param index The index (Starting at 0) of the job search result view button you wish to locate
         * @return Returns a locator for a job search result view button by index
         */
        public By findSearchResultViewBtnByIndex(String index) {
            return By.id("searchResultViewBtn" + index);
        }

        /**
         * Locates a job search result apply button for a given index
         *
         * @param index The index (Starting at 0) of the job search result apply button you wish to locate
         * @return Returns a locator for a job search result apply button by index
         */
        public By findSearchResultApplyBtnByIndex(String index) {
            return By.id("searchResultApplyBtn" + index);
        }

        public By searchResultsCountTxt = By.id("jobSearchJobCount");
        public By emptySearchTextTitle = By.id("emptySearchTextTitle");
        public By searchResultsEmptyMessageTxt = By.id("emptySearchTextContent");
        public By applySuccessToastTxt = By.id("applyForJobToast");
        public By applySuccessToastDismissBtn = By.id("applyForJobToastCloseBtn");

        /* Job Details - Auth'd */
        public By jobDetailsPositionTxt = By.id("jobNameTxt");
        public By jobDetailsWageTxt = By.id("jobWageTxt");
        public By jobDetailsApplyBtn = By.id("jobApplyBtn");
        public By jobDetailsApplySuccessToastTxt = By.id("applyForJobToast");
        public By jobDetailsApplySuccessToastDismissBtn = By.id("applyForJobToastCloseBtn");
        public By jobDetailsJobDescriptionTitleTxt = By.id("jobDescriptionTitleTxt");
        public By jobDetailsJobDescriptionTxt = By.id("jobDescriptionTxt");
        public By jobDetailsEmployerLogoImg = By.id("jobEmployerPhotoImg");
        public By jobDetailsEmployerNameTxt = By.id("employerNameTxt");
        public By jobDetailsEmployerDescriptionTitleTxt = By.id("employerDescriptionTitleTxt");
        public By jobDetailsEmployerDescriptionTxt = By.id("employerDescriptionTxt");
        public By jobDetailsEmployerAddressTxt = By.id("employerAddressTxt");
        public By jobDetailsEmployerPPATxt = By.id("employerPPATypeTxt");
        public By jobDetailsEmployerTypeTxt = By.id("employerTypeTxt");
        public By jobDetailsEmployerDistanceTxt = By.id("employerDistanceTxt");
        public By jobDetailsEmployerFollowBtn = By.xpath("//button[@id='employerFollowBtn']/div/span[contains(text(), 'Follow')]");
        public By jobDetailsEmployerFollowingBtn = By.xpath("//button[@id='employerFollowBtn']/div/span[contains(text(), 'Following')]");
        public By jobDetailsEmployerFollowToastTxt = By.id("jobDetailsToast");
        public By jobDetailsEmployerFollowToastDismissBtn = By.id("jobDetailsToastCloseBtn");
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

        /* Work History Section */
        public By workHistoryTitleTxt = By.id("profileExperienceTitle");
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
        public By addWorkHistoryPrimaryJobChk = By.id("addWorkHistoryPrimaryExperienceCheckboxBox");
        public By editWorkHistoryPrimaryJobChk = By.id("editWorkHistoryPrimaryExperienceCheckboxBox");

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
        public By googlePlacesMyStoreBtns = By.cssSelector("div.pac-container>div");

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

    public static class HourlyNetworkPageLocators {
        /* Global connections page locators */
        public By connectionsGetConnectedBtn = By.id("communityGetConnectedLinkTab");
        public By connectionsMyConnectionsBtn = By.id("communityMyConnectionsLinkTab");
        public By connectionsInvitationsBtn = By.id("communityInvitationsLinkTab");
        public By userSearchTextField = By.id("memberSearchInput");
        public By userSearchListResultTxt = By.id("memberSearchListItem");
        public By invitationsTitleTxt = By.id("invitationsBlockHeaderTxt");
        public By invitationsCountTxt = By.id("invitationsBlockConnectionsCountTxt");

        /**
         * Locates an invitation's photo for a given index
         *
         * @param index The index (Starting at 0) of the user you wish to locate
         * @return Returns a locator for the user card's image by index
         */
        public By findInvitationImgByIndex(String index) {
            return By.id("invitationsBlockCardImage" + index);
        }

        /**
         * Locates an invitation's name for a given index
         *
         * @param index The index (Starting at 0) of the user you wish to locate
         * @return Returns a locator for the user card's name by index
         */
        public By findInvitationNameTxtByIndex(String index) {
            return By.id("invitationsBlockNameTxt" + index);
        }

        /**
         * Locates an invitation's work history for a given index
         *
         * @param index The index (Starting at 0) of the user you wish to locate
         * @return Returns a locator for the user card's work history by index
         */
        public By findInvitationJobTxtByIndex(String index) {
            return By.id("invitationsBlockPrimaryJobTxt" + index);
        }

        /**
         * Locates an invitation's ignore button for a given index
         *
         * @param index The index (Starting at 0) of the user's ignore button you wish to locate
         * @return Returns a locator for the user card's ignore button by index
         */
        public By findInvitationIgnoreBtnByIndex(String index) {
            return By.id("invitationsBlockIgnoreBtn" + index);
        }

        /**
         * Locates an invitation's connect button for a given index
         *
         * @param index The index (Starting at 0) of the user you wish to locate
         * @return Returns a locator for the user card's connect button by index
         */
        public By findInvitationConnectBtnByIndex(String index) {
            return By.id("invitationsBlockConnectBtn" + index);
        }

        /* My Connections section */
        public By emptyConnectionsTitleTxt = By.id("myConnectionsEmptySearchTextTitle");

        /**
         * Locates a connection's photo for a given index
         *
         * @param index The index (Starting at 0) of the user you wish to locate
         * @return Returns a locator for the user card's image by index
         */
        public By findConnectionCardImgByIndex(String index) {
            return By.id("myConnectionsCardPlaceholderIcon" + index);
        }

        /**
         * Locates a connection's name for a given index
         *
         * @param index The index (Starting at 0) of the user you wish to locate
         * @return Returns a locator for the user card's name by index
         */
        public By findConnectionCardNameTxtByIndex(String index) {
            return By.id("myConnectionsNameTxt" + index);
        }

        /**
         * Locates a connection's work history for a given index
         *
         * @param index The index (Starting at 0) of the user you wish to locate
         * @return Returns a locator for the user card's work history by index
         */
        public By findConnectionCardWorkTxtByIndex(String index) {
            return By.id("myConnectionsPrimaryJobTxt" + index);
        }

        /**
         * Locates a connection's view button for a given index
         *
         * @param index The index (Starting at 0) of the user's view button you wish to locate
         * @return Returns a locator for the user card's view button by index
         */
        public By findConnectionCardViewBtnByIndex(String index) {
            return By.id("myConnectionsViewProfileBtn" + index);
        }

        /**
         * Locates a connection's message button for a given index
         *
         * @param index The index (Starting at 0) of the user's message button you wish to locate
         * @return Returns a locator for the user card's message button by index
         */
        public By findConnectionCardMessageBtnByIndex(String index) {
            return By.id("myConnectionsMessageBtn" + index);
        }

        public By connectionPage1Btn = By.id("connectionsPage1Btn");
        public By connectionPage2Btn = By.id("connectionsPage2Btn");
        public By connectionPage3Btn = By.id("connectionsPage3Btn");
        public By connectionPage4Btn = By.id("connectionsPage4Btn");
        public By connectionNextPageBtn = By.id("connectionsNextBtn");
        public By connectionPreviousPageBtn = By.id("connectionsPreviousBtn");

        /* Suggested connections section */

        /**
         * Locates a suggested connection's photo for a given index
         *
         * @param index The index (Starting at 0) of the user you wish to locate
         * @return Returns a locator for the user card's image by index
         */
        public By findSuggestionCardImgByIndex(String index) {
            return By.id("getConnectedCardPlaceholderIcon" + index);
        }

        /**
         * Locates a suggested connection's name for a given index
         *
         * @param index The index (Starting at 0) of the user you wish to locate
         * @return Returns a locator for the user card's name by index
         */
        public By findSuggestionCardNameTxtByIndex(String index) {
            return By.id("getConnectedNameTxt" + index);
        }

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
         *
         * @param index The index (Starting at 0) of the user's view button you wish to locate
         * @return Returns a locator for the user card's view button by index
         */
        public By findSuggestionCardViewBtnByIndex(String index) {
            return By.id("getConnectedViewProfileBtn" + index);
        }

        /**
         * Locates a suggested connection's connect button for a given index
         *
         * @param index The index (Starting at 0) of the user you wish to locate
         * @return Returns a locator for the user card's connect button by index
         */
        public By findSuggestionCardConnectBtnByIndex(String index) {
            return By.id("getConnectedConnectBtn" + index);
        }

        public By suggestionsPage1Btn = By.id("suggestedConnectionsPage1Btn");
        public By suggestionsPage2Btn = By.id("suggestedConnectionsPage2Btn");
        public By suggestionsPage3Btn = By.id("suggestedConnectionsPage3Btn");
        public By suggestionsPage4Btn = By.id("suggestedConnectionsPage4Btn");
        public By suggestionsnNextPageBtn = By.id("suggestedConnectionsNextBtn");
        public By suggestionsnPreviousPageBtn = By.id("suggestedConnectionsPreviousBtn");

        /* Invitations section */
        public By invitationEmptyTitleTxt = By.id("invitationsEmptySearchTextTitle");
        public By invitationEmptyTxt = By.id("invitationsEmptySearchTextContent");
        public By invitationEmptySuggestionsBtn = By.id("invitationsGetConnectedBtn");

        /**
         * Locates an invitation's photo for a given index
         *
         * @param index The index (Starting at 0) of the user you wish to locate
         * @return Returns a locator for the user card's image by index
         */
        public By findInvitationCardImgByIndex(String index) {
            return By.id("invitationsCardPlaceholderIcon" + index);
        }

        /**
         * Locates an invitation's name for a given index
         *
         * @param index The index (Starting at 0) of the user you wish to locate
         * @return Returns a locator for the user card's name by index
         */
        public By findInvitationCardNameTxtByIndex(String index) {
            return By.id("invitationsNameTxt" + index);
        }

        /**
         * Locates an invitation's work history for a given index
         *
         * @param index The index (Starting at 0) of the user you wish to locate
         * @return Returns a locator for the user card's work history by index
         */
        public By findInvitationCardJobTxtByIndex(String index) {
            return By.id("invitationsPrimaryJobTxt" + index);
        }

        /**
         * Locates an invitation's ignore button for a given index
         *
         * @param index The index (Starting at 0) of the user's ignore button you wish to locate
         * @return Returns a locator for the user card's ignore button by index
         */
        public By findInvitationCardIgnoreBtnByIndex(String index) {
            return By.id("invitationsIgnoreBtn" + index);
        }

        /**
         * Locates an invitation's connect button for a given index
         *
         * @param index The index (Starting at 0) of the user you wish to locate
         * @return Returns a locator for the user card's connect button by index
         */
        public By findInvitationCardConnectBtnByIndex(String index) {
            return By.id("invitationsConnectBtn" + index);
        }
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
        public By staffTabBtn = By.cssSelector("ul#new_ui_menu>li:nth-of-type(4)");
        public By staffTabAddEmployeeBtn = By.cssSelector("div#addOrImportEmployeeButtonDiv>a");
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
        public By activationActionLink = By.cssSelector("div.float-center>a");
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
        public By employerHeaderEditProfileBtn = By.id("storeProfileEditIcon");
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
        public By employerManagementTitleTxt = By.id("storeProfileManagementTitle");
        public By employerManagementEditBtn = By.id("storeProfileManagementEditBtn");

        /**
         * Locates an employer manager photo for a given index
         *
         * @param index The index (Starting at 0) of the employer manager photo you wish to locate
         * @return Returns a locator for the employer manager photo by index
         */
        public By findEmployerManagerPhotoByIndex(String index) {
            return By.id("StoreMember" + index + "Avatar");
        }

        /**
         * Locates an employer manager name for a given index
         *
         * @param index The index (Starting at 0) of the employer manager name you wish to locate
         * @return Returns a locator for the employer manager name by index
         */
        public By findEmployerManagerNameByIndex(String index) {
            return By.id("storeMember" + index + "NameText");
        }

        /**
         * Locates an employer manager label for a given index
         *
         * @param index The index (Starting at 0) of the employer manager label you wish to locate
         * @return Returns a locator for the employer manager label by index
         */
        public By findEmployerManagerLabelByIndex(String index) {
            return By.id("storeMember" + index + "Label");
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

        public By employerJobTitleTxt = By.id("");

        /**
         * Locates an employer job position for a given index
         *
         * @param index The index (Starting at 0) of the employer job position you wish to locate
         * @return Returns a locator for the employer job position by index
         */
        public By findEmployerJobCardPositionByIndex(String index) {
            return By.id("searchResultJobNameTextJobCard" + index);
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
            return By.id("searchResultViewBtnJobCard" + index);
        }

        /**
         * Locates an employer job edit button for a given index
         *
         * @param index The index (Starting at 0) of the employer job edit button you wish to locate
         * @return Returns a locator for the employer job edit button by index
         */
        public By findEmployerJobCardEditBtnByIndex(String index) {
            return By.id("searchResultApplyBtnJobCard" + index);
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
            return By.id("searchResultEmployerPhotoJobCard" + index);
        }

        /**
         * Locates a job's employer name for a given index
         *
         * @param index The index (Starting at 0) of the job's employer name you wish to locate
         * @return Returns a locator for the job's employer name by index
         */
        public By findEmployerJobCardNameByIndex(String index) {
            return By.id("searchResultEmployerNameTextJobCard" + index);
        }

        /**
         * Locates a job's employer address for a given index
         *
         * @param index The index (Starting at 0) of the job's employer address you wish to locate
         * @return Returns a locator for the job's employer address by index
         */
        public By findEmployerJobCardAddressByIndex(String index) {
            return By.id("searchResultAddressTextJobCard" + index);
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

    public static class EmployerProfileEditPageLocators {
        public By employerProfileEditInfoBtn = By.id("editprofileInfoLink");
        public By employerProfileEditPhotosBtn = By.id("editprofilePhotosLink");
        public By employerProfileEditAboutBtn = By.id("editprofileAboutMyStoreLink");
        public By employerProfileEditJobsBtn = By.id("editprofileHiringLink");
        public By employerProfileEditViewProfileBtn = By.id("editprofileViewProfileLink");

    }
}
