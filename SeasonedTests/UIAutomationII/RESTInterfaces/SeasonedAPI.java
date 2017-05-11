import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;

public interface SeasonedAPI {

    @PUT("user/{guid}/eligibility")
    Call<User> updateEligibility(@Path("guid") String guid, @Header("Authorization") String accessToken, @Body List<EligibilityAnswers> eligibility);

    @PUT("user/{guid}/availability")
    Call<Availability> updateAvailability(@Path("guid") String guid, @Header("Authorization") String accessToken, @Body AvailabilityUpdate availabilityUpdate);

    @POST("job")
    Call<Job> postJob(@Header("Authorization") String accessToken, @Body Job job);

    @DELETE("job/{guid}")
    Call<Job> deleteJob(@Path("guid") String guid, @Header("Authorization") String accessToken);

    @GET("user/{guid}")
    Call<User> getUser(@Path("guid") String guid, @Header("Authorization") String accessToken);

    @PUT("user")
    Call<User> updateUserNameEmailPhone(@Header("Authorization") String accessToken, @Body User user);

    @GET("employer/{guid}/employees/count")
    Call<EmployeeCount> getEmployeeCount(@Path("guid") String guid, @Header("Authorization") String accessToken);

    @POST("user/{guid}/primaryLocation")
    Call<Location_> postUserLocation(@Path("guid") String guid, @Header("Authorization") String accessToken, @Body Location_ location);
}
