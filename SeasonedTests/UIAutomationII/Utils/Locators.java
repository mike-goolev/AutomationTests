import org.openqa.selenium.By;

public class Locators {

    public static class NavPageLocators {
        /* Common Nav Header Locators */
        public By largeBrushfireLogo = By.id("headerBigLogoImg");
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
        public By userAvatarImg = By.id("profilePictureImgIcon");


        public By menuProfileBtn = By.id("headerMenuProfileLink");
        public By menuSettingsBtn = By.id("headerMenuSettingsLink");
        public By menuManagerBtn = By.id("headerMenuManagersLink");
        public By menuLogoutBtn = By.id("headerMenuLogOutLink");
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

        /* Facebook.com Locators */
        public By faceBookEmailField = By.id("email");
        public By faceBookPasswordField = By.id("pass");
        public By facebookLoginBtn = By.id("loginbutton");
    }

    public static class ContentPageLocators {
        /* Non Auth Content Locators */
        public By getStartedImg = By.id("marketingCardImg");
        public By getStartedTitle = By.id("marketingCardTitleText");
        public By getStartedTxt = By.id("marketingCardDescriptionText");
        public By getStartedBtn = By.id("marketingCardBtn");

        /* Shared Non Auth and Auth'd Content Locators */
        /**
         * Locates an article image for a given index
         * @param index The index (Starting at 0) of the article image you wish to locate
         * @return Returns a locator for an article's image by index
         */
        public By articleImgByIndex(String index) {
            return By.id("articleImg" + index);
        }

        /**
         * Locates an article title for a given index
         * @param index The index (Starting at 0) of the article title you wish to locate
         * @return Returns a locator for an article's title by index
         */
        public By artcleTitleTxtByIndex(String index) {
            return By.cssSelector("h2#articleTitleText" + index + ">div>div");
        }

        /**
         * Locates an article site name for a given index
         * @param index The index (Starting at 0) of the article site name you wish to locate
         * @return Returns a locator for an article's site name by index
         */
        public By articleSiteTxtByIndex(String index) {
            return By.id("articleSiteNameText" + index);
        }

        /**
         * Locates an article description for a given index
         * @param index The index (Starting at 0) of the article description you wish to locate
         * @return Returns a locator for an article's description by index
         */
        public By articleDescriptionTxtByIndex(String index) {
            return By.id("articleDescriptionText" + index);
        }

        /**
         * Locates an article publisher image for a given index
         * @param index The index (Starting at 0) of the article publisher image you wish to locate
         * @return Returns a locator for an article's publisher image by index
         */
        public By articlePublisherImgByIndex(String index) {
            return By.id("articleAuthorImg" + index);
        }

        /**
         * Locates an article publisher name for a given index
         * @param index The index (Starting at 0) of the article publisher name you wish to locate
         * @return Returns a locator for an article's publisher name by index
         */
        public By articlePublisherNameTxtByIndex(String index) {
            return By.id("articleAuthorNameText" + index);
        }

        /**
         * Locates an article publisher date for a given index
         * @param index The index (Starting at 0) of the article publisher date you wish to locate
         * @return Returns a locator for an article's publisher date by index
         */
        public By articlePublishedDateTxtByIndex(String index) {
            return By.id("articlePostedTimeAgoText" + index);
        }

        /**
         * Locates an article like button for a given index
         * @param index The index (Starting at 0) of the article like button you wish to locate
         * @return Returns a locator for an article's like button by index
         */
        public By articleLikeBtnByIndex(String index) {
            return By.id("articleLikeBtn" + index);
        }

        /**
         * Locates an article like count for a given index
         * @param index The index (Starting at 0) of the article like count you wish to locate
         * @return Returns a locator for an article's like count by index
         */
        public By articleLikeCountTxtByIndex(String index) {
            return By.id("articleLikeCountText" + index);
        }

        public By trendingTitle = By.id("trendingArticlesPreviewCardTitle");

        /**
         * Locates a trending article image for a given index
         * @param index The index (Starting at 0) of the trending article image you wish to locate
         * @return Returns a locator for a trending article's image by index
         */
        public By trendingArticleImgByIndex(String index) {
            return By.id("trendingArticlesPreviewItemImage" + index);
        }

        /**
         * Locates a trending article title for a given index
         * @param index The index (Starting at 0) of the trending article title you wish to locate
         * @return Returns a locator for a trending article's title by index
         */
        public By trendingArticleTitleTxtByIndex(String index) {
            return By.id("trendingArticlesPreviewItemTitle" + index);
        }

        /**
         * Locates a trending article site name for a given index
         * @param index The index (Starting at 0) of the trending article site name you wish to locate
         * @return Returns a locator for a trending article's site name by index
         */
        public By trendingArticleSiteTxtByIndex(String index) {
            return By.id("trendingArticlesPreviewItemSiteName" + index);
        }

        public By findJobsImg = By.id("dedicatedJobsCardImg");
        public By findJobsTitle = By.id("dedicatedJobsCardTitleText");
        public By findJobsTxt = By.id("dedicatedJobsCardDescriptionText");
        public By findJobsBtn = By.id("dedicatedJobsCardBtn");

        /* Auth'd Content Locators */
        public By viewedArticleTitle = By.id("recentlyViewedArticlesPreviewCardTitle");

        /**
         * Locates a viewed article image for a given index
         * @param index The index (Starting at 0) of the viewed article image you wish to locate
         * @return Returns a locator for a viewed article's image by index
         */
        public By viewedArticleImgByIndex(String index) {
            return By.id("recentlyViewedArticlesPreviewItemImage" + index);
        }

        /**
         * Locates a viewed article title for a given index
         * @param index The index (Starting at 0) of the viewed article title you wish to locate
         * @return Returns a locator for a viewed article's title by index
         */
        public By viewedArticleTitleTxtByIndex(String index) {
            return By.id("recentlyViewedArticlesPreviewItemTitle" + index);
        }

        /**
         * Locates a viewed article site name for a given index
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
        /*Search Fields*/
        public By searchPositionDropdown = By.id("searchJobTypeDropDown");

        public By searchJobEmployerField = By.id("searchTermTextField");
        public By searchLocationField = By.id("searchLocationTextField");
        public By searchBtn = By.id("searchButton");

        /* Search Results */
        public By searchResultPaginationTxt = By.id("searchShowResults");

        /**
         * Locates a job search result image for a given index
         * @param index The index (Starting at 0) of the job search result image you wish to locate
         * @return Returns a locator for a job search result image by index
         */
        public By searchResultEmployerImgByIndex(String index) {
            return By.id("searchResultEmployerPhoto" + index);
        }

        /**
         * Locates a job search result position for a given index
         * @param index The index (Starting at 0) of the job search result position you wish to locate
         * @return Returns a locator for a job search result position by index
         */
        public By searchResultPositionTxtByIndex(String index) {
            return  By.id("searchResultJobNameText" + index);
        }

        /**
         * Locates a job search result employer name for a given index
         * @param index The index (Starting at 0) of the job search result employer name you wish to locate
         * @return Returns a locator for a job search result employer name by index
         */
        public By searchResultEmployerNameTxtByIndex(String index) {
            return By.id("searchResultEmployerNameText" + index);
        }

        /**
         * Locates a job search result distance for a given index
         * @param index The index (Starting at 0) of the job search result distance you wish to locate
         * @return Returns a locator for a job search result distance by index
         */
        public By searchResultEmployerDistanceTxtByIndex(String index) {
            return By.id("searchResultEmployerDistanceText" + index);
        }

        /**
         * Locates a job search result zip for a given index
         * @param index The index (Starting at 0) of the job search result zip you wish to locate
         * @return Returns a locator for a job search result image by index
         */
        public By searchResultEmployerZipTxtByIndex(String index) {
            return By.id("searchResultEmployerZipText" + index);
        }

        /**
         * Locates a job search result view button for a given index
         * @param index The index (Starting at 0) of the job search result view button you wish to locate
         * @return Returns a locator for a job search result view button by index
         */
        public By searchResultViewBtnByIndex(String index) {
            return By.id("searchResultViewBtn" + index);
        }

        /**
         * Locates a job search result apply button for a given index
         * @param index The index (Starting at 0) of the job search result apply button you wish to locate
         * @return Returns a locator for a job search result apply button by index
         */
        public By searchResultApplyBtnByIndex(String index) {
            return By.id("searchResultLoggedInApplyBtn" + index);
        }

        /**
         * Locates a job search result apply loading button for a given index
         * @param index The index (Starting at 0) of the job search result apply loading button you wish to locate
         * @return Returns a locator for a job search result apply loading button by index
         */
        public By searchResultApplyLoadingBtnByIndex(String index) {
            return By.cssSelector("button#searchResultLoggedInApplyBtn" + index + ".loading");
        }

        /**
         * Locates a job search result applied button for a given index
         * @param index The index (Starting at 0) of the job search result applied button you wish to locate
         * @return Returns a locator for a job search result applied button by index
         */
        public By searchResultAppliedBtnByIndex(String index) {
            return By.id("searchResultAppliedBtn" + index);
        }

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
        public By jobDetailsEmployerUnfollowBtn = By.id("employerCardUnfollowBtn");
        public By jobDetailsEmployerUnfollowConfirm = By.cssSelector("div.bf-employer-details>div:nth-of-type(5)>button");
        /*public By jobDetailsEmployerUnfollowCancel = By.cssSelector("");*/
    }

    public static class ProfilePageLocators {
        /* Global profile page locators */
        public By profileEditBtn = By.id("editProfileBtn");

        /* Personal Info Section */
        public By personInfoUserPhotoImg = By.id("profilePhotoImg");
        public By personalInfoUserFirstAndLastNameTxt = By.id("profileNameTxt");

        /**
         * Locates a user's primary job on the profile page by index
         *
         * @param index The index (Starting at 0) of the user's primary job you wish to locate
         * @return A locator for the user's primary job at the given index
         */
        public By findPrimaryJobTxtByIndex(String index){
            return By.id("profilePrimaryJobJobName" + index);
        }

        public By personalInfoUserLocationTxt = By.id("profileLocationTxt");
        public By personalInfoActionsMenuBtn = By.cssSelector("div.actions-menu-toggle");
        public By personalInfoDisconnectBtn = By.id("disconnectLink");

        /* Work History Section */
        public By workHistoryCardHeader = By.id("profileExperienceTitle");

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
         * @param listIndex The index (Starting at 0) of the employer you wish to locate
         * @param positionIndex The index (Starting at 0) of the job name you wish to locate
         * @return A locator for the job position at the given indexes
         */
        public By findWorkHistoryJobPositionByIndex(String listIndex, String positionIndex) {
            return By.id("workHistoryCardListItem" + listIndex + "Position" + positionIndex);
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
         * Locates the time period the user worked at the employer by index
         * @param index The index (Starting at 0) of the employer you wish to locate
         * @return A locator for the time period the user work at the employer by index
         */
        public By findWorkHistoryEmployerTimePeriodByIndex(String index) {
            return By.id("workHistoryCardListItemWorkPeriodText" + index);
        }

        /**
         * Locates the duration the user worked at the employer by index
         * @param index The index (Starting at 0) of the employer you wish to locate
         * @return A locator for the duration the user worked at the employer by index
         */
        public By findWorkHistoryEmployerDurationByIndex(String index) {
            return By.id("workHistoryCardListItemWorkPeriodText" + index);
        }

        /* Certifications Section */
        public By certsEmptyHeader = By.id("certificationsCardEmptyTitleText");
        public By certsHeader = By.id("profileCertificationsTitleText");
        public By certsAddButton = By.id("certificationsCardEmptyAddBtn");
        public By certsEditButton = By.id("certificationsCardEditBtn");
        public By certsAlcoholImg = By.id("profileCertificationAlcoholSeller/ServerCardListItemImg");
        public By certsAlcoholTxt = By.id("certificationsCardListItemAlcoholSeller/ServerText");
        public By certsFoodHandlerImg = By.id("profileCertificationFoodHandlerCardListItemImg");
        public By certsFoodHandlerTxt = By.id("certificationsCardListItemFoodHandlerText");
        public By certsFoodProtectionImg = By.id("profileCertificationFoodProtectionManagerCardListItemImg");
        public By certsFoodProtectionTxt = By.id("certificationsCardListItemFoodProtectionManagerText");
        public By certsHACCPImg = By.id("profileCertificationHACCPCardListItemImg");
        public By certsHACCPTxt = By.id("certificationsCardListItemHACCPText");
        public By certsEmptyCardTxt = By.id("certificationsCardEmptyDescriptionText");
        public By sideMenuCertificationsLink = By.id("editProfileCertificationsLink");

        /* Skills Section */
        public By skillsHeader = By.id("viewProfileSkillTitle");

        /**
         * Locates a skill label for a given index
         * @param index The index (Starting at 0) of the skill you wish to locate
         * @return Returns a locator for the skill by index
         */
        public By findSkillLabelByIndex(String index) {
            return By.id("viewProfileSkillLabel" + index);
        }

        /* About Section */
        public By addAboutBtn = By.id("aboutCardEmptyAddBtn");
        public By editAboutBtn = By.id("aboutCardEditBtn");
        public By aboutHeader = By.id("aboutCardTitleText");
        public By aboutTxtField = By.id("profileAboutText");
        public By emptyAboutTxtField = By.id("aboutCardEmptyDescriptionText");
        public By sideMenuAboutMeLink = By.id("editProfileAboutLink");

        /* Availability Section */
        public By addAvailabilityBtn = By.id("availabilityCardEmptyAddBtn");
        public By editAvailabilityBtn = By.id("availabilityCardEditBtn");
        public By availabilityMorningsCard = By.id("profileAvailabilityCardMornings");
        public By availabilityAfternoonsCard = By.id("profileAvailabilityCardAfternoons");
        public By availabilityEveningsCard = By.id("profileAvailabilityCardEvenings");
        public By availabilityNightsCard = By.id("profileAvailabilityCardNights");
        public By availabilityInterestStatusTxt = By.id("profileAvailabilityEmploymentInterestStatus");
        public By availabilityInterestTypeTxt = By.id("profileAvailabilityEmploymentInterestType");
        public By sideMenuAvailabilityLink = By.id("editProfileAvailabilityLink");

        /* Connections Section */
        public By connectionsTitleTxt = By.id("connectionsCardTitleText");
        public By connectionsCountTxt = By.id("connectionsCardConnectionsCount");
        public By emptyConnectionsBtn = By.id("connectionsCardSuggestedConnectionsBtn");
        public By viewAllConnectionsBtn = By.id("connectionsCardMoreConnectionsBtn");

        /**
         * Locates a connection's photo for a given index
         * @param index The index (Starting at 0) of the user you wish to locate
         * @return Returns a locator for the connection's image by index
         */
        public By findConnectionImgByIndex(String index) {
            return By.id("connectionsCardConnectionProfilePhotoImg" + index);
        }

        /**
         * Locates a connection's view profile link for a given index
         * @param index The index (Starting at 0) of the user you wish to locate
         * @return Returns a locator for the connection's view profile link by index
         */
        public By findConnectionLinkByIndex(String index) {
            return By.id("connectionsCardConnectionLink" + index);
        }

        /* Suggested Connections Section */
        public By suggestedConnectionsTitleTxt = By.id("suggestedConnectionsCardTitleText");
        public By viewAllSuggestedConnectionsBtn = By.id("suggestedConnectionsCardSuggestedConnectionsBtn");

        /**
         * Locates a suggested connection's photo for a given index
         * @param index The index (Starting at 0) of the user you wish to locate
         * @return Returns a locator for the suggested connection's image by index
         */
        public By findSuggestedConnectionImgByIndex(String index) {
            return By.id("suggestedConnectionsCardConnectionProfilePhotoImg" + index);
        }

        /**
         * Locates a suggested connection's name for a given index
         * @param index The index (Starting at 0) of the user you wish to locate
         * @return Returns a locator for the suggested connection's name by index
         */
        public By findSuggestedConnectionNameTxtByIndex(String index) {
            return By.id("suggestedConnectionsCardConnectionUsernameText" + index);
        }

        /**
         * Locates a suggested connection's reason for a given index
         * @param index The index (Starting at 0) of the user you wish to locate
         * @return Returns a locator for the suggested connection's reason by index
         */
        public By findSuggestedConnectionReasonTxtByIndex(String index) {
            return By.id("suggestedConnectionsCardConnectionReasonText" + index);
        }

        /**
         * Locates a suggested connection's connect button for a given index
         * @param index The index (Starting at 0) of the user you wish to locate
         * @return Returns a locator for the suggested connection's reason by index
         */
        public By findSuggestedConnectionConnectBtnByIndex(String index) {
            return By.id("suggestedConnectionsCardConnectBtn" + index);
        }

        /* Shared profile page locators */
        public By successToastDiv = By.cssSelector("div#bodySideMenuToast.success");
        public By failToastDiv = By.cssSelector("div#bodySideMenuToast.error");
        public By profileBackBtn = By.id("editProfileBackBtn");
        public By publicProfileViewBackBtn = By.cssSelector("button.bf-button");
        public By editProfileBtn = By.id("editProfileBtn");
    }

    public static class PersonalInfoPageLocators {
        public By personalInfoPhotoTxt = By.id("profileInfoPhotoTxt");
        public By personalInfoUserPhotoAvatarImg = By.id("personalInfoCardProfileImgIcon");
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
        public By personalInfoEligibilityChk = By.id("eligibleToWorkChkBox");
        public By personalInfoSaveBtn = By.id("savePersonalInfoBtn");
        public By personalInfoSuccessToastTxt = By.id("personalInfoToastTypeTxt");
        public By personalInfoSuccessToastCloseBtn = By.id("personalInfoToastCloseBtn");
    }

    public static class WorkHistoryPageLocators {
        public By navMenuExperience = By.id("editProfileExperienceLink");
        public By editExperienceSuccessToast = By.id("editWorkHistorySuccessToast");
        public By editExperienceSuccessToastCloseBtn = By.id("editWorkHistorySuccessToastCloseBtn");
        public By addExperienceSuccessToast = By.cssSelector("div.toast");
        public By addExperienceSuccessToastCloseBtn = By.id("CloseBtn");

        public By addWorkHistoryBtn = By.id("addExperienceBtn");
        public By emptyWorkHistoryTitle = By.id("");
        public By emptyWorkHistoryTxt = By.id("");
        public By firstJobChk = By.id("addExperienceFirstJobCheckboxBox");
        public By firstJobChkLbl = By.id("addExperienceFirstJobCheckboxLabel");

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
         * @param listIndex The index (Starting at 0) of the work history list item position you wish to locate
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
        public By googlePlacesMyStoreBtns = By.cssSelector("div.pac-container>div");
        /**
         * Locates a edit work history button for a given index

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
        public By alcoholSellerUploadBtn = By.id("editCertificationsListItemAlcoholSeller/ServerUploadBtn0");
        public By foodHandlerImg = By.id("editCertificationsListItemFoodHandlerImg");
        public By foodHandlerTxt = By.id("editCertificationsListItemFoodHandlerLabelText");
        public By foodHandlerChk = By.id("editCertificationsListItemFoodHandlerChk");
        public By foodHandlerChkBox = By.id("editCertificationsListItemFoodHandlerChkBox");
        public By foodHandlerUploadBtn = By.id("editCertificationsListItemFoodHandlerUploadBtn1");
        public By foodProtectionImg = By.id("editCertificationsListItemFoodProtectionManagerImg");
        public By foodProtectionTxt = By.id("editCertificationsListItemFoodProtectionManagerLabelText");
        public By foodProtectionChk = By.id("editCertificationsListItemFoodProtectionManagerChk");
        public By foodProtectionChkBox = By.id("editCertificationsListItemFoodProtectionManagerChkBox");
        public By foodProtectionUploadBtn = By.id("editCertificationsListItemFoodProtectionManagerUploadBtn2");
        public By haccpImg = By.id("editCertificationsListItemHACCPImg");
        public By haccpTxt = By.id("editCertificationsListItemHACCPLabelText");
        public By haccpChk = By.id("editCertificationsListItemHACCPChk");
        public By haccpChkBox = By.id("editCertificationsListItemHACCPChkBox");
        public By haccpUploadBtn = By.id("editCertificationsListItemHACCPUploadBtn3");
        public By saveBtn = By.id("saveProfileCertificationsBtn");
        public By certsSuccessToastDiv = By.cssSelector("div#editProfileCertificationsToast.success");
        public By certsBannerCloseBtn = By.id("editProfileCertificationsToastCloseBtn");
    }

    public static class SkillsPageLocators {
        public By skillsTitleTxt = By.id("editProfileSkillTitle");

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
        public By navMenuSkills = By.id("editProfileSkillsLink");
        public By skillsSuccessToast = By.id("editProfileSkillToast");
        public By skillSuccessToastCloseBtn = By.id("editProfileSkillToastCloseBtn");
    }

    public static class AboutPageLocators {
        public By aboutHeader =  By.id("editProfileAboutTitleText");
        public By aboutTextField =  By.id("editProfileAboutTextArea");
        public By aboutSaveBtn =  By.id("saveProfileAboutBtn");
        public By aboutBannerDiv = By.id("editProfileAboutToast");
        public By aboutSuccessToastDiv = By.cssSelector("div#editProfileAboutToast.success");
        public By aboutBannerCloseBtn = By.id("editProfileAboutToastCloseBtn");
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
    }

    public static class HourlyConnectionPageLocators {
        public By connectionBackBtn = By.id("connectionsBackBtn");
        public By connectionsTitle = By.id("connectionsTitleText");

        /**
         * Locates a connection's photo for a given index
         * @param index The index (Starting at 0) of the user you wish to locate
         * @return Returns a locator for the user card's image by index
         */
        public By findConnectionCardImgByIndex(String index) {
            return By.id("connectionImg" + index);
        }

        /**
         * Locates a connection's name for a given index
         * @param index The index (Starting at 0) of the user you wish to locate
         * @return Returns a locator for the user card's name by index
         */
        public By findConnectionCardNameTxtByIndex(String index) {
            return By.id("connectionNameText" + index);
        }

        /**
         * Locates a connection's work history for a given index
         * @param index The index (Starting at 0) of the user you wish to locate
         * @return Returns a locator for the user card's work history by index
         */
        public By findConnectionCardWorkTxtByIndex(String index) {
            return By.id("connectionPrimaryWorkText" + index);
        }

        /**
         * Locates a connection's location for a given index
         * @param index The index (Starting at 0) of the user you wish to locate
         * @return Returns a locator for the user card's location by index
         */
        public By findConnectionCardLocationTxtByIndex(String index) {
            return By.id("connectionLocationText" + index);
        }

        /**
         * Locates a connection's view button for a given index
         * @param index The index (Starting at 0) of the user you wish to locate
         * @return Returns a locator for the user card's view button by index
         */
        public By findConnectionCardViewBtnByIndex(String index) {
            return By.id("connectionViewBtn" + index);
        }

        public By connectionPage1Btn = By.id("connectionsPage1Btn");
        public By connectionPage2Btn = By.id("connectionsPage2Btn");
        public By connectionPage3Btn = By.id("connectionsPage3Btn");
        public By connectionPage4Btn = By.id("connectionsPage4Btn");
        public By connectionNextPageBtn = By.id("connectionsNextBtn");
        public By connectionPreviousPageBtn = By.id("connectionsPreviousBtn");
    }

    public static class HourlySuggestedConnectionPageLocators {
        public By suggestedConnectionBackBtn = By.id("suggestedConnectionsBackBtn");
        public By suggestedConnectionsTitle = By.id("suggestedConnectionsTitleText");

        /**
         * Locates a suggested connection's photo for a given index
         * @param index The index (Starting at 0) of the user you wish to locate
         * @return Returns a locator for the user card's image by index
         */
        public By findSuggestedConnectionCardImgByIndex(String index) {
            return By.id("suggestedConnectionImg" + index);
        }

        /**
         * Locates a suggested connection's name for a given index
         * @param index The index (Starting at 0) of the user you wish to locate
         * @return Returns a locator for the user card's name by index
         */
        public By findSuggestedConnectionCardNameTxtByIndex(String index) {
            return By.id("suggestedConnectionNameText" + index);
        }

        /**
         * Locates a suggested connection's reason for a given index
         * @param index The index (Starting at 0) of the user you wish to locate
         * @return Returns a locator for the user card's reason by index
         */
        public By findSuggestedConnectionCardReasonTxtByIndex(String index) {
            return By.id("suggestedConnectionConnectionReasonText" + index);
        }

        /**
         * Locates a suggested connection's view button for a given index
         * @param index The index (Starting at 0) of the user you wish to locate
         * @return Returns a locator for the user card's view button by index
         */
        public By findSuggestedConnectionCardViewBtnByIndex(String index) {
            return By.id("suggestedConnectionViewBtn" + index);
        }

        /**
         * Locates a suggested connection's connect button for a given index
         * @param index The index (Starting at 0) of the user you wish to locate
         * @return Returns a locator for the user card's connect button by index
         */
        public By findSuggestedConnectionCardConnectBtnByIndex(String index) {
            return By.id("suggestedConnectionConnectBtn" + index);
        }

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