import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

public class SqlSelects {

    DatabaseManager dbManager = new DatabaseManager();
    Connection connection;
    Statement stmt;
    PreparedStatement pstmt;
    ResultSet rs;
    private String sql;
    private String sqsMessage;
    private String emailField;
    private String employer_guid;
    private String admin_guid;
    private String accountState;

    /**
     * Get the most recently created user from the SQS queue
     *
     * @return SQS message of the most recently created user in the SQS queue
    */
    public String getDeferredUser() throws SQLException, NullPointerException {
        sql = "SELECT message "
                + "from bf_deferred_sqs_message "
                + "order by created desc "
                + "limit 1";
        try {
            connection = dbManager.getConnection();
            stmt = connection.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                sqsMessage = rs.getString("message");
                System.out.println("SQS Message:\n" + TestUtils.toPrettyFormat(sqsMessage));
                }
        } catch (SQLException e) {
            System.out.println("Query failed with SQLException:\n" + sql);
        } catch (NullPointerException npe) {
            System.out.println("Query failed with NullPointerException:\n" + sql);
        }
        return sqsMessage;
    }

    /**
     * Get employer jobs
     *
     * @param employerGuid The owner guid of the employer's jobs
     * @return List of the employer's job guids
     */
    public List<String> getJobsByEmployer(String employerGuid) throws SQLException {
        List<String> jobGuids = new ArrayList<>();
        sql = "SELECT guid "
                + "from bf_job_posting "
                + "where owner_guid = ? ";
        try {
            connection = dbManager.getConnection();
            pstmt = dbManager.prepareStatement(connection, sql, ps -> ps.setString(1, employerGuid));
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                jobGuids.add(rs.getString("guid"));
            }
            System.out.println("Job guid list: " + jobGuids);
        } catch (SQLException e) {
            System.out.println("Query failed:\n" + sql);
            e.printStackTrace();
        }

        return jobGuids;
    }

    /**
     * Find user by email
     *
     * @param email The user's email
     * @return User's email address
     */
    public String getUserByEmail(String email) throws SQLException, NullPointerException {
        sql = "SELECT email "
                + "from bf_user "
                + "where email = ?";
        try {
            connection = dbManager.getConnection();
            pstmt = dbManager.prepareStatement(connection, sql, ps -> ps.setString(1, email));
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                emailField = rs.getString("email");
                System.out.println("Email: " + emailField);
            }
        } catch (SQLException e){
            System.out.println("Query failed with SQLException:\n" + sql);
        } catch (NullPointerException npe) {
            System.out.println("Query failed with NullPointerException:\n" + sql);
        }
        return emailField;
    }

    /**
     * Find user work history by guid
     *
     * @param userGuid The user's guid
     * @return User's work history
     */
    public List<String> getUserWorkHistoryByGuid(String userGuid) throws SQLException {
        List<String> workHistoryGuids  = new ArrayList<>();
        sql = "SELECT guid "
                + "from bf_user_workhistory "
                + "where user_guid = ?";
        try {
            connection = dbManager.getConnection();
            pstmt = dbManager.prepareStatement(connection, sql, ps -> ps.setString(1, userGuid));
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                workHistoryGuids.add(rs.getString("guid"));
            }
            System.out.println("Work history list: " + workHistoryGuids);
        } catch (SQLException e) {
            System.out.println("Query failed:\n" + sql);
            e.printStackTrace();
        }
        return workHistoryGuids;
    }

    /**
     * Get employer photos
     *
     * @param employerGuid The owner guid of the employer photos
     * @return The employer's photos
     */
    public List<String> getPhotosByEmployer(String employerGuid) throws SQLException {
        List<String> photoGuids = new ArrayList<>();
        sql = "SELECT guid "
                + "from bf_photo "
                + "where phototype_name in ('GooglePlacesPhoto', 'EmployerAdditionalPhoto') "
                + "and owner_guid = ?";

        try {
             connection = dbManager.getConnection();
             pstmt = dbManager.prepareStatement(connection, sql, ps -> ps.setString(1, employerGuid));
             ResultSet rs = pstmt.executeQuery();
             while (rs.next()) {
                 photoGuids.add(rs.getString("guid"));
            }
            System.out.println("Photo guid list: " + photoGuids);
        } catch (SQLException e) {
            System.out.println("Query failed:\n" + sql);
            e.printStackTrace();
        }
        return photoGuids;
    }

    /**
     * Get employer admins by employer
     *
     * @param employer The name of the employer
     * @return Employer guid and user guid
     */
    public List<String> getEmployerAdmins(String employer) throws SQLException {
        List<String> guids = new ArrayList<>();
        sql = "SELECT employer_guid, guid "
                + "from bf_employer_admin  "
                + "where employer_guid in ("
                    + "select guid "
                    + "from bf_employer "
                    + "where name = ?)";
        try {
            connection = dbManager.getConnection();
            pstmt = dbManager.prepareStatement(connection, sql, ps -> ps.setString(1, employer));
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                employer_guid = rs.getString("employer_guid");
                admin_guid = rs.getString("guid");
                guids.add(new String(employer_guid));
                guids.add(new String (admin_guid));
            }
            System.out.println("Admin guid list: " + guids);
        } catch (SQLException e) {
            System.out.println("Query failed:\n" + sql);
            e.printStackTrace();
        }
        return guids;
    }

    /**
     * Get user's account state by email
     *
     * @param email The user's email
     * @return a Connection object
     */
    public String getUserAccountState(String email) throws SQLException {
        sql = "SELECT account_state "
                + "from bf_user  "
                + "where email = ?";
        try {
            connection = dbManager.getConnection();
            pstmt = dbManager.prepareStatement(connection, sql, ps -> ps.setString(1, email));
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                accountState = rs.getString("account_state");
                System.out.println("Account state: " + accountState);
            }
        } catch (SQLException e) {
            System.out.println("Query failed:\n" + sql);
            e.printStackTrace();
        }
        return accountState;
    }

    /**
     * Get user's not connected to current user
     * @param fromUserGuid The user initiating the connection request
     * @param toUserGuid The user receiving the connection request
     * @return User's not connected to the current user
     */
    public List<String>  getNonConnectedUsers(String fromUserGuid, String toUserGuid) throws SQLException {
        List<String> guids = new ArrayList<>();
        sql = "select guid " +
                "from bf_user " +
                "where guid not in (" +
                    "select to_user_guid " +
                    "from bf_user_network " +
                    "where from_user_guid = ?" +
                ") and " +
                "guid not in (" +
                    "select from_user_guid " +
                    "from bf_user_network " +
                    "where to_user_guid = ?" +
                ") and " +
                "guid != ? " +
                "order by firstname desc";

        try {
            connection = dbManager.getConnection();
            pstmt = connection.prepareStatement(sql);
            {
                pstmt.setString(1, fromUserGuid);
                pstmt.setString(2, toUserGuid);
                pstmt.setString(3, fromUserGuid);
                ResultSet rs = pstmt.executeQuery();
                while (rs.next()) {
                    guids.add(rs.getString("guid"));
                }
                System.out.println("Non-connected users: " + guids);
            }
        } catch (SQLException e) {
            System.out.println("Query failed:\n" + sql);
            e.printStackTrace();
        }
        return guids;
    }

    /**
     * Get user's with a pending network connection request from a given user
     * @param fromUserGuid The user initiating the connection request
     * @return a User's with a pending connection request from a given user
     */
    public List<String>  getUsersWithPendingConnectionFrom(String fromUserGuid) throws SQLException {
        List<String> guids = new ArrayList<>();
        dbManager = new DatabaseManager();
        sql = "select guid " +
                     "from bf_user " +
                     "where guid "  +
                     "in (" +
                         "select to_user_guid " +
                         "from bf_user_network " +
                         "where from_user_guid = ? " +
                         "and status = 0" +
                         ")";
        try {
            connection = dbManager.getConnection();
            pstmt = dbManager.prepareStatement(connection, sql, ps -> ps.setString(1, fromUserGuid));
            {
                ResultSet rs = pstmt.executeQuery();
                while (rs.next()) {
                    guids.add(rs.getString("guid"));
                }
                System.out.println("List: " + guids);
            }
        } catch (SQLException e) {
            System.out.println("Query failed:\n" + sql);
            e.printStackTrace();
        }
        return guids;
    }

    /**
     * Get employer staff members
     *
     * @param employerGuid The guid of the employer
     * @return List of the employer staff members
     */
    public List<String> getEmployerStaffMembers(String employerGuid) throws SQLException, NullPointerException {
        List<String> staffGuids = new ArrayList<>();
        sql = "SELECT guid "
                + "from bf_employer_staff_member "
                + "where employer_guid = ?";
        try {
            connection = dbManager.getConnection();
            pstmt = dbManager.prepareStatement(connection, sql, ps -> ps.setString(1, employerGuid));
            {
                ResultSet rs = pstmt.executeQuery();
                while (rs.next()) {
                    staffGuids.add(rs.getString("guid"));
                    System.out.println("Staff guids: " + staffGuids);
                }
            }
        } catch (SQLException e) {
            System.out.println("Query failed due to SQLException...\n" + sql);
            e.printStackTrace();
        } catch (NullPointerException npe) {
            System.out.println("Query failed due to NullPointerException...\n" + sql);
            npe.printStackTrace();
        }
        return staffGuids;
    }
}
