import retrofit2.Call;
import retrofit2.http.*;

import java.util.ArrayList;
import java.util.List;

public interface SeasonedAPI {

    /*-------- User Endpoints --------*/

    @PUT("user")
    Call<User> setAvailabilityStatus(@Header("Authorization") String accessToken, @Body User user);

    @PUT("user/{guid}/eligibility")
    Call<User> updateEligibility(@Path("guid") String guid, @Header("Authorization") String accessToken, @Body List<EligibilityAnswers> eligibility);

    @PUT("user/{guid}/availability")
    Call<Availability> updateAvailability(@Path("guid") String guid, @Header("Authorization") String accessToken, @Body AvailabilityUpdate availabilityUpdate);

    @GET("user/{guid}")
    Call<User> getUser(@Path("guid") String guid, @Header("Authorization") String accessToken);

    @PUT("user")
    Call<User> updateUserNameEmailPhoneBday(@Header("Authorization") String accessToken, @Body User user);

    @POST("user/{guid}/primaryLocation")
    Call<Location_> postUserLocation(@Path("guid") String guid, @Header("Authorization") String accessToken, @Body Location_ location);

    @PUT("user")
    Call<User> updateUserAbout(@Header("Authorization") String accessToken, @Body User user);

    @PUT("user")
    Call<User> clearUserSkills(@Header("Authorization") String accessToken, @Body User user);

    @PUT("user/{guid}/certifications")
    Call<User> clearUserCertifications(@Path("guid") String guid, @Header("Authorization") String accessToken, @Body ArrayList<Certification> certs);

    @DELETE("user/{userGuid}/education/{educationGuid}")
    Call<User> deleteUserEducation(@Path("userGuid") String userGuid, @Path("educationGuid") String educationGuid, @Header("Authorization") String accessToken);

    /*-------- Job Endpoints --------*/

    @POST("job")
    Call<Job> postJob(@Header("Authorization") String accessToken, @Body Job job);

    @DELETE("job/{guid}")
    Call<Job> deleteJob(@Path("guid") String guid, @Header("Authorization") String accessToken);

    /*-------- Employer Endpoints --------*/

    @GET("employer/{guid}/employees/count")
    Call<EmployeeCount> getEmployeeCount(@Path("guid") String guid, @Header("Authorization") String accessToken);

    @POST("employer/{employerGuid}/unfollow")
    Call<User> unFollowEmployer(@Path("employerGuid") String employerGuid, @Header("Authorization") String accessToken, @Body User user);

    @POST("employer/{employerGuid}/unclaim")
    Call<Employer> unclaimEmployer(@Path("employerGuid") String employerGuid, @Header("Authorization") String accessToken);

    @DELETE("employer/{employerGuid}/admins/{adminGuid}")
    Call<Employer> deleteAdmin(@Header("Authorization") String accessToken, @Path("employerGuid") String employerGuid, @Path("adminGuid") String adminGuid);

    @DELETE("employer/logo/{employerGuid}")
    Call<Employer> deleteEmployerLogo(@Path("employerGuid") String employerGuid, @Header("Authorization") String accessToken);

    @DELETE("employer/photos/{employerGuid}/{photoGuid}")
    Call<Employer> deleteEmployerPhotos(@Path("employerGuid") String employerGuid, @Path("photoGuid") String photoGuid, @Header("Authorization") String accessToken);

    @PUT("employer/{employerGuid}")
    Call<Employer> updateEmployerInfo(@Path("employerGuid") String employerGuid, @Header("Authorization") String accessToken, @Body Employer employer);

    @DELETE("employer/{employerGuid}/staff/{staffGuid}")
    Call<Employer> deleteStaffMember(@Path("employerGuid") String employerGuid, @Path("staffGuid") String userGuid, @Header("Authorization") String accessToken);

    /*-------- Network Endpoints --------*/

    @POST("network")
    Call<Network> postNetworkConnection(@Header("Authorization") String accessToken, @Body Network network);

    @PUT("network/accept")
    Call<Network> updateNetworkConnection(@Header("Authorization") String accessToken, @Body Network network);

    @DELETE("network/between/{fromUserGuid}/{toUserGuid}")
    Call<Network> deleteNetworkConnection(@Header("Authorization") String accessToken, @Path("fromUserGuid") String fromUserGuid, @Path("toUserGuid") String toUserGuid);

    /*-------- Content Endpoints --------*/

    @POST("content/article")
    Call<Content> postArticle(@Header("Authorization") String accessToken, @Body Content content);

    @PUT("content/article")
    Call<Content> updateArticlePublishedStatus(@Header("Authorization") String accessToken, @Body Content content);

    @DELETE("content/article/{guid}")
    Call<Content> deleteArticle(@Path("guid") String guid, @Header("Authorization") String accessToken);

    /*-------- HotSchedules Autoprovision Endpoints --------*/
    @POST("test/sqs/user")
    Call<SQS> sendHSUserToSqs(@Header("Authorization") String accessToken, @Body SQS sqs);

    @POST("scheduler/runner/{guid}")
    Call<SQS> runTask(@Path("guid") String guid, @Header("Authorization") String accessToken);

    /*-------- Work History Endpoints --------*/
    @DELETE("workhistory/placeWorked/{workHistoryGuid}")
    Call<PrimaryWorkHistory> deleteWorkHistory(@Path("workHistoryGuid") String workHistoryGuid, @Header("Authorization") String accessToken);
}
