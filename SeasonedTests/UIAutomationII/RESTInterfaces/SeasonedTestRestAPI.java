import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.util.ArrayList;

public class SeasonedTestRestAPI {

    Retrofit retrofit;
    SeasonedAPI seasonedAPI;
    String accessToken;

    public SeasonedTestRestAPI(String accessToken) {
        retrofit = new Retrofit.Builder()
                               .baseUrl("http://hsp-load-balancer-851875221.us-west-2.elb.amazonaws.com/services/services/rest/")
                               .addConverterFactory(GsonConverterFactory.create())
                               .build();
        seasonedAPI = retrofit.create(SeasonedAPI.class);
        this.accessToken = accessToken;
    }

    /**
     * Clears out a user's eligibility questions by setting it to null
     * @param guid the user guid you want to clear
     */
    public void clearEligibilityAnswersForUser(String guid) {
        try {
            ArrayList<EligibilityAnswers> eligibilityAnswers = new ArrayList<EligibilityAnswers>();

            /* Construct eligibility json request body */
            EligibilityAnswers age = new EligibilityAnswers();
            age.setQuestionGuid("a7c54279-16de-4fb3-b3cc-53501c5ac071");
            age.setQuestionText("At least 18 years of age.");
            age.setPreferenceText(null);
            age.setAffirmationText("I'm at least 18 years old.");
            age.setNegationText("No, I'm not at least 18 years old.");
            age.setAnswer(null);
            age.setPreferenceValue(null);

            EligibilityAnswers transport = new EligibilityAnswers();
            transport.setQuestionGuid("e5f0f135-cea3-46bf-9c65-05ab1a95a73d");
            transport.setQuestionText("Has reliable transportation.");
            transport.setPreferenceText(null);
            transport.setAffirmationText("I have reliable transportation.");
            transport.setNegationText("No, I do not have reliable transportation.");
            transport.setAnswer(null);
            transport.setPreferenceValue(null);

            EligibilityAnswers legal = new EligibilityAnswers();
            legal.setQuestionGuid("08de00eb-5a26-42f5-b11f-8540cf49ebcc");
            legal.setQuestionText("Legally eligible to work in the U.S.A.");
            legal.setPreferenceText(null);
            legal.setAffirmationText("I'm legally eligible to work in the United States.");
            legal.setNegationText("No, I'm not legally eligible to work in the USA.");
            legal.setAnswer(null);
            legal.setPreferenceValue(null);


            eligibilityAnswers.add(age);
            eligibilityAnswers.add(transport);
            eligibilityAnswers.add(legal);

            /* Make a PUT request to user/guid/eligibility */
            Call<User> call = seasonedAPI.updateEligibility(guid, accessToken, eligibilityAnswers);
            call.enqueue(new Callback<User>() {
                @Override
                public void onResponse(Call<User> call, Response<User> response) {
                    System.out.println("PUT request to user/guid/eligibility returned with code: " + response.code());
                }

                @Override
                public void onFailure(Call<User> call, Throwable t) {
                    System.out.println("PUT request to user/guid/eligibility failed with error: " + t.getLocalizedMessage());
                }
            });
        }
        catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }
    }

    /*public static void main(String[] args) throws Exception {

        try {
            EligibilityAnswers age = new EligibilityAnswers();
            age.setQuestionGuid("a7c54279-16de-4fb3-b3cc-53501c5ac071");
            age.setQuestionText("At least 18 years of age.");
            age.setPreferenceText(null);
            age.setAffirmationText("I'm at least 18 years old.");
            age.setNegationText("No, I'm not at least 18 years old.");
            age.setAnswer(null);
            age.setPreferenceValue(null);

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("http://hsp-load-balancer-851875221.us-west-2.elb.amazonaws.com/services/services/rest/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            SeasonedAPI seasonedAPI = retrofit.create(SeasonedAPI.class);

            Call<User> call = seasonedAPI.getUser("791e969f-3c04-4739-a459-09bf5e88c800", "Bearer 821127bb-5e37-4376-afe5-e29a601e9001");
            call.enqueue(new Callback<User>() {
                @Override
                public void onResponse(Call<User> call, Response<User> response) {
                    System.out.println(response.code());
                    System.out.println(response.body());
                }

                @Override
                public void onFailure(Call<User> call, Throwable throwable) {
                    System.out.println("SAD! " + throwable.getMessage());
                }
            });
        } catch (Exception e) {
            System.out.println("You wiretapped my tower.");
        }
    }*/
}
