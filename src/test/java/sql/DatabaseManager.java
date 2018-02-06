package sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import utils.TestConfig;
public class DatabaseManager {

    /**
     * Connect to the PostgreSQL database
     *
     * @return a Connection object
    */
    public Connection getConnection() throws SQLException {
        Connection c = null;
        try {
            c = DriverManager.getConnection(TestConfig.getQaDatabaseUrl(), TestConfig.getQaDatabaseUsername(), TestConfig.getQaDatabasePassword());
            c.setAutoCommit(false);
            c.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
        } catch (SQLException e) {
            System.out.println("Unable to connect to the PostgreSQL server. Check VPN connection... \n");
            e.printStackTrace();
            System.err.println(e.getClass().getName()+": "+e.getMessage());
            System.exit((0));
        }
        return c;
    }

    public static PreparedStatement prepareStatement(Connection connection, String sql, PreparedStatementSetter setter) throws SQLException {
        PreparedStatement ps = connection.prepareStatement(sql);
        setter.setValues(ps);
        return ps;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        DatabaseManager app = new DatabaseManager();
        app.getConnection();
    }
}
