import okhttp3.OkHttpClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class SeasonedRestAPI {

    Retrofit retrofit;
    SeasonedAPI seasonedAPI;
    String accessToken;

    public SeasonedRestAPI(String accessToken) {
        OkHttpClient httpClient = new OkHttpClient.Builder().readTimeout(20, TimeUnit.SECONDS).connectTimeout(20, TimeUnit.SECONDS).build();
        retrofit = new Retrofit.Builder()
                               .baseUrl(TestConfig.getBaseAPIURL() + "services/rest/")
                               .addConverterFactory(GsonConverterFactory.create())
                               .client(httpClient)
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

    /**
     * Clears out a user's availability for every day of the week
     * @param guid The guid of the user you want to clear availability for
     */
    public void clearAvailabilityForUser(String guid) {
        try {
            /* Construct availability request body */
            AvailabilityUpdate availabilityUpdate = new AvailabilityUpdate();
            Monday monday = new Monday();
            Tuesday tuesday = new Tuesday();
            Wednesday wednesday = new Wednesday();
            Thursday thursday = new Thursday();
            Friday friday = new Friday();
            Saturday saturday = new Saturday();
            Sunday sunday = new Sunday();

            monday.setMornings(false);
            monday.setAfternoons(false);
            monday.setEvenings(false);
            monday.setNights(false);
            availabilityUpdate.setMonday(monday);

            tuesday.setMornings(false);
            tuesday.setAfternoons(false);
            tuesday.setEvenings(false);
            tuesday.setNights(false);
            availabilityUpdate.setTuesday(tuesday);

            wednesday.setMornings(false);
            wednesday.setAfternoons(false);
            wednesday.setEvenings(false);
            wednesday.setNights(false);
            availabilityUpdate.setWednesday(wednesday);

            thursday.setMornings(false);
            thursday.setAfternoons(false);
            thursday.setEvenings(false);
            thursday.setNights(false);
            availabilityUpdate.setThursday(thursday);

            friday.setMornings(false);
            friday.setAfternoons(false);
            friday.setEvenings(false);
            friday.setNights(false);
            availabilityUpdate.setFriday(friday);

            saturday.setMornings(false);
            saturday.setAfternoons(false);
            saturday.setEvenings(false);
            saturday.setNights(false);
            availabilityUpdate.setSaturday(saturday);

            sunday.setMornings(false);
            sunday.setAfternoons(false);
            sunday.setEvenings(false);
            sunday.setNights(false);
            availabilityUpdate.setSunday(sunday);

            /* Make a PUT request to user/guid/availability */
            Call<Availability> call = seasonedAPI.updateAvailability(guid, accessToken, availabilityUpdate);
            call.enqueue(new Callback<Availability>() {
                @Override
                public void onResponse(Call<Availability> call, Response<Availability> response) {
                    System.out.println("PUT request to user/guid/Availability returned with code: " + response.code());
                }

                @Override
                public void onFailure(Call<Availability> call, Throwable t) {
                    System.out.println("PUT request to user/guid/Availability failed with error: " + t.getLocalizedMessage());
                }
            });
        }
        catch(Exception e) {
            System.out.println(e.getLocalizedMessage());
        }
    }

    /**
     * Posts a job to a given employer
     */
    public String postJob() {
        /* Construct Job Request Body */
        String jobGuid = "";
        try {
            Job job = new Job();
            Employer employer = new Employer();
            UpdatedBy updatedBy = new UpdatedBy();
            CreatedBy createdBy = new CreatedBy();
            JobType jobType = new JobType();

            updatedBy.setGuid("48e90677-467e-437e-9f3c-8abb3f07d8ba");
            createdBy.setGuid("48e90677-467e-437e-9f3c-8abb3f07d8ba");
            employer.setGuid("75ced677-4368-4026-9f57-34ba6246c3cb");
            jobType.setGuid("fd1ad822-f2e6-4faf-9d04-d04ac7c3fdcb");
            job.setEmployer(employer);
            job.setUpdatedBy(updatedBy);
            job.setCreatedBy(createdBy);
            job.setJobType(jobType);
            job.setJobName("Bartender");
            job.setWage("1.99");
            job.setWageType("HOURLY");
            job.setDescription("$1.99 are you outta yo mind?");
            job.setStatus("POSTED");

            /* Make a POST request to job */
            Call<Job> call = seasonedAPI.postJob(accessToken, job);
            Response<Job> response = call.execute();
            System.out.println("POST request to /job returned a " + response.code());
            jobGuid = response.body().getGuid();
        }
        catch (Exception e) {
            System.out.println("Call failed with error: " + e.getLocalizedMessage());
        }
        return jobGuid;
    }

    /**
     * Deletes a job for a given employer
     * @param guid The job's guid
     */
    public void deleteJob(String guid) {
        try {
            /* Make a DELETE request to job */
            Call<Job> call = seasonedAPI.deleteJob(guid, accessToken);
            Response<Job> response = call.execute();
            System.out.println("DELETE request to /job/{guid} returned a " + response.code());
        }
        catch(Exception e) {
            System.out.println("Call failed with error: " + e.getLocalizedMessage());
        }
    }

    /**
     * Updates a user's name, email, and phone number
     * @param id The user's id
     * @param userGuid The user's guid
     * @param firstName The user's first name
     * @param lastName The user's last name
     * @param email The user's email address
     * @param phone The user's phone #
     * @param dob The user's date of birth
     * @param accountState The user's account state
     * @param roleGuid  The guid of the user's role
     * @param roleName The name of the user's role
     */
    public void updateUserNameEmailPhoneBday(String id, String userGuid, String firstName, String lastName, String email, String phone, String dob, String accountState, String roleGuid, String roleName) {
        /* Construct Job Request Body */
        try {
            ArrayList<Role> roles = new ArrayList<Role>();

            User user = new User();
            Role role = new Role();

            role.setGuid(roleGuid);
            role.setUserGuid(userGuid);
            role.setRole(roleName);
            roles.add(role);

            user.setId(id);
            user.setGuid(userGuid);
            user.setFirstname(firstName);
            user.setLastname(lastName);
            user.setEmail(email);
            user.setPhone(phone);
            user.setDob(dob);
            user.setAccountState(accountState);
            user.setRoles(roles);

            /* Make a PUT request to user */
            Call<User> call = seasonedAPI.updateUserNameEmailPhoneBday(accessToken, user);
            Response<User> response = call.execute();
            System.out.println("PUT request to /user returned a " + response.code());
        }
        catch (Exception e) {
            System.out.println("Call failed with error: " + e.getLocalizedMessage());
        }
    }

    /**
     * Updates a user's location
     * @param guid The user's guid
     * @param city The location's city
     * @param state The location's state
     * @param zip The location's zip
     * @param country The location's country
     * @param latitude The location's lat
     * @param longitude The location's long
     */
    public void updateUserLocation(String guid, String city, String state, String zip, String country, Double latitude, Double longitude) {
        /* Construct Job Request Body */
        try {
            Location_ location = new Location_();
            Geo geo = new Geo();

            geo.setLatitude(latitude);
            geo.setLongitude(longitude);

            location.setCity(city);
            location.setState(state);
            location.setZip(zip);
            location.setCountry(country);
            location.setGeo(geo);

            /* Make a POST request to primaryLocation */
            Call<Location_> call = seasonedAPI.postUserLocation(guid, accessToken, location);
            Response<Location_> response = call.execute();
            System.out.println("POST request to /primaryLocation returned a " + response.code());
        }
        catch (Exception e) {
            System.out.println("Call failed with error: " + e.getLocalizedMessage());
        }
    }

    /**
     * Sets a user availability status by calling the /user endpoint
     * @param id the db id for the user
     * @param guid the guid of the user you want to set the status of
     * @param firstname user's first name
     * @param lastname user's last name
     * @param email user's email
     * @param empInterestStatus set the user's status to OPEN, LOOKING, or EMPLOYED
     * @param empInterestType set the user's type to ANYTHING, FULL_TIME, PART_TIME, or SEASONAL
     * @param gigInterestStatus set the user's gig status to UNSPECIFIED, NO, YES
     */
    public void setAvailabilityStatus(String id, String guid, String firstname, String lastname, String email, String empInterestStatus, String empInterestType, String gigInterestStatus) {
        try {
            User user = new User();

            user.setId(id);
            user.setGuid(guid);
            user.setFirstname(firstname);
            user.setLastname(lastname);
            user.setEmail(email);
            user.setAccountState("normal");
            user.setEmploymentInterestStatus(empInterestStatus);
            user.setEmploymentInterestType(empInterestType);
            user.setGigInterestStatus(gigInterestStatus);

            /* Make a PUT request to user */
            Call<User> call = seasonedAPI.setAvailabilityStatus(accessToken, user);
            Response<User> response = call.execute();
            System.out.println("PUT request to /user returned a " + response.code());
        }
        catch(Exception e) {
            System.out.println("PUT request to /user failed with error: " + e.getLocalizedMessage());
        }
    }

    /** Updates a user's about section by calling the /user endpoint
     * @param id the db id for the user
     * @param guid the guid for the user to update
     * @param firstname user's firstname
     * @param lastname user's lastname
     * @param email user's email
     * @param about The about string to set for the user
     */
    public void updateUserAbout(String id, String guid, String firstname, String lastname, String email, String about) {
        try {
            User user = new User();

            user.setId(id);
            user.setGuid(guid);
            user.setFirstname(firstname);
            user.setLastname(lastname);
            user.setEmail(email);

            user.setAbout(about);

            /* Make a PUT request to /user */
            Call<User> call = seasonedAPI.updateUserAbout(accessToken, user);
            Response<User> response = call.execute();
            System.out.println("PUT request to /user returned a: " + response.code());
        }
        catch(Exception e) {
            System.out.println("PUT request to /user failed with error: " + e.getLocalizedMessage());
        }
    }

    /**
     * Posts a connection request from user a to user b
     * @param fromUserGuid The guid of the user sending the connection request
     * @param toUserGuid The guid of the user receiving the connection request
     */
    public void postConnectionRequest(String fromUserGuid, String toUserGuid) {
        /* Construct Job Request Body */
        try {
            Network network = new Network();

            network.setFromUserGuid(fromUserGuid);
            network.setToUserGuid(toUserGuid);

            /* Make a POST request to network */
            Call<Network> call = seasonedAPI.postNetworkConnection(accessToken, network);
            Response<Network> response = call.execute();
            System.out.println("POST request to /network returned a " + response.code());
        }
        catch (Exception e) {
            System.out.println("Call failed with error: " + e.getLocalizedMessage());
        }
    }

    /**
     * Accept a connection request
     * @param fromUserGuid The guid of the user sending the connection request
     * @param toUserGuid The guid of the user receiving the connection request
     */
    public void updateConnectionRequest(String fromUserGuid, String toUserGuid) {
        /* Construct Job Request Body */
        try {
            Network network = new Network();

            network.setFromUserGuid(fromUserGuid);
            network.setToUserGuid(toUserGuid);

            /* Make a PUT request to network */
            Call<Network> call = seasonedAPI.updateNetworkConnection(accessToken, network);
            Response<Network> response = call.execute();
            System.out.println("PUT request to /network/accept returned a " + response.code());
        }
        catch (Exception e) {
            System.out.println("Call failed with error: " + e.getLocalizedMessage());
        }
    }

    /**
     * Delete a connection request
     * @param fromUserGuid The guid of the user sending the connection request
     * @param toUserGuid The guid of the user receiving the connection request
     */
    public void deleteConnection(String fromUserGuid, String toUserGuid) {
        /* Construct Job Request Body */
        try {
            Network network = new Network();

            network.setFromUserGuid(fromUserGuid);
            network.setToUserGuid(toUserGuid);

            /* Make a DELETE request to network */
            Call<Network> call = seasonedAPI.deleteNetworkConnection(accessToken, fromUserGuid, toUserGuid);
            Response<Network> response = call.execute();
            System.out.println("Delete request to /network/between/{guid}/{guid} returned a " + response.code());
        }
        catch (Exception e) {
            System.out.println("Delete request to /network/between/{guid}/{guid} failed with error: " + e.getLocalizedMessage());
        }
    }

    /**
     * Unfollows an employer
     * @param employerGuid The guid of the employer to unfollow
     * @param userGuid The guid of the user that is unfollowing
     */
    public void unfollowEmployer(String employerGuid, String userGuid) {
        /* Construct Job Request Body */
        try {
            User user = new User();

            user.setGuid(userGuid);

            /* Make a POST request to unfollow an employer */
            Call<User> call = seasonedAPI.unFollowEmployer(employerGuid, accessToken, user);
            Response<User> response = call.execute();
            System.out.println("POST request to /employer/{guid/unfollow returned a " + response.code());
        }
        catch (Exception e) {
            System.out.println("Call failed with error: " + e.getLocalizedMessage());
        }
    }
}
