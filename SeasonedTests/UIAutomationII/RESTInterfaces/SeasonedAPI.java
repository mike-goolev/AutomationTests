import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;

public interface SeasonedAPI {

    @PUT("user/{guid}/eligibility")
    Call<User> updateEligibility(@Path("guid") String guid, @Header("Authorization") String accessToken, @Body List<EligibilityAnswers> eligibility);

    @GET("user/{guid}")
    Call<User> getUser(@Path("guid") String guid, @Header("Authorization") String accessToken);

    @GET("employer/{guid}/employees/count")
    Call<EmployeeCount> getEmployeeCount(@Path("guid") String guid, @Header("Authorization") String accessToken);

}
