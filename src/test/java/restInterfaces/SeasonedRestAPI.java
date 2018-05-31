package restInterfaces;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.HttpUrl;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import utils.TestConfig;
import jsonModels.*;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class SeasonedRestAPI {

    Retrofit retrofit;
    SeasonedAPI seasonedAPI;
    String accessToken;

    /**
     * Constructor with oauth url
     */
    public SeasonedRestAPI() {
        // Create logging interceptor
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BASIC);

        // Create http client
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder()
                .readTimeout(20, TimeUnit.SECONDS)
                .connectTimeout(20, TimeUnit.SECONDS)
                .addNetworkInterceptor(logging);
//              .addInterceptor(new LoggingInterceptor());
        // Create retrofit instance
        retrofit = new Retrofit.Builder()
                .baseUrl(TestConfig.getBaseApiUrl().replace("rest/", ""))
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient.build())
                .build();
        seasonedAPI = retrofit.create(SeasonedAPI.class);

    }

    public SeasonedRestAPI(String accessToken) {
        // Create logging interceptor
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        // NONE -> No logs
        // BASIC -> Logs request and response lines.
        // BODY -> Logs request and response lines and their respective headers and bodies (if present).
        // HEADERS -> Logs request and response lines and their respective headers.
        logging.setLevel(HttpLoggingInterceptor.Level.BASIC);

        // Create http client
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder()
                .readTimeout(20, TimeUnit.SECONDS)
                .connectTimeout(20, TimeUnit.SECONDS)
                .addNetworkInterceptor(logging);
//                .addInterceptor(new LoggingInterceptor());
        // Create retrofit instance
        retrofit = new Retrofit.Builder()
                .baseUrl(TestConfig.getBaseApiUrl())
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient.build())
                .build();

        seasonedAPI = retrofit.create(SeasonedAPI.class);
        this.accessToken = accessToken;
    }

    private String getRequestUrl(Request request) {
        HttpUrl requestUrl = request.url();
        System.out.println(requestUrl);
        return requestUrl.toString();
    }

    /**
     * Clears out a user's eligibility questions by setting it to null
     *
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
                    System.out.println("PUT request to " + getRequestUrl(call.request()) + "\nStatus code: " + response.code());
                }

                @Override
                public void onFailure(Call<User> call, Throwable t) {
                    System.out.println("PUT request to " + getRequestUrl(call.request()) + " failed with error: \n" + t.getLocalizedMessage());
                }
            });
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }
    }

    /**
     * Clears out a user's availability for every day of the week
     *
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
            Response<Availability> response  = call.execute();
            System.out.println("PUT request to " + getRequestUrl(call.request()) + "\nStatus code: " + response.code());
        } catch (Exception e) {
            System.out.println("PUT request to /user/" + guid + "/availability" + " failed with error: \n" + e.getLocalizedMessage());
        }
    }

    /**
     * Posts a job to a given employer
     */
    public String postJob(String updatedByGuid, String createdByGuid, String jobTypeGuid, String employerGuid, String jobName, String jobWage, String minWage, String maxWage, String jobWageType, String jobDescription, String jobStatus) {
        /* Construct Job Request Body */
        String jobGuid = "";
        try {
            Job job = new Job();
            Employer employer = new Employer();
            UpdatedBy updatedBy = new UpdatedBy();
            CreatedBy createdBy = new CreatedBy();
            JobType jobType = new JobType();

            updatedBy.setGuid(updatedByGuid);
            createdBy.setGuid(createdByGuid);
            employer.setGuid(employerGuid);
            jobType.setGuid(jobTypeGuid);
            job.setEmployer(employer);
            job.setUpdatedBy(updatedBy);
            job.setCreatedBy(createdBy);
            job.setJobType(jobType);
            job.setJobName(jobName);
            job.setWage(jobWage);
            job.setMinWage(minWage);
            job.setMaxWage(maxWage);
            job.setWageType(jobWageType);
            job.setDescription(jobDescription);
            job.setStatus(jobStatus);

            /* Make a POST request to job */
            Call<Job> call = seasonedAPI.postJob(accessToken, job);
            Response<Job> response = call.execute();
            System.out.println("POST request to " + getRequestUrl(call.request()) + "\nStatus code: " + response.code());
            jobGuid = response.body().getGuid();
        } catch (Exception e) {
            System.out.println("POST request to /job" + " failed with error: \n" + e.getLocalizedMessage());
        }
        return jobGuid;
    }

    /**
     * Deletes a job for a given employer
     *
     * @param guid The job's guid
     */
    public void deleteJob(String guid) {
        try {
            /* Make a DELETE request to job */
            Call<Job> call = seasonedAPI.deleteJob(guid, accessToken);
            Response<Job> response = call.execute();
            System.out.println("DELETE request to /job " + getRequestUrl(call.request()) + "\nStatus code: " + response.code());
        } catch (Exception e) {
            System.out.println("DELETE request to /job" + " failed with error: \n" + e.getLocalizedMessage());
        }
    }

    /**
     * Submits an application to an active job posting
     *
     * @param userId   the id for the user
     * @param userGuid the guid for the user
     * @param jobGuid  the guid for the job application
     */
    public void postApplication(String userId, String userGuid, String jobGuid) {
        /* Construct User Request Body */
        try {
            User user = new User();
            user.setId(userId);
            user.setGuid(userGuid);

            /* Make a POST request to /job/jobGuid/hireme */
            Call<User> call = seasonedAPI.postApplication(jobGuid, user, accessToken);
            Response<User> response = call.execute();
            System.out.println("POST request to " + getRequestUrl(call.request()) + "\nStatus code: " + response.code());
        } catch (Exception e) {
            System.out.println("POST request to job/" + jobGuid + "/hireme failed with error: \n" + e.getLocalizedMessage());
        }
    }

    /**
     * Updates a user's name, email, and phone number
     *
     * @param id           The user's id
     * @param userGuid     The user's guid
     * @param firstName    The user's first name
     * @param lastName     The user's last name
     * @param email        The user's email address
     * @param phone        The user's phone #
     * @param dob          The user's date of birth
     * @param accountState The user's account state
     * @param roleGuid     The guid of the user's role
     * @param roleName     The name of the user's role
     * @param firstJob     Whether or not the user is searching for their first job
     */
    public void updateUserNameEmailPhoneBday(String id, String userGuid, String firstName, String lastName, String email, String phone, String dob, String accountState, String roleGuid, String roleName, Boolean firstJob) {
        /* Construct User Request Body */
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
            user.setFirstJobSearch(firstJob);

            /* Make a PUT request to user */
            Call<User> call = seasonedAPI.updateUserNameEmailPhoneBday(accessToken, user);
            Response<User> response = call.execute();
            System.out.println("PUT request to " + getRequestUrl(call.request()) + "\nStatus code: " + response.code());
        } catch (Exception e) {
            System.out.println("PUT request to /user" + " failed with error: \n" + e.getLocalizedMessage());
        }
    }

    /**
     * Updates a user's location
     *
     * @param guid      The user's guid
     * @param city      The location's city
     * @param state     The location's state
     * @param zip       The location's zip
     * @param country   The location's country
     * @param latitude  The location's lat
     * @param longitude The location's long
     */
    public void updateUserLocation(String guid, String city, String state, String zip, String country, Double latitude, Double longitude) {
        /* Construct Location Request Body */
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
            System.out.println("POST request to " + getRequestUrl(call.request()) + "\nStatus code: " + response.code());
        } catch (Exception e) {
            System.out.println("POST request to user/" + guid + "/primarylocation" + " failed with error: \n" + e.getLocalizedMessage());
        }
    }

    /**
     * Sets a user availability status by calling the /user endpoint
     *
     * @param id                the db id for the user
     * @param guid              the guid of the user you want to set the status of
     * @param firstname         user's first name
     * @param lastname          user's last name
     * @param email             user's email
     * @param empInterestStatus set the user's status to OPEN, LOOKING, or EMPLOYED
     * @param empInterestType   set the user's type to ANYTHING, FULL_TIME, PART_TIME, or SEASONAL
     * @param gigInterestStatus set the user's gig status to UNSPECIFIED, NO, YES
     */
    public void setAvailabilityStatus(String id, String guid, String firstname, String lastname, String email, String empInterestStatus, String empInterestType, String gigInterestStatus) {
        /* Construct User Request Body */
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
            System.out.println("PUT request to " + getRequestUrl(call.request()) + "\nStatus code: " + response.code());
        } catch (Exception e) {
            System.out.println("PUT request to /user/" + guid + "/availability" + " failed with error: \n" + e.getLocalizedMessage());
        }
    }

    /**
     * Updates a user's about section by calling the /user endpoint
     *
     * @param id        the db id for the user
     * @param guid      the guid for the user to update
     * @param firstname user's firstname
     * @param lastname  user's lastname
     * @param email     user's email
     * @param about     The about string to set for the user
     */
    public void updateUserAbout(String id, String guid, String firstname, String lastname, String email, String about) {
        /* Construct User Request Body */
        try {
            User user = new User();
            user.setId(id);
            user.setGuid(guid);
            user.setFirstname(firstname);
            user.setLastname(lastname);
            user.setEmail(email);
            user.setAccountState("normal");
            user.setAbout(about);

            /* Make a PUT request to /user */
            Call<User> call = seasonedAPI.updateUserAbout(accessToken, user);
            Response<User> response = call.execute();
            System.out.println("PUT request to " + getRequestUrl(call.request()) + "\nStatus code: " + response.code());
        } catch (Exception e) {
            System.out.println("PUT request to /user" + " failed with error: \n" + e.getLocalizedMessage());
        }
    }

    /**
     * Clears any skills from the user
     *
     * @param id        the db id for the user
     * @param guid      the guid for the user to update
     * @param firstname user's firstname
     * @param lastname  user's lastname
     * @param email     user's email
     */
    public void clearUserSkills(String id, String guid, String firstname, String lastname, String email) {
        try {
            User user = new User();
            user.setId(id);
            user.setGuid(guid);
            user.setFirstname(firstname);
            user.setLastname(lastname);
            user.setEmail(email);
            user.setAccountState("normal");
            user.setSkills(new ArrayList<>());

            Call<User> call = seasonedAPI.clearUserSkills(accessToken, user);
            Response<User> response = call.execute();
            System.out.println("PUT request to " + getRequestUrl(call.request()) + "\nStatus code: " + response.code());
        } catch (Exception e) {
            System.out.println("PUT request to /user" + " failed with error: \n" + e.getLocalizedMessage());
        }
    }

    /**
     * Clears out a user's certifications
     *
     * @param guid the guid for the user
     */
    public void clearUserCertifications(String guid) {
        try {
            /* Construct the call with an empty arraylist of certifications to clear all certs */
            Call<User> call = seasonedAPI.clearUserCertifications(guid, accessToken, new ArrayList<Certification>());
            Response<User> response = call.execute();
            System.out.println("PUT request to " + getRequestUrl(call.request()) + "\nStatus code: " + response.code());
        } catch (Exception e) {
            System.out.println("PUT request to /user/" + guid + "certifications" + " failed with error: \n" + e.getLocalizedMessage());
        }
    }

    /**
     * Deletes work history for a user by guid
     *
     * @param workHistoryGuid The user's work history guid
     */
    public void deleteWorkHistoryByGuid(String workHistoryGuid) {
        try {
            /* Make a DELETE request to work history */
            Call<PrimaryWorkHistory> call = seasonedAPI.deleteWorkHistory(workHistoryGuid, accessToken);
            Response<PrimaryWorkHistory> response = call.execute();
            System.out.println("DELETE request to " + getRequestUrl(call.request()) + "\nStatus code: " + response.code());
        } catch (Exception e) {
            System.out.println("DELETE request to workhistory/placeWorked/" + workHistoryGuid + " failed with error: \n" + e.getLocalizedMessage());
        }
    }

    /**
     * Deletes education for a user by guid
     *
     * @param userGuid      the user's guid
     * @param educationGuid the user's education guid
     */
    public void deleteEducationByGuid(String userGuid, String educationGuid) {
        try {
            /* Make a DELETE request to education */
            Call<User> call = seasonedAPI.deleteUserEducation(userGuid, educationGuid, accessToken);
            Response<User> response = call.execute();
            System.out.println("DELETE request to " + getRequestUrl(call.request()) + "\nStatus code: " + response.code());
        } catch (Exception e) {
            System.out.println("DELETE request to user/" + userGuid + "/education/" + educationGuid + " failed with error: \n" + e.getLocalizedMessage());
        }
    }

    /**
     * Posts a connection request from user a to user b
     *
     * @param fromUserGuid The guid of the user sending the connection request
     * @param toUserGuid   The guid of the user receiving the connection request
     */
    public void postConnectionRequest(String fromUserGuid, String toUserGuid) {
        /* Construct Network Request Body */
        try {
            Network network = new Network();
            network.setFromUserGuid(fromUserGuid);
            network.setToUserGuid(toUserGuid);

            /* Make a POST request to network */
            Call<Network> call = seasonedAPI.postNetworkConnection(accessToken, network);
            Response<Network> response = call.execute();
            System.out.println("POST request to " + getRequestUrl(call.request()) + "\nStatus code: " + response.code());
        } catch (Exception e) {
            System.out.println("POST request to /network failed with error: \n" + e.getLocalizedMessage());
        }
    }

    /**
     * Accept a connection request
     *
     * @param fromUserGuid The guid of the user sending the connection request
     * @param toUserGuid   The guid of the user receiving the connection request
     */
    public void updateConnectionRequest(String fromUserGuid, String toUserGuid) {
        /* Construct Network Request Body */
        try {
            Network network = new Network();
            network.setFromUserGuid(fromUserGuid);
            network.setToUserGuid(toUserGuid);

            /* Make a PUT request to network */
            Call<Network> call = seasonedAPI.updateNetworkConnection(accessToken, network);
            Response<Network> response =  call.execute() ;
            System.out.println("PUT request to " + getRequestUrl(call.request()) + "\nStatus code: " + response.code());
        } catch (Exception e) {
            System.out.println("PUT request to network/accept failed with error: \n" + e.getLocalizedMessage());
        }
    }

    /**
     * Delete a connection request
     *
     * @param fromUserGuid The guid of the user sending the connection request
     * @param toUserGuid   The guid of the user receiving the connection request
     */
    public void deleteConnection(String fromUserGuid, String toUserGuid) {
        /* Construct Network Request Body */
        try {
            Network network = new Network();
            network.setFromUserGuid(fromUserGuid);
            network.setToUserGuid(toUserGuid);

            /* Make a DELETE request to network */
            Call<Network> call = seasonedAPI.deleteNetworkConnection(accessToken, fromUserGuid, toUserGuid);
            Response<Network> response = call.execute();
            System.out.println("DELETE request to " + getRequestUrl(call.request()) + "\nStatus code: " + response.code());
        } catch (Exception e) {
            System.out.println("DELETE request to network/between/" + fromUserGuid + "/" + toUserGuid + " failed with error: \n" + e.getLocalizedMessage());
        }
    }

    /**
     * Unclaims an employer
     *
     * @param employerGuid The guid of the employer to unclaim
     */
    public void unclaimEmployer(String employerGuid) {
        try {
            /* Make a POST request to unclaim an employer */
            Call<Employer> call = seasonedAPI.unclaimEmployer(employerGuid, accessToken);
            Response<Employer> response = call.execute();
            System.out.println("POST request to " + getRequestUrl(call.request()) + "\nStatus code: " + response.code());
        } catch (Exception e) {
            System.out.println("POST request to employer/" + employerGuid + "/unclaim failed with error: \n" + e.getLocalizedMessage());
        }
    }

    /**
     * Deletes an employer logo
     *
     * @param employerGuid The guid of the employer logo to remove
     */
    public void deleteEmployerLogo(String employerGuid) {
        try {
            /* Make a DELETE request to remove an employer's logo */
            Call<Employer> call = seasonedAPI.deleteEmployerLogo(employerGuid, accessToken);
            call.enqueue(new Callback<Employer>() {
                @Override
                public void onResponse(Call<Employer> call, Response<Employer> response) {
                    System.out.println("DELETE request to " + getRequestUrl(call.request()) + "\nStatus code: " + response.code());
                }

                @Override
                public void onFailure(Call<Employer> call, Throwable t) {
                    System.out.println("DELETE request to " + getRequestUrl(call.request()) + " failed with error: \n" + t.getLocalizedMessage());
                }
            });
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }
    }

    /**
     * Deletes an employer's photos
     *
     * @param employerGuid The guid of the employer photo to remove
     * @param photoGuid    The guid of the photo to remove
     */
    public void deleteEmployerPhotos(String employerGuid, String photoGuid) {
        try {
            /* Make a DELETE request to remove an employer's photos */
            Call<Employer> call = seasonedAPI.deleteEmployerPhotos(employerGuid, photoGuid, accessToken);
            call.enqueue(new Callback<Employer>() {
                @Override
                public void onResponse(Call<Employer> call, Response<Employer> response) {
                    System.out.println("DELETE request to " + getRequestUrl(call.request()) + "\nStatus code: " + response.code());
                }

                @Override
                public void onFailure(Call<Employer> call, Throwable t) {
                    System.out.println("DELETE request to " + getRequestUrl(call.request()) + " failed with error: \n" + t.getLocalizedMessage());
                }
            });
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }
    }

    /**
     * Unfollows an employer
     *
     * @param employerGuid The guid of the employer to unfollow
     * @param userGuid     The guid of the user that is unfollowing
     */
    public void unfollowEmployer(String employerGuid, String userGuid) {
        /* Construct User Request Body */
        try {
            User user = new User();
            user.setGuid(userGuid);

            /* Make a POST request to unfollow an employer */
            Call<User> call = seasonedAPI.unFollowEmployer(employerGuid, accessToken, user);
            call.enqueue(new Callback<User>() {
                @Override
                public void onResponse(Call<User> call, Response<User> response) {
                    System.out.println("POST request to " + getRequestUrl(call.request()) + "\nStatus code: " + response.code());
                }

                @Override
                public void onFailure(Call<User> call, Throwable t) {
                    System.out.println("POST request to " + getRequestUrl(call.request()) + " failed with error: \n" + t.getLocalizedMessage());
                }
            });
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }
    }

    /**
     * Delete an admin
     *
     * @param employerGuid The employer's guid
     * @param adminGuid    The admin's guid
     */
    public void deleteAdmin(String employerGuid, String adminGuid) {
        try {
            /* Make a DELETE request to employer admins */
            Call<Employer> call = seasonedAPI.deleteAdmin(accessToken, employerGuid, adminGuid);
            call.enqueue(new Callback<Employer>() {
                @Override
                public void onResponse(Call<Employer> call, Response<Employer> response) {
                    System.out.println("DELETE request to " + getRequestUrl(call.request()) + "\nStatus code: " + response.code());
                }

                @Override
                public void onFailure(Call<Employer> call, Throwable t) {
                    System.out.println("DELETE request to " + getRequestUrl(call.request()) + " failed with error: \n" + t.getLocalizedMessage());
                }
            });
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }
    }

    /**
     * Updates an employer's info section
     *
     * @param id       the db id for the employer
     * @param guid     the guid for the employer to update
     * @param name     employer's name
     * @param address1 employer's street address
     * @param city     employer's city
     * @param state    employer's state
     * @param zip      employer's zip
     * @param country  employer's country
     * @param phone    employer's phone
     * @param url      employer's website
     * @param about    employer's description
     */
    public void updateEmployerInfo(Long id, String guid, String name, String address1, String city, String state, String zip, String country, String phone, String url, String about, Long employerTypeId, String employerTypeName) {
        /* Construct User Request Body */
        try {
            Location location = new Location();
            EmployerType employerType = new EmployerType();
            Employer employer = new Employer();

            location.setAddress1(address1);
            location.setCity(city);
            location.setState(state);
            location.setZip(zip);
            location.setCountry(country);

            employerType.setId(employerTypeId);
            employerType.setName(employerTypeName);

            employer.setId(id);
            employer.setGuid(guid);
            employer.setName(name);
            employer.setLocation(location);
            employer.setPhone(phone);
            employer.setUrl(url);
            employer.setAbout(about);
            employer.setEmployerType(employerType);

            /* Make a PUT request to /employer */
            Call<Employer> call = seasonedAPI.updateEmployerInfo(guid, accessToken, employer);
            call.enqueue(new Callback<Employer>() {
                @Override
                public void onResponse(Call<Employer> call, Response<Employer> response) {
                    System.out.println("PUT request to " + getRequestUrl(call.request()) + "\nStatus code: " + response.code());
                }

                @Override
                public void onFailure(Call<Employer> call, Throwable t) {
                    System.out.println("PUT request to " + getRequestUrl(call.request()) + " failed with error: \n" + t.getLocalizedMessage());
                }
            });
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }
    }

    /**
     * Delete a staff member
     *
     * @param employerGuid The employer's guid
     * @param staffGuid    The staff member's guid
     */
    public void deleteStaffMember(String employerGuid, String staffGuid) {
        try {
            /* Make a DELETE request to employer */
            Call<Employer> call = seasonedAPI.deleteStaffMember(employerGuid, staffGuid, accessToken);
            call.enqueue(new Callback<Employer>() {
                @Override
                public void onResponse(Call<Employer> call, Response<Employer> response) {
                    System.out.println("DELETE request to " + getRequestUrl(call.request()) + "\nStatus code: " + response.code());
                }

                @Override
                public void onFailure(Call<Employer> call, Throwable t) {
                    System.out.println("DELETE request to " + getRequestUrl(call.request()) + " failed with error: \n" + t.getLocalizedMessage());
                }
            });
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }
    }

    /**
     * Create a new article
     *
     * @param url         The url of the article
     * @param siteName    The site name of the article
     * @param imageUrl    The url to the card's image placeholder
     * @param title       The title of the article
     * @param description The description of the article
     * @param labels      The label(s) associated with an article
     */
    public String postArticle(String url, String siteName, String imageUrl, String title, String description, ArrayList labels) {
        /* Construct Article Request Body */
        String articleGuid = "";
        try {
            Content content = new Content();

            content.setUrl(url);
            content.setSiteName(siteName);
            content.setImageUrl(imageUrl);
            content.setTitle(title);
            content.setDescription(description);
            content.setLabels(labels);

            /* Make a POST request to content */
            Call<Content> call = seasonedAPI.postArticle(accessToken, content);
            Response<Content> response = call.execute();
            articleGuid = response.body().getGuid();
            System.out.println("POST request to " + getRequestUrl(call.request()) + "\nStatus code: " + response.code());
        } catch (Exception e) {
            System.out.println("POST request to /content/article" + " failed with error: \n" + e.getLocalizedMessage());
        }
        return articleGuid;
    }

    /**
     * Set article status to 'Published'
     *
     * @param guid        The guid of the article to be published
     * @param url         The url of the article
     * @param siteName    The site name of the article
     * @param imageUrl    The url to the card's image placeholder
     * @param description The description of the article
     * @param title       The title of the article
     * @param published   The article's published date
     * @param created     The article's created date
     * @param updated     The article's updated date
     * @param id          The id of the publishing user
     * @param labels      The label(s) associated with an article
     */
    public void updateArticlePublishedStatus(String guid, String url, String siteName, String imageUrl, String title, String description, Long published, Long created, Long updated, String id, ArrayList labels) {
        /* Construct Job Request Body */
        try {
            UploadedBy uploadedBy = new UploadedBy();
            Content content = new Content();

            uploadedBy.setId(id);
            content.setUrl(url);
            content.setSiteName(siteName);
            content.setImageUrl(imageUrl);
            content.setTitle(title);
            content.setDescription(description);
            content.setLabels(labels);
            content.setGuid(guid);
            content.setUploadedBy(uploadedBy);
            content.setPublished(published);
            content.setCreated(created);
            content.setUpdated(updated);
            content.setLabels(labels);

            /* Make a PUT request to content */
            Call<Content> call = seasonedAPI.updateArticlePublishedStatus(accessToken, content);
            call.enqueue(new Callback<Content>() {
                @Override
                public void onResponse(Call<Content> call, Response<Content> response) {
                    System.out.println("PUT request to " + getRequestUrl(call.request()) + "\nStatus code: " + response.code());
                }

                @Override
                public void onFailure(Call<Content> call, Throwable t) {
                    System.out.println("PUT request to " + getRequestUrl(call.request()) + " failed with error: \n" + t.getLocalizedMessage());
                }
            });
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }
    }

    /**
     * Delete an article
     *
     * @param articleGuid The guid of the user sending the connection request
     */
    public void deleteArticle(String articleGuid) {
        try {
            /* Make a DELETE request to network */
            Call<Content> call = seasonedAPI.deleteArticle(articleGuid, accessToken);
            call.enqueue(new Callback<Content>() {
                @Override
                public void onResponse(Call<Content> call, Response<Content> response) {
                    System.out.println("DELETE request to " + getRequestUrl(call.request()) + "\nStatus code: " + response.code());
                }

                @Override
                public void onFailure(Call<Content> call, Throwable t) {
                    System.out.println("DELETE request to " + getRequestUrl(call.request()) + " failed with error: \n" + t.getLocalizedMessage());
                }
            });
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }
    }

    /**
     * Add HS user to SQS
     *
     * @param email         The user's email
     * @param password      The user's password
     * @param firstName     The user's first name
     * @param lastName      The user's last name
     * @param hsUserId      The HotSchedules user id
     * @param termsAccepted The description of the article
     * @param status        The user's status
     */
    public void postSendUserToSqs(String email, String password, String firstName, String lastName, String hsUserId, Boolean termsAccepted, String status) {
        /* Construct SQS User Request Body */
        try {
            SQS sqs = new SQS();

            sqs.setEmail(email);
            sqs.setPassword(password);
            sqs.setFirstName(firstName);
            sqs.setLastName(lastName);
            sqs.setHsUserId(hsUserId);
            sqs.setTermsAccepted(termsAccepted);
            sqs.setStatus(status);

            /* Make a POST request to test/sqs/user */
            Call<SQS> call = seasonedAPI.sendHSUserToSqs(accessToken, sqs);
            call.enqueue(new Callback<SQS>() {
                @Override
                public void onResponse(Call<SQS> call, Response<SQS> response) {
                    System.out.println("POST request to " + getRequestUrl(call.request()) + "\nStatus code: " + response.code());
                }

                @Override
                public void onFailure(Call<SQS> call, Throwable t) {
                    System.out.println("POST request to " + getRequestUrl(call.request()) + " failed with error: \n" + t.getLocalizedMessage());
                }
            });
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }
    }

    /**
     * Posts a connection request from user a to user b
     *
     * @param guid The task scheduler guid
     */
    public void postRunTask(String guid) {
        try {
            /* Make a POST request to task runner */
            Call<SQS> call = seasonedAPI.runTask(guid, accessToken);
            call.enqueue(new Callback<SQS>() {
                @Override
                public void onResponse(Call<SQS> call, Response<SQS> response) {
                    System.out.println("POST request to " + getRequestUrl(call.request()) + "\nStatus code: " + response.code());
                }

                @Override
                public void onFailure(Call<SQS> call, Throwable t) {
                    System.out.println("POST request to " + getRequestUrl(call.request()) + " failed with error: \n" + t.getLocalizedMessage());
                }
            });
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }
    }

    /**
     * Update talent status
     *
     * @param adminUserGuid  the admin's user guid
     * @param employerGuid   the employer's guid
     * @param talentUserGuid the talent's user guid
     * @param talentStatus   the talent's status
     */
    public void updateTalentStatus(String adminUserGuid, String employerGuid, String talentUserGuid, String talentStatus) {
        /* Construct Talent Request Body */
        try {
            AdminEmployer adminEmployer = new AdminEmployer();
            adminEmployer.setGuid(adminUserGuid);

            Talent talent = new Talent();
            talent.setAdmin(adminEmployer);
            talent.setUserGuid(talentUserGuid);
            talent.setStatus(talentStatus);

            /* Make a PUT request to update employer talent */
            Call<Talent> call = seasonedAPI.updateTalentStatus(employerGuid, talent, accessToken);
            call.enqueue(new Callback<Talent>() {
                @Override
                public void onResponse(Call<Talent> call, Response<Talent> response) {
                    System.out.println("PUT request to " + getRequestUrl(call.request()) + "\nStatus code: " + response.code());
                }

                @Override
                public void onFailure(Call<Talent> call, Throwable t) {
                    System.out.println("PUT request to " + getRequestUrl(call.request()) + " failed with error: \n" + t.getLocalizedMessage());
                }
            });
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }
    }

    /**
     * Grabs a new oauth token for a user
     *
     * @param email
     * @param password
     * @return
     */
    public String getToken(String email, String password){
        String token = "";
        System.out.println(email);
        System.out.println(password);
        try {
            /* Make a POST request to oauth/token */
            Call<OAuthToken> call = seasonedAPI.getToken("Basic OTlmYTRhMTMtZDhiNC00MzJjLWIwY2ItNjI3YjI5MDVhMWYyOjY1ZTNiZDVjLWY0YTEtNDI1NC05Nzk3LTQ1MzVhY2U5ZjNhZQ==", "application/x-www-form-urlencoded", "password", email, password);
            Response<OAuthToken> response = call.execute();
            token = response.body().getAccess_token();
            System.out.println("POST request to " + getRequestUrl(call.request()) + "\nStatus code: " + response.code());
        } catch (Exception e) {
            System.out.println("POST request to oauth" + "failed with error: \n" + e.getLocalizedMessage());
        }
        System.out.println(token);
        return token ;
    }
}
